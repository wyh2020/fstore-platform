package com.wyh2020.fstore.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface Identity {
    /**
     * 是否需要所在店铺编号 默认是需要
     * @return
     */
    boolean shopRequire() default true;
}
