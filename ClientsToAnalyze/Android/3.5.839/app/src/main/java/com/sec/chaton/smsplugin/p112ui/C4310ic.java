package com.sec.chaton.smsplugin.p112ui;

import android.media.MediaPlayer;

/* compiled from: SlideView.java */
/* renamed from: com.sec.chaton.smsplugin.ui.ic */
/* loaded from: classes.dex */
class C4310ic implements MediaPlayer.OnPreparedListener {

    /* renamed from: a */
    final /* synthetic */ SlideView f15703a;

    C4310ic(SlideView slideView) {
        this.f15703a = slideView;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) throws IllegalStateException {
        this.f15703a.f15139i = true;
        if (this.f15703a.f15141k > 0) {
            this.f15703a.f15138h.seekTo(this.f15703a.f15141k);
            this.f15703a.f15141k = 0;
        }
        if (this.f15703a.f15140j) {
            this.f15703a.f15138h.start();
            this.f15703a.f15140j = false;
            this.f15703a.m16217h();
        }
        if (this.f15703a.f15142l) {
            this.f15703a.f15138h.stop();
            this.f15703a.f15138h.release();
            this.f15703a.f15138h = null;
            this.f15703a.f15142l = false;
            this.f15703a.m16218i();
        }
    }
}
