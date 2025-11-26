package com.sec.chaton.settings;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;
import java.io.File;

/* compiled from: FragmentSkinChange3.java */
/* renamed from: com.sec.chaton.settings.fb */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3619fb implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentSkinChange3 f13153a;

    DialogInterfaceOnClickListenerC3619fb(FragmentSkinChange3 fragmentSkinChange3) {
        this.f13153a = fragmentSkinChange3;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f13153a.f12739D = false;
        if (!C4822an.m18251s()) {
            i++;
        }
        this.f13153a.f12742G = Uri.fromFile(new File(GlobalApplication.m18732r().getExternalCacheDir().getAbsolutePath() + "/tempMyBg"));
        switch (i) {
            case 0:
                Intent intent = new Intent("android.intent.action.PICK");
                intent.setType("image/*");
                intent.putExtra("set-as-image", true);
                if (!BuddyProfileActivity.m6743a(this.f13153a.getActivity(), intent)) {
                    intent = new Intent();
                    intent.setAction("android.intent.action.GET_CONTENT");
                    intent.setType("image/*");
                    intent.putExtra("set-as-image", true);
                }
                try {
                    this.f13153a.startActivityForResult(intent, 3);
                } catch (ActivityNotFoundException e) {
                    C5179v.m19810a(CommonApplication.m18732r(), R.string.multiwindow_dragNdrop_not_supported, 0).show();
                    if (C4904y.f17875e) {
                        C4904y.m18635a(e, getClass().getSimpleName());
                    }
                }
                this.f13153a.f12738C = true;
                break;
            case 1:
                Intent intent2 = new Intent("android.media.action.IMAGE_CAPTURE");
                intent2.putExtra("return-data", false);
                intent2.putExtra("output", this.f13153a.f12742G);
                intent2.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
                try {
                    this.f13153a.startActivityForResult(intent2, 4);
                } catch (ActivityNotFoundException e2) {
                    C5179v.m19810a(CommonApplication.m18732r(), R.string.multiwindow_dragNdrop_not_supported, 0).show();
                    if (C4904y.f17875e) {
                        C4904y.m18635a(e2, getClass().getSimpleName());
                    }
                }
                this.f13153a.f12738C = true;
                break;
        }
    }
}
