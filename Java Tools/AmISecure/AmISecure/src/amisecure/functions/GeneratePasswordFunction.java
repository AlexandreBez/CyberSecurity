/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package amisecure.functions;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;


public class GeneratePasswordFunction {

    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*()_+{}[]";

    public static String generatePassword(int length) throws IOException, NoSuchAlgorithmException {
        
        IsPasswordLeakedFunction isPasswordLeakedFunction = new IsPasswordLeakedFunction();

        Boolean isLeaked = true;
        StringBuilder password = new StringBuilder();

        while (isLeaked) {
            
            String allChars = UPPER + LOWER + DIGITS + SPECIAL;
            SecureRandom random = new SecureRandom();

            for (int i = 0; i < length; i++) {
                int randomIndex = random.nextInt(allChars.length());
                password.append(allChars.charAt(randomIndex));
            }
            
            isLeaked = isPasswordLeakedFunction.isPwned(password.toString());
        }

        return password.toString();
    }
}
