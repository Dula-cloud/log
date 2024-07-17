package com;

import java.util.regex.*;

public class B {

    public static String getPasswordStrength(String password) {
        int score = 0;

        if (password.length() >= 8) {
            score++;
        }

        Pattern upperCasePattern = Pattern.compile("[A-Z]");
        Matcher upperCaseMatcher = upperCasePattern.matcher(password);
        if (upperCaseMatcher.find()) {
            score++;
        }

        Pattern lowerCasePattern = Pattern.compile("[a-z]");
        Matcher lowerCaseMatcher = lowerCasePattern.matcher(password);
        if (lowerCaseMatcher.find()) {
            score++;
        }

        Pattern digitPattern = Pattern.compile("[0-9]");
        Matcher digitMatcher = digitPattern.matcher(password);
        if (digitMatcher.find()) {
            score++;
        }

        Pattern specialCharPattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher specialCharMatcher = specialCharPattern.matcher(password);
        if (specialCharMatcher.find()) {
            score++;
        }

        switch (score) {
            case 5:
                return "Strong";
            case 4:
                return "Medium";
            default:
                return "Weak";
        }
    }

    public static void main(String[] args) {
        String password = "12!";
        String strength = getPasswordStrength(password);
        System.out.println("The password strength is: " + strength);
    }
}
