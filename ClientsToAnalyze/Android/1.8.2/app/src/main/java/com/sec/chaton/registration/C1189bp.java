package com.sec.chaton.registration;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;

/* compiled from: SelectLanguage.java */
/* renamed from: com.sec.chaton.registration.bp */
/* loaded from: classes.dex */
class C1189bp extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ SelectLanguage f4399a;

    /* renamed from: b */
    private LayoutInflater f4400b;

    /* renamed from: c */
    private TextView f4401c;

    /* renamed from: d */
    private TextView f4402d;

    /* renamed from: e */
    private TextView f4403e;

    /* renamed from: f */
    private char f4404f;

    public C1189bp(SelectLanguage selectLanguage) {
        this.f4399a = selectLanguage;
        this.f4400b = LayoutInflater.from(selectLanguage.f4340e);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f4399a.f4346k.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f4399a.f4346k.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate = this.f4400b.inflate(R.layout.layout_item_country, viewGroup, false);
        this.f4403e = (TextView) this.f4399a.findViewById(R.id.subTitle);
        this.f4399a.f4343h = (CheckBox) viewInflate.findViewById(R.id.country_item_radio);
        this.f4401c = (TextView) viewInflate.findViewById(R.id.country_item_text);
        this.f4402d = (TextView) viewInflate.findViewById(R.id.country_item_code);
        this.f4402d.setVisibility(8);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.section);
        String string = this.f4399a.f4339d[i].toString();
        char cCharAt = string.toUpperCase().charAt(0);
        if (i == 0) {
            this.f4399a.m4448a(linearLayout, string);
        } else {
            this.f4404f = this.f4399a.f4339d[i - 1].toString().toUpperCase().charAt(0);
            if (cCharAt != this.f4404f) {
                this.f4399a.m4448a(linearLayout, string);
            } else {
                linearLayout.setVisibility(8);
            }
        }
        this.f4403e.setText(R.string.select_language);
        this.f4399a.f4347l.setText(R.string.select_language);
        this.f4399a.f4336a.setHint(R.string.select_language);
        if (this.f4399a.f4342g == null || this.f4399a.f4342g.size() <= 0) {
            if (i < this.f4399a.f4339d.length) {
                this.f4401c.setText(this.f4399a.f4339d[i].toString());
            }
        } else {
            this.f4399a.f4343h.setChecked(false);
            this.f4401c.setText((CharSequence) this.f4399a.f4342g.get(i));
            linearLayout.setVisibility(8);
            linearLayout.removeView(linearLayout);
            C1786r.m6061b("mFilteredCountry =" + this.f4399a.f4342g + "position" + i, getClass().getSimpleName());
        }
        if (this.f4399a.f4338c != i || !this.f4399a.f4344i) {
            this.f4399a.f4343h.setChecked(false);
        } else {
            this.f4399a.f4343h.setChecked(true);
        }
        if (!this.f4399a.f4336a.getText().toString().equals("")) {
            linearLayout.setVisibility(8);
        } else if (i == 0) {
            linearLayout.setVisibility(0);
        } else {
            this.f4404f = this.f4399a.f4339d[i - 1].toString().toUpperCase().charAt(0);
            if (cCharAt != this.f4404f) {
                linearLayout.setVisibility(0);
            } else {
                linearLayout.setVisibility(8);
            }
        }
        return viewInflate;
    }
}
