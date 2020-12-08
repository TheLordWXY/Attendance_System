package com.example.AttendanceSystemServer.Repository;

import com.example.AttendanceSystemServer.Entity.annual_leave;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface annual_leaveRepository extends CrudRepository<annual_leave, Integer> {
}
