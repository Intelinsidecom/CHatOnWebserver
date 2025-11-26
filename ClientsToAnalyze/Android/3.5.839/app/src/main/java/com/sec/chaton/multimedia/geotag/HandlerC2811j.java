package com.sec.chaton.multimedia.geotag;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.util.C4904y;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: GeotagActivity.java */
/* renamed from: com.sec.chaton.multimedia.geotag.j */
/* loaded from: classes.dex */
class HandlerC2811j extends Handler {

    /* renamed from: a */
    final /* synthetic */ GeotagActivity f10163a;

    HandlerC2811j(GeotagActivity geotagActivity) {
        this.f10163a = geotagActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f10163a.f10125D == null) {
            if (this.f10163a.f10123B == null) {
                this.f10163a.f10123B = AbstractC4932a.m18733a(this.f10163a.f10129c).mo18740a(this.f10163a.getResources().getString(R.string.geotag_dialog_findgsp_title_failed_find_location)).mo18749b(this.f10163a.getResources().getString(R.string.geotag_dialog_findgsp_message_failed_find_location)).mo18755c(this.f10163a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC2813l(this)).mo18741a(this.f10163a.getResources().getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC2812k(this)).mo18751b(false).mo18745a();
                this.f10163a.f10123B.mo18758a().setCanceledOnTouchOutside(false);
            }
            this.f10163a.f10123B.show();
            this.f10163a.f10151y = true;
            return;
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("mark with networkLocation ", GeotagActivity.f10121b);
        }
        this.f10163a.m11720a(this.f10163a.f10125D, false);
    }
}
