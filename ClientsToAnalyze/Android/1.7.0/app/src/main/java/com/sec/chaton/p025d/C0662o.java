package com.sec.chaton.p025d;

import android.net.Uri;
import android.provider.BaseColumns;
import java.util.List;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.d.o */
/* loaded from: classes.dex */
public class C0662o implements BaseColumns {

    /* renamed from: a */
    public static final Uri f2289a = C0669v.f2313b.buildUpon().appendPath("message").build();

    /* renamed from: a */
    public static Uri m2996a(String str) {
        return f2289a.buildUpon().appendPath("read_ack").appendPath(str).build();
    }

    /* renamed from: a */
    public static Uri m2994a() {
        return f2289a.buildUpon().appendPath("message_buddy").build();
    }

    /* renamed from: b */
    public static Uri m2999b() {
        return f2289a.buildUpon().appendPath("received").build();
    }

    /* renamed from: a */
    public static Uri m2995a(int i) {
        return f2289a.buildUpon().appendPath("message_buddy").appendPath(Integer.toString(i)).build();
    }

    /* renamed from: b */
    public static Uri m3000b(String str) {
        return f2289a.buildUpon().appendPath("received").appendPath(str).build();
    }

    /* renamed from: c */
    public static Uri m3003c(String str) {
        return f2289a.buildUpon().appendPath("count").appendPath(str).build();
    }

    /* renamed from: c */
    public static Uri m3002c() {
        return f2289a.buildUpon().appendPath("delete").build();
    }

    /* renamed from: d */
    public static Uri m3005d() {
        return f2289a.buildUpon().appendPath("update").build();
    }

    /* renamed from: a */
    public static String m2997a(Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() <= 1) {
            return null;
        }
        return pathSegments.get(1);
    }

    /* renamed from: b */
    public static String m3001b(Uri uri) {
        return uri.getPathSegments().get(2);
    }

    /* renamed from: c */
    public static String m3004c(Uri uri) {
        return uri.getPathSegments().get(2);
    }

    /* renamed from: d */
    public static String m3006d(Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() <= 2) {
            return null;
        }
        return pathSegments.get(2);
    }

    /* renamed from: a */
    public static String m2998a(Uri uri, int i) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() <= i) {
            return null;
        }
        return pathSegments.get(i);
    }

    /* renamed from: e */
    public static String m3007e(Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() <= 2) {
            return null;
        }
        return pathSegments.get(2);
    }
}
