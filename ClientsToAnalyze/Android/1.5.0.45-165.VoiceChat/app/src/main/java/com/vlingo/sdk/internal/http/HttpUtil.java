package com.vlingo.sdk.internal.http;

import android.util.Log;
import com.coolots.chaton.call.screenshare.util.ScreenSharePacket;
import com.infraware.office.evengine.InterfaceC0507E;
import com.sec.spp.push.Config;
import com.vlingo.sdk.internal.logging.Logger;
import com.vlingo.sdk.internal.net.ConnectionManager;
import com.vlingo.sdk.internal.net.ConnectionProvider;
import com.vlingo.sdk.internal.net.HttpConnection;
import com.vlingo.sdk.internal.recognizer.ClientMeta;
import com.vlingo.sdk.internal.recognizer.SoftwareMeta;
import com.vlingo.sdk.internal.util.StringUtils;
import com.vlingo.sdk.internal.util.XmlUtils;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.Enumeration;
import java.util.Hashtable;

/* loaded from: classes.dex */
public class HttpUtil {
    public static final String HEADER_CONNECTION = "Connection";
    public static final String HEADER_CONTENT_LENGTH = "Content-Length";
    public static final String HEADER_CONTENT_TYPE = "Content-type";
    public static final String HEADER_COOKIE = "Cookie";
    public static final String HEADER_SET_COOKIE = "Set-Cookie";
    public static final String HEADER_STATUS = "STATUS";
    public static final String HEADER_TRANSFER_ENCODING = "Transfer-Encoding";
    public static final String HEADER_USER_AGENT = "User-Agent";
    public static final String METHOD_GET = "GET";
    public static final String METHOD_HEAD = "HEAD";
    public static final String METHOD_POST = "POST";
    public static final String VAL_CHUNKED = "chunked";
    public static final String VAL_CLOSE = "Close";
    public static final String VAL_KEEP_ALIVE = "keep-alive";
    public static char LF_CHAR = '\n';
    public static char CR_CHAR = '\r';

    /* renamed from: CR */
    public static String f3251CR = new StringBuilder().append(CR_CHAR).toString();

    /* renamed from: LF */
    public static String f3252LF = new StringBuilder().append(LF_CHAR).toString();
    public static String CRLF = new StringBuilder().append(CR_CHAR).append(LF_CHAR).toString();
    public static byte[] CRLF_BYTES = CRLF.getBytes();
    private static final Logger log = Logger.getLogger(HttpUtil.class);

    public static void println(OutputStream out, String line) throws IOException {
        if (out == null) {
            throw new IllegalArgumentException("out is null");
        }
        out.write(line.getBytes());
        out.write(CRLF_BYTES);
    }

    public static void writeCRLF(OutputStream dout) throws IOException {
        println(dout, "");
    }

    public static String readLine(DataInputStream in) throws IOException {
        int it = in.read();
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        while (it >= 0 && it != LF_CHAR) {
            bout.write(it);
            it = in.read();
        }
        if (bout.size() == 0) {
            return null;
        }
        return bout.toString();
    }

    public static byte[] readData(InputStream in) throws Throwable {
        ByteArrayOutputStream boas = null;
        try {
            ByteArrayOutputStream boas2 = new ByteArrayOutputStream();
            try {
                transfer(in, boas2);
                byte[] data = boas2.toByteArray();
                if (boas2 != null) {
                    try {
                        boas2.close();
                    } catch (Exception e) {
                    }
                }
                return data;
            } catch (Throwable th) {
                th = th;
                boas = boas2;
                if (boas != null) {
                    try {
                        boas.close();
                    } catch (Exception e2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void transfer(InputStream in, ByteArrayOutputStream out) throws IOException {
        byte[] inBuff = new byte[1024];
        boolean dataRemaining = true;
        try {
            int numToRead = in.available();
            while (dataRemaining) {
                if (numToRead <= 0) {
                    numToRead = 1;
                }
                if (numToRead > 1024) {
                    numToRead = 1024;
                }
                int bytesRead = in.read(inBuff, 0, numToRead);
                if (bytesRead < 0) {
                    dataRemaining = false;
                } else {
                    out.write(inBuff, 0, bytesRead);
                    numToRead = in.available();
                    if (numToRead == 0) {
                        out.flush();
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    public static String byteArrayToString(byte[] arr) {
        if (arr == null) {
            return "null";
        }
        try {
            if (arr.length == 0) {
                return "";
            }
            return new String(arr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "unsupported encoding: UTF-8";
        }
    }

    public static String bytesToString(byte[] buff, int offset, int length) {
        int end = offset + length;
        String str = "";
        for (int index = offset; index < end; index++) {
            if (str.length() > 0) {
                str = String.valueOf(str) + "|";
            }
            str = String.valueOf(str) + ((int) buff[index]);
        }
        return str;
    }

    public static String genAtr(String name, String value) {
        return String.valueOf(name) + "=\"" + XmlUtils.xmlEncode(value) + "\" ";
    }

    public static String getCookies(Hashtable<?, ?> cookies) throws IOException {
        Enumeration<?> iter = cookies.keys();
        StringBuffer buffer = new StringBuffer();
        while (iter.hasMoreElements()) {
            String name = (String) iter.nextElement();
            String value = (String) cookies.get(name);
            if (buffer.length() > 0) {
                buffer.append(Config.KEYVALUE_SPLIT);
            }
            buffer.append(String.valueOf(name) + "=" + value);
        }
        return buffer.toString();
    }

    public static HttpConnection newHttpConnection(String method, String url, boolean keepalive, Hashtable<?, ?> cookies, Hashtable<?, ?> extraHeaders, ClientMeta client, SoftwareMeta software) throws IOException {
        return newHttpConnection(ConnectionManager.getInstance(), method, url, keepalive, cookies, extraHeaders, client, software);
    }

    public static HttpConnection newHttpConnection(ConnectionProvider connectionProvider, String method, String url, boolean keepalive, Hashtable<?, ?> cookies, Hashtable<?, ?> extraHeaders, ClientMeta client, SoftwareMeta software) throws IOException {
        log.debug("method: " + method);
        log.debug("url:" + url);
        HttpConnection hc = (HttpConnection) connectionProvider.getConnection(url, 1, true);
        log.debug("connection opened");
        hc.setRequestMethod(method);
        log.debug("keepalive " + keepalive);
        if (keepalive) {
            hc.setRequestProperty(HEADER_CONNECTION, VAL_KEEP_ALIVE);
        }
        log.debug("extraHeaders: " + extraHeaders);
        if (extraHeaders != null) {
            Enumeration<?> e = extraHeaders.keys();
            while (e.hasMoreElements()) {
                String key = (String) e.nextElement();
                log.debug(String.valueOf(key) + ": " + extraHeaders.get(key));
                hc.setRequestProperty(key, (String) extraHeaders.get(key));
            }
        }
        if (cookies != null) {
            String cookieStr = getCookies(cookies);
            if (cookieStr.length() > 0) {
                log.debug("** setting cookie header Cookie: " + cookieStr + " for URL: " + url);
                hc.setRequestProperty(HEADER_COOKIE, cookieStr);
            }
        }
        return hc;
    }

    public static String httpStatusCodeToString(int statusCode) {
        switch (statusCode) {
            case 200:
                return "OK";
            case 301:
                return "Moved Permanently";
            case 302:
                return "Found";
            case InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_SCREENMODE_THUMBNAIL_EVENT /* 304 */:
                return "Not Modified";
            case 400:
                return "Bad Request";
            case ScreenSharePacket.SCREEN_SHARE_CMD_CHANGE_DRAWING_REQ_MODE /* 401 */:
                return "Not Authorized";
            case ScreenSharePacket.SCREEN_SHARE_CMD_CHANGE_SHARE_MODE /* 403 */:
                return "Forbidden";
            case 404:
                return "Not Found";
            case ScreenSharePacket.SCREEN_SHARE_CMD_CHNAGE_REMOTE_RESP_MODE /* 405 */:
                return "Method Not Allowed";
            case 500:
                return "Internal Server Error";
            case 502:
                return "Bad Gateway";
            case 503:
                return "Service Unavailable";
            default:
                return "Unknown";
        }
    }

    public static String getHttpResponseHeader(String headerName, HttpConnection conn) {
        String value;
        String key = "";
        int i = 0;
        while (true) {
            try {
                key = conn.getHeaderFieldKey(i);
                if (key == null) {
                    break;
                }
                if (key.equalsIgnoreCase(headerName) && (value = conn.getHeaderField(i)) != null) {
                    log.debug("** getHttpResponseHeader: name=" + headerName + " value=" + value);
                }
                i++;
            } catch (IOException e) {
            }
        }
        return key;
    }

    public static Hashtable<String, String> getCacheControlHeaders(HttpConnection conn) {
        String[] parts;
        String key;
        String value;
        Hashtable<String, String> result = new Hashtable<>();
        String header = getHttpResponseHeader("cache-control", conn);
        if (header != null && header.length() > 0) {
            if (header.indexOf(",") != -1) {
                parts = StringUtils.split(header, ',');
            } else {
                parts = new String[]{header};
            }
            for (int i = 0; i < parts.length; i++) {
                int eqPos = header.indexOf("=");
                if (eqPos != -1) {
                    key = header.substring(0, eqPos);
                    value = header.substring(eqPos + 1, (header.length() - eqPos) - 1);
                } else {
                    key = header;
                    value = "1";
                }
                result.put(key, value);
            }
        }
        return result;
    }

    public static String getDomain(String url) {
        java.net.URL theURL = null;
        try {
            java.net.URL theURL2 = new java.net.URL(url);
            theURL = theURL2;
        } catch (MalformedURLException e) {
            log.error(HttpUtil.class.getCanonicalName(), Log.getStackTraceString(e));
        }
        if (theURL != null) {
            return theURL.getHost();
        }
        return null;
    }

    public static String getPath(String url) {
        java.net.URL theURL = null;
        try {
            java.net.URL theURL2 = new java.net.URL(url);
            theURL = theURL2;
        } catch (MalformedURLException e) {
            log.error(HttpUtil.class.getCanonicalName(), Log.getStackTraceString(e));
        }
        if (theURL != null) {
            return theURL.getPath();
        }
        return null;
    }
}
