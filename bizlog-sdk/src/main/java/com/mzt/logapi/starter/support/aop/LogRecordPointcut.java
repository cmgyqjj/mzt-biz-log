package com.mzt.logapi.starter.support.aop;

import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * DATE 4:45 PM
 *
 * @author mzt.
 */
public class LogRecordPointcut extends StaticMethodMatcherPointcut implements Serializable {

    // LogRecord的解析类,专门用来解析注解
    private LogRecordOperationSource logRecordOperationSource;

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        // 解析 这个 method 上有没有 @LogRecord 注解
        // 有的话会解析出来注解上的各个参数
        return !CollectionUtils.isEmpty(logRecordOperationSource.computeLogRecordOperations(method, targetClass));
    }

//    初始化方法，这个方法会在spring容器初始化的时候调用
//    BeanFactoryLogRecordAdvisor装配之后，再装配这个解析类设置进去
    void setLogRecordOperationSource(LogRecordOperationSource logRecordOperationSource) {
        this.logRecordOperationSource = logRecordOperationSource;
    }
}