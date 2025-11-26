package com.sec.chaton.buddy;

import android.view.View;
import android.widget.CheckBox;
import com.sec.chaton.buddy.item.BuddyItem;
import java.util.ArrayList;

/* renamed from: com.sec.chaton.buddy.al */
/* loaded from: classes.dex */
class ViewOnClickListenerC0088al implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f625a;

    /* renamed from: b */
    final /* synthetic */ int f626b;

    /* renamed from: c */
    final /* synthetic */ BuddyGroupEditAdapter f627c;

    ViewOnClickListenerC0088al(BuddyGroupEditAdapter buddyGroupEditAdapter, int i, int i2) {
        this.f627c = buddyGroupEditAdapter;
        this.f625a = i;
        this.f626b = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean zIsChecked = ((CheckBox) view).isChecked();
        ((CheckBox) view).setChecked(zIsChecked);
        ((BuddyItem) ((ArrayList) this.f627c.f539k.get(this.f625a)).get(this.f626b)).m672a(zIsChecked);
        this.f627c.m594a(((BuddyItem) ((ArrayList) this.f627c.f539k.get(this.f625a)).get(this.f626b)).m668a(), zIsChecked);
        this.f627c.f531c.invalidateViews();
        this.f627c.m590a(this.f627c.f537i);
    }
}
