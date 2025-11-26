package com.sec.vip.amschaton;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.vip.amschaton.i */
/* loaded from: classes.dex */
class C0706i extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ AMSActivity f4335a;

    C0706i(AMSActivity aMSActivity) {
        this.f4335a = aMSActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        ChatONLogWriter.m3506b("[onReceive] Storage: " + intent.getData(), getClass().getSimpleName());
        this.f4335a.m3709i();
    }
}
