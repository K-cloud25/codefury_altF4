package com.altfregistry.model.users;

public class Member extends Employee{


    public Member() {

    }

    public Member(int empID, String empName, String email, String phone, int empType, String passwd) {
        super(empID, empName, email, phone, empType, passwd);
    }

    @Override
    public int getEmployeeType() {
        return 3;
    }

    //other functions needed for Member

    //1. View Meeting Room Schedules

    //2. View Particular Meeting's details such as schedule , amenities ,etc.

}
