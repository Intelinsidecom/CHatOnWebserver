package com.sec.chaton.userprofile;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import com.sec.chaton.buddy.BuddyProfileFragment;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import java.io.File;

/* compiled from: UserProfileDetail.java */
/* renamed from: com.sec.chaton.userprofile.by */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1675by implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ UserProfileDetail f6172a;

    DialogInterfaceOnClickListenerC1675by(UserProfileDetail userProfileDetail) {
        this.f6172a = userProfileDetail;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                this.f6172a.f6026I = false;
                this.f6172a.f6027J = Uri.fromFile(new File(this.f6172a.f6073t, "tmp_myprofile.png_"));
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra("outputX", 600);
                intent.putExtra("outputY", 600);
                intent.putExtra("aspectX", 1);
                intent.putExtra("aspectY", 1);
                intent.putExtra("scale", true);
                intent.putExtra("return-data", false);
                intent.putExtra("output", this.f6172a.f6027J);
                intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
                this.f6172a.startActivityForResult(intent, 6);
                break;
            case 1:
                this.f6172a.f6026I = true;
                Intent intent2 = new Intent("android.intent.action.PICK");
                intent2.setType("image/*");
                if (!BuddyProfileFragment.m2132a(this.f6172a.f6028K, intent2)) {
                    intent2 = new Intent();
                    intent2.setAction("android.intent.action.GET_CONTENT");
                    intent2.setType("image/*");
                }
                intent2.putExtra("return-data", true);
                intent2.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
                this.f6172a.startActivityForResult(intent2, 5);
                break;
            case 2:
                C1786r.m6066e("onClick Delete profile iamge", "UserProfileDetail");
                if (!C1789u.m6075a().getString("profile_image_status", "").equals("deleted") && !C1789u.m6075a().getString("profile_image_status", "").equals("")) {
                    this.f6172a.f6079z.m2962a();
                    this.f6172a.f6022E.show();
                    break;
                }
                break;
        }
    }
}
