package com.linkmobility.numbers.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumbersUtil {

    public static String formatSwedishMobileNumber(String number) {
        String result = "invalid";
        number = number.replaceAll("\\s+","");

        Pattern msisdnValid = Pattern.compile("^((((0{2}?)|(\\+){1})46[0]?)|0)7\\d{1}([-])?\\d{7}");

        Matcher numberMatcher = msisdnValid.matcher(number);

        if (numberMatcher.matches()) {
            number = number.replaceAll("-","");
            result = "+46" + number.substring(number.length() - 9);
        }
        return result;
    }
}
