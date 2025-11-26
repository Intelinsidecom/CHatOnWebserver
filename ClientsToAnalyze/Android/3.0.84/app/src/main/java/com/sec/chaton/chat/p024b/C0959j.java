package com.sec.chaton.chat.p024b;

import android.speech.tts.TextToSpeech;
import com.sec.chaton.util.C3250y;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: TTSSpeakEngine.java */
/* renamed from: com.sec.chaton.chat.b.j */
/* loaded from: classes.dex */
final class C0959j implements TextToSpeech.OnInitListener {
    C0959j() {
    }

    @Override // android.speech.tts.TextToSpeech.OnInitListener
    public void onInit(int i) {
        if (i != 0) {
            boolean unused = C0958i.f3944d = false;
            if (C3250y.f11735c) {
                C3250y.m11453c("listener - init fail!", "TTSSpeakEngine");
            }
        } else {
            if (C3250y.f11735c) {
                C3250y.m11453c("listener - init success!", "TTSSpeakEngine");
            }
            boolean unused2 = C0958i.f3944d = true;
            Timer unused3 = C0958i.f3946f = new Timer();
            TimerTask unused4 = C0958i.f3948h = new C0960k(this);
            C0958i.f3946f.schedule(C0958i.f3948h, new Date(), 300L);
        }
        boolean unused5 = C0958i.f3943c = false;
        if (C3250y.f11735c) {
            C3250y.m11453c("listener - status : " + i + ", isInitInProgress : " + C0958i.f3943c + ", isInitSuccess : " + C0958i.f3944d, "TTSSpeakEngine");
        }
    }
}
