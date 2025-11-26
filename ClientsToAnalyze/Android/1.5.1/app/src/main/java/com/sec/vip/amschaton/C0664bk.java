package com.sec.vip.amschaton;

import android.widget.SeekBar;

/* renamed from: com.sec.vip.amschaton.bk */
/* loaded from: classes.dex */
class C0664bk implements SeekBar.OnSeekBarChangeListener {

    /* renamed from: a */
    final /* synthetic */ AMSEraserSelectionDialog f4284a;

    C0664bk(AMSEraserSelectionDialog aMSEraserSelectionDialog) {
        this.f4284a = aMSEraserSelectionDialog;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (z) {
            this.f4284a.m3872a((i + 1) / 2);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}
