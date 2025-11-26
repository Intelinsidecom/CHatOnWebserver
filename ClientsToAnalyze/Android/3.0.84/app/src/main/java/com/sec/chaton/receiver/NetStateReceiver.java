package com.sec.chaton.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.global.C1493a;
import com.sec.chaton.msgsend.C1759s;
import com.sec.chaton.msgsend.C1766z;
import com.sec.chaton.msgsend.EnumC1764x;
import com.sec.chaton.p037j.C1596x;
import com.sec.chaton.p037j.p040c.C1561g;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3194bi;
import com.sec.chaton.util.C3250y;
import com.sec.common.util.C3347i;
import com.sec.spp.push.Config;

/* loaded from: classes.dex */
public class NetStateReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (C3159aa.m10962a().m10987b("uid") && intent.getAction() != null && "android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            if (C1493a.m6463a("wifi_80_port")) {
                C3159aa.m10962a().m10984b(Config.PROVIDER_PATH_WIFI_PORT, Integer.valueOf(C3194bi.f11542b));
            }
            C3250y.m11450b("NetStateReceiver_onReceive", getClass().getSimpleName());
            C1596x.m6758c();
            if (!C1561g.m6628a().m6636b() && C3250y.f11734b) {
                C3250y.m11450b("NetStateReceiver_onReceive_FileUpload_Cancel_FAILED", getClass().getSimpleName());
            }
            C1759s.m7260a(NetStateReceiver.class.getSimpleName(), "-------------- (EVENT !!) Network Changed --------------", new Object[0]);
            if (C3347i.m11788k()) {
                C1766z.m7268a(context, EnumC1764x.REASON_NETWORK_CHANGED_ON);
            } else {
                C1766z.m7267a(context);
            }
            if (C3250y.f11735c) {
                StringBuilder sb = new StringBuilder();
                sb.append("p#ch@t[Network_State]").append(", Time : ").append(System.currentTimeMillis()).append(", Connected : ").append(C3347i.m11788k()).append(", Network : ").append(C3347i.m11789l());
                C3250y.m11453c(sb.toString(), getClass().getSimpleName());
            }
        }
    }
}
