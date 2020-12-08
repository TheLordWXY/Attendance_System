package com.example.AttendanceSystemServer.Entity;

public class approve_receipt {
    private int staff_id;
    private int leave_record_id;
    private boolean is_agree;
    private String reason;

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public int getLeave_record_id() {
        return leave_record_id;
    }

    public void setLeave_record_id(int leave_record_id) {
        this.leave_record_id = leave_record_id;
    }

    public boolean isIs_agree() {
        return is_agree;
    }

    public void setIs_agree(boolean is_agree) {
        this.is_agree = is_agree;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
