package com.example.franchise.Enums;


import java.util.Arrays;

public enum MessageType {

    /* - - - - - - - - - - - - - - - - - - - -
     * HttpStatus.UNAUTHORIZED (401)
     * - - - - - - - - - - - - - - - - - - - - */
    // 1xxx: Unauthorized Token, User
    // Access Token
    ACCESS_TOKEN_MISSING(1001),
    ACCESS_TOKEN_INVALID(1002),
    ACCESS_TOKEN_EXPIRED(1003),
    ACCESS_TOKEN_NOT_CREATED(1004),

    // Refresh Token
    REFRESH_TOKEN_INVALID(1021),
    REFRESH_TOKEN_EXPIRED(1022),

    // Auth Key
    AUTH_KEY_INVALID(1031),

    // Invalid Auth
    INVALID_USERNAME_PASSWORD(1041),
    INVALID_CURRENT_PASSWORD(1042),
    INVALID_PASSWORD(1043),
    LICENSE_EXPIRED(1044),

    // Auth Status
    DISABLED_USER(1061),

    // Required
    REQUIRED_PASSWORD(1081),

    // Unauthorized
    UNAUTHORIZED_ACCESS(1101),

    // LIMIT
    LIMIT_REACHED_GSTIN(1111),
    LIMIT_REACHED_REPORT(1112),


    /* - - - - - - - - - - - - - - - - - - - -
     * HttpStatus.BAD_REQUEST (400)
     * - - - - - - - - - - - - - - - - - - - - */
    // 2xxx: Invalid Request Params
    // Required
    REQUIRED_PARAM(2001),

    // Invalid
    INVALID_ENTITY(2051),
    INVALID_PARAMS(2052),
    INVALID_VALUE(2053),
    INVALID_ROLE(2054),
    INVALID_PHONE(2055),
    INVALID_LINK(2056),
    INVALID_EMAILS(2057),
    INVALID_CAPTCHA(2058),
    INVALID_NEW_PASSWORD(2059),
    INVALID_LINK_LEVEL(2060),
    INVALID_LINK_LEVEL_PARENT_ID(2061),
    INVALID_BOARD_OWNER(2062),

    // Already Exists
    ALREADY_EXIST_ENTITY(2101),
    ALREADY_EXISTS_USERNAME(2102),
    ALREADY_EXISTS_EMAIL(2103),
    ALREADY_EXISTS_STRIPE_ACCOUNT(2104),
    ALREADY_EXISTS_LINK_LEVEL_NAME(2105),
    ALREADY_EMAIL_VERIFIED(2106),
    ALREADY_EXISTS_ADVISORY_CATEGORY_NAME(2107),
    ALREADY_EXISTS_FILE_NAME(2108),
    ALREADY_REPORT_EXECUTED(2109),
    REPORT_GST_AUTH_REQUIRED(2110),

    // Not Verified
    NOT_VERIFIED_EMAIL(2201),

    // Constraint
    CONSTRAINT_VIOLATION(2301),

    // Unable To
    UNABLE_TO_PARSE(2401),
    UNABLE_TO_CONVERT_VALUE(2402),
    UNABLE_TO_CONVERT_JSON_TO_ENTITY(2403),
    UNABLE_TO_CONVERT_HTML_TO_PDF(2404),

    // Can't Delete
    CANNOT_DELETE_ENTITY(2501),
    CANNOT_DELETE_SELF_USER(2502),
    CANNOT_DELETE_PARENT_CHILD_PRESENT(2503),

    // Can't Change
    CANNOT_CHANGE_ENTITY(2551),
    CANNOT_CHANGE_USERNAME(2552),
    CANNOT_CHANGE_OTHER_ACCESS_TYPE_ROLES(2553),
    CANNOT_CHANGE_SELF_ROLES(2554),
    CANNOT_CHANGE_FIELD(2555),

    // Validation
    FROM_DATE_MUST_BE_LESS_THAN_TO_DATE(2601),

    // Failed
    FAILED_TO_UPLOAD_FILE(2701),
    FAILED_TO_DOWNLOAD_FILE(2702),
    FAILED_TO_DELETE_FILE(2703),

    // File
    FILE_SIZE_EXCEEDED(2951),
    FILE_TYPE_NOT_ALLOWED(2952),

    /* - - - - - - - - - - - - - - - - - - - -
     * HttpStatus.NOT_FOUND (404)
     * - - - - - - - - - - - - - - - - - - - - */
    // 3xxx: Not Found
    // Not Found
    NOT_FOUND_ENTITY(3001),
    NOT_FOUND_USER(3002),
    NOT_FOUND_PROFILE(3003),
    NOT_FOUND_ROLE(3004),
    NOT_FOUND_FILE_NAME(3005),
    NOT_FOUND_DATA(3006),

    // Not Exists
    NOT_EXISTS_EMAIL(3051),
    NOT_EXISTS_AUTH_TOKEN(3052),

    // NOT
    NOT_PREPARED_REPORT(3101),


    // 8xxx: Warning or Conflict
    /* - - - - - - - - - - - - - - - - - - - -
     * HttpStatus.CONFLICT (409)
     * - - - - - - - - - - - - - - - - - - - - */
    // Username
    EMAIL_ALREADY_EXIST_ROLE_ADDED(8001),


    /* - - - - - - - - - - - - - - - - - - - -
     * HttpStatus.INTERNAL_SERVER_ERROR (500)
     * - - - - - - - - - - - - - - - - - - - - */
    // 9xxx: Exception
    // Exception
    EXCEPTION(9001),
    NULL_POINTER_EXCEPTION(9002),
    SQL_EXCEPTION(9003),
    SQL_SP_EXCEPTION(9004),
    CUSTOM_EXCEPTION(9005),
    JOB_EXCEPTION(9006),
    GST_API_EXCEPTION(9007);

    private final int code;

    MessageType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static MessageType parse(int code) {
        return Arrays.stream(MessageType.values()).filter(element -> element.code == code).findFirst().orElse(null);
    }
}
