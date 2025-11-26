package com.sec.chaton.p030f;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;

/* compiled from: DialogMenuAdapter.java */
/* renamed from: com.sec.chaton.f.c */
/* loaded from: classes.dex */
public class C1474c extends BaseAdapter {

    /* renamed from: a */
    public ChatFragment f5454a;

    /* renamed from: b */
    private final LayoutInflater f5455b;

    /* renamed from: c */
    private ArrayList<C1478g> f5456c;

    public C1474c(ChatFragment chatFragment, ArrayList<C1478g> arrayList) {
        this.f5456c = new ArrayList<>();
        this.f5454a = chatFragment;
        this.f5455b = (LayoutInflater) this.f5454a.getActivity().getSystemService("layout_inflater");
        this.f5456c = arrayList;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1478g c1478g = (C1478g) getItem(i);
        if (view == null) {
            view = this.f5455b.inflate(R.layout.item_dialog_menu, viewGroup, false);
            C1476e c1476e = new C1476e(this);
            c1476e.f5457a = (ImageView) view.findViewById(R.id.insertMenuIcon);
            c1476e.f5458b = (TextView) view.findViewById(R.id.insertMenuText);
            view.setTag(c1476e);
        }
        C1476e c1476e2 = (C1476e) view.getTag();
        try {
            c1476e2.f5457a.setBackgroundResource(c1478g.f5461b);
        } catch (OutOfMemoryError e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, getClass().getSimpleName());
            }
            c1476e2.f5457a.setBackgroundDrawable(null);
        }
        c1476e2.f5458b.setText(this.f5454a.getResources().getString(c1478g.f5460a));
        return view;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f5456c.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f5456c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
