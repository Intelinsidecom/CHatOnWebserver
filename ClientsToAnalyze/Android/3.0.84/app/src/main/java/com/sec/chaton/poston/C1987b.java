package com.sec.chaton.poston;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.block.C0475ac;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.widget.CheckableRelativeLayout;
import java.util.ArrayList;

/* compiled from: HideListPostONAdapter.java */
/* renamed from: com.sec.chaton.poston.b */
/* loaded from: classes.dex */
class C1987b extends ArrayAdapter<C0475ac> {

    /* renamed from: a */
    public ArrayList<C0475ac> f7701a;

    /* renamed from: b */
    private Context f7702b;

    /* renamed from: c */
    private LayoutInflater f7703c;

    public C1987b(Context context, ArrayList<C0475ac> arrayList) {
        super(context, 0, arrayList);
        this.f7702b = context;
        this.f7701a = arrayList;
        this.f7703c = (LayoutInflater) this.f7702b.getSystemService("layout_inflater");
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        CheckableRelativeLayout checkableRelativeLayout = (CheckableRelativeLayout) this.f7703c.inflate(R.layout.list_item_common_6, (ViewGroup) null);
        C2012c c2012c = new C2012c();
        c2012c.f7732a = (TextView) checkableRelativeLayout.findViewById(R.id.text1);
        c2012c.f7733b = (TextView) checkableRelativeLayout.findViewById(R.id.text2);
        c2012c.f7733b.setVisibility(8);
        c2012c.f7734c = (ImageView) checkableRelativeLayout.findViewById(R.id.image1);
        checkableRelativeLayout.setChoiceMode(2);
        checkableRelativeLayout.setTag(c2012c);
        C0475ac item = getItem(i);
        c2012c.f7732a.setText(item.f1585b);
        C3205bt.m11182a(this.f7702b).m11210a(c2012c.f7734c, item.f1584a);
        return checkableRelativeLayout;
    }
}
