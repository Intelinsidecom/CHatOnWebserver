package com.sec.chaton.userprofile;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import com.sec.chaton.R;
import com.sec.chaton.util.C1766bv;

/* compiled from: RelationshipRankFragment2.java */
/* renamed from: com.sec.chaton.userprofile.bt */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1670bt implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Bitmap f6163a;

    /* renamed from: b */
    final /* synthetic */ String f6164b;

    /* renamed from: c */
    final /* synthetic */ RelationshipRankFragment2 f6165c;

    DialogInterfaceOnClickListenerC1670bt(RelationshipRankFragment2 relationshipRankFragment2, Bitmap bitmap, String str) {
        this.f6165c = relationshipRankFragment2;
        this.f6163a = bitmap;
        this.f6164b = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        C1766bv.m5997a(this.f6165c.getActivity(), this.f6165c.getString(R.string.share_via), this.f6163a, this.f6164b, (String) null);
    }
}
