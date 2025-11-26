package com.sec.chaton.buddy;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: BuddyAdapter.java */
/* renamed from: com.sec.chaton.buddy.z */
/* loaded from: classes.dex */
public class C0450z {

    /* renamed from: a */
    TextView f1716a;

    /* renamed from: b */
    TextView f1717b;

    /* renamed from: c */
    ImageView f1718c;

    /* renamed from: d */
    LinearLayout f1719d;

    /* renamed from: e */
    ImageView f1720e;

    public C0450z(LinearLayout linearLayout) {
        this.f1719d = linearLayout;
        this.f1716a = (TextView) linearLayout.findViewById(R.id.buddy_group_name);
        this.f1717b = (TextView) linearLayout.findViewById(R.id.buddy_group_participants);
        this.f1718c = (ImageView) linearLayout.findViewById(R.id.buddy_group_fold);
        if (GlobalApplication.m3265f()) {
            this.f1720e = (ImageView) linearLayout.findViewById(R.id.buddy_group_selected_none);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2466a(int i) {
        this.f1719d.setVisibility(i);
        this.f1716a.setVisibility(i);
        this.f1717b.setVisibility(i);
        this.f1718c.setVisibility(i);
        if (GlobalApplication.m3265f()) {
            this.f1720e.setVisibility(i);
        }
    }
}
