package com.wqp.shardingjdbcdemo.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @Description:
 * @Author Wang QiuPeng
 * @Date 2019-06-03 14:20
 */
public class OrderRequest {
    private Integer userId;
    private String startTime;
    private String endTime;
    private Long start;
    private Long end;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Long getEnd() {
        return end;
    }

    public void setEnd(Long end) {
        this.end = end;
    }
}
