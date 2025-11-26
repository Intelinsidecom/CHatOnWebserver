package com.sec.chaton.buddy;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.p074l.EnumC2498p;
import com.sec.chaton.widget.C4923p;
import java.util.ArrayList;

/* compiled from: SpecialBuddyRecommendListFragment.java */
/* renamed from: com.sec.chaton.buddy.ir */
/* loaded from: classes.dex */
public class C1392ir extends ArrayAdapter<C1391iq> {

    /* renamed from: a */
    ArrayList<C1391iq> f5000a;

    /* renamed from: b */
    String f5001b;

    /* renamed from: c */
    String f5002c;

    /* renamed from: d */
    final /* synthetic */ SpecialBuddyRecommendListFragment f5003d;

    /* renamed from: e */
    private Context f5004e;

    /* renamed from: f */
    private LayoutInflater f5005f;

    /* renamed from: g */
    private ViewGroup f5006g;

    /* renamed from: h */
    private View.OnClickListener f5007h;

    /* renamed from: i */
    private View.OnClickListener f5008i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1392ir(SpecialBuddyRecommendListFragment specialBuddyRecommendListFragment, Context context, int i, ArrayList<C1391iq> arrayList) {
        super(context, 0, arrayList);
        this.f5003d = specialBuddyRecommendListFragment;
        this.f5007h = new ViewOnClickListenerC1393is(this);
        this.f5008i = new ViewOnClickListenerC1394it(this);
        this.f5004e = context;
        this.f5000a = arrayList;
        this.f5005f = (LayoutInflater) this.f5004e.getSystemService("layout_inflater");
        this.f5006g = (ViewGroup) this.f5005f.inflate(i, (ViewGroup) null);
        specialBuddyRecommendListFragment.f4173f = (ProgressDialog) new C4923p(this.f5004e).m18724a(R.string.dialog_userprofile_updating);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1395iu c1395iu;
        if (view == null) {
            view = this.f5005f.inflate(R.layout.list_item_common_5, (ViewGroup) null);
            c1395iu = new C1395iu(this);
            c1395iu.f5011a = (ImageView) view.findViewById(R.id.image1);
            c1395iu.f5012b = (TextView) view.findViewById(R.id.text1);
            c1395iu.f5013c = (Button) view.findViewById(R.id.button1);
            view.setTag(c1395iu);
        } else {
            c1395iu = (C1395iu) view.getTag();
        }
        c1395iu.f5013c.setTag(Integer.valueOf(i));
        c1395iu.f5013c.setBackgroundResource(R.drawable.ic_arrow);
        c1395iu.f5013c.setOnClickListener(this.f5007h);
        c1395iu.f5012b.setTag(Integer.valueOf(i));
        c1395iu.f5012b.setOnClickListener(this.f5007h);
        C1391iq item = getItem(i);
        c1395iu.f5012b.setText(item.f4998b);
        c1395iu.f5011a.setTag(Integer.valueOf(i));
        c1395iu.f5011a.setOnClickListener(this.f5007h);
        if (this.f5003d.f4177j != 1) {
            if (this.f5003d.f4177j > 1) {
                c1395iu.f5011a.setVisibility(0);
                this.f5003d.f4180m.setVisibility(8);
                C2496n.m10765a(this.f5003d.f4180m, item.f4997a, EnumC2498p.ROUND);
            } else {
                c1395iu.f5011a.setVisibility(8);
                this.f5003d.f4180m.setVisibility(8);
            }
        } else {
            c1395iu.f5011a.setVisibility(8);
            this.f5003d.f4180m.setVisibility(0);
            C2496n.m10765a(this.f5003d.f4180m, item.f4997a, EnumC2498p.ROUND);
        }
        return view;
    }
}
