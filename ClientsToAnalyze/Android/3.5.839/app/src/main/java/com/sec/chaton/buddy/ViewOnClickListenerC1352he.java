package com.sec.chaton.buddy;

import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.p067j.C2471v;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;
import java.io.UnsupportedEncodingException;

/* compiled from: BuddyRecommendFragment.java */
/* renamed from: com.sec.chaton.buddy.he */
/* loaded from: classes.dex */
class ViewOnClickListenerC1352he implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendFragment f4931a;

    ViewOnClickListenerC1352he(BuddyRecommendFragment buddyRecommendFragment) {
        this.f4931a = buddyRecommendFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws UnsupportedEncodingException {
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (-3 == iM10677a || -2 == iM10677a) {
            C5179v.m19810a(this.f4931a.f4066A, R.string.popup_no_network_connection, 0).show();
            return;
        }
        String str = (String) view.getTag(R.id.TAG_FOR_BUDDYNO);
        this.f4931a.f4084l = Integer.parseInt(view.getTag(R.id.TAG_FOR_TYPE).toString());
        this.f4931a.m6909a(str, this.f4931a.f4084l);
    }
}
