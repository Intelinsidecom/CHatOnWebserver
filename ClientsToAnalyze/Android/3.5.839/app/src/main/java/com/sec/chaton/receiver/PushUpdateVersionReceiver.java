package com.sec.chaton.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.spp.push.Config;

/* loaded from: classes.dex */
public class PushUpdateVersionReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private final String f11524a = PushUpdateVersionReceiver.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context != null && intent != null && intent.getAction() != null) {
            if (intent.getAction().equals(Config.PUSH_VERSION_CHECK)) {
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    String string = extras.getString(Config.COLUMN_CURRENT_VERSION);
                    String string2 = extras.getString(Config.COLUMN_LATEST_VERSION);
                    if (C4904y.f17872b) {
                        C4904y.m18639b("[received SPP update BR] currentVer : " + string + " latestVer : " + string2, this.f11524a);
                    }
                    if (string != null && string2 != null && !string.equals(string2)) {
                        C4809aa.m18105a("spp_update_is", (Boolean) true);
                        C4809aa.m18108a("spp_latest_ver", string2);
                        Intent intent2 = new Intent();
                        intent2.setAction("action_noti_spp_update");
                        context.sendBroadcast(intent2);
                        return;
                    }
                    return;
                }
                if (C4904y.f17872b) {
                    C4904y.m18639b("[received SPP update BR] no version info", this.f11524a);
                    return;
                }
                return;
            }
            if (C4904y.f17872b) {
                C4904y.m18639b("[received SPP update BR] action is NOT available ", this.f11524a);
            }
        }
    }
}
