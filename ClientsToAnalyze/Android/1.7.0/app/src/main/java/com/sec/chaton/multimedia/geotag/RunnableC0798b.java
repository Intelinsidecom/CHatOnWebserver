package com.sec.chaton.multimedia.geotag;

import android.location.Criteria;
import com.sec.chaton.util.C1341p;

/* compiled from: GeotagActivity.java */
/* renamed from: com.sec.chaton.multimedia.geotag.b */
/* loaded from: classes.dex */
class RunnableC0798b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ GeotagActivity f2730a;

    RunnableC0798b(GeotagActivity geotagActivity) {
        this.f2730a = geotagActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f2730a.f2721p == null || this.f2730a.f2722q == null) {
            Criteria criteria = new Criteria();
            criteria.setAccuracy(0);
            this.f2730a.f2718m = this.f2730a.f2717l.getBestProvider(criteria, true);
            C1341p.m4658b("[Change provider] : " + this.f2730a.f2718m, GeotagActivity.f2706a);
            this.f2730a.m3295a();
        }
    }
}
