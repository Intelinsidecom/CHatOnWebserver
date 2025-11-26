package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.buddy.dialog.SpecialBuddyDialog;

/* compiled from: SpecialBuddyRecommendListFragment.java */
/* renamed from: com.sec.chaton.buddy.is */
/* loaded from: classes.dex */
class ViewOnClickListenerC1393is implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1392ir f5009a;

    ViewOnClickListenerC1393is(C1392ir c1392ir) {
        this.f5009a = c1392ir;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int iIntValue = ((Integer) view.getTag()).intValue();
        this.f5009a.f5001b = this.f5009a.f5000a.get(iIntValue).f4997a;
        this.f5009a.f5002c = this.f5009a.f5000a.get(iIntValue).f4998b;
        Intent intent = new Intent(this.f5009a.f5003d.f4182o, (Class<?>) SpecialBuddyDialog.class);
        intent.putExtra("specialuserid", this.f5009a.f5001b);
        intent.putExtra("speicalusername", this.f5009a.f5002c);
        intent.putExtra("specialBuddyAdded", false);
        this.f5009a.f5003d.startActivity(intent);
    }
}
