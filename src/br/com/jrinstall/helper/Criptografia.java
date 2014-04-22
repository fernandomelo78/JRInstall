/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jrinstall.helper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Fernando
 */
public class Criptografia {

    private static MessageDigest md = null;

    static {

        try {

            md = MessageDigest.getInstance("MD5");

        } catch (NoSuchAlgorithmException ex) {

            ex.printStackTrace();

        }

    }

    private static char[] hexCodes(byte[] text) {

        char[] hexOutput = new char[text.length * 3];

        String hexString;

        for (int i = 0; i < text.length; i++) {

            hexString = "00" + Integer.toHexString(text[i]);

            hexString.toUpperCase().getChars(hexString.length() - 3,
                    hexString.length(), hexOutput, i * 3);

        }

        return hexOutput;

    }

    public static String criptografar(String pwd) {

        if (md != null) {

            //return new String(hexCodes(md.digest(pwd.getBytes()))).substring(0, 19);
            return new String(pwd);
        }

        return null;

    }
}
