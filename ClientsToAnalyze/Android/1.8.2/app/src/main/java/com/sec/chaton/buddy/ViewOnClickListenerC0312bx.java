package com.sec.chaton.buddy;

import android.view.View;

/* compiled from: BuddyGroupEditActivity.java */
/* renamed from: com.sec.chaton.buddy.bx */
/* loaded from: classes.dex */
class ViewOnClickListenerC0312bx implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupEditActivity f1431a;

    ViewOnClickListenerC0312bx(BuddyGroupEditActivity buddyGroupEditActivity) {
        this.f1431a = buddyGroupEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        view.setVisibility(8);
        this.f1431a.f1040H.setVisibility(0);
        this.f1431a.f1063p.addTextChangedListener(this.f1431a.f1051S);
        this.f1431a.f1063p.setText(this.f1431a.f1057j.m2316b());
        this.f1431a.f1063p.requestFocus();
        this.f1431a.m2078b(this.f1431a.f1063p);
    }
}
