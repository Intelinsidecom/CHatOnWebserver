package com.sec.chaton.multimedia.emoticon;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.util.C4904y;
import com.sec.common.p132g.C5006b;
import com.sec.common.util.C5052r;

/* compiled from: EmoticonMruAdapter.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.g */
/* loaded from: classes.dex */
public class C2795g extends AbstractC2790b {

    /* renamed from: c */
    private static final String f10107c = C2795g.class.getSimpleName();

    public C2795g(Context context, C5006b c5006b) {
        super(context, c5006b);
    }

    @Override // com.sec.chaton.multimedia.emoticon.AbstractC2790b
    /* renamed from: a */
    public View mo11701a(Context context, ViewGroup viewGroup) {
        ImageView imageView = new ImageView(this.f10100a);
        imageView.setLayoutParams(new AbsListView.LayoutParams(-1, this.f10100a.getResources().getDimensionPixelOffset(R.dimen.emoticon_gridview_item_height)));
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        return imageView;
    }

    @Override // com.sec.chaton.multimedia.emoticon.AbstractC2790b
    /* renamed from: a */
    public void mo11702a(Context context, String str, View view) {
        int iM11704a = C2797i.m11704a(str);
        ImageView imageView = (ImageView) view;
        if (iM11704a != -1) {
            imageView.setImageResource(iM11704a);
            imageView.setTag(str);
            return;
        }
        imageView.setImageBitmap(null);
        imageView.setTag(null);
        if (C4904y.f17875e) {
            C4904y.m18634a(C5052r.m19199a("Unknown emoticon code.", str), f10107c);
        }
    }
}
