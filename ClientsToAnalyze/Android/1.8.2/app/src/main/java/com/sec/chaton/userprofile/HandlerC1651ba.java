package com.sec.chaton.userprofile;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: ProfileRegistPushName.java */
/* renamed from: com.sec.chaton.userprofile.ba */
/* loaded from: classes.dex */
class HandlerC1651ba extends Handler {

    /* renamed from: a */
    final /* synthetic */ ProfileRegistPushName f6142a;

    HandlerC1651ba(ProfileRegistPushName profileRegistPushName) {
        this.f6142a = profileRegistPushName;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (!this.f6142a.isFinishing()) {
            if (this.f6142a.f5962k.isShowing()) {
                this.f6142a.f5962k.dismiss();
            }
            switch (message.what) {
                case HttpResponseCode.UNAUTHORIZED /* 401 */:
                    C0101b c0101b = (C0101b) message.obj;
                    if (c0101b.m664a() && c0101b.m665b() != EnumC0803m.ERROR) {
                        this.f6142a.finish();
                        break;
                    } else {
                        new AlertDialog.Builder(this.f6142a).setMessage(this.f6142a.getResources().getString(R.string.setting_profile_update_status_failed)).setNegativeButton(this.f6142a.getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC1652bb(this)).setPositiveButton(this.f6142a.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).show();
                        break;
                    }
                    break;
            }
        }
    }
}
