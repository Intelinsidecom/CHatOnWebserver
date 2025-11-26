package com.sec.vip.amschaton.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import java.util.HashMap;
import java.util.Map;

/* compiled from: AMSListFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.bk */
/* loaded from: classes.dex */
public class C3490bk {

    /* renamed from: a */
    final /* synthetic */ AMSListFragment f12860a;

    /* renamed from: b */
    private final Map<String, Bitmap> f12861b = new HashMap();

    public C3490bk(AMSListFragment aMSListFragment) {
        this.f12860a = aMSListFragment;
    }

    /* renamed from: a */
    public Bitmap m12710a(String str) {
        if (this.f12861b.containsKey(str)) {
            return this.f12861b.get(str);
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        options.inPurgeable = true;
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str, options);
        if (bitmapDecodeFile != null) {
            this.f12861b.put(str, bitmapDecodeFile);
            return bitmapDecodeFile;
        }
        return bitmapDecodeFile;
    }

    /* renamed from: a */
    public void m12711a(String str, ImageView imageView) {
        if (this.f12861b.containsKey(str)) {
            imageView.setImageBitmap(this.f12861b.get(str));
        }
        new C3492bm(this, str, new HandlerC3491bl(this, imageView)).start();
    }
}
