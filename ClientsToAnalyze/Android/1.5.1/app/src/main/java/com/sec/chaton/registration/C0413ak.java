package com.sec.chaton.registration;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.sec.chaton.C0062R;

/* renamed from: com.sec.chaton.registration.ak */
/* loaded from: classes.dex */
class C0413ak extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ CountryActivity f2921a;

    /* renamed from: b */
    private LayoutInflater f2922b;

    /* renamed from: c */
    private TextView f2923c;

    /* renamed from: d */
    private TextView f2924d;

    public C0413ak(CountryActivity countryActivity) {
        this.f2921a = countryActivity;
        this.f2922b = LayoutInflater.from(countryActivity.f2900f);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f2921a.f2895a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f2921a.f2895a.get(Integer.valueOf(i));
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate = this.f2922b.inflate(C0062R.layout.layout_item_country, viewGroup, false);
        this.f2921a.f2905k = (CheckBox) viewInflate.findViewById(C0062R.id.country_item_radio);
        this.f2923c = (TextView) viewInflate.findViewById(C0062R.id.country_item_text);
        this.f2924d = (TextView) viewInflate.findViewById(C0062R.id.country_item_code);
        if (this.f2921a.f2903i == null || this.f2921a.f2903i.size() <= 0) {
            this.f2923c.setText(this.f2921a.f2899e[i].toString());
            this.f2924d.setText(" (+" + this.f2921a.f2901g[i].toString() + ")");
        } else {
            this.f2921a.f2905k.setChecked(false);
            this.f2923c.setText((CharSequence) this.f2921a.f2903i.get(i));
            this.f2924d.setText(" (+" + this.f2921a.f2895a.get(this.f2921a.f2903i.get(i)) + ")");
        }
        if (this.f2921a.f2898d == i && this.f2921a.f2906l) {
            this.f2921a.f2905k.setChecked(true);
        } else {
            this.f2921a.f2905k.setChecked(false);
        }
        return viewInflate;
    }
}
