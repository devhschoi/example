package com.example.service;

import org.springframework.stereotype.Service;

import java.security.MessageDigest;

@Service
public class UserPasswordHashClass {

    public String getSHA256(String plainText) {
        String shaString = "";
        try {
            MessageDigest sh = MessageDigest.getInstance("SHA-256");
            sh.update(plainText.getBytes());
            byte byteData[] = sh.digest();
            StringBuffer stringBuffer = new StringBuffer();

            for(int i = 0; i < byteData.length; i++) {
                stringBuffer.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16));
            }
            shaString = stringBuffer.toString();

        } catch (Exception e) {
            e.printStackTrace();
            shaString = null;
        }

        return shaString;

    }

}
