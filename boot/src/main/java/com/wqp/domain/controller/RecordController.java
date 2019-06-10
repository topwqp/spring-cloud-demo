package com.wqp.domain.controller;

import com.wqp.domain.entity.Record;
import com.wqp.domain.service.RecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;



/**
 * @Description: record add controller
 * @Author Wang QiuPeng
 * @Date 2019-06-05 14:24
 */
@RestController
public class RecordController {

    private static final Logger LOG = LoggerFactory.getLogger(RecordController.class);

    @Autowired
    private RecordService recordService;

    @RequestMapping(value = "/addRecord", method = RequestMethod.POST)
    public int addRecord(@RequestBody Record record) {
        LOG.info("add record success");
         return recordService.addRecord(record);
    }


    @RequestMapping(value = "/getRecords", method = RequestMethod.GET)
    public List<Record> getRecords() {
        LOG.info("invoke query request ");
        List<Record> recordList = new ArrayList<>();
        //Record  record = new Record.RecordBuilder().id(1).logs("111").build();
        Record record = new Record.Builder().id(1).logs("addg").build();
        recordList.add(record);
        return recordList;
    }
}
