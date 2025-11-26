package com.sec.chaton.util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.sec.chaton.TabActivity;

/* compiled from: EnhancedNotification.java */
/* renamed from: com.sec.chaton.util.ap */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4824ap implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ EnhancedNotification f17610a;

    DialogInterfaceOnClickListenerC4824ap(EnhancedNotification enhancedNotification) {
        this.f17610a = enhancedNotification;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Intent intentM3017a = TabActivity.m3017a((Context) this.f17610a, true);
        intentM3017a.putExtra("inboxNO", this.f17610a.f17563o);
        intentM3017a.putExtra("chatType", this.f17610a.f17564p);
        intentM3017a.putExtra("fromPush", 1);
        this.f17610a.startActivity(intentM3017a);
        this.f17610a.finish();
    }
}
