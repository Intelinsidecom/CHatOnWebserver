package com.sec.chaton.calllog.view;

import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;

/* compiled from: ShowConferenceMemberListFragment.java */
/* renamed from: com.sec.chaton.calllog.view.aj */
/* loaded from: classes.dex */
public class C1468aj {

    /* renamed from: a */
    ImageView f5338a;

    /* renamed from: b */
    TextView f5339b;

    /* renamed from: c */
    ViewGroup f5340c;

    /* renamed from: d */
    ImageView f5341d;

    /* renamed from: e */
    CheckBox f5342e;

    /* renamed from: f */
    LinearLayout f5343f;

    public C1468aj(ViewGroup viewGroup) {
        this.f5340c = viewGroup;
        this.f5338a = (ImageView) this.f5340c.findViewById(R.id.buddy_child_profile);
        this.f5339b = (TextView) this.f5340c.findViewById(R.id.buddy_child_name);
        this.f5341d = (ImageView) this.f5340c.findViewById(R.id.buddy_child_add);
        this.f5342e = (CheckBox) this.f5340c.findViewById(R.id.buddy_child_select);
        this.f5342e.setClickable(false);
        this.f5342e.setFocusable(false);
        this.f5343f = (LinearLayout) this.f5340c.findViewById(R.id.buddy_child_btns);
    }
}
