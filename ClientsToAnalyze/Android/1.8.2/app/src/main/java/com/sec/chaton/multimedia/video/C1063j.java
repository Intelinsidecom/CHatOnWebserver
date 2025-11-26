package com.sec.chaton.multimedia.video;

/* compiled from: VideoRecordActivity.java */
/* renamed from: com.sec.chaton.multimedia.video.j */
/* loaded from: classes.dex */
class C1063j extends Thread {

    /* renamed from: a */
    final /* synthetic */ VideoRecordActivity f3950a;

    C1063j(VideoRecordActivity videoRecordActivity) {
        this.f3950a = videoRecordActivity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws InterruptedException {
        this.f3950a.f3940u = true;
        while (this.f3950a.f3940u && this.f3950a.f3922c != null) {
            if (this.f3950a.f3922c.m4087a() == EnumC1065l.RECORDING && this.f3950a.f3935p != null) {
                this.f3950a.f3921b.sendEmptyMessage(0);
            }
            try {
                Thread.sleep(1000L);
            } catch (Exception e) {
            }
        }
    }
}
