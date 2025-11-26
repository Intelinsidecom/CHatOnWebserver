package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.buddy.item.BuddyGroupListItem;
import com.sec.chaton.buddy.item.BuddyItem;
import java.util.HashMap;

/* renamed from: com.sec.chaton.buddy.q */
/* loaded from: classes.dex */
class ViewOnClickListenerC0124q implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyItem f705a;

    /* renamed from: b */
    final /* synthetic */ BuddyAdapter f706b;

    ViewOnClickListenerC0124q(BuddyAdapter buddyAdapter, BuddyItem buddyItem) {
        this.f706b = buddyAdapter;
        this.f705a = buddyItem;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        HashMap mapM698w = this.f705a.m698w();
        BuddyGroupListItem buddyGroupListItem = new BuddyGroupListItem(Integer.parseInt(this.f705a.m668a()), this.f705a.m673b(), mapM698w == null ? 0 : mapM698w.size(), 2);
        Intent intent = new Intent(this.f706b.f385c, (Class<?>) BuddyGroupEditActivity.class);
        intent.putExtra("ACTIVITY_PURPOSE", 1);
        intent.putExtra("ACTIVITY_PURPOSE_ARG1", buddyGroupListItem);
        this.f706b.f385c.startActivity(intent);
    }
}
