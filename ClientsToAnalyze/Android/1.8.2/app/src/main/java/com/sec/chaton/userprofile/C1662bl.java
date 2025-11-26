package com.sec.chaton.userprofile;

import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p010a.C0257c;
import com.sec.widget.AlertDialogBuilderC2120a;

/* compiled from: RelationshipRankFragment2.java */
/* renamed from: com.sec.chaton.userprofile.bl */
/* loaded from: classes.dex */
class C1662bl implements AdapterView.OnItemLongClickListener {

    /* renamed from: a */
    final /* synthetic */ RelationshipRankFragment2 f6153a;

    C1662bl(RelationshipRankFragment2 relationshipRankFragment2) {
        this.f6153a = relationshipRankFragment2;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        AlertDialogBuilderC2120a alertDialogBuilderC2120a = new AlertDialogBuilderC2120a(view.getContext());
        alertDialogBuilderC2120a.setTitle(((C0257c) adapterView.getItemAtPosition(i)).m2324b());
        alertDialogBuilderC2120a.setMessage(String.format(view.getContext().getResources().getString(R.string.settings_hide_interaction_with), ((C0257c) adapterView.getItemAtPosition(i)).m2324b()));
        alertDialogBuilderC2120a.setPositiveButton(R.string.cancel, new DialogInterfaceOnClickListenerC1663bm(this));
        alertDialogBuilderC2120a.setNeutralButton(R.string.done, new DialogInterfaceOnClickListenerC1664bn(this, adapterView, i));
        alertDialogBuilderC2120a.show();
        return true;
    }
}
