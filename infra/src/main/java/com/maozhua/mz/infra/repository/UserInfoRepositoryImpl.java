package com.maozhua.mz.infra.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.maozhua.mz.domain.UserInfoModel;
import com.maozhua.mz.domain.repository.UserInfoRepository;
import com.maozhua.mz.infra.mapper.UserInfoMapper;

@Repository
public class UserInfoRepositoryImpl implements UserInfoRepository {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfoModel findByOpenid(String openid) {
        return userInfoMapper.findByOpenid(openid);
    }

    @Override
    public Boolean create(UserInfoModel userInfoModel) {
        return userInfoMapper.create(userInfoModel) > 0;
    }

    @Override
    public Boolean updateByOpenid(UserInfoModel userInfoModel) {
        return userInfoMapper.updateByOpenid(userInfoModel) > 0;
    }
}
