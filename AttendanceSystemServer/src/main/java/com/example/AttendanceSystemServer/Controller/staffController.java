package com.example.AttendanceSystemServer.Controller;
import com.alibaba.fastjson.JSONObject;
import com.example.AttendanceSystemServer.Entity.approve_receipt;
import com.example.AttendanceSystemServer.Entity.leave_apply;
import com.example.AttendanceSystemServer.Entity.staff;
import com.example.AttendanceSystemServer.Service.staffService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class staffController {
    @Autowired
    private staffService service;

    public staffController() {
    }

    @RequestMapping("login")
    @ResponseBody
    public JSONObject login(@RequestParam("id") int staff_id, @RequestParam("password") String password) {
        return this.service.login(staff_id, password);
    }

    @RequestMapping("sign")
    @ResponseBody
    public JSONObject sign(@RequestBody staff s) {
        return this.service.sign(s);
    }

    @RequestMapping("holiday/apply")
    @ResponseBody
    public JSONObject applyHoliday(@RequestBody leave_apply la) {
        return this.service.applyHoliday(la);
    }

    @RequestMapping("holiday/self")
    @ResponseBody
    public JSONObject getSelfHoliday(@RequestParam("staff_id") int staff_id){
        return service.getSelfHoliday(staff_id);
    }

    @RequestMapping("leave_record")
    @ResponseBody
    public JSONObject getLeave_record(@RequestParam("staff_id") int staff_id){
        return service.getLeave_record(staff_id);
    }

    @RequestMapping("leave_record/fromTo")
    @ResponseBody
    public JSONObject getLeave_record(@RequestParam("staff_id") int staff_id, @RequestParam("from") @DateTimeFormat(pattern = "yyyy-MM-dd")Date from, @RequestParam("to")@DateTimeFormat(pattern = "yyyy-MM-dd")Date to){
        return service.getLeave_record(staff_id,from,to);
    }

    @RequestMapping("approve")
    @ResponseBody
    public JSONObject approveApply(@RequestBody approve_receipt ar){
        return service.approveApply(ar);
    }

    @RequestMapping("approve/getlist")
    @ResponseBody
    public JSONObject getApproveList(@RequestParam("my_id") int my_id,@RequestParam("leaveman_id")int leaveman_id){
        return service.getApproveList(my_id,leaveman_id);
    }

    @RequestMapping("staffinfo/getlist")
    @ResponseBody
    public JSONObject getStaffinfo(){
        return service.getStaffinfo();
    }

    @RequestMapping("staffinfo/update")
    @ResponseBody
    public JSONObject updateStaffinfo(@RequestBody staff staff){
        return service.updateStaffinfo(staff);
    }


}
