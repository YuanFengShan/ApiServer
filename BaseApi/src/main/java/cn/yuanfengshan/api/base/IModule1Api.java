package cn.yuanfengshan.api.base;

import cn.yuanfengshan.base.api.framework.ApiServer;
import cn.yuanfengshan.base.api.framework.IApi;
import cn.yuanfengshan.base.api.framework.ImplApi;

@ImplApi(name = "cn.yuanfengshan.module1.Module1ApiImpl")
public interface IModule1Api extends IApi<IModule1Api> {

    String getHelloWordString();

    public static IModule1Api getServer() {
        return ApiServer.getServer(IModule1Api.class);
    }
}
