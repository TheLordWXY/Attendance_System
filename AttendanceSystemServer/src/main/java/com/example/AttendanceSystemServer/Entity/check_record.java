package com.example.AttendanceSystemServer.Entity;

import org.springframework.format.annotation.DateTimeFormat;

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
            name = "checkmanid"
    )
    private int checkmanid;
    @Column(
            name = "checktime"
    )
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date checktime;

    @Column(name = "checkplace")
    private String checkplace;

    public check_record() {
    }

    public int getCheck_record_id() {
        return check_record_id;
    }

    public void setCheck_record_id(int check_record_id) {
        this.check_record_id = check_record_id;
    }

    public Date getChecktime() {
        return checktime;
    }

    public void setChecktime(Date checktime) {
        this.checktime = checktime;
    }

    public String getCheckplace() {
        return checkplace;
    }

    public void setCheckplace(String checkplace) {
        this.checkplace = checkplace;
    }

    public int getCheckman_id() {
        return this.checkmanid;
    }

    public void setCheckman_id(int checkman_id) {
        this.checkmanid = checkman_id;
    }


}

