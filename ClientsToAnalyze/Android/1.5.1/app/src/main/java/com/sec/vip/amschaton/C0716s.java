package com.sec.vip.amschaton;

import android.media.MediaPlayer;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.vip.amschaton.s */
/* loaded from: classes.dex */
class C0716s implements MediaPlayer.OnCompletionListener {

    /* renamed from: a */
    final /* synthetic */ Viewer f4350a;

    C0716s(Viewer viewer) {
        this.f4350a = viewer;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        switch (this.f4350a.f4187f) {
            case 5:
                this.f4350a.f4187f = 0;
                if (this.f4350a.f4194m != null) {
                    this.f4350a.f4194m.mo4203a();
                    break;
                }
                break;
            case 6:
            default:
                ChatONLogWriter.m3499a("Audio Player done... - " + this.f4350a.f4187f, getClass().getSimpleName());
                break;
            case 7:
                this.f4350a.f4187f = 3;
                break;
        }
    }
}
