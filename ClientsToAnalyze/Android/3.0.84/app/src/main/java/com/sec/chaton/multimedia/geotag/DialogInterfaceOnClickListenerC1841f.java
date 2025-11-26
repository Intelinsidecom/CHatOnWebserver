package com.sec.chaton.multimedia.geotag;

import android.content.DialogInterface;
import android.location.LocationProvider;
import com.sec.chaton.R;
import com.sec.chaton.p037j.C1594v;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;

/* compiled from: GeotagActivity.java */
/* renamed from: com.sec.chaton.multimedia.geotag.f */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1841f implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ GeotagActivity f6865a;

    DialogInterfaceOnClickListenerC1841f(GeotagActivity geotagActivity) {
        this.f6865a = geotagActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        LocationProvider provider;
        int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
        if (-3 == iM6733a || -2 == iM6733a) {
            C3641ai.m13210a(this.f6865a.f6835c, R.string.popup_no_network_connection, 0).show();
            this.f6865a.finish();
        } else if (!this.f6865a.f6843k.isProviderEnabled("network") || (provider = this.f6865a.f6843k.getProvider("network")) == null) {
            C3641ai.m13210a(this.f6865a.f6835c, R.string.geotag_dialog_findgsp_message_failed_find_location, 0).show();
            this.f6865a.finish();
        } else {
            this.f6865a.m7545a(provider.getName());
        }
    }
}
