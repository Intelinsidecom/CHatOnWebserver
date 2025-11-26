package com.sec.chaton.registration;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.widget.GeneralHeaderView;

/* compiled from: CountryActivity.java */
/* renamed from: com.sec.chaton.registration.ar */
/* loaded from: classes.dex */
class C0946ar extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ CountryActivity f3333a;

    /* renamed from: b */
    private LayoutInflater f3334b;

    /* renamed from: c */
    private TextView f3335c;

    /* renamed from: d */
    private TextView f3336d;

    /* renamed from: e */
    private GeneralHeaderView f3337e;

    public C0946ar(CountryActivity countryActivity) {
        this.f3333a = countryActivity;
        this.f3334b = LayoutInflater.from(countryActivity.f3289h);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f3333a.f3282a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f3333a.f3282a.get(Integer.valueOf(i));
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f3334b.inflate(R.layout.layout_item_country, viewGroup, false);
        }
        this.f3337e = (GeneralHeaderView) this.f3333a.findViewById(R.id.subTitle);
        this.f3333a.f3294m = (CheckBox) view.findViewById(R.id.country_item_radio);
        this.f3335c = (TextView) view.findViewById(R.id.country_item_text);
        this.f3336d = (TextView) view.findViewById(R.id.country_item_code);
        if (this.f3333a.f3298q == 0) {
            this.f3336d.setVisibility(8);
        }
        if (this.f3333a.f3292k == null || this.f3333a.f3292k.size() <= 0) {
            if (i < this.f3333a.f3287f.length) {
                this.f3335c.setText(this.f3333a.f3287f[i].toString());
            }
            if (i < this.f3333a.f3290i.length) {
                this.f3336d.setText(" (+" + this.f3333a.f3290i[i].toString() + ")");
            }
        } else {
            this.f3333a.f3294m.setChecked(false);
            this.f3335c.setText((CharSequence) this.f3333a.f3292k.get(i));
            this.f3336d.setText(" (+" + this.f3333a.f3282a.get(this.f3333a.f3292k.get(i)) + ")");
        }
        if (this.f3333a.f3286e != i || !this.f3333a.f3295n) {
            this.f3333a.f3294m.setChecked(false);
        } else {
            this.f3333a.f3294m.setChecked(true);
        }
        return view;
    }
}
