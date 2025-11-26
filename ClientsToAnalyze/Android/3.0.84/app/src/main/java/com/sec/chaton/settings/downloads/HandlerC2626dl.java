package com.sec.chaton.settings.downloads;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.multimedia.audio.AsyncTaskC1772d;
import com.sec.chaton.multimedia.audio.EnumC1774f;
import com.sec.chaton.util.C3250y;

/* compiled from: SoundListAdapter.java */
/* renamed from: com.sec.chaton.settings.downloads.dl */
/* loaded from: classes.dex */
class HandlerC2626dl extends Handler {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC2625dk f9863a;

    HandlerC2626dl(ViewOnClickListenerC2625dk viewOnClickListenerC2625dk) {
        this.f9863a = viewOnClickListenerC2625dk;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        AsyncTaskC1772d asyncTaskC1772d = (AsyncTaskC1772d) message.obj;
        if (asyncTaskC1772d == null) {
            if (C3250y.f11734b) {
                C3250y.m11450b("download_sound, PlaySoundHandler(), task is null", ViewOnClickListenerC2625dk.f9855d);
                return;
            }
            return;
        }
        EnumC1774f enumC1774fM7323a = EnumC1774f.m7323a(message.what);
        if (C3250y.f11734b) {
            C3250y.m11450b("sound event (what/task status/ task canceled) : " + enumC1774fM7323a + "/" + asyncTaskC1772d.getStatus() + "/" + asyncTaskC1772d.isCancelled() + "/" + asyncTaskC1772d.m7321b(), ViewOnClickListenerC2625dk.f9855d);
        }
        this.f9863a.m9625a(asyncTaskC1772d.m7321b(), enumC1774fM7323a);
        if (enumC1774fM7323a == EnumC1774f.PLAY_STATUS_DOWNLOAD_FAILED) {
            this.f9863a.m9631f();
        }
        super.handleMessage(message);
    }
}
