package cn.yuanfengshan.module1;

import cn.yuanfengshan.api.base.IModule1Api;

public class Module1ApiImpl implements IModule1Api {
    @Override
    public String getHelloWordString() {
        return "我是module1的方法";
    }
}
