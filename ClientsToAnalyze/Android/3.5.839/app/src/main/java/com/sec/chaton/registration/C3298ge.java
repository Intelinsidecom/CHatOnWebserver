package com.sec.chaton.registration;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.R;
import com.sec.chaton.util.C4904y;

/* compiled from: SelectLanguageFragment.java */
/* renamed from: com.sec.chaton.registration.ge */
/* loaded from: classes.dex */
public class C3298ge extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ SelectLanguageFragment f12069a;

    /* renamed from: b */
    private LayoutInflater f12070b;

    /* renamed from: c */
    private TextView f12071c;

    /* renamed from: d */
    private TextView f12072d;

    public C3298ge(SelectLanguageFragment selectLanguageFragment) {
        this.f12069a = selectLanguageFragment;
        this.f12070b = LayoutInflater.from(selectLanguageFragment.f11854l);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f12069a.f11857o.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f12069a.f11857o.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate = this.f12070b.inflate(R.layout.list_item_common_2, viewGroup, false);
        this.f12071c = (TextView) viewInflate.findViewById(R.id.text1);
        this.f12071c.setGravity(16);
        this.f12072d = (TextView) viewInflate.findViewById(R.id.text2);
        this.f12072d.setVisibility(8);
        if (this.f12069a.f11856n == null || this.f12069a.f11856n.size() <= 0) {
            if (i < this.f12069a.f11853k.length) {
                this.f12071c.setText(this.f12069a.f11853k[i].toString());
            }
        } else {
            this.f12071c.setText((CharSequence) this.f12069a.f11856n.get(i));
            C4904y.m18639b("mFilteredCountry =" + this.f12069a.f11856n + VKApiConst.POSITION + i, getClass().getSimpleName());
        }
        return viewInflate;
    }
}
