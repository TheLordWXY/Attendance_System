package com.example.AttendanceSystemServer.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
        name = "annual_leave"
)
public class annual_leave {
    @Id
    @Column(
            name = "staff_id"
    )
    private int staff_id;
    @Column(
            name = "type"
    )
    private String type;
    @Column(
            name = "duration"
    )
    private int duration;
    @Column(
            name = "wages"
    )
    private int wages;

    public annual_leave() {
    }

    public annual_leave(staff s) {
        this.setType("annual");
        this.setWages(0);
        int join_year = s.getJoin_year();
        if (join_year < 1 & join_year >= 0) {
            this.setDuration(0);
        } else if (join_year < 10) {
            this.setDuration(5);
        } else if (join_year < 20) {
            this.setDuration(10);
        } else if (join_year >= 20) {
            this.setDuration(15);
        }

        this.staff_id = s.getStaff_id();
    }

    public int getStaff_id() {
        return this.staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getWages() {
        return this.wages;
    }

    public void setWages(int wages) {
        this.wages = wages;
    }
}
