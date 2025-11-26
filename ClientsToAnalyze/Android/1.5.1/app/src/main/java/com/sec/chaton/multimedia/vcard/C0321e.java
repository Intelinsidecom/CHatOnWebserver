package com.sec.chaton.multimedia.vcard;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.C0062R;

/* renamed from: com.sec.chaton.multimedia.vcard.e */
/* loaded from: classes.dex */
class C0321e {

    /* renamed from: a */
    TextView f2378a;

    /* renamed from: b */
    TextView f2379b;

    /* renamed from: c */
    ImageView f2380c;

    /* renamed from: d */
    LinearLayout f2381d;

    C0321e(LinearLayout linearLayout) {
        this.f2378a = (TextView) linearLayout.findViewById(C0062R.id.list_vcard_main_text);
        this.f2379b = (TextView) linearLayout.findViewById(C0062R.id.list_vcard_sub_text);
        this.f2380c = (ImageView) linearLayout.findViewById(C0062R.id.vcard_checkbtn);
        this.f2381d = linearLayout;
    }
}
