package com.example.AttendanceSystemServer.Entity;

import java.util.Date;

public class leave_apply {
    private Date start_time;
    private Date end_time;
    private int leaveman_id;
    private String type;
    private String reason;
    private String appendix;
    private int duration;

    public leave_apply() {
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration() {
        this.duration = (int)(this.end_time.getTime() - this.start_time.getTime()) / 1000 / 3600 / 24;
    }

    public Date getStart_time() {
        return this.start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return this.end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public int getLeaveman_id() {
        return this.leaveman_id;
    }

    public void setLeaveman_id(int leaveman_id) {
        this.leaveman_id = leaveman_id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getAppendix() {
        return this.appendix;
    }

    public void setAppendix(String appendix) {
        this.appendix = appendix;
    }
}
