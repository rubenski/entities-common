package nl.codebase.entities.common;

public class FaceterConstants {
    public static final String CSRF_COOKIE_NAME = "X-CSRF-TOKEN";
    public static final String CSRF_HEADER_NAME = "CSRF-TOKEN";
    public static final String PARAM_REFRESH_TOKEN = "refresh_token";
    public static final String PARAM_ACCESS_TOKEN = "access_token";
    public static final String AUTHENTICATED_COOKIE_NAME = "authenticated";

    public enum GRANT {
        ADMIN_USER("ADMIN_USER"),
        COMPANY_USER("COMPANY_USER"),
        SSL_USER("SSL_USER");

        private String grant;

        GRANT(String s) {
            grant = s;
        }
    }
}
