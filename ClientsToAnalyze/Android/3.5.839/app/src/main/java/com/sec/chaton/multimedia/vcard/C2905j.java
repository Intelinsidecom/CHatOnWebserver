package com.sec.chaton.multimedia.vcard;

import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.widget.CheckableRelativeLayout;

/* compiled from: ReadVCardAdapter.java */
/* renamed from: com.sec.chaton.multimedia.vcard.j */
/* loaded from: classes.dex */
class C2905j {

    /* renamed from: a */
    TextView f10756a;

    /* renamed from: b */
    TextView f10757b;

    /* renamed from: c */
    C2898c f10758c;

    /* renamed from: d */
    final /* synthetic */ C2904i f10759d;

    C2905j(C2904i c2904i, CheckableRelativeLayout checkableRelativeLayout) {
        this.f10759d = c2904i;
        this.f10756a = (TextView) checkableRelativeLayout.findViewById(R.id.text1);
        this.f10756a.setTextAppearance(c2904i.f10753a, R.style.TextAppearance_List07);
        this.f10757b = (TextView) checkableRelativeLayout.findViewById(R.id.text2);
        this.f10757b.setTextAppearance(c2904i.f10753a, R.style.TextAppearance_List01);
    }
}
