package com.maozhua.mz.api.service;

import com.maozhua.mz.api.dto.UserInfoDto;

public interface UserInfoService {

    UserInfoDto getByOpenid(String openid);

    UserInfoDto create(UserInfoDto request);

    UserInfoDto updateByOpenid(UserInfoDto request);
}
