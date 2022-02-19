package com.host.management.util;

import com.host.management.model.Host;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Util {

    private static List<Host> hostLibrary = Arrays.asList(new Host(1, "Kandy", new HashMap<String, Boolean>()), new Host(2, "Matara", new HashMap<String, Boolean>()));;
    public static List<Host> getHostLibrary() {
        return hostLibrary;
    }
}
