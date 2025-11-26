package com.sec.chaton.buddy;

import android.view.View;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.aa */
/* loaded from: classes.dex */
class ViewOnClickListenerC1110aa implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyFragment f4276a;

    ViewOnClickListenerC1110aa(AddBuddyFragment addBuddyFragment) {
        this.f4276a = addBuddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f4276a.f3514H != null) {
            this.f4276a.f3514H.removeAllViews();
        }
    }
}
