package p010b.p014d.p015a;

import java.io.InputStream;
import java.net.HttpURLConnection;

/* compiled from: HttpResponseImpl.java */
/* renamed from: b.d.a.n */
/* loaded from: classes.dex */
public class C0299n extends AbstractC0297l {

    /* renamed from: e */
    private HttpURLConnection f674e;

    C0299n(HttpURLConnection httpURLConnection, InterfaceC0289d interfaceC0289d) {
        super(interfaceC0289d);
        this.f674e = httpURLConnection;
        this.f665b = httpURLConnection.getResponseCode();
        InputStream errorStream = httpURLConnection.getErrorStream();
        this.f667d = errorStream;
        if (errorStream == null) {
            this.f667d = httpURLConnection.getInputStream();
        }
        if (this.f667d != null && "gzip".equals(httpURLConnection.getContentEncoding())) {
            this.f667d = new C0302q(this.f667d);
        }
    }

    @Override // p010b.p014d.p015a.AbstractC0297l
    /* renamed from: a */
    public String mo1026a(String str) {
        return this.f674e.getHeaderField(str);
    }

    @Override // p010b.p014d.p015a.AbstractC0297l
    /* renamed from: d */
    public void mo1029d() {
        this.f674e.disconnect();
    }
}
