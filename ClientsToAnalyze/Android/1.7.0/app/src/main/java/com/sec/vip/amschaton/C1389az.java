package com.sec.vip.amschaton;

import android.widget.SeekBar;

/* compiled from: AMSToolPenPopup.java */
/* renamed from: com.sec.vip.amschaton.az */
/* loaded from: classes.dex */
class C1389az implements SeekBar.OnSeekBarChangeListener {

    /* renamed from: a */
    final /* synthetic */ C1369af f4881a;

    C1389az(C1369af c1369af) {
        this.f4881a = c1369af;
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
            this.f4881a.m4920b(i + 1);
            this.f4881a.f5418d.mo4927b();
        }
    }
}
