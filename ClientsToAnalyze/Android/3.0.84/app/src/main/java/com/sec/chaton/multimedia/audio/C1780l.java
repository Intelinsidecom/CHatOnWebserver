package com.sec.chaton.multimedia.audio;

import com.sec.chaton.util.C3250y;
import java.util.TimerTask;

/* compiled from: RecordVoiceTask.java */
/* renamed from: com.sec.chaton.multimedia.audio.l */
/* loaded from: classes.dex */
class C1780l extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ AsyncTaskC1779k f6606a;

    C1780l(AsyncTaskC1779k asyncTaskC1779k) {
        this.f6606a = asyncTaskC1779k;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        AsyncTaskC1779k.m7344a(this.f6606a, 10);
        if (C3250y.f11734b) {
            C3250y.m11450b("milliseconds : " + this.f6606a.f6594h, AsyncTaskC1779k.f6587a);
        }
        this.f6606a.publishProgress(Integer.valueOf(this.f6606a.f6594h));
    }
}
