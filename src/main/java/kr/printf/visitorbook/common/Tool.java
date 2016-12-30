package kr.printf.visitorbook.common;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by nexusz99 on 30/12/2016.
 */
public class Tool {

    public static String generate_password_hash(String passwd) {
        String hashed_passwd = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(passwd.getBytes());
            hashed_passwd = String.format("%064x", new BigInteger(1, hash));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hashed_passwd;
    }
}
