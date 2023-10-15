package com.mzt.logapi.service.impl;

import com.mzt.logapi.service.IParseFunction;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author muzhantong
 * create on 2021/2/6 9:45 上午
 */

public class ParseFunctionFactory {
    private Map<String, IParseFunction> allFunctionMap;

    /**
     * @Author: qjj
     * @Description: 把传入的接口实现都里面的东西都放到map里面
     */
    public ParseFunctionFactory(List<IParseFunction> parseFunctions) {
        if (CollectionUtils.isEmpty(parseFunctions)) {
            return;
        }
        allFunctionMap = new HashMap<>();
        for (IParseFunction parseFunction : parseFunctions) {
            if (StringUtils.isEmpty(parseFunction.functionName())) {
                continue;
            }
            allFunctionMap.put(parseFunction.functionName(), parseFunction);
        }
    }

//    根据函数名获取函数
    public IParseFunction getFunction(String functionName) {
        return allFunctionMap.get(functionName);
    }

//    判断是否在还在函数执行之前
    public boolean isBeforeFunction(String functionName) {
        return allFunctionMap.get(functionName) != null && allFunctionMap.get(functionName).executeBefore();
    }
}
