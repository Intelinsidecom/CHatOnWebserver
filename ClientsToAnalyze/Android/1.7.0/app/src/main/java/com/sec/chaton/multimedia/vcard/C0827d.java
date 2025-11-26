package com.sec.chaton.multimedia.vcard;

import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;

/* compiled from: ReadVCardAdapter.java */
/* renamed from: com.sec.chaton.multimedia.vcard.d */
/* loaded from: classes.dex */
class C0827d {

    /* renamed from: a */
    TextView f2869a;

    /* renamed from: b */
    TextView f2870b;

    /* renamed from: c */
    CheckBox f2871c;

    /* renamed from: d */
    LinearLayout f2872d;

    C0827d(LinearLayout linearLayout) {
        this.f2869a = (TextView) linearLayout.findViewById(R.id.list_vcard_main_text);
        this.f2870b = (TextView) linearLayout.findViewById(R.id.list_vcard_sub_text);
        this.f2871c = (CheckBox) linearLayout.findViewById(R.id.vcard_checkbtn);
        this.f2872d = linearLayout;
    }
}
