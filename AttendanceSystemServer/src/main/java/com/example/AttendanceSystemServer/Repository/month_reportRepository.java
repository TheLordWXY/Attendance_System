package com.example.AttendanceSystemServer.Repository;
import com.example.AttendanceSystemServer.Entity.month_report;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface month_reportRepository extends CrudRepository<month_report, Integer> {
}
