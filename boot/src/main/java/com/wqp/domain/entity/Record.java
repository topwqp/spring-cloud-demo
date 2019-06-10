package com.wqp.domain.entity;

import lombok.*;

/**
 * @Description: record entity
 * @Author Wang QiuPeng
 * @Date 2019-06-05 15:00
 */
@Data
@Builder
@NoArgsConstructor
public class Record {

    private Integer id;

    private String logs;

    private Record(Builder builder) {
        setId(builder.id);
        setLogs(builder.logs);
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
}
