package com.avanes.nauka.employee.repository;

import com.avanes.nauka.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository(value = "dbEmployeeRepository")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value =
            "SELECT * " +
            "FROM employee AS e " +
            "WHERE e.id = ? ", nativeQuery = true)
    Optional<Employee> findById(Long id);

    @Query(value =
            "SELECT e.first_name " +
            "FROM employee AS e " +
            "GROUP BY e.first_name " +
            "ORDER BY e.first_name ASC", nativeQuery = true)
    List<String> groupByName();

    @Query(value =
            "SELECT * " +
            "FROM employee AS e " +
            "WHERE e.birthday BETWEEN ? AND ?", nativeQuery = true)
    List<Employee> findBetween(LocalDate from, LocalDate to);
}
