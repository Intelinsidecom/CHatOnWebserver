package com.sec.chaton.multimedia.audio;

import android.widget.SeekBar;
import com.sec.chaton.util.C1341p;

/* compiled from: RecordAudio.java */
/* renamed from: com.sec.chaton.multimedia.audio.o */
/* loaded from: classes.dex */
class C0778o implements SeekBar.OnSeekBarChangeListener {

    /* renamed from: a */
    final /* synthetic */ RecordAudio f2674a;

    C0778o(RecordAudio recordAudio) {
        this.f2674a = recordAudio;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) throws IllegalStateException {
        C1341p.m4659c("onStopTrackingTouch!!!!");
        C1341p.m4659c("seekBar.getProgress():" + seekBar.getProgress());
        if (this.f2674a.f2648u != null) {
            C1341p.m4659c("mediaPlayer.getCurrentPosition():" + this.f2674a.f2648u.getCurrentPosition());
            this.f2674a.f2648u.seekTo(seekBar.getProgress());
        }
        this.f2674a.m3233b();
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) throws IllegalStateException {
        C1341p.m4659c("onStartTrackingTouch!!!!");
        if (this.f2674a.f2648u != null) {
            C1341p.m4659c("onStartTrackingTouch seekBar.getProgress()" + seekBar.getProgress());
            this.f2674a.f2648u.seekTo(seekBar.getProgress());
        }
        this.f2674a.m3233b();
        this.f2674a.f2646s.setPressed(true);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) throws IllegalStateException {
        if (z && this.f2674a.f2648u != null) {
            this.f2674a.f2648u.seekTo(seekBar.getProgress());
            if (seekBar.getProgress() >= this.f2674a.f2648u.getDuration()) {
                this.f2674a.f2646s.setProgress(0);
                this.f2674a.f2646s.setPressed(false);
            }
        }
        this.f2674a.m3233b();
    }
}
