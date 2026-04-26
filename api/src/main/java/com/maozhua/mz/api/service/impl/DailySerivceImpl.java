package com.maozhua.mz.api.service.impl;

import com.maozhua.mz.api.dto.DailyDto;
import com.maozhua.mz.api.service.DailyService;
import com.maozhua.mz.common.PageInfo;
import com.maozhua.mz.domain.repository.DailyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DailySerivceImpl implements DailyService {


    @Autowired
    private DailyRepository dailyRepository;

    @Override
    public PageInfo<DailyDto> detailList(DailyDto request) {
        return null;
    }
}
