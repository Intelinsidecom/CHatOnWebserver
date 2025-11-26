package com.sec.chaton.buddy;

import android.view.View;
import com.sec.chaton.R;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bd */
/* loaded from: classes.dex */
class ViewOnClickListenerC0546bd implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f2505a;

    ViewOnClickListenerC0546bd(BuddyFragment buddyFragment) {
        this.f2505a = buddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_start_chat /* 2131165332 */:
                this.f2505a.m3440e();
                break;
            case R.id.button_broadcast /* 2131165333 */:
                this.f2505a.m3441f();
                break;
        }
    }
}
