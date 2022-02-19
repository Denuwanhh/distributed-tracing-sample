package com.host.management.util;

import com.host.management.model.Host;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Util {

    public static List<Host> getHostLibrary() {
        Map<Date, Boolean> baseCalender = new HashMap<Date, Boolean>();
        try {
            baseCalender.put(new SimpleDateFormat("yyyy-MM-dd").parse("2022-02-01"), true);
            baseCalender.put(new SimpleDateFormat("yyyy-MM-dd").parse("2022-02-02"), true);
            baseCalender.put(new SimpleDateFormat("yyyy-MM-dd").parse("2022-02-03"), true);
            baseCalender.put(new SimpleDateFormat("yyyy-MM-dd").parse("2022-02-19"), true);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Arrays.asList(new Host(1, "Kandy", baseCalender), new Host(2, "Matara", baseCalender));
    }
}
