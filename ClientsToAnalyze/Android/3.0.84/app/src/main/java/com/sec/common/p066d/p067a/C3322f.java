package com.sec.common.p066d.p067a;

import android.text.TextUtils;
import com.sec.common.C3330f;
import com.sec.common.util.C3364o;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

/* compiled from: HttpUtils.java */
/* renamed from: com.sec.common.d.a.f */
/* loaded from: classes.dex */
public class C3322f {
    /* renamed from: a */
    public static String m11705a(String str, Map<String, String> map) {
        boolean z;
        boolean z2 = str.contains("?");
        if (map != null && map.size() > 0) {
            StringBuffer stringBuffer = new StringBuffer(str);
            boolean z3 = z2;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (z3) {
                    stringBuffer.append("&");
                    z = z3;
                } else {
                    stringBuffer.append("?");
                    z = true;
                }
                stringBuffer.append(entry.getKey() + "=" + entry.getValue());
                z3 = z;
            }
            return stringBuffer.toString();
        }
        return str;
    }

    /* renamed from: a */
    public static void m11706a(String str, HttpURLConnection httpURLConnection) {
        C3330f.f12033a.m11651a(str, "[Request information] >>>>>");
        C3330f.f12033a.m11651a(str, C3364o.m11849a("\tRequest Method: ", httpURLConnection.getRequestMethod()));
        for (Map.Entry<String, List<String>> entry : httpURLConnection.getRequestProperties().entrySet()) {
            C3330f.f12033a.m11651a(str, C3364o.m11849a("\tHeader Key: ", entry.getKey(), ", Value: ", entry.getValue()));
        }
        C3330f.f12033a.m11651a(str, "[Request information] <<<<<");
    }

    /* renamed from: b */
    public static void m11707b(String str, HttpURLConnection httpURLConnection) {
        C3330f.f12033a.m11651a(str, "[Response information] >>>>>");
        try {
            C3330f.f12033a.m11651a(str, C3364o.m11849a("\tResponse Code: ", Integer.valueOf(httpURLConnection.getResponseCode())));
        } catch (IOException e) {
        }
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        if (headerFields != null) {
            for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
                if (!TextUtils.isEmpty(entry.getKey())) {
                    C3330f.f12033a.m11651a(str, C3364o.m11849a("\tHeader Key: ", entry.getKey(), ", Value: ", entry.getValue()));
                }
            }
        }
        C3330f.f12033a.m11651a(str, "[Response information] <<<<<");
    }
}
