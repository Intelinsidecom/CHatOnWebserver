package com.sec.chaton.multimedia.audio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C3250y;

/* compiled from: RecordVoiceTask.java */
/* renamed from: com.sec.chaton.multimedia.audio.m */
/* loaded from: classes.dex */
class C1781m extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ AsyncTaskC1779k f6607a;

    C1781m(AsyncTaskC1779k asyncTaskC1779k) {
        this.f6607a = asyncTaskC1779k;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (C3250y.f11734b) {
            C3250y.m11450b("onReceive : " + intent.getAction(), AsyncTaskC1779k.f6587a);
        }
        this.f6607a.m7357d();
    }
}
