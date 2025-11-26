package com.sec.vip.cropimage;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import com.sec.amsoma.AMSLibs;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.pns.msg.MsgResultCode;

/* renamed from: com.sec.vip.cropimage.e */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0732e implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSLibs f4470a;

    /* renamed from: b */
    final /* synthetic */ CropImage f4471b;

    DialogInterfaceOnClickListenerC0732e(CropImage cropImage, AMSLibs aMSLibs) {
        this.f4471b = cropImage;
        this.f4470a = aMSLibs;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int[] iArr;
        if (this.f4471b.f4376o == null) {
            ChatONLogWriter.m3499a("[onEffectOfImage] mBitmap is NULL!!!!!", getClass().getSimpleName());
            return;
        }
        int width = this.f4471b.f4376o.getWidth();
        int height = this.f4471b.f4376o.getHeight();
        if (i == 6 || i == 7) {
            iArr = null;
        } else {
            int[] iArr2 = new int[width * height];
            this.f4471b.f4376o.getPixels(iArr2, 0, width, 0, 0, width, height);
            iArr = iArr2;
        }
        switch (i) {
            case 1:
                this.f4471b.f4379r = MsgResultCode.UNEXPECTED_MESSAGE;
                this.f4470a.VipAMS_BlurUsingIntergralImg(iArr, width, height, 0, 0, width, height, 7);
                this.f4471b.f4382u = Bitmap.createBitmap(iArr, width, height, Bitmap.Config.ARGB_8888);
                break;
            case 2:
                this.f4471b.f4379r = MsgResultCode.INTERNAL_SERVER_ERROR;
                this.f4470a.VipAMS_Bright(iArr, width, height, 0, 0, width, height);
                this.f4471b.f4382u = Bitmap.createBitmap(iArr, width, height, Bitmap.Config.ARGB_8888);
                break;
            case 3:
                this.f4471b.f4379r = MsgResultCode.INTERRUPTED;
                this.f4470a.VipAMS_Dark(iArr, width, height, 0, 0, width, height);
                this.f4471b.f4382u = Bitmap.createBitmap(iArr, width, height, Bitmap.Config.ARGB_8888);
                break;
            case 4:
                this.f4471b.f4379r = 2004;
                this.f4470a.VipAMS_Gray(iArr, width, height, 0, 0, width, height);
                this.f4471b.f4382u = Bitmap.createBitmap(iArr, width, height, Bitmap.Config.ARGB_8888);
                break;
            case 5:
                this.f4471b.f4379r = 2005;
                this.f4470a.VipAMS_Negative(iArr, width, height, 0, 0, width, height);
                this.f4471b.f4382u = Bitmap.createBitmap(iArr, width, height, Bitmap.Config.ARGB_8888);
                break;
            case 6:
                this.f4471b.f4379r = 2006;
                this.f4471b.f4382u = null;
                break;
            case 7:
                this.f4471b.f4379r = 2007;
                this.f4471b.f4382u = null;
                break;
            case 8:
                this.f4471b.f4379r = 2008;
                this.f4470a.VipAMS_PencilSketch(iArr, width, height, 0, 0, width, height);
                this.f4471b.f4382u = Bitmap.createBitmap(iArr, width, height, Bitmap.Config.ARGB_8888);
                break;
            case 9:
                this.f4471b.f4379r = 2009;
                this.f4470a.VipAMS_Sepia(iArr, width, height, 0, 0, width, height);
                this.f4471b.f4382u = Bitmap.createBitmap(iArr, width, height, Bitmap.Config.ARGB_8888);
                break;
            default:
                this.f4471b.f4379r = MsgResultCode.UNKNOWN_MESSAGE_TYPE;
                this.f4471b.f4382u = null;
                break;
        }
        this.f4471b.m4254e();
        dialogInterface.dismiss();
    }
}
