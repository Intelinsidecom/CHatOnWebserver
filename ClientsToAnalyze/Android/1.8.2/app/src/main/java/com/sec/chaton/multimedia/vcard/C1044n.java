package com.sec.chaton.multimedia.vcard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.sec.chaton.R;
import java.util.List;

/* compiled from: ReadVCardAdapter.java */
/* renamed from: com.sec.chaton.multimedia.vcard.n */
/* loaded from: classes.dex */
public class C1044n extends BaseAdapter {

    /* renamed from: a */
    private ReadVCardActivity f3885a;

    /* renamed from: b */
    private LayoutInflater f3886b;

    /* renamed from: c */
    private List f3887c;

    public C1044n(ReadVCardActivity readVCardActivity, List list) {
        this.f3885a = readVCardActivity;
        this.f3886b = (LayoutInflater) readVCardActivity.getSystemService("layout_inflater");
        this.f3887c = list;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1045o c1045o;
        if (view == null) {
            LinearLayout linearLayout = (LinearLayout) this.f3886b.inflate(R.layout.item_list_multimedia_vcard, viewGroup, false);
            c1045o = new C1045o(linearLayout);
            view = linearLayout;
        } else {
            c1045o = (C1045o) view.getTag();
        }
        c1045o.f3890c.setVisibility(8);
        if (((C1039i) this.f3887c.get(i)).f3859e) {
            ((LinearLayout) view.findViewById(R.id.vcard_item_header)).setVisibility(0);
        } else {
            ((LinearLayout) view.findViewById(R.id.vcard_item_header)).setVisibility(8);
        }
        this.f3885a.m4002a(c1045o.f3888a, (C1039i) this.f3887c.get(i));
        this.f3885a.m4004b(c1045o.f3889b, (C1039i) this.f3887c.get(i));
        this.f3885a.m4006c(c1045o.f3891d, (C1039i) this.f3887c.get(i));
        view.setTag(c1045o);
        return view;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f3887c.size();
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C1039i getItem(int i) {
        return (C1039i) this.f3887c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return ((C1039i) this.f3887c.get(i)).f3858d;
    }
}
