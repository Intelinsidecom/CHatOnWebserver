package com.sec.chaton.buddy;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;

/* compiled from: BuddyAdapter.java */
/* renamed from: com.sec.chaton.buddy.ba */
/* loaded from: classes.dex */
public class C0393ba {

    /* renamed from: a */
    TextView f1363a;

    /* renamed from: b */
    TextView f1364b;

    /* renamed from: c */
    ImageView f1365c;

    /* renamed from: d */
    LinearLayout f1366d;

    public C0393ba(LinearLayout linearLayout) {
        this.f1366d = linearLayout;
        this.f1363a = (TextView) linearLayout.findViewById(R.id.buddy_group_name);
        this.f1364b = (TextView) linearLayout.findViewById(R.id.buddy_group_participants);
        this.f1365c = (ImageView) linearLayout.findViewById(R.id.buddy_group_fold);
    }
}
