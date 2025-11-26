package com.sec.chaton.multimedia.audio;

import android.database.Cursor;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p037j.p040c.C1555a;
import com.sec.chaton.util.C3159aa;

/* compiled from: MediaPlayerManager.java */
/* renamed from: com.sec.chaton.multimedia.audio.c */
/* loaded from: classes.dex */
class RunnableC1771c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Cursor f6540a;

    /* renamed from: b */
    final /* synthetic */ int f6541b;

    /* renamed from: c */
    final /* synthetic */ Handler f6542c;

    /* renamed from: d */
    final /* synthetic */ EnumC1450r f6543d;

    /* renamed from: e */
    final /* synthetic */ C1770b f6544e;

    RunnableC1771c(C1770b c1770b, Cursor cursor, int i, Handler handler, EnumC1450r enumC1450r) {
        this.f6544e = c1770b;
        this.f6540a = cursor;
        this.f6541b = i;
        this.f6542c = handler;
        this.f6543d = enumC1450r;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f6540a != null && !this.f6540a.isClosed()) {
            this.f6540a.moveToPosition(this.f6541b);
            while (!this.f6540a.isClosed() && this.f6540a.moveToNext() && EnumC1455w.m6358a(this.f6540a.getInt(this.f6540a.getColumnIndex("message_content_type"))) == EnumC1455w.AUDIO) {
                long j = this.f6540a.getLong(this.f6540a.getColumnIndex("message_sever_id"));
                String string = this.f6540a.getString(this.f6540a.getColumnIndex("message_download_uri"));
                String string2 = this.f6540a.getString(this.f6540a.getColumnIndex("message_sender"));
                String string3 = this.f6540a.getString(this.f6540a.getColumnIndex("message_content"));
                String string4 = this.f6540a.getString(this.f6540a.getColumnIndex("message_inbox_no"));
                boolean z = false;
                if (C3159aa.m10962a().m10979a("chaton_id", "").equals(string2)) {
                    z = true;
                }
                this.f6544e.m7296a((View) this.f6544e.f6538e.get(Long.valueOf(j)), string, j, z);
                if (TextUtils.isEmpty(string) && !C1555a.m6596a().m6598a(j)) {
                    C1555a.m6596a().m6597a(null, null, this.f6542c, 0, string3, false, string4, j, EnumC1455w.AUDIO, this.f6543d, string2);
                }
            }
        }
    }
}
