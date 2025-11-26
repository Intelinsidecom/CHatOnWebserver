package com.sec.chaton.p025d.p026a;

import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.msgsend.EnumC1751k;
import com.sec.chaton.p027e.C1396an;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p037j.C1548ag;
import com.sec.chaton.settings.downloads.C2646u;
import com.sec.chaton.util.C3159aa;
import com.sec.common.CommonApplication;
import com.sec.common.util.C3364o;
import twitter4j.Query;

/* compiled from: AniconChatTask.java */
/* renamed from: com.sec.chaton.d.a.n */
/* loaded from: classes.dex */
public class C1275n extends C1228db {

    /* renamed from: o */
    private String f4880o;

    public C1275n(Handler handler, String str, long j, EnumC1450r enumC1450r, String str2, String[] strArr, boolean z, String str3, String str4) {
        this(handler, str, j, enumC1450r, str2, strArr, z, str3, str4, EnumC1751k.f6455d);
    }

    public C1275n(Handler handler, String str, long j, EnumC1450r enumC1450r, String str2, String[] strArr, boolean z, String str3, String str4, EnumC1751k enumC1751k) {
        super(handler, str, j, "jpg", EnumC1455w.ANICON, enumC1450r, str2, strArr, null, z, null, str4, enumC1751k);
        this.f4880o = str3;
        this.f4751j = m5581d();
    }

    /* renamed from: d */
    private String m5581d() {
        return m5580a(this.f4880o, this.f4752k);
    }

    @Override // com.sec.chaton.p025d.p026a.C1228db, com.sec.chaton.p025d.p026a.C1280s, com.sec.chaton.p025d.p026a.AbstractC1253e, com.sec.chaton.p025d.p026a.AbstractC1199c
    /* renamed from: b */
    protected C1548ag mo5504b() {
        Uri uriBuild = C1396an.f5203a.buildUpon().appendPath(this.f4880o).build();
        this.f4749h = "anicon";
        this.f4750i = GlobalApplication.m6451b().getString(R.string.last_message_me_anicon);
        long jCurrentTimeMillis = System.currentTimeMillis();
        ContentValues contentValues = new ContentValues();
        contentValues.put("sent_time", Long.valueOf(jCurrentTimeMillis));
        CommonApplication.m11493l().getContentResolver().update(uriBuild, contentValues, null, null);
        return super.mo5504b();
    }

    /* renamed from: a */
    public static String m5580a(String str, String str2) {
        String string;
        String string2 = null;
        Cursor cursorQuery = GlobalApplication.m11493l().getContentResolver().query(C1396an.f5203a.buildUpon().appendPath(str).build(), null, null, null, null);
        if (cursorQuery.moveToNext()) {
            string = cursorQuery.getString(cursorQuery.getColumnIndex("cd_proxy_url"));
            string2 = cursorQuery.getString(cursorQuery.getColumnIndex("delegate_url"));
        } else {
            string = null;
        }
        cursorQuery.close();
        return !TextUtils.isEmpty(str2) ? C3364o.m11849a(Query.MIXED, "\n", "anicon", "\n", C2646u.m9647a(string, str), "\n", string2, "\n", C3159aa.m10962a().m10979a("uid", ""), "\n", "\n", str2) : C3364o.m11849a("anicon", "\n", "jpg", "\n", C2646u.m9647a(string, str), "\n", string2, "\n", C3159aa.m10962a().m10979a("uid", ""), "\n");
    }

    @Override // com.sec.chaton.p025d.p026a.C1228db, com.sec.chaton.p025d.p026a.C1280s, com.sec.chaton.p025d.p026a.AbstractC1253e, com.sec.chaton.p025d.p026a.AbstractC1199c
    /* renamed from: a */
    protected void mo5502a(int i, Object obj, Object obj2) throws Resources.NotFoundException, RemoteException, OperationApplicationException {
        C2646u.f9891a.clear();
        C2646u.f9891a.put(this.f4880o, true);
        super.mo5502a(i, obj, obj2);
    }
}
