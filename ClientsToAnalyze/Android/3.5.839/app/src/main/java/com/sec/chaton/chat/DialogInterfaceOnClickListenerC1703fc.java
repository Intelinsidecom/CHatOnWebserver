package com.sec.chaton.chat;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: ChatInfoFragment.java */
/* renamed from: com.sec.chaton.chat.fc */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1703fc implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatInfoFragment f6308a;

    DialogInterfaceOnClickListenerC1703fc(ChatInfoFragment chatInfoFragment) {
        this.f6308a = chatInfoFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (!C4822an.m18251s()) {
            i++;
        }
        switch (i) {
            case 0:
                Intent intent = new Intent("android.intent.action.PICK");
                intent.setType("image/*");
                intent.putExtra("set-as-image", true);
                if (!BuddyProfileActivity.m6743a(GlobalApplication.m18732r(), intent)) {
                    intent = new Intent();
                    intent.setAction("android.intent.action.GET_CONTENT");
                    intent.setType("image/*");
                    intent.putExtra("set-as-image", true);
                }
                try {
                    this.f6308a.startActivityForResult(intent, 4);
                } catch (ActivityNotFoundException e) {
                    C5179v.m19810a(CommonApplication.m18732r(), R.string.multiwindow_dragNdrop_not_supported, 0).show();
                    if (C4904y.f17875e) {
                        C4904y.m18635a(e, ChatInfoFragment.f5755a);
                    }
                }
                this.f6308a.f5771P = true;
                break;
            case 1:
                Intent intent2 = new Intent("android.media.action.IMAGE_CAPTURE");
                intent2.putExtra("return-data", false);
                intent2.putExtra("output", this.f6308a.f5769N);
                intent2.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
                try {
                    this.f6308a.startActivityForResult(intent2, 9);
                } catch (ActivityNotFoundException e2) {
                    C5179v.m19810a(CommonApplication.m18732r(), R.string.multiwindow_dragNdrop_not_supported, 0).show();
                    if (C4904y.f17875e) {
                        C4904y.m18635a(e2, ChatInfoFragment.f5755a);
                    }
                }
                this.f6308a.f5771P = true;
                break;
        }
    }
}
