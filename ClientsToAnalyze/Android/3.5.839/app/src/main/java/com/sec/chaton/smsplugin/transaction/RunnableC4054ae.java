package com.sec.chaton.smsplugin.transaction;

import android.widget.Toast;
import com.sec.chaton.R;

/* compiled from: SmsReceiverService.java */
/* renamed from: com.sec.chaton.smsplugin.transaction.ae */
/* loaded from: classes.dex */
class RunnableC4054ae implements Runnable {

    /* renamed from: a */
    final /* synthetic */ SmsReceiverService f14625a;

    RunnableC4054ae(SmsReceiverService smsReceiverService) {
        this.f14625a = smsReceiverService;
    }

    @Override // java.lang.Runnable
    public void run() {
        Toast.makeText(this.f14625a, this.f14625a.getString(R.string.fdn_check_failure), 0).show();
    }
}
