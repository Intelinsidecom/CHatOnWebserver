package com.sec.chaton.buddy;

import android.widget.TabHost;
import com.sec.chaton.buddy.AddBuddyActivity;

/* compiled from: AddBuddyActivity.java */
/* renamed from: com.sec.chaton.buddy.p */
/* loaded from: classes.dex */
class C0440p implements TabHost.OnTabChangeListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyActivity.AddBuddyFragment f1656a;

    C0440p(AddBuddyActivity.AddBuddyFragment addBuddyFragment) {
        this.f1656a = addBuddyFragment;
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    public void onTabChanged(String str) {
        this.f1656a.f856L = str;
        if (str == "Phone Number") {
            this.f1656a.m1865a(this.f1656a.f878q);
            return;
        }
        if (str == "Tellfriends") {
            this.f1656a.m1865a(this.f1656a.f880s);
        } else if (str == "Suggestions") {
            this.f1656a.m1865a(this.f1656a.f881t);
        } else {
            this.f1656a.m1865a(this.f1656a.f879r);
        }
    }
}
