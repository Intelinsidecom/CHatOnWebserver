package com.sec.chaton.registration;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: CountryActivity.java */
/* renamed from: com.sec.chaton.registration.bl */
/* loaded from: classes.dex */
class C2161bl extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ CountryActivity f8442a;

    /* renamed from: b */
    private LayoutInflater f8443b;

    /* renamed from: c */
    private TextView f8444c;

    /* renamed from: d */
    private TextView f8445d;

    /* renamed from: e */
    private String f8446e = null;

    public C2161bl(CountryActivity countryActivity) {
        this.f8442a = countryActivity;
        this.f8443b = LayoutInflater.from(countryActivity.f8182g);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f8442a.f8176a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f8442a.f8176a.get(Integer.valueOf(i));
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    /* renamed from: a */
    public void m8675a(String str) {
        this.f8446e = str;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int iIndexOf;
        if (view == null) {
            view = this.f8443b.inflate(R.layout.list_item_common_2, viewGroup, false);
        }
        this.f8444c = (TextView) view.findViewById(R.id.text1);
        this.f8445d = (TextView) view.findViewById(R.id.text2);
        if (this.f8442a.f8188m == 0) {
            this.f8445d.setVisibility(8);
            this.f8444c.setGravity(16);
        }
        if (this.f8442a.f8185j == null || this.f8442a.f8185j.size() <= 0) {
            if (i < this.f8442a.f8180e.length) {
                this.f8444c.setText(this.f8442a.f8180e[i].toString());
            }
            if (i < this.f8442a.f8183h.length) {
                this.f8445d.setText(" (+" + this.f8442a.f8183h[i].toString() + ")");
            }
        } else {
            this.f8444c.setText((CharSequence) this.f8442a.f8185j.get(i));
            this.f8445d.setText(" (+" + ((Object) this.f8442a.f8176a.get(this.f8442a.f8185j.get(i))) + ")");
        }
        if (this.f8446e != null && this.f8446e.length() > 0 && (iIndexOf = this.f8444c.getText().toString().toLowerCase().indexOf(this.f8446e.toString().toLowerCase())) >= 0) {
            int length = this.f8446e.length() + iIndexOf;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f8444c.getText().toString());
            spannableStringBuilder.setSpan(new ForegroundColorSpan(GlobalApplication.m6451b().getColor(R.color.buddy_list_item_status_highlight)), iIndexOf, length, 33);
            this.f8444c.setText(spannableStringBuilder);
        }
        return view;
    }
}
