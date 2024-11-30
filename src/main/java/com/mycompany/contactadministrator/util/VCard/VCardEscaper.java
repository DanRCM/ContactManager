package com.mycompany.contactadministrator.util.VCard;

public class VCardEscaper {

    public static String escape(String input) {
        if (input == null) {
            return null;
        }
        return input.replace("\\", "\\\\")
                .replace(",", "\\,")
                .replace(";", "\\;")
                .replace("\n", "\\n");
    }
}