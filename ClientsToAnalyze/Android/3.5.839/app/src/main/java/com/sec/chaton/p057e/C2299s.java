package com.sec.chaton.p057e;

import android.net.Uri;
import android.provider.BaseColumns;
import com.sec.chaton.specialbuddy.EnumC4549n;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.e.s */
/* loaded from: classes.dex */
public class C2299s implements BaseColumns {

    /* renamed from: a */
    public static final Uri f8209a = C2287g.f8194b.buildUpon().appendPath("inbox").build();

    /* renamed from: a */
    public static Uri m10185a(String str) {
        return f8209a.buildUpon().appendPath(str).build();
    }

    /* renamed from: a */
    public static Uri m10184a() {
        return f8209a.buildUpon().appendPath("buddy_participant_join").build();
    }

    /* renamed from: b */
    public static Uri m10188b() {
        return f8209a.buildUpon().appendPath("buddy_participant_join_for_list").build();
    }

    /* renamed from: c */
    public static Uri m10190c() {
        return f8209a.buildUpon().appendPath("buddy_participant_join_for_list_of_forward").build();
    }

    /* renamed from: d */
    public static Uri m10191d() {
        return f8209a.buildUpon().appendPath("buddy_participant_join_for_list_of_forward_chaton_only").build();
    }

    /* renamed from: e */
    public static Uri m10192e() {
        return f8209a.buildUpon().appendPath("search_buddy_participant_join_for_list_of_forward_chaton_only").build();
    }

    /* renamed from: f */
    public static Uri m10193f() {
        return f8209a.buildUpon().appendPath("buddy_participant_join_for_list_of_forward_sms_only").build();
    }

    /* renamed from: g */
    public static Uri m10194g() {
        return f8209a.buildUpon().appendPath("search_buddy_participant_join_for_list_of_forward_sms_only").build();
    }

    /* renamed from: h */
    public static Uri m10195h() {
        return f8209a.buildUpon().appendPath("buddy_participant_join_for_list_of_forward_sms_only_except_broadcast").build();
    }

    /* renamed from: i */
    public static Uri m10196i() {
        return f8209a.buildUpon().appendPath("buddy_participant_join_for_list_of_forward_without_topic").build();
    }

    /* renamed from: j */
    public static Uri m10197j() {
        return f8209a.buildUpon().appendPath("search_buddy_participant_join_for_list_of_forward_without_topic").build();
    }

    /* renamed from: k */
    public static Uri m10198k() {
        return f8209a.buildUpon().appendPath("update_unread_count").build();
    }

    /* renamed from: a */
    public static Uri m10186a(String str, EnumC4549n enumC4549n) {
        return f8209a.buildUpon().appendPath("update_unread_count_live").appendPath(str).appendPath(enumC4549n.m17248b()).build();
    }

    /* renamed from: l */
    public static Uri m10199l() {
        return f8209a.buildUpon().appendPath("update_inbox_with_current_unread_count").build();
    }

    /* renamed from: m */
    public static Uri m10200m() {
        return f8209a.buildUpon().appendPath("inbox_invalid_update").build();
    }

    /* renamed from: n */
    public static Uri m10201n() {
        return f8209a.buildUpon().appendPath("get_inbox_no").build();
    }

    /* renamed from: o */
    public static Uri m10202o() {
        return f8209a.buildUpon().appendPath("get_or_make_inbox_no").build();
    }

    /* renamed from: p */
    public static Uri m10203p() {
        return f8209a.buildUpon().appendPath("update_for_push").build();
    }

    /* renamed from: a */
    public static String m10187a(Uri uri) {
        return uri.getPathSegments().get(1);
    }

    /* renamed from: b */
    public static String m10189b(Uri uri) {
        return uri.getPathSegments().get(2);
    }

    /* renamed from: q */
    public static Uri m10204q() {
        return f8209a.buildUpon().appendPath("inbox_join_for_sms_mapping").build();
    }

    /* renamed from: r */
    public static Uri m10205r() {
        return f8209a.buildUpon().appendPath("inbox_join_sms_mapping").build();
    }

    /* renamed from: s */
    public static Uri m10206s() {
        return f8209a.buildUpon().appendPath("update_title").build();
    }
}
