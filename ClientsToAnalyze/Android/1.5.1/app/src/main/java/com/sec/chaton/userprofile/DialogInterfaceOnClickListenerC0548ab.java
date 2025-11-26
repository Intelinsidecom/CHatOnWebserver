package com.sec.chaton.userprofile;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;

/* renamed from: com.sec.chaton.userprofile.ab */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0548ab implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ UserProfileDetail f3526a;

    DialogInterfaceOnClickListenerC0548ab(UserProfileDetail userProfileDetail) {
        this.f3526a = userProfileDetail;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                this.f3526a.f3398P = true;
                Intent intent = new Intent("android.intent.action.PICK");
                intent.setType("image/*");
                intent.putExtra("crop", "true");
                intent.putExtra("outputX", 600);
                intent.putExtra("outputY", 600);
                intent.putExtra("aspectX", 1);
                intent.putExtra("aspectY", 1);
                intent.putExtra("scale", true);
                intent.putExtra("return-data", false);
                intent.putExtra("output", this.f3526a.f3399Q);
                intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
                this.f3526a.startActivityForResult(intent, 3);
                break;
            case 1:
                this.f3526a.f3398P = false;
                Intent intent2 = new Intent("android.media.action.IMAGE_CAPTURE");
                intent2.putExtra("output", this.f3526a.f3399Q);
                intent2.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
                this.f3526a.startActivityForResult(intent2, 4);
                break;
            case 2:
                ChatONLogWriter.m3511e("onClick Delete profile iamge", "UserProfileDetail");
                if (!ChatONPref.m3519a().getString("profile_image_status", "").equals("deleted") && !ChatONPref.m3519a().getString("profile_image_status", "").equals("")) {
                    this.f3526a.f3429w.m2064a();
                    this.f3526a.f3387E.show();
                    break;
                }
                break;
        }
    }
}
