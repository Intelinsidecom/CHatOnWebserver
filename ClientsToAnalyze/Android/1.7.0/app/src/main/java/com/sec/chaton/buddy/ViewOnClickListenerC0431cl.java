package com.sec.chaton.buddy;

import android.view.View;
import com.sec.chaton.util.C1346u;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.cl */
/* loaded from: classes.dex */
class ViewOnClickListenerC0431cl implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f1423a;

    ViewOnClickListenerC0431cl(BuddyFragment buddyFragment) {
        this.f1423a = buddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C1346u.m4676a()) {
            this.f1423a.m2084C();
        }
    }
}
