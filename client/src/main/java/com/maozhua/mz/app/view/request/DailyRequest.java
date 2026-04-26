package com.maozhua.mz.app.view.request;

import com.maozhua.mz.common.PageInfo;

import lombok.Data;

@Data
public class DailyRequest {
    private Integer pageNo;
    private Integer pageSize;
    private Long startTime;
    private Long endTime;
    private PageInfo<?> pageInfo = PageInfo.defaultPageInfo();
}
