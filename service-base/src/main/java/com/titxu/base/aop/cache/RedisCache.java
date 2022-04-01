package com.titxu.base.aop.cache;


import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import com.titxu.common.exception.BusinessException;
import com.titxu.common.result.ResponseEnum;
import com.titxu.common.utils.MD5;
import com.titxu.base.aop.BaseAspectSupport;
import com.titxu.base.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * 缓存查询
 */
@Aspect
@Slf4j
@Component
public class RedisCache extends BaseAspectSupport {

    private RedisUtils redisUtils;

    public RedisCache(RedisUtils redisUtils) {
        this.redisUtils = redisUtils;
    }

    // 定义切面
    @Pointcut("@annotation(com.titxu.base.aop.cache.Cacheable)")
    public void cache() {
    }

    // 环绕通知
    @Around("cache()")
    public Object doAround(ProceedingJoinPoint pjp) {
        Object result = null;
        try {
            //记录时间定时器
            TimeInterval timer = DateUtil.timer(true);


            Method method = resolveMethod(pjp);
            Cacheable cacheable = method.getAnnotation(Cacheable.class);
            String preKey = MD5.encrypt(method.toString());
            String key = preKey + ":" + cacheable.key();
            result = redisUtils.getCacheObject(key);
            if (result == null) {
                // 执行方法
                result = pjp.proceed();
                // 放入缓存
                log.info("缓存增加：{}", key);

                redisUtils.setCacheObject(key, result, cacheable.expire(), TimeUnit.SECONDS);
            }
            //执行消耗时间
            String endTime = timer.intervalPretty();
            log.info("缓存查询：{}，耗时：{}", key, endTime);
        } catch (Throwable e) {
            log.error("缓存查询异常", e);
            throw new BusinessException(ResponseEnum.REDIS_CACHE_ERROR);
        }
        return result;
    }


    /**
     * 根据方法和传入的参数获取请求参数
     */
    private Object getParameter(Method method, Object[] args) {
        List<Object> argList = new ArrayList<>();
        Parameter[] parameters = method.getParameters();
        Map<String, Object> map = new HashMap<>();
        for (int i = 0; i < parameters.length; i++) {
            //将RequestBody注解修饰的参数作为请求参数
            RequestBody requestBody = parameters[i].getAnnotation(RequestBody.class);
            //将RequestParam注解修饰的参数作为请求参数
            RequestParam requestParam = parameters[i].getAnnotation(RequestParam.class);
            String key = parameters[i].getName();
            if (requestBody != null) {
                argList.add(args[i]);
            } else if (requestParam != null) {
                map.put(key, args[i]);
            } else {
                map.put(key, args[i]);
            }
        }
        if (map.size() > 0) {
            argList.add(map);
        }
        if (argList.size() == 0) {
            return null;
        } else if (argList.size() == 1) {
            return argList.get(0);
        } else {
            return argList;
        }
    }


}
