package com.sec.common.p126d.p127a;

import android.text.TextUtils;
import com.sec.common.C4996f;
import com.sec.common.util.C5052r;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

/* compiled from: HttpUtils.java */
/* renamed from: com.sec.common.d.a.f */
/* loaded from: classes.dex */
public class C4990f {
    /* renamed from: a */
    public static String m18955a(String str, Map<String, String> map) {
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
    public static void m18956a(String str, HttpURLConnection httpURLConnection) {
        C4996f.f18229a.m18892f(str, "[Request information] >>>>>");
        C4996f.f18229a.m18892f(str, C5052r.m19199a("\tRequest Method: ", httpURLConnection.getRequestMethod()));
        for (Map.Entry<String, List<String>> entry : httpURLConnection.getRequestProperties().entrySet()) {
            C4996f.f18229a.m18892f(str, C5052r.m19199a("\tHeader Key: ", entry.getKey(), ", Value: ", entry.getValue()));
        }
        C4996f.f18229a.m18892f(str, "[Request information] <<<<<");
    }

    /* renamed from: b */
    public static void m18957b(String str, HttpURLConnection httpURLConnection) {
        C4996f.f18229a.m18892f(str, "[Response information] >>>>>");
        try {
            C4996f.f18229a.m18892f(str, C5052r.m19199a("\tResponse Code: ", Integer.valueOf(httpURLConnection.getResponseCode())));
        } catch (IOException e) {
        }
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        if (headerFields != null) {
            for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
                if (!TextUtils.isEmpty(entry.getKey())) {
                    C4996f.f18229a.m18892f(str, C5052r.m19199a("\tHeader Key: ", entry.getKey(), ", Value: ", entry.getValue()));
                }
            }
        }
        C4996f.f18229a.m18892f(str, "[Response information] <<<<<");
    }
}
