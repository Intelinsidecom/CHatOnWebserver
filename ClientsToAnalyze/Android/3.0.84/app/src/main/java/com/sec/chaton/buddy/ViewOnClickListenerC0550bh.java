package com.sec.chaton.buddy;

import android.view.View;
import com.sec.chaton.global.GlobalApplication;
import com.sec.common.actionbar.ActionBarFragmentActivity;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bh */
/* loaded from: classes.dex */
class ViewOnClickListenerC0550bh implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f2509a;

    ViewOnClickListenerC0550bh(BuddyFragment buddyFragment) {
        this.f2509a = buddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2509a.m3428a((String) view.getTag(), false, (String) null);
        if (this.f2509a.m3444i() == 0) {
            this.f2509a.m3447l();
        }
        if (this.f2509a.m3444i() > 0) {
            BuddyFragment.f1733l = true;
            if (this.f2509a.f1855bq != null) {
                this.f2509a.f1855bq.setEnabled(true);
            }
        } else {
            BuddyFragment.f1733l = false;
            if (this.f2509a.f1855bq != null) {
                this.f2509a.f1855bq.setEnabled(false);
            }
        }
        if (this.f2509a.f1791ac == 1) {
            ((ActionBarFragmentActivity) this.f2509a.getActivity()).supportInvalidateOptionsMenu();
        }
        if (this.f2509a.f1771aI != null) {
            this.f2509a.f1771aI.put((String) view.getTag(), (String) view.getTag());
        }
        if (GlobalApplication.m6456e() && this.f2509a.f1791ac == 1) {
            if (this.f2509a.f1843bd.getVisibility() == 0 || this.f2509a.f1845bf.getVisibility() == 0) {
                this.f2509a.f1820bF.setVisibility(0);
            } else {
                this.f2509a.f1820bF.setVisibility(8);
            }
        }
    }
}
