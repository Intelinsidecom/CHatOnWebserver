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
/* renamed from: com.sec.chaton.registration.z */
/* loaded from: classes.dex */
class C3319z extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ CountryActivity f12102a;

    /* renamed from: b */
    private LayoutInflater f12103b;

    /* renamed from: c */
    private TextView f12104c;

    /* renamed from: d */
    private TextView f12105d;

    /* renamed from: e */
    private String f12106e = null;

    public C3319z(CountryActivity countryActivity) {
        this.f12102a = countryActivity;
        this.f12103b = LayoutInflater.from(countryActivity.f11600g);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f12102a.f11594a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f12102a.f11594a.get(Integer.valueOf(i));
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    /* renamed from: a */
    public void m13051a(String str) {
        this.f12106e = str;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f12103b.inflate(R.layout.list_item_common_2, viewGroup, false);
        }
        this.f12104c = (TextView) view.findViewById(R.id.text1);
        this.f12105d = (TextView) view.findViewById(R.id.text2);
        if (this.f12102a.f11606m == 0) {
            this.f12105d.setVisibility(8);
            this.f12104c.setGravity(16);
        }
        if (this.f12102a.f11603j == null || this.f12102a.f11603j.size() <= 0) {
            if (i < this.f12102a.f11598e.length) {
                this.f12104c.setText(this.f12102a.f11598e[i].toString());
            }
            if (i < this.f12102a.f11601h.length) {
                this.f12105d.setText(" (+" + this.f12102a.f11601h[i].toString() + ")");
            }
        } else {
            this.f12104c.setText((CharSequence) this.f12102a.f11603j.get(i));
            this.f12105d.setText(" (+" + ((Object) this.f12102a.f11594a.get(this.f12102a.f11603j.get(i))) + ")");
        }
        if (this.f12106e != null && this.f12106e.length() > 0) {
            int iIndexOf = this.f12104c.getText().toString().toLowerCase().indexOf(this.f12106e.toString().toLowerCase());
            if (iIndexOf >= 0) {
                int length = this.f12106e.length() + iIndexOf;
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f12104c.getText().toString());
                spannableStringBuilder.setSpan(new ForegroundColorSpan(GlobalApplication.m10283b().getColor(R.color.buddy_list_item_status_highlight)), iIndexOf, length, 33);
                this.f12104c.setText(spannableStringBuilder);
            } else {
                int iIndexOf2 = this.f12105d.getText().toString().indexOf(this.f12106e.toString());
                if (iIndexOf2 >= 0) {
                    int length2 = this.f12106e.length() + iIndexOf2;
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.f12105d.getText().toString());
                    spannableStringBuilder2.setSpan(new ForegroundColorSpan(GlobalApplication.m10283b().getColor(R.color.buddy_list_item_status_highlight)), iIndexOf2, length2, 33);
                    this.f12105d.setText(spannableStringBuilder2);
                }
            }
        }
        return view;
    }
}
