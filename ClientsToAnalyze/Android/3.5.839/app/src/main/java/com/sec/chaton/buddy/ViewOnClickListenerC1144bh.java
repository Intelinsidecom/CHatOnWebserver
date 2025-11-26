package com.sec.chaton.buddy;

import android.content.res.Resources;
import android.view.View;
import com.sec.common.actionbar.ActionBarFragmentActivity;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bh */
/* loaded from: classes.dex */
class ViewOnClickListenerC1144bh implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4363a;

    ViewOnClickListenerC1144bh(BuddyFragment buddyFragment) {
        this.f4363a = buddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Resources.NotFoundException {
        this.f4363a.m6588a((String) view.getTag(), false, (String) null);
        if (this.f4363a.f3616W != null) {
            if (!this.f4363a.m6334Z() || this.f4363a.f3616W.getVisibility() != 0) {
                this.f4363a.f3616W.setChecked(true);
            } else {
                this.f4363a.f3616W.setChecked(false);
            }
        }
        if (this.f4363a.m6605h() == 0) {
            this.f4363a.m6608k();
        }
        if (this.f4363a.m6605h() > 0) {
            BuddyFragment.f3585k = true;
            if (this.f4363a.f3674bC != null) {
                boolean zM6435aq = this.f4363a.m6435aq();
                if (this.f4363a.f3660ao == 5 || !zM6435aq) {
                    this.f4363a.f3674bC.setEnabled(true);
                } else {
                    this.f4363a.f3674bC.setEnabled(false);
                }
                if (this.f4363a.f3660ao == 1000) {
                    this.f4363a.f3674bC.setEnabled(true);
                }
            }
            this.f4363a.m6534h(true);
        } else {
            BuddyFragment.f3585k = false;
            if (this.f4363a.f3674bC != null) {
                this.f4363a.f3674bC.setEnabled(false);
            }
            this.f4363a.m6526g(true);
        }
        if (this.f4363a.f3660ao == 1) {
            ((ActionBarFragmentActivity) this.f4363a.getActivity()).mo51u_();
        }
        if (this.f4363a.f3641aV != null) {
            this.f4363a.f3641aV.put((String) view.getTag(), (String) view.getTag());
        }
    }
}
