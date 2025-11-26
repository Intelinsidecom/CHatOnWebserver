package weibo4android.org.json;

import java.util.Iterator;

/* loaded from: classes.dex */
public class JSONML {
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0088, code lost:
    
        throw r9.syntaxError("Expected 'CDATA['");
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x013d, code lost:
    
        throw r9.syntaxError("Reserved attribute.");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.Object parse(weibo4android.org.json.XMLTokener r9, boolean r10, weibo4android.org.json.JSONArray r11) throws weibo4android.org.json.JSONException {
        /*
            Method dump skipped, instructions count: 466
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: weibo4android.org.json.JSONML.parse(weibo4android.org.json.XMLTokener, boolean, weibo4android.org.json.JSONArray):java.lang.Object");
    }

    public static JSONArray toJSONArray(String str) {
        return toJSONArray(new XMLTokener(str));
    }

    public static JSONArray toJSONArray(XMLTokener xMLTokener) {
        return (JSONArray) parse(xMLTokener, true, null);
    }

    public static JSONObject toJSONObject(XMLTokener xMLTokener) {
        return (JSONObject) parse(xMLTokener, false, null);
    }

    public static JSONObject toJSONObject(String str) {
        return toJSONObject(new XMLTokener(str));
    }

    public static String toString(JSONArray jSONArray) throws JSONException {
        int i;
        StringBuffer stringBuffer = new StringBuffer();
        String string = jSONArray.getString(0);
        XML.noSpace(string);
        String strEscape = XML.escape(string);
        stringBuffer.append('<');
        stringBuffer.append(strEscape);
        Object objOpt = jSONArray.opt(1);
        if (objOpt instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) objOpt;
            Iterator itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String string2 = itKeys.next().toString();
                XML.noSpace(string2);
                String strOptString = jSONObject.optString(string2);
                if (strOptString != null) {
                    stringBuffer.append(' ');
                    stringBuffer.append(XML.escape(string2));
                    stringBuffer.append('=');
                    stringBuffer.append('\"');
                    stringBuffer.append(XML.escape(strOptString));
                    stringBuffer.append('\"');
                }
            }
            i = 2;
        } else {
            i = 1;
        }
        int length = jSONArray.length();
        if (i >= length) {
            stringBuffer.append('/');
            stringBuffer.append('>');
        } else {
            stringBuffer.append('>');
            int i2 = i;
            do {
                Object obj = jSONArray.get(i2);
                i2++;
                if (obj != null) {
                    if (obj instanceof String) {
                        stringBuffer.append(XML.escape(obj.toString()));
                    } else if (obj instanceof JSONObject) {
                        stringBuffer.append(toString((JSONObject) obj));
                    } else if (obj instanceof JSONArray) {
                        stringBuffer.append(toString((JSONArray) obj));
                    }
                }
            } while (i2 < length);
            stringBuffer.append('<');
            stringBuffer.append('/');
            stringBuffer.append(strEscape);
            stringBuffer.append('>');
        }
        return stringBuffer.toString();
    }

    public static String toString(JSONObject jSONObject) throws JSONException {
        StringBuffer stringBuffer = new StringBuffer();
        String strOptString = jSONObject.optString("tagName");
        if (strOptString == null) {
            return XML.escape(jSONObject.toString());
        }
        XML.noSpace(strOptString);
        String strEscape = XML.escape(strOptString);
        stringBuffer.append('<');
        stringBuffer.append(strEscape);
        Iterator itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String string = itKeys.next().toString();
            if (!string.equals("tagName") && !string.equals("childNodes")) {
                XML.noSpace(string);
                String strOptString2 = jSONObject.optString(string);
                if (strOptString2 != null) {
                    stringBuffer.append(' ');
                    stringBuffer.append(XML.escape(string));
                    stringBuffer.append('=');
                    stringBuffer.append('\"');
                    stringBuffer.append(XML.escape(strOptString2));
                    stringBuffer.append('\"');
                }
            }
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("childNodes");
        if (jSONArrayOptJSONArray == null) {
            stringBuffer.append('/');
            stringBuffer.append('>');
        } else {
            stringBuffer.append('>');
            int length = jSONArrayOptJSONArray.length();
            for (int i = 0; i < length; i++) {
                Object obj = jSONArrayOptJSONArray.get(i);
                if (obj != null) {
                    if (obj instanceof String) {
                        stringBuffer.append(XML.escape(obj.toString()));
                    } else if (obj instanceof JSONObject) {
                        stringBuffer.append(toString((JSONObject) obj));
                    } else if (obj instanceof JSONArray) {
                        stringBuffer.append(toString((JSONArray) obj));
                    }
                }
            }
            stringBuffer.append('<');
            stringBuffer.append('/');
            stringBuffer.append(strEscape);
            stringBuffer.append('>');
        }
        return stringBuffer.toString();
    }
}
