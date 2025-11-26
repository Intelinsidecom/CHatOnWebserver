package com.google.p034a.p039d;

import com.google.p034a.p036b.AbstractC0658u;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

/* compiled from: JsonReader.java */
/* renamed from: com.google.a.d.a */
/* loaded from: classes.dex */
public class C0666a implements Closeable {

    /* renamed from: a */
    private static final char[] f1570a = ")]}'\n".toCharArray();

    /* renamed from: b */
    private final Reader f1571b;

    /* renamed from: j */
    private long f1579j;

    /* renamed from: k */
    private int f1580k;

    /* renamed from: l */
    private String f1581l;

    /* renamed from: n */
    private int f1583n;

    /* renamed from: c */
    private boolean f1572c = false;

    /* renamed from: d */
    private final char[] f1573d = new char[1024];

    /* renamed from: e */
    private int f1574e = 0;

    /* renamed from: f */
    private int f1575f = 0;

    /* renamed from: g */
    private int f1576g = 0;

    /* renamed from: h */
    private int f1577h = 0;

    /* renamed from: i */
    private int f1578i = 0;

    /* renamed from: m */
    private int[] f1582m = new int[32];

    static {
        AbstractC0658u.f1548a = new C0667b();
    }

    public C0666a(Reader reader) {
        this.f1583n = 0;
        int[] iArr = this.f1582m;
        int i = this.f1583n;
        this.f1583n = i + 1;
        iArr[i] = 6;
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.f1571b = reader;
    }

    /* renamed from: a */
    public final void m2130a(boolean z) {
        this.f1572c = z;
    }

    /* renamed from: p */
    public final boolean m2131p() {
        return this.f1572c;
    }

    /* renamed from: a */
    public void mo1987a() throws IOException {
        int iM2119o = this.f1578i;
        if (iM2119o == 0) {
            iM2119o = m2119o();
        }
        if (iM2119o == 3) {
            m2108a(1);
            this.f1578i = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + mo1992f() + " at line " + m2124u() + " column " + m2125v());
    }

    /* renamed from: b */
    public void mo1988b() throws IOException {
        int iM2119o = this.f1578i;
        if (iM2119o == 0) {
            iM2119o = m2119o();
        }
        if (iM2119o == 4) {
            this.f1583n--;
            this.f1578i = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + mo1992f() + " at line " + m2124u() + " column " + m2125v());
    }

    /* renamed from: c */
    public void mo1989c() throws IOException {
        int iM2119o = this.f1578i;
        if (iM2119o == 0) {
            iM2119o = m2119o();
        }
        if (iM2119o == 1) {
            m2108a(3);
            this.f1578i = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + mo1992f() + " at line " + m2124u() + " column " + m2125v());
    }

    /* renamed from: d */
    public void mo1990d() throws IOException {
        int iM2119o = this.f1578i;
        if (iM2119o == 0) {
            iM2119o = m2119o();
        }
        if (iM2119o == 2) {
            this.f1583n--;
            this.f1578i = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + mo1992f() + " at line " + m2124u() + " column " + m2125v());
    }

    /* renamed from: e */
    public boolean mo1991e() throws IOException {
        int iM2119o = this.f1578i;
        if (iM2119o == 0) {
            iM2119o = m2119o();
        }
        return (iM2119o == 2 || iM2119o == 4) ? false : true;
    }

    /* renamed from: f */
    public EnumC0668c mo1992f() throws IOException {
        int iM2119o = this.f1578i;
        if (iM2119o == 0) {
            iM2119o = m2119o();
        }
        switch (iM2119o) {
            case 1:
                return EnumC0668c.BEGIN_OBJECT;
            case 2:
                return EnumC0668c.END_OBJECT;
            case 3:
                return EnumC0668c.BEGIN_ARRAY;
            case 4:
                return EnumC0668c.END_ARRAY;
            case 5:
            case 6:
                return EnumC0668c.BOOLEAN;
            case 7:
                return EnumC0668c.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return EnumC0668c.STRING;
            case 12:
            case 13:
            case 14:
                return EnumC0668c.NAME;
            case 15:
            case 16:
                return EnumC0668c.NUMBER;
            case 17:
                return EnumC0668c.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public int m2119o() throws IOException {
        int i = this.f1582m[this.f1583n - 1];
        if (i == 1) {
            this.f1582m[this.f1583n - 1] = 2;
        } else if (i == 2) {
            switch (m2112b(true)) {
                case 44:
                    break;
                case 59:
                    m2126w();
                    break;
                case 93:
                    this.f1578i = 4;
                    return 4;
                default:
                    throw m2113b("Unterminated array");
            }
        } else {
            if (i == 3 || i == 5) {
                this.f1582m[this.f1583n - 1] = 4;
                if (i == 5) {
                    switch (m2112b(true)) {
                        case 44:
                            break;
                        case 59:
                            m2126w();
                            break;
                        case 125:
                            this.f1578i = 2;
                            return 2;
                        default:
                            throw m2113b("Unterminated object");
                    }
                }
                int iM2112b = m2112b(true);
                switch (iM2112b) {
                    case 34:
                        this.f1578i = 13;
                        return 13;
                    case 39:
                        m2126w();
                        this.f1578i = 12;
                        return 12;
                    case 125:
                        if (i != 5) {
                            this.f1578i = 2;
                            return 2;
                        }
                        throw m2113b("Expected name");
                    default:
                        m2126w();
                        this.f1574e--;
                        if (m2109a((char) iM2112b)) {
                            this.f1578i = 14;
                            return 14;
                        }
                        throw m2113b("Expected name");
                }
            }
            if (i == 4) {
                this.f1582m[this.f1583n - 1] = 5;
                switch (m2112b(true)) {
                    case 58:
                        break;
                    case 59:
                    case 60:
                    default:
                        throw m2113b("Expected ':'");
                    case 61:
                        m2126w();
                        if ((this.f1574e < this.f1575f || m2115b(1)) && this.f1573d[this.f1574e] == '>') {
                            this.f1574e++;
                            break;
                        }
                        break;
                }
            } else if (i == 6) {
                if (this.f1572c) {
                    m2129z();
                }
                this.f1582m[this.f1583n - 1] = 7;
            } else if (i == 7) {
                if (m2112b(false) == -1) {
                    this.f1578i = 17;
                    return 17;
                }
                m2126w();
                this.f1574e--;
            } else if (i == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        switch (m2112b(true)) {
            case 34:
                if (this.f1583n == 1) {
                    m2126w();
                }
                this.f1578i = 9;
                return 9;
            case 39:
                m2126w();
                this.f1578i = 8;
                return 8;
            case 44:
            case 59:
                break;
            case 91:
                this.f1578i = 3;
                return 3;
            case 93:
                if (i == 1) {
                    this.f1578i = 4;
                    return 4;
                }
                break;
            case 123:
                this.f1578i = 1;
                return 1;
            default:
                this.f1574e--;
                if (this.f1583n == 1) {
                    m2126w();
                }
                int iM2120q = m2120q();
                if (iM2120q == 0) {
                    int iM2121r = m2121r();
                    if (iM2121r == 0) {
                        if (!m2109a(this.f1573d[this.f1574e])) {
                            throw m2113b("Expected value");
                        }
                        m2126w();
                        this.f1578i = 10;
                        return 10;
                    }
                    return iM2121r;
                }
                return iM2120q;
        }
        if (i == 1 || i == 2) {
            m2126w();
            this.f1574e--;
            this.f1578i = 7;
            return 7;
        }
        throw m2113b("Unexpected value");
    }

    /* renamed from: q */
    private int m2120q() {
        String str;
        String str2;
        int i;
        char c2 = this.f1573d[this.f1574e];
        if (c2 == 't' || c2 == 'T') {
            str = "true";
            str2 = "TRUE";
            i = 5;
        } else if (c2 == 'f' || c2 == 'F') {
            str = "false";
            str2 = "FALSE";
            i = 6;
        } else {
            if (c2 != 'n' && c2 != 'N') {
                return 0;
            }
            str = "null";
            str2 = "NULL";
            i = 7;
        }
        int length = str.length();
        for (int i2 = 1; i2 < length; i2++) {
            if (this.f1574e + i2 >= this.f1575f && !m2115b(i2 + 1)) {
                return 0;
            }
            char c3 = this.f1573d[this.f1574e + i2];
            if (c3 != str.charAt(i2) && c3 != str2.charAt(i2)) {
                return 0;
            }
        }
        if ((this.f1574e + length < this.f1575f || m2115b(length + 1)) && m2109a(this.f1573d[this.f1574e + length])) {
            return 0;
        }
        this.f1574e += length;
        this.f1578i = i;
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:?, code lost:
    
        return 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:?, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0029, code lost:
    
        if (r4 != 2) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
    
        if (r5 == false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
    
        if (r7 != Long.MIN_VALUE) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
    
        if (r6 == false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0035, code lost:
    
        if (r6 == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0037, code lost:
    
        r19.f1579j = r7;
        r19.f1574e += r11;
        r19.f1578i = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0068, code lost:
    
        if (m2109a(r3) == false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006a, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0110, code lost:
    
        r7 = -r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0114, code lost:
    
        if (r4 == 2) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0117, code lost:
    
        if (r4 == 4) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x011a, code lost:
    
        if (r4 != 7) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x011c, code lost:
    
        r19.f1580k = r11;
        r19.f1578i = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0128, code lost:
    
        return 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ab  */
    /* renamed from: r */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int m2121r() {
        /*
            Method dump skipped, instructions count: 328
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.p034a.p039d.C0666a.m2121r():int");
    }

    /* renamed from: a */
    private boolean m2109a(char c2) throws IOException {
        switch (c2) {
            case '#':
            case '/':
            case ';':
            case '=':
            case '\\':
                m2126w();
            case '\t':
            case '\n':
            case '\f':
            case '\r':
            case ' ':
            case ',':
            case ':':
            case '[':
            case ']':
            case '{':
            case '}':
                return false;
            default:
                return true;
        }
    }

    /* renamed from: g */
    public String mo1993g() throws IOException {
        String strM2114b;
        int iM2119o = this.f1578i;
        if (iM2119o == 0) {
            iM2119o = m2119o();
        }
        if (iM2119o == 14) {
            strM2114b = m2122s();
        } else if (iM2119o == 12) {
            strM2114b = m2114b('\'');
        } else if (iM2119o == 13) {
            strM2114b = m2114b('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + mo1992f() + " at line " + m2124u() + " column " + m2125v());
        }
        this.f1578i = 0;
        return strM2114b;
    }

    /* renamed from: h */
    public String mo1994h() throws IOException {
        String str;
        int iM2119o = this.f1578i;
        if (iM2119o == 0) {
            iM2119o = m2119o();
        }
        if (iM2119o == 10) {
            str = m2122s();
        } else if (iM2119o == 8) {
            str = m2114b('\'');
        } else if (iM2119o == 9) {
            str = m2114b('\"');
        } else if (iM2119o == 11) {
            str = this.f1581l;
            this.f1581l = null;
        } else if (iM2119o == 15) {
            str = Long.toString(this.f1579j);
        } else if (iM2119o == 16) {
            str = new String(this.f1573d, this.f1574e, this.f1580k);
            this.f1574e += this.f1580k;
        } else {
            throw new IllegalStateException("Expected a string but was " + mo1992f() + " at line " + m2124u() + " column " + m2125v());
        }
        this.f1578i = 0;
        return str;
    }

    /* renamed from: i */
    public boolean mo1995i() throws IOException {
        int iM2119o = this.f1578i;
        if (iM2119o == 0) {
            iM2119o = m2119o();
        }
        if (iM2119o == 5) {
            this.f1578i = 0;
            return true;
        }
        if (iM2119o == 6) {
            this.f1578i = 0;
            return false;
        }
        throw new IllegalStateException("Expected a boolean but was " + mo1992f() + " at line " + m2124u() + " column " + m2125v());
    }

    /* renamed from: j */
    public void mo1996j() throws IOException {
        int iM2119o = this.f1578i;
        if (iM2119o == 0) {
            iM2119o = m2119o();
        }
        if (iM2119o == 7) {
            this.f1578i = 0;
            return;
        }
        throw new IllegalStateException("Expected null but was " + mo1992f() + " at line " + m2124u() + " column " + m2125v());
    }

    /* renamed from: k */
    public double mo1997k() throws IOException, NumberFormatException {
        int iM2119o = this.f1578i;
        if (iM2119o == 0) {
            iM2119o = m2119o();
        }
        if (iM2119o == 15) {
            this.f1578i = 0;
            return this.f1579j;
        }
        if (iM2119o == 16) {
            this.f1581l = new String(this.f1573d, this.f1574e, this.f1580k);
            this.f1574e += this.f1580k;
        } else if (iM2119o == 8 || iM2119o == 9) {
            this.f1581l = m2114b(iM2119o == 8 ? '\'' : '\"');
        } else if (iM2119o == 10) {
            this.f1581l = m2122s();
        } else if (iM2119o != 11) {
            throw new IllegalStateException("Expected a double but was " + mo1992f() + " at line " + m2124u() + " column " + m2125v());
        }
        this.f1578i = 11;
        double d = Double.parseDouble(this.f1581l);
        if (!this.f1572c && (Double.isNaN(d) || Double.isInfinite(d))) {
            throw new C0670e("JSON forbids NaN and infinities: " + d + " at line " + m2124u() + " column " + m2125v());
        }
        this.f1581l = null;
        this.f1578i = 0;
        return d;
    }

    /* renamed from: l */
    public long mo1998l() throws IOException, NumberFormatException {
        int iM2119o = this.f1578i;
        if (iM2119o == 0) {
            iM2119o = m2119o();
        }
        if (iM2119o == 15) {
            this.f1578i = 0;
            return this.f1579j;
        }
        if (iM2119o == 16) {
            this.f1581l = new String(this.f1573d, this.f1574e, this.f1580k);
            this.f1574e += this.f1580k;
        } else if (iM2119o == 8 || iM2119o == 9) {
            this.f1581l = m2114b(iM2119o == 8 ? '\'' : '\"');
            try {
                long j = Long.parseLong(this.f1581l);
                this.f1578i = 0;
                return j;
            } catch (NumberFormatException e) {
            }
        } else {
            throw new IllegalStateException("Expected a long but was " + mo1992f() + " at line " + m2124u() + " column " + m2125v());
        }
        this.f1578i = 11;
        double d = Double.parseDouble(this.f1581l);
        long j2 = (long) d;
        if (j2 != d) {
            throw new NumberFormatException("Expected a long but was " + this.f1581l + " at line " + m2124u() + " column " + m2125v());
        }
        this.f1581l = null;
        this.f1578i = 0;
        return j2;
    }

    /* renamed from: b */
    private String m2114b(char c2) throws IOException {
        char[] cArr = this.f1573d;
        StringBuilder sb = new StringBuilder();
        do {
            int i = this.f1574e;
            int i2 = this.f1575f;
            int i3 = i;
            while (i3 < i2) {
                int i4 = i3 + 1;
                char c3 = cArr[i3];
                if (c3 == c2) {
                    this.f1574e = i4;
                    sb.append(cArr, i, (i4 - i) - 1);
                    return sb.toString();
                }
                if (c3 == '\\') {
                    this.f1574e = i4;
                    sb.append(cArr, i, (i4 - i) - 1);
                    sb.append(m2128y());
                    i = this.f1574e;
                    i2 = this.f1575f;
                    i4 = i;
                } else if (c3 == '\n') {
                    this.f1576g++;
                    this.f1577h = i4;
                }
                i3 = i4;
            }
            sb.append(cArr, i, i3 - i);
            this.f1574e = i3;
        } while (m2115b(1));
        throw m2113b("Unterminated string");
    }

    /* renamed from: s */
    private String m2122s() throws IOException {
        String string;
        StringBuilder sb = null;
        int i = 0;
        while (true) {
            if (this.f1574e + i < this.f1575f) {
                switch (this.f1573d[this.f1574e + i]) {
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case '{':
                    case '}':
                        break;
                    case '#':
                    case '/':
                    case ';':
                    case '=':
                    case '\\':
                        m2126w();
                        break;
                    default:
                        i++;
                        continue;
                }
            } else if (i < this.f1573d.length) {
                if (m2115b(i + 1)) {
                }
            } else {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append(this.f1573d, this.f1574e, i);
                this.f1574e = i + this.f1574e;
                if (m2115b(1)) {
                    i = 0;
                } else {
                    i = 0;
                }
            }
        }
        if (sb == null) {
            string = new String(this.f1573d, this.f1574e, i);
        } else {
            sb.append(this.f1573d, this.f1574e, i);
            string = sb.toString();
        }
        this.f1574e = i + this.f1574e;
        return string;
    }

    /* renamed from: c */
    private void m2117c(char c2) throws IOException {
        char[] cArr = this.f1573d;
        do {
            int i = this.f1574e;
            int i2 = this.f1575f;
            int i3 = i;
            while (i3 < i2) {
                int i4 = i3 + 1;
                char c3 = cArr[i3];
                if (c3 == c2) {
                    this.f1574e = i4;
                    return;
                }
                if (c3 == '\\') {
                    this.f1574e = i4;
                    m2128y();
                    i4 = this.f1574e;
                    i2 = this.f1575f;
                } else if (c3 == '\n') {
                    this.f1576g++;
                    this.f1577h = i4;
                }
                i3 = i4;
            }
            this.f1574e = i3;
        } while (m2115b(1));
        throw m2113b("Unterminated string");
    }

    /* renamed from: t */
    private void m2123t() throws IOException {
        do {
            int i = 0;
            while (this.f1574e + i < this.f1575f) {
                switch (this.f1573d[this.f1574e + i]) {
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case '{':
                    case '}':
                        break;
                    case '#':
                    case '/':
                    case ';':
                    case '=':
                    case '\\':
                        m2126w();
                        break;
                    default:
                        i++;
                }
                this.f1574e = i + this.f1574e;
                return;
            }
            this.f1574e = i + this.f1574e;
        } while (m2115b(1));
    }

    /* renamed from: m */
    public int mo1999m() throws IOException, NumberFormatException {
        int iM2119o = this.f1578i;
        if (iM2119o == 0) {
            iM2119o = m2119o();
        }
        if (iM2119o == 15) {
            int i = (int) this.f1579j;
            if (this.f1579j != i) {
                throw new NumberFormatException("Expected an int but was " + this.f1579j + " at line " + m2124u() + " column " + m2125v());
            }
            this.f1578i = 0;
            return i;
        }
        if (iM2119o == 16) {
            this.f1581l = new String(this.f1573d, this.f1574e, this.f1580k);
            this.f1574e += this.f1580k;
        } else if (iM2119o == 8 || iM2119o == 9) {
            this.f1581l = m2114b(iM2119o == 8 ? '\'' : '\"');
            try {
                int i2 = Integer.parseInt(this.f1581l);
                this.f1578i = 0;
                return i2;
            } catch (NumberFormatException e) {
            }
        } else {
            throw new IllegalStateException("Expected an int but was " + mo1992f() + " at line " + m2124u() + " column " + m2125v());
        }
        this.f1578i = 11;
        double d = Double.parseDouble(this.f1581l);
        int i3 = (int) d;
        if (i3 != d) {
            throw new NumberFormatException("Expected an int but was " + this.f1581l + " at line " + m2124u() + " column " + m2125v());
        }
        this.f1581l = null;
        this.f1578i = 0;
        return i3;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f1578i = 0;
        this.f1582m[0] = 8;
        this.f1583n = 1;
        this.f1571b.close();
    }

    /* renamed from: n */
    public void mo2000n() throws IOException {
        int i = 0;
        do {
            int iM2119o = this.f1578i;
            if (iM2119o == 0) {
                iM2119o = m2119o();
            }
            if (iM2119o == 3) {
                m2108a(1);
                i++;
            } else if (iM2119o == 1) {
                m2108a(3);
                i++;
            } else if (iM2119o == 4 || iM2119o == 2) {
                this.f1583n--;
                i--;
            } else if (iM2119o == 14 || iM2119o == 10) {
                m2123t();
            } else if (iM2119o == 8 || iM2119o == 12) {
                m2117c('\'');
            } else if (iM2119o == 9 || iM2119o == 13) {
                m2117c('\"');
            } else if (iM2119o == 16) {
                this.f1574e += this.f1580k;
            }
            this.f1578i = 0;
        } while (i != 0);
    }

    /* renamed from: a */
    private void m2108a(int i) {
        if (this.f1583n == this.f1582m.length) {
            int[] iArr = new int[this.f1583n * 2];
            System.arraycopy(this.f1582m, 0, iArr, 0, this.f1583n);
            this.f1582m = iArr;
        }
        int[] iArr2 = this.f1582m;
        int i2 = this.f1583n;
        this.f1583n = i2 + 1;
        iArr2[i2] = i;
    }

    /* renamed from: b */
    private boolean m2115b(int i) throws IOException {
        char[] cArr = this.f1573d;
        this.f1577h -= this.f1574e;
        if (this.f1575f != this.f1574e) {
            this.f1575f -= this.f1574e;
            System.arraycopy(cArr, this.f1574e, cArr, 0, this.f1575f);
        } else {
            this.f1575f = 0;
        }
        this.f1574e = 0;
        do {
            int i2 = this.f1571b.read(cArr, this.f1575f, cArr.length - this.f1575f);
            if (i2 == -1) {
                return false;
            }
            this.f1575f = i2 + this.f1575f;
            if (this.f1576g == 0 && this.f1577h == 0 && this.f1575f > 0 && cArr[0] == 65279) {
                this.f1574e++;
                this.f1577h++;
                i++;
            }
        } while (this.f1575f < i);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public int m2124u() {
        return this.f1576g + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public int m2125v() {
        return (this.f1574e - this.f1577h) + 1;
    }

    /* renamed from: b */
    private int m2112b(boolean z) throws IOException {
        char[] cArr = this.f1573d;
        int i = this.f1574e;
        int i2 = this.f1575f;
        while (true) {
            if (i == i2) {
                this.f1574e = i;
                if (m2115b(1)) {
                    i = this.f1574e;
                    i2 = this.f1575f;
                } else {
                    if (z) {
                        throw new EOFException("End of input at line " + m2124u() + " column " + m2125v());
                    }
                    return -1;
                }
            }
            int i3 = i + 1;
            char c2 = cArr[i];
            if (c2 == '\n') {
                this.f1576g++;
                this.f1577h = i3;
                i = i3;
            } else if (c2 == ' ' || c2 == '\r') {
                i = i3;
            } else if (c2 == '\t') {
                i = i3;
            } else if (c2 == '/') {
                this.f1574e = i3;
                if (i3 == i2) {
                    this.f1574e--;
                    boolean zM2115b = m2115b(2);
                    this.f1574e++;
                    if (!zM2115b) {
                        return c2;
                    }
                }
                m2126w();
                switch (cArr[this.f1574e]) {
                    case '*':
                        this.f1574e++;
                        if (!m2110a("*/")) {
                            throw m2113b("Unterminated comment");
                        }
                        i = this.f1574e + 2;
                        i2 = this.f1575f;
                        break;
                    case '/':
                        this.f1574e++;
                        m2127x();
                        i = this.f1574e;
                        i2 = this.f1575f;
                        break;
                    default:
                        return c2;
                }
            } else if (c2 == '#') {
                this.f1574e = i3;
                m2126w();
                m2127x();
                i = this.f1574e;
                i2 = this.f1575f;
            } else {
                this.f1574e = i3;
                return c2;
            }
        }
    }

    /* renamed from: w */
    private void m2126w() throws IOException {
        if (!this.f1572c) {
            throw m2113b("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    /* renamed from: x */
    private void m2127x() {
        char c2;
        do {
            if (this.f1574e < this.f1575f || m2115b(1)) {
                char[] cArr = this.f1573d;
                int i = this.f1574e;
                this.f1574e = i + 1;
                c2 = cArr[i];
                if (c2 == '\n') {
                    this.f1576g++;
                    this.f1577h = this.f1574e;
                    return;
                }
            } else {
                return;
            }
        } while (c2 != '\r');
    }

    /* renamed from: a */
    private boolean m2110a(String str) {
        int i;
        while (true) {
            if (this.f1574e + str.length() > this.f1575f && !m2115b(str.length())) {
                return false;
            }
            if (this.f1573d[this.f1574e] == '\n') {
                this.f1576g++;
                this.f1577h = this.f1574e + 1;
            } else {
                for (0; i < str.length(); i + 1) {
                    i = this.f1573d[this.f1574e + i] == str.charAt(i) ? i + 1 : 0;
                }
                return true;
            }
            this.f1574e++;
        }
    }

    public String toString() {
        return getClass().getSimpleName() + " at line " + m2124u() + " column " + m2125v();
    }

    /* renamed from: y */
    private char m2128y() throws IOException {
        int i;
        if (this.f1574e == this.f1575f && !m2115b(1)) {
            throw m2113b("Unterminated escape sequence");
        }
        char[] cArr = this.f1573d;
        int i2 = this.f1574e;
        this.f1574e = i2 + 1;
        char c2 = cArr[i2];
        switch (c2) {
            case '\n':
                this.f1576g++;
                this.f1577h = this.f1574e;
                return c2;
            case 'b':
                return '\b';
            case 'f':
                return '\f';
            case 'n':
                return '\n';
            case 'r':
                return '\r';
            case 't':
                return '\t';
            case 'u':
                if (this.f1574e + 4 > this.f1575f && !m2115b(4)) {
                    throw m2113b("Unterminated escape sequence");
                }
                int i3 = this.f1574e;
                int i4 = i3 + 4;
                char c3 = 0;
                for (int i5 = i3; i5 < i4; i5++) {
                    char c4 = this.f1573d[i5];
                    char c5 = (char) (c3 << 4);
                    if (c4 >= '0' && c4 <= '9') {
                        i = c4 - '0';
                    } else if (c4 >= 'a' && c4 <= 'f') {
                        i = (c4 - 'a') + 10;
                    } else if (c4 >= 'A' && c4 <= 'F') {
                        i = (c4 - 'A') + 10;
                    } else {
                        throw new NumberFormatException("\\u" + new String(this.f1573d, this.f1574e, 4));
                    }
                    c3 = (char) (c5 + i);
                }
                this.f1574e += 4;
                return c3;
            default:
                return c2;
        }
    }

    /* renamed from: b */
    private IOException m2113b(String str) throws C0670e {
        throw new C0670e(str + " at line " + m2124u() + " column " + m2125v());
    }

    /* renamed from: z */
    private void m2129z() throws IOException {
        m2112b(true);
        this.f1574e--;
        if (this.f1574e + f1570a.length <= this.f1575f || m2115b(f1570a.length)) {
            for (int i = 0; i < f1570a.length; i++) {
                if (this.f1573d[this.f1574e + i] != f1570a[i]) {
                    return;
                }
            }
            this.f1574e += f1570a.length;
        }
    }
}
