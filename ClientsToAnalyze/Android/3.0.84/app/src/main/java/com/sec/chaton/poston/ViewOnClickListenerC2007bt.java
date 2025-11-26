package com.sec.chaton.poston;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.view.View;
import com.sec.chaton.util.C3250y;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* compiled from: PostONWriteFragment.java */
/* renamed from: com.sec.chaton.poston.bt */
/* loaded from: classes.dex */
class ViewOnClickListenerC2007bt implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PostONWriteFragment f7722a;

    ViewOnClickListenerC2007bt(PostONWriteFragment postONWriteFragment) {
        this.f7722a = postONWriteFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C3250y.m11456e("mCameraButton Click", "PostONWriteFragment");
        String str = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()) + PostONWriteFragment.f7574Y;
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "//Camera//");
        if (!file.exists()) {
            file.mkdir();
        }
        this.f7722a.f7587M = Uri.fromFile(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "//Camera//", str));
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("return-data", false);
        intent.putExtra("output", this.f7722a.f7587M);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        this.f7722a.startActivityForResult(intent, 1);
    }
}
