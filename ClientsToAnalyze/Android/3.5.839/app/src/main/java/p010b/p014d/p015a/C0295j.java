package p010b.p014d.p015a;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* compiled from: HttpParameter.java */
/* renamed from: b.d.a.j */
/* loaded from: classes.dex */
public final class C0295j implements Serializable, Comparable {

    /* renamed from: a */
    private String f653a;

    /* renamed from: b */
    private String f654b;

    /* renamed from: c */
    private File f655c = null;

    /* renamed from: d */
    private InputStream f656d = null;

    public C0295j(String str, String str2) {
        this.f653a = null;
        this.f654b = null;
        this.f653a = str;
        this.f654b = str2;
    }

    /* renamed from: a */
    public String m1012a() {
        return this.f653a;
    }

    /* renamed from: b */
    public String m1013b() {
        return this.f654b;
    }

    /* renamed from: c */
    public File m1014c() {
        return this.f655c;
    }

    /* renamed from: d */
    public InputStream m1015d() {
        return this.f656d;
    }

    /* renamed from: e */
    public boolean m1016e() {
        return this.f655c != null;
    }

    /* renamed from: f */
    public boolean m1017f() {
        return this.f656d != null;
    }

    /* renamed from: g */
    public String m1018g() {
        if (!m1016e()) {
            throw new IllegalStateException("not a file");
        }
        String name = this.f655c.getName();
        if (-1 == name.lastIndexOf(".")) {
            return "application/octet-stream";
        }
        String lowerCase = name.substring(name.lastIndexOf(".") + 1).toLowerCase();
        if (lowerCase.length() == 3) {
            if ("gif".equals(lowerCase)) {
                return "image/gif";
            }
            if ("png".equals(lowerCase)) {
                return "image/png";
            }
            if ("jpg".equals(lowerCase)) {
                return "image/jpeg";
            }
            return "application/octet-stream";
        }
        if (lowerCase.length() == 4 && "jpeg".equals(lowerCase)) {
            return "image/jpeg";
        }
        return "application/octet-stream";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0295j)) {
            return false;
        }
        C0295j c0295j = (C0295j) obj;
        if (this.f655c == null ? c0295j.f655c != null : !this.f655c.equals(c0295j.f655c)) {
            return false;
        }
        if (this.f656d == null ? c0295j.f656d != null : !this.f656d.equals(c0295j.f656d)) {
            return false;
        }
        if (!this.f653a.equals(c0295j.f653a)) {
            return false;
        }
        if (this.f654b != null) {
            if (this.f654b.equals(c0295j.f654b)) {
                return true;
            }
        } else if (c0295j.f654b == null) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m1010a(C0295j[] c0295jArr) {
        if (c0295jArr == null) {
            return false;
        }
        for (C0295j c0295j : c0295jArr) {
            if (c0295j.m1016e()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((this.f655c != null ? this.f655c.hashCode() : 0) + (((this.f654b != null ? this.f654b.hashCode() : 0) + (this.f653a.hashCode() * 31)) * 31)) * 31) + (this.f656d != null ? this.f656d.hashCode() : 0);
    }

    public String toString() {
        return "PostParameter{name='" + this.f653a + "', value='" + this.f654b + "', file=" + this.f655c + ", fileBody=" + this.f656d + '}';
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        C0295j c0295j = (C0295j) obj;
        int iCompareTo = this.f653a.compareTo(c0295j.f653a);
        if (iCompareTo == 0) {
            return this.f654b.compareTo(c0295j.f654b);
        }
        return iCompareTo;
    }

    /* renamed from: b */
    public static String m1011b(C0295j[] c0295jArr) {
        if (c0295jArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < c0295jArr.length; i++) {
            if (c0295jArr[i].m1016e()) {
                throw new IllegalArgumentException("parameter [" + c0295jArr[i].f653a + "]should be text");
            }
            if (i != 0) {
                sb.append("&");
            }
            sb.append(m1009a(c0295jArr[i].f653a)).append("=").append(m1009a(c0295jArr[i].f654b));
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m1009a(String str) throws UnsupportedEncodingException {
        String strEncode = null;
        try {
            strEncode = URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
        }
        StringBuilder sb = new StringBuilder(strEncode.length());
        int i = 0;
        while (i < strEncode.length()) {
            char cCharAt = strEncode.charAt(i);
            if (cCharAt == '*') {
                sb.append("%2A");
            } else if (cCharAt == '+') {
                sb.append("%20");
            } else if (cCharAt == '%' && i + 1 < strEncode.length() && strEncode.charAt(i + 1) == '7' && strEncode.charAt(i + 2) == 'E') {
                sb.append('~');
                i += 2;
            } else {
                sb.append(cCharAt);
            }
            i++;
        }
        return sb.toString();
    }
}
