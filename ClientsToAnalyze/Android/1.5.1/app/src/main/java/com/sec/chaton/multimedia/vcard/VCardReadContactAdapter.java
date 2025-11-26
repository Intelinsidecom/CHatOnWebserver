package com.sec.chaton.multimedia.vcard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.sec.chaton.C0062R;
import com.sec.chaton.multimedia.vcard.ContactStruct;
import java.util.List;

/* loaded from: classes.dex */
public class VCardReadContactAdapter extends BaseAdapter {

    /* renamed from: a */
    private VCardReadContactActivity f2367a;

    /* renamed from: b */
    private LayoutInflater f2368b;

    /* renamed from: c */
    private List f2369c;

    public VCardReadContactAdapter(VCardReadContactActivity vCardReadContactActivity, List list) {
        this.f2367a = vCardReadContactActivity;
        this.f2368b = (LayoutInflater) vCardReadContactActivity.getSystemService("layout_inflater");
        this.f2369c = list;
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ContactStruct.ContactMethod getItem(int i) {
        return (ContactStruct.ContactMethod) this.f2369c.get(i);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f2369c.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return ((ContactStruct.ContactMethod) this.f2369c.get(i)).f2296d;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0321e c0321e;
        View view2;
        if (view == null) {
            LinearLayout linearLayout = (LinearLayout) this.f2368b.inflate(C0062R.layout.item_list_multimedia_vcard, viewGroup, false);
            c0321e = new C0321e(linearLayout);
            view2 = linearLayout;
        } else {
            c0321e = (C0321e) view.getTag();
            view2 = view;
        }
        this.f2367a.m2657a(c0321e.f2380c, (ContactStruct.ContactMethod) this.f2369c.get(i));
        this.f2367a.m2660b(c0321e.f2378a, (ContactStruct.ContactMethod) this.f2369c.get(i));
        this.f2367a.m2661c(c0321e.f2379b, (ContactStruct.ContactMethod) this.f2369c.get(i));
        view2.setTag(c0321e);
        return view2;
    }
}
