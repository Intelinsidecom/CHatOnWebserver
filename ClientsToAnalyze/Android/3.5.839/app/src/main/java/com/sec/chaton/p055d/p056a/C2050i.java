package com.sec.chaton.p055d.p056a;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.msgsend.EnumC2706n;
import com.sec.chaton.p057e.C2255ba;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p067j.C2426ao;
import com.sec.chaton.settings.p096a.C3460d;
import com.sec.chaton.util.C4809aa;
import com.sec.common.CommonApplication;
import com.sec.common.util.C5052r;

/* compiled from: AniconChatTask.java */
/* renamed from: com.sec.chaton.d.a.i */
/* loaded from: classes.dex */
public class C2050i extends C1998dq {

    /* renamed from: p */
    private String f7502p;

    public C2050i(Handler handler, String str, long j, EnumC2300t enumC2300t, String str2, String[] strArr, boolean z, String str3, String str4) {
        this(handler, str, j, enumC2300t, str2, strArr, z, str3, str4, EnumC2706n.f9699d);
    }

    public C2050i(Handler handler, String str, long j, EnumC2300t enumC2300t, String str2, String[] strArr, boolean z, String str3, String str4, EnumC2706n enumC2706n) {
        super(handler, str, j, "jpg", EnumC2214ab.ANICON, enumC2300t, str2, strArr, null, z, null, str4, enumC2706n);
        this.f7502p = str3;
        this.f7335j = m9184f();
    }

    /* renamed from: f */
    private String m9184f() {
        return m9183a(this.f7502p, this.f7336k);
    }

    @Override // com.sec.chaton.p055d.p056a.C1998dq, com.sec.chaton.p055d.p056a.C2055n, com.sec.chaton.p055d.p056a.AbstractC1981d, com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: b */
    protected C2426ao mo9093b() {
        Uri uriBuild = C2255ba.f8038a.buildUpon().appendPath(this.f7502p).build();
        this.f7333h = "anicon";
        this.f7334i = GlobalApplication.m10283b().getString(R.string.last_message_me_anicon);
        long jCurrentTimeMillis = System.currentTimeMillis();
        ContentValues contentValues = new ContentValues();
        contentValues.put("sent_time", Long.valueOf(jCurrentTimeMillis));
        CommonApplication.m18732r().getContentResolver().update(uriBuild, contentValues, null, null);
        return super.mo9093b();
    }

    /* renamed from: a */
    public static String m9183a(String str, String str2) {
        String string;
        String string2 = null;
        Cursor cursorQuery = GlobalApplication.m18732r().getContentResolver().query(C2255ba.f8038a.buildUpon().appendPath(str).build(), null, null, null, null);
        if (cursorQuery.moveToNext()) {
            string = cursorQuery.getString(cursorQuery.getColumnIndex("cd_proxy_url"));
            string2 = cursorQuery.getString(cursorQuery.getColumnIndex("delegate_url"));
        } else {
            string = null;
        }
        cursorQuery.close();
        return !TextUtils.isEmpty(str2) ? C5052r.m19199a("mixed", "\n", "anicon", "\n", C3460d.m13765a(string, str), "\n", string2, "\n", C4809aa.m18104a().m18121a("uid", ""), "\n", "\n", str2) : C5052r.m19199a("anicon", "\n", "jpg", "\n", C3460d.m13765a(string, str), "\n", string2, "\n", C4809aa.m18104a().m18121a("uid", ""), "\n");
    }

    @Override // com.sec.chaton.p055d.p056a.C1998dq, com.sec.chaton.p055d.p056a.C2055n, com.sec.chaton.p055d.p056a.AbstractC1981d, com.sec.chaton.p055d.p056a.AbstractC1927b
    /* renamed from: a */
    protected void mo9092a(int i, Object obj, Object obj2) throws Throwable {
        C3460d.f12913a.clear();
        C3460d.f12913a.put(this.f7502p, true);
        super.mo9092a(i, obj, obj2);
    }
}
