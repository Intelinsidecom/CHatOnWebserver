package com.sec.chaton.multimedia.audio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C1341p;

/* compiled from: RecordAudio.java */
/* renamed from: com.sec.chaton.multimedia.audio.c */
/* loaded from: classes.dex */
class C0766c extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ RecordAudio f2661a;

    C0766c(RecordAudio recordAudio) {
        this.f2661a = recordAudio;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C1341p.m4658b("onReceive : " + intent.getAction(), RecordAudio.f2618a);
        this.f2661a.m3252j();
    }
}
