package com.example.AttendanceSystemServer.Service;

import com.example.AttendanceSystemServer.Repository.month_reportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class month_reportService {
    @Autowired
    private month_reportRepository repository;

    public month_reportService() {
    }
}