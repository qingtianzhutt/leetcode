package com.example.demo.service;

import com.example.demo.vo.TbTranlateResult;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TranslateTest {
    @Autowired
    private UserMapper userMapper;


    public List<TbTranlateResult> selectByContidion(){
        TbTranlateResult tbTranlateResult=new TbTranlateResult();
        tbTranlateResult.setSourceText("{\"key1\":\"钥匙\",\"key2\":\"文件\"}");
        tbTranlateResult.setTargetLanguage("en");
        return userMapper.selectByContidion(tbTranlateResult);
    }
}
