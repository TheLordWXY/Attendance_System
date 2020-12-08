package com.example.AttendanceSystemServer.Repository;

import com.example.AttendanceSystemServer.Entity.staff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface staffRepository extends CrudRepository<staff, Integer> {
    List<staff> findAllByDepartment(String department);

    List<staff> findAllByDepartmentAndStaffrank(String department, int i);
}
