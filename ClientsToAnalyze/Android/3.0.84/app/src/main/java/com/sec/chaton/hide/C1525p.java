package com.sec.chaton.hide;

import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.widget.CheckableRelativeLayout;

/* compiled from: HideListBuddyAdapter.java */
/* renamed from: com.sec.chaton.hide.p */
/* loaded from: classes.dex */
public class C1525p {

    /* renamed from: a */
    TextView f5610a;

    /* renamed from: b */
    TextView f5611b;

    /* renamed from: c */
    ImageView f5612c;

    /* renamed from: d */
    CheckBox f5613d;

    public C1525p(CheckableRelativeLayout checkableRelativeLayout) {
        this.f5610a = (TextView) checkableRelativeLayout.findViewById(R.id.text1);
        this.f5611b = (TextView) checkableRelativeLayout.findViewById(R.id.text2);
        this.f5611b.setVisibility(8);
        this.f5612c = (ImageView) checkableRelativeLayout.findViewById(R.id.image1);
        this.f5613d = (CheckBox) checkableRelativeLayout.findViewById(android.R.id.checkbox);
        checkableRelativeLayout.setChoiceMode(2);
    }
}
