package com.wqp.domain.service.impl;

import com.wqp.domain.dao.RecordMapper;
import com.wqp.domain.entity.Record;
import com.wqp.domain.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: record service impl
 * @Author Wang QiuPeng
 * @Date 2019-06-05 14:21
 */
@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordMapper recordMapper;

    @Override
    public int addRecord(Record record) {
        return   recordMapper.addRecord(record);
    }
}
