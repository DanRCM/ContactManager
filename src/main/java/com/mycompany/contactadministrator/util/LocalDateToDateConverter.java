package com.mycompany.contactadministrator.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class LocalDateToDateConverter {
    public static Date convertirLocalDateADate(LocalDate localDate) {

        LocalDateTime localDateTime = localDate.atStartOfDay();
        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println("Fecha convertida: " + date);
        return date;
    }
}