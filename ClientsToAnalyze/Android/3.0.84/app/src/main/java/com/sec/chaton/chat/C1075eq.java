package com.sec.chaton.chat;

import android.content.res.Resources;
import android.database.Cursor;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.emoticon.C1833h;
import com.sec.chaton.p016a.p017a.C0264a;
import com.sec.chaton.p016a.p017a.EnumC0273j;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.settings2.PrefFragmentChats;
import com.sec.chaton.util.C3250y;
import com.sec.spp.push.Config;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ChatUtil.java */
/* renamed from: com.sec.chaton.chat.eq */
/* loaded from: classes.dex */
public class C1075eq {
    /* renamed from: a */
    public static String m5321a(List<String> list) {
        StringBuilder sb = new StringBuilder("(");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                sb.append("'" + list.get(i2) + "'");
                if (i2 != list.size() - 1) {
                    sb.append(",");
                }
                i = i2 + 1;
            } else {
                sb.append(")");
                return sb.toString();
            }
        }
    }

    /* renamed from: a */
    public static String m5319a(String str, String str2) {
        if (str == null || !str.equals("Y")) {
            return GlobalApplication.m6451b().getString(R.string.insert_inbox_broad_cast) + " : " + str2;
        }
        return str2;
    }

    /* renamed from: a */
    public static String m5320a(String str, String str2, int i) {
        String string = i == 0 ? GlobalApplication.m6451b().getString(R.string.chat_title_no_buddies) : str2;
        if (str == null || !str.equals("Y")) {
            return GlobalApplication.m6451b().getString(R.string.insert_inbox_broad_cast) + " : " + string;
        }
        return string;
    }

    /* renamed from: a */
    public static String m5315a(Cursor cursor) {
        StringBuilder sb = new StringBuilder();
        int columnIndex = cursor.getColumnIndex("buddy_name");
        int columnIndex2 = cursor.getColumnIndex("participants_buddy_no");
        while (cursor.moveToNext()) {
            if (cursor.isNull(columnIndex)) {
                sb.append(cursor.getString(columnIndex2));
            } else {
                sb.append(cursor.getString(columnIndex).replace("\n", " "));
            }
            if (!cursor.isLast()) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m5316a(Cursor cursor, List<String> list, Map<String, C0264a> map) throws Resources.NotFoundException {
        int columnIndex = cursor.getColumnIndex("buddy_name");
        int columnIndex2 = cursor.getColumnIndex("buddy_no");
        int columnIndex3 = cursor.getColumnIndex("buddy_status_message");
        while (cursor.moveToNext()) {
            String string = cursor.getString(columnIndex);
            if (TextUtils.isEmpty(string)) {
                string = GlobalApplication.m6451b().getString(R.string.unknown);
            }
            String strReplace = string.replace("\n", " ");
            String string2 = cursor.getString(columnIndex2);
            String string3 = cursor.getString(columnIndex3);
            C0264a c0264a = map.get(string2);
            if (c0264a == null) {
                map.put(string2, new C0264a(string2, strReplace, string3));
            } else if (TextUtils.isEmpty(c0264a.m1329a()) || !c0264a.m1329a().equalsIgnoreCase(strReplace)) {
                c0264a.m1331b(strReplace);
                c0264a.m1332c(string3);
            }
        }
        return m5322a(list, map);
    }

    /* renamed from: a */
    public static String m5322a(List<String> list, Map<String, C0264a> map) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                String str = list.get(i2);
                if (map.containsKey(str)) {
                    sb.append(map.get(str).m1329a());
                } else {
                    sb.append(list.get(i2));
                }
                if (i2 != list.size() - 1) {
                    sb.append(", ");
                }
                i = i2 + 1;
            } else {
                return sb.toString();
            }
        }
    }

    /* renamed from: b */
    public static boolean m5324b(Cursor cursor, List<String> list, Map<String, C0264a> map) {
        boolean z;
        C0264a c0264a;
        ArrayList arrayList = new ArrayList();
        HashMap map2 = new HashMap();
        boolean z2 = false;
        while (true) {
            z = z2;
            if (!cursor.moveToNext()) {
                break;
            }
            String strReplace = cursor.getString(cursor.getColumnIndex("buddy_name")).replace("\n", " ");
            String string = cursor.getString(cursor.getColumnIndex("buddy_no"));
            String string2 = cursor.getString(cursor.getColumnIndex("buddy_status_message"));
            if (map.containsKey(string)) {
                C0264a c0264a2 = map.get(string);
                if (c0264a2 == null) {
                    c0264a = new C0264a(string, strReplace, string2);
                    z2 = true;
                } else if (TextUtils.isEmpty(c0264a2.m1329a()) || !c0264a2.m1329a().equalsIgnoreCase(strReplace)) {
                    c0264a2.m1331b(strReplace);
                    c0264a2.m1332c(string2);
                    c0264a = c0264a2;
                    z2 = true;
                } else {
                    z2 = z;
                    c0264a = c0264a2;
                }
            } else {
                z2 = z;
                c0264a = new C0264a(string, strReplace, string2);
            }
            map2.put(string, c0264a);
            arrayList.add(string);
        }
        boolean z3 = map.size() == map2.size() ? z : true;
        map.clear();
        list.clear();
        map.putAll(map2);
        list.addAll(arrayList);
        arrayList.clear();
        map2.clear();
        return z3;
    }

    /* renamed from: a */
    public static EnumC0273j m5314a(int i, int i2) {
        if (i2 == 4001 || i2 == 4002 || i2 == 4003 || i2 == 4005) {
            return EnumC0273j.END_APP;
        }
        if (i2 == 7007) {
            return EnumC0273j.RESET_BY_WEB;
        }
        if (i == 0 || 106 == i) {
            switch (i2) {
                case 1001:
                    return EnumC0273j.SUCCESS_RECEIVER_ERROR;
                case 3001:
                case 3008:
                    return EnumC0273j.CHANGE_SERVER;
                case 5009:
                    return EnumC0273j.BLOCK_RECEIVER;
                case 6002:
                    return EnumC0273j.INVALID_USER;
                case 7006:
                    return EnumC0273j.NON_WEB_USER_DETECTED;
                default:
                    return EnumC0273j.FAIL;
            }
        }
        if (i == 2) {
            switch (i2) {
                case 3001:
                case 3003:
                case 3007:
                    return EnumC0273j.CHANGE_SERVER;
                case 3006:
                    return EnumC0273j.SESSION_USER_NOT_EXIST;
                case 4004:
                    return EnumC0273j.RESTART_APP;
                case 6002:
                    return EnumC0273j.NEED_HANDLE;
                case PrefFragmentChats.METHOD_SET_TYPING_STATUS /* 7001 */:
                    return EnumC0273j.SESSION_DEACTIVATED;
                default:
                    return EnumC0273j.FAIL;
            }
        }
        if (4 == i || 102 == i) {
            switch (i2) {
                case 1001:
                    return EnumC0273j.SUCCESS_RECEIVER_ERROR;
                case 3003:
                case 3006:
                    return EnumC0273j.SESSION_USER_NOT_EXIST;
                case 3008:
                    return EnumC0273j.CHANGE_SERVER;
                case 5009:
                    return EnumC0273j.BLOCK_RECEIVER;
                case 6002:
                    return EnumC0273j.INVALID_USER;
                case PrefFragmentChats.METHOD_SET_TYPING_STATUS /* 7001 */:
                    return EnumC0273j.SESSION_DEACTIVATED;
                default:
                    return EnumC0273j.FAIL;
            }
        }
        if (i == 8) {
            switch (i2) {
                case 6002:
                    return EnumC0273j.REGARD_SUCCEESS;
                default:
                    return EnumC0273j.FAIL;
            }
        }
        if (i == 12) {
            switch (i2) {
                case 3003:
                case 3006:
                    return EnumC0273j.SESSION_USER_NOT_EXIST;
                case PrefFragmentChats.METHOD_SET_TYPING_STATUS /* 7001 */:
                    return EnumC0273j.SESSION_DEACTIVATED;
                case 7006:
                    return EnumC0273j.NON_WEB_USER_DETECTED;
            }
        }
        if (i == 31) {
            switch (i2) {
                case 3003:
                case 3006:
                    return EnumC0273j.SESSION_USER_NOT_EXIST;
                case 7006:
                    return EnumC0273j.NON_WEB_USER_DETECTED;
            }
        }
        return EnumC0273j.FAIL;
    }

    /* renamed from: a */
    public static String m5318a(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replace("%", "%25").replace(Config.KEYVALUE_SPLIT, "%3B");
    }

    /* renamed from: b */
    public static String m5323b(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replace("%3B", Config.KEYVALUE_SPLIT).replace("%25", "%");
    }

    /* renamed from: b */
    public static String[] m5325b(String str, String str2, int i) {
        String[] strArrSplit = str.split(str2);
        String[] strArr = new String[i];
        StringBuilder sb = new StringBuilder();
        if (strArrSplit.length < i) {
            C3250y.m11442a("split error. The string has a lack of token", "ChatUtil");
            return strArrSplit;
        }
        for (int i2 = 0; i2 < i - 1; i2++) {
            strArr[i2] = strArrSplit[i2];
        }
        for (int i3 = i - 1; i3 < strArrSplit.length; i3++) {
            sb.append(strArrSplit[i3]);
            if (i3 + 1 < strArrSplit.length) {
                sb.append(str2);
            }
        }
        if (i - 1 < strArr.length) {
            strArr[i - 1] = sb.toString();
        }
        return strArr;
    }

    /* renamed from: c */
    public static boolean m5326c(String str) {
        return (TextUtils.isEmpty(str) || "#".equals(str.trim()) || str.charAt(0) != '#') ? false : true;
    }

    /* renamed from: d */
    public static String m5327d(String str) {
        if (str.length() >= 97) {
            String strSubstring = str.substring(0, 97);
            String strSubstring2 = str.substring(97, str.length());
            int iLastIndexOf = strSubstring.lastIndexOf("[");
            if (iLastIndexOf >= 0) {
                int iLastIndexOf2 = strSubstring.lastIndexOf("]");
                if (iLastIndexOf2 >= 0) {
                    if (iLastIndexOf >= iLastIndexOf2) {
                        strSubstring = strSubstring.substring(0, iLastIndexOf);
                    }
                } else {
                    int iIndexOf = strSubstring2.indexOf("]");
                    if (iIndexOf >= 0) {
                        if (C1833h.m7503a(str.substring(iLastIndexOf, strSubstring.length() + iIndexOf + 1)) != -1) {
                            strSubstring = strSubstring.concat(strSubstring2.substring(0, iIndexOf + 1));
                        }
                    } else {
                        strSubstring = strSubstring.substring(0, iLastIndexOf);
                    }
                }
            }
            return strSubstring.concat("...");
        }
        return str;
    }

    /* renamed from: a */
    public static String m5317a(EnumC1455w enumC1455w) throws Resources.NotFoundException {
        String string;
        String string2 = GlobalApplication.m6451b().getString(R.string.delete_popup_body);
        switch (C1076er.f4315a[enumC1455w.ordinal()]) {
            case 1:
                string = GlobalApplication.m6451b().getString(R.string.qcmd_message);
                break;
            case 2:
                string = GlobalApplication.m6451b().getString(R.string.media_photo);
                break;
            case 3:
                string = GlobalApplication.m6451b().getString(R.string.media_video);
                break;
            case 4:
                string = GlobalApplication.m6451b().getString(R.string.media_map);
                break;
            case 5:
                string = GlobalApplication.m6451b().getString(R.string.media_voice);
                break;
            case 6:
                string = GlobalApplication.m6451b().getString(R.string.media_contact);
                break;
            case 7:
                string = GlobalApplication.m6451b().getString(R.string.media_calendar);
                break;
            case 8:
                string = GlobalApplication.m6451b().getString(R.string.media_file);
                break;
            default:
                string = GlobalApplication.m6451b().getString(R.string.qcmd_message);
                break;
        }
        return String.format(string2, string);
    }
}
