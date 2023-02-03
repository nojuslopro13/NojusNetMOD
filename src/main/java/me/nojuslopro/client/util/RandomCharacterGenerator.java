package me.nojuslopro.client.util;

import java.util.Random;

public class RandomCharacterGenerator {
    public static String generateUpperCaseRandomLetter() {
        Random random = new Random();

        // Generate a random character
        char randomChar = (char) (random.nextInt(26) + 'A');
        String randomLetter = String.valueOf(randomChar);

        return randomLetter;
    }

    public static String generateLowerCaseRandomLetter() {
        Random random = new Random();

        // Generate a random character
        char randomChar = (char) (random.nextInt(26) + 'a');
        String randomLetter = String.valueOf(randomChar);

        return randomLetter;
    }
}
