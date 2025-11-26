package com.sec.chaton.chat;

import android.content.ActivityNotFoundException;
import android.content.ContentProviderOperation;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.text.util.Linkify;
import android.widget.TextView;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.C1071bk;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p050a.EnumC1109f;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.emoticon.C2797i;
import com.sec.chaton.p046a.C0864cr;
import com.sec.chaton.p046a.p047a.C0777a;
import com.sec.chaton.p046a.p047a.EnumC0789m;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p055d.C2142w;
import com.sec.chaton.p057e.C2220ah;
import com.sec.chaton.p057e.C2306z;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.p057e.p058a.C2176ab;
import com.sec.chaton.p057e.p058a.C2190d;
import com.sec.chaton.p057e.p058a.C2202p;
import com.sec.chaton.p065io.entry.specialbuddy.SpecialBuddyTopicChatEntry;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.smsplugin.provider.C3947e;
import com.sec.chaton.smsplugin.provider.C3965w;
import com.sec.chaton.util.C4820al;
import com.sec.chaton.util.C4844bi;
import com.sec.chaton.util.C4883f;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.spp.push.Config;
import com.sec.widget.C5179v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

/* compiled from: ChatUtil.java */
/* renamed from: com.sec.chaton.chat.gi */
/* loaded from: classes.dex */
public class C1736gi {

    /* renamed from: a */
    public static final Pattern f6538a = Pattern.compile("(chaton://)\\S+");

    /* renamed from: b */
    public static final Linkify.TransformFilter f6539b = new C1737gj();

    /* renamed from: a */
    public static String m8637a(List<String> list) {
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
    public static String m8634a(String str, String str2) {
        if (str == null || !str.equals("Y")) {
            return GlobalApplication.m10283b().getString(R.string.insert_inbox_broad_cast) + " : " + str2;
        }
        return str2;
    }

    /* renamed from: a */
    public static String m8635a(String str, String str2, int i) {
        String string = i == 0 ? GlobalApplication.m10283b().getString(R.string.no_contacts) : str2;
        if (str == null || !str.equals("Y")) {
            return GlobalApplication.m10283b().getString(R.string.insert_inbox_broad_cast) + " : " + string;
        }
        return string;
    }

    /* renamed from: a */
    public static String m8629a(Cursor cursor) {
        StringBuilder sb = new StringBuilder();
        int columnIndex = cursor.getColumnIndex("buddy_name");
        cursor.getColumnIndex("participants_buddy_no");
        while (cursor.moveToNext()) {
            if (cursor.isNull(columnIndex)) {
                sb.append(GlobalApplication.m10283b().getString(R.string.unknown));
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
    public static String m8630a(Cursor cursor, List<String> list, Map<String, C0777a> map) throws Resources.NotFoundException {
        int columnIndex = cursor.getColumnIndex("buddy_name");
        int columnIndex2 = cursor.getColumnIndex("buddy_no");
        int columnIndex3 = cursor.getColumnIndex("buddy_status_message");
        while (cursor.moveToNext()) {
            String string = cursor.getString(columnIndex);
            if (TextUtils.isEmpty(string)) {
                string = GlobalApplication.m10283b().getString(R.string.unknown);
            }
            String strReplace = string.replace("\n", " ");
            String string2 = cursor.getString(columnIndex2);
            String string3 = cursor.getString(columnIndex3);
            C0777a c0777a = map.get(string2);
            if (c0777a == null) {
                map.put(string2, new C0777a(string2, strReplace, string3));
            } else if (TextUtils.isEmpty(c0777a.m3099b()) || !c0777a.m3099b().equalsIgnoreCase(strReplace)) {
                c0777a.m3100b(strReplace);
                c0777a.m3102c(string3);
            }
        }
        return m8638a(list, map);
    }

    /* renamed from: a */
    public static String m8638a(List<String> list, Map<String, C0777a> map) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                String str = list.get(i2);
                if (map.containsKey(str)) {
                    sb.append(map.get(str).m3099b());
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

    /* renamed from: a */
    public static boolean m8644a(Cursor cursor, List<String> list, Map<String, C0777a> map, ArrayList<C0777a> arrayList, EnumC2300t enumC2300t, EnumC2301u enumC2301u, List<String> list2) {
        C0777a c0777a;
        boolean z;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        HashMap map2 = new HashMap();
        int columnIndex = cursor.getColumnIndex("participants_sms_address");
        int columnIndex2 = cursor.getColumnIndex("participants_user_type");
        boolean z2 = false;
        while (cursor.moveToNext()) {
            String string = cursor.getString(cursor.getColumnIndex("buddy_no"));
            if (enumC2300t == EnumC2300t.GROUPCHAT && enumC2301u == EnumC2301u.NORMAL) {
                String string2 = cursor.getString(columnIndex);
                String string3 = cursor.getString(columnIndex2);
                if (!TextUtils.isEmpty(string2) && (EnumC1109f.INVITED.m7095a().equals(string3) || EnumC1109f.INVITING.m7095a().equals(string3))) {
                    arrayList3.add(string);
                }
            }
            String strReplace = cursor.getString(cursor.getColumnIndex("buddy_name")).replace("\n", " ");
            String string4 = cursor.getString(cursor.getColumnIndex("buddy_status_message"));
            int i = cursor.getInt(cursor.getColumnIndex("buddy_account_info"));
            String string5 = cursor.getString(cursor.getColumnIndex("buddy_extra_info"));
            if (map.containsKey(string)) {
                C0777a c0777a2 = map.get(string);
                if (c0777a2 == null) {
                    c0777a = new C0777a(string, strReplace, string4, i, string5);
                    z = true;
                } else {
                    if (TextUtils.isEmpty(c0777a2.m3099b()) || !c0777a2.m3099b().equalsIgnoreCase(strReplace)) {
                        c0777a2.m3100b(strReplace);
                        c0777a2.m3102c(string4);
                        z2 = true;
                    }
                    if (c0777a2.m3101c() != i) {
                        c0777a2.m3097a(i);
                        z2 = true;
                    }
                    if (TextUtils.isEmpty(string5) || string5.equals(c0777a2.m3103d())) {
                        c0777a = c0777a2;
                        z = z2;
                    } else {
                        c0777a2.m3104d(string5);
                        c0777a = c0777a2;
                        z = true;
                    }
                }
            } else {
                c0777a = new C0777a(string, strReplace, string4, i, string5);
                z = z2;
            }
            map2.put(string, c0777a);
            arrayList2.add(string);
            if (i == 1) {
                C4904y.m18641c("web only user : " + string + " (" + strReplace + ")", "composeDataSet");
                arrayList.clear();
                arrayList.add(c0777a);
                z2 = z;
            } else {
                z2 = z;
            }
        }
        if (map.size() != map2.size()) {
            z2 = true;
        }
        map.clear();
        list.clear();
        list2.clear();
        map.putAll(map2);
        list.addAll(arrayList2);
        list2.addAll(arrayList3);
        arrayList2.clear();
        map2.clear();
        arrayList3.clear();
        return z2;
    }

    /* renamed from: a */
    public static EnumC0789m m8627a(int i, int i2) {
        if (i2 == 4001 || i2 == 4002 || i2 == 4003 || i2 == 4005) {
            return EnumC0789m.END_APP;
        }
        if (i2 == 7007) {
            return EnumC0789m.RESET_BY_WEB;
        }
        if (i == 0 || 106 == i) {
            switch (i2) {
                case 1001:
                    return EnumC0789m.SUCCESS_RECEIVER_ERROR;
                case 3001:
                case 3008:
                    return EnumC0789m.CHANGE_SERVER;
                case 5009:
                    return EnumC0789m.BLOCK_RECEIVER;
                case 6002:
                    return EnumC0789m.INVALID_USER;
                case 7006:
                    return EnumC0789m.NON_WEB_USER_DETECTED;
                default:
                    return EnumC0789m.UNKNOWN;
            }
        }
        if (i == 2) {
            switch (i2) {
                case 3001:
                case 3003:
                case 3007:
                    return EnumC0789m.CHANGE_SERVER;
                case 3006:
                    return EnumC0789m.SESSION_USER_NOT_EXIST;
                case 4004:
                    return EnumC0789m.RESTART_APP;
                case 6002:
                    return EnumC0789m.NEED_HANDLE;
                case 7001:
                    return EnumC0789m.SESSION_DEACTIVATED;
                default:
                    return EnumC0789m.UNKNOWN;
            }
        }
        if (4 == i || 102 == i) {
            switch (i2) {
                case 1001:
                    return EnumC0789m.SUCCESS_RECEIVER_ERROR;
                case 3003:
                case 3006:
                    return EnumC0789m.SESSION_USER_NOT_EXIST;
                case 3008:
                    return EnumC0789m.CHANGE_SERVER;
                case 5009:
                    return EnumC0789m.BLOCK_RECEIVER;
                case 6002:
                    return EnumC0789m.INVALID_USER;
                case 7001:
                    return EnumC0789m.SESSION_DEACTIVATED;
                default:
                    return EnumC0789m.UNKNOWN;
            }
        }
        if (i == 8) {
            switch (i2) {
                case 6002:
                    return EnumC0789m.REGARD_SUCCEESS;
                default:
                    return EnumC0789m.UNKNOWN;
            }
        }
        if (i == 12) {
            switch (i2) {
                case 3003:
                case 3006:
                    return EnumC0789m.SESSION_USER_NOT_EXIST;
                case 7001:
                    return EnumC0789m.SESSION_DEACTIVATED;
                case 7006:
                    return EnumC0789m.NON_WEB_USER_DETECTED;
            }
        }
        if (i == 31) {
            switch (i2) {
                case 3003:
                case 3006:
                    return EnumC0789m.SESSION_USER_NOT_EXIST;
                case 7006:
                    return EnumC0789m.NON_WEB_USER_DETECTED;
            }
        }
        return EnumC0789m.UNKNOWN;
    }

    /* renamed from: a */
    public static String m8632a(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replace("%", "%25").replace(Config.KEYVALUE_SPLIT, "%3B");
    }

    /* renamed from: b */
    public static String m8646b(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replace("%3B", Config.KEYVALUE_SPLIT).replace("%25", "%");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m8651c(java.lang.String r10) throws java.lang.Throwable {
        /*
            r8 = 1
            r9 = 0
            r6 = -1
            r7 = 0
            java.lang.String r0 = "[contactSavedCheck] Contact Saved Find Start"
            java.lang.String r1 = "ChatUtil"
            com.sec.chaton.util.C4904y.m18639b(r0, r1)     // Catch: java.lang.Exception -> Lad java.lang.Throwable -> Lbf
            android.net.Uri r0 = android.provider.ContactsContract.PhoneLookup.CONTENT_FILTER_URI     // Catch: java.lang.Exception -> Lad java.lang.Throwable -> Lbf
            java.lang.String r1 = android.net.Uri.encode(r10)     // Catch: java.lang.Exception -> Lad java.lang.Throwable -> Lbf
            android.net.Uri r1 = android.net.Uri.withAppendedPath(r0, r1)     // Catch: java.lang.Exception -> Lad java.lang.Throwable -> Lbf
            android.content.Context r0 = com.sec.chaton.global.GlobalApplication.m18732r()     // Catch: java.lang.Exception -> Lad java.lang.Throwable -> Lbf
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Exception -> Lad java.lang.Throwable -> Lbf
            r2 = 3
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Exception -> Lad java.lang.Throwable -> Lbf
            r3 = 0
            java.lang.String r4 = "display_name"
            r2[r3] = r4     // Catch: java.lang.Exception -> Lad java.lang.Throwable -> Lbf
            r3 = 1
            java.lang.String r4 = "number"
            r2[r3] = r4     // Catch: java.lang.Exception -> Lad java.lang.Throwable -> Lbf
            r3 = 2
            java.lang.String r4 = "_id"
            r2[r3] = r4     // Catch: java.lang.Exception -> Lad java.lang.Throwable -> Lbf
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> Lad java.lang.Throwable -> Lbf
            if (r1 == 0) goto Ld5
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> Lc7 java.lang.Exception -> Lc9
            if (r0 <= 0) goto Ld5
            boolean r0 = r1.moveToNext()     // Catch: java.lang.Throwable -> Lc7 java.lang.Exception -> Lc9
            if (r0 == 0) goto Ld5
            java.lang.String r0 = "_id"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> Lc7 java.lang.Exception -> Lcd
            int r2 = r1.getInt(r0)     // Catch: java.lang.Throwable -> Lc7 java.lang.Exception -> Lcd
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc7 java.lang.Exception -> Ld1
            r0.<init>()     // Catch: java.lang.Throwable -> Lc7 java.lang.Exception -> Ld1
            java.lang.String r3 = "[contactSavedCheck] Found in Contact Number : "
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch: java.lang.Throwable -> Lc7 java.lang.Exception -> Ld1
            java.lang.StringBuilder r0 = r0.append(r10)     // Catch: java.lang.Throwable -> Lc7 java.lang.Exception -> Ld1
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Lc7 java.lang.Exception -> Ld1
            java.lang.String r3 = "ChatUtil"
            com.sec.chaton.util.C4904y.m18639b(r0, r3)     // Catch: java.lang.Throwable -> Lc7 java.lang.Exception -> Ld1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc7 java.lang.Exception -> Ld1
            r0.<init>()     // Catch: java.lang.Throwable -> Lc7 java.lang.Exception -> Ld1
            java.lang.String r3 = "[contactSavedCheck] ContactSaved id : "
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch: java.lang.Throwable -> Lc7 java.lang.Exception -> Ld1
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> Lc7 java.lang.Exception -> Ld1
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Lc7 java.lang.Exception -> Ld1
            java.lang.String r3 = "ChatUtil"
            com.sec.chaton.util.C4904y.m18639b(r0, r3)     // Catch: java.lang.Throwable -> Lc7 java.lang.Exception -> Ld1
            r9 = r8
        L89:
            if (r1 == 0) goto L8e
            r1.close()
        L8e:
            r0 = r2
        L8f:
            if (r9 != 0) goto Lac
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "[contactSavedCheck] No PhoneNumber in Contact : "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r10)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "ChatUtil"
            com.sec.chaton.util.C4904y.m18639b(r0, r1)
            r0 = r6
        Lac:
            return r0
        Lad:
            r0 = move-exception
            r1 = r7
            r2 = r9
            r3 = r6
        Lb1:
            java.lang.String r4 = "ChatUtil"
            com.sec.chaton.util.C4904y.m18635a(r0, r4)     // Catch: java.lang.Throwable -> Lc7
            if (r1 == 0) goto Lbc
            r1.close()
        Lbc:
            r9 = r2
            r0 = r3
            goto L8f
        Lbf:
            r0 = move-exception
            r1 = r7
        Lc1:
            if (r1 == 0) goto Lc6
            r1.close()
        Lc6:
            throw r0
        Lc7:
            r0 = move-exception
            goto Lc1
        Lc9:
            r0 = move-exception
            r2 = r9
            r3 = r6
            goto Lb1
        Lcd:
            r0 = move-exception
            r2 = r8
            r3 = r6
            goto Lb1
        Ld1:
            r0 = move-exception
            r3 = r2
            r2 = r8
            goto Lb1
        Ld5:
            r2 = r6
            goto L89
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.chat.C1736gi.m8651c(java.lang.String):int");
    }

    /* renamed from: a */
    public static void m8639a(Context context, String str, String str2, String str3) {
        Uri uri = ContactsContract.Contacts.CONTENT_URI;
        if (TextUtils.isEmpty(str)) {
            Bundle bundle = new Bundle();
            bundle.putString("phone", str2);
            bundle.putString("name", str3);
            C4904y.m18639b("phoneNum: " + str2, "ChatUtil");
            C4904y.m18639b("NAME: " + str3, "ChatUtil");
            Intent intent = new Intent("android.intent.action.INSERT", uri);
            intent.putExtras(bundle);
            intent.putExtra("return-data", true);
            try {
                context.startActivity(intent);
                return;
            } catch (ActivityNotFoundException e) {
                C4904y.m18635a(e, "ChatUtil");
                C5179v.m19810a(GlobalApplication.m18732r(), R.string.toast_contact_not_found, 0).show();
                return;
            }
        }
        C4904y.m18639b("contact id: " + str, "ChatUtil");
        Intent intent2 = new Intent("android.intent.action.VIEW");
        intent2.setData(Uri.parse(uri + "/" + str));
        try {
            context.startActivity(intent2);
        } catch (ActivityNotFoundException e2) {
            C4904y.m18635a(e2, "ChatUtil");
            C5179v.m19810a(GlobalApplication.m18732r(), R.string.toast_contact_not_found, 0).show();
        }
    }

    /* renamed from: b */
    public static String[] m8650b(String str, String str2, int i) {
        String[] strArrSplit = str.split(str2);
        String[] strArr = new String[i];
        StringBuilder sb = new StringBuilder();
        if (strArrSplit.length < i) {
            C4904y.m18634a("split error. The string has a lack of token", "ChatUtil");
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

    /* renamed from: d */
    public static boolean m8652d(String str) {
        return (TextUtils.isEmpty(str) || "#".equals(str.trim()) || str.charAt(0) != '#') ? false : true;
    }

    /* renamed from: e */
    public static String m8653e(String str) {
        return m8633a(str, 97, true);
    }

    /* renamed from: a */
    public static String m8633a(String str, int i, boolean z) {
        if (str.length() >= i) {
            String strSubstring = str.substring(0, i);
            String strSubstring2 = str.substring(i, str.length());
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
                        if (C2797i.m11704a(str.substring(iLastIndexOf, strSubstring.length() + iIndexOf + 1)) != -1) {
                            strSubstring = strSubstring.concat(strSubstring2.substring(0, iIndexOf + 1));
                        }
                    } else {
                        strSubstring = strSubstring.substring(0, iLastIndexOf);
                    }
                }
            }
            if (z) {
                strSubstring = strSubstring.concat("...");
            }
            return strSubstring;
        }
        return str;
    }

    /* renamed from: a */
    public static String m8631a(EnumC2214ab enumC2214ab) throws Resources.NotFoundException {
        if (enumC2214ab == EnumC2214ab.TEXT || enumC2214ab == EnumC2214ab.UNDEFINED) {
            return GlobalApplication.m10283b().getString(R.string.delete_popup_body, GlobalApplication.m10283b().getString(R.string.qcmd_message));
        }
        String strM10071a = EnumC2214ab.m10071a(enumC2214ab);
        if (TextUtils.isEmpty(strM10071a)) {
            strM10071a = GlobalApplication.m10283b().getString(R.string.qcmd_message);
        }
        return GlobalApplication.m10283b().getString(R.string.delete_popup_body, strM10071a);
    }

    /* renamed from: f */
    public static String m8654f(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] strArrSplit = str.split("\n");
            if (strArrSplit.length > 6 && "mixed".equals(strArrSplit[0])) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 6; i < strArrSplit.length; i++) {
                    stringBuffer.append(strArrSplit[i] + "\n");
                }
                return stringBuffer.toString().substring(0, stringBuffer.length() - 1);
            }
        }
        return "";
    }

    /* renamed from: g */
    public static String m8655g(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] strArrSplit = str.split("\n");
        if (strArrSplit.length <= 3) {
            return "";
        }
        return strArrSplit[3];
    }

    /* renamed from: h */
    public static String m8656h(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] strArrSplit = str.split("\n");
        if (strArrSplit.length <= 4) {
            return "";
        }
        return strArrSplit[4];
    }

    /* renamed from: b */
    public static void m8648b(List<C0864cr> list) {
        Collections.sort(list, new C1738gk());
    }

    /* renamed from: a */
    public static void m8640a(Handler handler, SpecialBuddyTopicChatEntry specialBuddyTopicChatEntry) {
        String strValueOf = String.valueOf(System.currentTimeMillis());
        C2142w c2142wM9593a = C2142w.m9593a(strValueOf, EnumC2300t.GROUPCHAT);
        if (c2142wM9593a != null) {
            c2142wM9593a.mo9252a(strValueOf, C4844bi.m18323a().m18328c().m18329a(), C4844bi.m18323a().m18328c().m18332b());
            c2142wM9593a.m9642a(true);
            c2142wM9593a.mo9243a(Long.MAX_VALUE);
            c2142wM9593a.m9624a(specialBuddyTopicChatEntry);
            c2142wM9593a.m9246a(handler);
            return;
        }
        if (C4904y.f17875e) {
            C4904y.m18634a("joinTopicChat() - cannot get MessageControl", "ChatUtil");
        }
    }

    /* renamed from: a */
    public static void m8642a(String str, long j) throws Resources.NotFoundException {
        Context contextM18732r = CommonApplication.m18732r();
        String string = contextM18732r.getResources().getString(R.string.sms_registered_notification, str);
        C4820al c4820alM18181a = C4820al.m18181a();
        c4820alM18181a.m18187b(C1071bk.f3377k);
        c4820alM18181a.m18182a(j);
        c4820alM18181a.m18184a(contextM18732r, string, C4820al.f17596i, C4820al.f17591d);
        new C2128i(null).m9495a();
    }

    /* renamed from: a */
    public static C1740gm m8628a(String str, ArrayList<C1739gl> arrayList) {
        C1740gm c1740gmM8664a;
        String str2 = "message_inbox_no =? AND ";
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList arrayList2 = new ArrayList();
        Iterator<C1739gl> it = arrayList.iterator();
        while (it.hasNext()) {
            C1739gl next = it.next();
            if (!arrayList2.contains(Long.valueOf(next.f6541b))) {
                arrayList2.add(Long.valueOf(next.f6541b));
            }
        }
        if (arrayList2.size() > 0) {
            if (arrayList2.size() == 1) {
                str2 = "message_inbox_no =? AND _id = " + arrayList2.get(0);
            } else {
                String str3 = "message_inbox_no =? AND _id IN ( ";
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    stringBuffer.append(", " + String.valueOf((Long) it2.next()));
                }
                str2 = str3 + stringBuffer.toString().substring(1) + " )";
            }
        }
        Cursor cursorQuery = CommonApplication.m18732r().getContentResolver().query(C2306z.f8229a, new String[]{"_id", "message_read_status", "message_time"}, str2, new String[]{str}, "message_time DESC");
        try {
            if (!cursorQuery.moveToFirst()) {
                c1740gmM8664a = null;
            } else {
                Long lValueOf = Long.valueOf(cursorQuery.getLong(0));
                int i = cursorQuery.getInt(1);
                Long lValueOf2 = Long.valueOf(cursorQuery.getLong(2));
                if (C4904y.f17873c) {
                    C4904y.m18641c("AnsMsgInfo : MsgId(" + lValueOf + "), MsgReadCount(" + i + "), AnsTime(" + lValueOf2 + ")", "ChatUtil");
                }
                c1740gmM8664a = C1740gm.m8664a(lValueOf, i, lValueOf2);
            }
            return c1740gmM8664a;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    /* renamed from: a */
    public static void m8643a(String str, C1740gm c1740gm, ArrayList<C1739gl> arrayList, HashMap<String, C1741gn> map) {
        String str2 = "participants_inbox_no =? AND ";
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList arrayList2 = new ArrayList();
        Iterator<C1739gl> it = arrayList.iterator();
        while (it.hasNext()) {
            C1739gl next = it.next();
            if (c1740gm.f6542a.longValue() == next.f6541b && !arrayList2.contains(next.f6540a)) {
                arrayList2.add(next.f6540a);
            }
        }
        if (arrayList2.size() > 0) {
            if (arrayList2.size() == 1) {
                str2 = "participants_inbox_no =? AND participants_buddy_no = '" + ((String) arrayList2.get(0)) + "'";
            } else {
                String str3 = "participants_inbox_no =? AND participants_buddy_no IN ( ";
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    stringBuffer.append(", '" + String.valueOf((String) it2.next())).append("'");
                }
                str2 = str3 + stringBuffer.toString().substring(1) + " )";
            }
        }
        Cursor cursorQuery = CommonApplication.m18732r().getContentResolver().query(C2220ah.f7942a, new String[]{"participants_buddy_no", "participants_read_time"}, str2, new String[]{str}, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.getCount() > 0) {
                    cursorQuery.move(-1);
                    Long.valueOf(0L);
                    while (cursorQuery.moveToNext()) {
                        String string = cursorQuery.getString(0);
                        Long lValueOf = Long.valueOf(cursorQuery.getLong(1));
                        if (C4904y.f17873c) {
                            C4904y.m18641c("AnsParticipantInfo : participantNo(" + string + "), readTime(" + lValueOf + ")", "ChatUtil");
                        }
                        map.put(string, C1741gn.m8665a(lValueOf));
                    }
                }
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
    }

    /* renamed from: b */
    public static void m8647b(String str, ArrayList<C1739gl> arrayList) {
        if (arrayList.size() != 0) {
            C1740gm c1740gmM8628a = m8628a(str, arrayList);
            if (c1740gmM8628a == null) {
                if (C4904y.f17873c) {
                    C4904y.m18641c("ansLatestMsgInfo is null!!", "ChatUtil");
                    StringBuilder sb = new StringBuilder("itemList : ");
                    Iterator<C1739gl> it = arrayList.iterator();
                    while (it.hasNext()) {
                        sb.append(it.next().f6541b).append(",");
                    }
                    C4904y.m18641c(sb.toString(), "ChatUtil");
                    return;
                }
                return;
            }
            HashMap map = new HashMap();
            m8643a(str, c1740gmM8628a, arrayList, (HashMap<String, C1741gn>) map);
            ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
            for (Map.Entry entry : map.entrySet()) {
                if (c1740gmM8628a.f6543b.longValue() > ((C1741gn) entry.getValue()).f6546a.longValue()) {
                    arrayList2.add(C2176ab.m9671a(str, (String) entry.getKey(), c1740gmM8628a.f6543b));
                    c1740gmM8628a.f6545d++;
                }
            }
            if (c1740gmM8628a.f6545d != 0) {
                ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C2306z.m10213a());
                builderNewUpdate.withValue("inboxNo", str).withValue("time", c1740gmM8628a.f6543b).withValue(VKApiConst.COUNT, Integer.valueOf(c1740gmM8628a.f6545d + c1740gmM8628a.f6544c));
                arrayList2.add(builderNewUpdate.build());
                try {
                    try {
                        if (arrayList2.size() > 0) {
                            CommonApplication.m18732r().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList2);
                        }
                    } catch (Exception e) {
                        C4904y.m18634a(e.getMessage(), "ChatUtil");
                    }
                } finally {
                    arrayList2.clear();
                }
            }
        }
    }

    /* renamed from: i */
    public static String m8657i(String str) {
        Cursor cursorM9843h = C2190d.m9843h(CommonApplication.m18732r().getContentResolver(), str);
        if (cursorM9843h == null || cursorM9843h.getCount() <= 0) {
            return null;
        }
        cursorM9843h.moveToFirst();
        String strM8636a = m8636a(str, cursorM9843h.getString(cursorM9843h.getColumnIndex("buddy_orginal_number")), cursorM9843h.getColumnIndex("buddy_msisdns") > 0 ? cursorM9843h.getString(cursorM9843h.getColumnIndex("buddy_msisdns")) : null);
        if (!TextUtils.isEmpty(strM8636a)) {
            return strM8636a;
        }
        if (cursorM9843h == null || cursorM9843h.isClosed()) {
            return null;
        }
        cursorM9843h.close();
        return null;
    }

    /* renamed from: a */
    public static String m8636a(String str, String str2, String str3) {
        if (!C4883f.m18540a(str, str3)) {
            if (!m8649b(str, str2)) {
                return "+" + str;
            }
            return str2;
        }
        List<String> listM8658j = m8658j(str3);
        if (listM8658j.size() > 0) {
            return "+" + listM8658j.get(0);
        }
        return null;
    }

    /* renamed from: b */
    public static boolean m8649b(String str, String str2) {
        if (TextUtils.isEmpty(str) || str.length() < 19 || !str.startsWith("10") || TextUtils.isEmpty(str2)) {
            return false;
        }
        return true;
    }

    /* renamed from: j */
    public static List<String> m8658j(String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, "|");
            new String();
            while (stringTokenizer.hasMoreTokens()) {
                String strNextToken = stringTokenizer.nextToken();
                if ((strNextToken.length() < 19 || !strNextToken.startsWith("10")) && !strNextToken.startsWith(Spam.ACTIVITY_CANCEL)) {
                    arrayList.add(strNextToken);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static void m8641a(TextView textView) {
        Linkify.addLinks(textView, 15);
        Linkify.addLinks(textView, f6538a, "", (Linkify.MatchFilter) null, f6539b);
    }

    /* renamed from: k */
    public static ContentValues m8659k(String str) {
        ContentValues contentValuesM8661m = m8661m(str);
        long jLongValue = (contentValuesM8661m == null || !contentValuesM8661m.containsKey("inbox_last_time")) ? 0L : contentValuesM8661m.getAsLong("inbox_last_time").longValue();
        ContentValues contentValuesM8660l = m8660l(str);
        long jLongValue2 = (contentValuesM8660l == null || !contentValuesM8660l.containsKey("inbox_last_time")) ? 0L : contentValuesM8660l.getAsLong("inbox_last_time").longValue();
        if (jLongValue == 0 && jLongValue2 == 0) {
            C4904y.m18639b("##### handleMessage: both of messages is null inboxNo : " + str, "ChatUtil");
            return null;
        }
        if (jLongValue > jLongValue2) {
            C4904y.m18639b("##### handleMessage: QUERY_SMS_LASTMESSAGE actual the last message is SMS/MMS for inboxNo : " + str, "ChatUtil");
            return contentValuesM8661m;
        }
        C4904y.m18639b("##### handleMessage: QUERY_SMS_LASTMESSAGE actual the last message is ChatON for inboxNo : " + str, "ChatUtil");
        return contentValuesM8660l;
    }

    /* renamed from: l */
    public static ContentValues m8660l(String str) {
        Cursor cursorQuery = GlobalApplication.m18732r().getContentResolver().query(C2306z.m10218b(), null, "message_inbox_no = ? AND ( message_type = ? OR message_type = ? ) AND message_content_type != ?", new String[]{str, String.valueOf(1), String.valueOf(2), String.valueOf(EnumC2214ab.SYSTEM.m10076a())}, "message_is_failed , message_time , _id");
        ContentValues contentValues = null;
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.moveToLast();
            if (cursorQuery.moveToPrevious()) {
                contentValues = new ContentValues();
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("message_content"));
                int i = cursorQuery.getInt(cursorQuery.getColumnIndex("message_type"));
                EnumC2214ab enumC2214abM10070a = EnumC2214ab.m10070a(cursorQuery.getInt(cursorQuery.getColumnIndex("message_content_type")));
                String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_name"));
                long j = cursorQuery.getLong(cursorQuery.getColumnIndex("message_time"));
                String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("message_sever_id"));
                String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("message_sender"));
                contentValues.put("inbox_last_message", String.format("%d;%d;%s;%s", Integer.valueOf(i), Integer.valueOf(enumC2214abM10070a.m10076a()), m8632a(string), m8632a(string2)));
                contentValues.put("inbox_last_msg_no", string3);
                contentValues.put("inbox_last_time", Long.valueOf(j));
                contentValues.put("inbox_last_msg_sender", string4);
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return contentValues;
    }

    /* renamed from: m */
    public static ContentValues m8661m(String str) throws Resources.NotFoundException {
        long j;
        int i;
        ContentValues contentValues = null;
        string = null;
        String string = null;
        contentValues = null;
        contentValues = null;
        contentValues = null;
        String strM9988e = C2202p.m9988e(GlobalApplication.m18732r().getContentResolver(), str);
        if (!TextUtils.isEmpty(strM9988e)) {
            Cursor cursorQuery = GlobalApplication.m18732r().getContentResolver().query(Uri.withAppendedPath(ContentUris.withAppendedId(C3965w.f14266a, Long.valueOf(strM9988e).longValue()), "subject"), new String[]{"snippet", "date", "snippet_cs"}, null, null, null);
            if (cursorQuery != null && cursorQuery.getCount() > 0 && !cursorQuery.isClosed()) {
                if (cursorQuery == null) {
                    j = 0;
                    i = 0;
                } else {
                    try {
                        if (!cursorQuery.moveToFirst()) {
                            j = 0;
                            i = 0;
                        } else {
                            string = cursorQuery.getString(0);
                            j = cursorQuery.getLong(1);
                            i = !cursorQuery.isNull(2) ? cursorQuery.getInt(2) : 0;
                        }
                    } finally {
                        cursorQuery.close();
                    }
                }
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("inbox_last_time", Long.valueOf(j));
                if (TextUtils.isEmpty(string)) {
                    string = CommonApplication.m18732r().getResources().getString(R.string.no_subject);
                }
                contentValues2.put("inbox_last_message", C3947e.m15257a(string, i));
                contentValues = contentValues2;
            }
            if (cursorQuery != null && !cursorQuery.isClosed()) {
            }
        }
        return contentValues;
    }

    /* renamed from: b */
    public static long m8645b(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("message_time");
        if (columnIndex != -1) {
            return cursor.getLong(columnIndex);
        }
        C1730gc c1730gc = new C1730gc(cursor);
        long j = cursor.getLong(c1730gc.f6502f);
        if ("mms".equals(cursor.getString(c1730gc.f6497a))) {
            return j * 1000;
        }
        return j;
    }
}
