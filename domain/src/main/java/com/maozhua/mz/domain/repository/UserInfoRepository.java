package com.maozhua.mz.domain.repository;

import com.maozhua.mz.domain.UserInfoModel;

public interface UserInfoRepository {

    UserInfoModel findByOpenid(String openid);

    Boolean create(UserInfoModel userInfoModel);

    Boolean updateByOpenid(UserInfoModel userInfoModel);
}
