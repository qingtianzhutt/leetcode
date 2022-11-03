package com.example.demo.Controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.bean.MicroServiceUrl;
import com.example.demo.service.TranslateTest;
import com.example.demo.vo.TbTranlateResult;
import com.example.entity.UserInfo;
import com.example.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.constant.MQConstants.DMSS_DELETE_REL_FROMB_EXCHANGE_NAME;
import static com.example.constant.MQConstants.DMSS_DELETE_REL_FROMB_QUEUEC_ROUTING_KEY;


@RestController
@RequestMapping("tset2")
public class Test2 {

    @Resource
    private MicroServiceUrl microServiceUrl;
    @Resource
    public UserMapper userMapper;
    @Autowired
    private TranslateTest translateTest;

    @Autowired
    RabbitTemplate rabbitTemplate;


    private final static Logger logger = LoggerFactory.getLogger(Test2.class);

    @RequestMapping("/log")
    public String test(){
        logger.info("qintaozhi");

        logger.info("=====获取的订单服务地址为：{}", microServiceUrl.getOrderUrl());
        logger.info("=====获取的用户服务地址为：{}", microServiceUrl.getUserUrl());
        logger.info("=====获取的购物车服务地址为：{}", microServiceUrl.getShoppingUrl());
    Map<String, Object> testmap = new HashMap<>();
    testmap.put("qintaozhi", "qintaozhidg");
    testmap.put("qintaozhi2", "qintaozhidg2");
    testmap.put("qintaozhi3", "qintaozhidg3");
    rabbitTemplate.convertAndSend(DMSS_DELETE_REL_FROMB_EXCHANGE_NAME, DMSS_DELETE_REL_FROMB_QUEUEC_ROUTING_KEY, testmap);
    logger.info("success");
        return null;
    }


    @RequestMapping("/userMapper")
    public String testUserMapper(){
        logger.info("qintaozhi");

        List<TbTranlateResult> tbTranlateResults = translateTest.selectByContidion();
        System.out.println(tbTranlateResults);


        List<String> res = userMapper.getAllOpenUserId();
        if (res == null){
            System.out.println(11111);
        }else{
            logger.info(JSON.toJSONString(res));
        }
        List<UserInfo> openUserIdList = userMapper.getUserInfo();
        if (openUserIdList == null){
            System.out.println(11111);
        }else{
            logger.info(JSON.toJSONString(openUserIdList));
        }
        logger.info("end");

        return null;
    }

    @GetMapping("sendExpirationMsg/{message}/{ttlTime}")
    public void sendMsg(@PathVariable String message, @PathVariable String ttlTime) {
        rabbitTemplate.convertAndSend("X", "XC", message, correlationData ->
        {correlationData.getMessageProperties().setExpiration(ttlTime);
        return correlationData;
});
        logger.info("当前时间： {},发送一条时长{}毫秒 TTL 信息给队列 C:{}", new Date(),ttlTime, message);
    }

}
