package com.sec.chaton.multimedia.vcard;

import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;

/* compiled from: VCardReadContactAdapter.java */
/* renamed from: com.sec.chaton.multimedia.vcard.i */
/* loaded from: classes.dex */
class C0832i {

    /* renamed from: a */
    TextView f2891a;

    /* renamed from: b */
    TextView f2892b;

    /* renamed from: c */
    CheckBox f2893c;

    /* renamed from: d */
    LinearLayout f2894d;

    C0832i(LinearLayout linearLayout) {
        this.f2891a = (TextView) linearLayout.findViewById(R.id.list_vcard_main_text);
        this.f2892b = (TextView) linearLayout.findViewById(R.id.list_vcard_sub_text);
        this.f2893c = (CheckBox) linearLayout.findViewById(R.id.vcard_checkbtn);
        this.f2894d = linearLayout;
    }
}
