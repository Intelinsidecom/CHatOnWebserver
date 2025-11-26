package com.sec.chaton.settings;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.coolots.AbstractC0521a;
import com.sec.chaton.coolots.C0526f;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.settings.FragmentDeleteAccount;
import com.sec.chaton.util.C1786r;

/* compiled from: FragmentDeleteAccount.java */
/* renamed from: com.sec.chaton.settings.by */
/* loaded from: classes.dex */
class HandlerC1273by extends Handler {

    /* renamed from: a */
    final /* synthetic */ FragmentDeleteAccount.DeleteWorkFragment f4820a;

    HandlerC1273by(FragmentDeleteAccount.DeleteWorkFragment deleteWorkFragment) {
        this.f4820a = deleteWorkFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0101b c0101b = (C0101b) message.obj;
        switch (message.what) {
            case 202:
                if (AbstractC0521a.m2697a(this.f4820a.getActivity())) {
                    new C0526f(GlobalApplication.m3260b(), null).m2698a();
                }
                if (this.f4820a.isResumed()) {
                    if (FragmentDeleteAccount.f4616c != null) {
                        this.f4820a.getFragmentManager().beginTransaction().detach(FragmentDeleteAccount.f4616c).commit();
                        this.f4820a.getFragmentManager().executePendingTransactions();
                    }
                    boolean unused = FragmentDeleteAccount.f4614a = false;
                } else {
                    boolean unused2 = FragmentDeleteAccount.f4614a = true;
                }
                if (c0101b.m664a() && c0101b.m665b() != EnumC0803m.ERROR) {
                    C1786r.m6061b("ChatON deregistration is success.", FragmentDeleteAccount.class.getSimpleName());
                    GlobalApplication.m3261b(this.f4820a.getActivity());
                    break;
                } else {
                    C1786r.m6054a("ChatON deregistration is fail.", FragmentDeleteAccount.class.getSimpleName());
                    if (!this.f4820a.isResumed()) {
                        boolean unused3 = FragmentDeleteAccount.f4615b = true;
                        break;
                    } else {
                        FragmentDeleteAccount.ErrorDialogFragment.m4603a(R.string.toast_dereg_failed, R.string.dialog_ok).show(this.f4820a.getFragmentManager(), "error_dialog");
                        boolean unused4 = FragmentDeleteAccount.f4615b = false;
                        break;
                    }
                }
                break;
        }
    }
}
