package com.sec.chaton.p027e;

import android.net.Uri;

/* compiled from: ChatONCallContract.java */
/* renamed from: com.sec.chaton.e.f */
/* loaded from: classes.dex */
public class C1438f implements InterfaceC1437e {

    /* renamed from: a */
    public static final Uri f5365a = C1436d.f5364a.buildUpon().appendPath("calllog").build();

    /* renamed from: a */
    public static Uri m6293a(boolean z) {
        String str = "delete_oldest_calllog";
        if (z) {
            str = "delete_oldest_group_calllog";
        }
        return f5365a.buildUpon().appendPath(str).build();
    }

    /* renamed from: a */
    public static Uri m6292a() {
        return f5365a.buildUpon().appendPath("missed_call_log").build();
    }

    /* renamed from: b */
    public static Uri m6294b() {
        return f5365a.buildUpon().appendPath("rejected_call_log").build();
    }

    /* renamed from: c */
    public static Uri m6295c() {
        return f5365a.buildUpon().appendPath("rejected_call_log").build();
    }

    /* renamed from: d */
    public static Uri m6296d() {
        return f5365a.buildUpon().appendPath("search_all_call_log").build();
    }

    /* renamed from: e */
    public static Uri m6297e() {
        return f5365a.buildUpon().appendPath("get_index_call_log").build();
    }

    /* renamed from: f */
    public static Uri m6298f() {
        return f5365a.buildUpon().appendPath("search_missed_call_log").build();
    }

    /* renamed from: g */
    public static Uri m6299g() {
        return f5365a.buildUpon().appendPath("search_dialed_call_log").build();
    }

    /* renamed from: h */
    public static Uri m6300h() {
        return f5365a.buildUpon().appendPath("search_received_call_log").build();
    }

    /* renamed from: i */
    public static Uri m6301i() {
        return f5365a.buildUpon().appendPath("search_rejected_call_log").build();
    }
}
