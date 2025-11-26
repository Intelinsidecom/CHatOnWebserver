package com.sec.chaton.buddy;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import com.sec.chaton.R;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.io.File;

/* compiled from: BuddyGroupProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.dv */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0657dv implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupProfileFragment f2876a;

    DialogInterfaceOnClickListenerC0657dv(BuddyGroupProfileFragment buddyGroupProfileFragment) {
        this.f2876a = buddyGroupProfileFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra("return-data", false);
                intent.putExtra("output", this.f2876a.f1915G);
                intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
                this.f2876a.startActivityForResult(intent, 5);
                this.f2876a.f1917I = true;
                break;
            case 1:
                Intent intent2 = new Intent("android.intent.action.PICK");
                intent2.setType("image/*");
                intent2.putExtra("set-as-image", true);
                if (!BuddyProfileActivity.m3573a(CommonApplication.m11493l(), intent2)) {
                    intent2 = new Intent();
                    intent2.setAction("android.intent.action.GET_CONTENT");
                    intent2.setType("image/*");
                    intent2.putExtra("set-as-image", true);
                }
                this.f2876a.startActivityForResult(intent2, 4);
                this.f2876a.f1917I = true;
                break;
            case 2:
                C3250y.m11456e("onClick Delete profile iamge", BuddyGroupProfileFragment.f1908a);
                if (new File(this.f2876a.f1921M, this.f2876a.f1932g.m3962b() + "_group_profile.png_").delete()) {
                    this.f2876a.f1920L.setImageResource(R.drawable.contacts_default_group);
                }
                this.f2876a.f1917I = true;
                break;
        }
    }
}
