package com.sec.chaton.multimedia.audio;

import android.database.Cursor;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p067j.p070c.C2434a;
import com.sec.chaton.util.C4809aa;

/* compiled from: MediaPlayerManager.java */
/* renamed from: com.sec.chaton.multimedia.audio.c */
/* loaded from: classes.dex */
class RunnableC2727c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Cursor f9769a;

    /* renamed from: b */
    final /* synthetic */ int f9770b;

    /* renamed from: c */
    final /* synthetic */ Handler f9771c;

    /* renamed from: d */
    final /* synthetic */ EnumC2300t f9772d;

    /* renamed from: e */
    final /* synthetic */ C2726b f9773e;

    RunnableC2727c(C2726b c2726b, Cursor cursor, int i, Handler handler, EnumC2300t enumC2300t) {
        this.f9773e = c2726b;
        this.f9769a = cursor;
        this.f9770b = i;
        this.f9771c = handler;
        this.f9772d = enumC2300t;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f9769a != null && !this.f9769a.isClosed()) {
            this.f9769a.moveToPosition(this.f9770b);
            while (!this.f9769a.isClosed() && this.f9769a.moveToNext() && EnumC2214ab.m10070a(this.f9769a.getInt(this.f9769a.getColumnIndex("message_content_type"))) == EnumC2214ab.AUDIO) {
                long j = this.f9769a.getLong(this.f9769a.getColumnIndex("message_sever_id"));
                String string = this.f9769a.getString(this.f9769a.getColumnIndex("message_download_uri"));
                String string2 = this.f9769a.getString(this.f9769a.getColumnIndex("message_sender"));
                String string3 = this.f9769a.getString(this.f9769a.getColumnIndex("message_content"));
                String string4 = this.f9769a.getString(this.f9769a.getColumnIndex("message_inbox_no"));
                boolean z = false;
                if (C4809aa.m18104a().m18121a("chaton_id", "").equals(string2)) {
                    z = true;
                }
                this.f9773e.m11436a((View) this.f9773e.f9767e.get(Long.valueOf(j)), string, j, z);
                if (TextUtils.isEmpty(string) && !C2434a.m10540a().m10542a(j)) {
                    C2434a.m10540a().m10541a(null, null, this.f9771c, 0, string3, false, string4, j, EnumC2214ab.AUDIO, this.f9772d, string2);
                }
            }
        }
    }
}
