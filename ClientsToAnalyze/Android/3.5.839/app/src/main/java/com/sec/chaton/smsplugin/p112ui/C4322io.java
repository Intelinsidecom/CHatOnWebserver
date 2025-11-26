package com.sec.chaton.smsplugin.p112ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.p110g.C3869o;
import com.sec.chaton.smsplugin.p110g.C3870p;

/* compiled from: SlideshowEditActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.io */
/* loaded from: classes.dex */
class C4322io extends ArrayAdapter<C3869o> {

    /* renamed from: a */
    private final Context f15721a;

    /* renamed from: b */
    private final int f15722b;

    /* renamed from: c */
    private final LayoutInflater f15723c;

    /* renamed from: d */
    private final C3870p f15724d;

    public C4322io(Context context, int i, C3870p c3870p) {
        super(context, i, c3870p);
        this.f15721a = context;
        this.f15722b = i;
        this.f15723c = LayoutInflater.from(context);
        this.f15724d = c3870p;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return m16487a(i, view, this.f15722b);
    }

    /* renamed from: a */
    private View m16487a(int i, View view, int i2) {
        SlideListItemView slideListItemView = (SlideListItemView) this.f15723c.inflate(i2, (ViewGroup) null);
        ((TextView) slideListItemView.findViewById(R.id.slide_number_text)).setText(this.f15721a.getString(R.string.slide_number, Integer.valueOf(i + 1)));
        int iM14849a = getItem(i).m14849a() / 1000;
        ((TextView) slideListItemView.findViewById(R.id.duration_text)).setText(this.f15721a.getResources().getQuantityString(R.plurals.slide_duration, iM14849a, Integer.valueOf(iM14849a)));
        AbstractC4277gx abstractC4277gxM16480a = C4278gy.m16480a("SlideshowPresenter", this.f15721a, slideListItemView, this.f15724d);
        ((SlideshowPresenter) abstractC4277gxM16480a).setLocation(i);
        abstractC4277gxM16480a.present();
        return slideListItemView;
    }
}
