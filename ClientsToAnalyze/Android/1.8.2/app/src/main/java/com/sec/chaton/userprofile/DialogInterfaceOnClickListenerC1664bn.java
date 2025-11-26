package com.sec.chaton.userprofile;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.widget.AdapterView;
import com.sec.chaton.buddy.p010a.C0257c;
import com.sec.chaton.p017e.C0688c;

/* compiled from: RelationshipRankFragment2.java */
/* renamed from: com.sec.chaton.userprofile.bn */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1664bn implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AdapterView f6155a;

    /* renamed from: b */
    final /* synthetic */ int f6156b;

    /* renamed from: c */
    final /* synthetic */ C1662bl f6157c;

    DialogInterfaceOnClickListenerC1664bn(C1662bl c1662bl, AdapterView adapterView, int i) {
        this.f6157c = c1662bl;
        this.f6155a = adapterView;
        this.f6156b = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("buddy_relation_hide", "Y");
        RelationshipRankFragment2.f5992g.startUpdate(0, null, C0688c.f2606a, contentValues, "buddy_no = ? ", new String[]{((C0257c) this.f6155a.getItemAtPosition(this.f6156b)).m2318a()});
    }
}
