package com.sec.chaton.smsplugin.transaction;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.R;

/* compiled from: TransactionService.java */
/* renamed from: com.sec.chaton.smsplugin.transaction.al */
/* loaded from: classes.dex */
class HandlerC4061al extends Handler {

    /* renamed from: a */
    final /* synthetic */ TransactionService f14644a;

    HandlerC4061al(TransactionService transactionService) {
        this.f14644a = transactionService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        String string = null;
        if (message.what == 1) {
            string = this.f14644a.getString(R.string.message_queued);
        } else if (message.what == 2) {
            string = this.f14644a.getString(R.string.download_later);
        }
        if (string != null) {
            Toast.makeText(this.f14644a, string, 1).show();
        }
    }
}
