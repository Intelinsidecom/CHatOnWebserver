package com.sec.chaton.buddy;

import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.p037j.C1594v;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;
import java.io.UnsupportedEncodingException;

/* compiled from: BuddyRecommendListFragment.java */
/* renamed from: com.sec.chaton.buddy.ha */
/* loaded from: classes.dex */
class ViewOnClickListenerC0744ha implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendListFragment f2998a;

    ViewOnClickListenerC0744ha(BuddyRecommendListFragment buddyRecommendListFragment) {
        this.f2998a = buddyRecommendListFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws UnsupportedEncodingException {
        int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
        if (-3 == iM6733a || -2 == iM6733a) {
            C3641ai.m13210a(this.f2998a.getActivity(), R.string.popup_no_network_connection, 0).show();
            return;
        }
        String str = (String) view.getTag(R.id.TAG_FOR_BUDDYNO);
        this.f2998a.f2225k = Integer.parseInt(view.getTag(R.id.TAG_FOR_TYPE).toString());
        this.f2998a.m3814a(str, this.f2998a.f2225k);
    }
}
