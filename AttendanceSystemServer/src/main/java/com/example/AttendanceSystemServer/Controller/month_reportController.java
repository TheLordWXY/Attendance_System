package com.example.AttendanceSystemServer.Controller;

import com.example.AttendanceSystemServer.Service.month_reportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class month_reportController {
    @Autowired
    private month_reportService service;

    public month_reportController() {
    }
}