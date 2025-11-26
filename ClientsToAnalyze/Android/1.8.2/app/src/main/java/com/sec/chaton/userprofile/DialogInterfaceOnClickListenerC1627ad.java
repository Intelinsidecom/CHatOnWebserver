package com.sec.chaton.userprofile;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import com.sec.chaton.buddy.BuddyProfileFragment;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import java.io.File;

/* compiled from: MyPageFragmentTablet.java */
/* renamed from: com.sec.chaton.userprofile.ad */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1627ad implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MyPageFragmentTablet f6114a;

    DialogInterfaceOnClickListenerC1627ad(MyPageFragmentTablet myPageFragmentTablet) {
        this.f6114a = myPageFragmentTablet;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                this.f6114a.f5864C = false;
                this.f6114a.f5865D = Uri.fromFile(new File(this.f6114a.f5891n, "tmp_myprofile.png_"));
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra("outputX", 600);
                intent.putExtra("outputY", 600);
                intent.putExtra("aspectX", 1);
                intent.putExtra("aspectY", 1);
                intent.putExtra("scale", true);
                intent.putExtra("return-data", false);
                intent.putExtra("output", this.f6114a.f5865D);
                intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
                this.f6114a.startActivityForResult(intent, 6);
                break;
            case 1:
                this.f6114a.f5864C = true;
                Intent intent2 = new Intent("android.intent.action.PICK");
                intent2.setType("image/*");
                if (!BuddyProfileFragment.m2132a(this.f6114a.getActivity(), intent2)) {
                    intent2 = new Intent();
                    intent2.setAction("android.intent.action.GET_CONTENT");
                    intent2.setType("image/*");
                }
                intent2.putExtra("return-data", true);
                intent2.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
                this.f6114a.startActivityForResult(intent2, 5);
                break;
            case 2:
                C1786r.m6066e("onClick Delete profile iamge", MyPageFragmentTablet.f5861b);
                if (!C1789u.m6075a().getString("profile_image_status", "").equals("deleted") && !C1789u.m6075a().getString("profile_image_status", "").equals("")) {
                    this.f6114a.f5892o.m2962a();
                    this.f6114a.f5899v.show();
                    break;
                }
                break;
        }
    }
}
