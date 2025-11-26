package com.sec.chaton.buddy;

import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyRecommendListActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p022h.C0809s;
import com.sec.widget.C2153y;

/* compiled from: BuddyRecommendListActivity.java */
/* renamed from: com.sec.chaton.buddy.dz */
/* loaded from: classes.dex */
class ViewOnClickListenerC0368dz implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendListActivity.BuddyRecommendListFragment f1519a;

    ViewOnClickListenerC0368dz(BuddyRecommendListActivity.BuddyRecommendListFragment buddyRecommendListFragment) {
        this.f1519a = buddyRecommendListFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int iM3420a = C0809s.m3420a(GlobalApplication.m3260b());
        if (-3 == iM3420a || -2 == iM3420a) {
            C2153y.m7535a(this.f1519a.getActivity(), R.string.popup_no_network_connection, 0).show();
            return;
        }
        String str = (String) view.getTag(R.id.TAG_FOR_BUDDYNO);
        this.f1519a.f1191i = Integer.parseInt(view.getTag(R.id.TAG_FOR_TYPE).toString());
        this.f1519a.m2209a(str, this.f1519a.f1191i);
    }
}
