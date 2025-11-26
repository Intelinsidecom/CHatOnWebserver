package com.sec.chaton.chat.notification;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.ExitAppDialogActivity;
import com.sec.chaton.chat.C1075eq;
import com.sec.chaton.chat.C1092fg;
import com.sec.chaton.p016a.p017a.C0272i;
import com.sec.chaton.p016a.p017a.EnumC0273j;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;

/* compiled from: FragmentScreenNotification.java */
/* renamed from: com.sec.chaton.chat.notification.k */
/* loaded from: classes.dex */
class HandlerC1115k extends Handler {

    /* renamed from: a */
    final /* synthetic */ FragmentScreenNotification f4525a;

    HandlerC1115k(FragmentScreenNotification fragmentScreenNotification) {
        this.f4525a = fragmentScreenNotification;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        AbstractC3271a abstractC3271aM5388a;
        C0272i c0272i = (C0272i) ((C1092fg) message.obj).m5376a();
        if (c0272i == null) {
            if (C3250y.f11734b) {
                C3250y.m11450b("resultEntry is null", FragmentScreenNotification.f4367b);
                return;
            }
            return;
        }
        if (C1075eq.m5314a(message.what, c0272i.m1365f()) == EnumC0273j.END_APP) {
            if (!ExitAppDialogActivity.m1139a()) {
                ExitAppDialogActivity.m1141b();
                return;
            }
            return;
        }
        if (C1075eq.m5314a(message.what, c0272i.m1365f()) == EnumC0273j.RESTART_APP && (abstractC3271aM5388a = this.f4525a.m5388a(EnumC0273j.RESTART_APP)) != null) {
            abstractC3271aM5388a.mo11505a().show();
        }
        if (!c0272i.f858a) {
            int iM1365f = c0272i.m1365f();
            if (iM1365f == 24 || iM1365f == 23 || iM1365f == 21) {
                if (this.f4525a.f4376j != null) {
                    this.f4525a.f4376j.m5901j();
                }
                this.f4525a.f4370d.setText(EnumC1455w.m6361a(EnumC1455w.m6358a(this.f4525a.f4378l), this.f4525a.f4377k, this.f4525a.f4380n, this.f4525a.m5383c()));
                this.f4525a.f4370d.setVisibility(0);
                this.f4525a.f4374h.setVisibility(8);
            }
        }
    }
}
