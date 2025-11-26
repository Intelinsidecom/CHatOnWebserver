package com.sec.chaton.multimedia.geotag;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;

/* compiled from: GeotagActivity.java */
/* renamed from: com.sec.chaton.multimedia.geotag.j */
/* loaded from: classes.dex */
class HandlerC1845j extends Handler {

    /* renamed from: a */
    final /* synthetic */ GeotagActivity f6869a;

    HandlerC1845j(GeotagActivity geotagActivity) {
        this.f6869a = geotagActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f6869a.f6830D == null) {
            if (this.f6869a.f6828B == null) {
                this.f6869a.f6828B = AbstractC3271a.m11494a(this.f6869a.f6835c).mo11500a(this.f6869a.getResources().getString(R.string.geotag_dialog_findgsp_title_failed_find_location)).mo11509b(this.f6869a.getResources().getString(R.string.geotag_dialog_findgsp_message_failed_find_location)).mo11510b(this.f6869a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1847l(this)).mo11501a(this.f6869a.getResources().getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC1846k(this)).mo11505a();
                this.f6869a.f6828B.mo11517a().setCanceledOnTouchOutside(false);
                this.f6869a.f6828B.mo11517a().setCancelable(false);
            }
            this.f6869a.f6828B.show();
            this.f6869a.f6857y = true;
            return;
        }
        if (C3250y.f11734b) {
            C3250y.m11450b("mark with networkLocation ", GeotagActivity.f6826b);
        }
        this.f6869a.m7515a(this.f6869a.f6830D);
    }
}
