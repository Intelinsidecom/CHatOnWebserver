package com.sec.chaton.buddy.dialog;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;

/* compiled from: ChatONVInstallDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.m */
/* loaded from: classes.dex */
class HandlerC0631m extends Handler {

    /* renamed from: a */
    final /* synthetic */ ChatONVInstallDialog f2851a;

    HandlerC0631m(ChatONVInstallDialog chatONVInstallDialog) {
        this.f2851a = chatONVInstallDialog;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0267d c0267d = (C0267d) message.obj;
        switch (message.what) {
            case 305:
                if (this.f2851a.f2692d != null && this.f2851a.f2692d.isShowing()) {
                    this.f2851a.f2692d.dismiss();
                }
                if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
                    this.f2851a.finish();
                    break;
                } else {
                    C3250y.m11450b("fail to set extra info", getClass().getSimpleName());
                    if (GlobalApplication.m11493l() != null) {
                        this.f2851a.f2694f = AbstractC3271a.m11494a(this.f2851a.f2690a).mo11500a(this.f2851a.getResources().getString(R.string.toast_error)).mo11509b(C3171am.m11046a(this.f2851a.getResources().getString(R.string.dev_network_error), this.f2851a.getResources().getString(R.string.toast_error), c0267d.m1356g())).mo11515d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC0633o(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC0632n(this)).mo11512b();
                        this.f2851a.f2694f.setOnCancelListener(new DialogInterfaceOnCancelListenerC0634p(this));
                        if (!this.f2851a.f2696h) {
                            this.f2851a.f2694f.show();
                            break;
                        }
                    }
                }
                break;
        }
    }
}
