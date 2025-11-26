package com.sec.chaton.multimedia.vcard;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;

/* compiled from: VCardReadContactAdapter.java */
/* renamed from: com.sec.chaton.multimedia.vcard.w */
/* loaded from: classes.dex */
class C1053w {

    /* renamed from: a */
    TextView f3909a;

    /* renamed from: b */
    TextView f3910b;

    /* renamed from: c */
    TextView f3911c;

    /* renamed from: d */
    ImageView f3912d;

    /* renamed from: e */
    LinearLayout f3913e;

    C1053w(LinearLayout linearLayout) {
        this.f3909a = (TextView) linearLayout.findViewById(R.id.list_vcard_main_text);
        this.f3910b = (TextView) linearLayout.findViewById(R.id.list_vcard_sub_text);
        this.f3912d = (ImageView) linearLayout.findViewById(R.id.vcard_checkbtn);
        this.f3911c = (TextView) linearLayout.findViewById(R.id.vcard_item_header_text);
        this.f3913e = linearLayout;
    }
}
