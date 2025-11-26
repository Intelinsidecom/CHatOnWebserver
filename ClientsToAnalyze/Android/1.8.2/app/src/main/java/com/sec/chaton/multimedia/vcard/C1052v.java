package com.sec.chaton.multimedia.vcard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import java.util.List;

/* compiled from: VCardReadContactAdapter.java */
/* renamed from: com.sec.chaton.multimedia.vcard.v */
/* loaded from: classes.dex */
public class C1052v extends BaseAdapter {

    /* renamed from: a */
    private VCardReadContactActivity f3906a;

    /* renamed from: b */
    private LayoutInflater f3907b;

    /* renamed from: c */
    private List f3908c;

    public C1052v(VCardReadContactActivity vCardReadContactActivity, List list) {
        this.f3906a = vCardReadContactActivity;
        this.f3907b = (LayoutInflater) vCardReadContactActivity.getSystemService("layout_inflater");
        this.f3908c = list;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1053w c1053w;
        if (view == null) {
            LinearLayout linearLayout = (LinearLayout) this.f3907b.inflate(R.layout.item_list_multimedia_vcard, viewGroup, false);
            c1053w = new C1053w(linearLayout);
            view = linearLayout;
        } else {
            c1053w = (C1053w) view.getTag();
        }
        if (GlobalApplication.m3265f()) {
            if (((C1039i) this.f3908c.get(i)).f3859e) {
                ((LinearLayout) view.findViewById(R.id.vcard_item_header)).setVisibility(0);
            } else {
                ((LinearLayout) view.findViewById(R.id.vcard_item_header)).setVisibility(8);
            }
        }
        this.f3906a.m4017a(c1053w.f3912d, (C1039i) this.f3908c.get(i));
        this.f3906a.m4020b(c1053w.f3909a, (C1039i) this.f3908c.get(i));
        this.f3906a.m4021c(c1053w.f3910b, (C1039i) this.f3908c.get(i));
        this.f3906a.m4022d(c1053w.f3911c, (C1039i) this.f3908c.get(i));
        view.setTag(c1053w);
        return view;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f3908c.size();
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C1039i getItem(int i) {
        return (C1039i) this.f3908c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return ((C1039i) this.f3908c.get(i)).f3858d;
    }
}
