package com.sii.Helpers;

import java.util.Random;

public class NameGenerator {

    public String getRandomName() {

        String chars = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder sb = new StringBuilder();
        Random rnd = new Random();
        while (sb.length() < 18) { // length of the random string.
            int index = rnd.nextInt(chars.length());
            sb.append(chars.charAt(index));
        }
        String name = sb.toString();
        return name;

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
}
