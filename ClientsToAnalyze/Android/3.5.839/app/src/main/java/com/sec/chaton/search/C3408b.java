package com.sec.chaton.search;

import android.content.Intent;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MergeCursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.spp.push.Config;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Search.java */
/* renamed from: com.sec.chaton.search.b */
/* loaded from: classes.dex */
public class C3408b {

    /* renamed from: a */
    public static final String f12370a = C3408b.class.getSimpleName();

    /* renamed from: b */
    protected static final Uri f12371b = Uri.parse("content://com.sec.chaton.provider/buddy");

    /* renamed from: c */
    protected static final Uri f12372c = Uri.parse("content://com.sec.chaton.provider/inbox");

    /* renamed from: d */
    public static final String[] f12373d = {"suggest_icon_1", "suggest_text_1", "suggest_text_2", "suggest_text_3", "suggest_target_type", "suggest_group", "suggest_intent_action", "suggest_intent_data", "suggest_extra_flags"};

    /* renamed from: e */
    private List<C3410d> f12374e = new ArrayList();

    /* renamed from: a */
    public void m13231a(C3410d c3410d) {
        this.f12374e.add(c3410d);
    }

    /* renamed from: a */
    public void m13230a() {
        this.f12374e.clear();
    }

    /* renamed from: a */
    public Cursor m13228a(SQLiteDatabase sQLiteDatabase) {
        Cursor[] cursorArr = new Cursor[this.f12374e.size()];
        Iterator<C3410d> it = this.f12374e.iterator();
        int i = 0;
        while (it.hasNext()) {
            cursorArr[i] = m13229a(sQLiteDatabase, it.next());
            i++;
        }
        return new MergeCursor(cursorArr);
    }

    /* renamed from: a */
    protected MatrixCursor m13229a(SQLiteDatabase sQLiteDatabase, C3410d c3410d) {
        MatrixCursor matrixCursorMo12498a = null;
        Cursor cursorM13227e = m13227e(sQLiteDatabase, c3410d);
        InterfaceC3412f interfaceC3412fM13238d = c3410d.m13238d();
        if (interfaceC3412fM13238d != null) {
            matrixCursorMo12498a = interfaceC3412fM13238d.mo12498a(cursorM13227e, c3410d);
            if (cursorM13227e != null) {
                cursorM13227e.close();
            }
        }
        return matrixCursorMo12498a;
    }

    /* renamed from: e */
    private Cursor m13227e(SQLiteDatabase sQLiteDatabase, C3410d c3410d) {
        switch (C3409c.f12375a[c3410d.m13239e().ordinal()]) {
            case 1:
                return m13234d(sQLiteDatabase, c3410d);
            case 2:
                return m13232b(sQLiteDatabase, c3410d);
            case 3:
                return m13233c(sQLiteDatabase, c3410d);
            default:
                return null;
        }
    }

    /* renamed from: b */
    protected Cursor m13232b(SQLiteDatabase sQLiteDatabase, C3410d c3410d) {
        StringBuilder sb = new StringBuilder();
        String[] strArrM13237c = c3410d.m13237c();
        String strM13240f = c3410d.m13240f();
        String strM13241g = c3410d.m13241g();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(");
        for (int i = 0; i < strArrM13237c.length; i++) {
            if ("AND".equals(strArrM13237c[i])) {
                sb2.append(" AND ");
            } else if ("OR".equals(strArrM13237c[i])) {
                sb2.append(" OR ");
            } else {
                sb2.append("message_content LIKE '%" + strArrM13237c[i] + "%'");
            }
        }
        if (strArrM13237c.length == 0) {
            sb2.append("message_content LIKE '%%'");
        }
        sb2.append(")");
        sb.append("SELECT distinct i.inbox_title inbox_title, message_content, message_time, message_inbox_no, message_sender, i.inbox_chat_type inbox_chat_type, p.participants_buddy_no participants_buddy_no");
        sb.append(" FROM ");
        sb.append("(SELECT * FROM message WHERE message_content_type IN(" + String.valueOf(EnumC2214ab.TEXT.m10076a()) + "))");
        sb.append(" LEFT OUTER JOIN ");
        sb.append("inbox i");
        sb.append(" ON message_inbox_no = i.inbox_no");
        sb.append(" LEFT OUTER JOIN ");
        sb.append("participant p");
        sb.append(" ON (message_inbox_no = p.participants_inbox_no");
        sb.append(" AND i.inbox_chat_type IN(0))");
        sb.append(" WHERE ");
        if (strM13240f != null && strM13241g != null) {
            sb.append("(message_time BETWEEN " + strM13240f + " AND " + strM13241g + ")");
            sb.append(" AND ");
        }
        sb.append(sb2.toString());
        if (c3410d.m13242h() != null) {
            sb.append(" LIMIT " + c3410d.m13242h());
        }
        if (C4904y.f17871a) {
            C4904y.m18646e("queryChat(), sql query is " + sb.toString(), f12370a);
        }
        return sQLiteDatabase.rawQuery(sb.toString(), null);
    }

    /* renamed from: c */
    protected Cursor m13233c(SQLiteDatabase sQLiteDatabase, C3410d c3410d) {
        StringBuilder sb = new StringBuilder();
        String[] strArrM13237c = c3410d.m13237c();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(");
        for (int i = 0; i < strArrM13237c.length; i++) {
            if ("AND".equals(strArrM13237c[i])) {
                sb2.append(" AND ");
            } else if ("OR".equals(strArrM13237c[i])) {
                sb2.append(" OR ");
            } else {
                sb2.append("inbox_title LIKE '%" + strArrM13237c[i] + "%'");
            }
        }
        if (strArrM13237c.length == 0) {
            sb2.append("inbox_title LIKE '%%'");
        }
        sb2.append(")");
        sb.append(" SELECT distinct inbox_title, inbox_no, inbox_last_msg_sender, inbox_last_message, inbox_last_time, inbox_room_type, inbox_chat_type, p.participants_buddy_no participants_buddy_no");
        sb.append(" FROM ");
        sb.append("inbox");
        sb.append(" LEFT OUTER JOIN ");
        sb.append("participant p");
        sb.append(" ON (inbox_no = p.participants_inbox_no");
        sb.append(" AND inbox_chat_type IN(" + String.valueOf(EnumC2300t.ONETOONE.m10210a()) + "))");
        sb.append(" WHERE " + sb2.toString());
        if (c3410d.m13242h() != null) {
            sb.append(" LIMIT " + c3410d.m13242h());
        }
        if (C4904y.f17871a) {
            C4904y.m18646e("queryChatTitle(), sql query is " + sb.toString(), f12370a);
        }
        return sQLiteDatabase.rawQuery(sb.toString(), null);
    }

    /* renamed from: d */
    protected Cursor m13234d(SQLiteDatabase sQLiteDatabase, C3410d c3410d) {
        StringBuilder sb = new StringBuilder();
        String[] strArrM13237c = c3410d.m13237c();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(");
        for (int i = 0; i < strArrM13237c.length; i++) {
            if ("AND".equals(strArrM13237c[i])) {
                sb2.append(" AND ");
            } else if ("OR".equals(strArrM13237c[i])) {
                sb2.append(" OR ");
            } else {
                sb2.append("buddy_name LIKE '%" + strArrM13237c[i] + "%'");
            }
        }
        if (strArrM13237c.length == 0) {
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
        if (c3410d.m13242h() != null) {
            sb.append(" LIMIT " + c3410d.m13242h());
        }
        if (C4904y.f17871a) {
            C4904y.m18646e("queryBuddy(), sql query is " + sb.toString(), f12370a);
        }
        return sQLiteDatabase.rawQuery(sb.toString(), null);
    }

    /* renamed from: a */
    public static Uri m13223a(String str, String str2, String str3, Bundle bundle) {
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
    public static Uri m13224a(String str, boolean z) {
        if (C2496n.m10767a(z ? C2496n.m10771b(GlobalApplication.m18732r(), str) : C2496n.m10757a(GlobalApplication.m18732r(), str))) {
            if (z) {
                return Uri.withAppendedPath(f12372c, str);
            }
            return Uri.withAppendedPath(f12371b, "buddy_no/" + str);
        }
        if (z) {
            return m13223a("android.resource", Config.CHATON_PACKAGE_NAME, "drawable/profile_photo_group_default", null);
        }
        return m13223a("android.resource", Config.CHATON_PACKAGE_NAME, "drawable/profile_photo_buddy_default", null);
    }

    /* renamed from: a */
    public static Intent m13220a(String str, EnumC2300t enumC2300t) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        Bundle bundle = new Bundle();
        bundle.putString("inboxNO", str);
        bundle.putString("chatType", String.valueOf(enumC2300t.m10210a()));
        intent.setData(m13223a("chaton", Config.CHATON_PACKAGE_NAME, "search", bundle));
        return intent;
    }

    /* renamed from: a */
    public static Intent m13221a(String str, EnumC2300t enumC2300t, int i) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        Bundle bundle = new Bundle();
        bundle.putString("inboxNO", str);
        bundle.putString("chatType", String.valueOf(enumC2300t.m10210a()));
        intent.setData(m13223a("chaton", Config.CHATON_PACKAGE_NAME, "search", bundle));
        intent.putExtra("issent", Integer.toString(i));
        return intent;
    }

    /* renamed from: a */
    public static String m13225a(int i) {
        if (CommonApplication.m18732r() == null) {
            return null;
        }
        switch (i) {
        }
        return CommonApplication.m18732r().getResources().getString(R.string.chaton_contacts_tab);
    }

    /* renamed from: a */
    public static MatrixCursor m13222a(MatrixCursor matrixCursor, int i, Uri uri, List<String> list, Intent intent) {
        if (list == null) {
            throw new IllegalArgumentException("texts should be not null");
        }
        matrixCursor.addRow(new Object[]{uri, list.get(0), list.get(1), list.get(2), Integer.valueOf(i), m13225a(i), intent.getAction(), intent.getData(), intent.getStringExtra("issent")});
        return matrixCursor;
    }

    /* renamed from: a */
    public static boolean m13226a(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        for (char c2 : str.toCharArray()) {
            if ((c2 < '0' || c2 > '9') && c2 != '+') {
                return false;
            }
        }
        return true;
    }
}
