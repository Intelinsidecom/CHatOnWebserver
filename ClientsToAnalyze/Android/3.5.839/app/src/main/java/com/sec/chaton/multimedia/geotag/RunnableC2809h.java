package com.sec.chaton.multimedia.geotag;

/* compiled from: GeotagActivity.java */
/* renamed from: com.sec.chaton.multimedia.geotag.h */
/* loaded from: classes.dex */
class RunnableC2809h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ GeotagActivity f10161a;

    RunnableC2809h(GeotagActivity geotagActivity) {
        this.f10161a = geotagActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.f10161a.f10152z && this.f10161a.f10131e.isShowing()) {
            this.f10161a.f10131e.hide();
            if (this.f10161a.f10144r && !this.f10161a.f10151y) {
                this.f10161a.f10128a.sendMessage(this.f10161a.f10128a.obtainMessage());
            }
        }
    }
}
