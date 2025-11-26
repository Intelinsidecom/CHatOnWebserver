package com.sec.vip.amschaton.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.sec.vip.amschaton.C3410al;
import java.util.HashMap;
import java.util.Map;

/* compiled from: AMSStampSelectionFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.ct */
/* loaded from: classes.dex */
public class C3526ct {

    /* renamed from: a */
    final /* synthetic */ AMSStampSelectionFragment f12928a;

    /* renamed from: b */
    private final Map<Integer, Bitmap> f12929b = new HashMap();

    /* renamed from: c */
    private int f12930c;

    public C3526ct(AMSStampSelectionFragment aMSStampSelectionFragment, Context context, int i) {
        this.f12928a = aMSStampSelectionFragment;
        this.f12930c = 5002;
        this.f12930c = i;
    }

    /* renamed from: a */
    public Bitmap m12730a(int i) {
        if (this.f12929b.containsKey(Integer.valueOf(i))) {
            return this.f12929b.get(Integer.valueOf(i));
        }
        Bitmap bitmapM12191c = null;
        switch (this.f12930c) {
            case 5000:
                bitmapM12191c = C3410al.m12173a().m12177a(i, true);
                break;
            case 5001:
                bitmapM12191c = C3410al.m12173a().m12198e(i, true);
                break;
            case 5002:
                bitmapM12191c = C3410al.m12173a().m12195d(C3410al.m12173a().m12202g(i), true);
                break;
            case 5003:
                bitmapM12191c = C3410al.m12173a().m12191c(i, true);
                break;
        }
        if (bitmapM12191c != null) {
            this.f12929b.put(Integer.valueOf(i), bitmapM12191c);
            return bitmapM12191c;
        }
        return bitmapM12191c;
    }

    /* renamed from: a */
    public void m12731a(int i, ImageView imageView) {
        if (this.f12929b.containsKey(Integer.valueOf(i))) {
            imageView.setImageBitmap(this.f12929b.get(Integer.valueOf(i)));
        }
        new C3528cv(this, i, new HandlerC3527cu(this, imageView)).start();
    }
}
