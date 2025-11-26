package com.sec.chaton.localbackup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.widget.CheckableRelativeLayout;
import java.util.ArrayList;

/* compiled from: BackuplistAdapter.java */
/* renamed from: com.sec.chaton.localbackup.o */
/* loaded from: classes.dex */
public class C1656o extends ArrayAdapter<C1651m> {

    /* renamed from: a */
    public boolean f6127a;

    /* renamed from: b */
    private LayoutInflater f6128b;

    public C1656o(Context context, ArrayList<C1651m> arrayList) {
        super(context, 0, arrayList);
        this.f6128b = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1657p c1657p;
        View viewInflate;
        if (view == null) {
            viewInflate = this.f6128b.inflate(R.layout.list_item_common_4, (ViewGroup) null);
            C1657p c1657p2 = new C1657p();
            c1657p2.f6129a = (TextView) viewInflate.findViewById(R.id.text1);
            c1657p2.f6130b = (TextView) viewInflate.findViewById(R.id.text2);
            c1657p2.f6131c = (CheckBox) viewInflate.findViewById(android.R.id.checkbox);
            viewInflate.setTag(c1657p2);
            c1657p = c1657p2;
        } else {
            c1657p = (C1657p) view.getTag();
            viewInflate = view;
        }
        C1651m item = getItem(i);
        c1657p.f6132d = item.f6114a;
        c1657p.f6133e = item.f6116c;
        c1657p.f6134f = item.f6117d;
        c1657p.f6135g = item.f6115b;
        if (this.f6127a) {
            ((CheckableRelativeLayout) viewInflate).setChoiceMode(2);
        } else {
            ((CheckableRelativeLayout) viewInflate).setChoiceMode(0);
        }
        c1657p.f6129a.setText(item.f6115b);
        c1657p.f6130b.setText(item.f6116c);
        return viewInflate;
    }
}
