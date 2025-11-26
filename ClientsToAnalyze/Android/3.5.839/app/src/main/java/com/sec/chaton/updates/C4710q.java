package com.sec.chaton.updates;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sec.chaton.R;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.p074l.EnumC2498p;
import com.sec.chaton.widget.CheckableRelativeLayout;
import java.util.ArrayList;

/* compiled from: UpdatesSelectionAdapter.java */
/* renamed from: com.sec.chaton.updates.q */
/* loaded from: classes.dex */
public class C4710q extends C4694a {

    /* renamed from: a */
    private Context f17067a;

    /* renamed from: b */
    private LayoutInflater f17068b;

    /* renamed from: c */
    private int f17069c;

    /* renamed from: d */
    private ArrayList<C4709p> f17070d;

    public C4710q(Context context, ArrayList<C4709p> arrayList, int i) {
        super(context, arrayList, i);
        this.f17067a = context;
        this.f17068b = (LayoutInflater) this.f17067a.getSystemService("layout_inflater");
        this.f17070d = arrayList;
        this.f17069c = i;
    }

    @Override // com.sec.chaton.updates.C4694a, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C4701h c4701h;
        CheckableRelativeLayout checkableRelativeLayout;
        if (view == null) {
            CheckableRelativeLayout checkableRelativeLayout2 = (CheckableRelativeLayout) this.f17068b.inflate(this.f17069c, viewGroup, false);
            c4701h = new C4701h(checkableRelativeLayout2);
            checkableRelativeLayout = checkableRelativeLayout2;
        } else {
            c4701h = (C4701h) view.getTag();
            checkableRelativeLayout = (CheckableRelativeLayout) view;
        }
        C2496n.m10765a(c4701h.f17041a, this.f17070d.get(i).m17763a(0), EnumC2498p.ROUND);
        c4701h.f17041a.setBackgroundResource(R.drawable.circle_background);
        c4701h.f17044d.setText(m17751a(this.f17070d.get(i)));
        if (this.f17070d.get(i).m17767d()) {
            c4701h.f17042b.setVisibility(0);
            if (this.f17070d.get(i).m17774k()) {
                c4701h.f17044d.setTextAppearance(this.f17067a, R.style.TextAppearance_List67);
            } else {
                c4701h.f17044d.setTextAppearance(this.f17067a, R.style.TextAppearance_List65);
            }
            String strM17768e = this.f17070d.get(i).m17768e();
            c4701h.f17045e.setVisibility(0);
            c4701h.f17045e.setText(strM17768e);
            if (this.f17070d.get(i).m17774k()) {
                c4701h.f17045e.setTextAppearance(this.f17067a, R.style.TextAppearance_List09);
            } else {
                c4701h.f17045e.setTextAppearance(this.f17067a, R.style.TextAppearance_List68);
            }
        } else {
            c4701h.f17042b.setVisibility(8);
            if (this.f17070d.get(i).m17774k()) {
                c4701h.f17044d.setTextAppearance(this.f17067a, R.style.TextAppearance_List66);
            } else {
                c4701h.f17044d.setTextAppearance(this.f17067a, R.style.TextAppearance_List65);
            }
        }
        switch (C4711r.f17071a[this.f17070d.get(i).m17770g().ordinal()]) {
            case 1:
                c4701h.f17043c.setVisibility(0);
                c4701h.f17048h.setImageResource(R.drawable.update_ic_image_normal);
                c4701h.f17048h.setVisibility(0);
                break;
            case 2:
                c4701h.f17043c.setVisibility(0);
                c4701h.f17048h.setImageResource(R.drawable.update_ic_video_normal);
                c4701h.f17048h.setVisibility(0);
                break;
            case 3:
                c4701h.f17043c.setVisibility(0);
                c4701h.f17048h.setImageResource(R.drawable.update_ic_location_normal);
                c4701h.f17048h.setVisibility(0);
                break;
            case 4:
                c4701h.f17043c.setVisibility(0);
                c4701h.f17048h.setImageResource(R.drawable.update_ic_image_normal);
                c4701h.f17048h.setVisibility(0);
                c4701h.f17049i.setImageResource(R.drawable.update_ic_location_normal);
                c4701h.f17049i.setVisibility(0);
                break;
            case 5:
                c4701h.f17043c.setVisibility(0);
                c4701h.f17043c.setVisibility(0);
                c4701h.f17048h.setImageResource(R.drawable.update_ic_video_normal);
                c4701h.f17048h.setVisibility(0);
                c4701h.f17049i.setImageResource(R.drawable.update_ic_location_normal);
                c4701h.f17049i.setVisibility(0);
                break;
            default:
                c4701h.f17043c.setVisibility(8);
                break;
        }
        c4701h.f17046f.setText(m17750a(Long.parseLong(this.f17070d.get(i).m17766c())));
        c4701h.f17047g.setText(m17753b(Long.parseLong(this.f17070d.get(i).m17766c())));
        checkableRelativeLayout.setChoiceMode(2);
        checkableRelativeLayout.setTag(c4701h);
        return checkableRelativeLayout;
    }
}
