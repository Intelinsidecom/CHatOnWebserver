package com.sec.vip.amschaton;

import android.media.MediaRecorder;
import java.io.IOException;

/* renamed from: com.sec.vip.amschaton.bo */
/* loaded from: classes.dex */
class C0668bo implements MediaRecorder.OnInfoListener {

    /* renamed from: a */
    final /* synthetic */ BackgroundAudioRecordActivity f4288a;

    C0668bo(BackgroundAudioRecordActivity backgroundAudioRecordActivity) {
        this.f4288a = backgroundAudioRecordActivity;
    }

    @Override // android.media.MediaRecorder.OnInfoListener
    public void onInfo(MediaRecorder mediaRecorder, int i, int i2) throws IllegalStateException, IOException {
        if (i == 800) {
            this.f4288a.m4125k();
            this.f4288a.m4129o();
            this.f4288a.f4096p = false;
            this.f4288a.f4097q = true;
            this.f4288a.f4086a.m4193a(true);
            this.f4288a.f4092C = 120;
            this.f4288a.f4106z.setText(String.format("%d:%02d", Integer.valueOf(this.f4288a.f4092C / 60), Integer.valueOf(this.f4288a.f4092C % 60)));
            this.f4288a.m4112a(false);
        }
    }
}
