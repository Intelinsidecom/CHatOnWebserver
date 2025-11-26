package com.sec.vip.cropimage.ics;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import com.sec.amsoma.AMSLibs;
import com.sec.chaton.util.C1341p;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.ics.b */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1580b implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSLibs f5594a;

    /* renamed from: b */
    final /* synthetic */ CropImage f5595b;

    DialogInterfaceOnClickListenerC1580b(CropImage cropImage, AMSLibs aMSLibs) {
        this.f5595b = cropImage;
        this.f5594a = aMSLibs;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int[] iArr;
        if (this.f5595b.f5577o != null) {
            int width = this.f5595b.f5577o.getWidth();
            int height = this.f5595b.f5577o.getHeight();
            if (i == 6 || i == 7) {
                iArr = null;
            } else {
                iArr = new int[width * height];
                this.f5595b.f5577o.getPixels(iArr, 0, width, 0, 0, width, height);
            }
            switch (i) {
                case 1:
                    this.f5595b.f5580r = 2001;
                    this.f5594a.VipAMS_Blur(iArr, width, height, 7);
                    this.f5595b.f5583u = Bitmap.createBitmap(iArr, width, height, Bitmap.Config.ARGB_8888);
                    break;
                case 2:
                    this.f5595b.f5580r = 2002;
                    this.f5594a.VipAMS_Bright(iArr, width, height);
                    this.f5595b.f5583u = Bitmap.createBitmap(iArr, width, height, Bitmap.Config.ARGB_8888);
                    break;
                case 3:
                    this.f5595b.f5580r = 2003;
                    this.f5594a.VipAMS_Dark(iArr, width, height);
                    this.f5595b.f5583u = Bitmap.createBitmap(iArr, width, height, Bitmap.Config.ARGB_8888);
                    break;
                case 4:
                    this.f5595b.f5580r = 2004;
                    this.f5594a.VipAMS_Gray(iArr, width, height);
                    this.f5595b.f5583u = Bitmap.createBitmap(iArr, width, height, Bitmap.Config.ARGB_8888);
                    break;
                case 5:
                    this.f5595b.f5580r = 2005;
                    this.f5594a.VipAMS_Negative(iArr, width, height);
                    this.f5595b.f5583u = Bitmap.createBitmap(iArr, width, height, Bitmap.Config.ARGB_8888);
                    break;
                case 6:
                    this.f5595b.f5580r = 2006;
                    this.f5595b.f5583u = null;
                    break;
                case 7:
                    this.f5595b.f5580r = 2007;
                    this.f5595b.f5583u = null;
                    break;
                case 8:
                    this.f5595b.f5580r = 2008;
                    this.f5594a.VipAMS_PencilSketch(iArr, width, height);
                    this.f5595b.f5583u = Bitmap.createBitmap(iArr, width, height, Bitmap.Config.ARGB_8888);
                    break;
                case 9:
                    this.f5595b.f5580r = 2009;
                    this.f5594a.VipAMS_Sepia(iArr, width, height);
                    this.f5595b.f5583u = Bitmap.createBitmap(iArr, width, height, Bitmap.Config.ARGB_8888);
                    break;
                default:
                    this.f5595b.f5580r = 2000;
                    this.f5595b.f5583u = null;
                    break;
            }
            this.f5595b.m5783a(false);
            dialogInterface.dismiss();
            return;
        }
        C1341p.m4651a("[onEffectOfImage] mBitmap is NULL!!!!!", getClass().getSimpleName());
    }
}
