package com.sec.chaton.chat;

import android.database.Cursor;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.p008a.C0100a;
import com.sec.chaton.p007a.p008a.EnumC0104e;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ChatUtil.java */
/* renamed from: com.sec.chaton.chat.bg */
/* loaded from: classes.dex */
public class C0493bg {
    /* renamed from: a */
    public static String m2686a(List list) {
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
    public static String m2681a(int i, Cursor cursor, Cursor cursor2) {
        return GlobalApplication.m3262c().getString(R.string.insert_inbox_broad_cast) + (C1789u.m6075a().getInt("broadcast_count", 0) + 1);
    }

    /* renamed from: a */
    public static String m2685a(String str, String str2) {
        if (str2 != null) {
            return GlobalApplication.m3262c().getString(R.string.insert_inbox_broad_cast) + " : " + str2;
        }
        return GlobalApplication.m3262c().getString(R.string.insert_inbox_broad_cast) + " : ";
    }

    /* renamed from: a */
    public static String m2682a(Cursor cursor) {
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
                sb.append(",");
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m2683a(Cursor cursor, List list, Map map) {
        int columnIndex = cursor.getColumnIndex("buddy_name");
        int columnIndex2 = cursor.getColumnIndex("buddy_no");
        int columnIndex3 = cursor.getColumnIndex("buddy_status_message");
        while (cursor.moveToNext()) {
            String strReplace = cursor.getString(columnIndex).replace("\n", " ");
            String string = cursor.getString(columnIndex2);
            String string2 = cursor.getString(columnIndex3);
            C0100a c0100a = (C0100a) map.get(string);
            if (c0100a == null) {
                map.put(string, new C0100a(string, strReplace, string2));
            } else if (TextUtils.isEmpty(c0100a.m656b()) || !c0100a.m656b().equalsIgnoreCase(strReplace)) {
                c0100a.m655a(strReplace);
                c0100a.m657b(string2);
            }
        }
        return m2687a(list, map);
    }

    /* renamed from: a */
    public static String m2687a(List list, Map map) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 <= list.size() - 1) {
                String str = (String) list.get(i2);
                if (map.containsKey(str)) {
                    sb.append(((C0100a) map.get(str)).m656b());
                } else {
                    sb.append((String) list.get(i2));
                }
                if (i2 != list.size() - 1) {
                    sb.append(",");
                }
                i = i2 + 1;
            } else {
                return sb.toString();
            }
        }
    }

    /* renamed from: b */
    public static boolean m2690b(Cursor cursor, List list, Map map) {
        boolean z;
        C0100a c0100a;
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
                C0100a c0100a2 = (C0100a) map.get(string);
                if (c0100a2 == null) {
                    c0100a = new C0100a(string, strReplace, string2);
                    z2 = true;
                } else if (TextUtils.isEmpty(c0100a2.m656b()) || !c0100a2.m656b().equalsIgnoreCase(strReplace)) {
                    c0100a2.m655a(strReplace);
                    c0100a2.m657b(string2);
                    c0100a = c0100a2;
                    z2 = true;
                } else {
                    z2 = z;
                    c0100a = c0100a2;
                }
            } else {
                z2 = z;
                c0100a = new C0100a(string, strReplace, string2);
            }
            map2.put(string, c0100a);
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
    public static EnumC0104e m2680a(int i, int i2) {
        if (i2 == 4001 || i2 == 4002 || i2 == 4003 || i2 == 4005) {
            return EnumC0104e.END_APP;
        }
        if (i == 0) {
            switch (i2) {
                case 1001:
                    return EnumC0104e.SUCCESS_RECEIVER_ERROR;
                case 3001:
                case 3008:
                    return EnumC0104e.CHANGE_SERVER;
                case 5009:
                    return EnumC0104e.BLOCK_RECEIVER;
                case 6002:
                    return EnumC0104e.INVALID_USER;
                default:
                    return EnumC0104e.FAIL;
            }
        }
        if (i == 2) {
            switch (i2) {
                case 3001:
                case 3003:
                case 3007:
                    return EnumC0104e.CHANGE_SERVER;
                case 4004:
                    return EnumC0104e.RESTART_APP;
                case 6002:
                    return EnumC0104e.NEED_HANDLE;
                default:
                    return EnumC0104e.FAIL;
            }
        }
        if (i == 4) {
            switch (i2) {
                case 1001:
                    return EnumC0104e.SUCCESS_RECEIVER_ERROR;
                case 3008:
                    return EnumC0104e.CHANGE_SERVER;
                case 5009:
                    return EnumC0104e.BLOCK_RECEIVER;
                case 6002:
                    return EnumC0104e.INVALID_USER;
                default:
                    return EnumC0104e.FAIL;
            }
        }
        if (i == 8) {
            switch (i2) {
                case 6002:
                    return EnumC0104e.REGARD_SUCCEESS;
                default:
                    return EnumC0104e.FAIL;
            }
        }
        return EnumC0104e.FAIL;
    }

    /* renamed from: a */
    public static String m2684a(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replace("%", "%25").replace(";", "%3B");
    }

    /* renamed from: b */
    public static String m2689b(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replace("%3B", ";").replace("%25", "%");
    }

    /* renamed from: a */
    public static String[] m2688a(String str, String str2, int i) {
        String[] strArrSplit = str.split(str2);
        String[] strArr = new String[i];
        StringBuilder sb = new StringBuilder();
        if (strArrSplit.length < i) {
            C1786r.m6054a("split error. The string has a lack of token", "ChatUtil");
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
