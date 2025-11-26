package com.sec.chaton.multimedia.geotag;

/* compiled from: GeotagActivity.java */
/* renamed from: com.sec.chaton.multimedia.geotag.h */
/* loaded from: classes.dex */
class RunnableC1843h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ GeotagActivity f6867a;

    RunnableC1843h(GeotagActivity geotagActivity) {
        this.f6867a = geotagActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.f6867a.f6858z && this.f6867a.f6837e.isShowing()) {
            this.f6867a.f6837e.hide();
            if (this.f6867a.f6850r && !this.f6867a.f6857y) {
                this.f6867a.f6834a.sendMessage(this.f6867a.f6834a.obtainMessage());
            }
        }
    }
}
