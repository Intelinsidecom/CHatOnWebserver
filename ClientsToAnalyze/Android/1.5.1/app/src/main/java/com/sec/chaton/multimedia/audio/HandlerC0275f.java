package com.sec.chaton.multimedia.audio;

import android.os.Handler;
import android.os.Message;

/* renamed from: com.sec.chaton.multimedia.audio.f */
/* loaded from: classes.dex */
class HandlerC0275f extends Handler {

    /* renamed from: a */
    final /* synthetic */ RecordAudio f2082a;

    HandlerC0275f(RecordAudio recordAudio) {
        this.f2082a = recordAudio;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (!this.f2082a.f2068r) {
            this.f2082a.f2069s.setEnabled(false);
            return;
        }
        this.f2082a.f2069s.incrementProgressBy(1);
        this.f2082a.setProgress(this.f2082a.f2069s.getProgress() * 100);
        this.f2082a.f2054d.sendEmptyMessageDelayed(0, 100L);
    }
}
