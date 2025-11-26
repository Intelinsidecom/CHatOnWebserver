package weibo4android.http;

import java.io.File;
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
import java.security.AccessControlException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.PartBase;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.jboss.netty.handler.codec.http.HttpHeaders;
import weibo4android.Configuration;
import weibo4android.Weibo;
import weibo4android.WeiboException;

/* loaded from: classes.dex */
public class HttpClient implements Serializable {
    private static final int BAD_GATEWAY = 502;
    private static final int BAD_REQUEST = 400;
    private static final boolean DEBUG = Configuration.getDebug();
    private static final int FORBIDDEN = 403;
    private static final int INTERNAL_SERVER_ERROR = 500;
    private static final int NOT_ACCEPTABLE = 406;
    private static final int NOT_AUTHORIZED = 401;
    private static final int NOT_FOUND = 404;
    private static final int NOT_MODIFIED = 304;

    /* renamed from: OK */
    private static final int f7920OK = 200;
    private static final int SERVICE_UNAVAILABLE = 503;
    private static boolean isJDK14orEarlier = false;
    private static final long serialVersionUID = 808018030183407996L;
    private String accessTokenURL;
    private String authenticationURL;
    private String authorizationURL;
    private String basic;
    private int connectionTimeout;
    private OAuth oauth;
    private OAuthToken oauthToken;
    private String password;
    private String proxyAuthPassword;
    private String proxyAuthUser;
    private String proxyHost;
    private int proxyPort;
    private int readTimeout;
    private Map requestHeaders;
    private String requestTokenURL;
    private int retryCount;
    private int retryIntervalMillis;
    private String token;
    private String userId;

    static {
        isJDK14orEarlier = false;
        try {
            String property = System.getProperty("java.specification.version");
            if (property == null) {
                return;
            }
            isJDK14orEarlier = 1.5d > Double.parseDouble(property);
        } catch (AccessControlException e) {
            isJDK14orEarlier = true;
        }
    }

    public HttpClient(String str, String str2) {
        this();
        setUserId(str);
        setPassword(str2);
    }

    public HttpClient() {
        this.retryCount = Configuration.getRetryCount();
        this.retryIntervalMillis = Configuration.getRetryIntervalSecs() * 1000;
        this.userId = Configuration.getUser();
        this.password = Configuration.getPassword();
        this.proxyHost = Configuration.getProxyHost();
        this.proxyPort = Configuration.getProxyPort();
        this.proxyAuthUser = Configuration.getProxyUser();
        this.proxyAuthPassword = Configuration.getProxyPassword();
        this.connectionTimeout = Configuration.getConnectionTimeout();
        this.readTimeout = Configuration.getReadTimeout();
        this.requestHeaders = new HashMap();
        this.oauth = null;
        this.requestTokenURL = String.valueOf(Configuration.getScheme()) + "api.t.sina.com.cn/oauth/request_token";
        this.authorizationURL = String.valueOf(Configuration.getScheme()) + "api.t.sina.com.cn/oauth/authorize";
        this.authenticationURL = String.valueOf(Configuration.getScheme()) + "api.t.sina.com.cn/oauth/authenticate";
        this.accessTokenURL = String.valueOf(Configuration.getScheme()) + "api.t.sina.com.cn/oauth/access_token";
        this.oauthToken = null;
        this.token = null;
        this.basic = null;
        setUserAgent(null);
        setOAuthConsumer(null, null);
        setRequestHeader("Accept-Encoding", "gzip");
    }

    public void setUserId(String str) {
        this.userId = str;
        encodeBasicAuthenticationString();
    }

    public void setPassword(String str) {
        this.password = str;
        encodeBasicAuthenticationString();
    }

    public String getUserId() {
        return this.userId;
    }

    public String getPassword() {
        return this.password;
    }

    public boolean isAuthenticationEnabled() {
        return (this.basic == null && this.oauth == null) ? false : true;
    }

    public void setOAuthConsumer(String str, String str2) {
        String oAuthConsumerKey = Configuration.getOAuthConsumerKey(str);
        String oAuthConsumerSecret = Configuration.getOAuthConsumerSecret(str2);
        if (oAuthConsumerKey != null && oAuthConsumerSecret != null && oAuthConsumerKey.length() != 0 && oAuthConsumerSecret.length() != 0) {
            this.oauth = new OAuth(oAuthConsumerKey, oAuthConsumerSecret);
        }
    }

    public RequestToken setToken(String str, String str2) {
        this.token = str;
        this.oauthToken = new RequestToken(str, str2);
        return (RequestToken) this.oauthToken;
    }

    public RequestToken getOAuthRequestToken() {
        this.oauthToken = new RequestToken(httpRequest(this.requestTokenURL, null, true), this);
        return (RequestToken) this.oauthToken;
    }

    public RequestToken getOauthRequestToken(String str) {
        this.oauthToken = new RequestToken(httpRequest(this.requestTokenURL, new PostParameter[]{new PostParameter("oauth_callback", str)}, true), this);
        return (RequestToken) this.oauthToken;
    }

    public AccessToken getOAuthAccessToken(RequestToken requestToken) throws WeiboException {
        try {
            this.oauthToken = requestToken;
            this.oauthToken = new AccessToken(httpRequest(this.accessTokenURL, new PostParameter[0], true));
            return (AccessToken) this.oauthToken;
        } catch (WeiboException e) {
            throw new WeiboException("The user has not given access to the account.", e, e.getStatusCode());
        }
    }

    public AccessToken getOAuthAccessToken(RequestToken requestToken, String str) throws WeiboException {
        try {
            this.oauthToken = requestToken;
            this.oauthToken = new AccessToken(httpRequest(this.accessTokenURL, new PostParameter[]{new PostParameter("oauth_verifier", str)}, true));
            return (AccessToken) this.oauthToken;
        } catch (WeiboException e) {
            throw new WeiboException("The user has not given access to the account.", e, e.getStatusCode());
        }
    }

    public AccessToken getOAuthAccessToken(String str, String str2) throws WeiboException {
        try {
            this.oauthToken = new OAuthToken(str, str2) { // from class: weibo4android.http.HttpClient.1
            };
            this.oauthToken = new AccessToken(httpRequest(this.accessTokenURL, new PostParameter[0], true));
            return (AccessToken) this.oauthToken;
        } catch (WeiboException e) {
            throw new WeiboException("The user has not given access to the account.", e, e.getStatusCode());
        }
    }

    public AccessToken getOAuthAccessToken(String str, String str2, String str3) throws WeiboException {
        try {
            this.oauthToken = new OAuthToken(str, str2) { // from class: weibo4android.http.HttpClient.2
            };
            this.oauthToken = new AccessToken(httpRequest(this.accessTokenURL, new PostParameter[]{new PostParameter("oauth_verifier", str3)}, true));
            return (AccessToken) this.oauthToken;
        } catch (WeiboException e) {
            throw new WeiboException("The user has not given access to the account.", e, e.getStatusCode());
        }
    }

    public AccessToken getXAuthAccessToken(String str, String str2, String str3) {
        this.oauthToken = new AccessToken(httpRequest(this.accessTokenURL, new PostParameter[]{new PostParameter("x_auth_username", str), new PostParameter("x_auth_password", str2), new PostParameter("x_auth_mode", str3)}, true));
        return (AccessToken) this.oauthToken;
    }

    public void setOAuthAccessToken(AccessToken accessToken) {
        this.oauthToken = accessToken;
    }

    public void setRequestTokenURL(String str) {
        this.requestTokenURL = str;
    }

    public String getRequestTokenURL() {
        return this.requestTokenURL;
    }

    public void setAuthorizationURL(String str) {
        this.authorizationURL = str;
    }

    public String getAuthorizationURL() {
        return this.authorizationURL;
    }

    public String getAuthenticationURL() {
        return this.authenticationURL;
    }

    public void setAuthenticationURL(String str) {
        this.authenticationURL = str;
    }

    public String getAuthenticationRL() {
        return this.authenticationURL;
    }

    public void setAccessTokenURL(String str) {
        this.accessTokenURL = str;
    }

    public String getAccessTokenURL() {
        return this.accessTokenURL;
    }

    public String getProxyHost() {
        return this.proxyHost;
    }

    public void setProxyHost(String str) {
        this.proxyHost = Configuration.getProxyHost(str);
    }

    public int getProxyPort() {
        return this.proxyPort;
    }

    public void setProxyPort(int i) {
        this.proxyPort = Configuration.getProxyPort(i);
    }

    public String getProxyAuthUser() {
        return this.proxyAuthUser;
    }

    public void setProxyAuthUser(String str) {
        this.proxyAuthUser = Configuration.getProxyUser(str);
    }

    public String getProxyAuthPassword() {
        return this.proxyAuthPassword;
    }

    public void setProxyAuthPassword(String str) {
        this.proxyAuthPassword = Configuration.getProxyPassword(str);
    }

    public int getConnectionTimeout() {
        return this.connectionTimeout;
    }

    public void setConnectionTimeout(int i) {
        this.connectionTimeout = Configuration.getConnectionTimeout(i);
    }

    public int getReadTimeout() {
        return this.readTimeout;
    }

    public void setReadTimeout(int i) {
        this.readTimeout = Configuration.getReadTimeout(i);
    }

    private void encodeBasicAuthenticationString() {
        if (this.userId != null && this.password != null) {
            this.basic = "Basic " + new String(new BASE64Encoder().encode((String.valueOf(this.userId) + ":" + this.password).getBytes()));
            this.oauth = null;
        }
    }

    public void setRetryCount(int i) {
        if (i >= 0) {
            this.retryCount = Configuration.getRetryCount(i);
            return;
        }
        throw new IllegalArgumentException("RetryCount cannot be negative.");
    }

    public void setUserAgent(String str) {
        setRequestHeader("User-Agent", Configuration.getUserAgent(str));
    }

    public String getUserAgent() {
        return getRequestHeader("User-Agent");
    }

    public void setRetryIntervalSecs(int i) {
        if (i >= 0) {
            this.retryIntervalMillis = Configuration.getRetryIntervalSecs(i) * 1000;
            return;
        }
        throw new IllegalArgumentException("RetryInterval cannot be negative.");
    }

    public Response post(String str, PostParameter[] postParameterArr, boolean z) {
        PostParameter[] postParameterArr2 = new PostParameter[postParameterArr.length + 1];
        for (int i = 0; i < postParameterArr.length; i++) {
            postParameterArr2[i] = postParameterArr[i];
        }
        postParameterArr2[postParameterArr.length] = new PostParameter("source", Weibo.CONSUMER_KEY);
        return httpRequest(str, postParameterArr2, z);
    }

    public Response post(String str, String str2, String str3, boolean z) {
        return post(str, new PostParameter[]{new PostParameter(str2, str3)}, z);
    }

    public Response delete(String str, boolean z) {
        return httpRequest(str, null, z, "DELETE");
    }

    public Response multPartURL(String str, PostParameter[] postParameterArr, ImageItem imageItem, boolean z) {
        Part[] partArr;
        String strGenerateAuthorizationHeader;
        PostMethod postMethod = new PostMethod(str);
        try {
            try {
                org.apache.commons.httpclient.HttpClient httpClient = new org.apache.commons.httpclient.HttpClient();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (postParameterArr == null) {
                    partArr = new Part[1];
                } else {
                    partArr = new Part[postParameterArr.length + 1];
                }
                if (postParameterArr != null) {
                    int i = 0;
                    int length = postParameterArr.length;
                    int i2 = 0;
                    while (i2 < length) {
                        PostParameter postParameter = postParameterArr[i2];
                        partArr[i] = new StringPart(postParameter.getName(), postParameter.getValue());
                        i2++;
                        i++;
                    }
                    partArr[partArr.length - 1] = new ByteArrayPart(imageItem.getContent(), imageItem.getName(), imageItem.getImageType());
                }
                postMethod.setRequestEntity(new MultipartRequestEntity(partArr, postMethod.getParams()));
                ArrayList arrayList = new ArrayList();
                if (z) {
                    if (this.basic == null) {
                    }
                    if (this.oauth != null) {
                        strGenerateAuthorizationHeader = this.oauth.generateAuthorizationHeader("POST", str, postParameterArr, this.oauthToken);
                    } else if (this.basic != null) {
                        strGenerateAuthorizationHeader = this.basic;
                    } else {
                        throw new IllegalStateException("Neither user ID/password combination nor OAuth consumer key/secret combination supplied");
                    }
                    arrayList.add(new Header("Authorization", strGenerateAuthorizationHeader));
                    log("Authorization: " + strGenerateAuthorizationHeader);
                }
                httpClient.getHostConfiguration().getParams().setParameter("http.default-headers", arrayList);
                httpClient.executeMethod(postMethod);
                Response response = new Response();
                response.setResponseAsString(postMethod.getResponseBodyAsString());
                response.setStatusCode(postMethod.getStatusCode());
                log("multPartURL URL:" + str + ", result:" + response + ", time:" + (System.currentTimeMillis() - jCurrentTimeMillis));
                return response;
            } catch (Exception e) {
                throw new WeiboException(e.getMessage(), e, -1);
            }
        } finally {
            postMethod.releaseConnection();
        }
    }

    public Response multPartURL(String str, String str2, PostParameter[] postParameterArr, File file, boolean z) {
        Part[] partArr;
        String strGenerateAuthorizationHeader;
        PostMethod postMethod = new PostMethod(str2);
        org.apache.commons.httpclient.HttpClient httpClient = new org.apache.commons.httpclient.HttpClient();
        try {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (postParameterArr == null) {
                    partArr = new Part[1];
                } else {
                    partArr = new Part[postParameterArr.length + 1];
                }
                if (postParameterArr != null) {
                    int i = 0;
                    int length = postParameterArr.length;
                    int i2 = 0;
                    while (i2 < length) {
                        PostParameter postParameter = postParameterArr[i2];
                        partArr[i] = new StringPart(postParameter.getName(), postParameter.getValue());
                        i2++;
                        i++;
                    }
                }
                FilePart filePart = new FilePart(str, file.getName(), file, new FileType().getMIMEType(file), "UTF-8");
                filePart.setTransferEncoding(HttpHeaders.Values.BINARY);
                partArr[partArr.length - 1] = filePart;
                postMethod.setRequestEntity(new MultipartRequestEntity(partArr, postMethod.getParams()));
                ArrayList arrayList = new ArrayList();
                if (z) {
                    if (this.basic == null) {
                    }
                    if (this.oauth != null) {
                        strGenerateAuthorizationHeader = this.oauth.generateAuthorizationHeader("POST", str2, postParameterArr, this.oauthToken);
                    } else if (this.basic != null) {
                        strGenerateAuthorizationHeader = this.basic;
                    } else {
                        throw new IllegalStateException("Neither user ID/password combination nor OAuth consumer key/secret combination supplied");
                    }
                    arrayList.add(new Header("Authorization", strGenerateAuthorizationHeader));
                    log("Authorization: " + strGenerateAuthorizationHeader);
                }
                httpClient.getHostConfiguration().getParams().setParameter("http.default-headers", arrayList);
                httpClient.executeMethod(postMethod);
                Response response = new Response();
                response.setResponseAsString(postMethod.getResponseBodyAsString());
                response.setStatusCode(postMethod.getStatusCode());
                log("multPartURL URL:" + str2 + ", result:" + response + ", time:" + (System.currentTimeMillis() - jCurrentTimeMillis));
                return response;
            } catch (Exception e) {
                throw new WeiboException(e.getMessage(), e, -1);
            }
        } finally {
            postMethod.releaseConnection();
        }
    }

    class ByteArrayPart extends PartBase {
        private byte[] mData;
        private String mName;

        public ByteArrayPart(byte[] bArr, String str, String str2) {
            super(str, str2, "UTF-8", HttpHeaders.Values.BINARY);
            this.mName = str;
            this.mData = bArr;
        }

        protected void sendData(OutputStream outputStream) throws IOException {
            outputStream.write(this.mData);
        }

        protected long lengthOfData() {
            return this.mData.length;
        }

        protected void sendDispositionHeader(OutputStream outputStream) throws IOException {
            super.sendDispositionHeader(outputStream);
            StringBuilder sb = new StringBuilder();
            sb.append("; filename=\"").append(this.mName).append("\"");
            outputStream.write(sb.toString().getBytes());
        }
    }

    public Response post(String str, boolean z) {
        return httpRequest(str, new PostParameter[0], z);
    }

    public Response post(String str, PostParameter[] postParameterArr) {
        return httpRequest(str, postParameterArr, false);
    }

    public Response post(String str) {
        return httpRequest(str, new PostParameter[0], false);
    }

    public Response get(String str, boolean z) {
        return httpRequest(str, null, z);
    }

    public Response get(String str) {
        return httpRequest(str, null, false);
    }

    protected Response httpRequest(String str, PostParameter[] postParameterArr, boolean z) {
        String str2 = "GET";
        if (postParameterArr != null) {
            PostParameter[] postParameterArr2 = new PostParameter[postParameterArr.length + 1];
            for (int i = 0; i < postParameterArr.length; i++) {
                postParameterArr2[i] = postParameterArr[i];
            }
            postParameterArr2[postParameterArr.length] = new PostParameter("source", Weibo.CONSUMER_KEY);
            str2 = "POST";
            postParameterArr = postParameterArr2;
        }
        return httpRequest(str, postParameterArr, z, str2);
    }

    public Response httpRequest(String str, PostParameter[] postParameterArr, boolean z, String str2) throws Throwable {
        OutputStream outputStream;
        int i;
        int responseCode;
        Response response;
        OutputStream outputStream2;
        int i2 = this.retryCount + 1;
        Response response2 = null;
        for (int i3 = 0; i3 < i2; i3++) {
            try {
                HttpURLConnection connection = getConnection(str);
                connection.setDoInput(true);
                setHeaders(str, postParameterArr, connection, z, str2);
                if (postParameterArr != null || "POST".equals(str2)) {
                    connection.setRequestMethod("POST");
                    connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    connection.setDoOutput(true);
                    String strEncodeParameters = "";
                    if (postParameterArr != null) {
                        strEncodeParameters = encodeParameters(postParameterArr);
                    }
                    log("Post Params: ", strEncodeParameters);
                    byte[] bytes = strEncodeParameters.getBytes("UTF-8");
                    connection.setRequestProperty("Content-Length", Integer.toString(bytes.length));
                    outputStream = connection.getOutputStream();
                    try {
                        outputStream.write(bytes);
                        outputStream.flush();
                        outputStream.close();
                        outputStream2 = outputStream;
                    } catch (Throwable th) {
                        th = th;
                        i = -1;
                        try {
                            try {
                                outputStream.close();
                            } catch (Exception e) {
                            }
                            throw th;
                        } catch (IOException e2) {
                            e = e2;
                            responseCode = i;
                            response = response2;
                        }
                    }
                } else if ("DELETE".equals(str2)) {
                    connection.setRequestMethod("DELETE");
                    outputStream2 = null;
                } else {
                    connection.setRequestMethod("GET");
                    outputStream2 = null;
                }
                try {
                    response = new Response(connection);
                    try {
                        responseCode = connection.getResponseCode();
                    } catch (Throwable th2) {
                        th = th2;
                        outputStream = outputStream2;
                        response2 = response;
                        i = -1;
                    }
                    try {
                        if (DEBUG) {
                            log("Response: ");
                            Map<String, List<String>> headerFields = connection.getHeaderFields();
                            for (String str3 : headerFields.keySet()) {
                                for (String str4 : headerFields.get(str3)) {
                                    if (str3 != null) {
                                        log(String.valueOf(str3) + ": " + str4);
                                    } else {
                                        log(str4);
                                    }
                                }
                            }
                        }
                        if (responseCode != 200) {
                            if (responseCode < 500 || i3 == this.retryCount) {
                                throw new WeiboException(String.valueOf(getCause(responseCode)) + "\n" + response.asString(), responseCode);
                            }
                            try {
                                try {
                                    outputStream2.close();
                                    response2 = response;
                                } catch (IOException e3) {
                                    e = e3;
                                }
                            } catch (Exception e4) {
                                response2 = response;
                            }
                            try {
                                if (DEBUG && response2 != null) {
                                    response2.asString();
                                }
                                log("Sleeping " + this.retryIntervalMillis + " millisecs for next retry.");
                                Thread.sleep(this.retryIntervalMillis);
                            } catch (InterruptedException e5) {
                            }
                        } else {
                            try {
                                outputStream2.close();
                                return response;
                            } catch (Exception e6) {
                                return response;
                            }
                        }
                        e = e3;
                        if (i3 == this.retryCount) {
                            throw new WeiboException(e.getMessage(), e, responseCode);
                        }
                        response2 = response;
                        if (DEBUG) {
                            response2.asString();
                        }
                        log("Sleeping " + this.retryIntervalMillis + " millisecs for next retry.");
                        Thread.sleep(this.retryIntervalMillis);
                    } catch (Throwable th3) {
                        th = th3;
                        outputStream = outputStream2;
                        response2 = response;
                        i = responseCode;
                        outputStream.close();
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    outputStream = outputStream2;
                    i = -1;
                }
            } catch (Throwable th5) {
                th = th5;
                outputStream = null;
                i = -1;
            }
        }
        return response2;
    }

    public static String encodeParameters(PostParameter[] postParameterArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < postParameterArr.length; i++) {
            if (i != 0) {
                stringBuffer.append("&");
            }
            try {
                stringBuffer.append(URLEncoder.encode(postParameterArr[i].name, "UTF-8")).append("=").append(URLEncoder.encode(postParameterArr[i].value, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
            }
        }
        return stringBuffer.toString();
    }

    private void setHeaders(String str, PostParameter[] postParameterArr, HttpURLConnection httpURLConnection, boolean z, String str2) {
        String strGenerateAuthorizationHeader;
        log("Request: ");
        log(String.valueOf(str2) + " ", str);
        if (z) {
            if (this.basic == null) {
            }
            if (this.oauth != null) {
                strGenerateAuthorizationHeader = this.oauth.generateAuthorizationHeader(str2, str, postParameterArr, this.oauthToken);
            } else if (this.basic != null) {
                strGenerateAuthorizationHeader = this.basic;
            } else {
                throw new IllegalStateException("Neither user ID/password combination nor OAuth consumer key/secret combination supplied");
            }
            httpURLConnection.addRequestProperty("Authorization", strGenerateAuthorizationHeader);
            log("Authorization: " + strGenerateAuthorizationHeader);
        }
        for (String str3 : this.requestHeaders.keySet()) {
            httpURLConnection.addRequestProperty(str3, (String) this.requestHeaders.get(str3));
            log(String.valueOf(str3) + ": " + ((String) this.requestHeaders.get(str3)));
        }
    }

    public void setRequestHeader(String str, String str2) {
        this.requestHeaders.put(str, str2);
    }

    public String getRequestHeader(String str) {
        return (String) this.requestHeaders.get(str);
    }

    private HttpURLConnection getConnection(String str) {
        HttpURLConnection httpURLConnection;
        if (this.proxyHost != null && !this.proxyHost.equals("")) {
            if (this.proxyAuthUser != null && !this.proxyAuthUser.equals("")) {
                log("Proxy AuthUser: " + this.proxyAuthUser);
                log("Proxy AuthPassword: " + this.proxyAuthPassword);
                Authenticator.setDefault(new Authenticator() { // from class: weibo4android.http.HttpClient.3
                    @Override // java.net.Authenticator
                    protected PasswordAuthentication getPasswordAuthentication() {
                        if (getRequestorType().equals(Authenticator.RequestorType.PROXY)) {
                            return new PasswordAuthentication(HttpClient.this.proxyAuthUser, HttpClient.this.proxyAuthPassword.toCharArray());
                        }
                        return null;
                    }
                });
            }
            Proxy proxy = new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(this.proxyHost, this.proxyPort));
            if (DEBUG) {
                log("Opening proxied connection(" + this.proxyHost + ":" + this.proxyPort + ")");
            }
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection(proxy);
        } else {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        }
        if (this.connectionTimeout > 0 && !isJDK14orEarlier) {
            httpURLConnection.setConnectTimeout(this.connectionTimeout);
        }
        if (this.readTimeout > 0 && !isJDK14orEarlier) {
            httpURLConnection.setReadTimeout(this.readTimeout);
        }
        return httpURLConnection;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpClient)) {
            return false;
        }
        HttpClient httpClient = (HttpClient) obj;
        if (this.connectionTimeout == httpClient.connectionTimeout && this.proxyPort == httpClient.proxyPort && this.readTimeout == httpClient.readTimeout && this.retryCount == httpClient.retryCount && this.retryIntervalMillis == httpClient.retryIntervalMillis) {
            if (this.accessTokenURL == null ? httpClient.accessTokenURL != null : !this.accessTokenURL.equals(httpClient.accessTokenURL)) {
                return false;
            }
            if (this.authenticationURL.equals(httpClient.authenticationURL) && this.authorizationURL.equals(httpClient.authorizationURL)) {
                if (this.basic == null ? httpClient.basic != null : !this.basic.equals(httpClient.basic)) {
                    return false;
                }
                if (this.oauth == null ? httpClient.oauth != null : !this.oauth.equals(httpClient.oauth)) {
                    return false;
                }
                if (this.oauthToken == null ? httpClient.oauthToken != null : !this.oauthToken.equals(httpClient.oauthToken)) {
                    return false;
                }
                if (this.password == null ? httpClient.password != null : !this.password.equals(httpClient.password)) {
                    return false;
                }
                if (this.proxyAuthPassword == null ? httpClient.proxyAuthPassword != null : !this.proxyAuthPassword.equals(httpClient.proxyAuthPassword)) {
                    return false;
                }
                if (this.proxyAuthUser == null ? httpClient.proxyAuthUser != null : !this.proxyAuthUser.equals(httpClient.proxyAuthUser)) {
                    return false;
                }
                if (this.proxyHost == null ? httpClient.proxyHost != null : !this.proxyHost.equals(httpClient.proxyHost)) {
                    return false;
                }
                if (this.requestHeaders.equals(httpClient.requestHeaders) && this.requestTokenURL.equals(httpClient.requestTokenURL)) {
                    if (this.userId != null) {
                        if (this.userId.equals(httpClient.userId)) {
                            return true;
                        }
                    } else if (httpClient.userId == null) {
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return (((this.accessTokenURL != null ? this.accessTokenURL.hashCode() : 0) + (((((((((this.oauth != null ? this.oauth.hashCode() : 0) + (((((((((this.proxyAuthPassword != null ? this.proxyAuthPassword.hashCode() : 0) + (((this.proxyAuthUser != null ? this.proxyAuthUser.hashCode() : 0) + (((((this.proxyHost != null ? this.proxyHost.hashCode() : 0) + (((this.password != null ? this.password.hashCode() : 0) + (((this.userId != null ? this.userId.hashCode() : 0) + ((((((this.basic != null ? this.basic.hashCode() : 0) * 31) + this.retryCount) * 31) + this.retryIntervalMillis) * 31)) * 31)) * 31)) * 31) + this.proxyPort) * 31)) * 31)) * 31) + this.connectionTimeout) * 31) + this.readTimeout) * 31) + this.requestHeaders.hashCode()) * 31)) * 31) + this.requestTokenURL.hashCode()) * 31) + this.authorizationURL.hashCode()) * 31) + this.authenticationURL.hashCode()) * 31)) * 31) + (this.oauthToken != null ? this.oauthToken.hashCode() : 0);
    }

    private static void log(String str) {
        if (DEBUG) {
            System.out.println("[" + new Date() + "]" + str);
        }
    }

    private static void log(String str, String str2) {
        if (DEBUG) {
            log(String.valueOf(str) + str2);
        }
    }

    private static String getCause(int i) {
        String str = null;
        switch (i) {
            case 304:
                break;
            case 400:
                str = "The request was invalid.  An accompanying error message will explain why. This is the status code will be returned during rate limiting.";
                break;
            case 401:
                str = "Authentication credentials were missing or incorrect.";
                break;
            case 403:
                str = "The request is understood, but it has been refused.  An accompanying error message will explain why.";
                break;
            case 404:
                str = "The URI requested is invalid or the resource requested, such as a user, does not exists.";
                break;
            case 406:
                str = "Returned by the Search API when an invalid format is specified in the request.";
                break;
            case 500:
                str = "Something is broken.  Please post to the group so the Weibo team can investigate.";
                break;
            case 502:
                str = "Weibo is down or being upgraded.";
                break;
            case 503:
                str = "Service Unavailable: The Weibo servers are up, but overloaded with requests. Try again later. The search and trend methods use this to indicate when you are being rate limited.";
                break;
            default:
                str = "";
                break;
        }
        return String.valueOf(i) + ":" + str;
    }
}
