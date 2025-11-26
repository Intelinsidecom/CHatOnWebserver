package com.sec.chaton.multimedia.geotag;

/* compiled from: GeotagActivity.java */
/* renamed from: com.sec.chaton.multimedia.geotag.i */
/* loaded from: classes.dex */
class RunnableC0979i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ GeotagActivity f3598a;

    RunnableC0979i(GeotagActivity geotagActivity) {
        this.f3598a = geotagActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3598a.f3571i != null && this.f3598a.f3571i.isShowing()) {
            this.f3598a.f3571i.dismiss();
            this.f3598a.f3568f.sendMessage(this.f3598a.f3568f.obtainMessage());
        }
    }
}
