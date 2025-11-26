package com.sec.chaton.block;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.buddy.BuddyProfileActivity;

/* compiled from: BlockBuddyAdapter.java */
/* renamed from: com.sec.chaton.block.f */
/* loaded from: classes.dex */
class ViewOnClickListenerC0246f implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f825a;

    /* renamed from: b */
    final /* synthetic */ C0245e f826b;

    ViewOnClickListenerC0246f(C0245e c0245e, int i) {
        this.f826b = c0245e;
        this.f825a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f826b.f816c, (Class<?>) BuddyProfileActivity.class);
        intent.putExtra("PROFILE_BUDDY_NO", ((C0253m) this.f826b.f814a.get(this.f825a)).f837b);
        intent.putExtra("PROFILE_BUDDY_NAME", ((C0253m) this.f826b.f814a.get(this.f825a)).f838c);
        intent.setFlags(67108864);
        this.f826b.f816c.startActivity(intent);
    }
}
