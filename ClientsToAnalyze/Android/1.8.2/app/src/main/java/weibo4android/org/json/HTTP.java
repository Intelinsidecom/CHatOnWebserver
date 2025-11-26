package weibo4android.org.json;

import java.util.Iterator;

/* loaded from: classes.dex */
public class HTTP {
    public static final String CRLF = "\r\n";

    public static JSONObject toJSONObject(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        HTTPTokener hTTPTokener = new HTTPTokener(str);
        String strNextToken = hTTPTokener.nextToken();
        if (strNextToken.toUpperCase().startsWith("HTTP")) {
            jSONObject.put("HTTP-Version", strNextToken);
            jSONObject.put("Status-Code", hTTPTokener.nextToken());
            jSONObject.put("Reason-Phrase", hTTPTokener.nextTo((char) 0));
            hTTPTokener.next();
        } else {
            jSONObject.put("Method", strNextToken);
            jSONObject.put("Request-URI", hTTPTokener.nextToken());
            jSONObject.put("HTTP-Version", hTTPTokener.nextToken());
        }
        while (hTTPTokener.more()) {
            String strNextTo = hTTPTokener.nextTo(':');
            hTTPTokener.next(':');
            jSONObject.put(strNextTo, hTTPTokener.nextTo((char) 0));
            hTTPTokener.next();
        }
        return jSONObject;
    }

    public static String toString(JSONObject jSONObject) throws JSONException {
        Iterator itKeys = jSONObject.keys();
        StringBuffer stringBuffer = new StringBuffer();
        if (jSONObject.has("Status-Code") && jSONObject.has("Reason-Phrase")) {
            stringBuffer.append(jSONObject.getString("HTTP-Version"));
            stringBuffer.append(' ');
            stringBuffer.append(jSONObject.getString("Status-Code"));
            stringBuffer.append(' ');
            stringBuffer.append(jSONObject.getString("Reason-Phrase"));
        } else if (jSONObject.has("Method") && jSONObject.has("Request-URI")) {
            stringBuffer.append(jSONObject.getString("Method"));
            stringBuffer.append(' ');
            stringBuffer.append('\"');
            stringBuffer.append(jSONObject.getString("Request-URI"));
            stringBuffer.append('\"');
            stringBuffer.append(' ');
            stringBuffer.append(jSONObject.getString("HTTP-Version"));
        } else {
            throw new JSONException("Not enough material for an HTTP header.");
        }
        stringBuffer.append(CRLF);
        while (itKeys.hasNext()) {
            String string = itKeys.next().toString();
            if (!string.equals("HTTP-Version") && !string.equals("Status-Code") && !string.equals("Reason-Phrase") && !string.equals("Method") && !string.equals("Request-URI") && !jSONObject.isNull(string)) {
                stringBuffer.append(string);
                stringBuffer.append(": ");
                stringBuffer.append(jSONObject.getString(string));
                stringBuffer.append(CRLF);
            }
        }
        stringBuffer.append(CRLF);
        return stringBuffer.toString();
    }
}
