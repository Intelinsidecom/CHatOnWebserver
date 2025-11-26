package com.sec.chaton.registration;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.util.C3250y;

/* compiled from: SelectLanguageFragment.java */
/* renamed from: com.sec.chaton.registration.gf */
/* loaded from: classes.dex */
public class C2290gf extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ SelectLanguageFragment f8592a;

    /* renamed from: b */
    private LayoutInflater f8593b;

    /* renamed from: c */
    private TextView f8594c;

    /* renamed from: d */
    private TextView f8595d;

    public C2290gf(SelectLanguageFragment selectLanguageFragment) {
        this.f8592a = selectLanguageFragment;
        this.f8593b = LayoutInflater.from(selectLanguageFragment.f8380d);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f8592a.f8383g.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f8592a.f8383g.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate = this.f8593b.inflate(R.layout.list_item_common_2, viewGroup, false);
        this.f8594c = (TextView) viewInflate.findViewById(R.id.text1);
        this.f8594c.setGravity(16);
        this.f8595d = (TextView) viewInflate.findViewById(R.id.text2);
        this.f8595d.setVisibility(8);
        if (this.f8592a.f8382f == null || this.f8592a.f8382f.size() <= 0) {
            if (i < this.f8592a.f8379c.length) {
                this.f8594c.setText(this.f8592a.f8379c[i].toString());
            }
        } else {
            this.f8594c.setText((CharSequence) this.f8592a.f8382f.get(i));
            C3250y.m11450b("mFilteredCountry =" + this.f8592a.f8382f + "position" + i, getClass().getSimpleName());
        }
        return viewInflate;
    }
}
