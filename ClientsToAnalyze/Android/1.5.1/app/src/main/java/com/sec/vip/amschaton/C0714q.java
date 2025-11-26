package com.sec.vip.amschaton;

import android.media.MediaPlayer;

/* renamed from: com.sec.vip.amschaton.q */
/* loaded from: classes.dex */
class C0714q implements MediaPlayer.OnPreparedListener {

    /* renamed from: a */
    final /* synthetic */ Viewer f4349a;

    C0714q(Viewer viewer) {
        this.f4349a = viewer;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        this.f4349a.f4193l = true;
    }
}
