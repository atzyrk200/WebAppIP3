package WebApp;

import org.mindrot.jbcrypt.BCrypt;

public class User {

}

class Password {

    /**
     * Hashes passwords using jBCrypt.
     *
     * @param password The user's password.
     * @return The hashed password.
     */
    private static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    /**
     * Method checks the password contains a number and a capital letter
     * and that the length is greater than eight characters.
     *
     * @param password Users password to check
     * @return true/false dependent on password being applicable.
     */
    private static boolean isPasswordGood(String password) {

        boolean hasCaps = false;
        boolean hasNumber = false;

        // Iterate through chars to change booleans.
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) hasCaps = true;
            if (Character.isDigit(ch)) hasNumber = true;
        }

        // Final check.
        return hasNumber && hasCaps && password.length() >= 8;
    }

    /**
     * Check that an unencrypted password matches one that has previously been hashed.
     * (It should NOT reveal the password, only verify whether the hashed matches the plain.)
     *
     * @param password       The user's hash (taken from DB).
     * @param hashedPassword The hashed password.
     * @return Boolean verifying whether password matches.
     */
    public static Boolean verifyPasswordHash(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }

}
