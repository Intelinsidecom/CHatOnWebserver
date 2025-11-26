package com.sec.chaton.multimedia.emoticon;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.sec.common.p069e.C3325b;

/* compiled from: AbstractMruAdapter.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.b */
/* loaded from: classes.dex */
public abstract class AbstractC1827b extends BaseAdapter {

    /* renamed from: a */
    protected Context f6814a;

    /* renamed from: b */
    protected C3325b f6815b;

    /* renamed from: c */
    private String[] f6816c;

    /* renamed from: d */
    private C1829d f6817d = new C1829d(this);

    /* renamed from: a */
    public abstract View mo7501a(Context context);

    /* renamed from: a */
    public abstract void mo7502a(Context context, String str, View view);

    public AbstractC1827b(Context context, C3325b c3325b) {
        this.f6814a = context;
        this.f6815b = c3325b;
        this.f6816c = c3325b.m11720a();
        this.f6815b.registerObserver(this.f6817d);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f6816c.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f6816c[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        String str = this.f6816c[i];
        if (view == null) {
            view = mo7501a(this.f6814a);
        }
        mo7502a(this.f6814a, str, view);
        return view;
    }
}
