package com.sec.chaton.smsplugin.transaction;

import android.widget.Toast;
import com.sec.chaton.R;

/* compiled from: SmsReceiverService.java */
/* renamed from: com.sec.chaton.smsplugin.transaction.ad */
/* loaded from: classes.dex */
class RunnableC4053ad implements Runnable {

    /* renamed from: a */
    final /* synthetic */ SmsReceiverService f14624a;

    RunnableC4053ad(SmsReceiverService smsReceiverService) {
        this.f14624a = smsReceiverService;
    }

    @Override // java.lang.Runnable
    public void run() {
        Toast.makeText(this.f14624a, this.f14624a.getString(R.string.message_queued), 0).show();
    }
}
