package com.sec.chaton;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3250y;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.ao */
/* loaded from: classes.dex */
class C0437ao extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ TabActivity f1499a;

    C0437ao(TabActivity tabActivity) {
        this.f1499a = tabActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.f1499a.f746M) {
            boolean zBooleanValue = C3159aa.m10962a().m10977a("chatonv_critical_update", (Boolean) false).booleanValue();
            if (C3250y.f11734b) {
                C3250y.m11450b("Receiver : updateChatONV, Critical is " + zBooleanValue, TabActivity.f732f);
            }
            this.f1499a.m1251b(zBooleanValue);
        }
        if (this.f1499a.f747N) {
            if (C3250y.f11734b) {
                C3250y.m11450b("Receiver : updateSPP", TabActivity.f732f);
            }
            Intent intent2 = new Intent(this.f1499a, (Class<?>) NewSPPUpgradeDialog.class);
            intent2.putExtra("isCritical", false);
            intent2.putExtra("isFromHome", true);
            this.f1499a.startActivity(intent2);
        }
        if (this.f1499a.f748O) {
            if (C3250y.f11734b) {
                C3250y.m11450b("Receiver : updateDisclaimer\n VersionInfo : " + this.f1499a.f801y, TabActivity.f732f);
            }
            if (this.f1499a.f801y.disclaimerUID != null) {
                this.f1499a.m1242a(this.f1499a.f801y.disclaimerUID);
            }
        }
        if (this.f1499a.f745L) {
            if (C3250y.f11734b) {
                C3250y.m11450b("Receiver : updateChatON\n VersionInfo : " + this.f1499a.f801y, TabActivity.f732f);
            }
            C3171am.m11049a(this.f1499a.f801y, this.f1499a, true, C3159aa.m10962a().m10979a("UpdateAppsReady", "NO"));
        }
        this.f1499a.m1202E();
    }
}
