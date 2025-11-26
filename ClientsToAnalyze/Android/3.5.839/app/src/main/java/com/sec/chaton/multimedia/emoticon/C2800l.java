package com.sec.chaton.multimedia.emoticon;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.emoticon.anicon.CallableC2789u;
import com.sec.common.p132g.C5006b;
import com.sec.common.p132g.C5007c;
import com.sec.common.util.C5034k;

/* compiled from: RecentMruAdapter.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.l */
/* loaded from: classes.dex */
public class C2800l extends AbstractC2790b {

    /* renamed from: c */
    private static final String f10113c = C2800l.class.getSimpleName();

    /* renamed from: d */
    private int f10114d;

    /* renamed from: e */
    private C5007c f10115e;

    /* renamed from: f */
    private LayoutInflater f10116f;

    public C2800l(Context context, C5006b c5006b, C5007c c5007c) {
        super(context, c5006b);
        m11713a(c5007c);
    }

    /* renamed from: a */
    private void m11713a(C5007c c5007c) {
        Resources resources = this.f10100a.getResources();
        this.f10115e = c5007c;
        this.f10114d = resources.getDimensionPixelOffset(R.dimen.recent_gridview_item_height);
        this.f10116f = (LayoutInflater) this.f10100a.getSystemService("layout_inflater");
    }

    @Override // com.sec.chaton.multimedia.emoticon.AbstractC2790b
    /* renamed from: a */
    public View mo11701a(Context context, ViewGroup viewGroup) {
        View viewInflate = this.f10116f.inflate(R.layout.layout_anicon_container_item, viewGroup, false);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, this.f10114d);
        C2801m c2801m = new C2801m();
        c2801m.f10117a = (ImageView) viewInflate.findViewById(R.id.anicon_image);
        c2801m.f10117a.setScaleType(ImageView.ScaleType.FIT_XY);
        c2801m.f10118b = (ImageView) viewInflate.findViewById(R.id.anicon_icon);
        viewInflate.setLayoutParams(layoutParams);
        viewInflate.setTag(c2801m);
        return viewInflate;
    }

    @Override // com.sec.chaton.multimedia.emoticon.AbstractC2790b
    /* renamed from: a */
    public void mo11702a(Context context, String str, View view) {
        C2801m c2801m = (C2801m) view.getTag();
        c2801m.f10119c = str;
        int iM11704a = C2797i.m11704a(str);
        if (iM11704a != -1) {
            c2801m.f10118b.setVisibility(8);
            c2801m.f10117a.setImageResource(iM11704a);
            c2801m.f10120d = "emoticon";
            view.setTag(c2801m);
            return;
        }
        c2801m.f10120d = "anicon";
        if (str == null || str.equals(String.valueOf(Integer.MIN_VALUE))) {
            this.f10115e.m19020a(c2801m.f10119c);
            ((ImageView) view).setImageResource(R.drawable.chat_anicon_btn_shop);
            view.setTag(str);
        } else {
            CallableC2789u callableC2789u = new CallableC2789u(str, C5034k.m19100e(), C5034k.m19101f(), c2801m.f10118b);
            callableC2789u.m18990a((View) c2801m.f10117a);
            this.f10115e.m19023b(c2801m.f10117a, callableC2789u);
        }
    }
}
