package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.buddy.item.BuddyItem;

/* renamed from: com.sec.chaton.userprofile.q */
/* loaded from: classes.dex */
class ViewOnClickListenerC0593q implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f3590a;

    /* renamed from: b */
    final /* synthetic */ C0546a f3591b;

    ViewOnClickListenerC0593q(C0546a c0546a, int i) {
        this.f3591b = c0546a;
        this.f3590a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f3591b.getContext(), (Class<?>) BuddyProfileActivity.class);
        intent.putExtra("PROFILE_BUDDY_NO", ((BuddyItem) this.f3591b.getItem(this.f3590a)).m668a());
        intent.putExtra("PROFILE_BUDDY_NAME", ((BuddyItem) this.f3591b.getItem(this.f3590a)).m673b());
        this.f3591b.getContext().startActivity(intent);
    }
}
