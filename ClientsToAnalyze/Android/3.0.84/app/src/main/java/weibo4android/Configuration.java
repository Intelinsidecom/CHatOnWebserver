package weibo4android;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.AccessControlException;
import java.util.Properties;

/* loaded from: classes.dex */
public class Configuration {
    private static boolean DALVIK;
    private static Properties defaultProperty;

    static {
        init();
    }

    static void init() throws ClassNotFoundException {
        defaultProperty = new Properties();
        defaultProperty.setProperty("weibo4j.debug", "true");
        defaultProperty.setProperty("weibo4j.source", Weibo.CONSUMER_KEY);
        defaultProperty.setProperty("weibo4j.clientURL", "http://open.t.sina.com.cn/-{weibo4j.clientVersion}.xml");
        defaultProperty.setProperty("weibo4j.http.userAgent", "weibo4j http://open.t.sina.com.cn/ /{weibo4j.clientVersion}");
        defaultProperty.setProperty("weibo4j.http.useSSL", "false");
        defaultProperty.setProperty("weibo4j.http.proxyHost.fallback", "http.proxyHost");
        defaultProperty.setProperty("weibo4j.http.proxyPort.fallback", "http.proxyPort");
        defaultProperty.setProperty("weibo4j.http.connectionTimeout", "20000");
        defaultProperty.setProperty("weibo4j.http.readTimeout", "120000");
        defaultProperty.setProperty("weibo4j.http.retryCount", "3");
        defaultProperty.setProperty("weibo4j.http.retryIntervalSecs", "10");
        defaultProperty.setProperty("weibo4j.async.numThreads", "1");
        defaultProperty.setProperty("weibo4j.clientVersion", Version.getVersion());
        try {
            Class.forName("dalvik.system.VMRuntime");
            defaultProperty.setProperty("weibo4j.dalvik", "true");
        } catch (ClassNotFoundException e) {
            defaultProperty.setProperty("weibo4j.dalvik", "false");
        }
        DALVIK = getBoolean("weibo4j.dalvik");
        if (loadProperties(defaultProperty, "." + File.separatorChar + "weibo4j.properties") || loadProperties(defaultProperty, Configuration.class.getResourceAsStream("/WEB-INF/weibo4j.properties")) || loadProperties(defaultProperty, Configuration.class.getResourceAsStream("/weibo4j.properties"))) {
        }
    }

    private static boolean loadProperties(Properties properties, String str) throws IOException {
        try {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                properties.load(new FileInputStream(file));
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    private static boolean loadProperties(Properties properties, InputStream inputStream) throws IOException {
        try {
            properties.load(inputStream);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isDalvik() {
        return DALVIK;
    }

    public static boolean useSSL() {
        return getBoolean("weibo4j.http.useSSL");
    }

    public static String getScheme() {
        return useSSL() ? "https://" : "http://";
    }

    public static String getCilentVersion() {
        return getProperty("weibo4j.clientVersion");
    }

    public static String getCilentVersion(String str) {
        return getProperty("weibo4j.clientVersion", str);
    }

    public static String getSource() {
        return getProperty("weibo4j.source");
    }

    public static String getSource(String str) {
        return getProperty("weibo4j.source", str);
    }

    public static String getProxyHost() {
        return getProperty("weibo4j.http.proxyHost");
    }

    public static String getProxyHost(String str) {
        return getProperty("weibo4j.http.proxyHost", str);
    }

    public static String getProxyUser() {
        return getProperty("weibo4j.http.proxyUser");
    }

    public static String getProxyUser(String str) {
        return getProperty("weibo4j.http.proxyUser", str);
    }

    public static String getClientURL() {
        return getProperty("weibo4j.clientURL");
    }

    public static String getClientURL(String str) {
        return getProperty("weibo4j.clientURL", str);
    }

    public static String getProxyPassword() {
        return getProperty("weibo4j.http.proxyPassword");
    }

    public static String getProxyPassword(String str) {
        return getProperty("weibo4j.http.proxyPassword", str);
    }

    public static int getProxyPort() {
        return getIntProperty("weibo4j.http.proxyPort");
    }

    public static int getProxyPort(int i) {
        return getIntProperty("weibo4j.http.proxyPort", i);
    }

    public static int getConnectionTimeout() {
        return getIntProperty("weibo4j.http.connectionTimeout");
    }

    public static int getConnectionTimeout(int i) {
        return getIntProperty("weibo4j.http.connectionTimeout", i);
    }

    public static int getReadTimeout() {
        return getIntProperty("weibo4j.http.readTimeout");
    }

    public static int getReadTimeout(int i) {
        return getIntProperty("weibo4j.http.readTimeout", i);
    }

    public static int getRetryCount() {
        return getIntProperty("weibo4j.http.retryCount");
    }

    public static int getRetryCount(int i) {
        return getIntProperty("weibo4j.http.retryCount", i);
    }

    public static int getRetryIntervalSecs() {
        return getIntProperty("weibo4j.http.retryIntervalSecs");
    }

    public static int getRetryIntervalSecs(int i) {
        return getIntProperty("weibo4j.http.retryIntervalSecs", i);
    }

    public static String getUser() {
        return getProperty("weibo4j.user");
    }

    public static String getUser(String str) {
        return getProperty("weibo4j.user", str);
    }

    public static String getPassword() {
        return getProperty("weibo4j.password");
    }

    public static String getPassword(String str) {
        return getProperty("weibo4j.password", str);
    }

    public static String getUserAgent() {
        return getProperty("weibo4j.http.userAgent");
    }

    public static String getUserAgent(String str) {
        return getProperty("weibo4j.http.userAgent", str);
    }

    public static String getOAuthConsumerKey() {
        return getProperty("weibo4j.oauth.consumerKey");
    }

    public static String getOAuthConsumerKey(String str) {
        return getProperty("weibo4j.oauth.consumerKey", str);
    }

    public static String getOAuthConsumerSecret() {
        return getProperty("weibo4j.oauth.consumerSecret");
    }

    public static String getOAuthConsumerSecret(String str) {
        return getProperty("weibo4j.oauth.consumerSecret", str);
    }

    public static boolean getBoolean(String str) {
        return Boolean.valueOf(getProperty(str)).booleanValue();
    }

    public static int getIntProperty(String str) {
        try {
            return Integer.parseInt(getProperty(str));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static int getIntProperty(String str, int i) {
        try {
            return Integer.parseInt(getProperty(str, String.valueOf(i)));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static long getLongProperty(String str) {
        try {
            return Long.parseLong(getProperty(str));
        } catch (NumberFormatException e) {
            return -1L;
        }
    }

    public static String getProperty(String str) {
        return getProperty(str, null);
    }

    public static String getProperty(String str, String str2) {
        String property;
        String property2;
        try {
            property = System.getProperty(str, str2);
            if (property == null) {
                property = defaultProperty.getProperty(str);
            }
            if (property == null && (property2 = defaultProperty.getProperty(str + ".fallback")) != null) {
                property = System.getProperty(property2);
            }
        } catch (AccessControlException e) {
            property = str2;
        }
        return replace(property);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String replace(java.lang.String r5) {
        /*
            r4 = 0
            if (r5 != 0) goto L4
        L3:
            return r5
        L4:
            r0 = -1
            java.lang.String r1 = "{"
            int r1 = r5.indexOf(r1, r4)
            if (r0 == r1) goto L51
            java.lang.String r0 = "}"
            int r0 = r5.indexOf(r0, r1)
            int r2 = r1 + 1
            if (r0 <= r2) goto L51
            int r2 = r1 + 1
            java.lang.String r2 = r5.substring(r2, r0)
            int r3 = r2.length()
            if (r3 <= 0) goto L51
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r1 = r5.substring(r4, r1)
            java.lang.StringBuilder r1 = r3.append(r1)
            java.lang.String r2 = getProperty(r2)
            java.lang.StringBuilder r1 = r1.append(r2)
            int r0 = r0 + 1
            java.lang.String r0 = r5.substring(r0)
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r0 = r0.toString()
        L46:
            boolean r1 = r0.equals(r5)
            if (r1 != 0) goto L3
            java.lang.String r5 = replace(r0)
            goto L3
        L51:
            r0 = r5
            goto L46
        */
        throw new UnsupportedOperationException("Method not decompiled: weibo4android.Configuration.replace(java.lang.String):java.lang.String");
    }

    public static int getNumberOfAsyncThreads() {
        return getIntProperty("weibo4j.async.numThreads");
    }

    public static boolean getDebug() {
        return getBoolean("weibo4j.debug");
    }
}
