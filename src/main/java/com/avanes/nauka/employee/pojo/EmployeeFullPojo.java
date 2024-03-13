package com.avanes.nauka.employee.pojo;

import com.avanes.nauka.employee.formats.DateFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class EmployeeFullPojo {

    private Long id;
    private String firstName;
    private String lastName;
    @DateTimeFormat(pattern = DateFormat.DATE_PATTERN)
    private LocalDate birthday;
    private String department;
    private Integer salary;
}
