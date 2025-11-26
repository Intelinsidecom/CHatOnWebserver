package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.buddy.item.BuddyItem;
import java.util.ArrayList;

/* renamed from: com.sec.chaton.buddy.t */
/* loaded from: classes.dex */
class ViewOnClickListenerC0127t implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f709a;

    /* renamed from: b */
    final /* synthetic */ int f710b;

    /* renamed from: c */
    final /* synthetic */ BuddyAdapter f711c;

    ViewOnClickListenerC0127t(BuddyAdapter buddyAdapter, int i, int i2) {
        this.f711c = buddyAdapter;
        this.f709a = i;
        this.f710b = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f711c.f385c, (Class<?>) BuddyProfileActivity.class);
        intent.putExtra("PROFILE_BUDDY_NO", ((BuddyItem) ((ArrayList) this.f711c.f388f.get(this.f709a)).get(this.f710b)).m668a());
        intent.putExtra("PROFILE_BUDDY_NAME", ((BuddyItem) ((ArrayList) this.f711c.f388f.get(this.f709a)).get(this.f710b)).m673b());
        intent.setFlags(268435456);
        this.f711c.f385c.startActivity(intent);
    }
}
