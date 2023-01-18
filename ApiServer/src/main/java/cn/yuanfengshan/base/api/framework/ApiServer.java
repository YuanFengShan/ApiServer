package cn.yuanfengshan.base.api.framework;

import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class ApiServer {


    private ApiServer() {

    }

    private static class Helper {

        private static final ApiServer instance = new ApiServer();
    }

    public static ApiServer getInstance() {
        return Helper.instance;
    }

    /**
     * 存储API类与注解关系的集合
     */
    private static final Map<Class, String> sAnnoNameMap = new ConcurrentHashMap();
    /**
     * 存储已经初始化过的API实现类
     */
    private final Map<Class<?>, Object> serverMap = new HashMap();


    public static final <T extends IApi> T getServer(Class<T> serverClass) {
        if (!serverClass.isInterface()) {
            throw new IllegalArgumentException("Only accept interface: " + serverClass);
        } else {

            ApiServer apiServer = getInstance();
            try {
                synchronized (apiServer.serverMap) {
                    //在服务集合中取对应的服务API
                    Object var2 = apiServer.serverMap.get(serverClass);
                    if (var2 != null) {
                        return (T) var2;
                    }

                    //使用注解生成API
                    String serverImplClassName = reflectClassName(serverClass);
                    if (TextUtils.isEmpty(serverImplClassName)) {
                        throw new IllegalArgumentException("服务API的实现类为空: " + serverClass);
                    } else {
                        Class<?> aClass = Class.forName(serverImplClassName);
                        if (serverClass.isAssignableFrom(aClass)) {
                            var2 = (T) aClass.newInstance();
                            apiServer.serverMap.put(serverClass, var2);
                        } else {
                            throw new IllegalArgumentException("服务API的实现类与服务API不是继承关系: " + serverClass);
                        }

                    }
                    return (T) var2;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    /**
     * 通过反射获取服务类中注解的内容
     *
     * @param cls
     * @return
     */
    private static String reflectClassName(Class cls) {
        try {
            if (sAnnoNameMap.containsKey(cls)) {
                return sAnnoNameMap.get(cls);
            }
            ImplApi implApi = (ImplApi) cls.getAnnotation(ImplApi.class);
            String str = "";
            if (!TextUtils.isEmpty(implApi.name())) {
                str = implApi.name();
            } else if (implApi.clz() != Object.class) {
                str = implApi.clz().getCanonicalName();
            }
            sAnnoNameMap.put(cls, str);
            return str;
        } catch (Throwable unused) {
            return null;
        }
    }

}
