package com.sec.chaton.buddy;

import android.content.res.Resources;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p050a.C1106c;
import java.util.ArrayList;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bb */
/* loaded from: classes.dex */
class ViewOnClickListenerC1138bb implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4356a;

    ViewOnClickListenerC1138bb(BuddyFragment buddyFragment) {
        this.f4356a = buddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Resources.NotFoundException {
        BuddyFragment.f3586l = true;
        switch (view.getId()) {
            case R.id.button_start_chat /* 2131165328 */:
                this.f4356a.m6601d();
                break;
            case R.id.button_sms /* 2131165329 */:
                this.f4356a.m6598c(false);
                break;
            case R.id.button_broadcast /* 2131165330 */:
                this.f4356a.m6602e();
                break;
            case R.id.button_chatonvoice /* 2131165331 */:
                this.f4356a.m6494d(R.id.button_chatonvoice);
                if (this.f4356a.f3660ao == 1) {
                    this.f4356a.m6595b(true);
                    BuddyFragment.f3586l = false;
                    break;
                }
                break;
            case R.id.button_chatonvideo /* 2131165332 */:
                this.f4356a.m6506e(R.id.button_chatonvideo);
                if (this.f4356a.f3660ao == 1) {
                    this.f4356a.m6595b(true);
                    BuddyFragment.f3586l = false;
                    break;
                }
                break;
            case R.id.button_call /* 2131165333 */:
                if (this.f4356a.m6604g().length != 0) {
                    this.f4356a.m6498d(this.f4356a.m6341a(this.f4356a.m6604g()[0], (ArrayList<ArrayList<C1106c>>) this.f4356a.f3666au));
                    break;
                }
                break;
        }
    }
}
