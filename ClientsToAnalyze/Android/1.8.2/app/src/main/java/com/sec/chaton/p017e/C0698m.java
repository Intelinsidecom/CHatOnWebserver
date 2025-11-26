package com.sec.chaton.p017e;

import android.net.Uri;
import android.provider.BaseColumns;
import java.util.List;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.e.m */
/* loaded from: classes.dex */
public class C0698m implements BaseColumns {

    /* renamed from: a */
    public static final Uri f2626a = C0656a.f2531b.buildUpon().appendPath("message").build();

    /* renamed from: a */
    public static Uri m3149a(String str) {
        return f2626a.buildUpon().appendPath("read_ack").appendPath(str).build();
    }

    /* renamed from: a */
    public static Uri m3147a() {
        return f2626a.buildUpon().appendPath("message_buddy").build();
    }

    /* renamed from: b */
    public static Uri m3152b() {
        return f2626a.buildUpon().appendPath("send").appendPath("inbox").build();
    }

    /* renamed from: c */
    public static Uri m3155c() {
        return f2626a.buildUpon().appendPath("received").build();
    }

    /* renamed from: a */
    public static Uri m3148a(int i) {
        return f2626a.buildUpon().appendPath("message_buddy").appendPath(Integer.toString(i)).build();
    }

    /* renamed from: b */
    public static Uri m3153b(String str) {
        return f2626a.buildUpon().appendPath("received").appendPath(str).build();
    }

    /* renamed from: c */
    public static Uri m3156c(String str) {
        return f2626a.buildUpon().appendPath("count").appendPath(str).build();
    }

    /* renamed from: a */
    public static String m3150a(Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() <= 1) {
            return null;
        }
        return pathSegments.get(1);
    }

    /* renamed from: b */
    public static String m3154b(Uri uri) {
        return uri.getPathSegments().get(2);
    }

    /* renamed from: c */
    public static String m3157c(Uri uri) {
        return uri.getPathSegments().get(2);
    }

    /* renamed from: d */
    public static String m3158d(Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() <= 2) {
            return null;
        }
        return pathSegments.get(2);
    }

    /* renamed from: a */
    public static String m3151a(Uri uri, int i) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() <= i) {
            return null;
        }
        return pathSegments.get(i);
    }

    /* renamed from: e */
    public static String m3159e(Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() <= 2) {
            return null;
        }
        return pathSegments.get(2);
    }
}
