package com.sec.chaton.buddy;

import android.text.TextUtils;
import android.view.View;

/* compiled from: BuddyInfoFragment.java */
/* renamed from: com.sec.chaton.buddy.ef */
/* loaded from: classes.dex */
class ViewOnClickListenerC0668ef implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyInfoFragment f2889a;

    ViewOnClickListenerC0668ef(BuddyInfoFragment buddyInfoFragment) {
        this.f2889a = buddyInfoFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String strReplaceAll;
        if (this.f2889a.f1975e.m3982i() != null && !TextUtils.isEmpty(this.f2889a.f1975e.m3982i()) && (strReplaceAll = this.f2889a.f1975e.m3982i().replaceAll(" ", "")) != null && strReplaceAll.length() >= 5) {
            if (strReplaceAll.length() != 5 && strReplaceAll.length() == 10) {
                strReplaceAll = strReplaceAll.substring(5);
            }
            this.f2889a.m3534c(strReplaceAll);
        }
    }
}
