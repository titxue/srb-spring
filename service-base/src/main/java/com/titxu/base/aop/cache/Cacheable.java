package com.titxu.base.aop.cache;


import java.lang.annotation.*;

/**
 * 缓存查询
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Cacheable {

    /**
     * 缓存key
     */
    String key();

    /**
     * 缓存过期时间 //单位秒
     * 默认为86400，表示一天
     */
    long expire() default 86400;
}
