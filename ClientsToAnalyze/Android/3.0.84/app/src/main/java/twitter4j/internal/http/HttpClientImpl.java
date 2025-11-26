package twitter4j.internal.http;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import twitter4j.TwitterException;
import twitter4j.conf.ConfigurationContext;
import twitter4j.internal.logging.Logger;
import twitter4j.internal.util.z_T4JInternalStringUtil;
import weibo4android.org.json.HTTP;

/* loaded from: classes.dex */
public class HttpClientImpl extends HttpClientBase implements Serializable, HttpClient, HttpResponseCode {
    static Class class$twitter4j$internal$http$HttpClientImpl = null;
    private static final Map<HttpClientConfiguration, HttpClient> instanceMap;
    private static boolean isJDK14orEarlier = false;
    private static final Logger logger;
    private static final long serialVersionUID = -8819171414069621503L;

    static {
        Class clsClass$;
        if (class$twitter4j$internal$http$HttpClientImpl == null) {
            clsClass$ = class$("twitter4j.internal.http.HttpClientImpl");
            class$twitter4j$internal$http$HttpClientImpl = clsClass$;
        } else {
            clsClass$ = class$twitter4j$internal$http$HttpClientImpl;
        }
        logger = Logger.getLogger(clsClass$);
        isJDK14orEarlier = false;
        try {
            String property = System.getProperty("java.specification.version");
            if (property != null) {
                isJDK14orEarlier = 1.5d > Double.parseDouble(property);
            }
            if (ConfigurationContext.getInstance().isDalvik()) {
                isJDK14orEarlier = false;
                System.setProperty("http.keepAlive", "false");
            }
        } catch (SecurityException e) {
            isJDK14orEarlier = true;
        }
        instanceMap = new HashMap(1);
    }

    static Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public HttpClientImpl() {
        super(ConfigurationContext.getInstance());
    }

    public HttpClientImpl(HttpClientConfiguration httpClientConfiguration) {
        super(httpClientConfiguration);
        if (isProxyConfigured() && isJDK14orEarlier) {
            logger.warn("HTTP Proxy is not supported on JDK1.4 or earlier. Try twitter4j-httpclient-supoprt artifact");
        }
    }

    public static HttpClient getInstance(HttpClientConfiguration httpClientConfiguration) {
        HttpClient httpClient = instanceMap.get(httpClientConfiguration);
        if (httpClient == null) {
            HttpClientImpl httpClientImpl = new HttpClientImpl(httpClientConfiguration);
            instanceMap.put(httpClientConfiguration, httpClientImpl);
            return httpClientImpl;
        }
        return httpClient;
    }

    public HttpResponse get(String str) {
        return request(new HttpRequest(RequestMethod.GET, str, null, null, null));
    }

    public HttpResponse post(String str, HttpParameter[] httpParameterArr) {
        return request(new HttpRequest(RequestMethod.POST, str, httpParameterArr, null, null));
    }

    @Override // twitter4j.internal.http.HttpClient
    public HttpResponse request(HttpRequest httpRequest) throws Throwable {
        HttpResponseImpl httpResponseImpl;
        Throwable th;
        OutputStream outputStream;
        int i;
        HttpResponseImpl httpResponseImpl2;
        HttpURLConnection connection;
        OutputStream outputStream2;
        OutputStream outputStream3;
        int httpRetryCount = this.CONF.getHttpRetryCount() + 1;
        HttpResponseImpl httpResponseImpl3 = null;
        for (int i2 = 0; i2 < httpRetryCount; i2++) {
            int responseCode = -1;
            try {
                connection = getConnection(httpRequest.getURL());
                connection.setDoInput(true);
                setHeaders(httpRequest, connection);
                connection.setRequestMethod(httpRequest.getMethod().name());
                if (httpRequest.getMethod() != RequestMethod.POST) {
                    outputStream2 = null;
                } else {
                    if (HttpParameter.containsFile(httpRequest.getParameters())) {
                        String string = new StringBuffer().append("----Twitter4J-upload").append(System.currentTimeMillis()).toString();
                        connection.setRequestProperty("Content-Type", new StringBuffer().append("multipart/form-data; boundary=").append(string).toString());
                        String string2 = new StringBuffer().append("--").append(string).toString();
                        connection.setDoOutput(true);
                        outputStream3 = connection.getOutputStream();
                        try {
                            DataOutputStream dataOutputStream = new DataOutputStream(outputStream3);
                            for (HttpParameter httpParameter : httpRequest.getParameters()) {
                                if (httpParameter.isFile()) {
                                    write(dataOutputStream, new StringBuffer().append(string2).append(HTTP.CRLF).toString());
                                    write(dataOutputStream, new StringBuffer().append("Content-Disposition: form-data; name=\"").append(httpParameter.getName()).append("\"; filename=\"").append(httpParameter.getFile().getName()).append("\"\r\n").toString());
                                    write(dataOutputStream, new StringBuffer().append("Content-Type: ").append(httpParameter.getContentType()).append("\r\n\r\n").toString());
                                    BufferedInputStream bufferedInputStream = new BufferedInputStream(httpParameter.hasFileBody() ? httpParameter.getFileBody() : new FileInputStream(httpParameter.getFile()));
                                    while (true) {
                                        int i3 = bufferedInputStream.read();
                                        if (i3 == -1) {
                                            break;
                                        }
                                        dataOutputStream.write(i3);
                                    }
                                    write(dataOutputStream, HTTP.CRLF);
                                    bufferedInputStream.close();
                                } else {
                                    write(dataOutputStream, new StringBuffer().append(string2).append(HTTP.CRLF).toString());
                                    write(dataOutputStream, new StringBuffer().append("Content-Disposition: form-data; name=\"").append(httpParameter.getName()).append("\"\r\n").toString());
                                    write(dataOutputStream, "Content-Type: text/plain; charset=UTF-8\r\n\r\n");
                                    logger.debug(httpParameter.getValue());
                                    dataOutputStream.write(httpParameter.getValue().getBytes("UTF-8"));
                                    write(dataOutputStream, HTTP.CRLF);
                                }
                            }
                            write(dataOutputStream, new StringBuffer().append(string2).append("--\r\n").toString());
                            write(dataOutputStream, HTTP.CRLF);
                        } catch (Throwable th2) {
                            httpResponseImpl = httpResponseImpl3;
                            th = th2;
                            outputStream = outputStream3;
                            i = -1;
                            try {
                                try {
                                    outputStream.close();
                                } catch (IOException e) {
                                    e = e;
                                    responseCode = i;
                                    httpResponseImpl2 = httpResponseImpl;
                                }
                            } catch (Exception e2) {
                            }
                            throw th;
                        }
                    } else {
                        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                        String strEncodeParameters = HttpParameter.encodeParameters(httpRequest.getParameters());
                        logger.debug("Post Params: ", strEncodeParameters);
                        byte[] bytes = strEncodeParameters.getBytes("UTF-8");
                        connection.setRequestProperty("Content-Length", Integer.toString(bytes.length));
                        connection.setDoOutput(true);
                        outputStream3 = connection.getOutputStream();
                        outputStream3.write(bytes);
                    }
                    outputStream3.flush();
                    outputStream3.close();
                    outputStream2 = outputStream3;
                }
                try {
                    httpResponseImpl2 = new HttpResponseImpl(connection, this.CONF);
                } catch (Throwable th3) {
                    i = -1;
                    OutputStream outputStream4 = outputStream2;
                    httpResponseImpl = httpResponseImpl3;
                    th = th3;
                    outputStream = outputStream4;
                }
            } catch (Throwable th4) {
                httpResponseImpl = httpResponseImpl3;
                th = th4;
                outputStream = null;
                i = -1;
            }
            try {
                responseCode = connection.getResponseCode();
                if (logger.isDebugEnabled()) {
                    logger.debug("Response: ");
                    Map<String, List<String>> headerFields = connection.getHeaderFields();
                    for (String str : headerFields.keySet()) {
                        for (String str2 : headerFields.get(str)) {
                            if (str != null) {
                                logger.debug(new StringBuffer().append(str).append(": ").append(str2).toString());
                            } else {
                                logger.debug(str2);
                            }
                        }
                    }
                }
                if (responseCode < 200 || (responseCode != 302 && 300 <= responseCode)) {
                    if (responseCode == 420 || responseCode == 400 || responseCode < 500 || i2 == this.CONF.getHttpRetryCount()) {
                        throw new TwitterException(httpResponseImpl2.asString(), httpResponseImpl2);
                    }
                    try {
                        try {
                            outputStream2.close();
                        } catch (IOException e3) {
                            e = e3;
                        }
                    } catch (Exception e4) {
                    }
                    httpResponseImpl3 = httpResponseImpl2;
                    try {
                        if (logger.isDebugEnabled() && httpResponseImpl3 != null) {
                            httpResponseImpl3.asString();
                        }
                        logger.debug(new StringBuffer().append("Sleeping ").append(this.CONF.getHttpRetryIntervalSeconds()).append(" seconds until the next retry.").toString());
                        Thread.sleep(this.CONF.getHttpRetryIntervalSeconds() * 1000);
                    } catch (InterruptedException e5) {
                    }
                } else {
                    try {
                        outputStream2.close();
                    } catch (Exception e6) {
                    }
                    return httpResponseImpl2;
                }
                e = e3;
                if (i2 == this.CONF.getHttpRetryCount()) {
                    throw new TwitterException(e.getMessage(), e, responseCode);
                }
                httpResponseImpl3 = httpResponseImpl2;
                if (logger.isDebugEnabled()) {
                    httpResponseImpl3.asString();
                }
                logger.debug(new StringBuffer().append("Sleeping ").append(this.CONF.getHttpRetryIntervalSeconds()).append(" seconds until the next retry.").toString());
                Thread.sleep(this.CONF.getHttpRetryIntervalSeconds() * 1000);
            } catch (Throwable th5) {
                th = th5;
                outputStream = outputStream2;
                httpResponseImpl = httpResponseImpl2;
                i = responseCode;
                outputStream.close();
                throw th;
            }
        }
        return httpResponseImpl3;
    }

    public static String encode(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError("will never happen");
        }
    }

    private void setHeaders(HttpRequest httpRequest, HttpURLConnection httpURLConnection) {
        String authorizationHeader;
        if (logger.isDebugEnabled()) {
            logger.debug("Request: ");
            logger.debug(new StringBuffer().append(httpRequest.getMethod().name()).append(" ").toString(), httpRequest.getURL());
        }
        if (httpRequest.getAuthorization() != null && (authorizationHeader = httpRequest.getAuthorization().getAuthorizationHeader(httpRequest)) != null) {
            if (logger.isDebugEnabled()) {
                logger.debug("Authorization: ", z_T4JInternalStringUtil.maskString(authorizationHeader));
            }
            httpURLConnection.addRequestProperty("Authorization", authorizationHeader);
        }
        if (httpRequest.getRequestHeaders() != null) {
            for (String str : httpRequest.getRequestHeaders().keySet()) {
                httpURLConnection.addRequestProperty(str, httpRequest.getRequestHeaders().get(str));
                logger.debug(new StringBuffer().append(str).append(": ").append(httpRequest.getRequestHeaders().get(str)).toString());
            }
        }
    }

    private HttpURLConnection getConnection(String str) {
        HttpURLConnection httpURLConnection;
        if (isProxyConfigured() && !isJDK14orEarlier) {
            if (this.CONF.getHttpProxyUser() != null && !this.CONF.getHttpProxyUser().equals("")) {
                if (logger.isDebugEnabled()) {
                    logger.debug(new StringBuffer().append("Proxy AuthUser: ").append(this.CONF.getHttpProxyUser()).toString());
                    logger.debug(new StringBuffer().append("Proxy AuthPassword: ").append(z_T4JInternalStringUtil.maskString(this.CONF.getHttpProxyPassword())).toString());
                }
                Authenticator.setDefault(new Authenticator(this) { // from class: twitter4j.internal.http.HttpClientImpl.1
                    private final HttpClientImpl this$0;

                    {
                        this.this$0 = this;
                    }

                    @Override // java.net.Authenticator
                    protected PasswordAuthentication getPasswordAuthentication() {
                        if (getRequestorType().equals(Authenticator.RequestorType.PROXY)) {
                            return new PasswordAuthentication(this.this$0.CONF.getHttpProxyUser(), this.this$0.CONF.getHttpProxyPassword().toCharArray());
                        }
                        return null;
                    }
                });
            }
            Proxy proxy = new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(this.CONF.getHttpProxyHost(), this.CONF.getHttpProxyPort()));
            if (logger.isDebugEnabled()) {
                logger.debug(new StringBuffer().append("Opening proxied connection(").append(this.CONF.getHttpProxyHost()).append(":").append(this.CONF.getHttpProxyPort()).append(")").toString());
            }
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection(proxy);
        } else {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        }
        if (this.CONF.getHttpConnectionTimeout() > 0 && !isJDK14orEarlier) {
            httpURLConnection.setConnectTimeout(this.CONF.getHttpConnectionTimeout());
        }
        if (this.CONF.getHttpReadTimeout() > 0 && !isJDK14orEarlier) {
            httpURLConnection.setReadTimeout(this.CONF.getHttpReadTimeout());
        }
        httpURLConnection.setInstanceFollowRedirects(false);
        return httpURLConnection;
    }
}
