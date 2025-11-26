package com.sec.chaton.hugefiletransfer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C4904y;

/* loaded from: classes.dex */
public class HugeFileUploadBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f8480a = HugeFileUploadBroadcastReceiver.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context != null && intent != null) {
            if (C4904y.f17872b) {
                C4904y.m18639b("onReceive : " + intent.getData(), f8480a);
            }
            intent.setClass(context, HugeFileSendingMessageService.class);
            context.startService(intent);
        }
    }
}
