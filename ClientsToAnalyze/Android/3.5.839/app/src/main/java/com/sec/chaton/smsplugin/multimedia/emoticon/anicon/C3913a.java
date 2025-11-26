package com.sec.chaton.smsplugin.multimedia.emoticon.anicon;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.support.v4.widget.AbstractC0243c;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.emoticon.anicon.CallableC2789u;
import com.sec.common.p132g.C5007c;
import com.sec.common.util.C5034k;

/* compiled from: AniconAdapter.java */
/* renamed from: com.sec.chaton.smsplugin.multimedia.emoticon.anicon.a */
/* loaded from: classes.dex */
public class C3913a extends AbstractC0243c {

    /* renamed from: j */
    private int f14100j;

    /* renamed from: k */
    private C5007c f14101k;

    /* renamed from: l */
    private LayoutInflater f14102l;

    public C3913a(Context context, Cursor cursor, int i, C5007c c5007c) {
        super(context, cursor, i);
        m15132a(c5007c);
    }

    /* renamed from: a */
    private void m15132a(C5007c c5007c) {
        Resources resources = this.f580d.getResources();
        this.f14101k = c5007c;
        this.f14100j = resources.getDimensionPixelOffset(R.dimen.anicon_gridview_item_height);
        this.f14102l = (LayoutInflater) this.f580d.getSystemService("layout_inflater");
    }

    @Override // android.support.v4.widget.AbstractC0243c
    /* renamed from: a */
    public View mo873a(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewInflate = this.f14102l.inflate(R.layout.layout_anicon_container_item, viewGroup, false);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, this.f14100j);
        C3914b c3914b = new C3914b();
        c3914b.f14103a = (ImageView) viewInflate.findViewById(R.id.anicon_image);
        c3914b.f14104b = (ImageView) viewInflate.findViewById(R.id.anicon_icon);
        viewInflate.setLayoutParams(layoutParams);
        viewInflate.setTag(c3914b);
        return viewInflate;
    }

    @Override // android.support.v4.widget.AbstractC0243c
    /* renamed from: a */
    public void mo876a(View view, Context context, Cursor cursor) {
        C3914b c3914b = (C3914b) view.getTag();
        String string = cursor.getString(cursor.getColumnIndex("anicon_id"));
        c3914b.f14105c = string;
        c3914b.f14106d = cursor.getString(cursor.getColumnIndex("package_id"));
        if (string.equals(String.valueOf(Integer.MIN_VALUE))) {
            this.f14101k.m19015a((View) c3914b.f14103a);
            ((ImageView) view).setImageResource(R.drawable.chat_anicon_btn_down);
            view.setTag(string);
        } else {
            CallableC2789u callableC2789u = new CallableC2789u(string, C5034k.m19100e(), C5034k.m19101f(), c3914b.f14104b);
            callableC2789u.m18990a((View) c3914b.f14103a);
            this.f14101k.m19023b(c3914b.f14103a, callableC2789u);
        }
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
    }
}
