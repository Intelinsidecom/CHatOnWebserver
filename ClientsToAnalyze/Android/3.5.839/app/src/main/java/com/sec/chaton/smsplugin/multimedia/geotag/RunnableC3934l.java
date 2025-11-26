package com.sec.chaton.smsplugin.multimedia.geotag;

/* compiled from: MmsGeotagActivity.java */
/* renamed from: com.sec.chaton.smsplugin.multimedia.geotag.l */
/* loaded from: classes.dex */
class RunnableC3934l implements Runnable {

    /* renamed from: a */
    final /* synthetic */ MmsGeotagActivity f14162a;

    RunnableC3934l(MmsGeotagActivity mmsGeotagActivity) {
        this.f14162a = mmsGeotagActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.f14162a.f14146x && this.f14162a.f14120F.isShowing()) {
            this.f14162a.f14120F.hide();
            if (this.f14162a.f14139q && !this.f14162a.f14145w) {
                this.f14162a.f14124a.sendMessage(this.f14162a.f14124a.obtainMessage());
            }
        }
    }
}
