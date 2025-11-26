package com.sec.chaton.multimedia.emoticon;

import android.content.Context;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.util.C3250y;
import com.sec.common.p069e.C3325b;
import com.sec.common.util.C3364o;

/* compiled from: EmoticonMruAdapter.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.g */
/* loaded from: classes.dex */
public class C1832g extends AbstractC1827b {

    /* renamed from: c */
    private static final String f6821c = C1832g.class.getSimpleName();

    public C1832g(Context context, C3325b c3325b) {
        super(context, c3325b);
    }

    @Override // com.sec.chaton.multimedia.emoticon.AbstractC1827b
    /* renamed from: a */
    public View mo7501a(Context context) {
        ImageView imageView = new ImageView(this.f6814a);
        imageView.setLayoutParams(new AbsListView.LayoutParams(-1, this.f6814a.getResources().getDimensionPixelOffset(R.dimen.emoticon_gridview_item_height)));
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        return imageView;
    }

    @Override // com.sec.chaton.multimedia.emoticon.AbstractC1827b
    /* renamed from: a */
    public void mo7502a(Context context, String str, View view) {
        int iM7503a = C1833h.m7503a(str);
        ImageView imageView = (ImageView) view;
        if (iM7503a != -1) {
            imageView.setImageResource(iM7503a);
            imageView.setTag(str);
            return;
        }
        imageView.setImageBitmap(null);
        imageView.setTag(null);
        if (C3250y.f11737e) {
            C3250y.m11442a(C3364o.m11849a("Unknown emoticon code.", str), f6821c);
        }
    }
}
