package com.sec.chaton.buddy;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import com.sec.chaton.R;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;
import java.io.File;

/* compiled from: BuddyGroupProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.es */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1285es implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupProfileFragment f4818a;

    DialogInterfaceOnClickListenerC1285es(BuddyGroupProfileFragment buddyGroupProfileFragment) {
        this.f4818a = buddyGroupProfileFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra("return-data", false);
                intent.putExtra("output", this.f4818a.f3793H);
                intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
                try {
                    this.f4818a.startActivityForResult(intent, 5);
                } catch (ActivityNotFoundException e) {
                    C5179v.m19810a(CommonApplication.m18732r(), R.string.multiwindow_dragNdrop_not_supported, 0).show();
                    if (C4904y.f17875e) {
                        C4904y.m18635a(e, BuddyGroupProfileFragment.f3785a);
                    }
                }
                this.f4818a.f3795J = true;
                break;
            case 1:
                Intent intent2 = new Intent("android.intent.action.PICK");
                intent2.setType("image/*");
                intent2.putExtra("set-as-image", true);
                if (!BuddyProfileActivity.m6743a(CommonApplication.m18732r(), intent2)) {
                    intent2 = new Intent();
                    intent2.setAction("android.intent.action.GET_CONTENT");
                    intent2.setType("image/*");
                    intent2.putExtra("set-as-image", true);
                }
                try {
                    this.f4818a.startActivityForResult(intent2, 4);
                } catch (ActivityNotFoundException e2) {
                    C5179v.m19810a(CommonApplication.m18732r(), R.string.multiwindow_dragNdrop_not_supported, 0).show();
                    if (C4904y.f17875e) {
                        C4904y.m18635a(e2, BuddyGroupProfileFragment.f3785a);
                    }
                }
                this.f4818a.f3795J = true;
                break;
            case 2:
                C4904y.m18646e("onClick Delete profile iamge", BuddyGroupProfileFragment.f3785a);
                if (new File(this.f4818a.f3799N, this.f4818a.f3812i.m7036b() + "_group_profile.png_").delete()) {
                    this.f4818a.f3798M.setImageResource(R.drawable.profile_photo_group_default);
                }
                this.f4818a.f3795J = true;
                break;
        }
    }
}
