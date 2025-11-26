package com.sec.vip.amschaton;

import android.media.MediaPlayer;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.vip.amschaton.t */
/* loaded from: classes.dex */
class C0717t implements MediaPlayer.OnCompletionListener {

    /* renamed from: a */
    final /* synthetic */ Viewer f4351a;

    C0717t(Viewer viewer) {
        this.f4351a = viewer;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        switch (this.f4351a.f4187f) {
            case 5:
                this.f4351a.f4187f = 0;
                if (this.f4351a.f4194m != null) {
                    this.f4351a.f4194m.mo4203a();
                    break;
                }
                break;
            case 6:
            default:
                ChatONLogWriter.m3499a("Audio Player done... - " + this.f4351a.f4187f, getClass().getSimpleName());
                break;
            case 7:
                this.f4351a.f4187f = 3;
                break;
        }
    }
}
