package com.avanes.nauka.employee.service;

import com.avanes.nauka.employee.pojo.EmployeeFullPojo;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeService {
    EmployeeFullPojo getEmployee(Long id);

    List<String> groupByName();

    List<EmployeeFullPojo> findBetween(LocalDate from, LocalDate to);
}
