package com.sec.chaton.p057e;

import android.net.Uri;
import android.provider.BaseColumns;
import com.p137vk.sdk.api.VKApiConst;
import java.util.List;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.e.z */
/* loaded from: classes.dex */
public class C2306z implements BaseColumns {

    /* renamed from: a */
    public static final Uri f8229a = C2287g.f8194b.buildUpon().appendPath(VKApiConst.MESSAGE).build();

    /* renamed from: a */
    public static Uri m10213a() {
        return f8229a.buildUpon().appendPath("read_ack").build();
    }

    /* renamed from: b */
    public static Uri m10218b() {
        return f8229a.buildUpon().appendPath("message_buddy").build();
    }

    /* renamed from: c */
    public static Uri m10222c() {
        return f8229a.buildUpon().appendPath("received").build();
    }

    /* renamed from: a */
    public static Uri m10214a(int i) {
        return f8229a.buildUpon().appendPath("message_buddy").appendPath(Integer.toString(i)).build();
    }

    /* renamed from: b */
    public static Uri m10219b(int i) {
        return f8229a.buildUpon().appendPath("message_buddy_noti").appendPath(Integer.toString(i)).build();
    }

    /* renamed from: a */
    public static Uri m10215a(String str) {
        return f8229a.buildUpon().appendPath("received").appendPath(str).build();
    }

    /* renamed from: b */
    public static Uri m10220b(String str) {
        return f8229a.buildUpon().appendPath(VKApiConst.COUNT).appendPath(str).build();
    }

    /* renamed from: d */
    public static Uri m10224d() {
        return f8229a.buildUpon().appendPath("delete").build();
    }

    /* renamed from: e */
    public static Uri m10226e() {
        return f8229a.buildUpon().appendPath("update").build();
    }

    /* renamed from: f */
    public static Uri m10227f() {
        return f8229a.buildUpon().appendPath("get_pendings").build();
    }

    /* renamed from: g */
    public static Uri m10228g() {
        return f8229a.buildUpon().appendPath("message_for_livechat_feedback").build();
    }

    /* renamed from: h */
    public static Uri m10229h() {
        return f8229a.buildUpon().appendPath("update_cancel_sending_status").build();
    }

    /* renamed from: a */
    public static String m10216a(Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() <= 1) {
            return null;
        }
        return pathSegments.get(1);
    }

    /* renamed from: b */
    public static String m10221b(Uri uri) {
        return uri.getPathSegments().get(2);
    }

    /* renamed from: c */
    public static String m10223c(Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() <= 2) {
            return null;
        }
        return pathSegments.get(2);
    }

    /* renamed from: a */
    public static String m10217a(Uri uri, int i) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() <= i) {
            return null;
        }
        return pathSegments.get(i);
    }

    /* renamed from: d */
    public static String m10225d(Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() <= 2) {
            return null;
        }
        return pathSegments.get(2);
    }
}
