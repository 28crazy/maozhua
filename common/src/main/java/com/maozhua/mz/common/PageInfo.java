package com.maozhua.mz.common;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class PageInfo<T> {
    private Integer pageNo;
    private Integer pageSize;
    private List<T> list;
    private Long total;


    private static final int DEFAULT_PAGE_NO = 1;
    private static final int DEFAULT_PAGE_SIZE = 10;
    private static final long DEFAULT_TOTAL = 0;

    private PageInfo(Integer pageNo, Integer pageSize, Long total, List<T> list) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.total = total;
        this.list = list;
    }

    public static <T> PageInfo<T> of(Integer pageNo, Integer pageSize, Long total, List<T> list) {
        return new PageInfo<>(pageNo, pageSize, total, list);
    }

    public static <T> PageInfo<T> defaultPageInfo() {
        return new PageInfo<T>(DEFAULT_PAGE_NO, DEFAULT_PAGE_SIZE, DEFAULT_TOTAL, new ArrayList<T>());
    }
}
