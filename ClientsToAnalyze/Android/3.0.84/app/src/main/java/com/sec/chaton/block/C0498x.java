package com.sec.chaton.block;

import android.R;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;

/* compiled from: BlockListFragment.java */
/* renamed from: com.sec.chaton.block.x */
/* loaded from: classes.dex */
class C0498x implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ BlockListFragment f1636a;

    C0498x(BlockListFragment blockListFragment) {
        this.f1636a = blockListFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        boolean z = true;
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkbox);
        if (checkBox.isChecked()) {
            checkBox.setChecked(false);
            this.f1636a.f1565i.f1622c[i] = false;
            this.f1636a.f1565i.f1621b.remove(this.f1636a.f1565i.f1620a.get(i));
            this.f1636a.f1567k.mo3161b();
        } else {
            checkBox.setChecked(true);
            this.f1636a.f1565i.f1622c[i] = true;
            this.f1636a.f1565i.f1621b.add(this.f1636a.f1565i.f1620a.get(i));
            for (int i2 = 0; i2 < this.f1636a.f1565i.f1622c.length; i2++) {
                if (!this.f1636a.f1565i.f1622c[i2]) {
                    z = false;
                }
            }
            if (z) {
                this.f1636a.f1567k.mo3160a();
            }
        }
        this.f1636a.f1567k.onClick();
    }
}
