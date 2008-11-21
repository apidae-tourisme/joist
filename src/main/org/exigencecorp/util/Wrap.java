package org.exigencecorp.util;

import java.util.ArrayList;
import java.util.List;

public class Wrap {

    public static String quotes(String input) {
        return "\"" + input + "\"";
    }

    public static List<String> quotes(String... input) {
        List<String> wrapped = new ArrayList<String>();
        for (String i : input) {
            wrapped.add(Wrap.quotes(i));
        }
        return wrapped;
    }

}
