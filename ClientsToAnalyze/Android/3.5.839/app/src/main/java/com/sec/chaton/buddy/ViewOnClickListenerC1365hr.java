package com.sec.chaton.buddy;

import android.view.View;
import android.widget.CheckBox;
import java.util.List;

/* compiled from: MultipleExpandableAdapter.java */
/* renamed from: com.sec.chaton.buddy.hr */
/* loaded from: classes.dex */
class ViewOnClickListenerC1365hr implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CheckBox f4962a;

    /* renamed from: b */
    final /* synthetic */ int f4963b;

    /* renamed from: c */
    final /* synthetic */ int f4964c;

    /* renamed from: d */
    final /* synthetic */ C1364hq f4965d;

    ViewOnClickListenerC1365hr(C1364hq c1364hq, CheckBox checkBox, int i, int i2) {
        this.f4965d = c1364hq;
        this.f4962a = checkBox;
        this.f4963b = i;
        this.f4964c = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4962a.setChecked(true);
        this.f4965d.f4961g.put(this.f4965d.f4957c.get(this.f4963b), ((List) this.f4965d.f4956b.get(this.f4965d.f4957c.get(this.f4963b))).get(this.f4964c));
        if (this.f4965d.f4958d.get(Integer.valueOf(this.f4963b)) == null) {
            this.f4965d.f4958d.put(Integer.valueOf(this.f4963b), Integer.valueOf(this.f4964c));
        } else {
            this.f4965d.f4958d.remove(Integer.valueOf(this.f4963b));
            this.f4965d.f4958d.put(Integer.valueOf(this.f4963b), Integer.valueOf(this.f4964c));
        }
        this.f4965d.notifyDataSetChanged();
    }
}
