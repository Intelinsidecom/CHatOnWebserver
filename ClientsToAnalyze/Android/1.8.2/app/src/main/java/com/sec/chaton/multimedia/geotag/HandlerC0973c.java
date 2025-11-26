package com.sec.chaton.multimedia.geotag;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;

/* compiled from: GeotagActivity.java */
/* renamed from: com.sec.chaton.multimedia.geotag.c */
/* loaded from: classes.dex */
class HandlerC0973c extends Handler {

    /* renamed from: a */
    final /* synthetic */ GeotagActivity f3592a;

    HandlerC0973c(GeotagActivity geotagActivity) {
        this.f3592a = geotagActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        new AlertDialog.Builder(this.f3592a.f3569g).setTitle(this.f3592a.getResources().getString(R.string.geotag_dialog_findgsp_title_failed_find_location)).setMessage(this.f3592a.getResources().getString(R.string.geotag_dialog_findgsp_message_failed_find_location)).setPositiveButton(this.f3592a.getResources().getString(R.string.geotag_dialog_findgsp_button_failed_cancel), (DialogInterface.OnClickListener) null).setNegativeButton(this.f3592a.getResources().getString(R.string.geotag_dialog_findgsp_button_failed_retry), new DialogInterfaceOnClickListenerC0974d(this)).show();
    }
}
