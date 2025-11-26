package com.sec.chaton.multimedia.geotag;

import android.location.Criteria;
import com.sec.chaton.util.C1786r;

/* compiled from: GeotagActivity.java */
/* renamed from: com.sec.chaton.multimedia.geotag.j */
/* loaded from: classes.dex */
class RunnableC0980j implements Runnable {

    /* renamed from: a */
    final /* synthetic */ GeotagActivity f3599a;

    RunnableC0980j(GeotagActivity geotagActivity) {
        this.f3599a = geotagActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3599a.f3582t == null || this.f3599a.f3583u == null) {
            Criteria criteria = new Criteria();
            criteria.setAccuracy(0);
            this.f3599a.f3579q = this.f3599a.f3578p.getBestProvider(criteria, true);
            C1786r.m6061b("[Change provider] : " + this.f3599a.f3579q, GeotagActivity.f3561a);
            this.f3599a.m3851a();
        }
    }
}
