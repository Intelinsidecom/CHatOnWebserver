package com.sec.chaton.multimedia.video;

import com.sec.chaton.multimedia.video.VideoRecordManager;

/* renamed from: com.sec.chaton.multimedia.video.g */
/* loaded from: classes.dex */
class C0333g extends Thread {

    /* renamed from: a */
    final /* synthetic */ VideoRecordActivity f2422a;

    C0333g(VideoRecordActivity videoRecordActivity) {
        this.f2422a = videoRecordActivity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws InterruptedException {
        while (this.f2422a.f2391c != null) {
            if (this.f2422a.f2391c.m2692a() == VideoRecordManager.State.RECORDING && this.f2422a.f2404p != null) {
                this.f2422a.f2390b.sendEmptyMessage(0);
            }
            try {
                Thread.sleep(1000L);
            } catch (Exception e) {
            }
        }
    }
}
