package nl.codebase.entities.common;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import java.security.SecureRandom;

@Slf4j
public class EncryptionUtil {

    public static String generatePasswordHash(String salt, String password) {
        return DigestUtils.sha512Hex(salt + password);
    }

    public static String getBase64Salt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[64];
        random.nextBytes(salt);
        return Base64.encodeBase64String(salt);
    }
}
