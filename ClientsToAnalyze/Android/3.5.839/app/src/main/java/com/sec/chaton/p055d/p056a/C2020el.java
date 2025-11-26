package com.sec.chaton.p055d.p056a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.text.TextUtils;
import com.sec.chaton.chat.C1736gi;
import com.sec.chaton.p057e.C2299s;
import com.sec.chaton.p057e.EnumC2214ab;
import java.util.ArrayList;

/* compiled from: SerialChatTask.java */
/* renamed from: com.sec.chaton.d.a.el */
/* loaded from: classes.dex */
class C2020el {

    /* renamed from: a */
    ArrayList<ContentProviderOperation> f7415a = new ArrayList<>();

    /* renamed from: b */
    ContentValues f7416b = new ContentValues();

    /* renamed from: c */
    String f7417c;

    /* renamed from: d */
    final /* synthetic */ C2019ek f7418d;

    C2020el(C2019ek c2019ek) {
        this.f7418d = c2019ek;
    }

    /* renamed from: a */
    void m9160a(ContentProviderOperation contentProviderOperation) {
        this.f7415a.add(contentProviderOperation);
    }

    /* renamed from: a */
    ArrayList<ContentProviderOperation> m9159a() {
        if (this.f7415a == null || this.f7415a.size() <= 0 || TextUtils.isEmpty(this.f7418d.f7411p)) {
            return null;
        }
        this.f7415a.add(ContentProviderOperation.newUpdate(C2299s.f8209a).withValues(this.f7416b).withSelection("inbox_no=?", new String[]{this.f7418d.f7411p}).build());
        return this.f7415a;
    }

    /* renamed from: b */
    void m9162b() {
        this.f7415a.clear();
    }

    /* renamed from: a */
    public void m9161a(ContentResolver contentResolver, String str, String str2, String str3, long j, String str4, String str5, Integer num, Long l, int i, EnumC2214ab enumC2214ab) {
        String str6 = String.format("%d;%d;%s;%s", 1, Integer.valueOf(enumC2214ab.m10076a()), C1736gi.m8632a(str3), "");
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_last_msg_sender", str);
        contentValues.put("inbox_last_message", str6);
        contentValues.put("inbox_last_time", Long.valueOf(j));
        contentValues.put("inbox_session_id", str4);
        contentValues.put("inbox_last_msg_no", l);
        if (!TextUtils.isEmpty(str5) && num != null && num.intValue() > 0) {
            contentValues.put("inbox_server_ip", str5);
            contentValues.put("inbox_server_port", num);
        }
        this.f7416b = contentValues;
        this.f7417c = str2;
    }
}
