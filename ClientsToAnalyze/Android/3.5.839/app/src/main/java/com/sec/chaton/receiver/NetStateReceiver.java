package com.sec.chaton.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1010ai;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.msgsend.C2684ab;
import com.sec.chaton.msgsend.C2691ai;
import com.sec.chaton.msgsend.EnumC2689ag;
import com.sec.chaton.p067j.C2417af;
import com.sec.chaton.p067j.p070c.C2438e;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4844bi;
import com.sec.chaton.util.C4904y;
import com.sec.common.util.C5034k;
import com.sec.spp.push.Config;

/* loaded from: classes.dex */
public class NetStateReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (C4809aa.m18104a().m18129b("uid") && intent.getAction() != null && "android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            if (C2349a.m10301a("wifi_80_port")) {
                C4809aa.m18104a().m18126b(Config.PROVIDER_PATH_WIFI_PORT, Integer.valueOf(C4844bi.f17657b));
            }
            C4904y.m18639b("NetStateReceiver_onReceive", getClass().getSimpleName());
            C2417af.m10456c();
            if (!C2438e.m10572a().m10580b() && C4904y.f17872b) {
                C4904y.m18639b("NetStateReceiver_onReceive_FileUpload_Cancel_FAILED", getClass().getSimpleName());
            }
            C2684ab.m11290a(NetStateReceiver.class.getSimpleName(), "-------------- (EVENT !!) Network Changed --------------", new Object[0]);
            if (C5034k.m19106k()) {
                C2691ai.m11298a(context, EnumC2689ag.REASON_NETWORK_CHANGED_ON);
            } else {
                C2691ai.m11297a(context);
            }
            C0991aa.m6037a().m18961c(new C1010ai(intent));
            if (C4904y.f17873c) {
                StringBuilder sb = new StringBuilder();
                sb.append("p#ch@t[Network_State]").append(", Time : ").append(System.currentTimeMillis()).append(", Connected : ").append(C5034k.m19106k()).append(", Network : ").append(C5034k.m19107l());
                C4904y.m18641c(sb.toString(), getClass().getSimpleName());
            }
        }
    }
}
