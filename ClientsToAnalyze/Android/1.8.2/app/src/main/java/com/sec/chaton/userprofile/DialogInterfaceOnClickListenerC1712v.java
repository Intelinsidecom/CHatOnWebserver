package com.sec.chaton.userprofile;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import com.sec.chaton.buddy.BuddyProfileFragment;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import java.io.File;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.v */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1712v implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f6226a;

    DialogInterfaceOnClickListenerC1712v(MyPageFragment myPageFragment) {
        this.f6226a = myPageFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                this.f6226a.f5816D = true;
                Intent intent = new Intent("android.intent.action.PICK");
                intent.setType("image/*");
                if (!BuddyProfileFragment.m2132a(this.f6226a.getActivity(), intent)) {
                    intent = new Intent();
                    intent.setAction("android.intent.action.GET_CONTENT");
                    intent.setType("image/*");
                }
                intent.putExtra("return-data", true);
                intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
                break;
            case 1:
                this.f6226a.f5816D = false;
                this.f6226a.f5817E = Uri.fromFile(new File(this.f6226a.f5844k, "tmp_myprofile.png_"));
                Intent intent2 = new Intent("android.media.action.IMAGE_CAPTURE");
                intent2.putExtra("outputX", 600);
                intent2.putExtra("outputY", 600);
                intent2.putExtra("aspectX", 1);
                intent2.putExtra("aspectY", 1);
                intent2.putExtra("scale", true);
                intent2.putExtra("return-data", false);
                intent2.putExtra("output", this.f6226a.f5817E);
                intent2.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
                this.f6226a.startActivityForResult(intent2, 6);
                break;
            case 2:
                C1786r.m6066e("onClick Delete profile iamge", MyPageFragment.f5812a);
                if (!C1789u.m6075a().getString("profile_image_status", "").equals("deleted") && !C1789u.m6075a().getString("profile_image_status", "").equals("")) {
                    this.f6226a.f5845l.m2962a();
                    this.f6226a.f5855v.show();
                    break;
                }
                break;
        }
    }
}
