package com.sec.chaton.block;

import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.widget.CheckableRelativeLayout;

/* compiled from: BlockListBuddyAdapter.java */
/* renamed from: com.sec.chaton.block.n */
/* loaded from: classes.dex */
public class C1086n {

    /* renamed from: a */
    TextView f3474a;

    /* renamed from: b */
    TextView f3475b;

    /* renamed from: c */
    ImageView f3476c;

    /* renamed from: d */
    CheckBox f3477d;

    public C1086n(CheckableRelativeLayout checkableRelativeLayout) {
        this.f3474a = (TextView) checkableRelativeLayout.findViewById(R.id.text1);
        this.f3475b = (TextView) checkableRelativeLayout.findViewById(R.id.text2);
        this.f3475b.setVisibility(8);
        this.f3476c = (ImageView) checkableRelativeLayout.findViewById(R.id.image1);
        this.f3477d = (CheckBox) checkableRelativeLayout.findViewById(android.R.id.checkbox);
        if (C4822an.m18195E()) {
            this.f3477d.setPadding(0, 0, 75, 0);
        }
        checkableRelativeLayout.setChoiceMode(2);
    }
}
