package com.sec.chaton.smsplugin.p112ui;

import android.media.MediaPlayer;

/* compiled from: AudioAttachmentView.java */
/* renamed from: com.sec.chaton.smsplugin.ui.f */
/* loaded from: classes.dex */
class C4226f implements MediaPlayer.OnCompletionListener {

    /* renamed from: a */
    final /* synthetic */ AudioAttachmentView f15577a;

    C4226f(AudioAttachmentView audioAttachmentView) {
        this.f15577a = audioAttachmentView;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f15577a.mo15732c();
    }
}
