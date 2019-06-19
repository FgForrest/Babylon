package com.fg.util.babylon.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * TODO TLN  - smazat? Zdá se, že se už nepoužívá
 *
 * @author Tomas Langer (langer@fg.cz), FG Forrest a.s. (c) 2019
 */
public class CommonUtils {

    private CommonUtils() {
    }

    public static String hashString(String textToHash) throws NoSuchAlgorithmException {
        MessageDigest objMD5 = MessageDigest.getInstance("MD5");
        byte[] hashBytes = objMD5.digest(textToHash.getBytes());
        BigInteger numHash = new BigInteger(1, hashBytes);
        return String.format("%032x", numHash);
    }

}
