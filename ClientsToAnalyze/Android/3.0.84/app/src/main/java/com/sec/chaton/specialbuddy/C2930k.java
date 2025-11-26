package com.sec.chaton.specialbuddy;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.renren.android.Renren;
import com.sec.chaton.p035io.entry.specialbuddy.SpecialBuddyRecommendBuddyEntry;
import com.sec.chaton.p035io.entry.specialbuddy.SpecialBuddyShareContentsEntry;
import com.sec.chaton.settings2.PrefFragmentChats;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3224cl;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ChatONLiveHelper.java */
/* renamed from: com.sec.chaton.specialbuddy.k */
/* loaded from: classes.dex */
public class C2930k {

    /* renamed from: a */
    private static final String f10461a = C2930k.class.getSimpleName();

    /* renamed from: a */
    public static SpecialBuddyShareContentsEntry m10151a(String str) {
        return m10152a(str, false);
    }

    /* renamed from: a */
    public static SpecialBuddyShareContentsEntry m10152a(String str, boolean z) {
        SpecialBuddyShareContentsEntry specialBuddyShareContentsEntryM10153a = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                boolean zHas = jSONObject.has("content");
                boolean zHas2 = jSONObject.has("push_message");
                if (zHas && zHas2) {
                    specialBuddyShareContentsEntryM10153a = m10153a(jSONObject.getJSONObject("content"), false);
                } else {
                    specialBuddyShareContentsEntryM10153a = m10153a(jSONObject, z);
                }
            } catch (Exception e) {
                C3250y.m11443a(e, f10461a);
            }
        }
        return specialBuddyShareContentsEntryM10153a;
    }

    /* renamed from: a */
    private static SpecialBuddyShareContentsEntry m10153a(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return null;
        }
        try {
            SpecialBuddyShareContentsEntry specialBuddyShareContentsEntry = new SpecialBuddyShareContentsEntry();
            specialBuddyShareContentsEntry.name = jSONObject.getString("name");
            specialBuddyShareContentsEntry.title = jSONObject.getString("title");
            if (!z) {
                specialBuddyShareContentsEntry.f5658id = jSONObject.getString("id");
                specialBuddyShareContentsEntry.hash = jSONObject.getString(SpecialBuddyShareContentsEntry.KEY_BUDDY_HASH);
                specialBuddyShareContentsEntry.url = jSONObject.getString("url");
            }
            return specialBuddyShareContentsEntry;
        } catch (Exception e) {
            C3250y.m11443a(e, f10461a);
            return null;
        }
    }

    /* renamed from: a */
    public static JSONObject m10154a(String str, String str2) throws Exception {
        String strM11336b;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(PrefFragmentChats.TYPE, "live_share");
        jSONObject.put("name", str2);
        jSONObject.put("title", str);
        int iM11332a = C3224cl.m11332a(jSONObject.toString());
        if (98 < iM11332a) {
            int iM11332a2 = C3224cl.m11332a("..");
            int iM11332a3 = C3224cl.m11332a(str);
            int iM11332a4 = C3224cl.m11332a(str2);
            int i = iM11332a - 98;
            int i2 = iM11332a4 - i;
            if (i2 > iM11332a2) {
                strM11336b = C3224cl.m11336b(str2, i2, "..");
            } else {
                strM11336b = C3224cl.m11336b(str2, iM11332a2, "..");
            }
            int iM11332a5 = i - (iM11332a4 - C3224cl.m11332a(strM11336b));
            if (iM11332a5 > 0) {
                int i3 = iM11332a3 - iM11332a5;
                if (i3 > iM11332a2) {
                    str = C3224cl.m11336b(str, i3, "..");
                } else {
                    str = C3224cl.m11336b(str, iM11332a2, "..");
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(PrefFragmentChats.TYPE, "live_share");
            jSONObject2.put("name", strM11336b);
            jSONObject2.put("title", str);
            if (98 >= C3224cl.m11332a(jSONObject2.toString())) {
                return jSONObject2;
            }
            throw new Exception("exceeds 100 bytes");
        }
        return jSONObject;
    }

    /* renamed from: b */
    public static String m10158b(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            C3250y.m11450b("ERROR In convertShareChatMessage(), emtpry input", f10461a);
            return null;
        }
        SpecialBuddyShareContentsEntry specialBuddyShareContentsEntryM10151a = m10151a(str);
        if (specialBuddyShareContentsEntryM10151a == null) {
            C3250y.m11450b("ERROR In convertShareChatMessage(), cannot parse input : " + str, f10461a);
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("name", specialBuddyShareContentsEntryM10151a.name);
            jSONObject2.put("title", specialBuddyShareContentsEntryM10151a.title);
            jSONObject2.put("id", specialBuddyShareContentsEntryM10151a.f5658id);
            jSONObject2.put(SpecialBuddyShareContentsEntry.KEY_BUDDY_HASH, specialBuddyShareContentsEntryM10151a.hash);
            jSONObject2.put("url", specialBuddyShareContentsEntryM10151a.url);
            JSONObject jSONObjectM10154a = m10154a(specialBuddyShareContentsEntryM10151a.title, specialBuddyShareContentsEntryM10151a.name);
            if (C3250y.f11734b) {
                C3250y.m11450b(String.format("convertShareChatMessage(), push_message bytes(%d), result : %s", Integer.valueOf(C3224cl.m11332a(jSONObjectM10154a.toString())), jSONObjectM10154a.toString()), f10461a);
            }
            jSONObject.put(PrefFragmentChats.TYPE, "live_share");
            jSONObject.put("format", Renren.RESPONSE_FORMAT_JSON);
            jSONObject.put("push_message", jSONObjectM10154a);
            jSONObject.put("content", jSONObject2);
            return jSONObject.toString();
        } catch (Exception e) {
            C3250y.m11443a(e, f10461a);
            return null;
        }
    }

    /* renamed from: c */
    public static SpecialBuddyRecommendBuddyEntry m10159c(String str) {
        return m10156b(str, false);
    }

    /* renamed from: b */
    public static SpecialBuddyRecommendBuddyEntry m10156b(String str, boolean z) {
        SpecialBuddyRecommendBuddyEntry specialBuddyRecommendBuddyEntryM10157b = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("content")) {
                    specialBuddyRecommendBuddyEntryM10157b = m10157b(jSONObject.getJSONObject("content"), false);
                } else {
                    specialBuddyRecommendBuddyEntryM10157b = m10157b(jSONObject, z);
                }
            } catch (Exception e) {
                C3250y.m11443a(e, f10461a);
            }
        }
        return specialBuddyRecommendBuddyEntryM10157b;
    }

    /* renamed from: b */
    private static SpecialBuddyRecommendBuddyEntry m10157b(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return null;
        }
        try {
            SpecialBuddyRecommendBuddyEntry specialBuddyRecommendBuddyEntry = new SpecialBuddyRecommendBuddyEntry();
            specialBuddyRecommendBuddyEntry.name = jSONObject.getString("name");
            if (!z) {
                specialBuddyRecommendBuddyEntry.f5657id = jSONObject.getString("id");
            }
            return specialBuddyRecommendBuddyEntry;
        } catch (Exception e) {
            C3250y.m11443a(e, f10461a);
            return null;
        }
    }

    /* renamed from: d */
    public static JSONObject m10160d(String str) throws Exception {
        String strM11336b;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(PrefFragmentChats.TYPE, "live_recommend");
        jSONObject.put("name", str);
        int iM11332a = C3224cl.m11332a(jSONObject.toString());
        if (98 < iM11332a) {
            int iM11332a2 = C3224cl.m11332a("..");
            int iM11332a3 = C3224cl.m11332a(str) - (iM11332a - 98);
            if (iM11332a3 > iM11332a2) {
                strM11336b = C3224cl.m11336b(str, iM11332a3, "..");
            } else {
                strM11336b = C3224cl.m11336b(str, iM11332a2, "..");
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(PrefFragmentChats.TYPE, "live_recommend");
            jSONObject2.put("name", strM11336b);
            if (98 >= C3224cl.m11332a(jSONObject2.toString())) {
                return jSONObject2;
            }
            throw new Exception("exceeds 100 bytes");
        }
        return jSONObject;
    }

    /* renamed from: e */
    public static String m10161e(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            C3250y.m11450b("ERROR In convertRecommendChatMessage(), emtpry input", f10461a);
            return null;
        }
        SpecialBuddyRecommendBuddyEntry specialBuddyRecommendBuddyEntryM10159c = m10159c(str);
        if (specialBuddyRecommendBuddyEntryM10159c == null) {
            C3250y.m11450b("ERROR In convertRecommendChatMessage(), cannot parse input : " + str, f10461a);
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", specialBuddyRecommendBuddyEntryM10159c.f5657id);
            jSONObject2.put("name", specialBuddyRecommendBuddyEntryM10159c.name);
            JSONObject jSONObjectM10160d = m10160d(specialBuddyRecommendBuddyEntryM10159c.name);
            if (C3250y.f11734b) {
                C3250y.m11450b(String.format("convertRecommendChatMessage(), push_message byte(%d), result : %s", Integer.valueOf(C3224cl.m11332a(jSONObjectM10160d.toString())), jSONObjectM10160d.toString()), f10461a);
            }
            jSONObject.put(PrefFragmentChats.TYPE, "live_recommend");
            jSONObject.put("format", Renren.RESPONSE_FORMAT_JSON);
            jSONObject.put("push_message", jSONObjectM10160d);
            jSONObject.put("content", jSONObject2);
            return jSONObject.toString();
        } catch (Exception e) {
            C3250y.m11443a(e, f10461a);
            return null;
        }
    }

    /* renamed from: f */
    public static String m10162f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("push_message")) {
                return jSONObject.getString("push_message");
            }
            return null;
        } catch (Exception e) {
            return str;
        }
    }

    /* renamed from: a */
    public static void m10155a() {
        long jM10976a = C3159aa.m10962a().m10976a("notification_api_timestamp", 0L);
        C3159aa.m10962a().m10982a("cleared_timestamp_livepartner_buddies", Long.valueOf(jM10976a));
        C3159aa.m10962a().m10984b("new_livepartner_count", (Integer) 0);
        LocalBroadcastManager.getInstance(CommonApplication.m11493l()).sendBroadcast(new Intent("more_tab_badge_update"));
        C3250y.m11450b("clear new live buddy badge count zero(0), update clear time : " + jM10976a, f10461a);
    }
}
