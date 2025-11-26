package com.sec.chaton.userprofile;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.userprofile.UserProfileImageView;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;

/* compiled from: UserProfileImageView.java */
/* renamed from: com.sec.chaton.userprofile.w */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1273w implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ UserProfileImageView.UserProfileImageViewFragment f4374a;

    DialogInterfaceOnClickListenerC1273w(UserProfileImageView.UserProfileImageViewFragment userProfileImageViewFragment) {
        this.f4374a = userProfileImageViewFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                this.f4374a.f4266i = true;
                Intent intent = new Intent("android.intent.action.PICK");
                intent.setType("image/*");
                if (!BuddyProfileActivity.m2254a(this.f4374a.getActivity(), intent)) {
                    intent = new Intent();
                    intent.setAction("android.intent.action.GET_CONTENT");
                    intent.setType("image/*");
                }
                intent.putExtra("return-data", true);
                intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
                this.f4374a.startActivityForResult(intent, 5);
                break;
            case 1:
                this.f4374a.f4266i = false;
                Intent intent2 = new Intent("android.media.action.IMAGE_CAPTURE");
                intent2.putExtra("outputX", 600);
                intent2.putExtra("outputY", 600);
                intent2.putExtra("aspectX", 1);
                intent2.putExtra("aspectY", 1);
                intent2.putExtra("scale", true);
                intent2.putExtra("return-data", false);
                intent2.putExtra("output", this.f4374a.f4262e);
                intent2.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
                this.f4374a.startActivityForResult(intent2, 6);
                break;
            case 2:
                C1341p.m4662e("onClick Delete profile iamge", UserProfileImageView.UserProfileImageViewFragment.f4258b);
                if (!C1323bs.m4575a().getString("profile_image_status", "").equals("deleted") && !C1323bs.m4575a().getString("profile_image_status", "").equals("")) {
                    this.f4374a.f4268k.m872a();
                    this.f4374a.f4267j.show();
                    break;
                }
                break;
        }
    }
}
