package com.sec.chaton.smsplugin.p112ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.spp.push.dlc.api.IDlcApi;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.dd */
/* loaded from: classes.dex */
class C4176dd extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ PluginComposeMessageActivity f15498a;

    C4176dd(PluginComposeMessageActivity pluginComposeMessageActivity) {
        this.f15498a = pluginComposeMessageActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("com.sec.chaton.smsplugin.PROGRESS_STATUS".equals(intent.getAction()) && intent.getLongExtra("token", -1L) == this.f15498a.f14935G.m14359d()) {
            int intExtra = intent.getIntExtra("progress", 0);
            switch (intExtra) {
                case IDlcApi.RC_SVC_UNAVAILABLE /* -2 */:
                case 100:
                    this.f15498a.setProgressBarVisibility(false);
                    break;
                case -1:
                    this.f15498a.setProgressBarVisibility(true);
                    break;
                default:
                    this.f15498a.setProgress(intExtra * 100);
                    break;
            }
        }
    }
}
