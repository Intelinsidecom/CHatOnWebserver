package com.sec.chaton.buddy.honeycomb;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;

/* compiled from: BuddySelectAdapter.java */
/* renamed from: com.sec.chaton.buddy.honeycomb.e */
/* loaded from: classes.dex */
public class C0422e {

    /* renamed from: a */
    LinearLayout f1636a;

    /* renamed from: b */
    TextView f1637b;

    /* renamed from: c */
    TextView f1638c;

    public C0422e(LinearLayout linearLayout) {
        this.f1636a = linearLayout;
        this.f1637b = (TextView) linearLayout.findViewById(R.id.buddy_select_group_name);
        this.f1638c = (TextView) linearLayout.findViewById(R.id.buddy_select_group_participants);
    }

    /* renamed from: a */
    public void m2438a(int i) {
        this.f1636a.setVisibility(i);
        this.f1637b.setVisibility(i);
        this.f1638c.setVisibility(i);
    }
}
