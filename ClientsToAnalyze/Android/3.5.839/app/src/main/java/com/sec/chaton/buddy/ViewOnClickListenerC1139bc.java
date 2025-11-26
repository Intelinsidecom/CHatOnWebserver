package com.sec.chaton.buddy;

import android.view.View;
import com.sec.chaton.R;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bc */
/* loaded from: classes.dex */
class ViewOnClickListenerC1139bc implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4357a;

    ViewOnClickListenerC1139bc(BuddyFragment buddyFragment) {
        this.f4357a = buddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_start_chat /* 2131165328 */:
                this.f4357a.m6601d();
                break;
            case R.id.button_broadcast /* 2131165330 */:
                this.f4357a.m6602e();
                break;
        }
    }
}
