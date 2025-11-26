package org.jboss.netty.handler.codec.http;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class CookieDecoder {
    private static final String COMMA = ",";
    private static final Pattern PATTERN = Pattern.compile("(?:\\s|[;,])*\\$*([^;=]+)(?:=(?:[\"']((?:\\\\.|[^\"])*)[\"']|([^;,]*)))?(\\s*(?:[;,]+\\s*|$))");

    private String decodeValue(String str) {
        return str == null ? str : str.replace("\\\"", "\"").replace("\\\\", "\\");
    }

    private void extractKeyValuePairs(String str, List list, List list2) {
        String str2 = null;
        Matcher matcher = PATTERN.matcher(str);
        String str3 = null;
        int iEnd = 0;
        String str4 = null;
        while (matcher.find(iEnd)) {
            iEnd = matcher.end();
            String strGroup = matcher.group(1);
            String strGroup2 = matcher.group(3);
            if (strGroup2 == null) {
                strGroup2 = decodeValue(matcher.group(2));
            }
            String strGroup3 = matcher.group(4);
            if (str3 == null) {
                str2 = strGroup2 == null ? "" : strGroup2;
                str3 = strGroup;
                str4 = strGroup3;
            } else if (strGroup2 != null || "Discard".equalsIgnoreCase(strGroup) || "Secure".equalsIgnoreCase(strGroup) || "HTTPOnly".equalsIgnoreCase(strGroup)) {
                list.add(str3);
                list2.add(str2);
                str4 = strGroup3;
                str2 = strGroup2;
                str3 = strGroup;
            } else {
                str2 = str2 + str4 + strGroup;
                str4 = strGroup3;
            }
        }
        if (str3 != null) {
            list.add(str3);
            list2.add(str2);
        }
    }

    public Set decode(String str) throws NumberFormatException {
        int i;
        ArrayList arrayList = new ArrayList(8);
        ArrayList arrayList2 = new ArrayList(8);
        extractKeyValuePairs(str, arrayList, arrayList2);
        if (arrayList.isEmpty()) {
            return Collections.emptySet();
        }
        int i2 = 0;
        if (((String) arrayList.get(0)).equalsIgnoreCase("Version")) {
            try {
                i2 = Integer.parseInt((String) arrayList2.get(0));
            } catch (NumberFormatException e) {
            }
            i = 1;
        } else {
            i = 0;
        }
        if (arrayList.size() <= i) {
            return Collections.emptySet();
        }
        TreeSet treeSet = new TreeSet();
        while (i < arrayList.size()) {
            String str2 = (String) arrayList.get(i);
            String str3 = (String) arrayList2.get(i);
            DefaultCookie defaultCookie = new DefaultCookie(str2, str3 == null ? "" : str3);
            treeSet.add(defaultCookie);
            String str4 = null;
            ArrayList arrayList3 = new ArrayList(2);
            int i3 = i + 1;
            int i4 = i;
            int i5 = -1;
            int i6 = i2;
            int i7 = i3;
            boolean z = false;
            String str5 = null;
            String str6 = null;
            boolean z2 = false;
            boolean z3 = false;
            String str7 = null;
            while (i7 < arrayList.size()) {
                String str8 = (String) arrayList.get(i7);
                String str9 = (String) arrayList2.get(i7);
                if ("Discard".equalsIgnoreCase(str8)) {
                    z3 = true;
                } else if ("Secure".equalsIgnoreCase(str8)) {
                    z2 = true;
                } else if ("HTTPOnly".equalsIgnoreCase(str8)) {
                    z = true;
                } else if ("Comment".equalsIgnoreCase(str8)) {
                    str4 = str9;
                } else if ("CommentURL".equalsIgnoreCase(str8)) {
                    str5 = str9;
                } else if ("Domain".equalsIgnoreCase(str8)) {
                    str6 = str9;
                } else if ("Path".equalsIgnoreCase(str8)) {
                    str7 = str9;
                } else if ("Expires".equalsIgnoreCase(str8)) {
                    try {
                        long time = new CookieDateFormat().parse(str9).getTime() - System.currentTimeMillis();
                        if (time <= 0) {
                            i5 = 0;
                        } else {
                            i5 = (time % 1000 != 0 ? 1 : 0) + ((int) (time / 1000));
                        }
                    } catch (ParseException e2) {
                    }
                } else if ("Max-Age".equalsIgnoreCase(str8)) {
                    i5 = Integer.parseInt(str9);
                } else if (!"Version".equalsIgnoreCase(str8)) {
                    if (!"Port".equalsIgnoreCase(str8)) {
                        break;
                    }
                    for (String str10 : str9.split(COMMA)) {
                        try {
                            arrayList3.add(Integer.valueOf(str10));
                        } catch (NumberFormatException e3) {
                        }
                    }
                } else {
                    i6 = Integer.parseInt(str9);
                }
                i7++;
                i4++;
            }
            defaultCookie.setVersion(i6);
            defaultCookie.setMaxAge(i5);
            defaultCookie.setPath(str7);
            defaultCookie.setDomain(str6);
            defaultCookie.setSecure(z2);
            defaultCookie.setHttpOnly(z);
            if (i6 > 0) {
                defaultCookie.setComment(str4);
            }
            if (i6 > 1) {
                defaultCookie.setCommentUrl(str5);
                defaultCookie.setPorts(arrayList3);
                defaultCookie.setDiscard(z3);
            }
            i = i4 + 1;
            i2 = i6;
        }
        return treeSet;
    }
}
