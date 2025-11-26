package com.sec.chaton.userprofile;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;

/* renamed from: com.sec.chaton.userprofile.aa */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0547aa implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ UserProfileFragment f3525a;

    DialogInterfaceOnClickListenerC0547aa(UserProfileFragment userProfileFragment) {
        this.f3525a = userProfileFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                this.f3525a.f3450Q = true;
                Intent intent = new Intent("android.intent.action.PICK");
                intent.setType("image/*");
                intent.putExtra("crop", "true");
                intent.putExtra("outputX", 600);
                intent.putExtra("outputY", 600);
                intent.putExtra("aspectX", 1);
                intent.putExtra("aspectY", 1);
                intent.putExtra("scale", true);
                intent.putExtra("return-data", false);
                intent.putExtra("output", this.f3525a.f3451R);
                intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
                this.f3525a.startActivityForResult(intent, 3);
                break;
            case 1:
                this.f3525a.f3450Q = false;
                Intent intent2 = new Intent("android.media.action.IMAGE_CAPTURE");
                intent2.putExtra("output", this.f3525a.f3451R);
                intent2.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
                this.f3525a.startActivityForResult(intent2, 4);
                break;
            case 2:
                ChatONLogWriter.m3511e("onClick Delete profile iamge", UserProfileFragment.f3433a);
                if (!ChatONPref.m3519a().getString("profile_image_status", "").equals("deleted") && !ChatONPref.m3519a().getString("profile_image_status", "").equals("")) {
                    this.f3525a.f3494t.m2064a();
                    this.f3525a.f3437D.show();
                    break;
                }
                break;
        }
    }
}
