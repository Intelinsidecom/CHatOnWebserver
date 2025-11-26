package com.sec.chaton.multimedia.geotag;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.C0062R;

/* renamed from: com.sec.chaton.multimedia.geotag.a */
/* loaded from: classes.dex */
class HandlerC0297a extends Handler {

    /* renamed from: a */
    final /* synthetic */ GeotagActivity f2166a;

    HandlerC0297a(GeotagActivity geotagActivity) {
        this.f2166a = geotagActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        new AlertDialog.Builder(this.f2166a.f2142c).setTitle(this.f2166a.getResources().getString(C0062R.string.geotag_dialog_findgsp_title_failed_find_location)).setMessage(this.f2166a.getResources().getString(C0062R.string.geotag_dialog_findgsp_message_failed_find_location)).setPositiveButton(this.f2166a.getResources().getString(C0062R.string.geotag_dialog_findgsp_button_failed_retry), new DialogInterfaceOnClickListenerC0304h(this)).setNegativeButton(this.f2166a.getResources().getString(C0062R.string.geotag_dialog_findgsp_button_failed_cancel), (DialogInterface.OnClickListener) null).show();
    }
}
