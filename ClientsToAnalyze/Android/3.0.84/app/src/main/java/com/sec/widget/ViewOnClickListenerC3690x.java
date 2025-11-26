package com.sec.widget;

import android.view.View;
import com.sec.chaton.buddy.BuddyFragment;

/* compiled from: EditTextWithClearButton.java */
/* renamed from: com.sec.widget.x */
/* loaded from: classes.dex */
class ViewOnClickListenerC3690x implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ EditTextWithClearButton f13619a;

    ViewOnClickListenerC3690x(EditTextWithClearButton editTextWithClearButton) {
        this.f13619a = editTextWithClearButton;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f13619a.f13382c.setText("");
        this.f13619a.f13382c.setSoundEffectsEnabled(true);
        this.f13619a.f13382c.playSoundEffect(0);
        this.f13619a.f13382c.requestFocus();
        BuddyFragment.f1731i = true;
    }
}
