package com.sec.chaton.userprofile;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import com.sec.chaton.buddy.BuddyProfileFragment;
import com.sec.chaton.userprofile.UserProfileImageView;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import java.io.File;

/* compiled from: UserProfileImageView.java */
/* renamed from: com.sec.chaton.userprofile.cn */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1691cn implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ UserProfileImageView.UserProfileImageViewFragment f6188a;

    DialogInterfaceOnClickListenerC1691cn(UserProfileImageView.UserProfileImageViewFragment userProfileImageViewFragment) {
        this.f6188a = userProfileImageViewFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                this.f6188a.f6094l = false;
                this.f6188a.f6090h = Uri.fromFile(new File(this.f6188a.f6101s, "tmp_myprofile.png_"));
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra("outputX", 600);
                intent.putExtra("outputY", 600);
                intent.putExtra("aspectX", 1);
                intent.putExtra("aspectY", 1);
                intent.putExtra("scale", true);
                intent.putExtra("return-data", false);
                intent.putExtra("output", this.f6188a.f6090h);
                intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
                this.f6188a.startActivityForResult(intent, 6);
                break;
            case 1:
                this.f6188a.f6094l = true;
                Intent intent2 = new Intent("android.intent.action.PICK");
                intent2.setType("image/*");
                if (!BuddyProfileFragment.m2132a(this.f6188a.getActivity(), intent2)) {
                    intent2 = new Intent();
                    intent2.setAction("android.intent.action.GET_CONTENT");
                    intent2.setType("image/*");
                }
                intent2.putExtra("return-data", true);
                intent2.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
                this.f6188a.startActivityForResult(intent2, 5);
                break;
            case 2:
                C1786r.m6066e("onClick Delete profile iamge", UserProfileImageView.UserProfileImageViewFragment.f6081b);
                if (!C1789u.m6075a().getString("profile_image_status", "").equals("deleted") && !C1789u.m6075a().getString("profile_image_status", "").equals("")) {
                    this.f6188a.f6097o.m2962a();
                    this.f6188a.f6096n.show();
                    break;
                }
                break;
        }
    }
}
