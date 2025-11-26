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

    public Set<Cookie> decode(String str) throws NumberFormatException {
        int i;
        int i2;
        int i3;
        String str2;
        String str3;
        boolean z;
        boolean z2;
        boolean z3;
        int i4;
        String str4;
        ArrayList arrayList = new ArrayList(8);
        ArrayList arrayList2 = new ArrayList(8);
        extractKeyValuePairs(str, arrayList, arrayList2);
        if (arrayList.isEmpty()) {
            return Collections.emptySet();
        }
        if (arrayList.get(0).equalsIgnoreCase("Version")) {
            try {
                i2 = Integer.parseInt(arrayList2.get(0));
            } catch (NumberFormatException e) {
                i2 = 0;
            }
            i = 1;
        } else {
            i = 0;
            i2 = 0;
        }
        if (arrayList.size() <= i) {
            return Collections.emptySet();
        }
        TreeSet treeSet = new TreeSet();
        int i5 = i2;
        while (true) {
            int i6 = i;
            if (i6 >= arrayList.size()) {
                return treeSet;
            }
            String str5 = arrayList.get(i6);
            String str6 = arrayList2.get(i6);
            if (str6 == null) {
                str6 = "";
            }
            DefaultCookie defaultCookie = new DefaultCookie(str5, str6);
            treeSet.add(defaultCookie);
            boolean z4 = false;
            boolean z5 = false;
            boolean z6 = false;
            String str7 = null;
            String str8 = null;
            String str9 = null;
            String str10 = null;
            ArrayList arrayList3 = new ArrayList(2);
            int i7 = i6 + 1;
            int i8 = i6;
            int i9 = -1;
            while (i7 < arrayList.size()) {
                String str11 = arrayList.get(i7);
                String str12 = arrayList2.get(i7);
                if ("Discard".equalsIgnoreCase(str11)) {
                    str12 = str10;
                    str3 = str7;
                    z2 = true;
                    i3 = i9;
                    str2 = str8;
                    z = z5;
                    boolean z7 = z6;
                    i4 = i5;
                    str4 = str9;
                    z3 = z7;
                } else if ("Secure".equalsIgnoreCase(str11)) {
                    str12 = str10;
                    str3 = str7;
                    z2 = z4;
                    String str13 = str8;
                    z = true;
                    i3 = i9;
                    str2 = str13;
                    boolean z8 = z6;
                    i4 = i5;
                    str4 = str9;
                    z3 = z8;
                } else if ("HTTPOnly".equalsIgnoreCase(str11)) {
                    str12 = str10;
                    i4 = i5;
                    str4 = str9;
                    str3 = str7;
                    z3 = true;
                    z2 = z4;
                    i3 = i9;
                    str2 = str8;
                    z = z5;
                } else if ("Comment".equalsIgnoreCase(str11)) {
                    i3 = i9;
                    z2 = z4;
                    str2 = str8;
                    z = z5;
                    str12 = str10;
                    str3 = str12;
                    String str14 = str9;
                    z3 = z6;
                    i4 = i5;
                    str4 = str14;
                } else if ("CommentURL".equalsIgnoreCase(str11)) {
                    i3 = i9;
                    z = z5;
                    str2 = str12;
                    str12 = str10;
                    str3 = str7;
                    z2 = z4;
                    String str15 = str9;
                    z3 = z6;
                    i4 = i5;
                    str4 = str15;
                } else if ("Domain".equalsIgnoreCase(str11)) {
                    i3 = i9;
                    z3 = z6;
                    str2 = str8;
                    i4 = i5;
                    z = z5;
                    str4 = str12;
                    str12 = str10;
                    str3 = str7;
                    z2 = z4;
                } else if ("Path".equalsIgnoreCase(str11)) {
                    i3 = i9;
                    str3 = str7;
                    str2 = str8;
                    z2 = z4;
                    z = z5;
                    boolean z9 = z6;
                    i4 = i5;
                    str4 = str9;
                    z3 = z9;
                } else if ("Expires".equalsIgnoreCase(str11)) {
                    try {
                        long time = new CookieDateFormat().parse(str12).getTime() - System.currentTimeMillis();
                        if (time <= 0) {
                            i3 = 0;
                        } else {
                            i3 = (time % 1000 != 0 ? 1 : 0) + ((int) (time / 1000));
                        }
                        str12 = str10;
                        str2 = str8;
                        str3 = str7;
                        z = z5;
                        z2 = z4;
                        String str16 = str9;
                        z3 = z6;
                        i4 = i5;
                        str4 = str16;
                    } catch (ParseException e2) {
                        i3 = i9;
                        str12 = str10;
                        str2 = str8;
                        str3 = str7;
                        z = z5;
                        z2 = z4;
                        String str17 = str9;
                        z3 = z6;
                        i4 = i5;
                        str4 = str17;
                    }
                } else if ("Max-Age".equalsIgnoreCase(str11)) {
                    i3 = Integer.parseInt(str12);
                    str12 = str10;
                    str2 = str8;
                    str3 = str7;
                    z = z5;
                    z2 = z4;
                    String str18 = str9;
                    z3 = z6;
                    i4 = i5;
                    str4 = str18;
                } else if ("Version".equalsIgnoreCase(str11)) {
                    int i10 = Integer.parseInt(str12);
                    i3 = i9;
                    str12 = str10;
                    str2 = str8;
                    str3 = str7;
                    z = z5;
                    z2 = z4;
                    String str19 = str9;
                    z3 = z6;
                    i4 = i10;
                    str4 = str19;
                } else {
                    if (!"Port".equalsIgnoreCase(str11)) {
                        break;
                    }
                    for (String str20 : str12.split(COMMA)) {
                        try {
                            arrayList3.add(Integer.valueOf(str20));
                        } catch (NumberFormatException e3) {
                        }
                    }
                    i3 = i9;
                    str12 = str10;
                    str2 = str8;
                    str3 = str7;
                    z = z5;
                    z2 = z4;
                    String str21 = str9;
                    z3 = z6;
                    i4 = i5;
                    str4 = str21;
                }
                i7++;
                i8++;
                z5 = z;
                z4 = z2;
                str8 = str2;
                str7 = str3;
                str10 = str12;
                i9 = i3;
                String str22 = str4;
                i5 = i4;
                z6 = z3;
                str9 = str22;
            }
            defaultCookie.setVersion(i5);
            defaultCookie.setMaxAge(i9);
            defaultCookie.setPath(str10);
            defaultCookie.setDomain(str9);
            defaultCookie.setSecure(z5);
            defaultCookie.setHttpOnly(z6);
            if (i5 > 0) {
                defaultCookie.setComment(str7);
            }
            if (i5 > 1) {
                defaultCookie.setCommentUrl(str8);
                defaultCookie.setPorts(arrayList3);
                defaultCookie.setDiscard(z4);
            }
            i = i8 + 1;
        }
    }

    private void extractKeyValuePairs(String str, List<String> list, List<String> list2) {
        String str2 = null;
        Matcher matcher = PATTERN.matcher(str);
        int i = 0;
        String str3 = null;
        String str4 = null;
        while (matcher.find(i)) {
            int iEnd = matcher.end();
            String strGroup = matcher.group(1);
            String strGroup2 = matcher.group(3);
            if (strGroup2 == null) {
                strGroup2 = decodeValue(matcher.group(2));
            }
            String strGroup3 = matcher.group(4);
            if (str4 == null) {
                str3 = strGroup2 == null ? "" : strGroup2;
                str4 = strGroup;
                str2 = strGroup3;
                i = iEnd;
            } else if (strGroup2 == null && !"Discard".equalsIgnoreCase(strGroup) && !"Secure".equalsIgnoreCase(strGroup) && !"HTTPOnly".equalsIgnoreCase(strGroup)) {
                str3 = str3 + str2 + strGroup;
                str2 = strGroup3;
                i = iEnd;
            } else {
                list.add(str4);
                list2.add(str3);
                str2 = strGroup3;
                str3 = strGroup2;
                str4 = strGroup;
                i = iEnd;
            }
        }
        if (str4 != null) {
            list.add(str4);
            list2.add(str3);
        }
    }

    private String decodeValue(String str) {
        return str == null ? str : str.replace("\\\"", "\"").replace("\\\\", "\\");
    }
}
