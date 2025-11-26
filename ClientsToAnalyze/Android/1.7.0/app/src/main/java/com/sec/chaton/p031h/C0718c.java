package com.sec.chaton.p031h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.chat.ChatFragment;
import java.util.ArrayList;

/* compiled from: DialogMenuAdapter.java */
/* renamed from: com.sec.chaton.h.c */
/* loaded from: classes.dex */
public class C0718c extends BaseAdapter {

    /* renamed from: a */
    public static Object f2437a;

    /* renamed from: b */
    public ChatFragment f2438b;

    /* renamed from: c */
    private final LayoutInflater f2439c;

    /* renamed from: d */
    private ArrayList f2440d;

    public C0718c(ChatFragment chatFragment, Object obj, ArrayList arrayList) {
        this.f2440d = new ArrayList();
        this.f2438b = chatFragment;
        this.f2439c = (LayoutInflater) this.f2438b.getActivity().getSystemService("layout_inflater");
        this.f2440d = arrayList;
        f2437a = obj;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0717b c0717b = (C0717b) getItem(i);
        if (view == null) {
            view = this.f2439c.inflate(R.layout.item_dialog_menu, viewGroup, false);
        }
        ((ImageView) view.findViewById(R.id.insertMenuIcon)).setImageDrawable(c0717b.f2435b);
        ((TextView) view.findViewById(R.id.insertMenuText)).setText(this.f2438b.getResources().getString(c0717b.f2434a));
        return view;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f2440d.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f2440d.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
