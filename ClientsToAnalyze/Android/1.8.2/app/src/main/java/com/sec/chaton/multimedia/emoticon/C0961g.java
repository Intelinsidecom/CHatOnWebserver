package com.sec.chaton.multimedia.emoticon;

import android.content.Context;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;
import com.sec.common.p056b.C1819c;
import com.sec.common.p056b.p060d.C1828c;

/* compiled from: EmoticonMruAdapter.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.g */
/* loaded from: classes.dex */
public class C0961g extends AbstractC0944b {

    /* renamed from: c */
    private static final String f3540c = C0961g.class.getSimpleName();

    public C0961g(Context context, C1819c c1819c) {
        super(context, c1819c);
    }

    @Override // com.sec.chaton.multimedia.emoticon.AbstractC0944b
    /* renamed from: a */
    public View mo3805a(Context context) {
        ImageView imageView = new ImageView(this.f3507a);
        imageView.setLayoutParams(new AbsListView.LayoutParams(-1, this.f3507a.getResources().getDimensionPixelOffset(R.dimen.emoticon_gridview_item_height)));
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        return imageView;
    }

    @Override // com.sec.chaton.multimedia.emoticon.AbstractC0944b
    /* renamed from: a */
    public void mo3806a(Context context, String str, View view) {
        int iM3818a = C0962h.m3818a(str);
        ImageView imageView = (ImageView) view;
        if (iM3818a != -1) {
            imageView.setImageResource(iM3818a);
            imageView.setTag(str);
            return;
        }
        imageView.setImageBitmap(null);
        imageView.setTag(null);
        if (C1786r.f6455e) {
            C1786r.m6054a(C1828c.m6207a("Unknown emoticon code.", str), f3540c);
        }
    }
}
