package com.sec.chaton.hide;

import android.R;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;

/* compiled from: HideListFragment.java */
/* renamed from: com.sec.chaton.hide.r */
/* loaded from: classes.dex */
class C1527r implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ HideListFragment f5615a;

    C1527r(HideListFragment hideListFragment) {
        this.f5615a = hideListFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        boolean z = true;
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkbox);
        if (checkBox.isChecked()) {
            checkBox.setChecked(false);
            this.f5615a.f5552g.f5604c[i] = false;
            this.f5615a.f5552g.f5603b.remove(this.f5615a.f5552g.f5602a.get(i));
            this.f5615a.f5554i.mo6519b();
        } else {
            checkBox.setChecked(true);
            this.f5615a.f5552g.f5604c[i] = true;
            this.f5615a.f5552g.f5603b.add(this.f5615a.f5552g.f5602a.get(i));
            for (int i2 = 0; i2 < this.f5615a.f5552g.f5604c.length; i2++) {
                if (!this.f5615a.f5552g.f5604c[i2]) {
                    z = false;
                }
            }
            if (z) {
                this.f5615a.f5554i.mo6518a();
            }
        }
        this.f5615a.f5554i.onClick();
    }
}
