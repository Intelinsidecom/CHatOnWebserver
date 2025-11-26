package com.facebook.android;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.sec.pns.msg.MsgResultCode;
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

/* loaded from: classes.dex */
public final class Util {
    /* renamed from: a */
    public static Bundle m259a(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String str2 : str.split("&")) {
                String[] strArrSplit = str2.split("=");
                bundle.putString(URLDecoder.decode(strArrSplit[0]), URLDecoder.decode(strArrSplit[1]));
            }
        }
        return bundle;
    }

    /* renamed from: a */
    public static String m260a(Bundle bundle) {
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
    public static String m261a(Bundle bundle, String str) {
        if (bundle == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : bundle.keySet()) {
            if (bundle.getByteArray(str2) == null) {
                sb.append("Content-Disposition: form-data; name=\"" + str2 + "\"\r\n\r\n" + bundle.getString(str2));
                sb.append("\r\n--" + str + "\r\n");
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static String m262a(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), MsgResultCode.SUCCESS);
        for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
            sb.append(line);
        }
        inputStream.close();
        return sb.toString();
    }

    /* renamed from: a */
    public static String m263a(String str, String str2, Bundle bundle) throws IOException {
        String str3 = str2.equals("GET") ? str + "?" + m260a(bundle) : str;
        Log.d("Facebook-Util", str2 + " URL: " + str3);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str3).openConnection();
        httpURLConnection.setRequestProperty("User-Agent", System.getProperties().getProperty("http.agent") + " FacebookAndroidSDK");
        if (!str2.equals("GET")) {
            Bundle bundle2 = new Bundle();
            for (String str4 : bundle.keySet()) {
                if (bundle.getByteArray(str4) != null) {
                    bundle2.putByteArray(str4, bundle.getByteArray(str4));
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
            bufferedOutputStream.write(("--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n").getBytes());
            bufferedOutputStream.write(m261a(bundle, "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f").getBytes());
            bufferedOutputStream.write(("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n").getBytes());
            if (!bundle2.isEmpty()) {
                for (String str5 : bundle2.keySet()) {
                    bufferedOutputStream.write(("Content-Disposition: form-data; filename=\"" + str5 + "\"\r\n").getBytes());
                    bufferedOutputStream.write(("Content-Type: content/unknown\r\n\r\n").getBytes());
                    bufferedOutputStream.write(bundle2.getByteArray(str5));
                    bufferedOutputStream.write(("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n").getBytes());
                }
            }
            bufferedOutputStream.flush();
        }
        try {
            return m262a(httpURLConnection.getInputStream());
        } catch (FileNotFoundException e) {
            return m262a(httpURLConnection.getErrorStream());
        }
    }

    /* renamed from: a */
    public static void m264a(Context context) {
        CookieSyncManager.createInstance(context);
        CookieManager.getInstance().removeAllCookie();
    }

    /* renamed from: a */
    public static void m265a(Context context, String str, String str2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.create().show();
    }

    /* renamed from: b */
    public static Bundle m266b(String str) {
        try {
            URL url = new URL(str.replace("fbconnect", "http"));
            Bundle bundleM259a = m259a(url.getQuery());
            bundleM259a.putAll(m259a(url.getRef()));
            return bundleM259a;
        } catch (MalformedURLException e) {
            return new Bundle();
        }
    }

    /* renamed from: c */
    public static JSONObject m267c(String str) throws JSONException, FacebookError {
        if (str.equals("false")) {
            throw new FacebookError("request failed");
        }
        JSONObject jSONObject = new JSONObject(str.equals("true") ? "{value : true}" : str);
        if (jSONObject.has("error")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("error");
            throw new FacebookError(jSONObject2.getString("message"), jSONObject2.getString("type"), 0);
        }
        if (jSONObject.has("error_code") && jSONObject.has("error_msg")) {
            throw new FacebookError(jSONObject.getString("error_msg"), "", Integer.parseInt(jSONObject.getString("error_code")));
        }
        if (jSONObject.has("error_code")) {
            throw new FacebookError("request failed", "", Integer.parseInt(jSONObject.getString("error_code")));
        }
        if (jSONObject.has("error_msg")) {
            throw new FacebookError(jSONObject.getString("error_msg"));
        }
        if (jSONObject.has("error_reason")) {
            throw new FacebookError(jSONObject.getString("error_reason"));
        }
        return jSONObject;
    }
}
