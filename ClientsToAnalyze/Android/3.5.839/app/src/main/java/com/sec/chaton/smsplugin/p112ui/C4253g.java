package com.sec.chaton.smsplugin.p112ui;

import android.media.MediaPlayer;

/* compiled from: AudioAttachmentView.java */
/* renamed from: com.sec.chaton.smsplugin.ui.g */
/* loaded from: classes.dex */
class C4253g implements MediaPlayer.OnErrorListener {

    /* renamed from: a */
    final /* synthetic */ AudioAttachmentView f15613a;

    C4253g(AudioAttachmentView audioAttachmentView) {
        this.f15613a = audioAttachmentView;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        this.f15613a.m15726h();
        return true;
    }
}
