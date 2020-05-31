package com.cgm.qanda.util;

import java.util.regex.Pattern;

public class ValidationUtil {
    public static boolean validateLength(String input) {
        if (input == null || input.length() > 256) {
            return false;
        }
        return true;
    }

    public static boolean validateAnswerFormat(String input) {
        if (input.contains("\"")) {
            return true;
        }
        return false;
    }

    public static boolean validateQuestionFormat(String input) {
        Pattern pattern = Pattern.compile("\\w+ \\? [?\\s\\w]+");
        return pattern.matcher(input).matches();
    }
}
