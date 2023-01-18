package cn.yuanfengshan.base.api.framework;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ImplApi {
    Class<?> clz() default Object.class;

    Class<?> defaultClz() default Object.class;

    String name() default "";

}
