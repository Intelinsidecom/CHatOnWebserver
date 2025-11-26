package com.sec.vip.amschaton.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.vip.amschaton.C3410al;

/* compiled from: AMSEmoticonSelectionFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.at */
/* loaded from: classes.dex */
public class C3472at extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ AMSEmoticonSelectionFragment f12834a;

    /* synthetic */ C3472at(AMSEmoticonSelectionFragment aMSEmoticonSelectionFragment, C3471as c3471as) {
        this(aMSEmoticonSelectionFragment);
    }

    private C3472at(AMSEmoticonSelectionFragment aMSEmoticonSelectionFragment) {
        this.f12834a = aMSEmoticonSelectionFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return C3410al.m12173a().m12196e();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C3473au c3473au;
        if (view == null) {
            C3473au c3473au2 = new C3473au(this, null);
            view = this.f12834a.getActivity().getLayoutInflater().inflate(R.layout.ams_ics_list_item_emoticon_stamp, viewGroup, false);
            c3473au2.f12835a = (LinearLayout) view.findViewById(R.id.layout_emoticon);
            if (GlobalApplication.m6456e()) {
                c3473au2.f12835a.setBackgroundColor(0);
            }
            c3473au2.f12836b = (ImageView) view.findViewById(R.id.image_emoticon);
            if (GlobalApplication.m6456e()) {
                c3473au2.f12836b.setScaleType(ImageView.ScaleType.CENTER);
            }
            view.setTag(c3473au2);
            c3473au = c3473au2;
        } else {
            c3473au = (C3473au) view.getTag();
        }
        c3473au.f12836b.setImageResource(C3410al.m12173a().m12186b(i));
        return view;
    }
}
