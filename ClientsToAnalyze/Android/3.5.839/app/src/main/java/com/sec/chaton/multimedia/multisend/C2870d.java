package com.sec.chaton.multimedia.multisend;

import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.R;

/* compiled from: CategoryView.java */
/* renamed from: com.sec.chaton.multimedia.multisend.d */
/* loaded from: classes.dex */
class C2870d implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ CategoryView f10566a;

    C2870d(CategoryView categoryView) {
        this.f10566a = categoryView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C2869c c2869c = (C2869c) view.getTag();
        if (c2869c.f10562c.isEnabled()) {
            if (!c2869c.f10562c.isChecked()) {
                if (this.f10566a.f10522j >= 10) {
                    this.f10566a.f10523k.setText(String.format(this.f10566a.getActivity().getString(R.string.select_images_up_to), 10));
                    this.f10566a.f10523k.setDuration(0);
                    this.f10566a.f10523k.show();
                } else {
                    c2869c.f10562c.setChecked(true);
                    this.f10566a.f10517e.m12005a(c2869c, true);
                    CategoryView.m11959b(this.f10566a, 1);
                    this.f10566a.m11963a();
                }
            } else {
                c2869c.f10562c.setChecked(false);
                this.f10566a.f10517e.m12005a(c2869c, false);
                CategoryView.m11955a(this.f10566a, 1);
                this.f10566a.m11963a();
            }
            this.f10566a.m11964a(this.f10566a.f10516d);
        }
    }
}
