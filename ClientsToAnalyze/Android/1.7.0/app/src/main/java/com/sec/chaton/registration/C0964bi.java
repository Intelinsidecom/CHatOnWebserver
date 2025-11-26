package com.sec.chaton.registration;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.util.C1341p;
import com.sec.widget.GeneralHeaderView;

/* compiled from: SelectLanguage.java */
/* renamed from: com.sec.chaton.registration.bi */
/* loaded from: classes.dex */
class C0964bi extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ SelectLanguage f3357a;

    /* renamed from: b */
    private LayoutInflater f3358b;

    /* renamed from: c */
    private TextView f3359c;

    /* renamed from: d */
    private TextView f3360d;

    /* renamed from: e */
    private GeneralHeaderView f3361e;

    public C0964bi(SelectLanguage selectLanguage) {
        this.f3357a = selectLanguage;
        this.f3358b = LayoutInflater.from(selectLanguage.f3308e);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f3357a.f3314k.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f3357a.f3314k.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate = this.f3358b.inflate(R.layout.layout_item_country, viewGroup, false);
        this.f3361e = (GeneralHeaderView) this.f3357a.findViewById(R.id.subTitle);
        this.f3357a.f3311h = (CheckBox) viewInflate.findViewById(R.id.country_item_radio);
        this.f3359c = (TextView) viewInflate.findViewById(R.id.country_item_text);
        this.f3360d = (TextView) viewInflate.findViewById(R.id.country_item_code);
        this.f3360d.setVisibility(8);
        this.f3361e.setText(R.string.select_language);
        if (this.f3357a.f3310g == null || this.f3357a.f3310g.size() <= 0) {
            if (i < this.f3357a.f3307d.length) {
                this.f3359c.setText(this.f3357a.f3307d[i].toString());
            }
        } else {
            this.f3357a.f3311h.setChecked(false);
            this.f3359c.setText((CharSequence) this.f3357a.f3310g.get(i));
            C1341p.m4658b("mFilteredCountry =" + this.f3357a.f3310g + "position" + i, getClass().getSimpleName());
        }
        if (this.f3357a.f3306c != i || !this.f3357a.f3312i) {
            this.f3357a.f3311h.setChecked(false);
        } else {
            this.f3357a.f3311h.setChecked(true);
        }
        return viewInflate;
    }
}
