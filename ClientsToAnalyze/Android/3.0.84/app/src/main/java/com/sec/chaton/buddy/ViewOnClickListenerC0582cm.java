package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.samsungaccount.MainActivity;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.cm */
/* loaded from: classes.dex */
class ViewOnClickListenerC0582cm implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f2544a;

    ViewOnClickListenerC0582cm(BuddyFragment buddyFragment) {
        this.f2544a = buddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f2544a.getActivity(), (Class<?>) MainActivity.class);
        intent.putExtra("is_mapping_mode", true);
        intent.putExtra("is_multi_device_mode", true);
        this.f2544a.startActivity(intent);
    }
}
