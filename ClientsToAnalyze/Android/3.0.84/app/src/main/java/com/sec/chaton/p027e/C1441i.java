package com.sec.chaton.p027e;

import android.net.Uri;
import android.provider.BaseColumns;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.e.i */
/* loaded from: classes.dex */
public class C1441i implements BaseColumns {

    /* renamed from: a */
    public static final Uri f5369a = C1439g.f5367b.buildUpon().appendPath("buddy").build();

    /* renamed from: a */
    public static Uri m6306a(String str) {
        return f5369a.buildUpon().appendPath("buddy_no").appendPath(str).build();
    }

    /* renamed from: a */
    public static Uri m6305a() {
        return f5369a.buildUpon().appendEncodedPath("alphabetical").build();
    }

    /* renamed from: b */
    public static Uri m6308b() {
        return f5369a.buildUpon().appendEncodedPath("alphabetical2").build();
    }

    /* renamed from: c */
    public static Uri m6310c() {
        return f5369a.buildUpon().appendPath("profile").build();
    }

    /* renamed from: d */
    public static Uri m6311d() {
        return f5369a.buildUpon().appendPath("participants").build();
    }

    /* renamed from: e */
    public static Uri m6312e() {
        return f5369a.buildUpon().appendPath("unknown_calllogs").build();
    }

    /* renamed from: f */
    public static Uri m6313f() {
        return f5369a.buildUpon().appendPath("participants_no_same").build();
    }

    /* renamed from: g */
    public static Uri m6314g() {
        return f5369a.buildUpon().appendEncodedPath("alphabetical_special").build();
    }

    /* renamed from: h */
    public static Uri m6315h() {
        return f5369a.buildUpon().appendEncodedPath("buddygroup_chatonv").build();
    }

    /* renamed from: i */
    public static Uri m6316i() {
        return f5369a.buildUpon().appendEncodedPath("buddy_count").build();
    }

    /* renamed from: j */
    public static Uri m6317j() {
        return f5369a.buildUpon().appendEncodedPath("hide_buddy_count").build();
    }

    /* renamed from: k */
    public static Uri m6318k() {
        return f5369a.buildUpon().appendEncodedPath("buddy_included_group").build();
    }

    /* renamed from: a */
    public static String m6307a(Uri uri) {
        return uri.getPathSegments().get(1);
    }

    /* renamed from: b */
    public static String m6309b(Uri uri) {
        return uri.getPathSegments().get(2);
    }

    /* renamed from: l */
    public static Uri m6319l() {
        return f5369a.buildUpon().appendEncodedPath("get_hide_buddy").build();
    }
}
