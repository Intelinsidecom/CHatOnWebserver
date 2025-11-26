package com.sec.chaton.chat.translate;

import android.speech.tts.TextToSpeech;
import com.sec.chaton.util.C4904y;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: TTSSpeakEngine.java */
/* renamed from: com.sec.chaton.chat.translate.j */
/* loaded from: classes.dex */
final class C1857j implements TextToSpeech.OnInitListener {
    C1857j() {
    }

    @Override // android.speech.tts.TextToSpeech.OnInitListener
    public void onInit(int i) {
        if (i != 0) {
            boolean unused = C1856i.f7055d = false;
            if (C4904y.f17873c) {
                C4904y.m18641c("listener - init fail!", "TTSSpeakEngine");
            }
        } else {
            if (C4904y.f17873c) {
                C4904y.m18641c("listener - init success!", "TTSSpeakEngine");
            }
            boolean unused2 = C1856i.f7055d = true;
            Timer unused3 = C1856i.f7057f = new Timer();
            TimerTask unused4 = C1856i.f7061j = new C1858k(this);
            C1856i.f7057f.schedule(C1856i.f7061j, new Date(), 300L);
            if (C1856i.f7059h != null) {
                C1856i.f7059h.invalidateViews();
            }
        }
        boolean unused5 = C1856i.f7054c = false;
        if (C4904y.f17873c) {
            C4904y.m18641c("listener - status : " + i + ", isInitInProgress : " + C1856i.f7054c + ", isInitSuccess : " + C1856i.f7055d, "TTSSpeakEngine");
        }
    }
}
