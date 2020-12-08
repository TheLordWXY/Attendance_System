package com.example.AttendanceSystemServer.Controller;
import com.alibaba.fastjson.JSONObject;
import com.example.AttendanceSystemServer.Entity.leave_apply;
import com.example.AttendanceSystemServer.Entity.staff;
import com.example.AttendanceSystemServer.Service.staffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class staffController {
    @Autowired
    private staffService service;

    public staffController() {
    }

    @RequestMapping({"login"})
    @ResponseBody
    public JSONObject login(@RequestParam("id") int staff_id, @RequestParam("password") String password) {
        return this.service.login(staff_id, password);
    }

    @RequestMapping({"sign"})
    @ResponseBody
    public JSONObject sign(@RequestBody staff s) {
        return this.service.sign(s);
    }

    @RequestMapping({"holiday/apply"})
    @ResponseBody
    public JSONObject applyHoliday(@RequestBody leave_apply la) {
        return this.service.applyHoliday(la);
    }
}
