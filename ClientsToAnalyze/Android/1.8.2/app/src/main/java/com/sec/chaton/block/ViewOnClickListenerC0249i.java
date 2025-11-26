package com.sec.chaton.block;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.buddy.BuddySelectActivity;

/* compiled from: BlockFragment.java */
/* renamed from: com.sec.chaton.block.i */
/* loaded from: classes.dex */
class ViewOnClickListenerC0249i implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BlockFragment f832a;

    ViewOnClickListenerC0249i(BlockFragment blockFragment) {
        this.f832a = blockFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f832a.getActivity(), (Class<?>) BuddySelectActivity.class);
        intent.putExtra("BUDDY_SORT_STYLE", 11);
        intent.putExtra("ACTIVITY_PURPOSE", 19);
        this.f832a.startActivity(intent);
    }
}
