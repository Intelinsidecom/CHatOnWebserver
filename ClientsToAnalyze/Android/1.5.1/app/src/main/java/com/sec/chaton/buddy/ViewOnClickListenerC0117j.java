package com.sec.chaton.buddy;

import android.view.View;

/* renamed from: com.sec.chaton.buddy.j */
/* loaded from: classes.dex */
class ViewOnClickListenerC0117j implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupEditActivity f697a;

    ViewOnClickListenerC0117j(BuddyGroupEditActivity buddyGroupEditActivity) {
        this.f697a = buddyGroupEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        view.setVisibility(8);
        this.f697a.f492E.setVisibility(0);
        this.f697a.f515m.addTextChangedListener(this.f697a.f503P);
        this.f697a.f515m.setText(this.f697a.f509g.m666b());
        this.f697a.f515m.requestFocus();
        this.f697a.m556b(this.f697a.f515m);
    }
}
