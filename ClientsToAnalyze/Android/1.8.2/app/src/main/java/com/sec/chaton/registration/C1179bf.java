package com.sec.chaton.registration;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.SectionIndexer;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: CountryActivity.java */
/* renamed from: com.sec.chaton.registration.bf */
/* loaded from: classes.dex */
class C1179bf extends BaseAdapter implements SectionIndexer {

    /* renamed from: a */
    String f4380a;

    /* renamed from: b */
    final /* synthetic */ CountryActivity f4381b;

    /* renamed from: c */
    private LayoutInflater f4382c;

    /* renamed from: d */
    private TextView f4383d;

    /* renamed from: e */
    private TextView f4384e;

    /* renamed from: f */
    private TextView f4385f;

    /* renamed from: g */
    private LinearLayout f4386g;

    /* renamed from: h */
    private char f4387h;

    /* renamed from: i */
    private View f4388i;

    /* renamed from: j */
    private String f4389j = null;

    public C1179bf(CountryActivity countryActivity) {
        this.f4381b = countryActivity;
        this.f4382c = LayoutInflater.from(countryActivity.f4313f);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f4381b.f4308a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f4381b.f4308a.get(Integer.valueOf(i));
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    /* renamed from: a */
    public void m4462a(String str) {
        this.f4389j = str;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int iIndexOf;
        if (view == null) {
            view = this.f4382c.inflate(R.layout.layout_item_country, viewGroup, false);
        }
        this.f4385f = (TextView) this.f4381b.findViewById(R.id.subTitle);
        this.f4381b.f4318k = (CheckBox) view.findViewById(R.id.country_item_radio);
        this.f4383d = (TextView) view.findViewById(R.id.country_item_text);
        this.f4384e = (TextView) view.findViewById(R.id.country_item_code);
        this.f4386g = (LinearLayout) view.findViewById(R.id.section);
        this.f4380a = this.f4381b.f4312e[i].toString();
        char cCharAt = this.f4380a.toUpperCase().charAt(0);
        if (i == 0) {
            m4461a(this.f4386g, this.f4380a);
        } else {
            this.f4387h = this.f4381b.f4312e[i - 1].toString().toUpperCase().charAt(0);
            if (cCharAt != this.f4387h) {
                m4461a(this.f4386g, this.f4380a);
            } else {
                this.f4386g.setVisibility(8);
            }
        }
        if (this.f4381b.f4322o == 0) {
            this.f4384e.setVisibility(8);
            this.f4385f.setText(R.string.select_country);
        }
        if (this.f4381b.f4316i == null || this.f4381b.f4316i.size() <= 0) {
            if (i < this.f4381b.f4312e.length) {
                this.f4383d.setText(this.f4381b.f4312e[i].toString());
            }
            if (i < this.f4381b.f4314g.length) {
                this.f4384e.setText(" (+" + this.f4381b.f4314g[i].toString() + ")");
            }
        } else {
            this.f4381b.f4318k.setChecked(false);
            this.f4383d.setText((CharSequence) this.f4381b.f4316i.get(i));
            this.f4384e.setText(" (+" + this.f4381b.f4308a.get(this.f4381b.f4316i.get(i)) + ")");
            this.f4386g.setVisibility(8);
            this.f4386g.removeView(this.f4386g);
        }
        if (this.f4389j != null && this.f4389j.length() > 0 && (iIndexOf = this.f4383d.getText().toString().toLowerCase().indexOf(this.f4389j.toString().toLowerCase())) >= 0) {
            int length = this.f4389j.length() + iIndexOf;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f4383d.getText().toString());
            spannableStringBuilder.setSpan(new ForegroundColorSpan(GlobalApplication.m3262c().getColor(R.color.buddy_list_item_status_highlight)), iIndexOf, length, 33);
            this.f4383d.setText(spannableStringBuilder);
        }
        if (this.f4381b.f4311d != i || !this.f4381b.f4319l) {
            this.f4381b.f4318k.setChecked(false);
        } else {
            this.f4381b.f4318k.setChecked(true);
        }
        if (!this.f4381b.f4309b.getText().toString().equals("")) {
            this.f4386g.setVisibility(8);
        } else if (i == 0) {
            this.f4386g.setVisibility(0);
        } else {
            this.f4387h = this.f4381b.f4312e[i - 1].toString().toUpperCase().charAt(0);
            if (cCharAt != this.f4387h) {
                LinearLayout linearLayout = this.f4386g;
                View view2 = this.f4388i;
                linearLayout.setVisibility(0);
            } else {
                this.f4386g.setVisibility(8);
            }
        }
        return view;
    }

    /* renamed from: a */
    private void m4461a(LinearLayout linearLayout, String str) {
        linearLayout.removeAllViews();
        TextView textView = new TextView(this.f4381b.f4313f);
        linearLayout.setBackgroundResource(R.drawable.sub_title_bg);
        textView.setTextColor(-1);
        textView.setText(str.substring(0, 1).toUpperCase());
        textView.setTextSize(1, 15.0f);
        textView.setPadding(5, 0, 0, 0);
        textView.setGravity(16);
        linearLayout.addView(textView);
    }

    @Override // android.widget.SectionIndexer
    public int getPositionForSection(int i) {
        if (i == 35) {
            return 0;
        }
        for (int i2 = 0; i2 < this.f4381b.f4312e.length; i2++) {
            if (this.f4381b.f4312e[i2].toString().toUpperCase().charAt(0) == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // android.widget.SectionIndexer
    public int getSectionForPosition(int i) {
        return 0;
    }

    @Override // android.widget.SectionIndexer
    public Object[] getSections() {
        return null;
    }
}
