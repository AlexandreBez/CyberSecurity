/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package amisecure.functions;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author adm
 */
public class IsPasswordStrongFunction {

    public static boolean validatePassword(String password) throws IOException, NoSuchAlgorithmException{
        
        IsPasswordLeakedFunction isPasswordLeakedFunction = new IsPasswordLeakedFunction();
        // Check minimum length
        if (password.length() < 8) {
            return false;
        }

        // Check character types
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (isSpecialChar(c)) {
                hasSpecialChar = true;
            }
        }

        // Check if all required character types are present
        return hasUppercase && hasLowercase && hasDigit && hasSpecialChar && isPasswordLeakedFunction.isPwned(password);
    }

    private static boolean isSpecialChar(char c) {
        String specialChars = "!@#$%^&*()-_=+[]{}|;:,.<>?";
        return specialChars.indexOf(c) != -1;
    }

}
