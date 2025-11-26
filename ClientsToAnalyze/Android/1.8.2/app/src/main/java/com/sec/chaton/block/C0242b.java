package com.sec.chaton.block;

import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import com.sec.chaton.R;

/* compiled from: BlockActivity.java */
/* renamed from: com.sec.chaton.block.b */
/* loaded from: classes.dex */
class C0242b implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ BlockActivity f811a;

    C0242b(BlockActivity blockActivity) {
        this.f811a = blockActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.item_check);
        checkBox.toggle();
        ((C0253m) this.f811a.f788l.get(i)).f840e = checkBox.isChecked();
        view.invalidate();
        this.f811a.m1839a();
    }
}
