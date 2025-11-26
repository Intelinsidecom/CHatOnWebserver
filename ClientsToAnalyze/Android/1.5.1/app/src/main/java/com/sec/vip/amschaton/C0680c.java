package com.sec.vip.amschaton;

import android.widget.SeekBar;

/* renamed from: com.sec.vip.amschaton.c */
/* loaded from: classes.dex */
class C0680c implements SeekBar.OnSeekBarChangeListener {

    /* renamed from: a */
    final /* synthetic */ AMSPenSelectionDialog f4301a;

    C0680c(AMSPenSelectionDialog aMSPenSelectionDialog) {
        this.f4301a = aMSPenSelectionDialog;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (z) {
            this.f4301a.m3996e(i + 1);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}
