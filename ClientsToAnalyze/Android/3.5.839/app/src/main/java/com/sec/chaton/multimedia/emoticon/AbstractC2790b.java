package com.sec.chaton.multimedia.emoticon;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.sec.common.p132g.C5006b;

/* compiled from: AbstractMruAdapter.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.b */
/* loaded from: classes.dex */
public abstract class AbstractC2790b extends BaseAdapter {

    /* renamed from: a */
    protected Context f10100a;

    /* renamed from: b */
    protected C5006b f10101b;

    /* renamed from: c */
    private String[] f10102c;

    /* renamed from: d */
    private C2792d f10103d = new C2792d(this);

    /* renamed from: a */
    public abstract View mo11701a(Context context, ViewGroup viewGroup);

    /* renamed from: a */
    public abstract void mo11702a(Context context, String str, View view);

    public AbstractC2790b(Context context, C5006b c5006b) {
        this.f10100a = context;
        this.f10101b = c5006b;
        this.f10102c = c5006b.mo11703a();
        this.f10101b.registerObserver(this.f10103d);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f10102c.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f10102c[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        String str = this.f10102c[i];
        if (view == null) {
            view = mo11701a(this.f10100a, viewGroup);
        }
        mo11702a(this.f10100a, str, view);
        return view;
    }
}
