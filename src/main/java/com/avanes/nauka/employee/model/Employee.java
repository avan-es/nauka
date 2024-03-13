package com.avanes.nauka.employee.model;

import com.avanes.nauka.department.model.Department;
import com.avanes.nauka.employee.formats.DateFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @DateTimeFormat(pattern = DateFormat.DATE_PATTERN)
    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "dp_id")
    private Department department;

    @Column(name = "salary", nullable = false)
    private Integer salary;

}
