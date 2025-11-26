package com.sec.chaton.settings;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.settings.FragmentDeleteAccount;
import com.sec.chaton.util.C1341p;

/* compiled from: FragmentDeleteAccount.java */
/* renamed from: com.sec.chaton.settings.ac */
/* loaded from: classes.dex */
class HandlerC1005ac extends Handler {

    /* renamed from: a */
    final /* synthetic */ FragmentDeleteAccount.DeleteWorkFragment f3609a;

    HandlerC1005ac(FragmentDeleteAccount.DeleteWorkFragment deleteWorkFragment) {
        this.f3609a = deleteWorkFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (((Boolean) message.obj).booleanValue()) {
            C1341p.m4658b("Push deregistration is success. execute chaton deregistration.", FragmentDeleteAccount.class.getSimpleName());
            this.f3609a.f3501d.m771a();
        } else {
            C1341p.m4651a("Push deregistration is fail.", FragmentDeleteAccount.class.getSimpleName());
            if (this.f3609a.getActivity() != null) {
                this.f3609a.f3502e.dismiss();
            }
            FragmentDeleteAccount.ErrorDialogFragment.m3834a(R.string.toast_dereg_failed, R.string.dialog_ok).show(this.f3609a.getFragmentManager(), "error_dialog");
        }
    }
}
