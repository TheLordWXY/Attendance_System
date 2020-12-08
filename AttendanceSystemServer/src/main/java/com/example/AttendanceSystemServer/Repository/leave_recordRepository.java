package com.example.AttendanceSystemServer.Repository;

import com.example.AttendanceSystemServer.Entity.leave_record;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface leave_recordRepository extends CrudRepository<leave_record, Integer> {
}
