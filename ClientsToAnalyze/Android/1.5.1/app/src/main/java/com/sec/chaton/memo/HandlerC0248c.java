package com.sec.chaton.memo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.C0062R;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.network.HttpResultCode;
import com.sec.chaton.trunk.control.TrunkMessageControl;

/* renamed from: com.sec.chaton.memo.c */
/* loaded from: classes.dex */
class HandlerC0248c extends Handler {

    /* renamed from: a */
    final /* synthetic */ WriteMemoActivity f1950a;

    HandlerC0248c(WriteMemoActivity writeMemoActivity) {
        this.f1950a = writeMemoActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f1950a.f1945h.dismiss();
        switch (message.what) {
            case TrunkMessageControl.METHOD_GET_COMMENT_ITEM_LIST /* 903 */:
                HttpEntry httpEntry = (HttpEntry) message.obj;
                if (httpEntry.m1950a() && httpEntry.m1951b() != HttpResultCode.ERROR) {
                    this.f1950a.setResult(-1);
                    this.f1950a.finish();
                    break;
                } else {
                    new AlertDialog.Builder(this.f1950a.f1938a).setMessage(this.f1950a.getResources().getString(C0062R.string.setting_profile_update_status_failed)).setPositiveButton(this.f1950a.getResources().getString(C0062R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC0246a(this)).setNegativeButton(this.f1950a.getResources().getString(C0062R.string.dialog_cancel), (DialogInterface.OnClickListener) null).show();
                    break;
                }
                break;
        }
    }
}
