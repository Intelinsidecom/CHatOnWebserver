package com.sec.chaton.p057e;

import android.net.Uri;
import com.sec.chaton.smsplugin.p102b.C3789h;
import java.util.ArrayList;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.e.ah */
/* loaded from: classes.dex */
public class C2220ah {

    /* renamed from: a */
    public static final Uri f7942a = C2287g.f8194b.buildUpon().appendPath("participant").build();

    /* renamed from: a */
    public static Uri m10086a(String str) {
        return f7942a.buildUpon().appendPath("participant_without_contact_buddy").appendPath(str).build();
    }

    /* renamed from: b */
    public static Uri m10090b(String str) {
        return f7942a.buildUpon().appendPath(str).build();
    }

    /* renamed from: c */
    public static Uri m10092c(String str) {
        return f7942a.buildUpon().appendPath("withphone").appendPath(str).build();
    }

    /* renamed from: a */
    public static final String m10088a(Uri uri) {
        return uri.getPathSegments().get(1);
    }

    /* renamed from: a */
    public static Uri m10085a() {
        return f7942a.buildUpon().appendPath("name_join_buddy").build();
    }

    /* renamed from: b */
    public static Uri m10089b() {
        return f7942a.buildUpon().appendPath("join_sms_buddy_buddyinfo").build();
    }

    /* renamed from: c */
    public static Uri m10091c() {
        return f7942a.buildUpon().appendPath("join_chat_buddy_buddyinfo").build();
    }

    /* renamed from: d */
    public static Uri m10093d() {
        return f7942a.buildUpon().appendPath("join_chat_specialbuddy_livebuddyinfo").build();
    }

    /* renamed from: a */
    public static Uri m10087a(String str, ArrayList<String> arrayList) {
        return f7942a.buildUpon().appendPath("insert_invited_contact_buddy").appendPath(str).appendPath(C3789h.m14301a((Iterable<String>) arrayList, false).m14308a()).build();
    }
}
