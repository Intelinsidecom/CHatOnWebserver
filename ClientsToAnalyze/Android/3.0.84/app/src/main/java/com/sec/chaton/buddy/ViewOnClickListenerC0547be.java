package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.common.CommonApplication;
import com.sec.common.util.log.collector.C3358h;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.be */
/* loaded from: classes.dex */
class ViewOnClickListenerC0547be implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f2506a;

    ViewOnClickListenerC0547be(BuddyFragment buddyFragment) {
        this.f2506a = buddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2506a.f1746J.setEnabled(false);
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C3358h.m11842a().m11846a("00030010");
        }
        Intent intent = new Intent(this.f2506a.getActivity(), (Class<?>) AddBuddyActivity.class);
        intent.putExtra("ADD_BUDDY_TYPE", 103);
        this.f2506a.startActivityForResult(intent, 100);
    }
}
