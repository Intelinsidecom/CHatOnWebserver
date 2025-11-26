package com.p001a.p002a;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;
import weibo4android.org.json.HTTP;

/* compiled from: Util.java */
/* renamed from: com.a.a.l */
/* loaded from: classes.dex */
public final class C0037l {
    /* renamed from: a */
    public static String m38a(Bundle bundle, String str) {
        if (bundle == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : bundle.keySet()) {
            if (bundle.getByteArray(str2) == null) {
                sb.append("Content-Disposition: form-data; name=\"" + str2 + "\"\r\n\r\n" + bundle.getString(str2));
                sb.append("\r\n--" + str + HTTP.CRLF);
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m37a(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str : bundle.keySet()) {
            if (z) {
                z = false;
            } else {
                sb.append("&");
            }
            sb.append(URLEncoder.encode(str) + "=" + URLEncoder.encode(bundle.getString(str)));
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static Bundle m36a(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String str2 : str.split("&")) {
                String[] strArrSplit = str2.split("=");
                bundle.putString(URLDecoder.decode(strArrSplit[0]), URLDecoder.decode(strArrSplit[1]));
            }
        }
        return bundle;
    }

    /* renamed from: b */
    public static Bundle m43b(String str) {
        try {
            URL url = new URL(str.replace("fbconnect", "http"));
            Bundle bundleM36a = m36a(url.getQuery());
            bundleM36a.putAll(m36a(url.getRef()));
            return bundleM36a;
        } catch (MalformedURLException e) {
            return new Bundle();
        }
    }

    /* renamed from: a */
    public static String m40a(String str, String str2, Bundle bundle) throws IOException {
        if ("GET".equals(str2)) {
            str = str + "?" + m37a(bundle);
        }
        Log.d("Facebook-Util", str2 + " URL: " + str);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestProperty("User-Agent", System.getProperties().getProperty("http.agent") + " FacebookAndroidSDK");
        if (!"GET".equals(str2)) {
            Bundle bundle2 = new Bundle();
            for (String str3 : bundle.keySet()) {
                if (bundle.getByteArray(str3) != null) {
                    bundle2.putByteArray(str3, bundle.getByteArray(str3));
                }
            }
            if (!bundle.containsKey("method")) {
                bundle.putString("method", str2);
            }
            if (bundle.containsKey("access_token")) {
                bundle.putString("access_token", URLDecoder.decode(bundle.getString("access_token")));
            }
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
            httpURLConnection.connect();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
            bufferedOutputStream.write(("--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f" + HTTP.CRLF).getBytes());
            bufferedOutputStream.write(m38a(bundle, "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f").getBytes());
            bufferedOutputStream.write((HTTP.CRLF + "--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f" + HTTP.CRLF).getBytes());
            if (!bundle2.isEmpty()) {
                for (String str4 : bundle2.keySet()) {
                    bufferedOutputStream.write(("Content-Disposition: form-data; filename=\"" + str4 + "\"" + HTTP.CRLF).getBytes());
                    bufferedOutputStream.write(("Content-Type: content/unknown" + HTTP.CRLF + HTTP.CRLF).getBytes());
                    bufferedOutputStream.write(bundle2.getByteArray(str4));
                    bufferedOutputStream.write((HTTP.CRLF + "--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f" + HTTP.CRLF).getBytes());
                }
            }
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        }
        try {
            return m39a(httpURLConnection.getInputStream());
        } catch (FileNotFoundException e) {
            return m39a(httpURLConnection.getErrorStream());
        }
    }

    /* renamed from: a */
    private static String m39a(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 1000);
        for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
            sb.append(line);
        }
        inputStream.close();
        bufferedReader.close();
        return sb.toString();
    }

    /* renamed from: a */
    public static void m41a(Context context) {
        CookieSyncManager.createInstance(context);
        CookieManager.getInstance().removeAllCookie();
    }

    /* renamed from: c */
    public static JSONObject m44c(String str) throws C0030e, JSONException {
        if ("false".equals(str)) {
            throw new C0030e("request failed");
        }
        if ("true".equals(str)) {
            str = "{value : true}";
        }
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("error")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("error");
            throw new C0030e(jSONObject2.getString("message"), jSONObject2.getString("type"), 0);
        }
        if (jSONObject.has("error_code") && jSONObject.has("error_msg")) {
            throw new C0030e(jSONObject.getString("error_msg"), "", Integer.parseInt(jSONObject.getString("error_code")));
        }
        if (jSONObject.has("error_code")) {
            throw new C0030e("request failed", "", Integer.parseInt(jSONObject.getString("error_code")));
        }
        if (jSONObject.has("error_msg")) {
            throw new C0030e(jSONObject.getString("error_msg"));
        }
        if (jSONObject.has("error_reason")) {
            throw new C0030e(jSONObject.getString("error_reason"));
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static void m42a(Context context, String str, String str2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.create().show();
    }
}
