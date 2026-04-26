package com.maozhua.mz.infra.mapper;

import org.apache.ibatis.annotations.Param;

import com.maozhua.mz.domain.UserInfoModel;

public interface UserInfoMapper {

    UserInfoModel findByOpenid(@Param("openid") String openid);

    int create(UserInfoModel userInfoModel);

    int updateByOpenid(UserInfoModel userInfoModel);
}
