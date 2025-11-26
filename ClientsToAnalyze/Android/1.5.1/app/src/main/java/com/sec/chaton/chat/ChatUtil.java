package com.sec.chaton.chat;

import android.database.Cursor;
import android.text.TextUtils;
import com.sec.chaton.C0062R;
import com.sec.chaton.common.entry.BuddyEntry;
import com.sec.chaton.common.entry.MessageResultEntry;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;
import com.sec.pns.msg.MsgResultCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class ChatUtil {
    /* renamed from: a */
    public static MessageResultEntry.errorCode m792a(int i, int i2) {
        if (i2 == 4001 || i2 == 4002 || i2 == 4003 || i2 == 4005) {
            return MessageResultEntry.errorCode.END_APP;
        }
        if (i == 0) {
            switch (i2) {
                case 1001:
                    return MessageResultEntry.errorCode.SUCCESS_RECEIVER_ERROR;
                case MsgResultCode.FAIL_TO_AUTHENTICATE /* 3001 */:
                case 3008:
                    return MessageResultEntry.errorCode.CHANGE_SERVER;
                case 5009:
                    return MessageResultEntry.errorCode.BLOCK_RECEIVER;
                case 6002:
                    return MessageResultEntry.errorCode.INVALID_USER;
                default:
                    return MessageResultEntry.errorCode.FAIL;
            }
        }
        if (i == 2) {
            switch (i2) {
                case MsgResultCode.FAIL_TO_AUTHENTICATE /* 3001 */:
                case MsgResultCode.PROVISION_EXCEPTION /* 3003 */:
                case 3007:
                    return MessageResultEntry.errorCode.CHANGE_SERVER;
                case MsgResultCode.EMPTY_REG_ID /* 4004 */:
                    return MessageResultEntry.errorCode.RESTART_APP;
                case 6002:
                    return MessageResultEntry.errorCode.NEED_HANDLE;
                default:
                    return MessageResultEntry.errorCode.FAIL;
            }
        }
        if (i != 4) {
            if (i != 8) {
                return MessageResultEntry.errorCode.FAIL;
            }
            switch (i2) {
                case 6002:
                    return MessageResultEntry.errorCode.REGARD_SUCCEESS;
                default:
                    return MessageResultEntry.errorCode.FAIL;
            }
        }
        switch (i2) {
            case 1001:
                return MessageResultEntry.errorCode.SUCCESS_RECEIVER_ERROR;
            case 3008:
                return MessageResultEntry.errorCode.CHANGE_SERVER;
            case 5009:
                return MessageResultEntry.errorCode.BLOCK_RECEIVER;
            case 6002:
                return MessageResultEntry.errorCode.INVALID_USER;
            default:
                return MessageResultEntry.errorCode.FAIL;
        }
    }

    /* renamed from: a */
    public static String m793a(int i, Cursor cursor, Cursor cursor2) {
        return GlobalApplication.m2388f().getString(C0062R.string.insert_inbox_broad_cast) + (ChatONPref.m3519a().getInt("broadcast_count", 0) + 1);
    }

    /* renamed from: a */
    public static String m794a(Cursor cursor) {
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
    public static String m795a(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replace("%", "%25").replace(";", "%3B");
    }

    /* renamed from: a */
    public static String m796a(String str, String str2) {
        return (str == null || !str.equals("Y")) ? GlobalApplication.m2388f().getString(C0062R.string.insert_inbox_broad_cast) + str2 : str2;
    }

    /* renamed from: a */
    public static String m797a(List list) {
        String str = "(";
        for (int i = 0; i < list.size(); i++) {
            str = str + "" + ((String) list.get(i)) + "";
            if (i != list.size() - 1) {
                str = str + ",";
            }
        }
        return str + ")";
    }

    /* renamed from: a */
    public static boolean m798a(Cursor cursor, List list, Map map) {
        BuddyEntry buddyEntry;
        ArrayList arrayList = new ArrayList();
        HashMap map2 = new HashMap();
        boolean z = false;
        while (cursor.moveToNext()) {
            String strReplace = cursor.getString(cursor.getColumnIndex("buddy_name")).replace("\n", " ");
            String string = cursor.getString(cursor.getColumnIndex("buddy_no"));
            String string2 = cursor.getString(cursor.getColumnIndex("buddy_status_message"));
            if (map.containsKey(string)) {
                buddyEntry = (BuddyEntry) map.get(string);
                if (buddyEntry == null) {
                    buddyEntry = new BuddyEntry(string, strReplace, string2);
                    z = true;
                } else if (TextUtils.isEmpty(buddyEntry.m1942a()) || !buddyEntry.m1942a().equalsIgnoreCase(strReplace)) {
                    buddyEntry.m1943a(strReplace);
                    buddyEntry.m1944b(string2);
                    z = true;
                }
            } else {
                buddyEntry = new BuddyEntry(string, strReplace, string2);
            }
            map2.put(string, buddyEntry);
            arrayList.add(string);
        }
        boolean z2 = map.size() != map2.size() ? true : z;
        map.clear();
        list.clear();
        map.putAll(map2);
        list.addAll(arrayList);
        arrayList.clear();
        map2.clear();
        return z2;
    }

    /* renamed from: a */
    public static String[] m799a(String str, String str2, int i) {
        String[] strArrSplit = str.split(str2);
        String[] strArr = new String[i];
        StringBuilder sb = new StringBuilder();
        if (strArrSplit.length < i) {
            ChatONLogWriter.m3499a("split error. The string has a lack of token", "ChatUtil");
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
        strArr[i - 1] = sb.toString();
        return strArr;
    }

    /* renamed from: b */
    public static String m800b(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replace("%3B", ";").replace("%25", "%");
    }
}
