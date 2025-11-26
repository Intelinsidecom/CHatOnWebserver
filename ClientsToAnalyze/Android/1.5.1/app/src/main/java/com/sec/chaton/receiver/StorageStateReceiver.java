package com.sec.chaton.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.constant.ChatONConst;
import com.sec.chaton.util.ChatONLogWriter;

/* loaded from: classes.dex */
public class StorageStateReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        ChatONLogWriter.m3506b("onReceive : " + intent.getAction(), getClass().getSimpleName());
        if (intent.getAction() == null || !intent.getAction().equals("android.intent.action.MEDIA_MOUNTED")) {
            return;
        }
        ChatONLogWriter.m3506b("ACTION_MEDIA_MOUNTED deleteFilesDirectory", getClass().getSimpleName());
        context.startService(new Intent(ChatONConst.f1340d));
    }
}
