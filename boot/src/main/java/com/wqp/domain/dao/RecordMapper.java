package com.wqp.domain.dao;

import com.wqp.domain.config.TableShard;
import com.wqp.domain.entity.Record;
import com.wqp.domain.service.impl.MonthTableShardStrategy;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: record mapper
 * @Author Wang QiuPeng
 * @Date 2019-06-05 11:47
 */

@TableShard(tableName = "tb_record", shardStrategy = MonthTableShardStrategy.class)
@Mapper
public interface RecordMapper {
    @Insert("INSERT INTO tb_record(logs) VALUES(#{record.logs})")
    int addRecord(@Param("record")Record record);
}
