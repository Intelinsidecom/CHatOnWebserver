package com.sec.chaton.multimedia.audio;

import android.os.Handler;
import android.os.Message;

/* compiled from: RecordAudio.java */
/* renamed from: com.sec.chaton.multimedia.audio.t */
/* loaded from: classes.dex */
class HandlerC0890t extends Handler {

    /* renamed from: a */
    final /* synthetic */ RecordAudio f3285a;

    HandlerC0890t(RecordAudio recordAudio) {
        this.f3285a = recordAudio;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (!this.f3285a.f3248r) {
            this.f3285a.f3249s.setEnabled(false);
            return;
        }
        if (this.f3285a.f3245o) {
            if (this.f3285a.f3251u != null) {
                this.f3285a.f3249s.setProgress(this.f3285a.f3251u.getCurrentPosition());
            }
        } else {
            this.f3285a.f3249s.setProgress(this.f3285a.f3225D);
        }
        this.f3285a.f3235e.sendEmptyMessageDelayed(0, 100L);
    }
}
