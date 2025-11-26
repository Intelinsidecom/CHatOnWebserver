package weibo4android.org.json;

import java.util.Iterator;

/* loaded from: classes.dex */
public class XML {
    public static final Character AMP = new Character('&');
    public static final Character APOS = new Character('\'');
    public static final Character BANG = new Character('!');

    /* renamed from: EQ */
    public static final Character f13762EQ = new Character('=');

    /* renamed from: GT */
    public static final Character f13763GT = new Character('>');

    /* renamed from: LT */
    public static final Character f13764LT = new Character('<');
    public static final Character QUEST = new Character('?');
    public static final Character QUOT = new Character('\"');
    public static final Character SLASH = new Character('/');

    public static String escape(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            switch (cCharAt) {
                case '\"':
                    stringBuffer.append("&quot;");
                    break;
                case '&':
                    stringBuffer.append("&amp;");
                    break;
                case '<':
                    stringBuffer.append("&lt;");
                    break;
                case '>':
                    stringBuffer.append("&gt;");
                    break;
                default:
                    stringBuffer.append(cCharAt);
                    break;
            }
        }
        return stringBuffer.toString();
    }

    public static void noSpace(String str) throws JSONException {
        int length = str.length();
        if (length == 0) {
            throw new JSONException("Empty string.");
        }
        for (int i = 0; i < length; i++) {
            if (Character.isWhitespace(str.charAt(i))) {
                throw new JSONException("'" + str + "' contains a space character.");
            }
        }
    }

    private static boolean parse(XMLTokener xMLTokener, JSONObject jSONObject, String str) throws JSONException {
        Object objNextToken = xMLTokener.nextToken();
        if (objNextToken == BANG) {
            char next = xMLTokener.next();
            if (next == '-') {
                if (xMLTokener.next() == '-') {
                    xMLTokener.skipPast("-->");
                    return false;
                }
                xMLTokener.back();
            } else if (next == '[') {
                if (xMLTokener.nextToken().equals("CDATA") && xMLTokener.next() == '[') {
                    String strNextCDATA = xMLTokener.nextCDATA();
                    if (strNextCDATA.length() > 0) {
                        jSONObject.accumulate("content", strNextCDATA);
                    }
                    return false;
                }
                throw xMLTokener.syntaxError("Expected 'CDATA['");
            }
            int i = 1;
            do {
                Object objNextMeta = xMLTokener.nextMeta();
                if (objNextMeta == null) {
                    throw xMLTokener.syntaxError("Missing '>' after '<!'.");
                }
                if (objNextMeta == f13764LT) {
                    i++;
                } else if (objNextMeta == f13763GT) {
                    i--;
                }
            } while (i > 0);
            return false;
        }
        if (objNextToken == QUEST) {
            xMLTokener.skipPast("?>");
            return false;
        }
        if (objNextToken == SLASH) {
            Object objNextToken2 = xMLTokener.nextToken();
            if (str == null) {
                throw xMLTokener.syntaxError("Mismatched close tag" + objNextToken2);
            }
            if (!objNextToken2.equals(str)) {
                throw xMLTokener.syntaxError("Mismatched " + str + " and " + objNextToken2);
            }
            if (xMLTokener.nextToken() != f13763GT) {
                throw xMLTokener.syntaxError("Misshaped close tag");
            }
            return true;
        }
        if (objNextToken instanceof Character) {
            throw xMLTokener.syntaxError("Misshaped tag");
        }
        String str2 = (String) objNextToken;
        JSONObject jSONObject2 = new JSONObject();
        Object objNextToken3 = null;
        while (true) {
            if (objNextToken3 == null) {
                objNextToken3 = xMLTokener.nextToken();
            }
            if (objNextToken3 instanceof String) {
                String str3 = (String) objNextToken3;
                Object objNextToken4 = xMLTokener.nextToken();
                if (objNextToken4 == f13762EQ) {
                    Object objNextToken5 = xMLTokener.nextToken();
                    if (!(objNextToken5 instanceof String)) {
                        throw xMLTokener.syntaxError("Missing value");
                    }
                    jSONObject2.accumulate(str3, JSONObject.stringToValue((String) objNextToken5));
                    objNextToken3 = null;
                } else {
                    jSONObject2.accumulate(str3, "");
                    objNextToken3 = objNextToken4;
                }
            } else {
                if (objNextToken3 == SLASH) {
                    if (xMLTokener.nextToken() != f13763GT) {
                        throw xMLTokener.syntaxError("Misshaped tag");
                    }
                    jSONObject.accumulate(str2, jSONObject2);
                    return false;
                }
                if (objNextToken3 != f13763GT) {
                    throw xMLTokener.syntaxError("Misshaped tag");
                }
                while (true) {
                    Object objNextContent = xMLTokener.nextContent();
                    if (objNextContent == null) {
                        if (str2 != null) {
                            throw xMLTokener.syntaxError("Unclosed tag " + str2);
                        }
                        return false;
                    }
                    if (objNextContent instanceof String) {
                        String str4 = (String) objNextContent;
                        if (str4.length() > 0) {
                            jSONObject2.accumulate("content", JSONObject.stringToValue(str4));
                        }
                    } else if (objNextContent == f13764LT && parse(xMLTokener, jSONObject2, str2)) {
                        if (jSONObject2.length() == 0) {
                            jSONObject.accumulate(str2, "");
                        } else if (jSONObject2.length() == 1 && jSONObject2.opt("content") != null) {
                            jSONObject.accumulate(str2, jSONObject2.opt("content"));
                        } else {
                            jSONObject.accumulate(str2, jSONObject2);
                        }
                        return false;
                    }
                }
            }
        }
    }

    public static JSONObject toJSONObject(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        XMLTokener xMLTokener = new XMLTokener(str);
        while (xMLTokener.more() && xMLTokener.skipPast("<")) {
            parse(xMLTokener, jSONObject, null);
        }
        return jSONObject;
    }

    public static String toString(Object obj) {
        return toString(obj, null);
    }

    public static String toString(Object obj, String str) throws JSONException {
        StringBuffer stringBuffer = new StringBuffer();
        if (obj instanceof JSONObject) {
            if (str != null) {
                stringBuffer.append('<');
                stringBuffer.append(str);
                stringBuffer.append('>');
            }
            JSONObject jSONObject = (JSONObject) obj;
            Iterator itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String string = itKeys.next().toString();
                Object objOpt = jSONObject.opt(string);
                if (objOpt == null) {
                    objOpt = "";
                }
                if (objOpt instanceof String) {
                }
                if (string.equals("content")) {
                    if (objOpt instanceof JSONArray) {
                        JSONArray jSONArray = (JSONArray) objOpt;
                        int length = jSONArray.length();
                        for (int i = 0; i < length; i++) {
                            if (i > 0) {
                                stringBuffer.append('\n');
                            }
                            stringBuffer.append(escape(jSONArray.get(i).toString()));
                        }
                    } else {
                        stringBuffer.append(escape(objOpt.toString()));
                    }
                } else if (objOpt instanceof JSONArray) {
                    JSONArray jSONArray2 = (JSONArray) objOpt;
                    int length2 = jSONArray2.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        Object obj2 = jSONArray2.get(i2);
                        if (obj2 instanceof JSONArray) {
                            stringBuffer.append('<');
                            stringBuffer.append(string);
                            stringBuffer.append('>');
                            stringBuffer.append(toString(obj2));
                            stringBuffer.append("</");
                            stringBuffer.append(string);
                            stringBuffer.append('>');
                        } else {
                            stringBuffer.append(toString(obj2, string));
                        }
                    }
                } else if (objOpt.equals("")) {
                    stringBuffer.append('<');
                    stringBuffer.append(string);
                    stringBuffer.append("/>");
                } else {
                    stringBuffer.append(toString(objOpt, string));
                }
            }
            if (str != null) {
                stringBuffer.append("</");
                stringBuffer.append(str);
                stringBuffer.append('>');
            }
            return stringBuffer.toString();
        }
        if (obj instanceof JSONArray) {
            JSONArray jSONArray3 = (JSONArray) obj;
            int length3 = jSONArray3.length();
            for (int i3 = 0; i3 < length3; i3++) {
                stringBuffer.append(toString(jSONArray3.opt(i3), str == null ? "array" : str));
            }
            return stringBuffer.toString();
        }
        String strEscape = obj == null ? "null" : escape(obj.toString());
        return str == null ? "\"" + strEscape + "\"" : strEscape.length() == 0 ? "<" + str + "/>" : "<" + str + ">" + strEscape + "</" + str + ">";
    }
}
