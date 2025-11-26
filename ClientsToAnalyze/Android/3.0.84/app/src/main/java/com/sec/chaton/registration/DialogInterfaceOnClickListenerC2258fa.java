package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.R;

/* compiled from: FragmentRegistPushName.java */
/* renamed from: com.sec.chaton.registration.fa */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2258fa implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2249es f8554a;

    DialogInterfaceOnClickListenerC2258fa(HandlerC2249es handlerC2249es) {
        this.f8554a = handlerC2249es;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f8554a.f8544a.m8613a(this.f8554a.f8544a.getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f8554a.f8544a.f8328p, this.f8554a.f8544a.f8329q);
        this.f8554a.f8544a.f8325m.m5723a("voip", 1, false);
    }
}
