package com.sec.chaton;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.motion.MotionRecognitionManager;
import com.sec.chaton.util.C4904y;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.ds */
/* loaded from: classes.dex */
class C2164ds extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ TabActivity f7793a;

    C2164ds(TabActivity tabActivity) {
        this.f7793a = tabActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (C4904y.f17872b) {
            C4904y.m18639b("received Update Push Version", TabActivity.f2029t);
        }
        if (!this.f7793a.m3004H()) {
            if (!this.f7793a.f2044M) {
                Intent intent2 = new Intent(this.f7793a, (Class<?>) NewSPPUpgradeDialog.class);
                intent2.putExtra("isCritical", false);
                intent2.putExtra("isFromHome", true);
                intent2.setFlags(MotionRecognitionManager.EVENT_OVER_TURN_LOW_POWER);
                this.f7793a.startActivity(intent2);
                return;
            }
            return;
        }
        this.f7793a.f2048Q = true;
    }
}
