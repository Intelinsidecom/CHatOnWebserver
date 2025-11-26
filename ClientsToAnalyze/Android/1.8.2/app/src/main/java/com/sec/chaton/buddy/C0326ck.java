package com.sec.chaton.buddy;

import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sec.chaton.R;

/* compiled from: BuddyGroupEditAdapter.java */
/* renamed from: com.sec.chaton.buddy.ck */
/* loaded from: classes.dex */
public class C0326ck {

    /* renamed from: a */
    CheckBox f1463a;

    /* renamed from: b */
    ImageView f1464b;

    /* renamed from: c */
    TextView f1465c;

    /* renamed from: d */
    TextView f1466d;

    public C0326ck(RelativeLayout relativeLayout) {
        this.f1463a = (CheckBox) relativeLayout.findViewById(R.id.buddy_child_check);
        this.f1464b = (ImageView) relativeLayout.findViewById(R.id.buddy_child_profile);
        this.f1465c = (TextView) relativeLayout.findViewById(R.id.buddy_child_name);
        this.f1466d = (TextView) relativeLayout.findViewById(R.id.buddy_child_status_msg);
    }
}
