package com.sec.chaton.settings;

import android.view.View;
import com.sec.chaton.buddy.item.BuddyItem;

/* renamed from: com.sec.chaton.settings.w */
/* loaded from: classes.dex */
class ViewOnClickListenerC0522w implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f3301a;

    /* renamed from: b */
    final /* synthetic */ RelationHideAdapter f3302b;

    ViewOnClickListenerC0522w(RelationHideAdapter relationHideAdapter, int i) {
        this.f3302b = relationHideAdapter;
        this.f3301a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3302b.f3114e = ((BuddyItem) this.f3302b.f3110a.get(this.f3301a)).m668a();
        this.f3302b.f3113d = ((BuddyItem) this.f3302b.f3110a.get(this.f3301a)).m673b();
    }
}
