package com.sec.chaton.multimedia.image;

import android.content.DialogInterface;
import com.sec.common.util.p070a.C3332a;

/* compiled from: PostONImagePagerFragment.java */
/* renamed from: com.sec.chaton.multimedia.image.al */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1861al implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PostONImagePagerFragment f7100a;

    DialogInterfaceOnClickListenerC1861al(PostONImagePagerFragment postONImagePagerFragment) {
        this.f7100a = postONImagePagerFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C3332a.m11750a().m11756a(this.f7100a.f7013M, this.f7100a.f7031u + this.f7100a.f7005E);
    }
}
