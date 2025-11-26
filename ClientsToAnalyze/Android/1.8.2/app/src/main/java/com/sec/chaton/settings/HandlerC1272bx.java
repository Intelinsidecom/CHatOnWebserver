package com.sec.chaton.settings;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.settings.FragmentDeleteAccount;
import com.sec.chaton.util.C1786r;

/* compiled from: FragmentDeleteAccount.java */
/* renamed from: com.sec.chaton.settings.bx */
/* loaded from: classes.dex */
class HandlerC1272bx extends Handler {

    /* renamed from: a */
    final /* synthetic */ FragmentDeleteAccount.DeleteWorkFragment f4819a;

    HandlerC1272bx(FragmentDeleteAccount.DeleteWorkFragment deleteWorkFragment) {
        this.f4819a = deleteWorkFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (((Boolean) message.obj).booleanValue()) {
            C1786r.m6061b("Push deregistration is success. execute chaton deregistration.", FragmentDeleteAccount.class.getSimpleName());
            this.f4819a.f4620d.m2806a();
            return;
        }
        C1786r.m6054a("Push deregistration is fail.", FragmentDeleteAccount.class.getSimpleName());
        if (!this.f4819a.isResumed()) {
            boolean unused = FragmentDeleteAccount.f4614a = true;
            boolean unused2 = FragmentDeleteAccount.f4615b = true;
            return;
        }
        if (this.f4819a.getActivity() != null && FragmentDeleteAccount.f4616c != null) {
            this.f4819a.getFragmentManager().beginTransaction().detach(FragmentDeleteAccount.f4616c).commit();
            this.f4819a.getFragmentManager().executePendingTransactions();
        }
        FragmentDeleteAccount.ErrorDialogFragment.m4603a(R.string.toast_dereg_failed, R.string.dialog_ok).show(this.f4819a.getFragmentManager(), "error_dialog");
        boolean unused3 = FragmentDeleteAccount.f4614a = false;
        boolean unused4 = FragmentDeleteAccount.f4615b = false;
    }
}
