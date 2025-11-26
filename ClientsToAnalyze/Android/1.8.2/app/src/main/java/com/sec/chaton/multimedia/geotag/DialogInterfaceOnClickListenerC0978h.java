package com.sec.chaton.multimedia.geotag;

import android.content.DialogInterface;
import android.location.Criteria;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p022h.C0809s;

/* compiled from: GeotagActivity.java */
/* renamed from: com.sec.chaton.multimedia.geotag.h */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0978h implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ GeotagActivity f3597a;

    DialogInterfaceOnClickListenerC0978h(GeotagActivity geotagActivity) {
        this.f3597a = geotagActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int iM3420a = C0809s.m3420a(GlobalApplication.m3260b());
        if (-3 == iM3420a || -2 == iM3420a) {
            Toast.makeText(this.f3597a.f3569g, R.string.toast_network_unable, 0).show();
            this.f3597a.finish();
            return;
        }
        Criteria criteria = new Criteria();
        criteria.setAccuracy(0);
        this.f3597a.f3579q = this.f3597a.f3578p.getBestProvider(criteria, true);
        if (this.f3597a.f3579q == null) {
            Toast.makeText(this.f3597a.f3569g, R.string.geotag_dialog_findgsp_message_failed_find_location, 0).show();
            this.f3597a.finish();
        } else {
            this.f3597a.m3851a();
        }
    }
}
