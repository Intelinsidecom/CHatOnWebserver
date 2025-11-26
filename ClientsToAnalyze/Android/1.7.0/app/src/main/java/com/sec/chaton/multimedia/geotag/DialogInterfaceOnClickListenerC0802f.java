package com.sec.chaton.multimedia.geotag;

import android.content.DialogInterface;
import android.location.Criteria;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p018c.C0502i;
import com.sec.widget.C1619g;

/* compiled from: GeotagActivity.java */
/* renamed from: com.sec.chaton.multimedia.geotag.f */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0802f implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ GeotagActivity f2734a;

    DialogInterfaceOnClickListenerC0802f(GeotagActivity geotagActivity) {
        this.f2734a = geotagActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int iM2526a = C0502i.m2526a(GlobalApplication.m3100a());
        if (-3 == iM2526a || -2 == iM2526a) {
            C1619g.m5888a(this.f2734a.f2708c, R.string.toast_network_unable, 0).show();
            this.f2734a.finish();
            return;
        }
        Criteria criteria = new Criteria();
        criteria.setAccuracy(0);
        this.f2734a.f2718m = this.f2734a.f2717l.getBestProvider(criteria, true);
        if (this.f2734a.f2718m == null) {
            C1619g.m5888a(this.f2734a.f2708c, R.string.geotag_dialog_findgsp_message_failed_find_location, 0).show();
            this.f2734a.finish();
        } else {
            this.f2734a.m3295a();
        }
    }
}
