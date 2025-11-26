package com.sec.chaton.settings.moreapps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.C0430ah;
import com.sec.chaton.PlusFragment;
import com.sec.chaton.R;
import java.util.ArrayList;

/* compiled from: PlusMenuAdapter.java */
/* renamed from: com.sec.chaton.settings.moreapps.d */
/* loaded from: classes.dex */
public class C2714d extends ArrayAdapter<C0430ah> {

    /* renamed from: a */
    private static final String f10033a = C2714d.class.getSimpleName();

    /* renamed from: b */
    private Context f10034b;

    /* renamed from: c */
    private LayoutInflater f10035c;

    public C2714d(Context context, PlusFragment plusFragment, ArrayList<C0430ah> arrayList) {
        super(context, 0, arrayList);
        this.f10034b = context;
        this.f10035c = (LayoutInflater) this.f10034b.getSystemService("layout_inflater");
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C2715e c2715e;
        if (view == null) {
            view = this.f10035c.inflate(R.layout.layout_plusmenu_item, viewGroup, false);
            c2715e = new C2715e();
            c2715e.f10036a = (ImageView) view.findViewById(R.id.imgItem);
            c2715e.f10037b = (TextView) view.findViewById(R.id.txtItem);
            c2715e.f10038c = (TextView) view.findViewById(R.id.badge);
            view.setTag(c2715e);
        } else {
            c2715e = (C2715e) view.getTag();
        }
        C0430ah item = getItem(i);
        c2715e.f10037b.setText(item.f1493b);
        c2715e.f10036a.setImageResource(item.f1492a);
        if (item.f1494c > 0) {
            c2715e.f10038c.setVisibility(0);
            if (item.f1494c > 99) {
                c2715e.f10038c.setText("99+");
            } else {
                c2715e.f10038c.setText(Integer.toString(item.f1494c));
            }
        } else {
            c2715e.f10038c.setVisibility(8);
        }
        return view;
    }
}
