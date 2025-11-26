package com.sec.vip.amschaton.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.sec.vip.amschaton.C3425b;
import java.util.HashMap;
import java.util.Map;

/* compiled from: AMSBgSelectionFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.q */
/* loaded from: classes.dex */
public class C3564q {

    /* renamed from: a */
    final /* synthetic */ AMSBgSelectionFragment f13000a;

    /* renamed from: b */
    private final Map<String, Bitmap> f13001b = new HashMap();

    public C3564q(AMSBgSelectionFragment aMSBgSelectionFragment) {
        this.f13000a = aMSBgSelectionFragment;
    }

    /* renamed from: a */
    public Bitmap m12748a(String str) {
        if (this.f13001b.containsKey(str)) {
            return this.f13001b.get(str);
        }
        Bitmap bitmapM12277a = null;
        if (str.startsWith("d")) {
            bitmapM12277a = C3425b.m12268a().m12276a((Context) this.f13000a.getActivity(), str.substring(1), false);
        } else {
            int iIntValue = Integer.valueOf(str).intValue();
            if (iIntValue < 10000) {
                bitmapM12277a = C3425b.m12268a().m12277a(this.f13000a.getActivity().getAssets(), iIntValue, false);
            }
        }
        if (bitmapM12277a != null) {
            this.f13001b.put(str, bitmapM12277a);
            return bitmapM12277a;
        }
        return bitmapM12277a;
    }

    /* renamed from: a */
    public void m12749a(String str, ImageView imageView) {
        if (this.f13001b.containsKey(str)) {
            imageView.setImageBitmap(this.f13001b.get(str));
        }
        new C3566s(this, str, new HandlerC3565r(this, imageView)).start();
    }
}
