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
/* renamed from: com.sec.chaton.localbackup.q */
/* loaded from: classes.dex */
public class C2558q extends ArrayAdapter<C2556o> {

    /* renamed from: a */
    public boolean f9171a;

    /* renamed from: b */
    private LayoutInflater f9172b;

    public C2558q(Context context, ArrayList<C2556o> arrayList) {
        super(context, 0, arrayList);
        this.f9172b = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C2559r c2559r;
        View viewInflate;
        if (view == null) {
            viewInflate = this.f9172b.inflate(R.layout.list_item_common_4, (ViewGroup) null);
            C2559r c2559r2 = new C2559r();
            c2559r2.f9173a = (TextView) viewInflate.findViewById(R.id.text1);
            c2559r2.f9174b = (TextView) viewInflate.findViewById(R.id.text2);
            c2559r2.f9175c = (CheckBox) viewInflate.findViewById(android.R.id.checkbox);
            viewInflate.setTag(c2559r2);
            c2559r = c2559r2;
        } else {
            c2559r = (C2559r) view.getTag();
            viewInflate = view;
        }
        C2556o item = getItem(i);
        c2559r.f9176d = item.f9164a;
        c2559r.f9177e = item.f9166c;
        c2559r.f9178f = item.f9167d;
        c2559r.f9179g = item.f9165b;
        if (this.f9171a) {
            ((CheckableRelativeLayout) viewInflate).setChoiceMode(2);
        } else {
            ((CheckableRelativeLayout) viewInflate).setChoiceMode(0);
        }
        c2559r.f9173a.setText(item.f9165b);
        c2559r.f9174b.setText(item.f9166c);
        return viewInflate;
    }
}
