package com.sec.chaton.userprofile;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;

/* compiled from: ProfileImageHistoryFragment.java */
/* renamed from: com.sec.chaton.userprofile.bz */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3127bz implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ProfileImageHistoryFragment f11360a;

    DialogInterfaceOnClickListenerC3127bz(ProfileImageHistoryFragment profileImageHistoryFragment) {
        this.f11360a = profileImageHistoryFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra("return-data", false);
                intent.putExtra("output", this.f11360a.f11248h);
                intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
                this.f11360a.startActivityForResult(intent, 6);
                this.f11360a.f11252l = true;
                break;
            case 1:
                this.f11360a.m10840i();
                break;
        }
    }
}
