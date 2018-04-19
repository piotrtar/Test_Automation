package com.sii.Helpers;

import java.util.Random;

public class DataGenerator {

    public String getRandomPassword() {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            char c = chars[random.nextInt(chars.length)];
            int  n = random.nextInt(9);
            sb.append(n);
            sb.append(c);
        }
        return sb.toString();
    }

    public String getRandomEmail() {

        String chars = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder sb = new StringBuilder();
        Random rnd = new Random();
        while (sb.length() < 18) { // length of the random string.
            int index = rnd.nextInt(chars.length());
            sb.append(chars.charAt(index));
        }
        String name = sb.append("@gmail.com").toString();
        return name;
    }

    public String getRandomWord() {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }

    public String getRandomPhoneNumber() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 9; i++) {
            int  n = random.nextInt(9);
            sb.append(n);
        }
        return sb.toString();
    }
}
