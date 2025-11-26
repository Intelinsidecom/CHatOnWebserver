package com.sec.chaton.p015d.p016a;

import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p017e.p018a.C0665i;
import com.sec.chaton.p022h.p025c.C0777a;
import com.sec.chaton.util.C1786r;

/* compiled from: FileDownloadTask2.java */
/* renamed from: com.sec.chaton.d.a.y */
/* loaded from: classes.dex */
class RunnableC0609y implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AsyncTaskC0608x f2420a;

    RunnableC0609y(AsyncTaskC0608x asyncTaskC0608x) {
        this.f2420a = asyncTaskC0608x;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f2420a.f2404j != null) {
            this.f2420a.f2404j.setVisibility(4);
        }
        if (this.f2420a.f2405k != null) {
            this.f2420a.f2405k.setVisibility(4);
        }
        if (this.f2420a.f2406l != null) {
            this.f2420a.f2406l.setVisibility(4);
        }
        C0665i.m3068b(GlobalApplication.m3260b().getContentResolver(), Long.valueOf(this.f2420a.f2400f));
        if (C0777a.m3326a().m3332d(this.f2420a.f2400f)) {
            C1786r.m6061b("Successfully removed from hashmap", getClass().getName());
        }
        Toast.makeText(GlobalApplication.m3260b(), R.string.media_download_fail, 0).show();
    }
}
