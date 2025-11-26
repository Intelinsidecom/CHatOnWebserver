package com.sec.chaton.buddy;

import android.view.View;
import com.sec.chaton.util.C1786r;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.az */
/* loaded from: classes.dex */
class ViewOnClickListenerC0284az implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f1381a;

    ViewOnClickListenerC0284az(BuddyFragment buddyFragment) {
        this.f1381a = buddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C1786r.m6067f("mButtonClickListener():buddy_choice_select_member_panel : " + ((String) view.getTag()), BuddyFragment.f908a);
        this.f1381a.f980aq.m2456a((String) view.getTag(), false);
        this.f1381a.m2041b((String) view.getTag());
        this.f1381a.m2056m();
        this.f1381a.f1021w.invalidateViews();
    }
}
