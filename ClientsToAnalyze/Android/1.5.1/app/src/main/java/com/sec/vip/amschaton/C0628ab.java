package com.sec.vip.amschaton;

import android.widget.SeekBar;

/* renamed from: com.sec.vip.amschaton.ab */
/* loaded from: classes.dex */
class C0628ab implements SeekBar.OnSeekBarChangeListener {

    /* renamed from: a */
    final /* synthetic */ AMSFigureSelectionDialog f4237a;

    C0628ab(AMSFigureSelectionDialog aMSFigureSelectionDialog) {
        this.f4237a = aMSFigureSelectionDialog;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (z) {
            this.f4237a.m3896d(i + 1);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}
