package com.sec.chaton.settings;

import android.content.ContentValues;
import android.view.View;
import com.sec.chaton.buddy.item.BuddyItem;
import com.sec.chaton.database.ChatONContract;

/* renamed from: com.sec.chaton.settings.v */
/* loaded from: classes.dex */
class ViewOnClickListenerC0521v implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f3299a;

    /* renamed from: b */
    final /* synthetic */ RelationHideAdapter f3300b;

    ViewOnClickListenerC0521v(RelationHideAdapter relationHideAdapter, int i) {
        this.f3300b = relationHideAdapter;
        this.f3299a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3300b.f3114e = ((BuddyItem) this.f3300b.f3110a.get(this.f3299a)).m668a();
        this.f3300b.f3113d = ((BuddyItem) this.f3300b.f3110a.get(this.f3299a)).m673b();
        BuddyItem buddyItem = (BuddyItem) this.f3300b.f3110a.get(this.f3299a);
        ContentValues contentValues = new ContentValues();
        contentValues.put("buddy_relation_hide", "N");
        this.f3300b.f3116g.startUpdate(0, null, ChatONContract.BuddyTable.f1713a, contentValues, "buddy_no = ? ", new String[]{buddyItem.m668a()});
        RelationHideActivity.f3098b = true;
    }
}
