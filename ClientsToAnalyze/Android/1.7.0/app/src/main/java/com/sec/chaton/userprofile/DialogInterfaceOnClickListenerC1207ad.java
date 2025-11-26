package com.sec.chaton.userprofile;

import android.content.DialogInterface;
import android.content.Intent;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;
import com.sec.vip.cropimage.ImageModify;

/* compiled from: UserProfileDetail.java */
/* renamed from: com.sec.chaton.userprofile.ad */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1207ad implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ UserProfileDetail f4284a;

    DialogInterfaceOnClickListenerC1207ad(UserProfileDetail userProfileDetail) {
        this.f4284a = userProfileDetail;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                this.f4284a.f4221C = true;
                Intent intent = new Intent(this.f4284a.f4223E, (Class<?>) ImageModify.class);
                intent.putExtra("is_gallery", true);
                intent.setType("image/*");
                intent.putExtra("outputX", 600);
                intent.putExtra("outputY", 600);
                intent.putExtra("aspectX", 1);
                intent.putExtra("aspectY", 1);
                intent.putExtra("return-data", true);
                this.f4284a.startActivityForResult(intent, 3);
                break;
            case 1:
                this.f4284a.f4221C = false;
                Intent intent2 = new Intent(this.f4284a.f4223E, (Class<?>) ImageModify.class);
                intent2.putExtra("is_camera", true);
                intent2.setType("image/*");
                intent2.putExtra("outputX", 600);
                intent2.putExtra("outputY", 600);
                intent2.putExtra("aspectX", 1);
                intent2.putExtra("aspectY", 1);
                intent2.putExtra("return-data", true);
                intent2.putExtra("image_uri", this.f4284a.f4222D.toString());
                this.f4284a.startActivityForResult(intent2, 3);
                break;
            case 2:
                C1341p.m4662e("onClick Delete profile iamge", "UserProfileDetail");
                if (!C1323bs.m4575a().getString("profile_image_status", "").equals("deleted") && !C1323bs.m4575a().getString("profile_image_status", "").equals("")) {
                    this.f4284a.f4246o.m872a();
                    this.f4284a.f4253v.show();
                    break;
                }
                break;
        }
    }
}
