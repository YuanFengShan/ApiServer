# ApiServer
将业务抽离成公用服务层的一个工具类，解决项目模块化之间的调用

创建这个项目的初衷是只想解决这个小问题，但是市面上其他框架很大，此功能只是一个附属，但是我仅仅只需要这个功能。所以创建了这个项目，不依赖gradler的版本，维护成本很低。





## 快速使用



### 引用

在base层中引用项目，需要让所有模块都可以使用到

```
api 'io.github.yuanfengshan:ApiServer:1.0.0'
```

对于不继承base的项目单独使用

```
compileOnly 'io.github.yuanfengshan:ApiServer:1.0.0'
```



### 定义api接口

1. 定义一个接口
2. 继承IApi
3. 将iApi的泛型设置为当前定义的接口
4. 设置注解（注解的值是具体的实现类）
5. 调用的地方按照getServer方法的方式就可以获取到接口并调用





```java
@ImplApi(name = "cn.yuanfengshan.module1.Module1ApiImpl")
public interface IModule1Api extends IApi<IModule1Api> {

    String getHelloWordString();

    public static IModule1Api getServer() {
        return ApiServer.getServer(IModule1Api.class);
    }
}
```



### 实现api接口

在任何一个子模块都可以实现定义的api接口，但是要注意名字和路径要与注解中的保持一致，并且只能有一个，不可再多个模块中重复实现



### 调用方法

可以在api定义接口中直接定义对应的方法

```
String helloWordString = IModule1Api.getServer().getHelloWordString();
```

或者直接使用原始的方法

```
ApiServer.getServer(IModule1Api.class).getHelloWordString();
```

