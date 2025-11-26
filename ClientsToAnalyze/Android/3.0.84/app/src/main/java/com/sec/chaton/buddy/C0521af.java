package com.sec.chaton.buddy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.sec.chaton.R;
import java.util.ArrayList;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.af */
/* loaded from: classes.dex */
public class C0521af extends ArrayAdapter<String> {

    /* renamed from: a */
    ArrayList<String> f2427a;

    /* renamed from: b */
    final /* synthetic */ AddBuddyFragment f2428b;

    /* renamed from: c */
    private Context f2429c;

    /* renamed from: d */
    private LayoutInflater f2430d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0521af(AddBuddyFragment addBuddyFragment, Context context, ArrayList<String> arrayList) {
        super(context, 0, arrayList);
        this.f2428b = addBuddyFragment;
        this.f2429c = context;
        this.f2427a = arrayList;
        this.f2430d = (LayoutInflater) this.f2429c.getSystemService("layout_inflater");
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f2430d.inflate(R.layout.list_item_common_5, (ViewGroup) null);
        }
        view.setTag(Integer.valueOf(i));
        view.findViewById(R.id.image1).setVisibility(8);
        view.findViewById(R.id.button1).setFocusable(false);
        view.findViewById(R.id.button1).setBackgroundResource(R.drawable.ic_arrow);
        ((TextView) view.findViewById(R.id.text1)).setText(getItem(i).toString());
        return view;
    }
}
