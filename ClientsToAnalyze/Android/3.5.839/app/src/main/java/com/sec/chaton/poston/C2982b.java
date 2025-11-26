package com.sec.chaton.poston;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.block.C1093u;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.p074l.EnumC2498p;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.widget.CheckableRelativeLayout;
import java.util.ArrayList;

/* compiled from: HideListPostONAdapter.java */
/* renamed from: com.sec.chaton.poston.b */
/* loaded from: classes.dex */
class C2982b extends ArrayAdapter<C1093u> {

    /* renamed from: a */
    public ArrayList<C1093u> f11078a;

    /* renamed from: b */
    private Context f11079b;

    /* renamed from: c */
    private LayoutInflater f11080c;

    public C2982b(Context context, ArrayList<C1093u> arrayList) {
        super(context, 0, arrayList);
        this.f11079b = context;
        this.f11078a = arrayList;
        this.f11080c = (LayoutInflater) this.f11079b.getSystemService("layout_inflater");
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        CheckableRelativeLayout checkableRelativeLayout = (CheckableRelativeLayout) this.f11080c.inflate(R.layout.list_item_common_6, (ViewGroup) null);
        C3008c c3008c = new C3008c();
        c3008c.f11128a = (TextView) checkableRelativeLayout.findViewById(R.id.text1);
        c3008c.f11129b = (TextView) checkableRelativeLayout.findViewById(R.id.text2);
        c3008c.f11129b.setVisibility(8);
        c3008c.f11130c = (ImageView) checkableRelativeLayout.findViewById(R.id.image1);
        checkableRelativeLayout.setChoiceMode(2);
        checkableRelativeLayout.setTag(c3008c);
        C1093u item = getItem(i);
        c3008c.f11128a.setText(item.f3485b);
        C2496n.m10765a(c3008c.f11130c, item.f3484a, EnumC2498p.ROUND);
        if (C4822an.m18218a()) {
            c3008c.f11130c.setBackgroundResource(R.drawable.circle_background);
        } else {
            c3008c.f11130c.setBackgroundResource(R.drawable.frame_background);
        }
        return checkableRelativeLayout;
    }
}
