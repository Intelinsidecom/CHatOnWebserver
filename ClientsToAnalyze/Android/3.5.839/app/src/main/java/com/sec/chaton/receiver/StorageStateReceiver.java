package com.sec.chaton.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1045aq;
import com.sec.chaton.C1046ar;
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.util.C4904y;

/* loaded from: classes.dex */
public class StorageStateReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context != null && intent != null) {
            C4904y.m18639b("onReceive : " + intent.getAction(), getClass().getSimpleName());
            if ("android.intent.action.MEDIA_MOUNTED".equals(intent.getAction())) {
                C0991aa.m6037a().m18961c(new C1045aq(intent));
            } else if ("android.intent.action.MEDIA_UNMOUNTED".equals(intent.getAction())) {
                C0991aa.m6037a().m18961c(new C1046ar(intent));
            }
            if (intent.getAction() != null && intent.getAction().equals("android.intent.action.MEDIA_MOUNTED")) {
                C4904y.m18639b("ACTION_MEDIA_MOUNTED deleteFilesDirectory", getClass().getSimpleName());
                context.startService(new Intent(C1427a.f5067e));
            }
        }
    }
}
