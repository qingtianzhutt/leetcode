package com.example.mapper;

import com.example.demo.vo.TbTranlateResult;
import com.example.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "UserMapper")
@Mapper
public interface UserMapper {

    /**
     * 获取所有的UserId和openUserId对应关系
     */
    List<UserInfo> getUserInfo();

    /**
     * 获取所有的UserId和openUserId对应关系
     */
    List<String> getAllOpenUserId();

    List<TbTranlateResult> selectByContidion(TbTranlateResult tbTranlateResult);
}
