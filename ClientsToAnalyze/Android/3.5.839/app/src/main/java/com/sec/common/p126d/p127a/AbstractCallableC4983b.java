package com.sec.common.p126d.p127a;

import android.text.TextUtils;
import com.sec.common.C4996f;
import com.sec.common.p126d.p127a.C4987c;
import com.sec.common.p126d.p127a.C4989e;
import com.sec.common.util.C5034k;
import com.sec.common.util.C5048n;
import com.sec.common.util.C5052r;
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
public abstract class AbstractCallableC4983b<ContentType, ReqType extends C4987c, ResType extends C4989e> implements Callable<ResType> {

    /* renamed from: a */
    private HttpURLConnection f18189a;

    /* renamed from: b */
    private ContentType f18190b;

    /* renamed from: c */
    private ReqType f18191c;

    /* renamed from: d */
    private ResType f18192d;

    /* renamed from: e */
    private boolean f18193e;

    /* renamed from: f */
    protected String f18194f = getClass().getSimpleName();

    /* renamed from: a */
    protected abstract ResType mo6146a(ReqType reqtype);

    /* renamed from: a */
    protected abstract void mo6149a(ResType restype);

    /* renamed from: a */
    protected abstract void mo9167a(HttpURLConnection httpURLConnection, OutputStream outputStream);

    /* renamed from: b */
    protected abstract ContentType mo6150b();

    /* renamed from: b */
    protected abstract void mo10418b(HttpURLConnection httpURLConnection, InputStream inputStream);

    public AbstractCallableC4983b(ReqType reqtype) {
        this.f18191c = reqtype;
    }

    /* renamed from: h */
    public ReqType m18918h() {
        return this.f18191c;
    }

    /* renamed from: i */
    public ResType m18919i() {
        return this.f18192d;
    }

    /* renamed from: j */
    public ContentType m18920j() {
        return this.f18190b;
    }

    /* JADX WARN: Finally extract failed */
    @Override // java.util.concurrent.Callable
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public ResType call() {
        OutputStream outputStreamM18915b;
        InputStream inputStreamM18916c;
        try {
            this.f18192d = (ResType) mo6146a((AbstractCallableC4983b<ContentType, ReqType, ResType>) this.f18191c);
            this.f18190b = mo6150b();
            if (!this.f18193e) {
                if (!C5034k.m19106k()) {
                    throw new IOException("The network isn't available.");
                }
                for (int i = 0; i <= this.f18191c.m18945l(); i++) {
                    try {
                        this.f18189a = m18914a();
                        break;
                    } catch (InterruptedIOException e) {
                        if (i == this.f18191c.m18945l()) {
                            if (C4996f.f18229a.f18174f) {
                                C4996f.f18229a.m18895i(this.f18194f, "Can't connect server.");
                            }
                            throw e;
                        }
                        if (C4996f.f18229a.f18173e) {
                            C4996f.f18229a.m18894h(this.f18194f, C5052r.m19199a("Retry connect to server. [", Integer.valueOf(i + 1), "], Reason: ", e.getMessage()));
                        }
                    }
                }
                this.f18192d.m18950a(true);
                if (C4996f.f18229a.f18171c) {
                    C4996f.f18229a.m18892f(this.f18194f, "Connection is established.");
                }
                if (this.f18189a.getDoOutput()) {
                    try {
                        outputStreamM18915b = m18915b(this.f18189a, this.f18189a.getOutputStream());
                    } catch (Throwable th) {
                        th = th;
                        outputStreamM18915b = null;
                    }
                    try {
                        mo9167a(this.f18189a, outputStreamM18915b);
                        C5048n.m19195a(outputStreamM18915b);
                    } catch (Throwable th2) {
                        th = th2;
                        C5048n.m19195a(outputStreamM18915b);
                        throw th;
                    }
                }
                m18917b(this.f18189a);
                if (C4996f.f18229a.f18171c) {
                    C4990f.m18957b(this.f18194f, this.f18189a);
                }
                try {
                    if (this.f18189a.getResponseCode() >= 400) {
                        inputStreamM18916c = m18916c(this.f18189a, this.f18189a.getErrorStream());
                        mo10416a(this.f18189a, inputStreamM18916c);
                    } else {
                        inputStreamM18916c = m18916c(this.f18189a, this.f18189a.getInputStream());
                        mo10418b(this.f18189a, inputStreamM18916c);
                    }
                    C5048n.m19194a(inputStreamM18916c);
                } catch (Throwable th3) {
                    C5048n.m19194a((InputStream) null);
                    throw th3;
                }
            }
            if (this.f18189a != null) {
                this.f18189a.disconnect();
            }
            mo6149a((AbstractCallableC4983b<ContentType, ReqType, ResType>) this.f18192d);
            return this.f18192d;
        } catch (Throwable th4) {
            if (this.f18189a != null) {
                this.f18189a.disconnect();
            }
            mo6149a((AbstractCallableC4983b<ContentType, ReqType, ResType>) this.f18192d);
            throw th4;
        }
    }

    /* renamed from: k */
    protected HttpURLConnection m18921k() {
        URL url = new URL(C4990f.m18955a(this.f18191c.mo10632c(), this.f18191c.m18946m()));
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(this.f18194f, C5052r.m19199a("Connect to ", url.toString()));
        }
        return (HttpURLConnection) url.openConnection();
    }

    /* renamed from: l */
    protected final void m18922l() {
        this.f18193e = true;
    }

    /* renamed from: a */
    protected void mo10415a(HttpURLConnection httpURLConnection) throws ProtocolException {
        httpURLConnection.setRequestMethod(this.f18191c.m18942i().name());
        if (this.f18191c.m18943j() > 0) {
            httpURLConnection.setConnectTimeout(this.f18191c.m18943j());
        }
        if (this.f18191c.m18944k() > 0) {
            httpURLConnection.setReadTimeout(this.f18191c.m18944k());
        }
        if (this.f18191c.m18940g()) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        } else {
            httpURLConnection.setRequestProperty("Accept-Encoding", "identify");
        }
        if (this.f18190b != null) {
            httpURLConnection.setDoOutput(true);
            if (this.f18191c.m18939f() && this.f18191c.m18942i() == EnumC4988d.POST) {
                httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
            }
        }
        for (Map.Entry<String, String> entry : this.f18191c.m18941h().entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    /* renamed from: b */
    protected void m18917b(HttpURLConnection httpURLConnection) {
        httpURLConnection.getHeaderFields();
        Map<String, String> mapM18952l = this.f18192d.m18952l();
        if (httpURLConnection.getHeaderFields() != null) {
            Iterator<Map.Entry<String, List<String>>> it = httpURLConnection.getHeaderFields().entrySet().iterator();
            while (it.hasNext()) {
                String key = it.next().getKey();
                if (!TextUtils.isEmpty(key)) {
                    mapM18952l.put(key, httpURLConnection.getHeaderField(key));
                }
            }
        }
        this.f18192d.m18948a(httpURLConnection.getResponseCode());
        String contentType = httpURLConnection.getContentType();
        if (!TextUtils.isEmpty(contentType)) {
            this.f18192d.m18949a(contentType);
        }
    }

    /* renamed from: a */
    protected void mo10416a(HttpURLConnection httpURLConnection, InputStream inputStream) {
        AbstractC4976a abstractC4976aM18947n;
        if (inputStream != null && (abstractC4976aM18947n = this.f18191c.m18947n()) != null) {
            this.f18192d.mo18925b(abstractC4976aM18947n.parse(inputStream));
        }
    }

    /* renamed from: a */
    private HttpURLConnection m18914a() throws ProtocolException {
        HttpURLConnection httpURLConnectionM18921k = m18921k();
        mo10415a(httpURLConnectionM18921k);
        if (C4996f.f18229a.f18171c) {
            C4990f.m18956a(this.f18194f, httpURLConnectionM18921k);
        }
        httpURLConnectionM18921k.connect();
        return httpURLConnectionM18921k;
    }

    /* renamed from: c */
    private InputStream m18916c(HttpURLConnection httpURLConnection, InputStream inputStream) {
        if ("gzip".equals(httpURLConnection.getHeaderField("Content-Encoding"))) {
            return new GZIPInputStream(inputStream);
        }
        return inputStream;
    }

    /* renamed from: b */
    private OutputStream m18915b(HttpURLConnection httpURLConnection, OutputStream outputStream) {
        if ("gzip".equals(httpURLConnection.getRequestProperty("Content-Encoding"))) {
            return new GZIPOutputStream(outputStream);
        }
        return outputStream;
    }
}
