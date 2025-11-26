package com.sec.chaton.buddy;

import android.view.View;

/* compiled from: BuddyChatInfoActivity.java */
/* renamed from: com.sec.chaton.buddy.ac */
/* loaded from: classes.dex */
class ViewOnFocusChangeListenerC0261ac implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ BuddyChatInfoActivity f1356a;

    ViewOnFocusChangeListenerC0261ac(BuddyChatInfoActivity buddyChatInfoActivity) {
        this.f1356a = buddyChatInfoActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (z) {
            this.f1356a.f895e.m2037a(true);
        } else {
            this.f1356a.f895e.m2037a(false);
        }
        this.f1356a.invalidateOptionsMenu();
    }
}
