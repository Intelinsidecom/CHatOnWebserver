package twitter4j.internal.http;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* loaded from: classes.dex */
public class HttpResponseImpl extends HttpResponse {
    private HttpURLConnection con;

    HttpResponseImpl(HttpURLConnection httpURLConnection, HttpClientConfiguration httpClientConfiguration) {
        super(httpClientConfiguration);
        this.con = httpURLConnection;
        this.statusCode = httpURLConnection.getResponseCode();
        InputStream errorStream = httpURLConnection.getErrorStream();
        this.f7896is = errorStream;
        if (errorStream == null) {
            this.f7896is = httpURLConnection.getInputStream();
        }
        if (this.f7896is != null && "gzip".equals(httpURLConnection.getContentEncoding())) {
            this.f7896is = new GZIPInputStream(this.f7896is);
        }
    }

    HttpResponseImpl(String str) {
        this.responseAsString = str;
    }

    @Override // twitter4j.internal.http.HttpResponse
    public String getResponseHeader(String str) {
        return this.con.getHeaderField(str);
    }

    @Override // twitter4j.internal.http.HttpResponse
    public Map getResponseHeaderFields() {
        return this.con.getHeaderFields();
    }

    @Override // twitter4j.internal.http.HttpResponse
    public void disconnect() {
        this.con.disconnect();
    }
}
