package com.maozhua.mz.api.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maozhua.mz.api.dto.UserInfoDto;
import com.maozhua.mz.api.service.UserInfoService;
import com.maozhua.mz.domain.UserInfoModel;
import com.maozhua.mz.domain.repository.UserInfoRepository;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfoDto getByOpenid(String openid) {
        UserInfoModel userInfoModel = userInfoRepository.findByOpenid(openid);
        if (userInfoModel == null) {
            return null;
        }

        UserInfoDto dto = new UserInfoDto();
        BeanUtils.copyProperties(userInfoModel, dto);
        return dto;
    }

    @Override
    public UserInfoDto create(UserInfoDto request) {
        if (request == null || request.getOpenid() == null || request.getOpenid().trim().isEmpty()) {
            return null;
        }

        UserInfoModel existModel = userInfoRepository.findByOpenid(request.getOpenid().trim());
        if (existModel != null) {
            UserInfoDto existDto = new UserInfoDto();
            BeanUtils.copyProperties(existModel, existDto);
            return existDto;
        }

        long now = System.currentTimeMillis() / 1000;
        UserInfoModel createModel = new UserInfoModel();
        BeanUtils.copyProperties(request, createModel);
        createModel.setOpenid(request.getOpenid().trim());
        createModel.setCreateTime(now);
        createModel.setUpdateTime(now);
        if (createModel.getStatus() == null) {
            createModel.setStatus(1);
        }

        Boolean created = userInfoRepository.create(createModel);
        if (Boolean.FALSE.equals(created)) {
            return null;
        }

        UserInfoDto dto = new UserInfoDto();
        BeanUtils.copyProperties(createModel, dto);
        return dto;
    }

    @Override
    public UserInfoDto updateByOpenid(UserInfoDto request) {
        if (request == null || request.getOpenid() == null || request.getOpenid().trim().isEmpty()) {
            return null;
        }

        String openid = request.getOpenid().trim();
        UserInfoModel existModel = userInfoRepository.findByOpenid(openid);
        if (existModel == null) {
            return null;
        }

        UserInfoModel updateModel = new UserInfoModel();
        BeanUtils.copyProperties(request, updateModel);
        updateModel.setOpenid(openid);
        updateModel.setUpdateTime(System.currentTimeMillis() / 1000);

        Boolean updated = userInfoRepository.updateByOpenid(updateModel);
        if (Boolean.FALSE.equals(updated)) {
            return null;
        }

        UserInfoModel latest = userInfoRepository.findByOpenid(openid);
        if (latest == null) {
            return null;
        }

        UserInfoDto dto = new UserInfoDto();
        BeanUtils.copyProperties(latest, dto);
        return dto;
    }
}
