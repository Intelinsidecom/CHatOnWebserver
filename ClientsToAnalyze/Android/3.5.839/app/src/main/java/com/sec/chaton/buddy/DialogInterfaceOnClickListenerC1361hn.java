package com.sec.chaton.buddy;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import com.sec.chaton.R;
import com.sec.chaton.p055d.C2134o;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* compiled from: GroupProfileImageViewFragment.java */
/* renamed from: com.sec.chaton.buddy.hn */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1361hn implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ GroupProfileImageViewFragment f4951a;

    DialogInterfaceOnClickListenerC1361hn(GroupProfileImageViewFragment groupProfileImageViewFragment) {
        this.f4951a = groupProfileImageViewFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws UnsupportedEncodingException {
        String strEncode;
        switch (i) {
            case 0:
                Intent intent = new Intent("android.intent.action.PICK");
                intent.setType("image/*");
                intent.putExtra("set-as-image", true);
                if (!BuddyProfileActivity.m6743a(this.f4951a.f4120r, intent)) {
                    intent = new Intent();
                    intent.setAction("android.intent.action.GET_CONTENT");
                    intent.setType("image/*");
                    intent.putExtra("set-as-image", true);
                }
                try {
                    this.f4951a.startActivityForResult(intent, 5);
                    break;
                } catch (ActivityNotFoundException e) {
                    C5179v.m19810a(CommonApplication.m18732r(), R.string.multiwindow_dragNdrop_not_supported, 0).show();
                    if (C4904y.f17875e) {
                        C4904y.m18635a(e, GroupProfileImageViewFragment.f4103b);
                        return;
                    }
                    return;
                }
            case 1:
                Intent intent2 = new Intent("android.media.action.IMAGE_CAPTURE");
                intent2.putExtra("return-data", false);
                intent2.putExtra("output", this.f4951a.f4106d);
                intent2.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
                try {
                    this.f4951a.startActivityForResult(intent2, 6);
                    break;
                } catch (ActivityNotFoundException e2) {
                    C5179v.m19810a(CommonApplication.m18732r(), R.string.multiwindow_dragNdrop_not_supported, 0).show();
                    if (C4904y.f17875e) {
                        C4904y.m18635a(e2, GroupProfileImageViewFragment.f4103b);
                        return;
                    }
                    return;
                }
            case 2:
                C4904y.m18646e("onClick Delete profile iamge", GroupProfileImageViewFragment.f4103b);
                C2134o.m9568a((Handler) null, this.f4951a.f4110h);
                try {
                    strEncode = URLEncoder.encode(this.f4951a.f4110h, "UTF-8");
                } catch (UnsupportedEncodingException e3) {
                    if (C4904y.f17875e) {
                        C4904y.m18635a(e3, getClass().getSimpleName());
                    }
                    strEncode = null;
                }
                File file = new File(this.f4951a.f4114l, strEncode + "_group_profile.png_");
                C2134o.m9568a((Handler) null, this.f4951a.f4110h);
                if (file.delete()) {
                    this.f4951a.f4105c.setImageResource(R.drawable.profile_photo_group_default);
                    C2496n.m10794g(this.f4951a.f4120r, this.f4951a.f4110h);
                }
                this.f4951a.f4120r.finish();
                break;
        }
    }
}
