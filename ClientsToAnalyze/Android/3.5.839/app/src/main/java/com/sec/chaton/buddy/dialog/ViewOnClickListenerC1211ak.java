package com.sec.chaton.buddy.dialog;

import android.view.View;

/* compiled from: SpecialBuddyDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.ak */
/* loaded from: classes.dex */
class ViewOnClickListenerC1211ak implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyDialog f4706a;

    ViewOnClickListenerC1211ak(SpecialBuddyDialog specialBuddyDialog) {
        this.f4706a = specialBuddyDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        view.sendAccessibilityEvent(8);
    }
}
