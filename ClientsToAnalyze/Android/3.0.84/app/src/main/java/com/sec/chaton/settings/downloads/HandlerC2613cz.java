package com.sec.chaton.settings.downloads;

import android.os.Handler;
import android.os.Message;
import android.widget.ListAdapter;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.widget.C3641ai;

/* compiled from: SoundDownloads.java */
/* renamed from: com.sec.chaton.settings.downloads.cz */
/* loaded from: classes.dex */
class HandlerC2613cz extends Handler {

    /* renamed from: a */
    final /* synthetic */ SoundDownloads f9838a;

    HandlerC2613cz(SoundDownloads soundDownloads) {
        this.f9838a = soundDownloads;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f9838a.f9593b != null && message.what == 1000) {
            C0267d c0267d = (C0267d) message.obj;
            this.f9838a.f9597f = null;
            this.f9838a.m9411f();
            if (c0267d.m1351b() != EnumC1587o.SUCCESS) {
                if (this.f9838a.f9593b != null) {
                    C3641ai.m13210a(this.f9838a.f9593b, C2555av.m9488a(R.string.dev_network_error), 1).show();
                    this.f9838a.f9593b.finish();
                    return;
                }
                return;
            }
            this.f9838a.getLoaderManager().initLoader(0, null, this.f9838a);
            this.f9838a.f9594c.setAdapter((ListAdapter) this.f9838a.f9598g);
            this.f9838a.m9416a(true);
        }
    }
}
