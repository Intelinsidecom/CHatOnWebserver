package com.sec.chaton.multimedia.doc;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;

/* compiled from: FileListAdapter.java */
/* renamed from: com.sec.chaton.multimedia.doc.i */
/* loaded from: classes.dex */
class C2765i {

    /* renamed from: a */
    ImageView f9978a;

    /* renamed from: b */
    TextView f9979b;

    /* renamed from: c */
    TextView f9980c;

    @SuppressLint({"NewApi"})
    public C2765i(View view) {
        this.f9978a = (ImageView) view.findViewById(R.id.image1);
        this.f9978a.setAdjustViewBounds(true);
        if (Build.VERSION.SDK_INT < 16) {
            this.f9978a.setBackgroundDrawable(null);
        } else {
            this.f9978a.setBackground(null);
        }
        this.f9979b = (TextView) view.findViewById(R.id.text1);
        this.f9979b.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        this.f9980c = (TextView) view.findViewById(R.id.text2);
    }
}
