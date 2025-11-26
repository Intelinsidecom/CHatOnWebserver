package com.sec.chaton.multimedia.multisend;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.common.p132g.C5007c;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: CategoryAdapter.java */
/* renamed from: com.sec.chaton.multimedia.multisend.b */
/* loaded from: classes.dex */
class C2868b extends ArrayAdapter<C2871e> {

    /* renamed from: a */
    int f10555a;

    /* renamed from: b */
    private Context f10556b;

    /* renamed from: c */
    private LayoutInflater f10557c;

    /* renamed from: d */
    private C5007c f10558d;

    /* renamed from: e */
    private HashMap<String, String> f10559e;

    public C2868b(Context context, int i, ArrayList<C2871e> arrayList, C5007c c5007c, HashMap<String, String> map) {
        super(context, 0, arrayList);
        this.f10556b = context;
        this.f10558d = c5007c;
        this.f10555a = i;
        this.f10559e = map;
        this.f10557c = (LayoutInflater) this.f10556b.getSystemService("layout_inflater");
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C2869c c2869c;
        if (view == null) {
            view = this.f10557c.inflate(this.f10555a, (ViewGroup) null);
            C2869c c2869c2 = new C2869c();
            c2869c2.f10560a = (ImageView) view.findViewById(R.id.dimId);
            c2869c2.f10561b = (ImageView) view.findViewById(R.id.thumbnailCategory);
            c2869c2.f10562c = (CheckBox) view.findViewById(R.id.smiCheck);
            view.setTag(c2869c2);
            c2869c = c2869c2;
        } else {
            c2869c = (C2869c) view.getTag();
        }
        C2871e item = getItem(i);
        c2869c.f10563d = item.f10567a;
        c2869c.f10564e = item.f10568b;
        c2869c.f10565f = item.f10569c;
        this.f10558d.m19023b(c2869c.f10561b, new C2875i(item.f10567a, item.f10568b, false, false, c2869c.f10565f, c2869c.f10562c, c2869c.f10560a));
        m12004a(c2869c);
        return view;
    }

    /* renamed from: a */
    private void m12004a(C2869c c2869c) {
        if (!TextUtils.isEmpty(c2869c.f10563d)) {
            if (!this.f10559e.isEmpty() && this.f10559e.containsKey(c2869c.f10563d)) {
                c2869c.f10562c.setChecked(true);
            } else {
                c2869c.f10562c.setChecked(false);
            }
        }
    }

    /* renamed from: a */
    public void m12005a(C2869c c2869c, boolean z) {
        if (z) {
            this.f10559e.put(c2869c.f10563d, c2869c.f10564e);
        } else if (this.f10559e.containsKey(c2869c.f10563d)) {
            this.f10559e.remove(c2869c.f10563d);
        }
    }
}
