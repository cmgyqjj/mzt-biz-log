package com.mzt.logapi.starter.support.aop;

import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractBeanFactoryPointcutAdvisor;

/**
 * DATE 4:45 PM
 *
 * @author mzt.
 */
/**
*@Param:
*@return:
*@Author: qjj
*@describe: 适配器，来把接口方法和切点资源对接上
 * AbstractBeanFactoryPointcutAdvisor
 * 这里相当于手写spring aop实现，但是实际使用中，我们并不需要去兼容spring1.5版本，直接aop实现就ok了
*/
public class BeanFactoryLogRecordAdvisor extends AbstractBeanFactoryPointcutAdvisor {

    private final LogRecordPointcut pointcut = new LogRecordPointcut();

    @Override
    public Pointcut getPointcut() {
        return pointcut;
    }

    public void setLogRecordOperationSource(LogRecordOperationSource logRecordOperationSource) {
        pointcut.setLogRecordOperationSource(logRecordOperationSource);
    }
}