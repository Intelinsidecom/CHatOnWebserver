package com.sec.chaton.multimedia.geotag;

/* compiled from: GeotagActivity.java */
/* renamed from: com.sec.chaton.multimedia.geotag.h */
/* loaded from: classes.dex */
class RunnableC0804h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ GeotagActivity f2736a;

    RunnableC0804h(GeotagActivity geotagActivity) {
        this.f2736a = geotagActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f2736a.f2710e.isShowing()) {
            this.f2736a.f2710e.dismiss();
            this.f2736a.f2707b.sendMessage(this.f2736a.f2707b.obtainMessage());
        }
    }
}
