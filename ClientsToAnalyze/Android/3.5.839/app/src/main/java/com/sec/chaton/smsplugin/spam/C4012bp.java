package com.sec.chaton.smsplugin.spam;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SqliteWrapper;
import android.net.Uri;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.provider.C3959q;

/* compiled from: SpamFilter.java */
/* renamed from: com.sec.chaton.smsplugin.spam.bp */
/* loaded from: classes.dex */
public class C4012bp {

    /* renamed from: a */
    public static String f14465a;

    /* renamed from: b */
    public static String f14466b;

    /* renamed from: c */
    public static String f14467c;

    /* renamed from: d */
    public static Uri f14468d;

    /* renamed from: e */
    public static Uri f14469e;

    /* renamed from: f */
    public static Uri f14470f;

    /* renamed from: g */
    public static Uri f14471g;

    /* renamed from: h */
    public static Uri f14472h;

    /* renamed from: i */
    public static Uri f14473i;

    /* renamed from: j */
    public static Uri f14474j;

    static {
        f14465a = C3847e.m14629M() ? "mms-sms" : "chaton-mms-sms";
        f14466b = C3847e.m14629M() ? "spamsms" : "chaton-spamsms";
        f14467c = C3847e.m14629M() ? "spammms" : "chaton-spammms";
        f14468d = Uri.parse("content://" + f14465a + "/spam-filter");
        f14469e = Uri.parse("content://" + f14465a + "/spam-messages");
        f14470f = Uri.parse("content://" + f14466b);
        f14471g = Uri.parse("content://" + f14466b + "/inbox");
        f14472h = Uri.parse("content://" + f14466b + "/spam");
        f14473i = Uri.parse("content://" + f14467c);
        f14474j = Uri.parse("content://" + f14467c + "/inbox");
    }

    /* renamed from: a */
    public static Uri m15422a(Context context, int i, String str, boolean z, int i2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("filter_type", Integer.valueOf(i));
        contentValues.put("filter", str);
        contentValues.put("enable", Integer.valueOf(z ? 1 : 0));
        contentValues.put("criteria", Integer.valueOf(i2));
        Uri uriInsert = context.getContentResolver().insert(f14468d, contentValues);
        int i3 = Integer.parseInt(uriInsert.getPathSegments().get(1));
        C4015bs.m15433a(i3, new C4017bu(i3, i, z, str, i2));
        return uriInsert;
    }

    /* renamed from: a */
    public static int m15421a(Context context, int i, String str) {
        new StringBuilder();
        C3890m.m14996b("Mms/SpamFilter", "SpamFilter delete()");
        if (context == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        Cursor cursorQuery = SqliteWrapper.query(context, context.getContentResolver(), f14468d, (String[]) null, (String) null, (String[]) null, (String) null);
        if (cursorQuery == null) {
            C3890m.m14998d("Mms/SpamFilter", "cursor is null");
            return 0;
        }
        String strReplace = str;
        while (cursorQuery.moveToNext()) {
            try {
                int i2 = cursorQuery.getInt(0);
                int i3 = cursorQuery.getInt(1);
                String string = cursorQuery.getString(3);
                int i4 = cursorQuery.getInt(4);
                String str2 = "_id=" + i2;
                if (C3847e.m14680al()) {
                    if (i3 == i && i4 == 0 && strReplace != null && string != null && string.length() != 0 && strReplace.length() != 0) {
                        if (C3959q.m15277a(strReplace)) {
                            strReplace = strReplace.replace(" ", "").replace("-", "");
                        }
                        if (TextUtils.equals(strReplace, string)) {
                            int iDelete = context.getContentResolver().delete(f14468d, str2, null);
                            C4015bs.m15444b(i, strReplace);
                            return iDelete;
                        }
                    }
                } else if (i3 == i && i4 == 0 && PhoneNumberUtils.compareStrictly(strReplace, string)) {
                    int iDelete2 = context.getContentResolver().delete(f14468d, str2, null);
                    C4015bs.m15444b(i, strReplace);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return iDelete2;
                }
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        int iDelete3 = context.getContentResolver().delete(f14468d, "filter_type = " + Integer.toString(i) + " AND filter = ?", new String[]{strReplace});
        C4015bs.m15444b(i, strReplace);
        return iDelete3;
    }
}
