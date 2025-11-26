package com.sec.chaton.settings;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.widget.CheckableRelativeLayout;

/* compiled from: ActivityNoti.java */
/* renamed from: com.sec.chaton.settings.be */
/* loaded from: classes.dex */
class C2444be extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ ActivityNoti f9304a;

    C2444be(ActivityNoti activityNoti) {
        this.f9304a = activityNoti;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f9304a.f9020y.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f9304a.f9019x.get(this.f9304a.f9020y[i]);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.f9304a.f9006k).inflate(R.layout.list_item_common_4, viewGroup, false);
        ((CheckableRelativeLayout) viewInflate).setChoiceMode(1);
        TextView textView = (TextView) viewInflate.findViewById(R.id.text1);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.text2);
        textView.setText(this.f9304a.f9020y[i]);
        textView2.setText((CharSequence) this.f9304a.f9019x.get(this.f9304a.f9020y[i]));
        return viewInflate;
    }
}
