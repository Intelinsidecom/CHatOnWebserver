package com.sec.chaton.buddy;

import android.view.View;

/* compiled from: BuddyProfileEditNameActivity.java */
/* renamed from: com.sec.chaton.buddy.el */
/* loaded from: classes.dex */
class ViewOnFocusChangeListenerC0674el implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileEditNameActivity f2896a;

    ViewOnFocusChangeListenerC0674el(BuddyProfileEditNameActivity buddyProfileEditNameActivity) {
        this.f2896a = buddyProfileEditNameActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (z) {
            this.f2896a.f2008j = true;
        } else {
            this.f2896a.f2008j = false;
        }
    }
}
