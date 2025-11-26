package p021c.p022a;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import p021c.C0325a;

/* compiled from: OAuth.java */
/* renamed from: c.a.e */
/* loaded from: classes.dex */
public class C0330e implements Serializable {

    /* renamed from: a */
    private static final C0332g f748a = new C0332g("oauth_signature_method", "HMAC-SHA1");

    /* renamed from: b */
    private static final boolean f749b = C0325a.m1118p();

    /* renamed from: e */
    private static Random f750e = new Random();

    /* renamed from: c */
    private String f751c = "";

    /* renamed from: d */
    private String f752d;

    public C0330e(String str, String str2) {
        m1164c(str);
        m1165d(str2);
    }

    /* renamed from: a */
    String m1163a(String str, String str2, C0332g[] c0332gArr, String str3, String str4, AbstractC0331f abstractC0331f) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        if (c0332gArr == null) {
            c0332gArr = new C0332g[0];
        }
        ArrayList arrayList = new ArrayList(5);
        arrayList.add(new C0332g("oauth_consumer_key", this.f751c));
        arrayList.add(f748a);
        arrayList.add(new C0332g("oauth_timestamp", str4));
        arrayList.add(new C0332g("oauth_nonce", str3));
        arrayList.add(new C0332g("oauth_version", "1.0"));
        if (abstractC0331f != null) {
            arrayList.add(new C0332g("oauth_token", abstractC0331f.mo1123d()));
        }
        List<C0332g> arrayList2 = new ArrayList<>(arrayList.size() + c0332gArr.length);
        arrayList2.addAll(arrayList);
        arrayList2.addAll(m1155a(c0332gArr));
        m1157a(str2, arrayList2);
        StringBuffer stringBufferAppend = new StringBuffer(str).append("&").append(m1152a(m1158b(str2))).append("&");
        stringBufferAppend.append(m1152a(m1153a(arrayList2)));
        String string = stringBufferAppend.toString();
        m1156a("OAuth base string:", string);
        String strM1161a = m1161a(string, abstractC0331f);
        m1156a("OAuth signature:", strM1161a);
        arrayList.add(new C0332g("oauth_signature", strM1161a));
        return "OAuth " + m1154a(arrayList, ",", true);
    }

    /* renamed from: a */
    private void m1157a(String str, List<C0332g> list) {
        int iIndexOf = str.indexOf("?");
        if (-1 != iIndexOf) {
            try {
                for (String str2 : str.substring(iIndexOf + 1).split("&")) {
                    String[] strArrSplit = str2.split("=");
                    if (strArrSplit.length == 2) {
                        list.add(new C0332g(URLDecoder.decode(strArrSplit[0], "UTF-8"), URLDecoder.decode(strArrSplit[1], "UTF-8")));
                    } else {
                        list.add(new C0332g(URLDecoder.decode(strArrSplit[0], "UTF-8"), ""));
                    }
                }
            } catch (UnsupportedEncodingException e) {
            }
        }
    }

    /* renamed from: a */
    String m1162a(String str, String str2, C0332g[] c0332gArr, AbstractC0331f abstractC0331f) {
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        return m1163a(str, str2, c0332gArr, String.valueOf(f750e.nextInt() + jCurrentTimeMillis), String.valueOf(jCurrentTimeMillis), abstractC0331f);
    }

    /* renamed from: a */
    String m1161a(String str, AbstractC0331f abstractC0331f) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        SecretKeySpec secretKeySpecM1167e;
        byte[] bArrDoFinal = null;
        try {
            Mac mac = Mac.getInstance("HmacSHA1");
            if (abstractC0331f == null) {
                secretKeySpecM1167e = new SecretKeySpec((m1152a(this.f752d) + "&").getBytes(), "HmacSHA1");
            } else {
                if (abstractC0331f.m1167e() == null) {
                    abstractC0331f.m1166a(new SecretKeySpec((m1152a(this.f752d) + "&" + m1152a(abstractC0331f.mo1122c())).getBytes(), "HmacSHA1"));
                }
                secretKeySpecM1167e = abstractC0331f.m1167e();
            }
            mac.init(secretKeySpecM1167e);
            bArrDoFinal = mac.doFinal(str.getBytes());
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e2) {
        }
        return new C0327b().m1124a(bArrDoFinal);
    }

    /* renamed from: a */
    public static String m1153a(List<C0332g> list) {
        Collections.sort(list);
        return m1159b(list);
    }

    /* renamed from: a */
    public static List<C0332g> m1155a(C0332g[] c0332gArr) {
        ArrayList arrayList = new ArrayList(c0332gArr.length);
        arrayList.addAll(Arrays.asList(c0332gArr));
        return arrayList;
    }

    /* renamed from: b */
    public static String m1159b(List<C0332g> list) {
        return m1154a(list, "&", false);
    }

    /* renamed from: a */
    public static String m1154a(List<C0332g> list, String str, boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        for (C0332g c0332g : list) {
            if (stringBuffer.length() != 0) {
                if (z) {
                    stringBuffer.append("\"");
                }
                stringBuffer.append(str);
            }
            stringBuffer.append(m1152a(c0332g.f758a)).append("=");
            if (z) {
                stringBuffer.append("\"");
            }
            stringBuffer.append(m1152a(c0332g.f759b));
        }
        if (stringBuffer.length() != 0 && z) {
            stringBuffer.append("\"");
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public static String m1152a(String str) throws UnsupportedEncodingException {
        String strEncode = null;
        try {
            strEncode = URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
        }
        StringBuffer stringBuffer = new StringBuffer(strEncode.length());
        int i = 0;
        while (i < strEncode.length()) {
            char cCharAt = strEncode.charAt(i);
            if (cCharAt == '*') {
                stringBuffer.append("%2A");
            } else if (cCharAt == '+') {
                stringBuffer.append("%20");
            } else if (cCharAt == '%' && i + 1 < strEncode.length() && strEncode.charAt(i + 1) == '7' && strEncode.charAt(i + 2) == 'E') {
                stringBuffer.append('~');
                i += 2;
            } else {
                stringBuffer.append(cCharAt);
            }
            i++;
        }
        return stringBuffer.toString();
    }

    /* renamed from: b */
    public static String m1158b(String str) {
        int iIndexOf = str.indexOf("?");
        if (-1 != iIndexOf) {
            str = str.substring(0, iIndexOf);
        }
        int iIndexOf2 = str.indexOf("/", 8);
        String lowerCase = str.substring(0, iIndexOf2).toLowerCase();
        int iIndexOf3 = lowerCase.indexOf(":", 8);
        if (-1 != iIndexOf3) {
            if (lowerCase.startsWith("http://") && lowerCase.endsWith(":80")) {
                lowerCase = lowerCase.substring(0, iIndexOf3);
            } else if (lowerCase.startsWith("https://") && lowerCase.endsWith(":443")) {
                lowerCase = lowerCase.substring(0, iIndexOf3);
            }
        }
        return lowerCase + str.substring(iIndexOf2);
    }

    /* renamed from: c */
    public void m1164c(String str) {
        if (str == null) {
            str = "";
        }
        this.f751c = str;
    }

    /* renamed from: d */
    public void m1165d(String str) {
        if (str == null) {
            str = "";
        }
        this.f752d = str;
    }

    /* renamed from: e */
    private void m1160e(String str) {
        if (f749b) {
            System.out.println("[" + new Date() + "]" + str);
        }
    }

    /* renamed from: a */
    private void m1156a(String str, String str2) {
        if (f749b) {
            m1160e(str + str2);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0330e)) {
            return false;
        }
        C0330e c0330e = (C0330e) obj;
        if (this.f751c == null ? c0330e.f751c != null : !this.f751c.equals(c0330e.f751c)) {
            return false;
        }
        if (this.f752d != null) {
            if (this.f752d.equals(c0330e.f752d)) {
                return true;
            }
        } else if (c0330e.f752d == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.f751c != null ? this.f751c.hashCode() : 0) * 31) + (this.f752d != null ? this.f752d.hashCode() : 0);
    }

    public String toString() {
        return "OAuth{consumerKey='" + this.f751c + "', consumerSecret='" + this.f752d + "'}";
    }
}
