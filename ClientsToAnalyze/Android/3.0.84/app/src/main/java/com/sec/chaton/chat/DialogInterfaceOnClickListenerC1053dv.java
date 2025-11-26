package com.sec.chaton.chat;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C3171am;

/* compiled from: ChatInfoFragment.java */
/* renamed from: com.sec.chaton.chat.dv */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1053dv implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatInfoFragment f4164a;

    DialogInterfaceOnClickListenerC1053dv(ChatInfoFragment chatInfoFragment) {
        this.f4164a = chatInfoFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (!C3171am.m11077o()) {
            i++;
        }
        switch (i) {
            case 0:
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra("return-data", false);
                intent.putExtra("output", this.f4164a.f3721I);
                intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
                this.f4164a.startActivityForResult(intent, 9);
                this.f4164a.f3723K = true;
                break;
            case 1:
                Intent intent2 = new Intent("android.intent.action.PICK");
                intent2.setType("image/*");
                intent2.putExtra("set-as-image", true);
                if (!BuddyProfileActivity.m3573a(GlobalApplication.m11493l(), intent2)) {
                    intent2 = new Intent();
                    intent2.setAction("android.intent.action.GET_CONTENT");
                    intent2.setType("image/*");
                    intent2.putExtra("set-as-image", true);
                }
                this.f4164a.startActivityForResult(intent2, 4);
                this.f4164a.f3723K = true;
                break;
        }
    }
}
