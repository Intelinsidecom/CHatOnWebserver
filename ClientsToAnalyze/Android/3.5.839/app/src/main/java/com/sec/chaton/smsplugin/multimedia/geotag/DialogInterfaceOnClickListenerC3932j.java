package com.sec.chaton.smsplugin.multimedia.geotag;

import android.content.DialogInterface;
import android.location.LocationProvider;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.p111h.C3894q;
import com.sec.common.CommonApplication;

/* compiled from: MmsGeotagActivity.java */
/* renamed from: com.sec.chaton.smsplugin.multimedia.geotag.j */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3932j implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MmsGeotagActivity f14160a;

    DialogInterfaceOnClickListenerC3932j(MmsGeotagActivity mmsGeotagActivity) {
        this.f14160a = mmsGeotagActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        LocationProvider provider;
        int iM15037a = C3894q.m15037a(CommonApplication.m18732r());
        if (-3 == iM15037a || -2 == iM15037a) {
            Toast.makeText(this.f14160a.f14125c, R.string.popup_no_network_connection, 0).show();
            this.f14160a.finish();
        } else if (!this.f14160a.f14132j.isProviderEnabled("network") || (provider = this.f14160a.f14132j.getProvider("network")) == null) {
            Toast.makeText(this.f14160a.f14125c, R.string.geotag_dialog_findgsp_message_failed_find_location, 0).show();
            this.f14160a.finish();
        } else {
            this.f14160a.m15173a(provider.getName());
        }
    }
}
