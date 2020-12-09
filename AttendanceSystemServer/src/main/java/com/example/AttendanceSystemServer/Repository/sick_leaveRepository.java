package com.example.AttendanceSystemServer.Repository;

import com.example.AttendanceSystemServer.Entity.sick_leave;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface sick_leaveRepository extends CrudRepository<sick_leave,Integer> {
}
