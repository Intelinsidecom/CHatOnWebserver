package p021c.p022a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import p021c.C0325a;
import p021c.C0351j;
import p021c.p023b.p024a.C0338b;
import p021c.p023b.p024a.C0339c;

/* compiled from: Response.java */
/* renamed from: c.a.i */
/* loaded from: classes.dex */
public class C0334i {

    /* renamed from: a */
    private static final boolean f762a = C0325a.m1118p();

    /* renamed from: b */
    private static ThreadLocal<DocumentBuilder> f763b = new C0335j();

    /* renamed from: i */
    private static Pattern f764i = Pattern.compile("&#([0-9]{3,5});");

    /* renamed from: c */
    private int f765c;

    /* renamed from: f */
    private InputStream f768f;

    /* renamed from: g */
    private HttpURLConnection f769g;

    /* renamed from: d */
    private Document f766d = null;

    /* renamed from: e */
    private String f767e = null;

    /* renamed from: h */
    private boolean f770h = false;

    public C0334i() {
    }

    public C0334i(HttpURLConnection httpURLConnection) {
        this.f769g = httpURLConnection;
        this.f765c = httpURLConnection.getResponseCode();
        InputStream errorStream = httpURLConnection.getErrorStream();
        this.f768f = errorStream;
        if (errorStream == null) {
            this.f768f = httpURLConnection.getInputStream();
        }
        if (this.f768f != null && "gzip".equals(httpURLConnection.getContentEncoding())) {
            this.f768f = new GZIPInputStream(this.f768f);
        }
    }

    /* renamed from: a */
    public String m1173a(String str) {
        if (this.f769g != null) {
            return this.f769g.getHeaderField(str);
        }
        return null;
    }

    /* renamed from: a */
    public InputStream m1172a() {
        if (this.f770h) {
            throw new IllegalStateException("Stream has already been consumed.");
        }
        return this.f768f;
    }

    /* renamed from: b */
    public String m1174b() throws IOException, C0351j {
        if (this.f767e == null) {
            try {
                InputStream inputStreamM1172a = m1172a();
                if (inputStreamM1172a == null) {
                    return null;
                }
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamM1172a, "UTF-8"));
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    stringBuffer.append(line).append("\n");
                }
                this.f767e = stringBuffer.toString();
                if (C0325a.m1095b()) {
                    this.f767e = m1170b(this.f767e);
                }
                m1171c(this.f767e);
                inputStreamM1172a.close();
                this.f769g.disconnect();
                this.f770h = true;
            } catch (IOException e) {
                throw new C0351j(e.getMessage(), e);
            } catch (NullPointerException e2) {
                throw new C0351j(e2.getMessage(), e2);
            }
        }
        return this.f767e;
    }

    /* renamed from: c */
    public C0339c m1175c() throws C0351j {
        try {
            return new C0339c(m1174b());
        } catch (C0338b e) {
            throw new C0351j(e.getMessage() + ":" + this.f767e, e);
        }
    }

    /* renamed from: b */
    public static String m1170b(String str) {
        Matcher matcher = f764i.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, Character.toString((char) Integer.parseInt(matcher.group(1), 10)));
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public String toString() {
        return this.f767e != null ? this.f767e : "Response{statusCode=" + this.f765c + ", response=" + this.f766d + ", responseString='" + this.f767e + "', is=" + this.f768f + ", con=" + this.f769g + '}';
    }

    /* renamed from: c */
    private void m1171c(String str) {
        if (f762a) {
            System.out.println("[" + new Date() + "]" + str);
        }
    }
}
