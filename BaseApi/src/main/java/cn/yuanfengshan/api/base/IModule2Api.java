package cn.yuanfengshan.api.base;

import cn.yuanfengshan.base.api.framework.ApiServer;
import cn.yuanfengshan.base.api.framework.IApi;
import cn.yuanfengshan.base.api.framework.ImplApi;

@ImplApi(name = "cn.yuanfengshan.module2.Module2ApiImpl")
public interface IModule2Api extends IApi<IModule2Api> {

    String getHelloWordString();


    public static IModule2Api getServer() {
        return ApiServer.getServer(IModule2Api.class);
    }
}
