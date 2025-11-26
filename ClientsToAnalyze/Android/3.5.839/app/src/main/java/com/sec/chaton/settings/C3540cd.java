package com.sec.chaton.settings;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.widget.CheckableRelativeLayout;

/* compiled from: ActivityNoti2.java */
/* renamed from: com.sec.chaton.settings.cd */
/* loaded from: classes.dex */
class C3540cd extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ ActivityNoti2 f13028a;

    C3540cd(ActivityNoti2 activityNoti2) {
        this.f13028a = activityNoti2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f13028a.f12575y.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f13028a.f12574x.get(this.f13028a.f12575y[i]);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.f13028a).inflate(R.layout.list_item_common_4, viewGroup, false);
        ((CheckableRelativeLayout) viewInflate).setChoiceMode(1);
        viewInflate.setPadding(this.f13028a.getResources().getDimensionPixelOffset(R.dimen.datepicker_picker_margin_left), 0, 0, 0);
        TextView textView = (TextView) viewInflate.findViewById(R.id.text1);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.text2);
        textView.setText(this.f13028a.f12575y[i]);
        textView.setTextAppearance(this.f13028a, R.style.TextAppearance_Pop02);
        textView2.setText((CharSequence) this.f13028a.f12574x.get(this.f13028a.f12575y[i]));
        textView2.setTextAppearance(this.f13028a, R.style.TextAppearance_Pop03);
        return viewInflate;
    }
}
