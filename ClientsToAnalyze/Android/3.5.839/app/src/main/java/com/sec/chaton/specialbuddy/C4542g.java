package com.sec.chaton.specialbuddy;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.C0096i;
import android.text.TextUtils;
import com.renren.android.Renren;
import com.sec.chaton.buddy.p050a.EnumC1109f;
import com.sec.chaton.chat.ChatActivity;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.p065io.entry.specialbuddy.SpecialBuddyRecommendBuddyEntry;
import com.sec.chaton.p065io.entry.specialbuddy.SpecialBuddyShareContentsEntry;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4874cl;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ChatONLiveHelper.java */
/* renamed from: com.sec.chaton.specialbuddy.g */
/* loaded from: classes.dex */
public class C4542g {

    /* renamed from: a */
    private static final String f16402a = C4542g.class.getSimpleName();

    /* renamed from: a */
    public static SpecialBuddyShareContentsEntry m17227a(String str) {
        return m17228a(str, false);
    }

    /* renamed from: a */
    public static SpecialBuddyShareContentsEntry m17228a(String str, boolean z) {
        SpecialBuddyShareContentsEntry specialBuddyShareContentsEntryM17229a = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                boolean zHas = jSONObject.has("content");
                boolean zHas2 = jSONObject.has("push_message");
                if (zHas && zHas2) {
                    specialBuddyShareContentsEntryM17229a = m17229a(jSONObject.getJSONObject("content"), false);
                } else {
                    specialBuddyShareContentsEntryM17229a = m17229a(jSONObject, z);
                }
            } catch (Exception e) {
                C4904y.m18635a(e, f16402a);
            }
        }
        return specialBuddyShareContentsEntryM17229a;
    }

    /* renamed from: a */
    private static SpecialBuddyShareContentsEntry m17229a(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return null;
        }
        try {
            SpecialBuddyShareContentsEntry specialBuddyShareContentsEntry = new SpecialBuddyShareContentsEntry();
            specialBuddyShareContentsEntry.name = jSONObject.getString("name");
            specialBuddyShareContentsEntry.title = jSONObject.getString("title");
            if (!z) {
                specialBuddyShareContentsEntry.f8585id = jSONObject.getString("id");
                specialBuddyShareContentsEntry.hash = jSONObject.getString(SpecialBuddyShareContentsEntry.KEY_BUDDY_HASH);
                specialBuddyShareContentsEntry.url = jSONObject.getString("url");
            }
            return specialBuddyShareContentsEntry;
        } catch (Exception e) {
            C4904y.m18635a(e, f16402a);
            return null;
        }
    }

    /* renamed from: a */
    public static JSONObject m17230a(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", "live_share");
        jSONObject.put("name", str2);
        jSONObject.put("title", str);
        return jSONObject;
    }

    /* renamed from: b */
    public static JSONObject m17237b(String str, String str2) throws Exception {
        String strM18510b;
        JSONObject jSONObjectM17230a = m17230a(str, str2);
        int iM18509b = C4874cl.m18509b(jSONObjectM17230a.toString());
        if (98 < iM18509b) {
            int iM18509b2 = C4874cl.m18509b("..");
            int iM18509b3 = C4874cl.m18509b(str);
            int iM18509b4 = C4874cl.m18509b(str2);
            int i = iM18509b - 98;
            int i2 = iM18509b4 - i;
            if (i2 > iM18509b2) {
                strM18510b = C4874cl.m18510b(str2, i2, "..");
            } else {
                strM18510b = C4874cl.m18510b(str2, iM18509b2, "..");
            }
            int iM18509b5 = i - (iM18509b4 - C4874cl.m18509b(strM18510b));
            if (iM18509b5 > 0) {
                int i3 = iM18509b3 - iM18509b5;
                if (i3 > iM18509b2) {
                    str = C4874cl.m18510b(str, i3, "..");
                } else {
                    str = C4874cl.m18510b(str, iM18509b2, "..");
                }
            }
            jSONObjectM17230a = m17230a(str, strM18510b);
            if (98 < C4874cl.m18509b(jSONObjectM17230a.toString())) {
                throw new Exception("exceeds 100 bytes");
            }
        }
        return jSONObjectM17230a;
    }

    /* renamed from: b */
    public static String m17236b(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            C4904y.m18639b("ERROR In convertShareChatMessage(), emtpry input", f16402a);
            return null;
        }
        SpecialBuddyShareContentsEntry specialBuddyShareContentsEntryM17227a = m17227a(str);
        if (specialBuddyShareContentsEntryM17227a == null) {
            C4904y.m18639b("ERROR In convertShareChatMessage(), cannot parse input : " + str, f16402a);
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("name", specialBuddyShareContentsEntryM17227a.name);
            jSONObject2.put("title", specialBuddyShareContentsEntryM17227a.title);
            jSONObject2.put("id", specialBuddyShareContentsEntryM17227a.f8585id);
            jSONObject2.put(SpecialBuddyShareContentsEntry.KEY_BUDDY_HASH, specialBuddyShareContentsEntryM17227a.hash);
            jSONObject2.put("url", specialBuddyShareContentsEntryM17227a.url);
            JSONObject jSONObjectM17237b = m17237b(specialBuddyShareContentsEntryM17227a.title, specialBuddyShareContentsEntryM17227a.name);
            if (C4904y.f17872b) {
                C4904y.m18639b(String.format("convertShareChatMessage(), push_message bytes(%d), result : %s", Integer.valueOf(C4874cl.m18509b(jSONObjectM17237b.toString())), jSONObjectM17237b.toString()), f16402a);
            }
            jSONObject.put("type", "live_share");
            jSONObject.put("format", Renren.RESPONSE_FORMAT_JSON);
            jSONObject.put("push_message", jSONObjectM17237b);
            jSONObject.put("content", jSONObject2);
            return jSONObject.toString();
        } catch (Exception e) {
            C4904y.m18635a(e, f16402a);
            return null;
        }
    }

    /* renamed from: c */
    public static SpecialBuddyRecommendBuddyEntry m17238c(String str) {
        return m17234b(str, false);
    }

    /* renamed from: b */
    public static SpecialBuddyRecommendBuddyEntry m17234b(String str, boolean z) {
        SpecialBuddyRecommendBuddyEntry specialBuddyRecommendBuddyEntryM17235b = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("content")) {
                    specialBuddyRecommendBuddyEntryM17235b = m17235b(jSONObject.getJSONObject("content"), false);
                } else {
                    specialBuddyRecommendBuddyEntryM17235b = m17235b(jSONObject, z);
                }
            } catch (Exception e) {
                C4904y.m18635a(e, f16402a);
            }
        }
        return specialBuddyRecommendBuddyEntryM17235b;
    }

    /* renamed from: b */
    private static SpecialBuddyRecommendBuddyEntry m17235b(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return null;
        }
        try {
            SpecialBuddyRecommendBuddyEntry specialBuddyRecommendBuddyEntry = new SpecialBuddyRecommendBuddyEntry();
            specialBuddyRecommendBuddyEntry.name = jSONObject.getString("name");
            if (!z) {
                specialBuddyRecommendBuddyEntry.f8584id = jSONObject.getString("id");
            }
            return specialBuddyRecommendBuddyEntry;
        } catch (Exception e) {
            C4904y.m18635a(e, f16402a);
            return null;
        }
    }

    /* renamed from: d */
    public static JSONObject m17239d(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", "live_recommend");
        jSONObject.put("name", str);
        return jSONObject;
    }

    /* renamed from: e */
    public static JSONObject m17240e(String str) throws Exception {
        String strM18510b;
        JSONObject jSONObjectM17239d = m17239d(str);
        int iM18509b = C4874cl.m18509b(jSONObjectM17239d.toString());
        if (98 < iM18509b) {
            int iM18509b2 = C4874cl.m18509b("..");
            int iM18509b3 = C4874cl.m18509b(str) - (iM18509b - 98);
            if (iM18509b3 > iM18509b2) {
                strM18510b = C4874cl.m18510b(str, iM18509b3, "..");
            } else {
                strM18510b = C4874cl.m18510b(str, iM18509b2, "..");
            }
            jSONObjectM17239d = m17239d(strM18510b);
            if (98 < C4874cl.m18509b(jSONObjectM17239d.toString())) {
                throw new Exception("exceeds 100 bytes");
            }
        }
        return jSONObjectM17239d;
    }

    /* renamed from: f */
    public static String m17241f(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            C4904y.m18639b("ERROR In convertRecommendChatMessage(), emtpry input", f16402a);
            return null;
        }
        SpecialBuddyRecommendBuddyEntry specialBuddyRecommendBuddyEntryM17238c = m17238c(str);
        if (specialBuddyRecommendBuddyEntryM17238c == null) {
            C4904y.m18639b("ERROR In convertRecommendChatMessage(), cannot parse input : " + str, f16402a);
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", specialBuddyRecommendBuddyEntryM17238c.f8584id);
            jSONObject2.put("name", specialBuddyRecommendBuddyEntryM17238c.name);
            JSONObject jSONObjectM17240e = m17240e(specialBuddyRecommendBuddyEntryM17238c.name);
            if (C4904y.f17872b) {
                C4904y.m18639b(String.format("convertRecommendChatMessage(), push_message byte(%d), result : %s", Integer.valueOf(C4874cl.m18509b(jSONObjectM17240e.toString())), jSONObjectM17240e.toString()), f16402a);
            }
            jSONObject.put("type", "live_recommend");
            jSONObject.put("format", Renren.RESPONSE_FORMAT_JSON);
            jSONObject.put("push_message", jSONObjectM17240e);
            jSONObject.put("content", jSONObject2);
            return jSONObject.toString();
        } catch (Exception e) {
            C4904y.m18635a(e, f16402a);
            return null;
        }
    }

    /* renamed from: g */
    public static String m17242g(String str) {
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
    public static void m17231a() {
        long jM18118a = C4809aa.m18104a().m18118a("notification_api_timestamp", 0L);
        C4809aa.m18104a().m18124a("cleared_timestamp_livepartner_buddies", Long.valueOf(jM18118a));
        C4809aa.m18104a().m18126b("new_livepartner_count", (Integer) 0);
        C0096i.m358a(CommonApplication.m18732r()).m363a(new Intent("more_tab_badge_update"));
        C4904y.m18639b("clear new live buddy badge count zero(0), update clear time : " + jM18118a, f16402a);
    }

    /* renamed from: a */
    public static Intent m17226a(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(context, (Class<?>) ChatActivity.class);
        intent.putExtra("chatType", EnumC2300t.ONETOONE.m10210a());
        intent.putExtra("receivers", new String[]{str});
        intent.putExtra("specialbuddy", true);
        intent.putExtra("callChatList", true);
        intent.putExtra("roomType", EnumC2301u.LIVE.m10212a());
        intent.putExtra("liveServiceType", EnumC4549n.LIVECONTENTS.m17247a());
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("key_buddy_name", str2);
            intent.putExtra("buddy_name", str2);
        }
        intent.putExtra("liveUserType", str3);
        return intent;
    }

    /* renamed from: a */
    public static Intent m17225a(Context context, String str) {
        return m17226a(context, str, "", EnumC1109f.CONTENTS.m7095a());
    }

    /* renamed from: b */
    public static Intent m17233b(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(context, (Class<?>) ChatActivity.class);
        intent.putExtra("chatType", EnumC2300t.ONETOONE.m10210a());
        intent.putExtra("receivers", new String[]{str});
        intent.putExtra("specialbuddy", true);
        intent.putExtra("callChatList", true);
        intent.putExtra("roomType", EnumC2301u.LIVE.m10212a());
        intent.putExtra("liveServiceType", EnumC4549n.LIVECHAT.m17247a());
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("key_buddy_name", str2);
            intent.putExtra("buddy_name", str2);
        }
        intent.putExtra("liveUserType", str3);
        return intent;
    }

    /* renamed from: b */
    public static Intent m17232b(Context context, String str) {
        return m17233b(context, str, "", EnumC1109f.CHATCONTENTS.m7095a());
    }
}
