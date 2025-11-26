package com.sec.chaton.p057e;

import android.net.Uri;

/* compiled from: ChatONCallContract.java */
/* renamed from: com.sec.chaton.e.f */
/* loaded from: classes.dex */
public class C2286f implements InterfaceC2285e {

    /* renamed from: a */
    public static final Uri f8192a = C2284d.f8191a.buildUpon().appendPath("calllog").build();

    /* renamed from: a */
    public static Uri m10149a(boolean z) {
        String str = "delete_oldest_calllog";
        if (z) {
            str = "delete_oldest_group_calllog";
        }
        return f8192a.buildUpon().appendPath(str).build();
    }

    /* renamed from: a */
    public static Uri m10148a() {
        return f8192a.buildUpon().appendPath("missed_call_log").build();
    }

    /* renamed from: b */
    public static Uri m10150b() {
        return f8192a.buildUpon().appendPath("rejected_call_log").build();
    }

    /* renamed from: c */
    public static Uri m10151c() {
        return f8192a.buildUpon().appendPath("rejected_call_log").build();
    }

    /* renamed from: d */
    public static Uri m10152d() {
        return f8192a.buildUpon().appendPath("search_all_call_log").build();
    }

    /* renamed from: e */
    public static Uri m10153e() {
        return f8192a.buildUpon().appendPath("get_index_call_log").build();
    }

    /* renamed from: f */
    public static Uri m10154f() {
        return f8192a.buildUpon().appendPath("search_missed_call_log").build();
    }

    /* renamed from: g */
    public static Uri m10155g() {
        return f8192a.buildUpon().appendPath("search_dialed_call_log").build();
    }

    /* renamed from: h */
    public static Uri m10156h() {
        return f8192a.buildUpon().appendPath("search_received_call_log").build();
    }

    /* renamed from: i */
    public static Uri m10157i() {
        return f8192a.buildUpon().appendPath("search_rejected_call_log").build();
    }
}
