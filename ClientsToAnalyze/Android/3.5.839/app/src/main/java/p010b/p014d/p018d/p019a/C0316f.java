package p010b.p014d.p018d.p019a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* compiled from: JSONTokener.java */
/* renamed from: b.d.d.a.f */
/* loaded from: classes.dex */
public class C0316f {

    /* renamed from: a */
    private int f695a;

    /* renamed from: b */
    private boolean f696b;

    /* renamed from: c */
    private int f697c;

    /* renamed from: d */
    private int f698d;

    /* renamed from: e */
    private char f699e;

    /* renamed from: f */
    private Reader f700f;

    /* renamed from: g */
    private boolean f701g;

    public C0316f(Reader reader) {
        this.f700f = reader.markSupported() ? reader : new BufferedReader(reader);
        this.f696b = false;
        this.f701g = false;
        this.f699e = (char) 0;
        this.f697c = 0;
        this.f695a = 1;
        this.f698d = 1;
    }

    public C0316f(String str) {
        this(new StringReader(str));
    }

    /* renamed from: a */
    public void m1068a() throws C0312b {
        if (this.f701g || this.f697c <= 0) {
            throw new C0312b("Stepping back two steps is not supported");
        }
        this.f697c--;
        this.f695a--;
        this.f701g = true;
        this.f696b = false;
    }

    /* renamed from: b */
    public boolean m1069b() {
        return this.f696b && !this.f701g;
    }

    /* renamed from: c */
    public char m1070c() throws IOException, C0312b {
        int i;
        if (this.f701g) {
            this.f701g = false;
            i = this.f699e;
        } else {
            try {
                i = this.f700f.read();
                if (i <= 0) {
                    this.f696b = true;
                    i = 0;
                }
            } catch (IOException e) {
                throw new C0312b(e);
            }
        }
        this.f697c++;
        if (this.f699e == '\r') {
            this.f698d++;
            this.f695a = i != 10 ? 1 : 0;
        } else if (i == 10) {
            this.f698d++;
            this.f695a = 0;
        } else {
            this.f695a++;
        }
        this.f699e = (char) i;
        return this.f699e;
    }

    /* renamed from: a */
    public String m1067a(int i) throws C0312b {
        if (i == 0) {
            return "";
        }
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < i; i2++) {
            cArr[i2] = m1070c();
            if (m1069b()) {
                throw m1065a("Substring bounds error");
            }
        }
        return new String(cArr);
    }

    /* renamed from: d */
    public char m1071d() throws IOException, C0312b {
        char cM1070c;
        do {
            cM1070c = m1070c();
            if (cM1070c == 0) {
                break;
            }
        } while (cM1070c <= ' ');
        return cM1070c;
    }

    /* renamed from: a */
    public String m1066a(char c2) throws IOException, C0312b {
        StringBuilder sb = new StringBuilder();
        while (true) {
            char cM1070c = m1070c();
            switch (cM1070c) {
                case 0:
                case '\n':
                case '\r':
                    throw m1065a("Unterminated string");
                case '\\':
                    char cM1070c2 = m1070c();
                    switch (cM1070c2) {
                        case '\"':
                        case '\'':
                        case '/':
                        case '\\':
                            sb.append(cM1070c2);
                            break;
                        case 'b':
                            sb.append('\b');
                            break;
                        case 'f':
                            sb.append('\f');
                            break;
                        case 'n':
                            sb.append('\n');
                            break;
                        case 'r':
                            sb.append('\r');
                            break;
                        case 't':
                            sb.append('\t');
                            break;
                        case 'u':
                            sb.append((char) Integer.parseInt(m1067a(4), 16));
                            break;
                        default:
                            throw m1065a("Illegal escape.");
                    }
                default:
                    if (cM1070c == c2) {
                        return sb.toString();
                    }
                    sb.append(cM1070c);
                    break;
            }
        }
    }

    /* renamed from: e */
    public Object m1072e() throws IOException, C0312b {
        char cM1071d = m1071d();
        switch (cM1071d) {
            case '\"':
            case '\'':
                return m1066a(cM1071d);
            case '[':
                m1068a();
                return new C0311a(this);
            case '{':
                m1068a();
                return new C0313c(this);
            default:
                StringBuilder sb = new StringBuilder();
                while (cM1071d >= ' ' && ",:]}/\\\"[{;=#".indexOf(cM1071d) < 0) {
                    sb.append(cM1071d);
                    cM1071d = m1070c();
                }
                m1068a();
                String strTrim = sb.toString().trim();
                if (strTrim.equals("")) {
                    throw m1065a("Missing value");
                }
                return C0313c.m1055h(strTrim);
        }
    }

    /* renamed from: a */
    public C0312b m1065a(String str) {
        return new C0312b(str + toString());
    }

    public String toString() {
        return " at " + this.f697c + " [character " + this.f695a + " line " + this.f698d + "]";
    }
}
