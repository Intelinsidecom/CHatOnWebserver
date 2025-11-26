package com.sec.chaton.p057e;

import android.net.Uri;
import android.provider.BaseColumns;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.e.i */
/* loaded from: classes.dex */
public class C2289i implements BaseColumns {

    /* renamed from: a */
    public static final Uri f8196a = C2287g.f8194b.buildUpon().appendPath("buddy").build();

    /* renamed from: a */
    public static Uri m10161a(String str) {
        return f8196a.buildUpon().appendPath("buddy_no").appendPath(str).build();
    }

    /* renamed from: a */
    public static Uri m10160a() {
        return f8196a.buildUpon().appendEncodedPath("alphabetical").build();
    }

    /* renamed from: b */
    public static Uri m10163b() {
        return f8196a.buildUpon().appendEncodedPath("alphabetical2").build();
    }

    /* renamed from: c */
    public static Uri m10165c() {
        return f8196a.buildUpon().appendEncodedPath("alphabetical2_sms").build();
    }

    /* renamed from: d */
    public static Uri m10166d() {
        return f8196a.buildUpon().appendPath("profile").build();
    }

    /* renamed from: e */
    public static Uri m10167e() {
        return f8196a.buildUpon().appendPath("participants").build();
    }

    /* renamed from: f */
    public static Uri m10168f() {
        return f8196a.buildUpon().appendPath("unknown_calllogs").build();
    }

    /* renamed from: g */
    public static Uri m10169g() {
        return f8196a.buildUpon().appendPath("participants_no_same").build();
    }

    /* renamed from: h */
    public static Uri m10170h() {
        return f8196a.buildUpon().appendEncodedPath("alphabetical_special").build();
    }

    /* renamed from: i */
    public static Uri m10171i() {
        return f8196a.buildUpon().appendEncodedPath("buddygroup_chatonv").build();
    }

    /* renamed from: j */
    public static Uri m10172j() {
        return f8196a.buildUpon().appendEncodedPath("buddy_count").build();
    }

    /* renamed from: k */
    public static Uri m10173k() {
        return f8196a.buildUpon().appendEncodedPath("hide_buddy_count").build();
    }

    /* renamed from: l */
    public static Uri m10174l() {
        return f8196a.buildUpon().appendEncodedPath("buddy_included_group").build();
    }

    /* renamed from: a */
    public static String m10162a(Uri uri) {
        return uri.getPathSegments().get(1);
    }

    /* renamed from: b */
    public static String m10164b(Uri uri) {
        return uri.getPathSegments().get(2);
    }

    /* renamed from: m */
    public static Uri m10175m() {
        return f8196a.buildUpon().appendEncodedPath("get_hide_buddy").build();
    }
}
