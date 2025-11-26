package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.p025d.C1308au;
import com.sec.chaton.settings.tellfriends.C2733aj;
import com.sec.chaton.settings.tellfriends.C2735al;
import com.sec.chaton.settings.tellfriends.C2737an;
import com.sec.chaton.settings.tellfriends.C2739ap;

/* compiled from: FragmentConnectAccounts.java */
/* renamed from: com.sec.chaton.registration.bo */
/* loaded from: classes.dex */
class ViewOnClickListenerC2164bo implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentConnectAccounts f8449a;

    ViewOnClickListenerC2164bo(FragmentConnectAccounts fragmentConnectAccounts) {
        this.f8449a = fragmentConnectAccounts;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.textSkip) {
            this.f8449a.m8502a();
            if (this.f8449a.f8203j != null) {
                this.f8449a.f8203j = null;
            }
            switch (view.getId()) {
                case R.id.twitter /* 2131165921 */:
                    this.f8449a.f8203j = new C1308au(this.f8449a.f8201h, C2737an.class);
                    break;
                case R.id.facebook /* 2131165922 */:
                    this.f8449a.f8203j = new C1308au(this.f8449a.f8201h, C2733aj.class);
                    break;
                case R.id.sina_weibo /* 2131165923 */:
                    this.f8449a.f8203j = new C1308au(this.f8449a.f8201h, C2739ap.class);
                    break;
                case R.id.renren /* 2131165924 */:
                    this.f8449a.f8203j = new C1308au(this.f8449a.f8201h, C2735al.class);
                    break;
            }
            if (this.f8449a.f8203j != null) {
                this.f8449a.f8203j.m5650a(this.f8449a.f8195b);
                this.f8449a.f8203j.m5648a();
                return;
            }
            return;
        }
        this.f8449a.f8201h.setResult(3, new Intent());
        this.f8449a.f8201h.finish();
    }
}
