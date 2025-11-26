package com.sec.chaton.buddy;

import android.view.View;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ab */
/* loaded from: classes.dex */
class ViewOnClickListenerC1111ab implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyFragment f4277a;

    ViewOnClickListenerC1111ab(AddBuddyFragment addBuddyFragment) {
        this.f4277a = addBuddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f4277a.f3514H != null) {
            this.f4277a.f3514H.removeAllViews();
        }
    }
}
