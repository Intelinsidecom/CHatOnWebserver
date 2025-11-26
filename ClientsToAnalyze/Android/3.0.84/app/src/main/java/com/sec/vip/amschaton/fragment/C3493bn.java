package com.sec.vip.amschaton.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.sec.vip.amschaton.C3584q;
import java.util.HashMap;
import java.util.Map;

/* compiled from: AMSListFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.bn */
/* loaded from: classes.dex */
public class C3493bn {

    /* renamed from: a */
    final /* synthetic */ AMSListFragment f12867a;

    /* renamed from: b */
    private final Map<Integer, Bitmap> f12868b = new HashMap();

    /* renamed from: c */
    private Context f12869c;

    /* renamed from: d */
    private int f12870d;

    public C3493bn(AMSListFragment aMSListFragment, Context context, int i) {
        this.f12867a = aMSListFragment;
        this.f12870d = 5001;
        this.f12869c = context;
        this.f12870d = i;
    }

    /* renamed from: a */
    public Bitmap m12712a(int i) {
        if (this.f12868b.containsKey(Integer.valueOf(i))) {
            return this.f12868b.get(Integer.valueOf(i));
        }
        Bitmap bitmapM12791a = null;
        switch (this.f12870d) {
            case 5000:
                bitmapM12791a = C3584q.m12778a().m12792a(this.f12869c, i, false);
                break;
            case 5001:
                bitmapM12791a = C3584q.m12778a().m12804b(i, false);
                break;
            case 5002:
                bitmapM12791a = C3584q.m12778a().m12791a(i, false);
                break;
        }
        if (bitmapM12791a != null) {
            this.f12868b.put(Integer.valueOf(i), bitmapM12791a);
            return bitmapM12791a;
        }
        return bitmapM12791a;
    }

    /* renamed from: a */
    public void m12713a(int i, ImageView imageView) {
        if (this.f12868b.containsKey(Integer.valueOf(i))) {
            imageView.setImageBitmap(this.f12868b.get(Integer.valueOf(i)));
        }
        new C3495bp(this, i, new HandlerC3494bo(this, imageView)).start();
    }
}
