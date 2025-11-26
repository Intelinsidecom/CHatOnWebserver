package com.sec.chaton.buddy;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;

/* compiled from: BuddyRecommendActivity.java */
/* renamed from: com.sec.chaton.buddy.du */
/* loaded from: classes.dex */
public class C0363du {

    /* renamed from: a */
    ImageView f1511a;

    /* renamed from: b */
    TextView f1512b;

    /* renamed from: c */
    Button f1513c;

    /* renamed from: d */
    Button f1514d;

    C0363du(View view) {
        this.f1511a = (ImageView) view.findViewById(R.id.listItemImage);
        this.f1512b = (TextView) view.findViewById(R.id.listItemText1);
        this.f1513c = (Button) view.findViewById(R.id.listItemButton);
        this.f1514d = (Button) view.findViewById(R.id.listItemMoreButton);
    }
}
