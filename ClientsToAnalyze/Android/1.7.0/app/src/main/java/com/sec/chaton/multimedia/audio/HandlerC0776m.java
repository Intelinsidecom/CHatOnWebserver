package com.sec.chaton.multimedia.audio;

import android.os.Handler;
import android.os.Message;

/* compiled from: RecordAudio.java */
/* renamed from: com.sec.chaton.multimedia.audio.m */
/* loaded from: classes.dex */
class HandlerC0776m extends Handler {

    /* renamed from: a */
    final /* synthetic */ RecordAudio f2671a;

    HandlerC0776m(RecordAudio recordAudio) {
        this.f2671a = recordAudio;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f2671a.f2645r) {
            if (this.f2671a.f2642o) {
                if (this.f2671a.f2648u != null) {
                    this.f2671a.f2646s.setProgress(this.f2671a.f2648u.getCurrentPosition());
                }
            } else {
                this.f2671a.f2646s.setProgress(this.f2671a.f2622D);
            }
            this.f2671a.f2632e.sendEmptyMessageDelayed(0, 100L);
        }
    }
}
