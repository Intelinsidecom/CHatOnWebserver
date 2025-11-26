package com.android.p029ex.editstyledtext;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Html;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: EditStyledText.java */
/* renamed from: com.android.ex.editstyledtext.ao */
/* loaded from: classes.dex */
class C0375ao implements Html.ImageGetter {

    /* renamed from: a */
    final /* synthetic */ C0374an f918a;

    C0375ao(C0374an c0374an) {
        this.f918a = c0374an;
    }

    @Override // android.text.Html.ImageGetter
    public Drawable getDrawable(String str) throws IOException {
        Bitmap bitmapDecodeStream;
        int i;
        int i2;
        Log.d("EditStyledText", "--- sethtml: src=" + str);
        if (!str.startsWith("content://")) {
            return null;
        }
        Uri uri = Uri.parse(str);
        try {
            System.gc();
            InputStream inputStreamOpenInputStream = this.f918a.f916b.getContext().getContentResolver().openInputStream(uri);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
            inputStreamOpenInputStream.close();
            InputStream inputStreamOpenInputStream2 = this.f918a.f916b.getContext().getContentResolver().openInputStream(uri);
            int i3 = options.outWidth;
            int i4 = options.outHeight;
            if (options.outWidth > this.f918a.f915a.m1285z()) {
                int iM1285z = this.f918a.f915a.m1285z();
                int iM1285z2 = (i4 * this.f918a.f915a.m1285z()) / options.outWidth;
                bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream2, new Rect(0, 0, iM1285z, iM1285z2), null);
                i = iM1285z;
                i2 = iM1285z2;
            } else {
                bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream2);
                i = i3;
                i2 = i4;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(this.f918a.f916b.getContext().getResources(), bitmapDecodeStream);
            bitmapDrawable.setBounds(0, 0, i, i2);
            inputStreamOpenInputStream2.close();
            return bitmapDrawable;
        } catch (Exception e) {
            Log.e("EditStyledText", "--- set html: Failed to loaded content " + uri, e);
            return null;
        } catch (OutOfMemoryError e2) {
            Log.e("EditStyledText", "OutOfMemoryError");
            this.f918a.f916b.setHint(5);
            return null;
        }
    }
}
