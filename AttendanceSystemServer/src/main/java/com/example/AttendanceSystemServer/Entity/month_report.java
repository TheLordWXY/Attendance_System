package com.example.AttendanceSystemServer.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
        name = "month_report"
)
public class month_report {
    @Id
    @Column(
            name = "month_report_id"
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private int month_report_id;
    @Column(
            name = "month"
    )
    private int month;
    @Column(
            name = "staff_id"
    )
    private int staff_id;
    private int month_wages;

    public month_report() {
    }
}

