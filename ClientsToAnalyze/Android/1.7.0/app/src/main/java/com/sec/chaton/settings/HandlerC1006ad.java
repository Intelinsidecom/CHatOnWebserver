package com.sec.chaton.settings;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.coolots.AbstractC0617h;
import com.sec.chaton.coolots.C0614e;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.settings.FragmentDeleteAccount;
import com.sec.chaton.util.C1341p;

/* compiled from: FragmentDeleteAccount.java */
/* renamed from: com.sec.chaton.settings.ad */
/* loaded from: classes.dex */
class HandlerC1006ad extends Handler {

    /* renamed from: a */
    final /* synthetic */ FragmentDeleteAccount.DeleteWorkFragment f3610a;

    HandlerC1006ad(FragmentDeleteAccount.DeleteWorkFragment deleteWorkFragment) {
        this.f3610a = deleteWorkFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0259g c0259g = (C0259g) message.obj;
        switch (message.what) {
            case 202:
                if (AbstractC0617h.m2831a(this.f3610a.getActivity())) {
                    new C0614e(GlobalApplication.m3100a(), null).m2832b();
                }
                if (c0259g.m927a() && c0259g.m928b() != EnumC0518y.ERROR) {
                    C1341p.m4658b("ChatON deregistration is success.", FragmentDeleteAccount.class.getSimpleName());
                    GlobalApplication.m3104b(this.f3610a.getActivity());
                    break;
                } else {
                    if (this.f3610a.getActivity() != null) {
                        this.f3610a.getFragmentManager().beginTransaction().detach(this.f3610a.f3502e).commitAllowingStateLoss();
                        this.f3610a.getFragmentManager().executePendingTransactions();
                    }
                    C1341p.m4651a("ChatON deregistration is fail.", FragmentDeleteAccount.class.getSimpleName());
                    this.f3610a.getFragmentManager().beginTransaction().add(FragmentDeleteAccount.ErrorDialogFragment.m3834a(R.string.toast_dereg_failed, R.string.dialog_ok), "error_dialog").commitAllowingStateLoss();
                    break;
                }
                break;
        }
    }
}
