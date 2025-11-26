package com.sec.chaton.plugin.p083b;

import android.annotation.TargetApi;
import android.net.Uri;
import com.sec.chaton.plugin.p087f.C2946a;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.apache.http.NameValuePair;

/* compiled from: HttpRequest.java */
@TargetApi(14)
/* renamed from: com.sec.chaton.plugin.b.d */
/* loaded from: classes.dex */
public class C2927d {

    /* renamed from: a */
    private static final String f10805a = C2927d.class.getSimpleName();

    /* renamed from: b */
    private String f10806b;

    /* renamed from: c */
    private C2928e f10807c = new C2928e();

    /* renamed from: d */
    private List<NameValuePair> f10808d = null;

    /* renamed from: e */
    private String f10809e;

    public C2927d(String str) {
        this.f10809e = str;
    }

    /* renamed from: a */
    public C2927d m12160a(String str) {
        this.f10806b = str;
        return this;
    }

    /* renamed from: a */
    public URL m12161a() {
        Uri.Builder builderBuildUpon = Uri.parse(this.f10809e).buildUpon();
        builderBuildUpon.encodedPath(this.f10806b);
        builderBuildUpon.encodedQuery(this.f10807c.toString());
        try {
            return new URL(builderBuildUpon.build().toString());
        } catch (MalformedURLException e) {
            C2946a.m12187a(e, f10805a);
            return null;
        }
    }
}
