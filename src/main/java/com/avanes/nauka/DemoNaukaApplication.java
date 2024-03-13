package com.avanes.nauka;

import com.avanes.nauka.ApiError.exception.NotFoundException;
import com.avanes.nauka.employee.pojo.EmployeeFullPojo;
import com.avanes.nauka.employee.service.EmployeeService;
import com.avanes.nauka.employee.service.EmployeeServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.List;


public class DemoNaukaApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(NaukaApplication.class, args);
        EmployeeService service = applicationContext.getBean(EmployeeServiceImpl.class);
        System.out.println();

        System.out.println("Демонстрация работы getEmployee(ID) для существующего работника с ID 1:");
        System.out.println(service.getEmployee(1L) + "\n");

        System.out.println("Демонстрация работы getEmployee(ID) для несуществующего работника с ID 1000:");
        try {
            System.out.println(service.getEmployee(1000L) + "\n");
        } catch (NotFoundException e) {
            System.out.println( e.getMessage() + "\n");
        }

        System.out.println("Демонстрация работы findBetween(from, to) с from < to (from= 1990-01-01, to = 1992-12-31):");
        List<EmployeeFullPojo> result = service.findBetween(LocalDate.of(1990,1,1), LocalDate.of(1992, 12, 31));
        printEmployee(result);

        System.out.println("Демонстрация работы findBetween(from, to) с from > to (from = 1992-01-01, to = 1990-12-31):");
        result = service.findBetween(LocalDate.of(1992, 1,1), LocalDate.of(1990, 12, 31));
        printEmployee(result);

        System.out.println("Демонстрация работы findBetween(from, to) с from = to = 1992-02-21:");
        result = service.findBetween(LocalDate.of(1992,2,21), LocalDate.of(1992, 2, 21));
        printEmployee(result);

        System.out.println("Демонстрация работы findBetween(from, to) с 0 списком from = to = 2050-12-06:");
        result = service.findBetween(LocalDate.of(2050,12,6), LocalDate.of(2050, 12, 6));
        printEmployee(result);

        System.out.println("Демонстрация работы groupByName():");
        System.out.println(service.groupByName() + "\n");

    }

    private static void printEmployee(List<EmployeeFullPojo> result) {
        if (result.size() == 0) {
            System.out.println("Нет сотрудников с днями рождения в заданном диапазоне.");
        } else {
            for (EmployeeFullPojo emp : result) {
                System.out.println(emp);
            }
        }
        System.out.println();
    }
}
