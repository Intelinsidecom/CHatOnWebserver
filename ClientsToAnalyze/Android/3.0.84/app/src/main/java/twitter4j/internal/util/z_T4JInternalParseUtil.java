package twitter4j.internal.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;
import twitter4j.TwitterException;
import twitter4j.internal.http.HTMLEntity;
import twitter4j.internal.http.HttpResponse;

/* loaded from: classes.dex */
public final class z_T4JInternalParseUtil {
    private static ThreadLocal<Map<String, SimpleDateFormat>> formatMap = new ThreadLocal<Map<String, SimpleDateFormat>>() { // from class: twitter4j.internal.util.z_T4JInternalParseUtil.1
        @Override // java.lang.ThreadLocal
        protected Map<String, SimpleDateFormat> initialValue() {
            return initialValue2();
        }

        @Override // java.lang.ThreadLocal
        /* renamed from: initialValue, reason: avoid collision after fix types in other method */
        protected Map<String, SimpleDateFormat> initialValue2() {
            return new HashMap();
        }
    };

    private z_T4JInternalParseUtil() {
        throw new AssertionError();
    }

    public static String getUnescapedString(String str, JSONObject jSONObject) {
        return HTMLEntity.unescape(getRawString(str, jSONObject));
    }

    public static String getRawString(String str, JSONObject jSONObject) {
        try {
            if (jSONObject.isNull(str)) {
                return null;
            }
            return jSONObject.getString(str);
        } catch (JSONException e) {
            return null;
        }
    }

    public static String getURLDecodedString(String str, JSONObject jSONObject) {
        String rawString = getRawString(str, jSONObject);
        if (rawString != null) {
            try {
                return URLDecoder.decode(rawString, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                return rawString;
            }
        }
        return rawString;
    }

    public static Date parseTrendsDate(String str) {
        switch (str.length()) {
            case 10:
                return new Date(Long.parseLong(str) * 1000);
            case 20:
                return getDate(str, "yyyy-MM-dd'T'HH:mm:ss'Z'");
            default:
                return getDate(str, "EEE, d MMM yyyy HH:mm:ss z");
        }
    }

    public static Date getDate(String str, JSONObject jSONObject) {
        return getDate(str, jSONObject, "EEE MMM d HH:mm:ss z yyyy");
    }

    public static Date getDate(String str, JSONObject jSONObject, String str2) {
        String unescapedString = getUnescapedString(str, jSONObject);
        if ("null".equals(unescapedString) || unescapedString == null) {
            return null;
        }
        return getDate(unescapedString, str2);
    }

    public static Date getDate(String str, String str2) throws TwitterException {
        SimpleDateFormat simpleDateFormat = formatMap.get().get(str2);
        if (simpleDateFormat == null) {
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(str2, Locale.ENGLISH);
            simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("GMT"));
            formatMap.get().put(str2, simpleDateFormat2);
            simpleDateFormat = simpleDateFormat2;
        }
        try {
            return simpleDateFormat.parse(str);
        } catch (ParseException e) {
            throw new TwitterException(new StringBuffer().append("Unexpected date format(").append(str).append(") returned from twitter.com").toString(), e);
        }
    }

    public static int getInt(String str, JSONObject jSONObject) {
        return getInt(getRawString(str, jSONObject));
    }

    public static int getInt(String str) {
        if (str == null || "".equals(str) || "null".equals(str)) {
            return -1;
        }
        try {
            return Integer.valueOf(str).intValue();
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static long getLong(String str, JSONObject jSONObject) {
        return getLong(getRawString(str, jSONObject));
    }

    public static long getLong(String str) {
        if (str == null || "".equals(str) || "null".equals(str)) {
            return -1L;
        }
        if (str.endsWith("+")) {
            return Long.valueOf(str.substring(0, str.length() - 1)).longValue() + 1;
        }
        return Long.valueOf(str).longValue();
    }

    public static double getDouble(String str, JSONObject jSONObject) {
        String rawString = getRawString(str, jSONObject);
        if (rawString == null || "".equals(rawString) || "null".equals(rawString)) {
            return -1.0d;
        }
        return Double.valueOf(rawString).doubleValue();
    }

    public static boolean getBoolean(String str, JSONObject jSONObject) {
        String rawString = getRawString(str, jSONObject);
        if (rawString == null || "null".equals(rawString)) {
            return false;
        }
        return Boolean.valueOf(rawString).booleanValue();
    }

    public static int toAccessLevel(HttpResponse httpResponse) {
        if (httpResponse == null) {
            return -1;
        }
        String responseHeader = httpResponse.getResponseHeader("X-Access-Level");
        if (responseHeader == null) {
            return 0;
        }
        switch (responseHeader.length()) {
            case 4:
                return 1;
            case 10:
                return 2;
            case 25:
                return 3;
            case 26:
                return 3;
            default:
                return 0;
        }
    }
}
