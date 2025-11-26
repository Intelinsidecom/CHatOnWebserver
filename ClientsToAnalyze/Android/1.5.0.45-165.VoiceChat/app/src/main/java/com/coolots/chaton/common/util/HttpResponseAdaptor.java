package com.coolots.chaton.common.util;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import com.sds.coolots.common.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;

/* loaded from: classes.dex */
public class HttpResponseAdaptor extends AsyncTask<String, Void, HttpResponse> {
    private static final String CLASSNAME = "[HttpResponseAdaptor]";
    private final Handler mHandler;

    private static void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    private static void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public HttpResponseAdaptor(Handler handler) {
        this.mHandler = handler;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public HttpResponse doInBackground(String... urls) throws IOException {
        HttpClient client = new DefaultHttpClient();
        HttpConnectionParams.setConnectionTimeout(client.getParams(), 10000);
        HttpGet httpGet = new HttpGet(urls[0]);
        try {
            HttpResponse response = client.execute(httpGet);
            return response;
        } catch (ClientProtocolException e) {
            logE("ClientProtocolException " + e);
            return null;
        } catch (IOException e2) {
            logE("IOException " + e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(HttpResponse result) throws IllegalStateException, ParseException, IOException {
        String xmlString = getResponseBody(result);
        Message msg = new Message();
        msg.obj = xmlString;
        this.mHandler.sendMessage(msg);
    }

    public String getResponseBody(HttpResponse response) throws IllegalStateException, ParseException, IOException {
        HttpEntity entity = null;
        try {
            entity = response.getEntity();
            String response_text = _getResponseBody(entity);
            return response_text;
        } catch (IOException e) {
            if (entity == null) {
                return null;
            }
            try {
                entity.consumeContent();
                return null;
            } catch (IOException e1) {
                logE("IOException " + e1);
                return null;
            }
        } catch (java.text.ParseException e2) {
            logE("ParseException " + e2);
            return null;
        }
    }

    public String _getResponseBody(HttpEntity entity) throws IllegalStateException, ParseException, IOException, java.text.ParseException {
        if (entity == null) {
            throw new IllegalArgumentException("HTTP entity may not be null");
        }
        InputStream instream = entity.getContent();
        if (instream == null) {
            return "";
        }
        if (entity.getContentLength() > 2147483647L) {
            throw new IllegalArgumentException("HTTP entity too large to be buffered in memory");
        }
        String charset = getContentCharSet(entity);
        if (charset == null) {
            charset = "ISO-8859-1";
        }
        Reader reader = new InputStreamReader(instream, charset);
        StringBuilder buffer = new StringBuilder();
        try {
            char[] tmp = new char[1024];
            while (true) {
                int l = reader.read(tmp);
                if (l != -1) {
                    buffer.append(tmp, 0, l);
                } else {
                    reader.close();
                    return buffer.toString();
                }
            }
        } catch (Throwable th) {
            reader.close();
            throw th;
        }
    }

    public String getContentCharSet(HttpEntity entity) throws ParseException, java.text.ParseException {
        NameValuePair param;
        if (entity == null) {
            throw new IllegalArgumentException("HTTP entity may not be null");
        }
        if (entity.getContentType() == null) {
            return null;
        }
        HeaderElement[] values = entity.getContentType().getElements();
        if (values.length <= 0 || (param = values[0].getParameterByName("charset")) == null) {
            return null;
        }
        String charset = param.getValue();
        return charset;
    }
}
