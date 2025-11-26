package com.samsung.sdraw;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.WindowManager;

/* renamed from: com.samsung.sdraw.ca */
/* loaded from: classes.dex */
class C1042ca {
    /* renamed from: a */
    public static Drawable m1517a(byte[] bArr) {
        return new BitmapDrawable(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
    }

    /* renamed from: a */
    public static boolean m1518a(Context context) {
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        return rotation == 0 || rotation == 2;
    }
}
