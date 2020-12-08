package com.example.AttendanceSystemServer.Entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
        name = "leave_record"
)
public class leave_record {
    @Id
    @Column(
            name = "leave_record_id"
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private int leave_record_id;
    @Column(
            name = "start_time"
    )
    private Date start_time;
    @Column(
            name = "end_time"
    )
    private Date end_time;
    @Column(
            name = "leaveman_id"
    )
    private int leaveman_id;
    @Column(
            name = "type"
    )
    private String type;
    @Column(
            name = "reason"
    )
    private String reason;
    @Column(
            name = "appendix"
    )
    private String appendix;
    @Column(
            name = "record_state"
    )
    private String record_state;
    @Column(
            name = "duration"
    )
    private int duration;

    public leave_record(leave_apply la) {
        this.start_time = la.getStart_time();
        this.end_time = la.getEnd_time();
        this.leaveman_id = la.getLeaveman_id();
        this.type = la.getType();
        this.reason = la.getReason();
        this.appendix = la.getAppendix();
        this.duration = la.getDuration();
        this.record_state = "reviewing";
    }

    public int getLeave_record_id() {
        return this.leave_record_id;
    }

    public void setLeave_record_id(int leave_record_id) {
        this.leave_record_id = leave_record_id;
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

    public String getRecord_state() {
        return this.record_state;
    }

    public void setRecord_state(String record_state) {
        this.record_state = record_state;
    }
}
