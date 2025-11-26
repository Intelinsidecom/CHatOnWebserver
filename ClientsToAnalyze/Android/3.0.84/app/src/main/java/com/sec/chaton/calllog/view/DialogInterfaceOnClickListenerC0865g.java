package com.sec.chaton.calllog.view;

import android.content.DialogInterface;
import com.sec.chaton.p025d.C1330h;

/* compiled from: CallLogDetailFragment.java */
/* renamed from: com.sec.chaton.calllog.view.g */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0865g implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0864f f3386a;

    DialogInterfaceOnClickListenerC0865g(HandlerC0864f handlerC0864f) {
        this.f3386a = handlerC0864f;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f3386a.f3385a.m4547s();
        new C1330h(this.f3386a.f3385a.f3243b).m5730b(this.f3386a.f3385a.f3239L.m3975b());
    }
}
