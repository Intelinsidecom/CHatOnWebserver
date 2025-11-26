package com.sec.chaton.multimedia.doc;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;

/* compiled from: FileListAdapter.java */
/* renamed from: com.sec.chaton.multimedia.doc.h */
/* loaded from: classes.dex */
class C1801h {

    /* renamed from: a */
    ImageView f6686a;

    /* renamed from: b */
    TextView f6687b;

    /* renamed from: c */
    TextView f6688c;

    public C1801h(View view) {
        this.f6686a = (ImageView) view.findViewById(R.id.image1);
        this.f6686a.setAdjustViewBounds(true);
        this.f6687b = (TextView) view.findViewById(R.id.text1);
        this.f6687b.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        this.f6688c = (TextView) view.findViewById(R.id.text2);
    }
}
