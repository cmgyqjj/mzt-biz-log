package com.mzt.logapi.service.impl;


import com.mzt.logapi.service.IParseFunction;

/**
 * @author muzhantong
 * create on 2021/2/6 9:58 上午
 */
public class DefaultParseFunction implements IParseFunction {

//    默认执行前返回true
    @Override
    public boolean executeBefore() {
        return true;
    }

//    默认函数名为空
    @Override
    public String functionName() {
        return null;
    }

//    默认返回null
    @Override
    public String apply(Object value) {
        return null;
    }
}
