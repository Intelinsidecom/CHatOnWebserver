package com.sec.chaton.multimedia.audio;

import com.sec.chaton.util.C4904y;
import java.util.TimerTask;

/* compiled from: PlayVoiceTask.java */
/* renamed from: com.sec.chaton.multimedia.audio.e */
/* loaded from: classes.dex */
class C2729e extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ AsyncTaskC2728d f9792a;

    C2729e(AsyncTaskC2728d asyncTaskC2728d) {
        this.f9792a = asyncTaskC2728d;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        try {
            if (this.f9792a.f9786m != null && this.f9792a.f9788o) {
                this.f9792a.publishProgress(Integer.valueOf(this.f9792a.f9786m.getCurrentPosition()));
                C4904y.m18639b("CurrentPosition : " + this.f9792a.f9786m.getCurrentPosition(), AsyncTaskC2728d.f9774j);
            }
        } catch (Exception e) {
            C4904y.m18635a(e, AsyncTaskC2728d.f9774j);
        }
    }
}
