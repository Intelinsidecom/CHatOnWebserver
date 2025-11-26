package com.sec.chaton.userprofile;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.widget.AdapterView;
import com.sec.chaton.buddy.p010a.C0257c;
import com.sec.chaton.p015d.C0637i;
import com.sec.chaton.p017e.C0688c;
import com.sec.chaton.util.C1786r;
import java.util.ArrayList;

/* compiled from: MyPageRelationshipRankFragment.java */
/* renamed from: com.sec.chaton.userprofile.ao */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1638ao implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AdapterView f6125a;

    /* renamed from: b */
    final /* synthetic */ int f6126b;

    /* renamed from: c */
    final /* synthetic */ C1636am f6127c;

    DialogInterfaceOnClickListenerC1638ao(C1636am c1636am, AdapterView adapterView, int i) {
        this.f6127c = c1636am;
        this.f6125a = adapterView;
        this.f6126b = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("buddy_relation_hide", "Y");
        ArrayList arrayList = new ArrayList();
        arrayList.add(((C0257c) this.f6125a.getItemAtPosition(this.f6126b)).m2318a());
        MyPageRelationshipRankFragment.f5926t.show();
        new C0637i(MyPageRelationshipRankFragment.f5927u).m2894a(new ArrayList(), arrayList);
        C1786r.m6061b("InteractionHide: " + ((C0257c) this.f6125a.getItemAtPosition(this.f6126b)).m2318a(), getClass().getSimpleName());
        MyPageRelationshipRankFragment.f5924d.startUpdate(0, null, C0688c.f2606a, contentValues, "buddy_no = ? ", new String[]{((C0257c) this.f6125a.getItemAtPosition(this.f6126b)).m2318a()});
    }
}
