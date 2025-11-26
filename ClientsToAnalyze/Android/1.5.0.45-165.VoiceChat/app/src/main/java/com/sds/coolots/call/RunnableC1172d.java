package com.sds.coolots.call;

import android.media.AudioManager;
import android.media.ToneGenerator;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.sds.coolots.MainApplication;

/* renamed from: com.sds.coolots.call.d */
/* loaded from: classes.dex */
class RunnableC1172d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1150c f2402a;

    RunnableC1172d(C1150c c1150c) {
        this.f2402a = c1150c;
    }

    @Override // java.lang.Runnable
    public void run() {
        ToneGenerator toneGenerator;
        try {
            try {
                toneGenerator = new ToneGenerator(0, 90);
            } catch (RuntimeException e) {
                C1134a.m2109b("<CIH> Exception caught while creating ToneGenerator: " + e);
                toneGenerator = null;
            }
            if (this.f2402a.f2354a.f2345l == null) {
                this.f2402a.f2354a.f2345l = (AudioManager) MainApplication.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
            }
            if (toneGenerator != null) {
                this.f2402a.f2354a.f2345l.getRingerMode();
                synchronized (this) {
                    if (this.f2402a.f2354a.f2346m != 1) {
                        this.f2402a.f2354a.f2346m = 2;
                        toneGenerator.startTone(25);
                        try {
                            wait(2000);
                        } catch (InterruptedException e2) {
                            C1134a.m2109b("InCallTonePlayer stopped: " + e2);
                        }
                        toneGenerator.stopTone();
                        toneGenerator.release();
                        this.f2402a.f2354a.f2346m = 0;
                    } else {
                        toneGenerator.release();
                        this.f2402a.f2354a.f2346m = 0;
                    }
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }
}
