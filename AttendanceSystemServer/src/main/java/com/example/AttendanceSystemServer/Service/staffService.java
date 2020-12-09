package com.example.AttendanceSystemServer.Service;

import com.alibaba.fastjson.JSONObject;
import com.example.AttendanceSystemServer.Entity.*;
import com.example.AttendanceSystemServer.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class staffService {
    @Autowired
    private staffRepository staffRepository;
    @Autowired
    private annual_leaveRepository annual_leaveRepository;
    @Autowired
    private leave_recordRepository leave_recordRepository;
    @Autowired
    private check_recordRepository check_recordRepository;
    @Autowired
    private compassionate_leaveRepository compassionate_leaveRepository;

    public staffService() {
    }

    public void reduceLeave(String type,int leaveman_id,int duration){
        switch (type){
            case "annual":{
                annual_leave al = new annual_leave(staffRepository.findById(leaveman_id).get());
                al.setDuration(al.getDuration() - duration);
                annual_leaveRepository.save(al);
            }
        }
    }

    public JSONObject login(int staff_id, String password) {
        staff s = (staff)this.staffRepository.findById(staff_id).get();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", s);
        if (s.getPassword().equals(password)) {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "login successfully");
        } else {
            jsonObject.put("code", 1);
            jsonObject.put("msg", "password incorrect");
        }

        return jsonObject;
    }

    public JSONObject sign(staff s) {
        JSONObject jsonObject = new JSONObject();
        if (!this.staffRepository.existsById(s.getStaff_id())) {
            this.staffRepository.save(s);
            annual_leave al = new annual_leave(s);
            this.annual_leaveRepository.save(al);
            jsonObject.put("code", 0);
            jsonObject.put("msg", "sign successfully");
        } else {
            jsonObject.put("code", 1);
            jsonObject.put("msg", "already exist");
        }

        return jsonObject;
    }

    public JSONObject applyHoliday(leave_apply la) {
        JSONObject jsonObject = new JSONObject();
        la.setDuration();
        int staff_id = la.getLeaveman_id();
        staff s = (staff)this.staffRepository.findById(staff_id).get();
        //annual_leave leaveman_now = new annual_leave(s);
        leave_record lr = new leave_record(la);
        String type = lr.getType();
        switch (type){
            case "annual":{
                if (la.getDuration() <= ((annual_leave)this.annual_leaveRepository.findById(staff_id).get()).getDuration()) {
                    this.leave_recordRepository.save(lr);
                    //leaveman_now.setDuration(((annual_leave)this.annual_leaveRepository.findById(staff_id).get()).getDuration() - la.getDuration());
                    //this.annual_leaveRepository.save(leaveman_now);
                    jsonObject.put("code", 0);
                    jsonObject.put("msg", "apply successfully");
                } else {
                    jsonObject.put("code", 1);
                    jsonObject.put("msg", "not enough");
                }
            }
//            case "compassionate":{
//                leave_recordRepository.save(lr);
//                compassionate_leave cl = new compassionate_leave(s);
//
//                compassionate_leaveRepository.save(cl);
//                jsonObject.put("code", 0);
//                jsonObject.put("msg", "apply successfully");
//            }
        }



        return jsonObject;
    }

    public JSONObject getSelfHoliday(int staff_id) {
        JSONObject jsonObject = new JSONObject();
        annual_leave al = annual_leaveRepository.findById(staff_id).get();

        jsonObject.put("code",0);
        jsonObject.put("msg","get successfully");
        Map<String,Integer> data = new HashMap<>();
        data.put(al.getType(),al.getDuration());

        jsonObject.put("data",data);
        return jsonObject;
    }

    public JSONObject getLeave_record(int staff_id) {
        JSONObject jsonObject = new JSONObject();
//        leave_record lr = leave_recordRepository.findById(staff_id).get();
//        Set<Integer> ids = new HashSet<>();
//        ids.add(staff_id);
        List<leave_record> data = leave_recordRepository.findAllByLeavemanid(staff_id);
        jsonObject.put("code",0);
        jsonObject.put("msg","get successfully");
        jsonObject.put("data",data);
        return jsonObject;
    }

    public JSONObject getLeave_record(int staff_id,Date from,Date to) {
        JSONObject jsonObject = new JSONObject();
        List<leave_record> get = leave_recordRepository.findAllByLeavemanid(staff_id);
        List<leave_record> data = new ArrayList<>();
        for (leave_record lr:get) {
            if(lr.getStart_time().after(from) & lr.getEnd_time().before(to)){
                data.add(lr);
            }
        }
        jsonObject.put("code",0);
        jsonObject.put("msg","get successfully");
        jsonObject.put("data",data);
        return jsonObject;
    }

    //这是审批者也就是经理的id，是需要自己审批的请假申请
    public JSONObject approveApply(approve_receipt ar) {
        JSONObject jsonObject = new JSONObject();
        leave_record lr = leave_recordRepository.findById(ar.getLeave_record_id()).get();
        int leaveman_id = lr.getLeavemanid();
        String state = lr.getRecord_state();
        int duration = lr.getDuration();
        staff leaveman = staffRepository.findById(leaveman_id).get();
        String type = lr.getType();
        if(state.equals("reviewing") & leaveman.getStaff_rank() == 1){
            if(ar.isIs_agree()){
                if(duration <= 3){
                    lr.setRecord_state("agree");
                    jsonObject.put("code",0);
                    jsonObject.put("msg","agree");
                }
                else{
                    lr.setRecord_state("need more approve");
                    jsonObject.put("code",0);
                    jsonObject.put("msg","need more approve");
                }
                reduceLeave(type,leaveman_id,duration);
            }
            else{
                lr.setRecord_state("disagree");
                lr.setReceipt(ar.getReason());
                jsonObject.put("code",0);
                jsonObject.put("msg","disagree");
            }
            leave_recordRepository.save(lr);
        }
        else if((state.equals("reviewing") & leaveman.getStaff_rank() == 2) | state.equals("need more approve")){
            if(ar.isIs_agree()){
                lr.setRecord_state("agree");
                jsonObject.put("code",0);
                jsonObject.put("msg","agree");
                reduceLeave(type,leaveman_id,duration);
            }
            else{
                lr.setRecord_state("disagree");
                lr.setReceipt(ar.getReason());
                jsonObject.put("code",0);
                jsonObject.put("msg","disagree");
            }
            leave_recordRepository.save(lr);
        }
//        else if(state.equals("disagree") | state.equals("agree")){
//            jsonObject.put("code",1);
//            jsonObject.put("msg","already approve");
//        }
        return jsonObject;
    }

    public JSONObject getApproveList(int my_id,int leaveman_id) {
        JSONObject jsonObject = new JSONObject();
        List<leave_record> data = new ArrayList<>();
        staff my = staffRepository.findById(my_id).get();
        staff leaveman = staffRepository.findById(leaveman_id).get();
        if(my.getStaff_rank() == 1){
            jsonObject.put("code",1);
            jsonObject.put("msg","宁不配");
        }
        else if(my.getStaff_rank() == 3){
            data = leave_recordRepository.findAllByRecordstate("need more approve");
            jsonObject.put("code",0);
            jsonObject.put("msg","get successfully");
            jsonObject.put("data",data);
        }
        else{
            List<staff> my_department_staffs = new ArrayList<>();
            my_department_staffs = staffRepository.findAllByDepartmentAndStaffrank(my.getDepartment(),1);
            for (staff s:my_department_staffs) {
                int id = s.getStaff_id();
                data.addAll(leave_recordRepository.findAllByLeavemanidAndRecordstate(id,"reviewing"));
            }
            jsonObject.put("code",0);
            jsonObject.put("msg","get successfully");
            jsonObject.put("data",data);
        }
        return jsonObject;
    }

    public JSONObject getStaffinfo() {
        JSONObject jsonObject = new JSONObject();
        List<staff> allStaff = (List<staff>) staffRepository.findAll();
        jsonObject.put("code",0);
        jsonObject.put("msg","get successfully");
        jsonObject.put("data",allStaff);
        return jsonObject;
    }

    public JSONObject updateStaffinfo(staff staff) {
        JSONObject jsonObject = new JSONObject();
        staffRepository.save(staff);
        jsonObject.put("code",0);
        jsonObject.put("msg","get successfully");
        return jsonObject;
    }

    public JSONObject clockIn(Date check_time, String check_place) {
        JSONObject jsonObject = new JSONObject();
        check_record cr = new check_record();
        cr.setChecktime(check_time);
        cr.setCheckplace(check_place);
        if(check_place.equals("天津市津南区北洋园校区")){
            check_recordRepository.save(cr);
            jsonObject.put("code",0);
            jsonObject.put("msg","clockIn successfully");
        }
        else {
            jsonObject.put("code",1);
            jsonObject.put("msg","clockIn failed");
        }
        return jsonObject;
    }


    public JSONObject getMonthReport(int month, int staff_id) {
        JSONObject jsonObject = new JSONObject();
        List<check_record> all = check_recordRepository.findAllByCheckmanid(staff_id);
        List<check_record> check_records = new ArrayList<>();
        for (check_record cr:all) {
            if((cr.getChecktime().getMonth()+1) == month){
                check_records.add(cr);
            }
        }
        int mySalary = staffRepository.findById(staff_id).get().getSalary();


        if(month == 1|month == 3|month == 5|month == 7|month == 8|month == 10|month == 12){
            mySalary -= 100 * (31 - check_records.size());
        }
        else if(month == 2){
            mySalary -= 100 * (28 - check_records.size());
        }
        else {
            mySalary -= 100 * (30 - check_records.size());
        }


        int compassionateDuration = 0;


        jsonObject.put("code",0);
        jsonObject.put("msg","get successfully");
        jsonObject.put("check_records",check_records);
        jsonObject.put("salary",mySalary);
        return jsonObject;
    }
}
