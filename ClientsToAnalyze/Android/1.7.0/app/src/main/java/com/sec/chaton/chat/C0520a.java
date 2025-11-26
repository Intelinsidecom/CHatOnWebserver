package com.sec.chaton.chat;

import android.database.Cursor;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015b.p016a.C0258f;
import com.sec.chaton.p015b.p016a.EnumC0255c;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ChatUtil.java */
/* renamed from: com.sec.chaton.chat.a */
/* loaded from: classes.dex */
public class C0520a {
    /* renamed from: a */
    public static String m2715a(List list) {
        StringBuilder sb = new StringBuilder("(");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                sb.append("'" + ((String) list.get(i2)) + "'");
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
    public static String m2710a(int i, Cursor cursor, Cursor cursor2) {
        return GlobalApplication.m3106g().getString(R.string.insert_inbox_broad_cast) + (C1323bs.m4575a().getInt("broadcast_count", 0) + 1);
    }

    /* renamed from: a */
    public static String m2714a(String str, String str2) {
        if (str == null || !str.equals("Y")) {
            return GlobalApplication.m3106g().getString(R.string.insert_inbox_broad_cast) + str2;
        }
        return str2;
    }

    /* renamed from: a */
    public static String m2711a(Cursor cursor) {
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
    public static String m2712a(Cursor cursor, List list, Map map) {
        int columnIndex = cursor.getColumnIndex("buddy_name");
        int columnIndex2 = cursor.getColumnIndex("buddy_no");
        int columnIndex3 = cursor.getColumnIndex("buddy_status_message");
        while (cursor.moveToNext()) {
            String strReplace = cursor.getString(columnIndex).replace("\n", " ");
            String string = cursor.getString(columnIndex2);
            String string2 = cursor.getString(columnIndex3);
            C0258f c0258f = (C0258f) map.get(string);
            if (c0258f == null) {
                map.put(string, new C0258f(string, strReplace, string2));
            } else if (TextUtils.isEmpty(c0258f.m919a()) || !c0258f.m919a().equalsIgnoreCase(strReplace)) {
                c0258f.m920a(strReplace);
                c0258f.m921b(string2);
            }
        }
        return m2716a(list, map);
    }

    /* renamed from: a */
    public static String m2716a(List list, Map map) {
        StringBuilder sb = new StringBuilder();
        for (int size = list.size() - 1; size >= 0; size--) {
            String str = (String) list.get(size);
            if (map.containsKey(str)) {
                sb.append(((C0258f) map.get(str)).m919a());
            } else {
                sb.append((String) list.get(size));
            }
            if (size != 0) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    /* renamed from: b */
    public static boolean m2719b(Cursor cursor, List list, Map map) {
        boolean z;
        C0258f c0258f;
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
                C0258f c0258f2 = (C0258f) map.get(string);
                if (c0258f2 == null) {
                    c0258f = new C0258f(string, strReplace, string2);
                    z2 = true;
                } else if (TextUtils.isEmpty(c0258f2.m919a()) || !c0258f2.m919a().equalsIgnoreCase(strReplace)) {
                    c0258f2.m920a(strReplace);
                    c0258f2.m921b(string2);
                    c0258f = c0258f2;
                    z2 = true;
                } else {
                    z2 = z;
                    c0258f = c0258f2;
                }
            } else {
                z2 = z;
                c0258f = new C0258f(string, strReplace, string2);
            }
            map2.put(string, c0258f);
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
    public static EnumC0255c m2709a(int i, int i2) {
        if (i2 == 4001 || i2 == 4002 || i2 == 4003 || i2 == 4005) {
            return EnumC0255c.END_APP;
        }
        if (i == 0 || 1029 == i) {
            switch (i2) {
                case 1001:
                    return EnumC0255c.SUCCESS_RECEIVER_ERROR;
                case 3001:
                case 3008:
                    return EnumC0255c.CHANGE_SERVER;
                case 5009:
                    return EnumC0255c.BLOCK_RECEIVER;
                case 6002:
                    return EnumC0255c.INVALID_USER;
                default:
                    return EnumC0255c.FAIL;
            }
        }
        if (i == 2) {
            switch (i2) {
                case 3001:
                case 3003:
                case 3007:
                    return EnumC0255c.CHANGE_SERVER;
                case 4004:
                    return EnumC0255c.RESTART_APP;
                case 6002:
                    return EnumC0255c.NEED_HANDLE;
                default:
                    return EnumC0255c.FAIL;
            }
        }
        if (4 == i || 1025 == i) {
            switch (i2) {
                case 1001:
                    return EnumC0255c.SUCCESS_RECEIVER_ERROR;
                case 3008:
                    return EnumC0255c.CHANGE_SERVER;
                case 5009:
                    return EnumC0255c.BLOCK_RECEIVER;
                case 6002:
                    return EnumC0255c.INVALID_USER;
                default:
                    return EnumC0255c.FAIL;
            }
        }
        if (i == 8) {
            switch (i2) {
                case 6002:
                    return EnumC0255c.REGARD_SUCCEESS;
                default:
                    return EnumC0255c.FAIL;
            }
        }
        return EnumC0255c.FAIL;
    }

    /* renamed from: a */
    public static String m2713a(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replace("%", "%25").replace(";", "%3B");
    }

    /* renamed from: b */
    public static String m2718b(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replace("%3B", ";").replace("%25", "%");
    }

    /* renamed from: a */
    public static String[] m2717a(String str, String str2, int i) {
        String[] strArrSplit = str.split(str2);
        String[] strArr = new String[i];
        StringBuilder sb = new StringBuilder();
        if (strArrSplit.length < i) {
            C1341p.m4651a("split error. The string has a lack of token", "ChatUtil");
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
}
