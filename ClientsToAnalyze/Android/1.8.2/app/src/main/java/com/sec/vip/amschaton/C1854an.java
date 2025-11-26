package com.sec.vip.amschaton;

import android.widget.SeekBar;

/* compiled from: AMSToolPenPopup.java */
/* renamed from: com.sec.vip.amschaton.an */
/* loaded from: classes.dex */
class C1854an implements SeekBar.OnSeekBarChangeListener {

    /* renamed from: a */
    final /* synthetic */ C1851ak f6805a;

    C1854an(C1851ak c1851ak) {
        this.f6805a = c1851ak;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (z && i >= 0 && i < 10) {
            this.f6805a.m6431b(i + 1);
            this.f6805a.f6816e.mo6436d_();
        }
    }
}
