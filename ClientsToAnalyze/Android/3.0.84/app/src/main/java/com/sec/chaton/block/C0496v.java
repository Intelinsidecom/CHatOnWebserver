package com.sec.chaton.block;

import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.widget.CheckableRelativeLayout;

/* compiled from: BlockListBuddyAdapter.java */
/* renamed from: com.sec.chaton.block.v */
/* loaded from: classes.dex */
public class C0496v {

    /* renamed from: a */
    TextView f1631a;

    /* renamed from: b */
    TextView f1632b;

    /* renamed from: c */
    ImageView f1633c;

    /* renamed from: d */
    CheckBox f1634d;

    public C0496v(CheckableRelativeLayout checkableRelativeLayout) {
        this.f1631a = (TextView) checkableRelativeLayout.findViewById(R.id.text1);
        this.f1632b = (TextView) checkableRelativeLayout.findViewById(R.id.text2);
        this.f1632b.setVisibility(8);
        this.f1633c = (ImageView) checkableRelativeLayout.findViewById(R.id.image1);
        this.f1634d = (CheckBox) checkableRelativeLayout.findViewById(android.R.id.checkbox);
        checkableRelativeLayout.setChoiceMode(2);
    }
}
