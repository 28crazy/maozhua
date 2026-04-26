package com.maozhua.mz.api.service;

import com.maozhua.mz.api.dto.DailyDto;
import com.maozhua.mz.common.PageInfo;

public interface DailyService {

    PageInfo<DailyDto> detailList(DailyDto request);

}
