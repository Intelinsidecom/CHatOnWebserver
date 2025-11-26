package com.sds.coolots.common.httpAdaptor;

import com.google.protobuf.CodedOutputStream;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: classes.dex */
public class AndroidHttpClient implements HttpClientInterface {

    /* renamed from: b */
    static final HostnameVerifier f3017b = new C1251a();

    /* renamed from: c */
    private static final String f3018c = "POST";

    /* renamed from: a */
    protected String f3019a = "[AndroidHttpClient]";

    /* renamed from: d */
    private Serializable f3020d;

    /* renamed from: e */
    private HttpURLConnection f3021e;

    /* renamed from: a */
    public void m2919a(String str) {
        Log.m2958e(String.valueOf(this.f3019a) + str);
    }

    /* renamed from: b */
    public void m2920b(String str) {
        Log.m2954d(String.valueOf(this.f3019a) + str);
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpClientInterface
    public void cancelTransaction() {
        if (this.f3021e != null) {
            this.f3021e.disconnect();
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpClientInterface
    public Serializable getTransactionResult() {
        return this.f3020d;
    }

    /* JADX WARN: Type inference failed for: r0v63, types: [byte[], java.io.Serializable] */
    @Override // com.sds.coolots.common.httpAdaptor.HttpClientInterface
    public int httpTransaction(String str, String str2, int i) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                try {
                    try {
                        try {
                            try {
                                URL url = new URL(str2);
                                this.f3021e = (HttpURLConnection) url.openConnection();
                                m2920b("CONNECTING=" + url.toString());
                                this.f3021e.setConnectTimeout(i);
                                this.f3021e.setReadTimeout(i);
                                this.f3021e.setDefaultUseCaches(false);
                                this.f3021e.setDoInput(true);
                                this.f3021e.setDoOutput(true);
                                this.f3021e.setRequestMethod("POST");
                                this.f3021e.setRequestProperty("content-type", "application/x-www-form-urlencoded");
                                StringBuilder sb = new StringBuilder();
                                sb.append("si").append("=").append(URLEncoder.encode(MainApplication.mConfig.getSessionID(), "UTF-8")).append("&");
                                sb.append("value").append("=").append(URLEncoder.encode(str, "UTF-8"));
                                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(this.f3021e.getOutputStream(), "UTF-8"));
                                bufferedWriter.write(sb.toString());
                                bufferedWriter.flush();
                                InputStream inputStream = this.f3021e.getInputStream();
                                byte[] bArr = new byte[CodedOutputStream.DEFAULT_BUFFER_SIZE];
                                while (true) {
                                    int i2 = inputStream.read(bArr);
                                    if (i2 == -1) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(bArr, 0, i2);
                                }
                                if (this.f3021e != null) {
                                    this.f3021e.disconnect();
                                    m2919a("A http connection cut");
                                }
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                if (byteArray == null || byteArray.length == 0) {
                                    return -4;
                                }
                                this.f3020d = byteArrayOutputStream.toByteArray();
                                return 0;
                            } catch (IOException e) {
                                m2919a(e.getMessage());
                                if (this.f3021e != null) {
                                    this.f3021e.disconnect();
                                    m2919a("A http connection cut");
                                }
                                return -7;
                            } catch (Error e2) {
                                m2919a(e2.getMessage());
                                if (this.f3021e != null) {
                                    this.f3021e.disconnect();
                                    m2919a("A http connection cut");
                                }
                                return -1;
                            }
                        } catch (Exception e3) {
                            m2919a(e3.getMessage());
                            if (this.f3021e != null) {
                                this.f3021e.disconnect();
                                m2919a("A http connection cut");
                            }
                            return -1;
                        } catch (OutOfMemoryError e4) {
                            m2919a(e4.getMessage());
                            if (this.f3021e != null) {
                                this.f3021e.disconnect();
                                m2919a("A http connection cut");
                            }
                            return -7;
                        }
                    } catch (MalformedURLException e5) {
                        m2919a(e5.getMessage());
                        if (this.f3021e != null) {
                            this.f3021e.disconnect();
                            m2919a("A http connection cut");
                        }
                        return -6;
                    }
                } catch (SocketTimeoutException e6) {
                    m2919a(e6.getMessage());
                    if (this.f3021e != null) {
                        this.f3021e.disconnect();
                        m2919a("A http connection cut");
                    }
                    return -10;
                }
            } catch (SocketException e7) {
                m2919a(e7.getMessage());
                if (this.f3021e != null) {
                    this.f3021e.disconnect();
                    m2919a("A http connection cut");
                }
                return -11;
            }
        } catch (Throwable th) {
            if (this.f3021e != null) {
                this.f3021e.disconnect();
                m2919a("A http connection cut");
            }
            throw th;
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpClientInterface
    public int httpsTransaction(String str, String str2, String str3, int i) {
        StringBuilder sb = new StringBuilder();
        try {
            try {
                try {
                    try {
                        try {
                            URL url = new URL(str3);
                            m2920b("CONNECTING=" + url.toString());
                            this.f3021e = (HttpsURLConnection) url.openConnection();
                            ((HttpsURLConnection) this.f3021e).setHostnameVerifier(f3017b);
                            this.f3021e.setConnectTimeout(i);
                            this.f3021e.setReadTimeout(i);
                            this.f3021e.setDefaultUseCaches(false);
                            this.f3021e.setDoInput(true);
                            this.f3021e.setDoOutput(true);
                            this.f3021e.setRequestMethod("POST");
                            this.f3021e.setRequestProperty("content-type", "application/x-www-form-urlencoded");
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("v1").append("=").append(URLEncoder.encode(str, "UTF-8")).append("&");
                            sb2.append("v2").append("=").append(URLEncoder.encode(str2, "UTF-8"));
                            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(this.f3021e.getOutputStream(), "UTF-8"));
                            bufferedWriter.write(sb2.toString());
                            bufferedWriter.flush();
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f3021e.getInputStream(), "UTF-8"));
                            while (true) {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                }
                                sb.append(line).append("\n");
                            }
                            if (this.f3021e != null) {
                                this.f3021e.disconnect();
                                m2919a("A http connection cut");
                            }
                            String string = sb.toString();
                            if (string == null || string.isEmpty()) {
                                return -4;
                            }
                            this.f3020d = string;
                            return 0;
                        } catch (IOException e) {
                            m2919a(e.getMessage());
                            if (this.f3021e != null) {
                                this.f3021e.disconnect();
                                m2919a("A http connection cut");
                            }
                            return -7;
                        } catch (Exception e2) {
                            m2919a(e2.getMessage());
                            if (this.f3021e != null) {
                                this.f3021e.disconnect();
                                m2919a("A http connection cut");
                            }
                            return -1;
                        }
                    } catch (MalformedURLException e3) {
                        m2919a(e3.getMessage());
                        if (this.f3021e != null) {
                            this.f3021e.disconnect();
                            m2919a("A http connection cut");
                        }
                        return -6;
                    }
                } catch (SocketTimeoutException e4) {
                    m2919a(e4.getMessage());
                    if (this.f3021e != null) {
                        this.f3021e.disconnect();
                        m2919a("A http connection cut");
                    }
                    return -10;
                }
            } catch (SocketException e5) {
                m2919a(e5.getMessage());
                if (this.f3021e != null) {
                    this.f3021e.disconnect();
                    m2919a("A http connection cut");
                }
                return -11;
            }
        } catch (Throwable th) {
            if (this.f3021e != null) {
                this.f3021e.disconnect();
                m2919a("A http connection cut");
            }
            throw th;
        }
    }
}
