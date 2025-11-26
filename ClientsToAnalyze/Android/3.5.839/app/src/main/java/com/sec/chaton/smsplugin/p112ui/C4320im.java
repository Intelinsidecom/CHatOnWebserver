package com.sec.chaton.smsplugin.p112ui;

import android.widget.MediaController;
import com.sec.chaton.smsplugin.p104d.p106b.RunnableC3832m;

/* compiled from: SlideshowActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.im */
/* loaded from: classes.dex */
class C4320im implements MediaController.MediaPlayerControl {

    /* renamed from: a */
    final /* synthetic */ SlideshowActivity f15717a;

    /* renamed from: b */
    private final RunnableC3832m f15718b;

    /* renamed from: c */
    private boolean f15719c = true;

    public C4320im(SlideshowActivity slideshowActivity, RunnableC3832m runnableC3832m) {
        this.f15717a = slideshowActivity;
        this.f15718b = runnableC3832m;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        return 100;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        return this.f15718b.m14585n();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        return this.f15718b.m14584m();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        return this.f15719c;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        this.f15718b.m14577f();
        this.f15719c = false;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.f15718b.m14578g();
        this.f15719c = true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        return 0;
    }
}
