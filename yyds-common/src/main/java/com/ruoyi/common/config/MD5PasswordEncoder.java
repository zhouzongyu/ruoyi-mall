package com.ruoyi.common.config;

import org.springframework.security.crypto.password.PasswordEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5PasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(rawPassword.toString().getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not found");
        }
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if(rawPassword.length() >= 32) {
            return rawPassword.equals(encodedPassword);
        } else {
            return encode(rawPassword).equals(encodedPassword);
        }

    }
}
