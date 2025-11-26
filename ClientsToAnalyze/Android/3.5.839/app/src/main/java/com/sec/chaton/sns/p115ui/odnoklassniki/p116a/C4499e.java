package com.sec.chaton.sns.p115ui.odnoklassniki.p116a;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: OkNetUtil.java */
/* renamed from: com.sec.chaton.sns.ui.odnoklassniki.a.e */
/* loaded from: classes.dex */
public class C4499e {
    /* renamed from: a */
    public static final String m17038a(HttpClient httpClient, String str, Map<String, String> map) {
        HttpPost httpPost = new HttpPost(str);
        if (map != null && !map.isEmpty()) {
            ArrayList arrayList = new ArrayList(map.size());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                arrayList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            try {
                httpPost.setEntity(new UrlEncodedFormEntity(arrayList, "utf-8"));
            } catch (Exception e) {
            }
        }
        return m17039a(httpClient, httpPost);
    }

    /* renamed from: b */
    public static final String m17040b(HttpClient httpClient, String str, Map<String, String> map) {
        String str2 = null;
        if (map != null && !map.isEmpty()) {
            ArrayList arrayList = new ArrayList(map.size());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                arrayList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            str2 = URLEncodedUtils.format(arrayList, "utf-8");
        }
        if (str2 != null) {
            str = str + "?" + str2;
        }
        return m17039a(httpClient, new HttpGet(str));
    }

    /* renamed from: a */
    private static final String m17039a(HttpClient httpClient, HttpRequestBase httpRequestBase) throws IOException {
        HttpEntity entity = httpClient.execute(httpRequestBase).getEntity();
        if (entity != null) {
            try {
                return C4498d.m17036a(entity.getContent());
            } catch (Exception e) {
                return null;
            }
        }
        throw new IOException();
    }
}
