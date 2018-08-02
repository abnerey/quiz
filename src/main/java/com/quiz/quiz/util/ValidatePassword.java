package com.quiz.quiz.util;

public class ValidatePassword {

    private static final String LETTERS[] = new String[] {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","ñ",
            "o", "p", "q", "r", "s", "t", "u", "v","w","x","y","z"};

    public static boolean isValid(String password) {
        boolean lowerCaseValid = isLetterValids(password, true, 4);
        boolean upperCaseValid = isLetterValids(password, false, 2);
        boolean digitValid = isDigitValid(password);
        boolean symbolValid = isSymbolValid(password);
        if (lowerCaseValid && upperCaseValid && digitValid && symbolValid) {
            System.out.println("OK");
        }
        return lowerCaseValid && upperCaseValid && digitValid && symbolValid;
    }

    private static boolean isSymbolValid(String password) {
        boolean response = password.matches("[^-_=+\\\\|\\[{\\]};:'\",<>/]*");
        if (!response) {
            System.out.println("Símbolos faltantes : 1");
        }
        return response;
    }

    private static boolean isDigitValid(String password) {
        for (char character : password.toCharArray()) {
            try {
                Integer.parseInt(String.valueOf(character));
                return true;
            } catch (NumberFormatException e) {
                //e.printStackTrace();
            }
        }
        System.out.println("Dígitos faltantes : 1");
        return false;
    }

    private static boolean isLetterValids(String password, boolean isLowerCase, int size) {
        int count = 0;
        for (char character : password.toCharArray()) {
            if ( isInArray(character, isLowerCase) ) {
                count++;
            }
        }
        if (count < size) {
            System.out.println("Carácteres en " +  (isLowerCase ? "minúscula" : "mayúscula") + " faltantes : " + (size - count));
        }
        return count >= size;
    }

    private static boolean isInArray(char character, boolean isLowerCase) {
        for (String letter : LETTERS) {
            if (isLowerCase) {
                if (letter.equals(String.valueOf(character))) return true;
            } else {
                if (letter.toUpperCase().equals(String.valueOf(character))) return true;
            }
        }
        return false;
    }

}