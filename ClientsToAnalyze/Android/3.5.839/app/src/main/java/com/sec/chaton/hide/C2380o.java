package com.sec.chaton.hide;

import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.widget.CheckableRelativeLayout;

/* compiled from: HideListBuddyAdapter.java */
/* renamed from: com.sec.chaton.hide.o */
/* loaded from: classes.dex */
public class C2380o {

    /* renamed from: a */
    TextView f8464a;

    /* renamed from: b */
    TextView f8465b;

    /* renamed from: c */
    ImageView f8466c;

    /* renamed from: d */
    CheckBox f8467d;

    public C2380o(CheckableRelativeLayout checkableRelativeLayout) {
        this.f8464a = (TextView) checkableRelativeLayout.findViewById(R.id.text1);
        this.f8465b = (TextView) checkableRelativeLayout.findViewById(R.id.text2);
        this.f8465b.setVisibility(8);
        this.f8466c = (ImageView) checkableRelativeLayout.findViewById(R.id.image1);
        this.f8467d = (CheckBox) checkableRelativeLayout.findViewById(android.R.id.checkbox);
        if (C4822an.m18195E()) {
            this.f8467d.setPadding(0, 0, 75, 0);
        }
        checkableRelativeLayout.setChoiceMode(2);
    }
}
