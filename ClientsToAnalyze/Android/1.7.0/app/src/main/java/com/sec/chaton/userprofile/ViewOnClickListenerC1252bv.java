package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.buddy.p017a.C0363a;

/* compiled from: InteractionAdapter.java */
/* renamed from: com.sec.chaton.userprofile.bv */
/* loaded from: classes.dex */
class ViewOnClickListenerC1252bv implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f4348a;

    /* renamed from: b */
    final /* synthetic */ C1276z f4349b;

    ViewOnClickListenerC1252bv(C1276z c1276z, int i) {
        this.f4349b = c1276z;
        this.f4348a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f4349b.getContext(), (Class<?>) BuddyProfileActivity.class);
        intent.putExtra("PROFILE_BUDDY_NO", ((C0363a) this.f4349b.getItem(this.f4348a)).m2308a());
        intent.putExtra("PROFILE_BUDDY_NAME", ((C0363a) this.f4349b.getItem(this.f4348a)).m2314b());
        this.f4349b.getContext().startActivity(intent);
    }
}
