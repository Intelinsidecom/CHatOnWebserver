package com.sec.chaton.p027e;

import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.chat.C1075eq;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p035io.entry.ApplinkMsgEntry;
import com.sec.chaton.p035io.entry.specialbuddy.SpecialBuddyRecommendBuddyEntry;
import com.sec.chaton.p035io.entry.specialbuddy.SpecialBuddyShareContentsEntry;
import com.sec.chaton.specialbuddy.C2930k;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.e.w */
/* loaded from: classes.dex */
public enum EnumC1455w {
    SYSTEM(-1),
    TEXT(0),
    IMAGE(1),
    VIDEO(2),
    GEO(3),
    AUDIO(4),
    CONTACT(5),
    CALENDAR(6),
    ANICON(7),
    DOCUMENT(8),
    APPLINK(9),
    POLL(10),
    FILE(11),
    AMS(12),
    LIVESHARE(13),
    LIVERECOMMEND(14),
    LIVECONTENTS(15),
    UNDEFINED(99);


    /* renamed from: s */
    private int f5413s;

    EnumC1455w(int i) {
        this.f5413s = i;
    }

    /* renamed from: a */
    public int m6364a() {
        return this.f5413s;
    }

    /* renamed from: a */
    public static EnumC1455w m6358a(int i) {
        switch (i) {
            case -1:
                return SYSTEM;
            case 0:
                return TEXT;
            case 1:
                return IMAGE;
            case 2:
                return VIDEO;
            case 3:
                return GEO;
            case 4:
                return AUDIO;
            case 5:
                return CONTACT;
            case 6:
                return CALENDAR;
            case 7:
                return ANICON;
            case 8:
                return DOCUMENT;
            case 9:
                return APPLINK;
            case 10:
                return POLL;
            case 11:
                return FILE;
            case 12:
                return AMS;
            case 13:
                return LIVESHARE;
            case 14:
                return LIVERECOMMEND;
            case 15:
                return LIVECONTENTS;
            case 99:
                return UNDEFINED;
            default:
                return UNDEFINED;
        }
    }

    /* renamed from: b */
    public boolean m6365b() {
        switch (C1440h.f5368a[ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                return true;
            default:
                return false;
        }
    }

    /* renamed from: a */
    public static String m6361a(EnumC1455w enumC1455w, String str, String str2, boolean z) {
        String[] strArrSplit;
        switch (C1440h.f5368a[enumC1455w.ordinal()]) {
            case 1:
                return z ? CommonApplication.m11493l().getString(R.string.send_message_and_animessage_to_you, str2) : CommonApplication.m11493l().getString(R.string.send_ams_to_you, str2);
            case 2:
                return z ? CommonApplication.m11493l().getString(R.string.send_message_and_anicon_to_you, str2) : CommonApplication.m11493l().getString(R.string.send_anicon_to_you, str2);
            case 3:
                return CommonApplication.m11493l().getString(R.string.sent_voice_to_you, str2);
            case 4:
                return CommonApplication.m11493l().getString(R.string.send_calendar_to_you, str2);
            case 5:
                return CommonApplication.m11493l().getString(R.string.send_contact_to_you, str2);
            case 6:
            case 7:
                String string = CommonApplication.m11493l().getString(R.string.send_file_to_you, str2, "");
                return (str == null || (strArrSplit = str.split("\n")) == null || strArrSplit.length <= 3) ? string : CommonApplication.m11493l().getString(R.string.send_file_to_you, str2, strArrSplit[3].substring(strArrSplit[3].lastIndexOf(".") + 1).toUpperCase());
            case 8:
                return CommonApplication.m11493l().getString(R.string.send_location_to_you, str2);
            case 9:
                return z ? CommonApplication.m11493l().getString(R.string.send_message_and_image_to_you, str2) : CommonApplication.m11493l().getString(R.string.send_image_to_you, str2);
            case 10:
                return z ? CommonApplication.m11493l().getString(R.string.send_message_and_video_to_you, str2) : CommonApplication.m11493l().getString(R.string.send_video_to_you, str2);
            case 11:
            default:
                return null;
            case 12:
                SpecialBuddyShareContentsEntry specialBuddyShareContentsEntryM10152a = C2930k.m10152a(str, true);
                if (specialBuddyShareContentsEntryM10152a != null) {
                    return CommonApplication.m11493l().getString(R.string.send_live_share_to_you, str2, specialBuddyShareContentsEntryM10152a.title);
                }
                return null;
            case 13:
                SpecialBuddyRecommendBuddyEntry specialBuddyRecommendBuddyEntryM10156b = C2930k.m10156b(str, true);
                if (specialBuddyRecommendBuddyEntryM10156b != null) {
                    return CommonApplication.m11493l().getString(R.string.send_live_recommend_to_you, str2, specialBuddyRecommendBuddyEntryM10156b.name);
                }
                return null;
            case 14:
                return C2930k.m10162f(str);
            case 15:
                try {
                    return CommonApplication.m11493l().getString(R.string.sent_open_api_to_you, str2, ApplinkMsgEntry.parse(str).getDisplayMessage());
                } catch (Exception e) {
                    if (C3250y.f11737e) {
                        C3250y.m11443a(e, C1439g.class.getSimpleName());
                    }
                    return str;
                }
            case 16:
                return CommonApplication.m11493l().getString(R.string.toast_supported_format);
        }
    }

    /* renamed from: a */
    public static String m6359a(EnumC1455w enumC1455w) {
        return m6360a(enumC1455w, null);
    }

    /* renamed from: a */
    public static String m6360a(EnumC1455w enumC1455w, String str) {
        return m6362a(enumC1455w, str, false);
    }

    /* renamed from: a */
    public static String m6362a(EnumC1455w enumC1455w, String str, boolean z) {
        String[] strArrSplit;
        switch (C1440h.f5368a[enumC1455w.ordinal()]) {
            case 1:
                if (z) {
                    return GlobalApplication.m11493l().getString(R.string.media_animessage_text);
                }
                return CommonApplication.m11493l().getString(R.string.media_animessage);
            case 2:
                if (z) {
                    return CommonApplication.m11493l().getString(R.string.media_anicon_text);
                }
                return CommonApplication.m11493l().getString(R.string.anicon_download_list_title);
            case 3:
                return CommonApplication.m11493l().getString(R.string.media_voice);
            case 4:
                return CommonApplication.m11493l().getString(R.string.media_event);
            case 5:
                return CommonApplication.m11493l().getString(R.string.popup_media_contact);
            case 6:
            case 7:
                String string = CommonApplication.m11493l().getString(R.string.media_file);
                if (!TextUtils.isEmpty(str) && (strArrSplit = str.split("\n")) != null && strArrSplit.length > 3) {
                    String strSubstring = strArrSplit[3].substring(strArrSplit[3].lastIndexOf(".") + 1);
                    if (!TextUtils.isEmpty(strSubstring)) {
                        return strSubstring.toUpperCase();
                    }
                    return string;
                }
                return string;
            case 8:
                return CommonApplication.m11493l().getString(R.string.media_map);
            case 9:
                if (z) {
                    return CommonApplication.m11493l().getString(R.string.media_image_text);
                }
                return CommonApplication.m11493l().getString(R.string.media_photo);
            case 10:
                if (z) {
                    return CommonApplication.m11493l().getString(R.string.media_video_text);
                }
                return CommonApplication.m11493l().getString(R.string.media_video);
            case 11:
                return CommonApplication.m11493l().getString(R.string.poll_title);
            case 12:
                SpecialBuddyShareContentsEntry specialBuddyShareContentsEntryM10152a = C2930k.m10152a(str, true);
                if (specialBuddyShareContentsEntryM10152a == null) {
                    return "";
                }
                return specialBuddyShareContentsEntryM10152a.title;
            case 13:
                SpecialBuddyRecommendBuddyEntry specialBuddyRecommendBuddyEntryM10156b = C2930k.m10156b(str, true);
                if (specialBuddyRecommendBuddyEntryM10156b == null) {
                    return "";
                }
                return specialBuddyRecommendBuddyEntryM10156b.name;
            case 14:
                return C2930k.m10162f(str);
            case 15:
            default:
                return CommonApplication.m11493l().getString(R.string.dialog_header_text);
            case 16:
                return CommonApplication.m11493l().getString(R.string.toast_supported_format);
        }
    }

    /* renamed from: a */
    public static String m6363a(EnumC1455w enumC1455w, String[] strArr, boolean z) {
        SpecialBuddyRecommendBuddyEntry specialBuddyRecommendBuddyEntryM10156b;
        String string;
        String strM5323b;
        String string2;
        String string3;
        String strM5323b2 = "";
        String str = CommonApplication.m11493l().getString(R.string.buddy_profile_interaction_me) + ": ";
        switch (C1440h.f5368a[enumC1455w.ordinal()]) {
            case 1:
                if (z) {
                    return str + CommonApplication.m11493l().getString(R.string.media_animessage_text);
                }
                return str + CommonApplication.m11493l().getString(R.string.media_animessage);
            case 2:
                if (z) {
                    return str + CommonApplication.m11493l().getString(R.string.media_anicon_text);
                }
                return str + CommonApplication.m11493l().getString(R.string.anicon_download_list_title);
            case 3:
                return str + CommonApplication.m11493l().getString(R.string.media_voice);
            case 4:
                return str + CommonApplication.m11493l().getString(R.string.media_event);
            case 5:
                return str + CommonApplication.m11493l().getString(R.string.popup_media_contact);
            case 6:
            case 7:
                String string4 = CommonApplication.m11493l().getString(R.string.last_message_me_document);
                if (strArr == null || strArr.length < 3 || strArr[2] == null) {
                    return string4;
                }
                String[] strArrSplit = strArr[2].split("\n");
                if (strArrSplit != null && strArrSplit.length > 3) {
                    String strSubstring = strArrSplit[3].substring(strArrSplit[3].lastIndexOf(".") + 1);
                    if (!TextUtils.isEmpty(strSubstring)) {
                        string4 = CommonApplication.m11493l().getString(R.string.dialog_chatting_me, strSubstring.toUpperCase());
                    }
                } else {
                    string4 = CommonApplication.m11493l().getString(R.string.dialog_chatting_me, strArr[2].toUpperCase());
                }
                return string4;
            case 8:
                return str + CommonApplication.m11493l().getString(R.string.media_map);
            case 9:
                if (z) {
                    return str + CommonApplication.m11493l().getString(R.string.media_image_text);
                }
                return str + CommonApplication.m11493l().getString(R.string.media_photo);
            case 10:
                if (z) {
                    return str + CommonApplication.m11493l().getString(R.string.media_video_text);
                }
                return str + CommonApplication.m11493l().getString(R.string.media_video);
            case 11:
                if (strArr != null && strArr.length >= 3) {
                    strM5323b2 = C1075eq.m5323b(strArr[2]);
                }
                try {
                    try {
                        if (new JSONObject(strM5323b2).getJSONObject("push_message").getString("content_type").equals("result")) {
                            string3 = CommonApplication.m11493l().getString(R.string.poll_result_now_available);
                        } else {
                            string3 = CommonApplication.m11493l().getString(R.string.poll_title);
                        }
                        string2 = CommonApplication.m11493l().getString(R.string.dialog_chatting_me, string3);
                    } catch (JSONException e) {
                        C3250y.m11443a(e, "getLastMessageMe");
                        string2 = CommonApplication.m11493l().getString(R.string.dialog_chatting_me, "");
                    }
                    return string2;
                } catch (Throwable th) {
                    CommonApplication.m11493l().getString(R.string.dialog_chatting_me, "");
                    throw th;
                }
            case 12:
                if (strArr == null || strArr.length < 3) {
                    return "";
                }
                SpecialBuddyShareContentsEntry specialBuddyShareContentsEntryM10152a = C2930k.m10152a(C1075eq.m5323b(strArr[2]), true);
                if (specialBuddyShareContentsEntryM10152a == null) {
                    string = "";
                } else {
                    string = CommonApplication.m11493l().getString(R.string.dialog_chatting_me, specialBuddyShareContentsEntryM10152a.title);
                }
                return string;
            case 13:
                return (strArr == null || strArr.length < 3 || (specialBuddyRecommendBuddyEntryM10156b = C2930k.m10156b(C1075eq.m5323b(strArr[2]), true)) == null) ? "" : CommonApplication.m11493l().getString(R.string.dialog_chatting_me, specialBuddyRecommendBuddyEntryM10156b.name);
            case 14:
                if (strArr == null || strArr.length < 3) {
                    return "";
                }
                return C2930k.m10162f(C1075eq.m5323b(strArr[2]));
            case 15:
                if (strArr == null || strArr.length < 3) {
                    strM5323b = "";
                } else {
                    strM5323b = C1075eq.m5323b(strArr[2]);
                }
                return CommonApplication.m11493l().getString(R.string.dialog_chatting_me, ApplinkMsgEntry.getDisplayMessage(strM5323b));
            case 16:
                return CommonApplication.m11493l().getString(R.string.toast_supported_format);
            case 17:
                if (strArr != null && strArr.length >= 3) {
                    strM5323b2 = C1075eq.m5323b(strArr[2]);
                    if (C1075eq.m5326c(strM5323b2)) {
                        strM5323b2 = new StringBuilder(strM5323b2).substring(1);
                    }
                }
                return String.format(CommonApplication.m11493l().getString(R.string.dialog_chatting_me), strM5323b2);
            default:
                return "";
        }
    }
}
