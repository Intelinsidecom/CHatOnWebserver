package com.sec.chaton.buddy;

import android.view.View;
import com.sec.chaton.R;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ck */
/* loaded from: classes.dex */
class ViewOnClickListenerC0430ck implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f1422a;

    ViewOnClickListenerC0430ck(BuddyFragment buddyFragment) {
        this.f1422a = buddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_start_chat /* 2131427523 */:
                this.f1422a.m2188y();
                break;
            case R.id.button_broadcast /* 2131427524 */:
                this.f1422a.m2191z();
                break;
        }
    }
}
