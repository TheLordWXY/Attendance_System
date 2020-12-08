package com.example.AttendanceSystemServer.Controller;

import com.example.AttendanceSystemServer.Service.check_recordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class check_recordController {
    @Autowired
    private check_recordService service;

    public check_recordController() {
    }
}
