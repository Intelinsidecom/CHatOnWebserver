package com.sec.chaton.buddy;

import android.content.res.Resources;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.dm */
/* loaded from: classes.dex */
class ViewOnClickListenerC1252dm implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4754a;

    ViewOnClickListenerC1252dm(BuddyFragment buddyFragment) {
        this.f4754a = buddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Resources.NotFoundException {
        BuddyFragment.f3586l = true;
        switch (view.getId()) {
            case R.id.button_start_chat /* 2131165328 */:
                this.f4754a.m6601d();
                break;
            case R.id.button_broadcast /* 2131165330 */:
                this.f4754a.m6602e();
                break;
            case R.id.button_chatonvoice /* 2131165331 */:
                this.f4754a.m6494d(R.id.button_chatonvoice);
                if (BuddyFragment.f3586l && this.f4754a.f3660ao == 1) {
                    this.f4754a.m6595b(true);
                    BuddyFragment.f3586l = false;
                    break;
                }
                break;
            case R.id.button_chatonvideo /* 2131165332 */:
                this.f4754a.m6506e(R.id.button_chatonvideo);
                if (BuddyFragment.f3586l && this.f4754a.f3660ao == 1) {
                    this.f4754a.m6595b(true);
                    BuddyFragment.f3586l = false;
                    break;
                }
                break;
        }
    }
}
