package com.sec.chaton.multimedia.audio;

import android.widget.SeekBar;
import com.sec.chaton.util.C1786r;

/* compiled from: RecordAudio.java */
/* renamed from: com.sec.chaton.multimedia.audio.v */
/* loaded from: classes.dex */
class C0892v implements SeekBar.OnSeekBarChangeListener {

    /* renamed from: a */
    final /* synthetic */ RecordAudio f3287a;

    C0892v(RecordAudio recordAudio) {
        this.f3287a = recordAudio;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) throws IllegalStateException {
        C1786r.m6064d("onStopTrackingTouch!!!!");
        C1786r.m6064d("seekBar.getProgress():" + seekBar.getProgress());
        C1786r.m6064d("seekBar.getProgress():" + seekBar.getProgress());
        C1786r.m6064d("mediaPlayer.getCurrentPosition():" + this.f3287a.f3251u.getCurrentPosition());
        this.f3287a.f3251u.seekTo(seekBar.getProgress());
        this.f3287a.m3575b();
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) throws IllegalStateException {
        C1786r.m6064d("onStartTrackingTouch!!!!");
        C1786r.m6064d("onStartTrackingTouch seekBar.getProgress()" + seekBar.getProgress());
        this.f3287a.f3251u.seekTo(seekBar.getProgress());
        this.f3287a.m3575b();
        this.f3287a.f3249s.setPressed(true);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) throws IllegalStateException {
        if (z) {
            this.f3287a.f3251u.seekTo(seekBar.getProgress());
            if (seekBar.getProgress() >= this.f3287a.f3251u.getDuration()) {
                this.f3287a.f3249s.setProgress(0);
                this.f3287a.f3249s.setPressed(false);
            }
        }
        this.f3287a.m3575b();
    }
}
