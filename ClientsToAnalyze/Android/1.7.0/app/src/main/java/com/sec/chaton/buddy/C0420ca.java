package com.sec.chaton.buddy;

import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;

/* compiled from: BuddyAdapter.java */
/* renamed from: com.sec.chaton.buddy.ca */
/* loaded from: classes.dex */
public class C0420ca {

    /* renamed from: a */
    CheckBox f1395a;

    /* renamed from: b */
    ImageView f1396b;

    /* renamed from: c */
    TextView f1397c;

    /* renamed from: d */
    TextView f1398d;

    /* renamed from: e */
    ViewGroup f1399e;

    /* renamed from: f */
    LinearLayout f1400f;

    /* renamed from: g */
    ImageView f1401g;

    /* renamed from: h */
    ImageView f1402h;

    public C0420ca(ViewGroup viewGroup) {
        this.f1399e = viewGroup;
        this.f1395a = (CheckBox) this.f1399e.findViewById(R.id.buddy_child_check);
        this.f1396b = (ImageView) this.f1399e.findViewById(R.id.buddy_child_profile);
        this.f1397c = (TextView) this.f1399e.findViewById(R.id.buddy_child_name);
        this.f1398d = (TextView) this.f1399e.findViewById(R.id.buddy_child_status_msg);
        this.f1400f = (LinearLayout) this.f1399e.findViewById(R.id.buddy_child_profile_outline);
        this.f1401g = (ImageView) this.f1399e.findViewById(R.id.buddy_child_selected_arrow);
        this.f1402h = (ImageView) this.f1399e.findViewById(R.id.buddy_child_selected_none);
    }
}
