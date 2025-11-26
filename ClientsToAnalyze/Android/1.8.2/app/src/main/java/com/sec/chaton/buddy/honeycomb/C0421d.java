package com.sec.chaton.buddy.honeycomb;

import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;

/* compiled from: BuddySelectAdapter.java */
/* renamed from: com.sec.chaton.buddy.honeycomb.d */
/* loaded from: classes.dex */
public class C0421d {

    /* renamed from: a */
    LinearLayout f1630a;

    /* renamed from: b */
    CheckBox f1631b;

    /* renamed from: c */
    ImageView f1632c;

    /* renamed from: d */
    TextView f1633d;

    /* renamed from: e */
    TextView f1634e;

    /* renamed from: f */
    ImageView f1635f;

    public C0421d(LinearLayout linearLayout) {
        this.f1630a = linearLayout;
        this.f1631b = (CheckBox) this.f1630a.findViewById(R.id.buddy_select_child_check);
        this.f1632c = (ImageView) this.f1630a.findViewById(R.id.buddy_select_child_profile);
        this.f1633d = (TextView) this.f1630a.findViewById(R.id.buddy_select_child_name);
        this.f1634e = (TextView) this.f1630a.findViewById(R.id.buddy_select_child_status_msg);
        this.f1635f = (ImageView) this.f1630a.findViewById(R.id.buddy_select_child_remove);
    }
}
