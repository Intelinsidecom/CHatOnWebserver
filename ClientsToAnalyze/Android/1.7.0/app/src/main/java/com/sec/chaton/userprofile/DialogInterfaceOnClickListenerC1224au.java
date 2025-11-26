package com.sec.chaton.userprofile;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import com.sec.chaton.R;
import com.sec.chaton.util.C1335j;

/* compiled from: RelationshipRankFragment2.java */
/* renamed from: com.sec.chaton.userprofile.au */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1224au implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Bitmap f4301a;

    /* renamed from: b */
    final /* synthetic */ String f4302b;

    /* renamed from: c */
    final /* synthetic */ RelationshipRankFragment2 f4303c;

    DialogInterfaceOnClickListenerC1224au(RelationshipRankFragment2 relationshipRankFragment2, Bitmap bitmap, String str) {
        this.f4303c = relationshipRankFragment2;
        this.f4301a = bitmap;
        this.f4302b = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        C1335j.m4616a(this.f4303c.getActivity(), this.f4303c.getString(R.string.share_via), this.f4301a, this.f4302b, (String) null);
    }
}
