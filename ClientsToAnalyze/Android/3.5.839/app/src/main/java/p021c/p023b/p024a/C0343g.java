package p021c.p023b.p024a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* compiled from: JSONTokener.java */
/* renamed from: c.b.a.g */
/* loaded from: classes.dex */
public class C0343g {

    /* renamed from: a */
    private int f779a;

    /* renamed from: b */
    private Reader f780b;

    /* renamed from: c */
    private char f781c;

    /* renamed from: d */
    private boolean f782d;

    public C0343g(Reader reader) {
        this.f780b = reader.markSupported() ? reader : new BufferedReader(reader);
        this.f782d = false;
        this.f779a = 0;
    }

    public C0343g(String str) {
        this(new StringReader(str));
    }

    /* renamed from: a */
    public void m1210a() throws C0338b {
        if (this.f782d || this.f779a <= 0) {
            throw new C0338b("Stepping back two steps is not supported");
        }
        this.f779a--;
        this.f782d = true;
    }

    /* renamed from: b */
    public char m1211b() throws IOException, C0338b {
        if (this.f782d) {
            this.f782d = false;
            if (this.f781c != 0) {
                this.f779a++;
            }
            return this.f781c;
        }
        try {
            int i = this.f780b.read();
            if (i <= 0) {
                this.f781c = (char) 0;
                return (char) 0;
            }
            this.f779a++;
            this.f781c = (char) i;
            return this.f781c;
        } catch (IOException e) {
            throw new C0338b(e);
        }
    }

    /* renamed from: a */
    public String m1209a(int i) throws IOException, C0338b {
        int i2 = 0;
        if (i == 0) {
            return "";
        }
        char[] cArr = new char[i];
        if (this.f782d) {
            this.f782d = false;
            cArr[0] = this.f781c;
            i2 = 1;
        }
        while (i2 < i) {
            try {
                int i3 = this.f780b.read(cArr, i2, i - i2);
                if (i3 == -1) {
                    break;
                }
                i2 += i3;
            } catch (IOException e) {
                throw new C0338b(e);
            }
        }
        this.f779a += i2;
        if (i2 < i) {
            throw m1207a("Substring bounds error");
        }
        this.f781c = cArr[i - 1];
        return new String(cArr);
    }

    /* renamed from: c */
    public char m1212c() throws IOException, C0338b {
        char cM1211b;
        do {
            cM1211b = m1211b();
            if (cM1211b == 0) {
                break;
            }
        } while (cM1211b <= ' ');
        return cM1211b;
    }

    /* renamed from: a */
    public String m1208a(char c2) throws IOException, C0338b {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            char cM1211b = m1211b();
            switch (cM1211b) {
                case 0:
                case '\n':
                case '\r':
                    throw m1207a("Unterminated string");
                case '\\':
                    char cM1211b2 = m1211b();
                    switch (cM1211b2) {
                        case 'b':
                            stringBuffer.append('\b');
                            break;
                        case 'f':
                            stringBuffer.append('\f');
                            break;
                        case 'n':
                            stringBuffer.append('\n');
                            break;
                        case 'r':
                            stringBuffer.append('\r');
                            break;
                        case 't':
                            stringBuffer.append('\t');
                            break;
                        case 'u':
                            stringBuffer.append((char) Integer.parseInt(m1209a(4), 16));
                            break;
                        case 'x':
                            stringBuffer.append((char) Integer.parseInt(m1209a(2), 16));
                            break;
                        default:
                            stringBuffer.append(cM1211b2);
                            break;
                    }
                default:
                    if (cM1211b == c2) {
                        return stringBuffer.toString();
                    }
                    stringBuffer.append(cM1211b);
                    break;
            }
        }
    }

    /* renamed from: d */
    public Object m1213d() throws IOException, C0338b {
        char cM1212c = m1212c();
        switch (cM1212c) {
            case '\"':
            case '\'':
                return m1208a(cM1212c);
            case '(':
            case '[':
                m1210a();
                return new C0337a(this);
            case '{':
                m1210a();
                return new C0339c(this);
            default:
                StringBuffer stringBuffer = new StringBuffer();
                while (cM1212c >= ' ' && ",:]}/\\\"[{;=#".indexOf(cM1212c) < 0) {
                    stringBuffer.append(cM1212c);
                    cM1212c = m1211b();
                }
                m1210a();
                String strTrim = stringBuffer.toString().trim();
                if (strTrim.equals("")) {
                    throw m1207a("Missing value");
                }
                return C0339c.m1191m(strTrim);
        }
    }

    /* renamed from: a */
    public C0338b m1207a(String str) {
        return new C0338b(str + toString());
    }

    public String toString() {
        return " at character " + this.f779a;
    }
}
