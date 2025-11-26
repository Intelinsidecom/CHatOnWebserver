package com.sec.chaton.buddy;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;

/* compiled from: BuddyGroupEditAdapter.java */
/* renamed from: com.sec.chaton.buddy.cl */
/* loaded from: classes.dex */
public class C0327cl {

    /* renamed from: a */
    TextView f1467a;

    /* renamed from: b */
    TextView f1468b;

    /* renamed from: c */
    ImageView f1469c;

    public C0327cl(LinearLayout linearLayout) {
        this.f1467a = (TextView) linearLayout.findViewById(R.id.buddy_group_name);
        this.f1468b = (TextView) linearLayout.findViewById(R.id.buddy_group_participants);
        this.f1469c = (ImageView) linearLayout.findViewById(R.id.buddy_group_fold);
    }
}
