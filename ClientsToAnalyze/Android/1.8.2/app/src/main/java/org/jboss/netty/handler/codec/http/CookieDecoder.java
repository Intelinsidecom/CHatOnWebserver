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
    private final boolean lenient;

    public CookieDecoder() {
        this(false);
    }

    public CookieDecoder(boolean z) {
        this.lenient = z;
    }

    public Set decode(String str) throws NumberFormatException {
        int i;
        int i2;
        int i3;
        int i4;
        String str2;
        String str3;
        String str4;
        boolean z;
        boolean z2;
        boolean z3;
        int i5;
        ArrayList arrayList = new ArrayList(8);
        ArrayList arrayList2 = new ArrayList(8);
        extractKeyValuePairs(str, arrayList, arrayList2);
        if (arrayList.isEmpty()) {
            return Collections.emptySet();
        }
        if (((String) arrayList.get(0)).equalsIgnoreCase("Version")) {
            try {
                i2 = Integer.parseInt((String) arrayList2.get(0));
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
        while (true) {
            int i6 = i2;
            int i7 = i;
            if (i7 >= arrayList.size()) {
                return treeSet;
            }
            String str5 = (String) arrayList.get(i7);
            if (this.lenient && "HTTPOnly".equalsIgnoreCase(str5)) {
                i2 = i6;
                i3 = i7;
            } else {
                String str6 = (String) arrayList2.get(i7);
                if (str6 == null) {
                    str6 = "";
                }
                DefaultCookie defaultCookie = new DefaultCookie(str5, str6);
                treeSet.add(defaultCookie);
                ArrayList arrayList3 = new ArrayList(2);
                int i8 = i7 + 1;
                i3 = i7;
                String str7 = null;
                String str8 = null;
                String str9 = null;
                String str10 = null;
                boolean z4 = false;
                boolean z5 = false;
                boolean z6 = false;
                int i9 = i6;
                int i10 = -1;
                while (i8 < arrayList.size()) {
                    String str11 = (String) arrayList.get(i8);
                    String str12 = (String) arrayList2.get(i8);
                    if ("Discard".equalsIgnoreCase(str11)) {
                        str12 = str7;
                        str3 = str9;
                        z = z4;
                        z3 = true;
                        i4 = i10;
                        str2 = str8;
                        str4 = str10;
                        z2 = z5;
                        i5 = i9;
                    } else if ("Secure".equalsIgnoreCase(str11)) {
                        str12 = str7;
                        i5 = i9;
                        str3 = str9;
                        z = z4;
                        z3 = z6;
                        String str13 = str8;
                        str4 = str10;
                        z2 = true;
                        i4 = i10;
                        str2 = str13;
                    } else if ("HTTPOnly".equalsIgnoreCase(str11)) {
                        str12 = str7;
                        z3 = z6;
                        str3 = str9;
                        z = true;
                        i4 = i10;
                        str2 = str8;
                        str4 = str10;
                        z2 = z5;
                        i5 = i9;
                    } else if ("Comment".equalsIgnoreCase(str11)) {
                        i4 = i10;
                        z2 = z5;
                        str2 = str8;
                        i5 = i9;
                        str4 = str12;
                        str12 = str7;
                        str3 = str9;
                        z = z4;
                        z3 = z6;
                    } else if ("CommentURL".equalsIgnoreCase(str11)) {
                        i4 = i10;
                        z = z4;
                        str2 = str8;
                        z3 = z6;
                        str4 = str10;
                        z2 = z5;
                        i5 = i9;
                        str12 = str7;
                        str3 = str12;
                    } else if ("Domain".equalsIgnoreCase(str11)) {
                        i4 = i10;
                        str4 = str10;
                        str2 = str12;
                        z2 = z5;
                        str12 = str7;
                        i5 = i9;
                        str3 = str9;
                        z = z4;
                        z3 = z6;
                    } else if ("Path".equalsIgnoreCase(str11)) {
                        i4 = i10;
                        str3 = str9;
                        str2 = str8;
                        z = z4;
                        str4 = str10;
                        z3 = z6;
                        z2 = z5;
                        i5 = i9;
                    } else if ("Expires".equalsIgnoreCase(str11)) {
                        try {
                            long time = new CookieDateFormat().parse(str12).getTime() - System.currentTimeMillis();
                            if (time <= 0) {
                                i4 = 0;
                            } else {
                                i4 = (time % 1000 != 0 ? 1 : 0) + ((int) (time / 1000));
                            }
                            str12 = str7;
                            str2 = str8;
                            str3 = str9;
                            str4 = str10;
                            z = z4;
                            z2 = z5;
                            z3 = z6;
                            i5 = i9;
                        } catch (ParseException e2) {
                            i4 = i10;
                            str12 = str7;
                            str2 = str8;
                            str3 = str9;
                            str4 = str10;
                            z = z4;
                            z2 = z5;
                            z3 = z6;
                            i5 = i9;
                        }
                    } else if ("Max-Age".equalsIgnoreCase(str11)) {
                        i4 = Integer.parseInt(str12);
                        str12 = str7;
                        str2 = str8;
                        str3 = str9;
                        str4 = str10;
                        z = z4;
                        z2 = z5;
                        z3 = z6;
                        i5 = i9;
                    } else if ("Version".equalsIgnoreCase(str11)) {
                        int i11 = Integer.parseInt(str12);
                        str12 = str7;
                        str3 = str9;
                        z = z4;
                        z3 = z6;
                        String str14 = str10;
                        z2 = z5;
                        i5 = i11;
                        i4 = i10;
                        str2 = str8;
                        str4 = str14;
                    } else {
                        if (!"Port".equalsIgnoreCase(str11)) {
                            break;
                        }
                        for (String str15 : str12.split(COMMA)) {
                            try {
                                arrayList3.add(Integer.valueOf(str15));
                            } catch (NumberFormatException e3) {
                            }
                        }
                        i4 = i10;
                        str12 = str7;
                        str2 = str8;
                        str3 = str9;
                        str4 = str10;
                        z = z4;
                        z2 = z5;
                        z3 = z6;
                        i5 = i9;
                    }
                    i8++;
                    i3++;
                    z6 = z3;
                    i9 = i5;
                    z4 = z;
                    z5 = z2;
                    str9 = str3;
                    str10 = str4;
                    str7 = str12;
                    str8 = str2;
                    i10 = i4;
                }
                defaultCookie.setVersion(i9);
                defaultCookie.setMaxAge(i10);
                defaultCookie.setPath(str7);
                defaultCookie.setDomain(str8);
                defaultCookie.setSecure(z5);
                defaultCookie.setHttpOnly(z4);
                if (i9 > 0) {
                    defaultCookie.setComment(str10);
                }
                if (i9 > 1) {
                    defaultCookie.setCommentUrl(str9);
                    defaultCookie.setPorts(arrayList3);
                    defaultCookie.setDiscard(z6);
                }
                i2 = i9;
            }
            i = i3 + 1;
        }
    }

    private void extractKeyValuePairs(String str, List list, List list2) {
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
