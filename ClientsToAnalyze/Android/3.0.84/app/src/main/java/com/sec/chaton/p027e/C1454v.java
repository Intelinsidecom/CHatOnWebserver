package com.sec.chaton.p027e;

import android.net.Uri;
import android.provider.BaseColumns;
import java.util.List;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.e.v */
/* loaded from: classes.dex */
public class C1454v implements BaseColumns {

    /* renamed from: a */
    public static final Uri f5393a = C1439g.f5367b.buildUpon().appendPath("message").build();

    /* renamed from: a */
    public static Uri m6343a() {
        return f5393a.buildUpon().appendPath("read_ack").build();
    }

    /* renamed from: b */
    public static Uri m6348b() {
        return f5393a.buildUpon().appendPath("message_buddy").build();
    }

    /* renamed from: c */
    public static Uri m6352c() {
        return f5393a.buildUpon().appendPath("received").build();
    }

    /* renamed from: a */
    public static Uri m6344a(int i) {
        return f5393a.buildUpon().appendPath("message_buddy").appendPath(Integer.toString(i)).build();
    }

    /* renamed from: b */
    public static Uri m6349b(int i) {
        return f5393a.buildUpon().appendPath("message_buddy_noti").appendPath(Integer.toString(i)).build();
    }

    /* renamed from: a */
    public static Uri m6345a(String str) {
        return f5393a.buildUpon().appendPath("received").appendPath(str).build();
    }

    /* renamed from: b */
    public static Uri m6350b(String str) {
        return f5393a.buildUpon().appendPath("count").appendPath(str).build();
    }

    /* renamed from: d */
    public static Uri m6354d() {
        return f5393a.buildUpon().appendPath("delete").build();
    }

    /* renamed from: e */
    public static Uri m6356e() {
        return f5393a.buildUpon().appendPath("update").build();
    }

    /* renamed from: f */
    public static Uri m6357f() {
        return f5393a.buildUpon().appendPath("get_pendings").build();
    }

    /* renamed from: a */
    public static String m6346a(Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() <= 1) {
            return null;
        }
        return pathSegments.get(1);
    }

    /* renamed from: b */
    public static String m6351b(Uri uri) {
        return uri.getPathSegments().get(2);
    }

    /* renamed from: c */
    public static String m6353c(Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() <= 2) {
            return null;
        }
        return pathSegments.get(2);
    }

    /* renamed from: a */
    public static String m6347a(Uri uri, int i) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() <= i) {
            return null;
        }
        return pathSegments.get(i);
    }

    /* renamed from: d */
    public static String m6355d(Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() <= 2) {
            return null;
        }
        return pathSegments.get(2);
    }
}
