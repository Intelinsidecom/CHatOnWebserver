package com.sec.chaton.multimedia.emoticon.p030a.p031a;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.emoticon.anicon.C0921d;
import com.sec.chaton.multimedia.emoticon.p032b.C0950e;
import com.sec.chaton.p015d.p016a.C0566bg;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.p017e.EnumC0699n;
import com.sec.chaton.p022h.C0770ab;
import com.sec.chaton.util.C1789u;
import com.sec.common.p056b.p060d.C1828c;

/* compiled from: AniconChatTask.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.a.a.a */
/* loaded from: classes.dex */
public class C0911a extends C0566bg {

    /* renamed from: k */
    private String f3378k;

    /* renamed from: d */
    public String m3673d() {
        return this.f2265j;
    }

    public C0911a(Handler handler, String str, long j, EnumC0695j enumC0695j, String str2, String[] strArr, boolean z, String str3) {
        super(handler, str, j, "jpg", EnumC0699n.ANICON, enumC0695j, str2, strArr, null, z, str3, null);
        this.f3378k = str3;
        this.f2265j = m3672e();
    }

    /* renamed from: e */
    private String m3672e() {
        String string;
        String string2 = null;
        Cursor cursorQuery = GlobalApplication.m3260b().getContentResolver().query(C0950e.f3514a.buildUpon().appendPath(this.f3378k).build(), null, null, null, null);
        if (cursorQuery.moveToNext()) {
            string = cursorQuery.getString(cursorQuery.getColumnIndex("cd_proxy_url"));
            string2 = cursorQuery.getString(cursorQuery.getColumnIndex("delegate_url"));
        } else {
            string = null;
        }
        cursorQuery.close();
        return C1828c.m6207a("image", "\n", "jpg", "\n", C0921d.m3787a(string, this.f3378k), "\n", string2, "\n", C1789u.m6075a().getString("uid", ""));
    }

    @Override // com.sec.chaton.p015d.p016a.C0566bg, com.sec.chaton.p015d.p016a.AbstractC0559b
    /* renamed from: c */
    protected C0770ab mo2748c() {
        Log.d("lsw", "log5");
        Uri uriBuild = C0950e.f3514a.buildUpon().appendPath(this.f3378k).build();
        Log.d("lsw", "log6");
        this.f2263h = "image";
        this.f2264i = GlobalApplication.m3262c().getString(R.string.last_message_me_anicon);
        long jCurrentTimeMillis = System.currentTimeMillis();
        ContentValues contentValues = new ContentValues();
        contentValues.put("sent_time", Long.valueOf(jCurrentTimeMillis));
        GlobalApplication.m3260b().getContentResolver().update(uriBuild, contentValues, null, null);
        return super.mo2748c();
    }
}
