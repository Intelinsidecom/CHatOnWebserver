package com.sec.chaton.poston;

import android.content.DialogInterface;
import com.sec.chaton.util.C4904y;

/* compiled from: PostONDetailFragment.java */
/* renamed from: com.sec.chaton.poston.ag */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2962ag implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2957ab f11054a;

    DialogInterfaceOnClickListenerC2962ag(HandlerC2957ab handlerC2957ab) {
        this.f11054a = handlerC2957ab;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            this.f11054a.f11049a.f10906U.m9289a(this.f11054a.f11049a.f10890E, new C3021p(this.f11054a.f11049a.f10900O, this.f11054a.f11049a.f10891F, this.f11054a.f11049a.f10923ae.getText().toString(), this.f11054a.f11049a.f10892G, "-1", null), this.f11054a.f11049a.f10896K);
            this.f11054a.f11049a.f10910Y.show();
        } catch (Exception e) {
            C4904y.m18635a(e, getClass().getSimpleName());
        }
    }
}
