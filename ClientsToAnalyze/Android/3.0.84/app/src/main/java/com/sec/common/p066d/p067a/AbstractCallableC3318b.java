package com.sec.common.p066d.p067a;

import android.text.TextUtils;
import com.sec.common.C3330f;
import com.sec.common.p066d.p067a.C3319c;
import com.sec.common.p066d.p067a.C3321e;
import com.sec.common.util.C3347i;
import com.sec.common.util.C3350l;
import com.sec.common.util.C3364o;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: AbstractHttpTask.java */
/* renamed from: com.sec.common.d.a.b */
/* loaded from: classes.dex */
public abstract class AbstractCallableC3318b<ContentType, ReqType extends C3319c, ResType extends C3321e> implements Callable<ResType> {

    /* renamed from: a */
    private HttpURLConnection f11979a;

    /* renamed from: b */
    private ContentType f11980b;

    /* renamed from: c */
    private ReqType f11981c;

    /* renamed from: d */
    protected String f11982d = getClass().getSimpleName();

    /* renamed from: e */
    private ResType f11983e;

    /* renamed from: f */
    private boolean f11984f;

    /* renamed from: a */
    protected abstract ResType mo5487a(ReqType reqtype);

    /* renamed from: a */
    protected abstract void mo5489a(ResType restype);

    /* renamed from: a */
    protected abstract void mo11661a(HttpURLConnection httpURLConnection, InputStream inputStream);

    /* renamed from: a */
    protected abstract void mo5565a(HttpURLConnection httpURLConnection, OutputStream outputStream);

    /* renamed from: h */
    protected abstract ContentType mo5498h();

    public AbstractCallableC3318b(ReqType reqtype) {
        this.f11981c = reqtype;
    }

    /* renamed from: j */
    public ReqType m11674j() {
        return this.f11981c;
    }

    /* renamed from: k */
    public ResType m11675k() {
        return this.f11983e;
    }

    /* renamed from: l */
    public ContentType m11676l() {
        return this.f11980b;
    }

    /* renamed from: m */
    public final boolean m11677m() {
        return this.f11984f;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public ResType call() {
        OutputStream outputStreamM11669b;
        InputStream inputStreamM11670c;
        try {
            this.f11983e = (ResType) mo5487a((AbstractCallableC3318b<ContentType, ReqType, ResType>) this.f11981c);
            this.f11980b = mo5498h();
            if (!this.f11984f) {
                if (!C3347i.m11788k()) {
                    throw new IOException("The network isn't available.");
                }
                for (int i = 0; i <= this.f11981c.m11695n(); i++) {
                    try {
                        this.f11979a = m11668a();
                        break;
                    } catch (InterruptedIOException e) {
                        if (i == this.f11981c.m11695n()) {
                            ResType restype = this.f11983e;
                            if (this.f11979a == null) {
                                return restype;
                            }
                            this.f11979a.disconnect();
                            return restype;
                        }
                        if (C3330f.f12033a.f11974d) {
                            C3330f.f12033a.m11656c(this.f11982d, C3364o.m11849a("Retry connect to server. [", Integer.valueOf(i + 1), "], Reason: ", e.getMessage()));
                        }
                    }
                }
                this.f11983e.m11700a(true);
                if (C3330f.f12033a.f11972b) {
                    C3330f.f12033a.m11651a(this.f11982d, "Connection is established.");
                }
                if (this.f11979a.getDoOutput()) {
                    try {
                        outputStreamM11669b = m11669b(this.f11979a, this.f11979a.getOutputStream());
                    } catch (Throwable th) {
                        th = th;
                        outputStreamM11669b = null;
                    }
                    try {
                        mo5565a(this.f11979a, outputStreamM11669b);
                        C3350l.m11805a(outputStreamM11669b);
                    } catch (Throwable th2) {
                        th = th2;
                        C3350l.m11805a(outputStreamM11669b);
                        throw th;
                    }
                }
                m11672b(this.f11979a);
                if (C3330f.f12033a.f11972b) {
                    C3322f.m11707b(this.f11982d, this.f11979a);
                }
                try {
                    if (this.f11979a.getResponseCode() >= 400) {
                        inputStreamM11670c = m11670c(this.f11979a, this.f11979a.getErrorStream());
                        m11673b(this.f11979a, inputStreamM11670c);
                    } else {
                        inputStreamM11670c = m11670c(this.f11979a, this.f11979a.getInputStream());
                        mo11661a(this.f11979a, inputStreamM11670c);
                    }
                    C3350l.m11804a(inputStreamM11670c);
                } catch (Throwable th3) {
                    C3350l.m11804a((InputStream) null);
                    throw th3;
                }
            }
            if (this.f11979a != null) {
                this.f11979a.disconnect();
            }
            mo5489a((AbstractCallableC3318b<ContentType, ReqType, ResType>) this.f11983e);
            return this.f11983e;
        } catch (Throwable th4) {
            if (this.f11979a != null) {
                this.f11979a.disconnect();
            }
            throw th4;
        }
    }

    /* renamed from: o */
    protected HttpURLConnection m11679o() {
        URL url = new URL(C3322f.m11705a(this.f11981c.mo6703c(), this.f11981c.m11696o()));
        if (C3330f.f12033a.f11972b) {
            C3330f.f12033a.m11651a(this.f11982d, C3364o.m11849a("Connect to ", url.toString()));
        }
        return (HttpURLConnection) url.openConnection();
    }

    /* renamed from: p */
    protected final void m11680p() {
        this.f11984f = true;
    }

    /* renamed from: a */
    protected void m11671a(HttpURLConnection httpURLConnection) throws ProtocolException {
        httpURLConnection.setRequestMethod(this.f11981c.m11692k().name());
        if (this.f11981c.m11693l() > 0) {
            httpURLConnection.setConnectTimeout(this.f11981c.m11693l());
        }
        if (this.f11981c.m11694m() > 0) {
            httpURLConnection.setReadTimeout(this.f11981c.m11694m());
        }
        if (this.f11981c.m11690i()) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        } else {
            httpURLConnection.setRequestProperty("Accept-Encoding", "identify");
        }
        if (this.f11980b != null) {
            httpURLConnection.setDoOutput(true);
            if (this.f11981c.m11689h() && this.f11981c.m11692k() == EnumC3320d.POST) {
                httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
            }
        }
        for (Map.Entry<String, String> entry : this.f11981c.m11691j().entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    /* renamed from: b */
    protected void m11672b(HttpURLConnection httpURLConnection) {
        Map<String, String> mapM11702l = this.f11983e.m11702l();
        if (httpURLConnection.getHeaderFields() != null) {
            Iterator<Map.Entry<String, List<String>>> it = httpURLConnection.getHeaderFields().entrySet().iterator();
            while (it.hasNext()) {
                String key = it.next().getKey();
                if (!TextUtils.isEmpty(key)) {
                    mapM11702l.put(key, httpURLConnection.getHeaderField(key));
                }
            }
        }
        this.f11983e.m11698a(httpURLConnection.getResponseCode());
        String contentType = httpURLConnection.getContentType();
        if (!TextUtils.isEmpty(contentType)) {
            this.f11983e.m11699a(contentType);
        }
    }

    /* renamed from: b */
    protected void m11673b(HttpURLConnection httpURLConnection, InputStream inputStream) {
        AbstractC3314a abstractC3314aM11697p;
        if (inputStream != null && (abstractC3314aM11697p = this.f11981c.m11697p()) != null) {
            this.f11983e.mo11664b(abstractC3314aM11697p.parse(inputStream));
        }
    }

    /* renamed from: a */
    private HttpURLConnection m11668a() throws ProtocolException {
        HttpURLConnection httpURLConnectionM11679o = m11679o();
        m11671a(httpURLConnectionM11679o);
        if (C3330f.f12033a.f11972b) {
            C3322f.m11706a(this.f11982d, httpURLConnectionM11679o);
        }
        httpURLConnectionM11679o.connect();
        return httpURLConnectionM11679o;
    }

    /* renamed from: c */
    private InputStream m11670c(HttpURLConnection httpURLConnection, InputStream inputStream) {
        if ("gzip".equals(httpURLConnection.getHeaderField("Content-Encoding"))) {
            return new GZIPInputStream(inputStream);
        }
        return inputStream;
    }

    /* renamed from: b */
    private OutputStream m11669b(HttpURLConnection httpURLConnection, OutputStream outputStream) {
        if ("gzip".equals(httpURLConnection.getRequestProperty("Content-Encoding"))) {
            return new GZIPOutputStream(outputStream);
        }
        return outputStream;
    }
}
