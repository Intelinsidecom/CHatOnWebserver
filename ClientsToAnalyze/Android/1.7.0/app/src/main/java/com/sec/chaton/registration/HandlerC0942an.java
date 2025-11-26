package com.sec.chaton.registration;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;
import com.sec.widget.AlertDialogBuilderC1625m;

/* compiled from: ActivityDisclaimer.java */
/* renamed from: com.sec.chaton.registration.an */
/* loaded from: classes.dex */
class HandlerC0942an extends Handler {

    /* renamed from: a */
    final /* synthetic */ ActivityDisclaimer f3329a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC0942an(ActivityDisclaimer activityDisclaimer, Looper looper) {
        super(looper);
        this.f3329a = activityDisclaimer;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0259g c0259g = (C0259g) message.obj;
        if (c0259g.m927a() && c0259g.m928b() != EnumC0518y.ERROR) {
            C1323bs.m4579a("update_disclaimer_status", "DONE");
            this.f3329a.finish();
        } else {
            new AlertDialogBuilderC1625m(this.f3329a).setTitle(this.f3329a.getResources().getString(R.string.toast_error)).setMessage(this.f3329a.getResources().getString(R.string.toast_network_unable)).setPositiveButton(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC0951aw(this)).create().show();
            C1341p.m4651a("SELF SMS failed becuase netwrok error", getClass().getSimpleName());
        }
        this.f3329a.f3150b.dismiss();
    }
}
