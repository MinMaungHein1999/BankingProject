package main.java.dao.abs.employee;

import main.java.dao.AbstractDao;

import main.java.model.Employee;

public abstract class EmployeeDao extends AbstractDao<Employee> {
    public abstract Employee findByName(String name);
    public abstract boolean isEmailExists(String email);
    public abstract boolean isPhoneExists(String phoneNumber);
    public abstract Employee getEmployeeByEmployeeEmail(String email);
    public abstract Employee validateEmployee(String email,String password);
    public abstract void updateLoginToken(Employee employee);
    public abstract void validateLoginToken(Employee employee);
    public abstract void setConfimedAt(Employee employee);
}
