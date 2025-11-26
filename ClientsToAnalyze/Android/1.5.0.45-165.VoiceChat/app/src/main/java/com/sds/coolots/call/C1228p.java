package com.sds.coolots.call;

import android.media.MediaPlayer;

/* renamed from: com.sds.coolots.call.p */
/* loaded from: classes.dex */
class C1228p implements MediaPlayer.OnErrorListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1227o f2863a;

    C1228p(HandlerC1227o handlerC1227o) {
        this.f2863a = handlerC1227o;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) throws Throwable {
        this.f2863a.m2763a("MediaPlayer mMediaPlayerForRingBackTone arg1 : " + i + " arg2 : " + i2);
        this.f2863a.f2849F.reset();
        this.f2863a.m2776l();
        return false;
    }
}
