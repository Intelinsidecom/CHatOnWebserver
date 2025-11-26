package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.buddy.item.BuddyItem;
import java.util.ArrayList;

/* renamed from: com.sec.chaton.buddy.u */
/* loaded from: classes.dex */
class ViewOnClickListenerC0128u implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f712a;

    /* renamed from: b */
    final /* synthetic */ int f713b;

    /* renamed from: c */
    final /* synthetic */ BuddyAdapter f714c;

    ViewOnClickListenerC0128u(BuddyAdapter buddyAdapter, int i, int i2) {
        this.f714c = buddyAdapter;
        this.f712a = i;
        this.f713b = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f714c.f385c, (Class<?>) BuddyProfileActivity.class);
        intent.putExtra("PROFILE_BUDDY_NO", ((BuddyItem) ((ArrayList) this.f714c.f388f.get(this.f712a)).get(this.f713b)).m668a());
        intent.putExtra("PROFILE_BUDDY_NAME", ((BuddyItem) ((ArrayList) this.f714c.f388f.get(this.f712a)).get(this.f713b)).m673b());
        intent.setFlags(268435456);
        this.f714c.f385c.startActivity(intent);
    }
}
