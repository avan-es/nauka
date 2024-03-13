package com.avanes.nauka.employee.service;

import com.avanes.nauka.ApiError.exception.NotFoundException;
import com.avanes.nauka.employee.model.Employee;
import com.avanes.nauka.employee.model.EmployeeMapper;
import com.avanes.nauka.employee.pojo.EmployeeFullPojo;
import com.avanes.nauka.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {


    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeFullPojo getEmployee(Long id) {
        System.out.println();
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("Сотрудник с ID %d не найден.", id)));
        return EmployeeMapper.INSTANT.toEmployeeFullPojo(employee);
    }

    @Override
    public List<String> groupByName() {
        return employeeRepository.groupByName();
    }

    @Override
    public List<EmployeeFullPojo> findBetween(LocalDate from, LocalDate to) {
        List<Employee> employees;
        if (from.isBefore(to)) {
            employees = employeeRepository.findBetween(from, to);
        } else {
            employees = employeeRepository.findBetween(to, from);
        }
        return employees.stream().map(EmployeeMapper.INSTANT::toEmployeeFullPojo).collect(Collectors.toList());
    }
}
