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
public class C0857aj {

    /* renamed from: a */
    ImageView f3365a;

    /* renamed from: b */
    TextView f3366b;

    /* renamed from: c */
    ViewGroup f3367c;

    /* renamed from: d */
    ImageView f3368d;

    /* renamed from: e */
    CheckBox f3369e;

    /* renamed from: f */
    LinearLayout f3370f;

    public C0857aj(ViewGroup viewGroup) {
        this.f3367c = viewGroup;
        this.f3365a = (ImageView) this.f3367c.findViewById(R.id.buddy_child_profile);
        this.f3366b = (TextView) this.f3367c.findViewById(R.id.buddy_child_name);
        this.f3368d = (ImageView) this.f3367c.findViewById(R.id.buddy_child_add);
        this.f3369e = (CheckBox) this.f3367c.findViewById(R.id.buddy_child_select);
        this.f3369e.setClickable(false);
        this.f3369e.setFocusable(false);
        this.f3370f = (LinearLayout) this.f3367c.findViewById(R.id.buddy_child_btns);
    }
}
