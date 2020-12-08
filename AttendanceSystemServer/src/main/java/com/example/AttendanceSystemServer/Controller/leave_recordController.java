package com.example.AttendanceSystemServer.Controller;
import com.example.AttendanceSystemServer.Service.leave_recordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class leave_recordController {
    @Autowired
    private leave_recordService service;

    public leave_recordController() {
    }
}
