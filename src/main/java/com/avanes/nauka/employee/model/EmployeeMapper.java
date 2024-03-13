package com.avanes.nauka.employee.model;

import com.avanes.nauka.employee.pojo.EmployeeFullPojo;

public enum EmployeeMapper {
    INSTANT;

    public EmployeeFullPojo toEmployeeFullPojo(Employee employee) {
        EmployeeFullPojo result = new EmployeeFullPojo();
        result.setId(employee.getId());
        result.setFirstName(employee.getFirstName());
        result.setLastName(employee.getLastName());
        result.setBirthday(employee.getBirthday());
        result.setDepartment(employee.getDepartment().getName());
        result.setSalary(employee.getSalary());
        return result;
    }
}
