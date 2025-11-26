package com.renren.android;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.Xml;
import com.sec.amsoma.AMSLibs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: Util.java */
/* renamed from: com.renren.android.g */
/* loaded from: classes.dex */
public final class C0214g {

    /* renamed from: a */
    public static final String f449a = System.getProperties().getProperty("http.agent") + " Renren_Android_SDK_v3.0_beta";

    /* renamed from: a */
    public static String m568a(Bundle bundle) {
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
            sb.append(str + "=" + URLEncoder.encode(bundle.getString(str)));
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static Uri m566a(String str, String str2, Bundle bundle) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("http");
        builder.authority(str);
        builder.path(str2);
        for (String str3 : bundle.keySet()) {
            Object obj = bundle.get(str3);
            if (obj instanceof String) {
                builder.appendQueryParameter(str3, (String) obj);
            }
        }
        return builder.build();
    }

    /* renamed from: a */
    public static Bundle m567a(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            bundle.putString("url", str);
            for (String str2 : str.split("&")) {
                String[] strArrSplit = str2.split("=");
                if (strArrSplit.length > 1) {
                    bundle.putString(strArrSplit[0], URLDecoder.decode(strArrSplit[1]));
                }
            }
        }
        return bundle;
    }

    /* renamed from: b */
    public static Bundle m574b(String str) {
        try {
            URL url = new URL(str.replace("rrconnect", "http").replace("#", "?"));
            Bundle bundleM567a = m567a(url.getQuery());
            bundleM567a.putAll(m567a(url.getRef()));
            return bundleM567a;
        } catch (MalformedURLException e) {
            return new Bundle();
        }
    }

    /* renamed from: b */
    public static String m575b(String str, String str2, Bundle bundle) throws IOException {
        InputStream errorStream;
        if (str2.equals("GET")) {
            str = str + "?" + m568a(bundle);
        }
        try {
            Log.d("Renren-SDK", str2 + " URL: " + str);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestProperty("User-Agent", f449a);
            if (!str2.equals("GET")) {
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.getOutputStream().write(m568a(bundle).getBytes("UTF-8"));
            }
            if (httpURLConnection.getResponseCode() == 200) {
                errorStream = httpURLConnection.getInputStream();
            } else {
                errorStream = httpURLConnection.getErrorStream();
            }
            return m569a(errorStream);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /* renamed from: a */
    private static String m569a(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 1000);
        for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
            sb.append(line);
        }
        inputStream.close();
        return sb.toString();
    }

    /* renamed from: d */
    private static C0211e m577d(String str) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("error_code");
            return new C0211e(i, C0211e.m559a(i, jSONObject.getString("error_msg")), str);
        } catch (JSONException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /* renamed from: e */
    private static C0211e m578e(String str) throws XmlPullParserException, IOException, NumberFormatException {
        int i;
        String strNextText;
        XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
        try {
            xmlPullParserNewPullParser.setInput(new StringReader(str));
            String str2 = null;
            int eventType = xmlPullParserNewPullParser.getEventType();
            int i2 = -1;
            while (eventType != 1) {
                switch (eventType) {
                    case 2:
                        if ("error_code".equals(xmlPullParserNewPullParser.getName())) {
                            i2 = Integer.parseInt(xmlPullParserNewPullParser.nextText());
                        }
                        if ("error_msg".equals(xmlPullParserNewPullParser.getName())) {
                            i = i2;
                            strNextText = xmlPullParserNewPullParser.nextText();
                            break;
                        }
                    default:
                        String str3 = str2;
                        i = i2;
                        strNextText = str3;
                        break;
                }
                if (i > -1 && strNextText != null) {
                    return new C0211e(i, strNextText, str);
                }
                eventType = xmlPullParserNewPullParser.next();
                String str4 = strNextText;
                i2 = i;
                str2 = str4;
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /* renamed from: a */
    public static void m573a(String str, String str2) throws C0212f, XmlPullParserException, JSONException, IOException, NumberFormatException {
        C0211e c0211eM578e;
        if (str != null && str.indexOf("error_code") >= 0) {
            if (Renren.RESPONSE_FORMAT_JSON.equalsIgnoreCase(str2)) {
                c0211eM578e = m577d(str);
            } else {
                c0211eM578e = m578e(str);
            }
            if (c0211eM578e != null) {
                throw new C0212f(c0211eM578e);
            }
        }
    }

    /* renamed from: a */
    public static void m572a(Context context, String str, String str2, boolean z) {
        AlertDialog alertDialogCreate = new AlertDialog.Builder(context).create();
        alertDialogCreate.setTitle(str);
        alertDialogCreate.setMessage(str2);
        if (z) {
            alertDialogCreate.setButton2("确定", (DialogInterface.OnClickListener) null);
        }
        alertDialogCreate.show();
    }

    /* renamed from: a */
    public static void m571a(Context context, String str, String str2) {
        m572a(context, str, str2, true);
    }

    /* renamed from: c */
    public static String m576c(String str) {
        if (str == null || str.trim().length() < 1) {
            return null;
        }
        try {
            return m570a(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /* renamed from: a */
    private static String m570a(byte[] bArr) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            StringBuffer stringBuffer = new StringBuffer();
            byte[] bArrDigest = messageDigest.digest(bArr);
            for (byte b : bArrDigest) {
                stringBuffer.append(Integer.toHexString((b & 240) >>> 4));
                stringBuffer.append(Integer.toHexString(b & AMSLibs.ENUM_VIP_AMS_ERROR_USERIMAGE_ID_FULL));
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
