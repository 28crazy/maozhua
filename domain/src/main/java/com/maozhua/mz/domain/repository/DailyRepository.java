package com.maozhua.mz.domain.repository;

import com.maozhua.mz.common.PageInfo;
import com.maozhua.mz.domain.DailyModel;

public interface DailyRepository {

    PageInfo<DailyModel> findAll(DailyModel dailyModel);

    DailyModel findById(String id);

    Boolean create(DailyModel dailyModel);

    Boolean update(DailyModel dailyModel);
}
