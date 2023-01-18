package cn.yuanfengshan.module2;

import cn.yuanfengshan.api.base.IModule2Api;

public class Module2ApiImpl implements IModule2Api {
    @Override
    public String getHelloWordString() {
        return "我是module 2 的方法";
    }
}
