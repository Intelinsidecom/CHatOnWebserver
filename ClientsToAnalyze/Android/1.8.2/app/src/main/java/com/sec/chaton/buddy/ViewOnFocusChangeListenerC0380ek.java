package com.sec.chaton.buddy;

import android.view.View;

/* compiled from: GroupProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.ek */
/* loaded from: classes.dex */
class ViewOnFocusChangeListenerC0380ek implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ GroupProfileFragment f1538a;

    ViewOnFocusChangeListenerC0380ek(GroupProfileFragment groupProfileFragment) {
        this.f1538a = groupProfileFragment;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (z) {
            this.f1538a.f1228q.setVisibility(8);
            this.f1538a.f1226o.m2037a(true);
        } else {
            this.f1538a.f1226o.m2037a(false);
        }
        this.f1538a.getActivity().invalidateOptionsMenu();
    }
}
