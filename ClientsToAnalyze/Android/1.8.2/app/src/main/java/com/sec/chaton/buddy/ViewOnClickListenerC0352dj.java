package com.sec.chaton.buddy;

import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyRecommendActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p022h.C0809s;
import com.sec.widget.C2153y;

/* compiled from: BuddyRecommendActivity.java */
/* renamed from: com.sec.chaton.buddy.dj */
/* loaded from: classes.dex */
class ViewOnClickListenerC0352dj implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendActivity.BuddyRecommendFragment f1496a;

    ViewOnClickListenerC0352dj(BuddyRecommendActivity.BuddyRecommendFragment buddyRecommendFragment) {
        this.f1496a = buddyRecommendFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int iM3420a = C0809s.m3420a(GlobalApplication.m3260b());
        if (-3 == iM3420a || -2 == iM3420a) {
            C2153y.m7535a(this.f1496a.getActivity(), R.string.popup_no_network_connection, 0).show();
            return;
        }
        String str = (String) view.getTag(R.id.TAG_FOR_BUDDYNO);
        this.f1496a.f1173i = Integer.parseInt(view.getTag(R.id.TAG_FOR_TYPE).toString());
        this.f1496a.m2183a(str, this.f1496a.f1173i);
    }
}
