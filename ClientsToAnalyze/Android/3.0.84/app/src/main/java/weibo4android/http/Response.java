package weibo4android.http;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import weibo4android.Configuration;
import weibo4android.WeiboException;
import weibo4android.org.json.JSONArray;
import weibo4android.org.json.JSONException;
import weibo4android.org.json.JSONObject;

/* loaded from: classes.dex */
public class Response {
    private static final boolean DEBUG = Configuration.getDebug();
    private static ThreadLocal<DocumentBuilder> builders = new ThreadLocal<DocumentBuilder>() { // from class: weibo4android.http.Response.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public DocumentBuilder initialValue() {
            try {
                return DocumentBuilderFactory.newInstance().newDocumentBuilder();
            } catch (ParserConfigurationException e) {
                throw new ExceptionInInitializerError(e);
            }
        }
    };
    private static Pattern escaped = Pattern.compile("&#([0-9]{3,5});");
    private HttpURLConnection con;

    /* renamed from: is */
    private InputStream f13761is;
    private Document responseAsDocument;
    private String responseAsString;
    private int statusCode;
    private boolean streamConsumed;

    public Response() {
        this.responseAsDocument = null;
        this.responseAsString = null;
        this.streamConsumed = false;
    }

    public Response(HttpURLConnection httpURLConnection) {
        this.responseAsDocument = null;
        this.responseAsString = null;
        this.streamConsumed = false;
        this.con = httpURLConnection;
        this.statusCode = httpURLConnection.getResponseCode();
        InputStream errorStream = httpURLConnection.getErrorStream();
        this.f13761is = errorStream;
        if (errorStream == null) {
            this.f13761is = httpURLConnection.getInputStream();
        }
        if (this.f13761is != null && "gzip".equals(httpURLConnection.getContentEncoding())) {
            this.f13761is = new GZIPInputStream(this.f13761is);
        }
    }

    Response(String str) {
        this.responseAsDocument = null;
        this.responseAsString = null;
        this.streamConsumed = false;
        this.responseAsString = str;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getResponseHeader(String str) {
        if (this.con != null) {
            return this.con.getHeaderField(str);
        }
        return null;
    }

    public InputStream asStream() {
        if (this.streamConsumed) {
            throw new IllegalStateException("Stream has already been consumed.");
        }
        return this.f13761is;
    }

    public String asString() throws IOException, WeiboException {
        if (this.responseAsString == null) {
            try {
                InputStream inputStreamAsStream = asStream();
                if (inputStreamAsStream == null) {
                    return null;
                }
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamAsStream, "UTF-8"));
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    stringBuffer.append(line).append("\n");
                }
                this.responseAsString = stringBuffer.toString();
                if (Configuration.isDalvik()) {
                    this.responseAsString = unescape(this.responseAsString);
                }
                log(this.responseAsString);
                inputStreamAsStream.close();
                this.con.disconnect();
                this.streamConsumed = true;
            } catch (IOException e) {
                throw new WeiboException(e.getMessage(), e);
            } catch (NullPointerException e2) {
                throw new WeiboException(e2.getMessage(), e2);
            }
        }
        return this.responseAsString;
    }

    public Document asDocument() throws WeiboException {
        if (this.responseAsDocument == null) {
            try {
                this.responseAsDocument = builders.get().parse(new ByteArrayInputStream(asString().getBytes("UTF-8")));
            } catch (IOException e) {
                throw new WeiboException("There's something with the connection.", e);
            } catch (SAXException e2) {
                throw new WeiboException("The response body was not well-formed:\n" + this.responseAsString, e2);
            }
        }
        return this.responseAsDocument;
    }

    public JSONObject asJSONObject() throws WeiboException {
        try {
            return new JSONObject(asString());
        } catch (JSONException e) {
            throw new WeiboException(e.getMessage() + ":" + this.responseAsString, e);
        }
    }

    public JSONArray asJSONArray() throws WeiboException {
        try {
            return new JSONArray(asString());
        } catch (Exception e) {
            throw new WeiboException(e.getMessage() + ":" + this.responseAsString, e);
        }
    }

    public InputStreamReader asReader() {
        try {
            return new InputStreamReader(this.f13761is, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return new InputStreamReader(this.f13761is);
        }
    }

    public void disconnect() {
        this.con.disconnect();
    }

    public static String unescape(String str) {
        Matcher matcher = escaped.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, Character.toString((char) Integer.parseInt(matcher.group(1), 10)));
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public String toString() {
        return this.responseAsString != null ? this.responseAsString : "Response{statusCode=" + this.statusCode + ", response=" + this.responseAsDocument + ", responseString='" + this.responseAsString + "', is=" + this.f13761is + ", con=" + this.con + '}';
    }

    private void log(String str) {
        if (DEBUG) {
            System.out.println("[" + new Date() + "]" + str);
        }
    }

    private void log(String str, String str2) {
        if (DEBUG) {
            log(str + str2);
        }
    }

    public String getResponseAsString() {
        return this.responseAsString;
    }

    public void setResponseAsString(String str) {
        this.responseAsString = str;
    }

    public void setStatusCode(int i) {
        this.statusCode = i;
    }
}
