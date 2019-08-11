package com.hyj.hyjurl.common;

public class Base62Encode {
    private static String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static int BASE = ALPHABET.length();


    public static String encode(int number) {
        if (number == 0) {
            return ALPHABET.substring(0, 1);
        }

        StringBuilder code = new StringBuilder(16);

        while (number > 0) {
            int remainder = number % BASE;
            number /= BASE;

            code.append(ALPHABET.charAt(remainder));
        }

        return code.reverse().toString();
    }

}
