package com.sec.chaton.multimedia.vcard;

import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.widget.CheckableRelativeLayout;

/* compiled from: ReadVCardAdapter.java */
/* renamed from: com.sec.chaton.multimedia.vcard.j */
/* loaded from: classes.dex */
class C1936j {

    /* renamed from: a */
    TextView f7435a;

    /* renamed from: b */
    TextView f7436b;

    /* renamed from: c */
    C1929c f7437c;

    /* renamed from: d */
    final /* synthetic */ C1935i f7438d;

    C1936j(C1935i c1935i, CheckableRelativeLayout checkableRelativeLayout) {
        this.f7438d = c1935i;
        this.f7435a = (TextView) checkableRelativeLayout.findViewById(R.id.text1);
        this.f7435a.setTextAppearance(c1935i.f7432a, R.style.TextAppearance_List07);
        this.f7436b = (TextView) checkableRelativeLayout.findViewById(R.id.text2);
        this.f7436b.setTextAppearance(c1935i.f7432a, R.style.TextAppearance_List01);
    }
}
