package com.sec.chaton.multimedia.vcard;

import android.widget.CheckBox;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.widget.CheckableRelativeLayout;

/* compiled from: VCardReadContactAdapter.java */
/* renamed from: com.sec.chaton.multimedia.vcard.p */
/* loaded from: classes.dex */
class C2911p {

    /* renamed from: a */
    TextView f10774a;

    /* renamed from: b */
    TextView f10775b;

    /* renamed from: c */
    CheckBox f10776c;

    /* renamed from: d */
    final /* synthetic */ C2910o f10777d;

    C2911p(C2910o c2910o, CheckableRelativeLayout checkableRelativeLayout) {
        this.f10777d = c2910o;
        this.f10774a = (TextView) checkableRelativeLayout.findViewById(R.id.text1);
        this.f10774a.setTextAppearance(c2910o.f10773c, R.style.TextAppearance_List07);
        this.f10775b = (TextView) checkableRelativeLayout.findViewById(R.id.text2);
        this.f10775b.setTextAppearance(c2910o.f10773c, R.style.TextAppearance_List01);
        this.f10776c = (CheckBox) checkableRelativeLayout.findViewById(android.R.id.checkbox);
        checkableRelativeLayout.setChoiceMode(2);
    }
}
