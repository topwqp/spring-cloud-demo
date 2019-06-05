package com.wqp.domain.entity;

/**
 * @Description: record entity
 * @Author Wang QiuPeng
 * @Date 2019-06-05 15:00
 */
public class Record {

    private Integer id;

    private String logs;

    private Record(Builder builder) {
        setId(builder.id);
        setLogs(builder.logs);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogs() {
        return logs;
    }

    public void setLogs(String logs) {
        this.logs = logs;
    }


    public static final class Builder {
        private Integer id;
        private String logs;

        public Builder() {
        }

        public Builder id(Integer val) {
            id = val;
            return this;
        }

        public Builder logs(String val) {
            logs = val;
            return this;
        }

        public Record build() {
            return new Record(this);
        }
    }

    public Record() {
    }
}
