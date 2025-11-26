package com.sec.chaton.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.sec.chaton.R;
import java.util.ArrayList;

/* compiled from: MenuSpinner.java */
/* renamed from: com.sec.chaton.widget.b */
/* loaded from: classes.dex */
public class C1798b extends BaseAdapter {

    /* renamed from: a */
    private ArrayList f6485a;

    /* renamed from: b */
    private LayoutInflater f6486b;

    /* renamed from: c */
    private Context f6487c;

    public C1798b(Context context, ArrayList arrayList) {
        this.f6487c = context;
        this.f6485a = arrayList;
        this.f6486b = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f6485a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f6485a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1797a c1797a = (C1797a) this.f6485a.get(i);
        View viewInflate = this.f6486b.inflate(R.layout.optionmenu_item_layout, viewGroup, false);
        viewInflate.setVisibility(0);
        viewInflate.setBackgroundResource(R.drawable.settings_preference_item_xml);
        ((TextView) viewInflate).setText(c1797a.f6483a);
        ((TextView) viewInflate).setCompoundDrawablesWithIntrinsicBounds(this.f6487c.getResources().getDrawable(c1797a.f6484b), (Drawable) null, (Drawable) null, (Drawable) null);
        viewInflate.setPadding(10, 0, 0, 0);
        viewInflate.setTag(c1797a.f6483a);
        return viewInflate;
    }
}
