package com.sds.coolots.call;

import android.media.ToneGenerator;
import com.sds.coolots.MainApplication;

/* renamed from: com.sds.coolots.call.t */
/* loaded from: classes.dex */
class C1232t extends Thread {

    /* renamed from: a */
    final /* synthetic */ HandlerC1227o f2867a;

    /* renamed from: b */
    private final int f2868b;

    C1232t(HandlerC1227o handlerC1227o, int i) {
        this.f2867a = handlerC1227o;
        this.f2868b = i;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            if (this.f2867a.f2852I == null) {
                this.f2867a.f2852I = new ToneGenerator(MainApplication.mNativeSetting.getAudioManagerStreamTTS(), 80);
            }
        } catch (RuntimeException e) {
            this.f2867a.f2852I = null;
        }
        if (this.f2867a.f2852I != null) {
            synchronized (this) {
                try {
                    this.f2867a.f2852I.startTone(this.f2868b, 60000);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
