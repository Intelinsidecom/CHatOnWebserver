package com.sec.chaton.p037j.p040c;

import android.view.View;
import com.sec.chaton.multimedia.audio.C1770b;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;

/* compiled from: FileDownloadTask2.java */
/* renamed from: com.sec.chaton.j.c.e */
/* loaded from: classes.dex */
class RunnableC1559e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f5771a;

    /* renamed from: b */
    final /* synthetic */ AsyncTaskC1557c f5772b;

    RunnableC1559e(AsyncTaskC1557c asyncTaskC1557c, String str) {
        this.f5772b = asyncTaskC1557c;
        this.f5771a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (C1555a.m6596a().m6603d(this.f5772b.f5750f)) {
            C3250y.m11450b("Successfully removed from hashmap after down-load", getClass().getName());
        }
        if (this.f5772b.f5759o == EnumC1455w.AUDIO) {
            boolean z = false;
            if (C3159aa.m10962a().m10979a("chaton_id", "").equals(this.f5772b.f5752h)) {
                z = true;
            }
            C1770b.m7289a().m7296a((View) null, this.f5771a, this.f5772b.f5750f, z);
        }
        if (this.f5772b.f5769z != null) {
            this.f5772b.f5769z.hide();
        }
    }
}
