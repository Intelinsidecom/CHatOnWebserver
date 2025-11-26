package com.sec.chaton.multimedia.vcard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.sec.chaton.R;
import java.util.List;

/* compiled from: VCardReadContactAdapter.java */
/* renamed from: com.sec.chaton.multimedia.vcard.l */
/* loaded from: classes.dex */
public class C0835l extends BaseAdapter {

    /* renamed from: a */
    private VCardReadContactActivity f2913a;

    /* renamed from: b */
    private LayoutInflater f2914b;

    /* renamed from: c */
    private List f2915c;

    public C0835l(VCardReadContactActivity vCardReadContactActivity, List list) {
        this.f2913a = vCardReadContactActivity;
        this.f2914b = (LayoutInflater) vCardReadContactActivity.getSystemService("layout_inflater");
        this.f2915c = list;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0832i c0832i;
        if (view == null) {
            LinearLayout linearLayout = (LinearLayout) this.f2914b.inflate(R.layout.item_list_multimedia_vcard, viewGroup, false);
            c0832i = new C0832i(linearLayout);
            view = linearLayout;
        } else {
            c0832i = (C0832i) view.getTag();
        }
        c0832i.f2893c.setChecked(((C0834k) this.f2915c.get(i)).f2912f);
        this.f2913a.m3381a(c0832i.f2891a, (C0834k) this.f2915c.get(i));
        this.f2913a.m3384b(c0832i.f2892b, (C0834k) this.f2915c.get(i));
        view.setTag(c0832i);
        return view;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f2915c.size();
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0834k getItem(int i) {
        return (C0834k) this.f2915c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return ((C0834k) this.f2915c.get(i)).f2910d;
    }
}
