package com.maozhua.mz.domain;

import lombok.Data;
import java.util.List;

import com.maozhua.mz.common.PageInfo;

@Data
public class DailyModel {
    private String id;
    private String title;
    private String content;
    private String subtitle;
    private Long publicationDate;
    private List<String> imageList;
    private PageInfo<DailyModel> pageInfo = PageInfo.defaultPageInfo();
}
