package com.sec.chaton.poston;

import android.content.DialogInterface;
import com.sec.chaton.util.C3250y;

/* compiled from: PostONDetailFragment.java */
/* renamed from: com.sec.chaton.poston.ag */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1967ag implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2034y f7659a;

    DialogInterfaceOnClickListenerC1967ag(HandlerC2034y handlerC2034y) {
        this.f7659a = handlerC2034y;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            this.f7659a.f7823a.f7522T.m5914a(this.f7659a.f7823a.f7505C, new C2025p(this.f7659a.f7823a.f7506D, this.f7659a.f7823a.f7507E, this.f7659a.f7823a.f7531ac.getText().toString(), this.f7659a.f7823a.f7508F, "-1", null), this.f7659a.f7823a.f7512J);
            this.f7659a.f7823a.f7525W.show();
        } catch (Exception e) {
            C3250y.m11443a(e, getClass().getSimpleName());
        }
    }
}
