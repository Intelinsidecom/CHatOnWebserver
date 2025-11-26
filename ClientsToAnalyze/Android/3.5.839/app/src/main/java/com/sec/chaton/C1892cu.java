package com.sec.chaton;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.buddy.BuddyFragment;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.cu */
/* loaded from: classes.dex */
class C1892cu extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ TabActivity f7109a;

    C1892cu(TabActivity tabActivity) {
        this.f7109a = tabActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (!this.f7109a.f2044M) {
            if (this.f7109a.f2047P) {
                boolean zBooleanValue = C4809aa.m18104a().m18119a("chatonv_critical_update", (Boolean) false).booleanValue();
                if (C4904y.f17872b) {
                    C4904y.m18639b("Receiver : updateChatONV, Critical is " + zBooleanValue, TabActivity.f2029t);
                }
                this.f7109a.m3031b(zBooleanValue);
            }
            if (this.f7109a.f2048Q) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("Receiver : updateSPP", TabActivity.f2029t);
                }
                Intent intent2 = new Intent(this.f7109a, (Class<?>) NewSPPUpgradeDialog.class);
                intent2.putExtra("isCritical", false);
                intent2.putExtra("isFromHome", true);
                this.f7109a.startActivity(intent2);
            }
            if (this.f7109a.f2049R) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("Receiver : updateDisclaimer\n VersionInfo : " + this.f7109a.f2043L, TabActivity.f2029t);
                }
                if (this.f7109a.f2043L.disclaimerUID != null) {
                    this.f7109a.m3030b(this.f7109a.f2043L.disclaimerUID);
                }
            }
            if (this.f7109a.f2046O) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("Receiver : updateChatON\n VersionInfo : " + this.f7109a.f2043L, TabActivity.f2029t);
                }
                C4822an.m18213a(this.f7109a.f2043L, this.f7109a, true, C4809aa.m18104a().m18121a("UpdateAppsReady", "NO"));
            }
            this.f7109a.m3005I();
            C4904y.m18639b("Receiver : update lock state : " + this.f7109a.f2043L, TabActivity.f2029t);
            BuddyFragment.f3593s = true;
            return;
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("Password Lock Receiver : Activity was destroyed ", TabActivity.f2029t);
        }
    }
}
