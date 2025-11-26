package com.sds.coolots.call;

import android.media.MediaPlayer;

/* renamed from: com.sds.coolots.call.s */
/* loaded from: classes.dex */
class C1231s implements MediaPlayer.OnErrorListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1227o f2866a;

    C1231s(HandlerC1227o handlerC1227o) {
        this.f2866a = handlerC1227o;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) throws Throwable {
        this.f2866a.m2763a("MediaPlayer mMediaPlayerForHoldTone arg1 : " + i + " arg2 : " + i2);
        this.f2866a.f2848E.reset();
        this.f2866a.m2781q();
        return false;
    }
}
