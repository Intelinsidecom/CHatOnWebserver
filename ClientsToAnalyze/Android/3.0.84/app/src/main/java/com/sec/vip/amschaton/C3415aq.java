package com.sec.vip.amschaton;

import android.widget.SeekBar;

/* compiled from: AMSToolPenPopup.java */
/* renamed from: com.sec.vip.amschaton.aq */
/* loaded from: classes.dex */
class C3415aq implements SeekBar.OnSeekBarChangeListener {

    /* renamed from: a */
    final /* synthetic */ C3412an f12516a;

    C3415aq(C3412an c3412an) {
        this.f12516a = c3412an;
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
            this.f12516a.m12229b(i + 1);
            this.f12516a.f12527e.mo12235b();
        }
    }
}
