package com.sec.chaton.block;

import android.view.View;
import com.sec.chaton.control.BlockControl;

/* renamed from: com.sec.chaton.block.d */
/* loaded from: classes.dex */
class ViewOnClickListenerC0074d implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f378a;

    /* renamed from: b */
    final /* synthetic */ BlockBuddyAdapter f379b;

    ViewOnClickListenerC0074d(BlockBuddyAdapter blockBuddyAdapter, int i) {
        this.f379b = blockBuddyAdapter;
        this.f378a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f379b.f361g = ((C0071a) this.f379b.f355a.get(this.f378a)).f372b;
        this.f379b.f360f = ((C0071a) this.f379b.f355a.get(this.f378a)).f373c;
        this.f379b.f359e = new BlockControl(this.f379b.f356b);
        this.f379b.f359e.m1990a(this.f379b.f361g);
        this.f379b.f363i.show();
    }
}
