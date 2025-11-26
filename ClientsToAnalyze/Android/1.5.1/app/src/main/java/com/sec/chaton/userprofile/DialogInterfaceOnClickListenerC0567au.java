package com.sec.chaton.userprofile;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;

/* renamed from: com.sec.chaton.userprofile.au */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0567au implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ UserProfileImageView f3547a;

    DialogInterfaceOnClickListenerC0567au(UserProfileImageView userProfileImageView) {
        this.f3547a = userProfileImageView;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                this.f3547a.f3511k = true;
                Intent intent = new Intent("android.intent.action.PICK");
                intent.setType("image/*");
                intent.putExtra("crop", "true");
                intent.putExtra("outputX", this.f3547a.f3514n);
                intent.putExtra("outputY", this.f3547a.f3515o);
                intent.putExtra("aspectX", 1);
                intent.putExtra("aspectY", 1);
                intent.putExtra("scale", true);
                intent.putExtra("return-data", false);
                intent.putExtra("output", this.f3547a.f3509i);
                intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
                this.f3547a.startActivityForResult(intent, 3);
                break;
            case 1:
                this.f3547a.f3511k = false;
                Intent intent2 = new Intent("android.media.action.IMAGE_CAPTURE");
                intent2.putExtra("output", this.f3547a.f3509i);
                intent2.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
                this.f3547a.startActivityForResult(intent2, 4);
                break;
            case 2:
                ChatONLogWriter.m3511e("onClick Delete profile iamge", UserProfileImageView.f3501b);
                if (!ChatONPref.m3519a().getString("profile_image_status", "").equals("deleted") && !ChatONPref.m3519a().getString("profile_image_status", "").equals("")) {
                    this.f3547a.f3513m.m2064a();
                    this.f3547a.f3512l.show();
                    break;
                }
                break;
        }
    }
}
