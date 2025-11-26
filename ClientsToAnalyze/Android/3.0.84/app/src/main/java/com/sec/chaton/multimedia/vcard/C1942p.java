package com.sec.chaton.multimedia.vcard;

import android.widget.CheckBox;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.widget.CheckableRelativeLayout;

/* compiled from: VCardReadContactAdapter.java */
/* renamed from: com.sec.chaton.multimedia.vcard.p */
/* loaded from: classes.dex */
class C1942p {

    /* renamed from: a */
    TextView f7453a;

    /* renamed from: b */
    TextView f7454b;

    /* renamed from: c */
    CheckBox f7455c;

    /* renamed from: d */
    final /* synthetic */ C1941o f7456d;

    C1942p(C1941o c1941o, CheckableRelativeLayout checkableRelativeLayout) {
        this.f7456d = c1941o;
        this.f7453a = (TextView) checkableRelativeLayout.findViewById(R.id.text1);
        this.f7453a.setTextAppearance(c1941o.f7452c, R.style.TextAppearance_List07);
        this.f7454b = (TextView) checkableRelativeLayout.findViewById(R.id.text2);
        this.f7454b.setTextAppearance(c1941o.f7452c, R.style.TextAppearance_List01);
        this.f7455c = (CheckBox) checkableRelativeLayout.findViewById(android.R.id.checkbox);
        checkableRelativeLayout.setChoiceMode(2);
    }
}
