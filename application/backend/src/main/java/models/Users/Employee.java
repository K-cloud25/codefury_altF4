package models.users;


public abstract class Employee {
    // Attributes corresponding to the table columns
    private int empID;          // Database defined ID
    private String empName;     // Employee Name
    private String email;       // Email Address
    private String phone;       // Phone Number
    private int empType;        // Employee Type (default 3)
    private String passwd;      // Password (plain text for now)

    public Employee() {
    }

    // Constructor
    public Employee(int empID, String empName, String email, String phone, int empType, String passwd) {
        this.empID = empID;
        this.empName = empName;
        this.email = email;
        this.phone = phone;
        this.empType = empType;
        this.passwd = passwd;
    }

    // Getters and Setters
    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getEmpType() {
        return empType;
    }

    public void setEmpType(int empType) {
        this.empType = empType;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    abstract public int getEmployeeType();

    // Optional: toString method to display employee information
    @Override
    public String toString() {
        return "Employee{" +
                "empID=" + empID +
                ", empName='" + empName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", empType=" + empType +
                ", passwd='" + passwd + '\'' +
                '}';
    }
}
