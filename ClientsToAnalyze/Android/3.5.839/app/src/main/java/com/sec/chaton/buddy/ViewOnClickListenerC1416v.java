package com.sec.chaton.buddy;

import android.content.res.Resources;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.p067j.C2471v;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.v */
/* loaded from: classes.dex */
class ViewOnClickListenerC1416v implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyFragment f5052a;

    ViewOnClickListenerC1416v(AddBuddyFragment addBuddyFragment) {
        this.f5052a = addBuddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Resources.NotFoundException {
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (-3 == iM10677a || -2 == iM10677a) {
            C5179v.m19810a(this.f5052a.f3528V, R.string.popup_no_network_connection, 0).show();
        } else {
            this.f5052a.m6243a(true);
        }
    }
}
