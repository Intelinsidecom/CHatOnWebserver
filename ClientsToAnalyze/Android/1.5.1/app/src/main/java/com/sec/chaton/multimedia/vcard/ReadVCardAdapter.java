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
public class ReadVCardAdapter extends BaseAdapter {

    /* renamed from: a */
    private ReadVCardActivity f2333a;

    /* renamed from: b */
    private LayoutInflater f2334b;

    /* renamed from: c */
    private List f2335c;

    public ReadVCardAdapter(ReadVCardActivity readVCardActivity, List list) {
        this.f2333a = readVCardActivity;
        this.f2334b = (LayoutInflater) readVCardActivity.getSystemService("layout_inflater");
        this.f2335c = list;
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ContactStruct.ContactMethod getItem(int i) {
        return (ContactStruct.ContactMethod) this.f2335c.get(i);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f2335c.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return ((ContactStruct.ContactMethod) this.f2335c.get(i)).f2296d;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0318b c0318b;
        View view2;
        if (view == null) {
            LinearLayout linearLayout = (LinearLayout) this.f2334b.inflate(C0062R.layout.item_list_multimedia_vcard, viewGroup, false);
            c0318b = new C0318b(linearLayout);
            view2 = linearLayout;
        } else {
            c0318b = (C0318b) view.getTag();
            view2 = view;
        }
        c0318b.f2374c.setVisibility(8);
        this.f2333a.m2623a(c0318b.f2372a, (ContactStruct.ContactMethod) this.f2335c.get(i));
        this.f2333a.m2625b(c0318b.f2373b, (ContactStruct.ContactMethod) this.f2335c.get(i));
        view2.setTag(c0318b);
        return view2;
    }
}
