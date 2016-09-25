package ua.artcode.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by serhii on 9/25/16.
 */
public final class SecurityUtils {

    private static MessageDigest messageDigest;

    private SecurityUtils() {
    }

    static {
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static String hash(String word) {
        byte[] hashed = messageDigest.digest(word.getBytes());
        return new String(hashed);
    }

}
