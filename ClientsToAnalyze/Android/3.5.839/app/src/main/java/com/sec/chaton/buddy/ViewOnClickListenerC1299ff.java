package com.sec.chaton.buddy;

import android.text.TextUtils;
import android.view.View;

/* compiled from: BuddyInfoFragment.java */
/* renamed from: com.sec.chaton.buddy.ff */
/* loaded from: classes.dex */
class ViewOnClickListenerC1299ff implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyInfoFragment f4835a;

    ViewOnClickListenerC1299ff(BuddyInfoFragment buddyInfoFragment) {
        this.f4835a = buddyInfoFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String strReplaceAll;
        if (this.f4835a.f3865k.m7059h() != null && !TextUtils.isEmpty(this.f4835a.f3865k.m7059h()) && (strReplaceAll = this.f4835a.f3865k.m7059h().replaceAll(" ", "")) != null && strReplaceAll.length() >= 5) {
            if (strReplaceAll.length() != 5 && strReplaceAll.length() == 10) {
                strReplaceAll = strReplaceAll.substring(5);
            }
            this.f4835a.m6689c(strReplaceAll);
        }
    }
}
