package com.sec.chaton.trunk;

import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.R;
import com.sec.chaton.widget.C1797a;
import com.sec.widget.AlertDialogBuilderC2120a;

/* compiled from: TrunkView.java */
/* renamed from: com.sec.chaton.trunk.bl */
/* loaded from: classes.dex */
class C1563bl implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ TrunkView f5640a;

    C1563bl(TrunkView trunkView) {
        this.f5640a = trunkView;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        if (this.f5640a.getActivity() != null) {
            if (view.isPressed() || view.isInTouchMode()) {
                if (this.f5640a.f5512C != null && ((C1797a) this.f5640a.f5514a.get(i)).equals(this.f5640a.f5512C)) {
                    new AlertDialogBuilderC2120a(this.f5640a.f5518f).setTitle(R.string.buddy_list_optionmenu_listby).setSingleChoiceItems(R.array.trunk_ordering_types, this.f5640a.f5529q.ordinal(), new DialogInterfaceOnClickListenerC1564bm(this)).show();
                }
                if (((C1797a) this.f5640a.f5514a.get(i)).equals(this.f5640a.f5511B)) {
                    this.f5640a.m5326a(true, true, this.f5640a.f5529q);
                }
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView adapterView) {
    }
}
