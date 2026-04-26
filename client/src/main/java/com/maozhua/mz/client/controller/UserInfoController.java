package com.maozhua.mz.client.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maozhua.mz.api.dto.UserInfoDto;
import com.maozhua.mz.api.service.UserInfoService;
import com.maozhua.mz.client.base.BaseResponse;
import com.maozhua.mz.client.base.ErrorConst;
import com.maozhua.mz.client.view.UserInfoView;
import com.maozhua.mz.client.view.request.UserInfoCreateRequest;
import com.maozhua.mz.client.view.request.UserInfoRequest;
import com.maozhua.mz.client.view.request.UserInfoUpdateRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/user/info")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/get")
    public BaseResponse<UserInfoView> getByOpenid(@RequestBody UserInfoRequest request) {
        log.info("UserInfoController.getByOpenid request: {}", request);
        if (request == null || request.getOpenid() == null || request.getOpenid().trim().isEmpty()) {
            return BaseResponse.error(ErrorConst.ERROR);
        }

        UserInfoDto dto = userInfoService.getByOpenid(request.getOpenid().trim());
        if (dto == null) {
            return BaseResponse.success(null);
        }

        UserInfoView view = new UserInfoView();
        BeanUtils.copyProperties(dto, view);
        return BaseResponse.success(view);
    }

    @PostMapping("/create")
    public BaseResponse<UserInfoView> create(@RequestBody UserInfoCreateRequest request) {
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
    public BaseResponse<UserInfoView> update(@RequestBody UserInfoUpdateRequest request) {
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
