package com.carservice.Utils;

import java.util.regex.Pattern;

public final class UtilsImpl implements IUtils{

    private static UtilsImpl INSTANCE;

    private final static Pattern DATE_PATTERN = Pattern.compile("^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$");

    private final static String UUID_PATTERN = "[0-9a-fA-F]{8}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{12}";

    public static UtilsImpl getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new UtilsImpl();
        }
        return INSTANCE;
    }

    private UtilsImpl() {

    }

    @Override
    public Boolean isStringUUID(String uuid) {

        String stringUUID = uuid.toString();
        if(stringUUID.matches(UUID_PATTERN)) {
            return true;
        }
        System.out.println("Acesta nu este un id valid.");
        return false;
    }

    @Override
    public Boolean checkDate(String date) {
        if(DATE_PATTERN.matcher(date).matches())
            return true;

        System.out.println("Aceasta nu este o data valida.");
        return false;
    }

}
