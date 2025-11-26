package com.sec.chaton.multimedia.vcard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.sec.chaton.R;
import java.util.List;

/* compiled from: ReadVCardAdapter.java */
/* renamed from: com.sec.chaton.multimedia.vcard.t */
/* loaded from: classes.dex */
public class C0843t extends BaseAdapter {

    /* renamed from: a */
    private ReadVCardActivity f2925a;

    /* renamed from: b */
    private LayoutInflater f2926b;

    /* renamed from: c */
    private List f2927c;

    public C0843t(ReadVCardActivity readVCardActivity, List list) {
        this.f2925a = readVCardActivity;
        this.f2926b = (LayoutInflater) readVCardActivity.getSystemService("layout_inflater");
        this.f2927c = list;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0827d c0827d;
        if (view == null) {
            LinearLayout linearLayout = (LinearLayout) this.f2926b.inflate(R.layout.item_list_multimedia_vcard, viewGroup, false);
            c0827d = new C0827d(linearLayout);
            view = linearLayout;
        } else {
            c0827d = (C0827d) view.getTag();
        }
        c0827d.f2871c.setVisibility(8);
        this.f2925a.m3365a(c0827d.f2869a, (C0834k) this.f2927c.get(i));
        this.f2925a.m3367b(c0827d.f2870b, (C0834k) this.f2927c.get(i));
        view.setTag(c0827d);
        return view;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f2927c.size();
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0834k getItem(int i) {
        return (C0834k) this.f2927c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return ((C0834k) this.f2927c.get(i)).f2910d;
    }
}
