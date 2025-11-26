package com.sec.chaton.multimedia.audio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.sec.chaton.util.C1786r;

/* compiled from: RecordAudio.java */
/* renamed from: com.sec.chaton.multimedia.audio.q */
/* loaded from: classes.dex */
class C0887q extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ RecordAudio f3282a;

    C0887q(RecordAudio recordAudio) {
        this.f3282a = recordAudio;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        C1786r.m6061b("onReceive : " + intent.getAction(), RecordAudio.f3221a);
        if (extras != null) {
            if ("pause".equals(extras.get("command"))) {
                if (!extras.getBoolean("ChatON")) {
                    this.f3282a.m3600m();
                }
            } else if (extras.getBoolean("playing")) {
                this.f3282a.m3600m();
            }
        }
    }
}
