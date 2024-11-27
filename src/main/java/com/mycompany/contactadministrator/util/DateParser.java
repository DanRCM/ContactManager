package com.mycompany.contactadministrator.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {

    private DateParser(){}

    // Método para transformar un String a Date
    public static Date stringToDate(String dateString) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        return formato.parse(dateString);
    }

    public static String dateToString(Date date, String formato) {
        SimpleDateFormat formatter = new SimpleDateFormat(formato);
        return formatter.format(date);
    }
  
    
}
