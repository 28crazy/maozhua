package com.maozhua.mz.infra.repository;

import org.springframework.stereotype.Repository;

import com.maozhua.mz.domain.repository.DailyRepository;

@Repository
public class DailyRepositoryImpl implements DailyRepository {

    @Override
    public com.maozhua.mz.common.PageInfo<com.maozhua.mz.domain.DailyModel> findAll(com.maozhua.mz.domain.DailyModel dailyModel) {
        // TODO: 实现查询全部日常记录的逻辑
        return null;
    }

    @Override
    public com.maozhua.mz.domain.DailyModel findById(String id) {
        // TODO: 实现根据ID查询日常记录的逻辑
        return null;
    }

    @Override
    public Boolean create(com.maozhua.mz.domain.DailyModel dailyModel) {
        // TODO: 实现创建日常记录的逻辑
        return null;
    }

    @Override
    public Boolean update(com.maozhua.mz.domain.DailyModel dailyModel) {
        // TODO: 实现更新日常记录的逻辑
        return null;
    }
}
