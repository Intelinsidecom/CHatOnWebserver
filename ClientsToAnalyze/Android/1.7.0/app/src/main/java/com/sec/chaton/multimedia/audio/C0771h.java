package com.sec.chaton.multimedia.audio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.sec.chaton.util.C1341p;

/* compiled from: RecordAudio.java */
/* renamed from: com.sec.chaton.multimedia.audio.h */
/* loaded from: classes.dex */
class C0771h extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ RecordAudio f2666a;

    C0771h(RecordAudio recordAudio) {
        this.f2666a = recordAudio;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        C1341p.m4658b("onReceive : " + intent.getAction(), RecordAudio.f2618a);
        if (extras != null) {
            if ("pause".equals(extras.get("command"))) {
                if (!extras.getBoolean("ChatON")) {
                    this.f2666a.m3258m();
                }
            } else if (extras.getBoolean("playing")) {
                this.f2666a.m3258m();
            }
        }
    }
}
