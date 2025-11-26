package com.sec.chaton.trunk;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.p017e.EnumC0695j;

/* compiled from: TrunkView.java */
/* renamed from: com.sec.chaton.trunk.bj */
/* loaded from: classes.dex */
class ViewOnClickListenerC1561bj implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkView f5638a;

    ViewOnClickListenerC1561bj(TrunkView trunkView) {
        this.f5638a = trunkView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f5638a.f5510A == EnumC0695j.ONETOONE) {
            Intent intent = new Intent(this.f5638a.getActivity(), (Class<?>) BuddyProfileActivity.class);
            intent.putExtra("PROFILE_BUDDY_NO", this.f5638a.f5537y);
            intent.putExtra("PROFILE_BUDDY_NAME", this.f5638a.f5538z);
            intent.setFlags(67108864);
            this.f5638a.getActivity().startActivity(intent);
        }
    }
}
