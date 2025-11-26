package com.sec.chaton.userprofile;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.C0062R;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.network.HttpResultCode;

/* renamed from: com.sec.chaton.userprofile.an */
/* loaded from: classes.dex */
class HandlerC0560an extends Handler {

    /* renamed from: a */
    final /* synthetic */ ProfileRegistPushName f3539a;

    HandlerC0560an(ProfileRegistPushName profileRegistPushName) {
        this.f3539a = profileRegistPushName;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f3539a.f3352h.dismiss();
        switch (message.what) {
            case 401:
                HttpEntry httpEntry = (HttpEntry) message.obj;
                if (httpEntry.m1950a() && httpEntry.m1951b() != HttpResultCode.ERROR) {
                    this.f3539a.finish();
                    break;
                } else {
                    new AlertDialog.Builder(this.f3539a.f3345a).setMessage(this.f3539a.getResources().getString(C0062R.string.setting_profile_update_status_failed)).setPositiveButton(this.f3539a.getResources().getString(C0062R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC0585i(this)).setNegativeButton(this.f3539a.getResources().getString(C0062R.string.dialog_cancel), (DialogInterface.OnClickListener) null).show();
                    break;
                }
                break;
        }
    }
}
