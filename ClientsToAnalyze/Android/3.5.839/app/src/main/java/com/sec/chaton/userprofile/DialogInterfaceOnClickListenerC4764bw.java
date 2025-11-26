package com.sec.chaton.userprofile;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import com.sec.chaton.R;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: ProfileImageHistoryFragment.java */
/* renamed from: com.sec.chaton.userprofile.bw */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4764bw implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ProfileImageHistoryFragment f17482a;

    DialogInterfaceOnClickListenerC4764bw(ProfileImageHistoryFragment profileImageHistoryFragment) {
        this.f17482a = profileImageHistoryFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                this.f17482a.m17995i();
                break;
            case 1:
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra("return-data", false);
                intent.putExtra("output", this.f17482a.f17340h);
                intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
                try {
                    this.f17482a.startActivityForResult(intent, 6);
                } catch (ActivityNotFoundException e) {
                    C5179v.m19810a(CommonApplication.m18732r(), R.string.multiwindow_dragNdrop_not_supported, 0).show();
                    if (C4904y.f17875e) {
                        C4904y.m18635a(e, ProfileImageHistoryFragment.f17281d);
                    }
                }
                this.f17482a.f17344l = true;
                break;
        }
    }
}
