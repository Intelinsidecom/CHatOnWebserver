package com.sec.chaton.util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.sec.chaton.HomeActivity;

/* renamed from: com.sec.chaton.util.g */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0609g implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ EnhancedNotification f3774a;

    DialogInterfaceOnClickListenerC0609g(EnhancedNotification enhancedNotification) {
        this.f3774a = enhancedNotification;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Intent intentM358a = HomeActivity.m358a((Context) this.f3774a, true);
        intentM358a.putExtra("inboxNO", this.f3774a.f3670c);
        intentM358a.putExtra("chatType", this.f3774a.f3671d);
        intentM358a.putExtra("fromPush", 1);
        this.f3774a.startActivity(intentM358a);
        this.f3774a.finish();
    }
}
