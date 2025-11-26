package com.sec.chaton.userprofile;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.C0062R;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.network.HttpResultCode;

/* renamed from: com.sec.chaton.userprofile.p */
/* loaded from: classes.dex */
class HandlerC0592p extends Handler {

    /* renamed from: a */
    final /* synthetic */ ProfileRegistStatusMessage f3589a;

    HandlerC0592p(ProfileRegistStatusMessage profileRegistStatusMessage) {
        this.f3589a = profileRegistStatusMessage;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f3589a.f3362h.dismiss();
        switch (message.what) {
            case 401:
                HttpEntry httpEntry = (HttpEntry) message.obj;
                if (httpEntry.m1950a() && httpEntry.m1951b() != HttpResultCode.ERROR) {
                    this.f3589a.finish();
                    break;
                } else {
                    new AlertDialog.Builder(this.f3589a.f3355a).setMessage(this.f3589a.getResources().getString(C0062R.string.setting_profile_update_status_failed)).setPositiveButton(this.f3589a.getResources().getString(C0062R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC0558al(this)).setNegativeButton(this.f3589a.getResources().getString(C0062R.string.dialog_cancel), (DialogInterface.OnClickListener) null).show();
                    break;
                }
                break;
        }
    }
}
