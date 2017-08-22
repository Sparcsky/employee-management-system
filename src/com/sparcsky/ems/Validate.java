package com.sparcsky.ems;

public class Validate {

    private final int minLength = 6;
    private final int maxLength = 20;
    private StringBuffer error = new StringBuffer();

    public boolean isValid(String password, String pswRepeat) {

        //  Passwords must contain at least one upper case and lower case letter, a symbol/special character, and a numeral
        if (!password.equals(pswRepeat)) {
            error.append("Password do not match.");
        } else if (password.equals(pswRepeat)) {

            final String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$)" + ".{" + minLength + ',' + maxLength + '}';

            if (password.matches(pattern)) {
                return true;
            } else {
                error.append(" Passwords must contain at least one upper case and lower case letter and a numeral");
            }
        }

        return false;
    }


}
