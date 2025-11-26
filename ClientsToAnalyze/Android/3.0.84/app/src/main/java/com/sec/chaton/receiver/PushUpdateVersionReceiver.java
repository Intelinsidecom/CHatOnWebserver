package com.sec.chaton.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.spp.push.Config;

/* loaded from: classes.dex */
public class PushUpdateVersionReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private final String f8071a = PushUpdateVersionReceiver.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context != null) {
            if (intent.getAction().equals(Config.PUSH_VERSION_CHECK)) {
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    String string = extras.getString(Config.COLUMN_CURRENT_VERSION);
                    String string2 = extras.getString(Config.COLUMN_LATEST_VERSION);
                    if (C3250y.f11734b) {
                        C3250y.m11450b("[received SPP update BR] currentVer : " + string + " latestVer : " + string2, this.f8071a);
                    }
                    if (string != null && string2 != null && !string.equals(string2)) {
                        C3159aa.m10963a("spp_update_is", (Boolean) true);
                        C3159aa.m10966a("spp_latest_ver", string2);
                        Intent intent2 = new Intent();
                        intent2.setAction("action_noti_spp_update");
                        context.sendBroadcast(intent2);
                        return;
                    }
                    return;
                }
                if (C3250y.f11734b) {
                    C3250y.m11450b("[received SPP update BR] no version info", this.f8071a);
                    return;
                }
                return;
            }
            if (C3250y.f11734b) {
                C3250y.m11450b("[received SPP update BR] action is NOT available ", this.f8071a);
            }
        }
    }
}
