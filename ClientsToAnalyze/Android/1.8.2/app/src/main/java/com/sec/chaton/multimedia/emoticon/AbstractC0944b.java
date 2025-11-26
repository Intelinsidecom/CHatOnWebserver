package com.sec.chaton.multimedia.emoticon;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.sec.common.p056b.C1819c;

/* compiled from: AbstractMruAdapter.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.b */
/* loaded from: classes.dex */
public abstract class AbstractC0944b extends BaseAdapter {

    /* renamed from: a */
    protected Context f3507a;

    /* renamed from: b */
    protected C1819c f3508b;

    /* renamed from: c */
    private String[] f3509c;

    /* renamed from: d */
    private C0958d f3510d = new C0958d(this);

    /* renamed from: a */
    public abstract View mo3805a(Context context);

    /* renamed from: a */
    public abstract void mo3806a(Context context, String str, View view);

    public AbstractC0944b(Context context, C1819c c1819c) {
        this.f3507a = context;
        this.f3508b = c1819c;
        this.f3509c = c1819c.m6171a();
        this.f3508b.registerObserver(this.f3510d);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f3509c.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f3509c[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        String str = this.f3509c[i];
        if (view == null) {
            view = mo3805a(this.f3507a);
        }
        mo3806a(this.f3507a, str, view);
        return view;
    }
}
