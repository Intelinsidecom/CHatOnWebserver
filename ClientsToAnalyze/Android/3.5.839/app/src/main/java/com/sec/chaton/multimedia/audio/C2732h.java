package com.sec.chaton.multimedia.audio;

import com.sec.chaton.util.C4904y;
import java.util.TimerTask;

/* compiled from: RecordVoiceTask.java */
/* renamed from: com.sec.chaton.multimedia.audio.h */
/* loaded from: classes.dex */
class C2732h extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ AsyncTaskC2731g f9814a;

    C2732h(AsyncTaskC2731g asyncTaskC2731g) {
        this.f9814a = asyncTaskC2731g;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        AsyncTaskC2731g.m11468a(this.f9814a, 10);
        if (C4904y.f17872b) {
            C4904y.m18639b("milliseconds : " + this.f9814a.f9801h, AsyncTaskC2731g.f9794a);
        }
        this.f9814a.publishProgress(Integer.valueOf(this.f9814a.f9801h));
    }
}
