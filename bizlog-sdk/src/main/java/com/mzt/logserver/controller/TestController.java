package com.mzt.logserver.controller;

import com.mzt.logapi.beans.LogRecord;
import com.mzt.logserver.IOrderService;
import com.mzt.logserver.IUserService;
import com.mzt.logserver.SkuService;
import com.mzt.logserver.UserQueryService;
import com.mzt.logserver.infrastructure.constants.LogRecordType;
import com.mzt.logserver.infrastructure.logrecord.service.DbLogRecordService;
import com.mzt.logserver.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author:qjj
 * @create: 2023-10-20 09:59
 * @Description:
 */
@RequestMapping("/test")
@RestController
@Slf4j
public class TestController {

    @Autowired
    private IOrderService orderService;
    @Autowired
    private SkuService skuService;
    @Autowired
    private UserQueryService userQueryService;
    @Autowired
    private IUserService userService;
    @Resource
    private DbLogRecordService logRecordService;


    @GetMapping("/userQuery")
    public void userQuery(){
        User user = new User();
        user.setId(1L);
        user.setName("张三");
        user.setSex("男");
        user.setAge(18);
        User.Address address = new User.Address();
        address.setProvinceName("湖北省");
        address.setCityName("武汉市");
        user.setAddress(address);

        User newUser = new User();
        newUser.setId(1L);
        newUser.setName("李四");
        newUser.setSex("女");
        newUser.setAge(20);
        User.Address newAddress = new User.Address();
        newAddress.setProvinceName("湖南省");
        newAddress.setCityName("长沙市");
        newUser.setAddress(newAddress);
        userService.diffUser(user, newUser);

        List<LogRecord> logRecordList = logRecordService.queryLog(String.valueOf(user.getId()), LogRecordType.USER);
        Assert.assertEquals(1, logRecordList.size());
        LogRecord logRecord = logRecordList.get(0);
        Assert.assertEquals(logRecord.getAction(), "更新了用户信息【address的cityName】从【武汉市】修改为【长沙市】；【address的provinceName】从【湖北省】修改为【湖南省】；【name】从【张三】修改为【李四】；【性别】从【男333】修改为【女333】");
        Assert.assertNotNull(logRecord.getExtra());
        Assert.assertEquals(logRecord.getOperator(), "111");
        logRecordService.clean();
    }

}
