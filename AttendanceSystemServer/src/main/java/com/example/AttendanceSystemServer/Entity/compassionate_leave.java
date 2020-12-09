package com.example.AttendanceSystemServer.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "compassionate_leave")
public class compassionate_leave {
    @Id
    @Column(name = "staff_id")
    private int staff_id;

    @Column(name = "type")
    private String type;

    @Column(name = "duration")
    private int duration;

    @Column(name = "wages")
    private int wages;

    @Column(name = "month")
    private int month;

    public compassionate_leave(){
    }

    public compassionate_leave(staff s){
        this.setType("compassionate");
        this.setWages(-100);
        this.setDuration(0);
        this.setStaff_id(s.getStaff_id());
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getWages() {
        return wages;
    }

    public void setWages(int wages) {
        this.wages = wages;
    }
}
