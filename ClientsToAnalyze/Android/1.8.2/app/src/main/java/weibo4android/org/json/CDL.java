package weibo4android.org.json;

import com.sec.chaton.C0229at;
import java.io.IOException;

/* loaded from: classes.dex */
public class CDL {
    private static String getValue(JSONTokener jSONTokener) throws JSONException, IOException {
        char next;
        while (true) {
            next = jSONTokener.next();
            if (next != ' ' && next != '\t') {
                break;
            }
        }
        switch (next) {
            case 0:
                return null;
            case C0229at.HorizontalSrollView_android_minWidth /* 34 */:
            case C0229at.HorizontalSrollView_android_hapticFeedbackEnabled /* 39 */:
                return jSONTokener.nextString(next);
            case C0229at.HorizontalSrollView_android_fadeScrollbars /* 44 */:
                jSONTokener.back();
                return "";
            default:
                jSONTokener.back();
                return jSONTokener.nextTo(',');
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static weibo4android.org.json.JSONArray rowToJSONArray(weibo4android.org.json.JSONTokener r3) throws weibo4android.org.json.JSONException, java.io.IOException {
        /*
            weibo4android.org.json.JSONArray r0 = new weibo4android.org.json.JSONArray
            r0.<init>()
        L5:
            java.lang.String r1 = getValue(r3)
            if (r1 == 0) goto L17
            int r2 = r0.length()
            if (r2 != 0) goto L19
            int r2 = r1.length()
            if (r2 != 0) goto L19
        L17:
            r0 = 0
        L18:
            return r0
        L19:
            r0.put(r1)
        L1c:
            char r1 = r3.next()
            r2 = 44
            if (r1 == r2) goto L5
            r2 = 32
            if (r1 == r2) goto L1c
            r2 = 10
            if (r1 == r2) goto L18
            r2 = 13
            if (r1 == r2) goto L18
            if (r1 == 0) goto L18
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Bad character '"
            r0.<init>(r2)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r2 = "' ("
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = ")."
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            weibo4android.org.json.JSONException r0 = r3.syntaxError(r0)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: weibo4android.org.json.CDL.rowToJSONArray(weibo4android.org.json.JSONTokener):weibo4android.org.json.JSONArray");
    }

    public static JSONObject rowToJSONObject(JSONArray jSONArray, JSONTokener jSONTokener) throws JSONException, IOException {
        JSONArray jSONArrayRowToJSONArray = rowToJSONArray(jSONTokener);
        if (jSONArrayRowToJSONArray != null) {
            return jSONArrayRowToJSONArray.toJSONObject(jSONArray);
        }
        return null;
    }

    public static JSONArray toJSONArray(String str) {
        return toJSONArray(new JSONTokener(str));
    }

    public static JSONArray toJSONArray(JSONTokener jSONTokener) {
        return toJSONArray(rowToJSONArray(jSONTokener), jSONTokener);
    }

    public static JSONArray toJSONArray(JSONArray jSONArray, String str) {
        return toJSONArray(jSONArray, new JSONTokener(str));
    }

    public static JSONArray toJSONArray(JSONArray jSONArray, JSONTokener jSONTokener) throws JSONException, IOException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        JSONArray jSONArray2 = new JSONArray();
        while (true) {
            JSONObject jSONObjectRowToJSONObject = rowToJSONObject(jSONArray, jSONTokener);
            if (jSONObjectRowToJSONObject == null) {
                break;
            }
            jSONArray2.put(jSONObjectRowToJSONObject);
        }
        if (jSONArray2.length() != 0) {
            return jSONArray2;
        }
        return null;
    }

    public static String rowToString(JSONArray jSONArray) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < jSONArray.length(); i++) {
            if (i > 0) {
                stringBuffer.append(',');
            }
            Object objOpt = jSONArray.opt(i);
            if (objOpt != null) {
                String string = objOpt.toString();
                if (string.indexOf(44) >= 0) {
                    if (string.indexOf(34) >= 0) {
                        stringBuffer.append('\'');
                        stringBuffer.append(string);
                        stringBuffer.append('\'');
                    } else {
                        stringBuffer.append('\"');
                        stringBuffer.append(string);
                        stringBuffer.append('\"');
                    }
                } else {
                    stringBuffer.append(string);
                }
            }
        }
        stringBuffer.append('\n');
        return stringBuffer.toString();
    }

    public static String toString(JSONArray jSONArray) {
        JSONArray jSONArrayNames;
        JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(0);
        if (jSONObjectOptJSONObject == null || (jSONArrayNames = jSONObjectOptJSONObject.names()) == null) {
            return null;
        }
        return String.valueOf(rowToString(jSONArrayNames)) + toString(jSONArrayNames, jSONArray);
    }

    public static String toString(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < jSONArray2.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray2.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                stringBuffer.append(rowToString(jSONObjectOptJSONObject.toJSONArray(jSONArray)));
            }
        }
        return stringBuffer.toString();
    }
}
