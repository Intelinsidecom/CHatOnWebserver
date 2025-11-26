package com.sec.chaton.multimedia.audio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C1786r;

/* compiled from: RecordAudio.java */
/* renamed from: com.sec.chaton.multimedia.audio.p */
/* loaded from: classes.dex */
class C0886p extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ RecordAudio f3281a;

    C0886p(RecordAudio recordAudio) {
        this.f3281a = recordAudio;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C1786r.m6061b("onReceive : " + intent.getAction(), RecordAudio.f3221a);
        this.f3281a.m3595j();
    }
}
