package com.sec.chaton.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.network.TcpClient;
import com.sec.chaton.util.ChatONLogWriter;

/* loaded from: classes.dex */
public class NetStateReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() != null && "android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            ChatONLogWriter.m3506b("NetStateReceiver_onReceive", getClass().getSimpleName());
            TcpClient.m2762c();
        }
    }
}
