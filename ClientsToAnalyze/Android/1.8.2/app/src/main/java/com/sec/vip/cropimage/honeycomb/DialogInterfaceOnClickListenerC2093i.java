package com.sec.vip.cropimage.honeycomb;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import com.sec.amsoma.AMSLibs;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;
import com.sec.widget.C2153y;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.honeycomb.i */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2093i implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSLibs f7616a;

    /* renamed from: b */
    final /* synthetic */ CropImage f7617b;

    DialogInterfaceOnClickListenerC2093i(CropImage cropImage, AMSLibs aMSLibs) {
        this.f7617b = cropImage;
        this.f7616a = aMSLibs;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int[] iArr = null;
        if (this.f7617b.f7592p != null) {
            try {
                int width = this.f7617b.f7592p.getWidth();
                int height = this.f7617b.f7592p.getHeight();
                if (i != 6 && i != 7) {
                    iArr = new int[width * height];
                    this.f7617b.f7592p.getPixels(iArr, 0, width, 0, 0, width, height);
                }
                switch (i) {
                    case 1:
                        this.f7617b.f7595s = 2001;
                        this.f7616a.VipAMS_Blur(iArr, width, height, 7);
                        this.f7617b.f7598v = Bitmap.createBitmap(iArr, width, height, Bitmap.Config.ARGB_8888);
                        break;
                    case 2:
                        this.f7617b.f7595s = 2002;
                        this.f7616a.VipAMS_Bright(iArr, width, height);
                        this.f7617b.f7598v = Bitmap.createBitmap(iArr, width, height, Bitmap.Config.ARGB_8888);
                        break;
                    case 3:
                        this.f7617b.f7595s = 2003;
                        this.f7616a.VipAMS_Dark(iArr, width, height);
                        this.f7617b.f7598v = Bitmap.createBitmap(iArr, width, height, Bitmap.Config.ARGB_8888);
                        break;
                    case 4:
                        this.f7617b.f7595s = 2004;
                        this.f7616a.VipAMS_Gray(iArr, width, height);
                        this.f7617b.f7598v = Bitmap.createBitmap(iArr, width, height, Bitmap.Config.ARGB_8888);
                        break;
                    case 5:
                        this.f7617b.f7595s = 2005;
                        this.f7616a.VipAMS_Negative(iArr, width, height);
                        this.f7617b.f7598v = Bitmap.createBitmap(iArr, width, height, Bitmap.Config.ARGB_8888);
                        break;
                    case 6:
                        this.f7617b.f7595s = 2006;
                        this.f7617b.f7598v = null;
                        break;
                    case 7:
                        this.f7617b.f7595s = 2007;
                        this.f7617b.f7598v = null;
                        break;
                    case 8:
                        this.f7617b.f7595s = 2008;
                        this.f7616a.VipAMS_PencilSketch(iArr, width, height);
                        this.f7617b.f7598v = Bitmap.createBitmap(iArr, width, height, Bitmap.Config.ARGB_8888);
                        break;
                    case 9:
                        this.f7617b.f7595s = 2009;
                        this.f7616a.VipAMS_Sepia(iArr, width, height);
                        this.f7617b.f7598v = Bitmap.createBitmap(iArr, width, height, Bitmap.Config.ARGB_8888);
                        break;
                    default:
                        this.f7617b.f7595s = 2000;
                        this.f7617b.f7598v = null;
                        break;
                }
                this.f7617b.m7347a(false);
                dialogInterface.dismiss();
                return;
            } catch (OutOfMemoryError e) {
                C2153y.m7535a(this.f7617b.m7360d(), R.string.chat_view_memory_error, 0).show();
                dialogInterface.dismiss();
                return;
            }
        }
        C1786r.m6054a("[onEffectOfImage] mBitmap is NULL!!!!!", getClass().getSimpleName());
        dialogInterface.dismiss();
    }
}
