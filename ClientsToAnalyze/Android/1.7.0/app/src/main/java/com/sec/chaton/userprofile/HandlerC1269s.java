package com.sec.chaton.userprofile;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.widget.AlertDialogBuilderC1625m;

/* compiled from: ProfileRegistStatusMessage.java */
/* renamed from: com.sec.chaton.userprofile.s */
/* loaded from: classes.dex */
class HandlerC1269s extends Handler {

    /* renamed from: a */
    final /* synthetic */ ProfileRegistStatusMessage f4366a;

    HandlerC1269s(ProfileRegistStatusMessage profileRegistStatusMessage) {
        this.f4366a = profileRegistStatusMessage;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (!this.f4366a.isFinishing()) {
            if (this.f4366a.f4185d.isShowing()) {
                this.f4366a.f4185d.dismiss();
            }
            switch (message.what) {
                case 401:
                    C0259g c0259g = (C0259g) message.obj;
                    if (c0259g.m927a() && c0259g.m928b() != EnumC0518y.ERROR) {
                        this.f4366a.finish();
                        break;
                    } else {
                        new AlertDialogBuilderC1625m(this.f4366a).setMessage(this.f4366a.getResources().getString(R.string.setting_profile_update_status_failed)).setPositiveButton(this.f4366a.getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC1220aq(this)).setNegativeButton(this.f4366a.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).show();
                        break;
                    }
                    break;
            }
        }
    }
}
