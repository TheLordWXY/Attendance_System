package com.example.AttendanceSystemServer.Repository;

import com.example.AttendanceSystemServer.Entity.leave_record;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository
public interface leave_recordRepository extends CrudRepository<leave_record, Integer> {
    List<leave_record> findAllByLeavemanid(Integer leaveman_id);

    List<leave_record> findAllByRecordstate(String recordstate);

    List<leave_record> findAllByLeavemanidAndRecordstate(int id, String reviewing);

    @Query(value = "select * from checkattendancedb.leave_record where checkattendancedb.leave_record.leavemanid = :staff_id and " +
            "checkattendancedb.leave_record.start_time >= :from and checkattendancedb.leave_record.end_time <= :to",nativeQuery = true)
    List<leave_record> findAllByLeavemanidFromTo(@Param("staff_id") int staff_id,@Param("from") Date from,@Param("to") Date to);
}
