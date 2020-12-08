package com.example.AttendanceSystemServer.Service;

import com.alibaba.fastjson.JSONObject;
import com.example.AttendanceSystemServer.Entity.annual_leave;
import com.example.AttendanceSystemServer.Entity.leave_apply;
import com.example.AttendanceSystemServer.Entity.leave_record;
import com.example.AttendanceSystemServer.Entity.staff;
import com.example.AttendanceSystemServer.Repository.annual_leaveRepository;
import com.example.AttendanceSystemServer.Repository.leave_recordRepository;
import com.example.AttendanceSystemServer.Repository.staffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class staffService {
    @Autowired
    private staffRepository staffRepository;
    @Autowired
    private annual_leaveRepository annual_leaveRepository;
    @Autowired
    private leave_recordRepository leave_recordRepository;

    public staffService() {
    }

    public JSONObject login(int staff_id, String password) {
        staff s = (staff)this.staffRepository.findById(staff_id).get();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", s);
        if (s.getPassword().equals(password)) {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "login successfully");
        } else {
            jsonObject.put("code", 1);
            jsonObject.put("msg", "password incorrect");
        }

        return jsonObject;
    }

    public JSONObject sign(staff s) {
        JSONObject jsonObject = new JSONObject();
        if (!this.staffRepository.existsById(s.getStaff_id())) {
            this.staffRepository.save(s);
            annual_leave al = new annual_leave(s);
            this.annual_leaveRepository.save(al);
            jsonObject.put("code", 0);
            jsonObject.put("msg", "sign successfully");
        } else {
            jsonObject.put("code", 1);
            jsonObject.put("msg", "already exist");
        }

        return jsonObject;
    }

    public JSONObject applyHoliday(leave_apply la) {
        JSONObject jsonObject = new JSONObject();
        la.setDuration();
        int staff_id = la.getLeaveman_id();
        staff s = (staff)this.staffRepository.findById(staff_id).get();
        annual_leave leaveman_now = new annual_leave(s);
        leave_record lr = new leave_record(la);
        if (la.getDuration() <= ((annual_leave)this.annual_leaveRepository.findById(staff_id).get()).getDuration()) {
            this.leave_recordRepository.save(lr);
            leaveman_now.setDuration(((annual_leave)this.annual_leaveRepository.findById(staff_id).get()).getDuration() - la.getDuration());
            this.annual_leaveRepository.save(leaveman_now);
            jsonObject.put("code", 0);
            jsonObject.put("msg", "apply successfully");
        } else {
            jsonObject.put("code", 1);
            jsonObject.put("msg", "not enough");
        }

        return jsonObject;
    }
}
