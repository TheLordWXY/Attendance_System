package com.example.AttendanceSystemServer.Repository;

import com.example.AttendanceSystemServer.Entity.staff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface staffRepository extends CrudRepository<staff, Integer> {
}
