package com.example.AttendanceSystemServer.Repository;

import com.example.AttendanceSystemServer.Entity.compassionate_leave;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface compassionate_leaveRepository extends CrudRepository<compassionate_leave,Integer> {

}
