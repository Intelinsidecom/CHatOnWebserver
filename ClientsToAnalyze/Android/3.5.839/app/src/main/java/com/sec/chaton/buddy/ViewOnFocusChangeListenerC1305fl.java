package com.sec.chaton.buddy;

import android.view.View;

/* compiled from: BuddyProfileEditNameActivity.java */
/* renamed from: com.sec.chaton.buddy.fl */
/* loaded from: classes.dex */
class ViewOnFocusChangeListenerC1305fl implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileEditNameActivity f4841a;

    ViewOnFocusChangeListenerC1305fl(BuddyProfileEditNameActivity buddyProfileEditNameActivity) {
        this.f4841a = buddyProfileEditNameActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (z) {
            this.f4841a.f3902w = true;
        } else {
            this.f4841a.f3902w = false;
        }
    }
}
