package com.wqp.domain.service;

import com.wqp.domain.entity.Record;

/**
 * @Description: record service
 * @Author Wang QiuPeng
 * @Date 2019-06-05 14:21
 */
public interface RecordService {

    /**
     * 添加记录
     * @param record
     */
    int  addRecord(Record record);
}
