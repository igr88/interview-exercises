package dev.me.exercises;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Sha256Generator {
    public static void main(String[] args) {
        String line = "";
        try(Scanner console = new Scanner(System.in)) {
            line = console.nextLine();
        }

        System.out.println(calculateSha256(line));
    }

    private static String calculateSha256(String string) {
        try {
            var messageDigest = MessageDigest.getInstance("SHA-256");
            var hash = messageDigest.digest(string.getBytes(StandardCharsets.UTF_8));
            return toHexadecimalString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static String toHexadecimalString(byte[] bytes) {
        return new BigInteger(1, bytes).toString(16).toLowerCase();
    }

}
