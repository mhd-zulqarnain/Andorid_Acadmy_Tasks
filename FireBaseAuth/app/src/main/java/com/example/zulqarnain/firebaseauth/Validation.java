package com.example.zulqarnain.firebaseauth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Zul Qarnain on 10/8/2017.
 */

public class Validation {
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean emailValidate(String emailStr){
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        return matcher.find();
    }
}
