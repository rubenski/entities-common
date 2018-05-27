package nl.codebase.entities.common;

import org.apache.commons.codec.digest.DigestUtils;

import java.security.SecureRandom;
import java.util.Arrays;

public class EncryptionUtil {

    public static String generatePasswordHash(String salt, String password) {
        return DigestUtils.sha512Hex(salt + password);
    }

    public static String getSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[64];
        random.nextBytes(salt);
        return Arrays.toString(salt);
    }

}
