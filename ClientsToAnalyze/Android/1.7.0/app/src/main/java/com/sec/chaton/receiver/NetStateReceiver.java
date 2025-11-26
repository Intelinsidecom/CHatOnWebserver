package com.sec.chaton.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.p018c.C0477ab;
import com.sec.chaton.p018c.p019a.C0468e;
import com.sec.chaton.util.C1341p;

/* loaded from: classes.dex */
public class NetStateReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() != null && "android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            C1341p.m4658b("NetStateReceiver_onReceive", getClass().getSimpleName());
            C0477ab.m2449c();
            if (!C0468e.m2389a().m2394b() && C1341p.f4578b) {
                C1341p.m4658b("NetStateReceiver_onReceive_FileUpload_Cancel_FAILED", getClass().getSimpleName());
            }
        }
    }
}
