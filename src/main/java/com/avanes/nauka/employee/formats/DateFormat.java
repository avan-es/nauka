package com.avanes.nauka.employee.formats;

import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public final class DateFormat {

    public static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static final String DATE_PATTERN = "yyyy-MM-dd";

}