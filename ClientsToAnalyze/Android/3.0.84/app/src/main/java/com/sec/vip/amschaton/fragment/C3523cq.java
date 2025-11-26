package com.sec.vip.amschaton.fragment;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.sec.vip.amschaton.C3410al;
import java.util.HashMap;
import java.util.Map;

/* compiled from: AMSStampSelectionFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.cq */
/* loaded from: classes.dex */
public class C3523cq {

    /* renamed from: a */
    final /* synthetic */ AMSStampSelectionFragment f12921a;

    /* renamed from: b */
    private final Map<String, Bitmap> f12922b = new HashMap();

    public C3523cq(AMSStampSelectionFragment aMSStampSelectionFragment) {
        this.f12921a = aMSStampSelectionFragment;
    }

    /* renamed from: a */
    public Bitmap m12728a(String str) throws NumberFormatException {
        if (this.f12922b.containsKey(str)) {
            return this.f12922b.get(str);
        }
        Bitmap bitmapM12187b = null;
        if (str.startsWith("d")) {
            bitmapM12187b = C3410al.m12173a().m12178a(str.substring(1), true);
        } else {
            int iIntValue = Integer.valueOf(str).intValue();
            if (iIntValue >= 0) {
                if (iIntValue < 20000) {
                    bitmapM12187b = C3410al.m12173a().m12195d(iIntValue, true);
                } else if (iIntValue < 30000) {
                    bitmapM12187b = C3410al.m12173a().m12198e(iIntValue - 20000, true);
                } else if (iIntValue < 40000) {
                    bitmapM12187b = C3410al.m12173a().m12187b(iIntValue - 30000, true);
                }
            }
        }
        if (bitmapM12187b != null) {
            this.f12922b.put(str, bitmapM12187b);
            return bitmapM12187b;
        }
        return bitmapM12187b;
    }

    /* renamed from: a */
    public void m12729a(String str, ImageView imageView) {
        if (this.f12922b.containsKey(str)) {
            imageView.setImageBitmap(this.f12922b.get(str));
        }
        new C3525cs(this, str, new HandlerC3524cr(this, imageView)).start();
    }
}
