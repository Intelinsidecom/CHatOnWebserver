package com.sec.chaton.buddy;

import android.view.View;
import com.sec.chaton.R;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bc */
/* loaded from: classes.dex */
class ViewOnClickListenerC0545bc implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f2504a;

    ViewOnClickListenerC0545bc(BuddyFragment buddyFragment) {
        this.f2504a = buddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BuddyFragment.f1734m = true;
        switch (view.getId()) {
            case R.id.button_start_chat /* 2131165332 */:
                this.f2504a.m3440e();
                break;
            case R.id.button_broadcast /* 2131165333 */:
                this.f2504a.m3441f();
                break;
            case R.id.button_chatonvoice /* 2131165334 */:
                this.f2504a.m3407t();
                break;
            case R.id.button_chatonvideo /* 2131165335 */:
                this.f2504a.m3408u();
                break;
        }
    }
}
