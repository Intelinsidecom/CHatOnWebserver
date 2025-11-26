package com.vlingo.sdk.internal.util;

/* loaded from: classes.dex */
public class XmlUtils {
    public static String xmlEncode(String str) {
        if (str == null) {
            return null;
        }
        StringBuffer sb = new StringBuffer(str.length());
        xmlEncode(str, sb);
        return sb.toString();
    }

    public static void xmlEncode(String str, StringBuffer sb) {
        if (str != null) {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == '\"') {
                    sb.append("&quot;");
                } else if (c == '\'') {
                    sb.append("&apos;");
                } else if (c == '&') {
                    sb.append("&amp;");
                } else if (c == '<') {
                    sb.append("&lt;");
                } else if (c == '>') {
                    sb.append("&gt;");
                } else if (c > 31) {
                    sb.append(c);
                }
            }
        }
    }

    public static void xmlEncode(String str, StringBuilder sb) {
        if (str != null) {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == '\"') {
                    sb.append("&quot;");
                } else if (c == '\'') {
                    sb.append("&apos;");
                } else if (c == '&') {
                    sb.append("&amp;");
                } else if (c == '<') {
                    sb.append("&lt;");
                } else if (c == '>') {
                    sb.append("&gt;");
                } else if (c > 31) {
                    sb.append(c);
                }
            }
        }
    }

    public static String xmlDecode(String str) {
        if (str == null) {
            return null;
        }
        StringBuffer sb = new StringBuffer(str.length());
        xmlDecode(str, sb);
        return sb.toString();
    }

    public static void xmlDecode(String str, StringBuffer sb) {
        if (str != null) {
            int i = 0;
            while (i < str.length()) {
                char c = str.charAt(i);
                if (c == '&') {
                    String substr = str.substring(i);
                    if (substr.startsWith("&quot;")) {
                        i += 5;
                        sb.append('\"');
                    } else if (substr.startsWith("&apos;")) {
                        i += 5;
                        sb.append('\'');
                    } else if (substr.startsWith("&amp;")) {
                        i += 4;
                        sb.append('&');
                    } else if (substr.startsWith("&lt;")) {
                        i += 3;
                        sb.append('<');
                    } else if (substr.startsWith("&gt;")) {
                        i += 3;
                        sb.append('>');
                    } else {
                        sb.append(c);
                    }
                } else {
                    sb.append(c);
                }
                i++;
            }
        }
    }

    public static String wrapInCDATA(String data) {
        StringBuffer buff = new StringBuffer();
        buff.append("<![CDATA[");
        buff.append(StringUtils.replace(data, "]]>", "]]]><![CDATA[]>"));
        buff.append("]]>");
        return buff.toString();
    }
}
