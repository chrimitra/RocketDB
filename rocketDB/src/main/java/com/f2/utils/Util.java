package com.f2.utils;

import org.springframework.util.SerializationUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class Util {
    public static String generateUsername() {
        Random random = new Random();
        String adjective = Constants.ADJECTIVES[random.nextInt(Constants.ADJECTIVES.length)];
        String noun = Constants.NOUNS[random.nextInt(Constants.NOUNS.length)];
        int number = random.nextInt(1000);

        return adjective + noun + number;
    }

    public static String generateRandomIPAddress() {
        Random random = new Random();
        StringBuilder ipAddressBuilder = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            int segment = random.nextInt(256); // Generate a random number between 0 and 255
            ipAddressBuilder.append(segment);

            if (i < 3) {
                ipAddressBuilder.append(".");
            }
        }

        return ipAddressBuilder.toString();
    }

}
