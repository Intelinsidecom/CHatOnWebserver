package com.sec.widget;

import android.view.View;

/* compiled from: EditTextWithClearButton.java */
/* renamed from: com.sec.widget.k */
/* loaded from: classes.dex */
class ViewOnClickListenerC5168k implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ EditTextWithClearButton f18910a;

    ViewOnClickListenerC5168k(EditTextWithClearButton editTextWithClearButton) {
        this.f18910a = editTextWithClearButton;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f18910a.f18749c.setText("");
        this.f18910a.f18749c.setSoundEffectsEnabled(true);
        this.f18910a.f18749c.playSoundEffect(0);
        this.f18910a.f18749c.requestFocus();
    }
}
