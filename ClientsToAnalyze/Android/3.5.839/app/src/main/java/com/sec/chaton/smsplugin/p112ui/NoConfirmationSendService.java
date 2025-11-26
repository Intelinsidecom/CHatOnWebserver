package com.sec.chaton.smsplugin.p112ui;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import com.sec.chaton.smsplugin.p102b.C3790i;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.transaction.C4052ac;
import com.sec.spp.push.Config;

/* loaded from: classes.dex */
public class NoConfirmationSendService extends Service {
    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            super.onStartCommand(intent, i, i2);
            PluginComposeMessageActivity.m16048c("NoConfirmationSendService onStartCommand");
            String action = intent.getAction();
            if (!"com.sec.chaton.smsplugin.intent.action.SENDTO_NO_CONFIRMATION".equals(action)) {
                PluginComposeMessageActivity.m16048c("NoConfirmationSendService onStartCommand wrong action: " + action);
                stopSelf();
            } else {
                Bundle extras = intent.getExtras();
                if (extras == null) {
                    PluginComposeMessageActivity.m16048c("Called to send SMS but no extras");
                    stopSelf();
                } else {
                    String string = extras.getString("android.intent.extra.TEXT");
                    String strM14323a = C3790i.m14323a(intent.getData());
                    if (TextUtils.isEmpty(strM14323a) || TextUtils.isEmpty(string)) {
                        PluginComposeMessageActivity.m16048c("Recipient(s) and/or message cannot be empty");
                        stopSelf();
                    } else {
                        try {
                            new C4052ac(this, TextUtils.split(strM14323a, Config.KEYVALUE_SPLIT), string, 0L).mo15606a(0L);
                        } catch (Exception e) {
                            C3890m.m14995a("Mms/NoConfirmationSendService", "Failed to send SMS message, threadId=0", e);
                        }
                        stopSelf();
                    }
                }
            }
        }
        return 2;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }
}
