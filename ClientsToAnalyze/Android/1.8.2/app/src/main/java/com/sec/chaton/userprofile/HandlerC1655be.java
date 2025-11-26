package com.sec.chaton.userprofile;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: ProfileRegistStatusMessage.java */
/* renamed from: com.sec.chaton.userprofile.be */
/* loaded from: classes.dex */
class HandlerC1655be extends Handler {

    /* renamed from: a */
    final /* synthetic */ ProfileRegistStatusMessage f6146a;

    HandlerC1655be(ProfileRegistStatusMessage profileRegistStatusMessage) {
        this.f6146a = profileRegistStatusMessage;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (!this.f6146a.isFinishing()) {
            if (this.f6146a.f5972k.isShowing()) {
                this.f6146a.f5972k.dismiss();
            }
            switch (message.what) {
                case HttpResponseCode.UNAUTHORIZED /* 401 */:
                    C0101b c0101b = (C0101b) message.obj;
                    if (c0101b.m664a() && c0101b.m665b() != EnumC0803m.ERROR) {
                        this.f6146a.finish();
                        break;
                    } else {
                        new AlertDialog.Builder(this.f6146a).setMessage(this.f6146a.getResources().getString(R.string.setting_profile_update_status_failed)).setNegativeButton(this.f6146a.getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC1656bf(this)).setPositiveButton(this.f6146a.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).show();
                        break;
                    }
                    break;
            }
        }
    }
}
