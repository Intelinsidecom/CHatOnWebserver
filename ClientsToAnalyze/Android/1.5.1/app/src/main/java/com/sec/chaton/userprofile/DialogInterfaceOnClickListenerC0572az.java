package com.sec.chaton.userprofile;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import com.sec.chaton.C0062R;
import com.sec.chaton.util.ShareUtil;

/* renamed from: com.sec.chaton.userprofile.az */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0572az implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Bitmap f3552a;

    /* renamed from: b */
    final /* synthetic */ String f3553b;

    /* renamed from: c */
    final /* synthetic */ RelationshipRank2 f3554c;

    DialogInterfaceOnClickListenerC0572az(RelationshipRank2 relationshipRank2, Bitmap bitmap, String str) {
        this.f3554c = relationshipRank2;
        this.f3552a = bitmap;
        this.f3553b = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        ShareUtil.m3654a(this.f3554c, this.f3554c.getString(C0062R.string.share_via), this.f3552a, this.f3553b, (String) null);
    }
}
