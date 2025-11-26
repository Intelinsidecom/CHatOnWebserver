package com.sec.chaton.multimedia.geotag;

/* renamed from: com.sec.chaton.multimedia.geotag.b */
/* loaded from: classes.dex */
class RunnableC0298b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ GeotagActivity f2167a;

    RunnableC0298b(GeotagActivity geotagActivity) {
        this.f2167a = geotagActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f2167a.f2144e.isShowing()) {
            this.f2167a.f2144e.dismiss();
            this.f2167a.f2141b.sendMessage(this.f2167a.f2141b.obtainMessage());
        }
    }
}
