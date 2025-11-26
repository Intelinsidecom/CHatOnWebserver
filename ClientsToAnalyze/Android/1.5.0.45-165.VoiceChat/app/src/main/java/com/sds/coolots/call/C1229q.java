package com.sds.coolots.call;

import android.media.MediaPlayer;

/* renamed from: com.sds.coolots.call.q */
/* loaded from: classes.dex */
class C1229q implements MediaPlayer.OnErrorListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1227o f2864a;

    C1229q(HandlerC1227o handlerC1227o) {
        this.f2864a = handlerC1227o;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) throws Throwable {
        this.f2864a.m2763a("MediaPlayer mMediaPlayerForConnectTone arg1 : " + i + " arg2 : " + i2);
        this.f2864a.f2850G.reset();
        this.f2864a.m2777m();
        return false;
    }
}
