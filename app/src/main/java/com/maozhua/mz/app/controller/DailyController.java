package com.maozhua.mz.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maozhua.mz.api.service.DailyService;
import com.maozhua.mz.app.base.BaseResponse;
import com.maozhua.mz.app.view.DailyView;
import com.maozhua.mz.app.view.request.DailyRequest;
import com.maozhua.mz.common.PageInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/daily")
public class DailyController {

    @Autowired
    private DailyService dailyService;

    @PostMapping("/detail/list")
    public BaseResponse<PageInfo<DailyView>> detailList(@RequestBody DailyRequest request) {
        log.info("DailyController.detailList request: {}", request);
        dailyService.detailList(null);
        return BaseResponse.success(PageInfo.defaultPageInfo());
    }
}
