package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.buddy.dialog.SpecialBuddyDialog;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: SpecialBuddyRecommendListFragment.java */
/* renamed from: com.sec.chaton.buddy.iq */
/* loaded from: classes.dex */
class ViewOnClickListenerC0787iq implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0785io f3069a;

    ViewOnClickListenerC0787iq(C0785io c0785io) {
        this.f3069a = c0785io;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int iIntValue = ((Integer) view.getTag()).intValue();
        this.f3069a.f3060b = this.f3069a.f3059a.get(iIntValue).f3056a;
        this.f3069a.f3061c = this.f3069a.f3059a.get(iIntValue).f3057b;
        if (GlobalApplication.m6456e()) {
            Intent intent = new Intent(this.f3069a.f3062d.f2337p, (Class<?>) SpecialBuddyActivity.class);
            intent.putExtra("specialuserid", this.f3069a.f3060b);
            intent.putExtra("speicalusername", this.f3069a.f3061c);
            intent.putExtra("specialBuddyAdded", false);
            this.f3069a.f3062d.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(this.f3069a.f3062d.f2337p, (Class<?>) SpecialBuddyDialog.class);
        intent2.putExtra("specialuserid", this.f3069a.f3060b);
        intent2.putExtra("speicalusername", this.f3069a.f3061c);
        intent2.putExtra("specialBuddyAdded", false);
        this.f3069a.f3062d.startActivity(intent2);
    }
}
