package com.sec.chaton.multimedia.vcard;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;

/* compiled from: ReadVCardAdapter.java */
/* renamed from: com.sec.chaton.multimedia.vcard.o */
/* loaded from: classes.dex */
class C1045o {

    /* renamed from: a */
    TextView f3888a;

    /* renamed from: b */
    TextView f3889b;

    /* renamed from: c */
    ImageView f3890c;

    /* renamed from: d */
    TextView f3891d;

    /* renamed from: e */
    LinearLayout f3892e;

    C1045o(LinearLayout linearLayout) {
        this.f3888a = (TextView) linearLayout.findViewById(R.id.list_vcard_main_text);
        this.f3889b = (TextView) linearLayout.findViewById(R.id.list_vcard_sub_text);
        this.f3890c = (ImageView) linearLayout.findViewById(R.id.vcard_checkbtn);
        this.f3891d = (TextView) linearLayout.findViewById(R.id.vcard_item_header_text);
        this.f3892e = linearLayout;
    }
}
