package com.avanes.nauka.employee.controller;

import com.avanes.nauka.employee.formats.DateFormat;
import com.avanes.nauka.employee.pojo.EmployeeFullPojo;
import com.avanes.nauka.employee.service.EmployeeService;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("nauka/employee")
@Validated
@Slf4j
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeFullPojo getAlbumById(
            @PositiveOrZero @PathVariable Long id) {
        return employeeService.getEmployee(id);
    }

    @GetMapping("/groupByName")
    @ResponseStatus(HttpStatus.OK)
    public List<String> groupByName() {
        return employeeService.groupByName();
    }

    @GetMapping("/findBetween")
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeFullPojo> findBetween(
            @DateTimeFormat(pattern = DateFormat.DATE_PATTERN) LocalDate from,
            @DateTimeFormat(pattern = DateFormat.DATE_PATTERN) LocalDate to) {
        System.out.println();
        return employeeService.findBetween(from, to);
    }
}
