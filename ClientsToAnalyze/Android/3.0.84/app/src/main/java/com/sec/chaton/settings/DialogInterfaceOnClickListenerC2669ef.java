package com.sec.chaton.settings;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.util.C3171am;

/* compiled from: FragmentSkinChange3.java */
/* renamed from: com.sec.chaton.settings.ef */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2669ef implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentSkinChange3 f9936a;

    DialogInterfaceOnClickListenerC2669ef(FragmentSkinChange3 fragmentSkinChange3) {
        this.f9936a = fragmentSkinChange3;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f9936a.f9178D = false;
        if (!C3171am.m11077o()) {
            i++;
        }
        switch (i) {
            case 0:
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra("return-data", false);
                intent.putExtra("output", this.f9936a.f9181G);
                intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
                this.f9936a.startActivityForResult(intent, 4);
                this.f9936a.f9177C = true;
                break;
            case 1:
                Intent intent2 = new Intent("android.intent.action.PICK");
                intent2.setType("image/*");
                intent2.putExtra("set-as-image", true);
                if (!BuddyProfileActivity.m3573a(this.f9936a.getActivity(), intent2)) {
                    intent2 = new Intent();
                    intent2.setAction("android.intent.action.GET_CONTENT");
                    intent2.setType("image/*");
                    intent2.putExtra("set-as-image", true);
                }
                this.f9936a.startActivityForResult(intent2, 3);
                this.f9936a.f9177C = true;
                break;
        }
    }
}
