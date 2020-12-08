package com.example.AttendanceSystemServer.Entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
        name = "staff"
)
public class staff {
    @Column(
            name = "staff_id"
    )
    @Id
    private int staff_id;
    @Column(
            name = "gender"
    )
    private String gender;
    @Column(
            name = "name"
    )
    private String name;
    @Column(
            name = "birth_date"
    )
    private Date birth_date;
    @Column(
            name = "join_year"
    )
    private int join_year;
    @Column(
            name = "age"
    )
    private int age;
    @Column(
            name = "department"
    )
    private String department;
    @Column(
            name = "password"
    )
    private String password;
    @Column(
            name = "staff_rank"
    )
    private int staff_rank;

    public staff() {
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStaff_rank() {
        return this.staff_rank;
    }

    public void setStaff_rank(int rank) {
        this.staff_rank = rank;
    }

    public int getStaff_id() {
        return this.staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth_date() {
        return this.birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public int getJoin_year() {
        return this.join_year;
    }

    public void setJoin_year(int join_year) {
        this.join_year = join_year;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
