package com.sec.chaton.search;

import android.content.Intent;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MergeCursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import com.sec.chaton.R;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.search.Search;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: Search.java */
/* renamed from: com.sec.chaton.search.b */
/* loaded from: classes.dex */
public class C2380b {

    /* renamed from: a */
    public static final String f8841a = C2380b.class.getSimpleName();

    /* renamed from: b */
    protected static final Uri f8842b = Uri.parse("content://com.sec.chaton.provider/buddy");

    /* renamed from: c */
    protected static final Uri f8843c = Uri.parse("content://com.sec.chaton.provider/inbox");

    /* renamed from: d */
    public static final String[] f8844d = {"suggest_icon_1", "suggest_text_1", "suggest_text_2", "suggest_text_3", "suggest_target_type", "suggest_group", "suggest_intent_action", "suggest_intent_data", "suggest_intent_extra_data"};

    /* renamed from: e */
    private static final Map<Search.RequestKey, SearchResponse> f8845e = new HashMap();

    /* renamed from: f */
    private List<C2382d> f8846f = new ArrayList();

    /* renamed from: a */
    public void m8848a(C2382d c2382d) {
        this.f8846f.add(c2382d);
    }

    /* renamed from: a */
    public void m8847a() {
        this.f8846f.clear();
    }

    /* renamed from: a */
    public Cursor m8845a(SQLiteDatabase sQLiteDatabase) {
        Cursor[] cursorArr = new Cursor[this.f8846f.size()];
        Iterator<C2382d> it = this.f8846f.iterator();
        int i = 0;
        while (it.hasNext()) {
            cursorArr[i] = m8846a(sQLiteDatabase, it.next());
            i++;
        }
        return new MergeCursor(cursorArr);
    }

    /* renamed from: a */
    protected MatrixCursor m8846a(SQLiteDatabase sQLiteDatabase, C2382d c2382d) {
        MatrixCursor matrixCursorMo8155a = null;
        Cursor cursorM8844d = m8844d(sQLiteDatabase, c2382d);
        InterfaceC2384f interfaceC2384fM8854d = c2382d.m8854d();
        if (interfaceC2384fM8854d != null) {
            matrixCursorMo8155a = interfaceC2384fM8854d.mo8155a(cursorM8844d, c2382d);
            if (cursorM8844d != null) {
                cursorM8844d.close();
            }
        }
        return matrixCursorMo8155a;
    }

    /* renamed from: d */
    private Cursor m8844d(SQLiteDatabase sQLiteDatabase, C2382d c2382d) {
        switch (C2381c.f8847a[c2382d.m8855e().ordinal()]) {
            case 1:
                return m8850c(sQLiteDatabase, c2382d);
            case 2:
                return m8849b(sQLiteDatabase, c2382d);
            default:
                return null;
        }
    }

    /* renamed from: b */
    protected Cursor m8849b(SQLiteDatabase sQLiteDatabase, C2382d c2382d) {
        StringBuilder sb = new StringBuilder();
        String[] strArrM8853c = c2382d.m8853c();
        String strM8856f = c2382d.m8856f();
        String strM8857g = c2382d.m8857g();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(");
        for (int i = 0; i < strArrM8853c.length; i++) {
            if ("AND".equals(strArrM8853c[i])) {
                sb2.append(" AND ");
            } else if ("OR".equals(strArrM8853c[i])) {
                sb2.append(" OR ");
            } else {
                sb2.append("message_content LIKE '%" + strArrM8853c[i] + "%'");
            }
        }
        if (strArrM8853c.length == 0) {
            sb2.append("message_content LIKE '%%'");
        }
        sb2.append(")");
        sb.append("SELECT distinct i.inbox_title inbox_title, message_content, message_time, message_inbox_no, i.inbox_chat_type inbox_chat_type, p.participants_buddy_no participants_buddy_no");
        sb.append(" FROM ");
        sb.append("message");
        sb.append(" LEFT OUTER JOIN ");
        sb.append("inbox i");
        sb.append(" ON message_inbox_no = i.inbox_no");
        sb.append(" LEFT OUTER JOIN ");
        sb.append("participant p");
        sb.append(" ON (message_inbox_no = p.participants_inbox_no");
        sb.append(" AND i.inbox_chat_type IN(0))");
        sb.append(" WHERE ");
        if (strM8856f != null && strM8857g != null) {
            sb.append("(message_time BETWEEN " + strM8856f + " AND " + strM8857g + ")");
            sb.append(" AND ");
        }
        sb.append(sb2.toString());
        if (c2382d.m8858h() != null) {
            sb.append(" LIMIT " + c2382d.m8858h());
        }
        if (C3250y.f11733a) {
            C3250y.m11456e("queryChat(), sql query is " + sb.toString(), f8841a);
        }
        return sQLiteDatabase.rawQuery(sb.toString(), null);
    }

    /* renamed from: c */
    protected Cursor m8850c(SQLiteDatabase sQLiteDatabase, C2382d c2382d) {
        StringBuilder sb = new StringBuilder();
        String[] strArrM8853c = c2382d.m8853c();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(");
        for (int i = 0; i < strArrM8853c.length; i++) {
            if ("AND".equals(strArrM8853c[i])) {
                sb2.append(" AND ");
            } else if ("OR".equals(strArrM8853c[i])) {
                sb2.append(" OR ");
            } else {
                sb2.append("buddy_name LIKE '%" + strArrM8853c[i] + "%'");
            }
        }
        if (strArrM8853c.length == 0) {
            sb2.append("buddy_name LIKE '%%'");
        }
        sb2.append(")");
        sb.append("SELECT distinct buddy_no, buddy_name, buddy_status_message as suggest_text_2");
        sb.append(" FROM ");
        sb.append("(SELECT buddy_no, buddy_name, buddy_status_message");
        sb.append(" FROM ");
        sb.append("buddy");
        sb.append(" WHERE ");
        sb.append("buddy_is_hide IN ('N')");
        sb.append(" UNION ALL ");
        sb.append("SELECT buddy_no, buddy_name, msgstatus");
        sb.append(" FROM ");
        sb.append("specialbuddy)");
        sb.append(" WHERE " + sb2.toString());
        if (c2382d.m8858h() != null) {
            sb.append(" LIMIT " + c2382d.m8858h());
        }
        if (C3250y.f11733a) {
            C3250y.m11456e("queryBuddy(), sql query is " + sb.toString(), f8841a);
        }
        return sQLiteDatabase.rawQuery(sb.toString(), null);
    }

    /* renamed from: a */
    public static Uri m8841a(String str, String str2, String str3, Bundle bundle) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(str);
        builder.authority(str2);
        builder.path(str3);
        if (bundle != null) {
            for (String str4 : bundle.keySet()) {
                Object obj = bundle.get(str4);
                if (obj instanceof String) {
                    builder.appendQueryParameter(str4, (String) obj);
                }
            }
        }
        return builder.build();
    }

    /* renamed from: a */
    public static Uri m8842a(String str, boolean z) {
        File file = z ? new File(CommonApplication.m11493l().getFilesDir(), C3205bt.m11195c(str)) : new File(CommonApplication.m11493l().getFilesDir(), C3205bt.m11197d(str));
        if (file.isFile() && file.exists()) {
            if (z) {
                return Uri.withAppendedPath(f8843c, str);
            }
            return Uri.withAppendedPath(f8842b, "buddy_no/" + str);
        }
        if (z) {
            return m8841a("android.resource", "com.sec.chaton", "drawable/contacts_default_group", null);
        }
        return m8841a("android.resource", "com.sec.chaton", "drawable/contacts_default_01", null);
    }

    /* renamed from: a */
    public static Intent m8839a(String str, EnumC1450r enumC1450r) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        Bundle bundle = new Bundle();
        bundle.putString("inboxNO", str);
        bundle.putString("chatType", String.valueOf(enumC1450r.m6342a()));
        intent.setData(m8841a("chaton", "com.sec.chaton", "search", bundle));
        return intent;
    }

    /* renamed from: a */
    public static String m8843a(int i) {
        if (CommonApplication.m11493l() == null) {
            return null;
        }
        switch (i) {
        }
        return CommonApplication.m11493l().getResources().getString(R.string.tab_buddies);
    }

    /* renamed from: a */
    public static MatrixCursor m8840a(MatrixCursor matrixCursor, int i, Uri uri, List<String> list, Intent intent) {
        if (list == null) {
            throw new IllegalArgumentException("texts should be not null");
        }
        matrixCursor.addRow(new Object[]{uri, list.get(0), list.get(1), list.get(2), Integer.valueOf(i), m8843a(i), intent.getAction(), intent.getData(), intent.getExtras()});
        return matrixCursor;
    }
}
