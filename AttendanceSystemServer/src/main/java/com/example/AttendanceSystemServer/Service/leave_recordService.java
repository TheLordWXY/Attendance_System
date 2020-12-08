package com.example.AttendanceSystemServer.Service;

import com.example.AttendanceSystemServer.Repository.leave_recordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class leave_recordService {
    @Autowired
    private leave_recordRepository repository;

    public leave_recordService() {
    }
}
