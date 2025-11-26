package com.sec.chaton.userprofile;

import android.content.DialogInterface;
import com.sec.chaton.util.C1341p;
import java.util.ArrayList;

/* compiled from: RelationshipRankFragment2.java */
/* renamed from: com.sec.chaton.userprofile.bq */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1247bq implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f4328a;

    /* renamed from: b */
    final /* synthetic */ RelationshipRankFragment2 f4329b;

    DialogInterfaceOnClickListenerC1247bq(RelationshipRankFragment2 relationshipRankFragment2, String str) {
        this.f4329b = relationshipRankFragment2;
        this.f4328a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f4328a);
        this.f4329b.f4216x.show();
        this.f4329b.f4218z.m747a(new ArrayList(), arrayList);
        C1341p.m4658b("InteractionHide: " + this.f4328a, getClass().getSimpleName());
    }
}
