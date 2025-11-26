package com.sec.vip.amschaton.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.sec.vip.amschaton.C3425b;
import java.util.HashMap;
import java.util.Map;

/* compiled from: AMSBgSelectionFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.n */
/* loaded from: classes.dex */
public class C3561n {

    /* renamed from: a */
    final /* synthetic */ AMSBgSelectionFragment f12991a;

    /* renamed from: b */
    private final Map<Integer, Bitmap> f12992b = new HashMap();

    /* renamed from: c */
    private Context f12993c;

    /* renamed from: d */
    private int f12994d;

    public C3561n(AMSBgSelectionFragment aMSBgSelectionFragment, Context context, int i) {
        this.f12991a = aMSBgSelectionFragment;
        this.f12994d = 5001;
        this.f12993c = context;
        this.f12994d = i;
    }

    /* renamed from: a */
    public Bitmap m12746a(int i) {
        if (this.f12992b.containsKey(Integer.valueOf(i))) {
            return this.f12992b.get(Integer.valueOf(i));
        }
        Bitmap bitmapM12277a = null;
        switch (this.f12994d) {
            case 5000:
                bitmapM12277a = C3425b.m12268a().m12275a(this.f12993c, i, false);
                break;
            case 5001:
                bitmapM12277a = C3425b.m12268a().m12277a(this.f12993c.getAssets(), i, false);
                break;
        }
        if (bitmapM12277a != null) {
            this.f12992b.put(Integer.valueOf(i), bitmapM12277a);
            return bitmapM12277a;
        }
        return bitmapM12277a;
    }

    /* renamed from: a */
    public void m12747a(int i, ImageView imageView) {
        if (this.f12992b.containsKey(Integer.valueOf(i))) {
            imageView.setImageBitmap(this.f12992b.get(Integer.valueOf(i)));
        }
        new C3563p(this, i, new HandlerC3562o(this, imageView)).start();
    }
}
