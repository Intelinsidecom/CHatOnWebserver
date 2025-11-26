package com.sec.chaton.util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.sec.chaton.HomeActivity;

/* compiled from: EnhancedNotification.java */
/* renamed from: com.sec.chaton.util.ag */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1724ag implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ EnhancedNotification f6319a;

    DialogInterfaceOnClickListenerC1724ag(EnhancedNotification enhancedNotification) {
        this.f6319a = enhancedNotification;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Intent intentM585a = HomeActivity.m585a((Context) this.f6319a, true);
        intentM585a.putExtra("inboxNO", this.f6319a.f6284c);
        intentM585a.putExtra("chatType", this.f6319a.f6285d);
        intentM585a.putExtra("fromPush", 1);
        this.f6319a.startActivity(intentM585a);
        this.f6319a.finish();
    }
}
