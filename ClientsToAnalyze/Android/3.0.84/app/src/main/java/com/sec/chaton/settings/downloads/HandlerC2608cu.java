package com.sec.chaton.settings.downloads;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.multimedia.audio.AsyncTaskC1772d;
import com.sec.chaton.multimedia.audio.EnumC1774f;
import com.sec.chaton.util.C3250y;

/* compiled from: SoundDetail.java */
/* renamed from: com.sec.chaton.settings.downloads.cu */
/* loaded from: classes.dex */
class HandlerC2608cu extends Handler {

    /* renamed from: a */
    final /* synthetic */ SoundDetail f9833a;

    HandlerC2608cu(SoundDetail soundDetail) {
        this.f9833a = soundDetail;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        AsyncTaskC1772d asyncTaskC1772d = (AsyncTaskC1772d) message.obj;
        if (asyncTaskC1772d == null) {
            if (C3250y.f11734b) {
                C3250y.m11450b("download_sound, PlaySoundHandler(), task is null", SoundDetail.f9569c);
                return;
            }
            return;
        }
        EnumC1774f enumC1774fM7323a = EnumC1774f.m7323a(message.what);
        if (C3250y.f11734b) {
            C3250y.m11450b("sound event (what/task status/ task canceled) : " + enumC1774fM7323a + "/" + asyncTaskC1772d.getStatus() + "/" + asyncTaskC1772d.isCancelled() + "/" + asyncTaskC1772d.m7321b(), SoundDetail.f9569c);
        }
        C2620df.m9598a(this.f9833a.f9579k, enumC1774fM7323a);
        if (message.what == EnumC1774f.PLAY_STATUS_DOWNLOAD_FAILED.m7324a()) {
            this.f9833a.m9398a();
        }
        super.handleMessage(message);
    }
}
