package com.sec.chaton.samsungaccount;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.sec.chaton.util.C3214cb;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.EnumC3215cc;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;

/* compiled from: MainActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.ab */
/* loaded from: classes.dex */
class C2313ab extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ MainActivity f8736a;

    C2313ab(MainActivity mainActivity) {
        this.f8736a = mainActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (C3250y.f11734b) {
            C3250y.m11450b("onReceive : mBackRegiReceiver, bundle : " + extras, this.f8736a.f8672W);
        }
        if (extras != null) {
            if (extras.getString(RtspHeaders.Values.MODE).equals("start")) {
                this.f8736a.m8803t();
                return;
            }
            this.f8736a.m8806u();
            if (C3214cb.m11248a().equals(EnumC3215cc.SUCCESS)) {
                this.f8736a.m8791n();
            }
        }
    }
}
