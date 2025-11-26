package com.sec.chaton.multimedia.geotag;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.widget.AlertDialogBuilderC1625m;

/* compiled from: GeotagActivity.java */
/* renamed from: com.sec.chaton.multimedia.geotag.d */
/* loaded from: classes.dex */
class HandlerC0800d extends Handler {

    /* renamed from: a */
    final /* synthetic */ GeotagActivity f2732a;

    HandlerC0800d(GeotagActivity geotagActivity) {
        this.f2732a = geotagActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        new AlertDialogBuilderC1625m(this.f2732a.f2708c).setTitle(this.f2732a.getResources().getString(R.string.geotag_dialog_findgsp_title_failed_find_location)).setMessage(this.f2732a.getResources().getString(R.string.geotag_dialog_findgsp_message_failed_find_location)).setPositiveButton(this.f2732a.getResources().getString(R.string.geotag_dialog_findgsp_button_failed_retry), new DialogInterfaceOnClickListenerC0806j(this)).setNegativeButton(this.f2732a.getResources().getString(R.string.geotag_dialog_findgsp_button_failed_cancel), new DialogInterfaceOnClickListenerC0807k(this)).show();
    }
}
