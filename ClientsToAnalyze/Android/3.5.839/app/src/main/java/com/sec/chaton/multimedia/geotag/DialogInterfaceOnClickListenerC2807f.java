package com.sec.chaton.multimedia.geotag;

import android.content.DialogInterface;
import android.location.Location;
import android.location.LocationProvider;
import com.sec.chaton.R;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: GeotagActivity.java */
/* renamed from: com.sec.chaton.multimedia.geotag.f */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2807f implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ GeotagActivity f10159a;

    DialogInterfaceOnClickListenerC2807f(GeotagActivity geotagActivity) {
        this.f10159a = geotagActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        LocationProvider provider;
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (-3 == iM10677a || -2 == iM10677a) {
            C5179v.m19810a(this.f10159a.f10129c, R.string.popup_no_network_connection, 0).show();
            this.f10159a.finish();
            return;
        }
        if (!this.f10159a.f10137k.isProviderEnabled("network") || (provider = this.f10159a.f10137k.getProvider("network")) == null) {
            C5179v.m19810a(this.f10159a.f10129c, R.string.geotag_dialog_findgsp_message_failed_find_location, 0).show();
            this.f10159a.finish();
            return;
        }
        Location lastKnownLocation = this.f10159a.f10137k.getLastKnownLocation("network");
        if (C4904y.f17875e) {
            C4904y.m18634a("lastLocation NETWORK_PROVIDER : " + lastKnownLocation, GeotagActivity.f10121b);
        }
        if (lastKnownLocation != null) {
            this.f10159a.m11720a(lastKnownLocation, true);
            this.f10159a.f10143q = false;
        }
        this.f10159a.m11750a(provider.getName());
    }
}
