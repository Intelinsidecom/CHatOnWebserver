package com.sec.chaton.util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.sec.chaton.TabActivity;

/* compiled from: EnhancedNotification.java */
/* renamed from: com.sec.chaton.util.ap */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3174ap implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ EnhancedNotification f11495a;

    DialogInterfaceOnClickListenerC3174ap(EnhancedNotification enhancedNotification) {
        this.f11495a = enhancedNotification;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Intent intentM1228a = TabActivity.m1228a((Context) this.f11495a, true);
        intentM1228a.putExtra("inboxNO", this.f11495a.f11462b);
        intentM1228a.putExtra("chatType", this.f11495a.f11463c);
        intentM1228a.putExtra("fromPush", 1);
        this.f11495a.startActivity(intentM1228a);
        this.f11495a.finish();
    }
}
