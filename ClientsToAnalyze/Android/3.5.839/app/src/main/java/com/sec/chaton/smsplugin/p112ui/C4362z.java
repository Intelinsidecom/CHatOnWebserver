package com.sec.chaton.smsplugin.p112ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import java.util.List;

/* compiled from: IconListAdapter.java */
/* renamed from: com.sec.chaton.smsplugin.ui.z */
/* loaded from: classes.dex */
public class C4362z extends ArrayAdapter<C4092aa> {

    /* renamed from: a */
    protected LayoutInflater f15809a;

    public C4362z(Context context, List<C4092aa> list) {
        super(context, R.layout.icon_list_item, list);
        this.f15809a = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f15809a.inflate(R.layout.icon_list_item, viewGroup, false);
        }
        ((TextView) view.findViewById(R.id.text1)).setText(getItem(i).m16287a());
        ((ImageView) view.findViewById(R.id.icon)).setImageResource(getItem(i).m16288b());
        return view;
    }
}
