package com.sec.vip.amschaton;

import android.media.MediaPlayer;

/* renamed from: com.sec.vip.amschaton.u */
/* loaded from: classes.dex */
class C0718u implements MediaPlayer.OnPreparedListener {

    /* renamed from: a */
    final /* synthetic */ Viewer f4352a;

    C0718u(Viewer viewer) {
        this.f4352a = viewer;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        this.f4352a.f4193l = true;
    }
}
