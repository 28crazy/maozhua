package com.maozhua.mz.client.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maozhua.mz.api.dto.UserInfoDto;
import com.maozhua.mz.api.service.UserInfoService;
import com.maozhua.mz.client.base.BaseResponse;
import com.maozhua.mz.client.base.ErrorConst;
import com.maozhua.mz.client.view.UserInfoView;
import com.maozhua.mz.client.view.request.UserInfoCreateOrUpdateRequest;
import com.maozhua.mz.infra.RedisConfig.RedisHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/user/info")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private RedisHandler redisHandler;


    @GetMapping("/get")
    public String get() {
        String key = "user:info:get";
        redisHandler.setString(key, "test_value_maozhua");
        return redisHandler.getString(key);
    }

    @PostMapping("/create")
    public BaseResponse<UserInfoView> create(@RequestBody UserInfoCreateOrUpdateRequest request) {
        log.info("UserInfoController.create request: {}", request);
        if (request == null || request.getOpenid() == null || request.getOpenid().trim().isEmpty()) {
            return BaseResponse.error(ErrorConst.ERROR);
        }
        UserInfoDto dtoRequest = new UserInfoDto();
        BeanUtils.copyProperties(request, dtoRequest);
        dtoRequest.setOpenid(request.getOpenid().trim());

        UserInfoDto dto = userInfoService.create(dtoRequest);
        if (dto == null) {
            return BaseResponse.error(ErrorConst.ERROR);
        }

        UserInfoView view = new UserInfoView();
        BeanUtils.copyProperties(dto, view);
        return BaseResponse.success(view);
    }

    @PostMapping("/update")
    public BaseResponse<UserInfoView> update(@RequestBody UserInfoCreateOrUpdateRequest request) {
        log.info("UserInfoController.update request: {}", request);
        if (request == null || request.getOpenid() == null || request.getOpenid().trim().isEmpty()) {
            return BaseResponse.error(ErrorConst.ERROR);
        }

        UserInfoDto dtoRequest = new UserInfoDto();
        BeanUtils.copyProperties(request, dtoRequest);
        dtoRequest.setOpenid(request.getOpenid().trim());

        UserInfoDto dto = userInfoService.updateByOpenid(dtoRequest);
        if (dto == null) {
            return BaseResponse.error(ErrorConst.ERROR);
        }

        UserInfoView view = new UserInfoView();
        BeanUtils.copyProperties(dto, view);
        return BaseResponse.success(view);
    }
}
