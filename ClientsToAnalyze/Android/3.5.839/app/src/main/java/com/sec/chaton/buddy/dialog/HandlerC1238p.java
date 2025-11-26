package com.sec.chaton.buddy.dialog;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.widget.C5179v;

/* compiled from: ChatONVInstallDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.p */
/* loaded from: classes.dex */
class HandlerC1238p extends Handler {

    /* renamed from: a */
    final /* synthetic */ ChatONVInstallDialog f4738a;

    HandlerC1238p(ChatONVInstallDialog chatONVInstallDialog) {
        this.f4738a = chatONVInstallDialog;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0778b c0778b = (C0778b) message.obj;
        switch (message.what) {
            case 305:
                if (this.f4738a.f4535d != null && this.f4738a.f4535d.isShowing()) {
                    this.f4738a.f4535d.dismiss();
                }
                if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                    this.f4738a.finish();
                    break;
                } else {
                    C4904y.m18639b("fail to set extra info", getClass().getSimpleName());
                    if (GlobalApplication.m18732r() != null) {
                        String strM3112g = c0778b.m3112g();
                        AbstractC4932a abstractC4932aMo18747b = AbstractC4932a.m18733a(this.f4738a.f4533a).mo18740a(this.f4738a.getResources().getString(R.string.toast_error)).mo18749b(C4822an.m18209a(this.f4738a.getResources().getString(R.string.dev_network_error), this.f4738a.getResources().getString(R.string.error_code_common), strM3112g)).mo18754c(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC1240r(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1239q(this));
                        this.f4738a.f4537f = C4859bx.m18375a(abstractC4932aMo18747b, this.f4738a, strM3112g).mo18745a();
                        this.f4738a.f4537f.setOnCancelListener(new DialogInterfaceOnCancelListenerC1241s(this));
                        if (!this.f4738a.f4539h) {
                            this.f4738a.f4537f.show();
                            break;
                        }
                    }
                }
                break;
            case 411:
                if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                    if (this.f4738a.f4535d != null && this.f4738a.f4535d.isShowing()) {
                        this.f4738a.f4535d.dismiss();
                    }
                    if (C4904y.f17872b) {
                        C4904y.m18639b("get profile all fail", ChatONVInstallDialog.f4532b);
                    }
                    String strM3112g2 = c0778b.m3112g();
                    AbstractC4932a abstractC4932aMo18747b2 = AbstractC4932a.m18733a(this.f4738a.f4533a).mo18740a(this.f4738a.getResources().getString(R.string.toast_error)).mo18749b(C4822an.m18209a(this.f4738a.getResources().getString(R.string.dev_network_error), this.f4738a.getResources().getString(R.string.error_code_common), strM3112g2)).mo18754c(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC1243u(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1242t(this));
                    this.f4738a.f4537f = C4859bx.m18375a(abstractC4932aMo18747b2, this.f4738a, strM3112g2).mo18745a();
                    this.f4738a.f4537f.setOnCancelListener(new DialogInterfaceOnCancelListenerC1244v(this));
                    if (!this.f4738a.f4539h) {
                        this.f4738a.f4537f.show();
                        break;
                    }
                } else {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("get profile all", ChatONVInstallDialog.f4532b);
                    }
                    if (C4859bx.m18369a(this.f4738a.f4533a, this.f4738a.f4534c) != 0) {
                        if (this.f4738a.f4535d != null && this.f4738a.f4535d.isShowing()) {
                            this.f4738a.f4535d.dismiss();
                        }
                        C5179v.m19810a(this.f4738a.f4533a, R.string.toast_setting_communication_failed, 0).show();
                        this.f4738a.finish();
                        break;
                    }
                }
                break;
        }
    }
}
