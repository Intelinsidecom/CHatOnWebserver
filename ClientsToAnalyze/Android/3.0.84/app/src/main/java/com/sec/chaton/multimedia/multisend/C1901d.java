package com.sec.chaton.multimedia.multisend;

import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.R;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;

/* compiled from: CategoryView.java */
/* renamed from: com.sec.chaton.multimedia.multisend.d */
/* loaded from: classes.dex */
class C1901d implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ CategoryView f7245a;

    C1901d(CategoryView categoryView) {
        this.f7245a = categoryView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C1900c c1900c = (C1900c) view.getTag();
        if (c1900c.f7241c.isEnabled()) {
            if (!c1900c.f7241c.isChecked()) {
                if (this.f7245a.f7201j >= 10) {
                    this.f7245a.f7202k = C3641ai.m13211a(CommonApplication.m11493l(), (CharSequence) null, 0);
                    this.f7245a.f7202k.setText(String.format(this.f7245a.getActivity().getString(R.string.select_images_up_to), 10));
                    this.f7245a.f7202k.setDuration(0);
                    this.f7245a.f7202k.show();
                } else {
                    c1900c.f7241c.setChecked(true);
                    this.f7245a.f7196e.m7775a(c1900c, true);
                    CategoryView.m7729b(this.f7245a, 1);
                    this.f7245a.m7733a();
                }
            } else {
                c1900c.f7241c.setChecked(false);
                this.f7245a.f7196e.m7775a(c1900c, false);
                CategoryView.m7724a(this.f7245a, 1);
                this.f7245a.m7733a();
            }
            this.f7245a.m7734a(this.f7245a.f7195d);
        }
    }
}
