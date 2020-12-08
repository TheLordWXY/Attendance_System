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
        name = "check_record"
)
public class check_record {
    @Id
    @Column(
            name = "check_record_id"
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private int check_record_id;
    @Column(
            name = "checkman_id"
    )
    private int checkman_id;
    @Column(
            name = "check_time"
    )
    private Date check_time;

    public check_record() {
    }

    public int getCheckman_id() {
        return this.checkman_id;
    }

    public void setCheckman_id(int checkman_id) {
        this.checkman_id = checkman_id;
    }

    public Date getCheck_time() {
        return this.check_time;
    }

    public void setCheck_time(Date check_time) {
        this.check_time = check_time;
    }
}

