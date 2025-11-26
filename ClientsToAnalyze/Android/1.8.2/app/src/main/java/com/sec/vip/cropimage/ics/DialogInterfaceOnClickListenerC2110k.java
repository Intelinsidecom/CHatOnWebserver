package com.sec.vip.cropimage.ics;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import com.sec.amsoma.AMSLibs;
import com.sec.chaton.util.C1786r;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.ics.k */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2110k implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSLibs f7675a;

    /* renamed from: b */
    final /* synthetic */ CropImage f7676b;

    DialogInterfaceOnClickListenerC2110k(CropImage cropImage, AMSLibs aMSLibs) {
        this.f7676b = cropImage;
        this.f7675a = aMSLibs;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int[] iArr;
        if (this.f7676b.f7648o != null) {
            int width = this.f7676b.f7648o.getWidth();
            int height = this.f7676b.f7648o.getHeight();
            if (i == 6 || i == 7) {
                iArr = null;
            } else {
                iArr = new int[width * height];
                this.f7676b.f7648o.getPixels(iArr, 0, width, 0, 0, width, height);
            }
            switch (i) {
                case 1:
                    this.f7676b.f7651r = 2001;
                    this.f7675a.VipAMS_Blur(iArr, width, height, 7);
                    this.f7676b.f7654u = Bitmap.createBitmap(iArr, width, height, Bitmap.Config.ARGB_8888);
                    break;
                case 2:
                    this.f7676b.f7651r = 2002;
                    this.f7675a.VipAMS_Bright(iArr, width, height);
                    this.f7676b.f7654u = Bitmap.createBitmap(iArr, width, height, Bitmap.Config.ARGB_8888);
                    break;
                case 3:
                    this.f7676b.f7651r = 2003;
                    this.f7675a.VipAMS_Dark(iArr, width, height);
                    this.f7676b.f7654u = Bitmap.createBitmap(iArr, width, height, Bitmap.Config.ARGB_8888);
                    break;
                case 4:
                    this.f7676b.f7651r = 2004;
                    this.f7675a.VipAMS_Gray(iArr, width, height);
                    this.f7676b.f7654u = Bitmap.createBitmap(iArr, width, height, Bitmap.Config.ARGB_8888);
                    break;
                case 5:
                    this.f7676b.f7651r = 2005;
                    this.f7675a.VipAMS_Negative(iArr, width, height);
                    this.f7676b.f7654u = Bitmap.createBitmap(iArr, width, height, Bitmap.Config.ARGB_8888);
                    break;
                case 6:
                    this.f7676b.f7651r = 2006;
                    this.f7676b.f7654u = null;
                    break;
                case 7:
                    this.f7676b.f7651r = 2007;
                    this.f7676b.f7654u = null;
                    break;
                case 8:
                    this.f7676b.f7651r = 2008;
                    this.f7675a.VipAMS_PencilSketch(iArr, width, height);
                    this.f7676b.f7654u = Bitmap.createBitmap(iArr, width, height, Bitmap.Config.ARGB_8888);
                    break;
                case 9:
                    this.f7676b.f7651r = 2009;
                    this.f7675a.VipAMS_Sepia(iArr, width, height);
                    this.f7676b.f7654u = Bitmap.createBitmap(iArr, width, height, Bitmap.Config.ARGB_8888);
                    break;
                default:
                    this.f7676b.f7651r = 2000;
                    this.f7676b.f7654u = null;
                    break;
            }
            this.f7676b.m7396a(false);
            dialogInterface.dismiss();
            return;
        }
        C1786r.m6054a("[onEffectOfImage] mBitmap is NULL!!!!!", getClass().getSimpleName());
    }
}
