package com.sec.chaton.p057e;

import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.chat.C1736gi;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p065io.entry.ApplinkMsgEntry;
import com.sec.chaton.p065io.entry.specialbuddy.SpecialBuddyRecommendBuddyEntry;
import com.sec.chaton.p065io.entry.specialbuddy.SpecialBuddyShareContentsEntry;
import com.sec.chaton.specialbuddy.C4542g;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.e.ab */
/* loaded from: classes.dex */
public enum EnumC2214ab {
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
    SMS(16),
    MMS(17),
    HUGEFILE(18),
    GLYMPSE(19),
    UNDEFINED(99);


    /* renamed from: w */
    private final int f7927w;

    EnumC2214ab(int i) {
        this.f7927w = i;
    }

    /* renamed from: a */
    public int m10076a() {
        return this.f7927w;
    }

    /* renamed from: b */
    public String m10077b() {
        return String.valueOf(this.f7927w);
    }

    /* renamed from: a */
    public static EnumC2214ab m10070a(int i) {
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
            case 16:
                return SMS;
            case 17:
                return MMS;
            case 18:
                return HUGEFILE;
            case 19:
                return GLYMPSE;
            case 99:
                return UNDEFINED;
            default:
                return UNDEFINED;
        }
    }

    /* renamed from: c */
    public boolean m10078c() {
        switch (C2288h.f8195a[ordinal()]) {
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
            case 11:
            case 12:
                return true;
            default:
                return false;
        }
    }

    /* renamed from: a */
    public static String m10073a(EnumC2214ab enumC2214ab, String str, String str2, boolean z) {
        String[] strArrSplit;
        switch (C2288h.f8195a[enumC2214ab.ordinal()]) {
            case 1:
                return z ? CommonApplication.m18732r().getString(R.string.send_message_and_animessage_to_you, str2) : CommonApplication.m18732r().getString(R.string.send_ams_to_you, str2);
            case 2:
                return z ? CommonApplication.m18732r().getString(R.string.send_message_and_sticker_to_you, str2) : CommonApplication.m18732r().getString(R.string.send_sticker_to_you, str2);
            case 3:
                return CommonApplication.m18732r().getString(R.string.sent_voice_to_you, str2);
            case 4:
                return CommonApplication.m18732r().getString(R.string.send_calendar_to_you, str2);
            case 5:
                return CommonApplication.m18732r().getString(R.string.send_contact_to_you, str2);
            case 6:
            case 7:
                String string = CommonApplication.m18732r().getString(R.string.send_file_to_you, str2, "");
                return (str == null || (strArrSplit = str.split("\n")) == null || strArrSplit.length <= 3) ? string : CommonApplication.m18732r().getString(R.string.send_file_to_you, str2, strArrSplit[3].substring(strArrSplit[3].lastIndexOf(".") + 1).toUpperCase());
            case 8:
                return CommonApplication.m18732r().getString(R.string.send_location_to_you, str2);
            case 9:
                return z ? CommonApplication.m18732r().getString(R.string.send_message_and_image_to_you, str2) : CommonApplication.m18732r().getString(R.string.send_image_to_you, str2);
            case 10:
                return z ? CommonApplication.m18732r().getString(R.string.send_message_and_video_to_you, str2) : CommonApplication.m18732r().getString(R.string.send_video_to_you, str2);
            case 11:
                return CommonApplication.m18732r().getString(R.string.glympse_push_popup, str2);
            case 12:
                return CommonApplication.m18732r().getString(R.string.send_file_to_you, str2, CommonApplication.m18732r().getString(R.string.hugefile_large_file));
            case 13:
            default:
                return null;
            case 14:
                SpecialBuddyShareContentsEntry specialBuddyShareContentsEntryM17228a = C4542g.m17228a(str, true);
                if (specialBuddyShareContentsEntryM17228a != null) {
                    return CommonApplication.m18732r().getString(R.string.send_live_share_to_you, str2, specialBuddyShareContentsEntryM17228a.title);
                }
                return null;
            case 15:
                SpecialBuddyRecommendBuddyEntry specialBuddyRecommendBuddyEntryM17234b = C4542g.m17234b(str, true);
                if (specialBuddyRecommendBuddyEntryM17234b != null) {
                    return CommonApplication.m18732r().getString(R.string.send_live_recommend_to_you, str2, specialBuddyRecommendBuddyEntryM17234b.name);
                }
                return null;
            case 16:
                return C4542g.m17242g(str);
            case 17:
                try {
                    return CommonApplication.m18732r().getString(R.string.sent_open_api_to_you, str2, ApplinkMsgEntry.parse(str).getDisplayMessage());
                } catch (Exception e) {
                    if (C4904y.f17875e) {
                        C4904y.m18635a(e, C2287g.class.getSimpleName());
                    }
                    return str;
                }
            case 18:
                return CommonApplication.m18732r().getString(R.string.toast_supported_format);
        }
    }

    /* renamed from: a */
    public static String m10071a(EnumC2214ab enumC2214ab) {
        return m10072a(enumC2214ab, null);
    }

    /* renamed from: a */
    public static String m10072a(EnumC2214ab enumC2214ab, String str) {
        return m10074a(enumC2214ab, str, false);
    }

    /* renamed from: a */
    public static String m10074a(EnumC2214ab enumC2214ab, String str, boolean z) {
        String[] strArrSplit;
        switch (C2288h.f8195a[enumC2214ab.ordinal()]) {
            case 1:
                if (z) {
                    return GlobalApplication.m18732r().getString(R.string.media_animessage_text);
                }
                return CommonApplication.m18732r().getString(R.string.media_animessage);
            case 2:
                if (z) {
                    return CommonApplication.m18732r().getString(R.string.media_sticker_text);
                }
                return CommonApplication.m18732r().getString(R.string.chat_stickers);
            case 3:
                return CommonApplication.m18732r().getString(R.string.media_voice);
            case 4:
                return CommonApplication.m18732r().getString(R.string.media_event);
            case 5:
                return CommonApplication.m18732r().getString(R.string.popup_media_contact);
            case 6:
            case 7:
                String string = CommonApplication.m18732r().getString(R.string.media_file);
                if (!TextUtils.isEmpty(str) && (strArrSplit = str.split("\n")) != null && strArrSplit.length > 3) {
                    String strSubstring = strArrSplit[3].substring(strArrSplit[3].lastIndexOf(".") + 1);
                    if (!TextUtils.isEmpty(strSubstring)) {
                        return strSubstring.toUpperCase();
                    }
                    return string;
                }
                return string;
            case 8:
                return CommonApplication.m18732r().getString(R.string.media_map);
            case 9:
                if (z) {
                    return CommonApplication.m18732r().getString(R.string.media_image_text);
                }
                return CommonApplication.m18732r().getString(R.string.media_photo);
            case 10:
                if (z) {
                    return CommonApplication.m18732r().getString(R.string.media_video_text);
                }
                return CommonApplication.m18732r().getString(R.string.media_video);
            case 11:
                return CommonApplication.m18732r().getString(R.string.glympse);
            case 12:
                return CommonApplication.m18732r().getString(R.string.hugefile_large_file);
            case 13:
                return CommonApplication.m18732r().getString(R.string.poll_title);
            case 14:
                SpecialBuddyShareContentsEntry specialBuddyShareContentsEntryM17228a = C4542g.m17228a(str, true);
                if (specialBuddyShareContentsEntryM17228a == null) {
                    return "";
                }
                return specialBuddyShareContentsEntryM17228a.title;
            case 15:
                SpecialBuddyRecommendBuddyEntry specialBuddyRecommendBuddyEntryM17234b = C4542g.m17234b(str, true);
                if (specialBuddyRecommendBuddyEntryM17234b == null) {
                    return "";
                }
                return specialBuddyRecommendBuddyEntryM17234b.name;
            case 16:
                return C4542g.m17242g(str);
            case 17:
            default:
                return CommonApplication.m18732r().getString(R.string.dialog_header_text);
            case 18:
                return CommonApplication.m18732r().getString(R.string.toast_supported_format);
        }
    }

    /* renamed from: a */
    public static String m10075a(EnumC2214ab enumC2214ab, String[] strArr, boolean z) {
        SpecialBuddyRecommendBuddyEntry specialBuddyRecommendBuddyEntryM17234b;
        String string;
        String strM8646b;
        String string2;
        String string3;
        String strM8646b2 = "";
        String str = CommonApplication.m18732r().getString(R.string.buddy_profile_interaction_me) + ": ";
        switch (C2288h.f8195a[enumC2214ab.ordinal()]) {
            case 1:
                if (z) {
                    return str + CommonApplication.m18732r().getString(R.string.media_animessage_text);
                }
                return str + CommonApplication.m18732r().getString(R.string.media_animessage);
            case 2:
                if (z) {
                    return str + CommonApplication.m18732r().getString(R.string.media_sticker_text);
                }
                return str + CommonApplication.m18732r().getString(R.string.chat_stickers);
            case 3:
                return str + CommonApplication.m18732r().getString(R.string.media_voice);
            case 4:
                return str + CommonApplication.m18732r().getString(R.string.media_event);
            case 5:
                return str + CommonApplication.m18732r().getString(R.string.popup_media_contact);
            case 6:
            case 7:
                String string4 = CommonApplication.m18732r().getString(R.string.last_message_me_document);
                if (strArr == null || strArr.length < 3 || strArr[2] == null) {
                    return string4;
                }
                String[] strArrSplit = strArr[2].split("\n");
                if (strArrSplit != null && strArrSplit.length > 3) {
                    String strSubstring = strArrSplit[3].substring(strArrSplit[3].lastIndexOf(".") + 1);
                    if (!TextUtils.isEmpty(strSubstring)) {
                        string4 = CommonApplication.m18732r().getString(R.string.dialog_chatting_me, strSubstring.toUpperCase());
                    }
                } else {
                    string4 = CommonApplication.m18732r().getString(R.string.dialog_chatting_me, strArr[2].toUpperCase());
                }
                return string4;
            case 8:
                return str + CommonApplication.m18732r().getString(R.string.media_map);
            case 9:
                if (z) {
                    return str + CommonApplication.m18732r().getString(R.string.media_image_text);
                }
                return str + CommonApplication.m18732r().getString(R.string.media_photo);
            case 10:
                if (z) {
                    return str + CommonApplication.m18732r().getString(R.string.media_video_text);
                }
                return str + CommonApplication.m18732r().getString(R.string.media_video);
            case 11:
                return str + CommonApplication.m18732r().getString(R.string.glympse);
            case 12:
                return str + CommonApplication.m18732r().getString(R.string.hugefile_large_file);
            case 13:
                if (strArr != null && strArr.length >= 3) {
                    strM8646b2 = C1736gi.m8646b(strArr[2]);
                }
                try {
                    try {
                        if (new JSONObject(strM8646b2).getJSONObject("push_message").getString("content_type").equals("result")) {
                            string3 = CommonApplication.m18732r().getString(R.string.poll_result_now_available);
                        } else {
                            string3 = CommonApplication.m18732r().getString(R.string.poll_title);
                        }
                        string2 = CommonApplication.m18732r().getString(R.string.dialog_chatting_me, string3);
                    } catch (JSONException e) {
                        C4904y.m18635a(e, "getLastMessageMe");
                        string2 = CommonApplication.m18732r().getString(R.string.dialog_chatting_me, "");
                    }
                    return string2;
                } catch (Throwable th) {
                    CommonApplication.m18732r().getString(R.string.dialog_chatting_me, "");
                    throw th;
                }
            case 14:
                if (strArr == null || strArr.length < 3) {
                    return "";
                }
                SpecialBuddyShareContentsEntry specialBuddyShareContentsEntryM17228a = C4542g.m17228a(C1736gi.m8646b(strArr[2]), true);
                if (specialBuddyShareContentsEntryM17228a == null) {
                    string = "";
                } else {
                    string = CommonApplication.m18732r().getString(R.string.dialog_chatting_me, specialBuddyShareContentsEntryM17228a.title);
                }
                return string;
            case 15:
                return (strArr == null || strArr.length < 3 || (specialBuddyRecommendBuddyEntryM17234b = C4542g.m17234b(C1736gi.m8646b(strArr[2]), true)) == null) ? "" : CommonApplication.m18732r().getString(R.string.dialog_chatting_me, specialBuddyRecommendBuddyEntryM17234b.name);
            case 16:
                if (strArr == null || strArr.length < 3) {
                    return "";
                }
                return C4542g.m17242g(C1736gi.m8646b(strArr[2]));
            case 17:
                if (strArr == null || strArr.length < 3) {
                    strM8646b = "";
                } else {
                    strM8646b = C1736gi.m8646b(strArr[2]);
                }
                return CommonApplication.m18732r().getString(R.string.dialog_chatting_me, ApplinkMsgEntry.getDisplayMessage(strM8646b));
            case 18:
                return CommonApplication.m18732r().getString(R.string.toast_supported_format);
            case 19:
                if (strArr != null && strArr.length >= 3) {
                    strM8646b2 = C1736gi.m8646b(strArr[2]);
                    if (C1736gi.m8652d(strM8646b2)) {
                        strM8646b2 = new StringBuilder(strM8646b2).substring(1);
                    }
                }
                return String.format(CommonApplication.m18732r().getString(R.string.dialog_chatting_me), strM8646b2);
            default:
                return "";
        }
    }
}
