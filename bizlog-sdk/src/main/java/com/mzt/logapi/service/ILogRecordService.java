package com.mzt.logapi.service;


import com.mzt.logapi.beans.LogRecord;

import java.util.List;

public interface ILogRecordService {
    /**
     * 保存log
     *
     * @param logRecord 日志实体
     */
    void record(LogRecord logRecord);

    /**
     * @Author: qjj
     * @Description: 依据操作日志类型和业务标识查询日志
     * @Params:
     * @Return
     */
    /**
     * 返回最多100条记录
     *
     * @param type  操作日志类型
     * @param bizNo 操作日志的业务标识，比如：订单号
     * @return 操作日志列表
     */
    List<LogRecord> queryLog(String bizNo, String type);

    /**
     * @Author: qjj
     * @Description: 依据操作日志类型+子类型和业务标识查询日志
     */
    /**
     * 返回最多100条记录
     *
     * @param type    操作日志类型
     * @param subType 操作日志子类型
     * @param bizNo   操作日志的业务标识，比如：订单号
     * @return 操作日志列表
     */
    List<LogRecord> queryLogByBizNo(String bizNo, String type, String subType);
}
