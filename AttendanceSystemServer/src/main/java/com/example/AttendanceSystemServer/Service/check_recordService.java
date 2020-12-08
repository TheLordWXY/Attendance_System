package com.example.AttendanceSystemServer.Service;
import com.example.AttendanceSystemServer.Repository.check_recordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class check_recordService {
    @Autowired
    private check_recordRepository repository;

    public check_recordService() {
    }
}
