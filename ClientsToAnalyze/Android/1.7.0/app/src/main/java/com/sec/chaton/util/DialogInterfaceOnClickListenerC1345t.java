package com.sec.chaton.util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.sec.chaton.HomeActivity;

/* compiled from: EnhancedNotification.java */
/* renamed from: com.sec.chaton.util.t */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1345t implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ EnhancedNotification f4585a;

    DialogInterfaceOnClickListenerC1345t(EnhancedNotification enhancedNotification) {
        this.f4585a = enhancedNotification;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Intent intentM630a = HomeActivity.m630a((Context) this.f4585a, true);
        intentM630a.putExtra("inboxNO", this.f4585a.f4428c);
        intentM630a.putExtra("chatType", this.f4585a.f4429d);
        intentM630a.putExtra("fromPush", 1);
        this.f4585a.startActivity(intentM630a);
        this.f4585a.finish();
    }
}
