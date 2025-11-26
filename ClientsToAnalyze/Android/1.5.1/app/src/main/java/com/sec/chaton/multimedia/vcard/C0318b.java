package com.sec.chaton.multimedia.vcard;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.C0062R;

/* renamed from: com.sec.chaton.multimedia.vcard.b */
/* loaded from: classes.dex */
class C0318b {

    /* renamed from: a */
    TextView f2372a;

    /* renamed from: b */
    TextView f2373b;

    /* renamed from: c */
    ImageView f2374c;

    /* renamed from: d */
    LinearLayout f2375d;

    C0318b(LinearLayout linearLayout) {
        this.f2372a = (TextView) linearLayout.findViewById(C0062R.id.list_vcard_main_text);
        this.f2373b = (TextView) linearLayout.findViewById(C0062R.id.list_vcard_sub_text);
        this.f2374c = (ImageView) linearLayout.findViewById(C0062R.id.vcard_checkbtn);
        this.f2375d = linearLayout;
    }
}
