package com.example.AttendanceSystemServer.Repository;

//import com.example.checkAttendance.Entity.check_record;
import com.example.AttendanceSystemServer.Entity.check_record;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface check_recordRepository extends CrudRepository<check_record, Integer> {
}
