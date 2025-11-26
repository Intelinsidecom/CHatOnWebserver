package com.sec.chaton.userprofile;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import com.sec.chaton.R;
import com.sec.chaton.util.C1766bv;

/* compiled from: MyPageRelationshipRankFragment.java */
/* renamed from: com.sec.chaton.userprofile.as */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1642as implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Bitmap f6130a;

    /* renamed from: b */
    final /* synthetic */ String f6131b;

    /* renamed from: c */
    final /* synthetic */ MyPageRelationshipRankFragment f6132c;

    DialogInterfaceOnClickListenerC1642as(MyPageRelationshipRankFragment myPageRelationshipRankFragment, Bitmap bitmap, String str) {
        this.f6132c = myPageRelationshipRankFragment;
        this.f6130a = bitmap;
        this.f6131b = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        C1766bv.m5997a(this.f6132c.getActivity(), this.f6132c.getString(R.string.share_via), this.f6130a, this.f6131b, (String) null);
    }
}
