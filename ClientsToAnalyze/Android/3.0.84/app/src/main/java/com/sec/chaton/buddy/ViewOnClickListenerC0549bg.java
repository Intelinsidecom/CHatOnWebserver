package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.samsungaccount.MainActivity;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bg */
/* loaded from: classes.dex */
class ViewOnClickListenerC0549bg implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f2508a;

    ViewOnClickListenerC0549bg(BuddyFragment buddyFragment) {
        this.f2508a = buddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f2508a.getActivity(), (Class<?>) MainActivity.class);
        intent.putExtra("is_mapping_mode", true);
        intent.putExtra("is_multi_device_mode", true);
        this.f2508a.startActivity(intent);
    }
}
