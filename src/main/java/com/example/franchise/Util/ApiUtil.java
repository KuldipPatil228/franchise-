package com.example.franchise.Util;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.SecureRandom;
import java.util.*;

public class ApiUtil {

    private static final Logger log = LoggerFactory.getLogger(ApiUtil.class);

    private static final String PHONE_ALLOWED_CHARS = "0123456789";

    private static final SecureRandom rnd = new SecureRandom();

    private ApiUtil() {
    }

    public static long generateUid() {
        return generateUid(1000000000L, 8999999999L);
    }

    public static long generateUid(long min, long max) {
        return ((Double) ((Math.random() * (max - min)) + min)).longValue();
    }

    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }


    public static String randomString(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }

    public static String randomNumeric(int length) {
        return RandomStringUtils.randomNumeric(length);
    }


}
