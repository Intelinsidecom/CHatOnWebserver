package com.sds.coolots.call;

import android.media.MediaPlayer;

/* renamed from: com.sds.coolots.call.r */
/* loaded from: classes.dex */
class C1230r implements MediaPlayer.OnErrorListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1227o f2865a;

    C1230r(HandlerC1227o handlerC1227o) {
        this.f2865a = handlerC1227o;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) throws Throwable {
        this.f2865a.m2763a("MediaPlayer mMediaPlayerForDisconnectTone arg1 : " + i + " arg2 : " + i2);
        this.f2865a.f2851H.reset();
        this.f2865a.m2778n();
        return false;
    }
}
