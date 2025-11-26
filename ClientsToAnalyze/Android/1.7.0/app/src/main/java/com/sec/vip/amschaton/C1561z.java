package com.sec.vip.amschaton;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.sec.chaton.R;
import com.sec.chaton.util.C1341p;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: AMSStampManager.java */
/* renamed from: com.sec.vip.amschaton.z */
/* loaded from: classes.dex */
public class C1561z {

    /* renamed from: c */
    private static final C1561z f5424c = new C1561z();

    /* renamed from: j */
    private static int[] f5425j = {0, 3, 6, 29, 30, 31, 33, 34, 36, 40, 41, 55, 56, 57, 61, 63, 65, 75, 76, 77, 78, 81, 82, 84, 90, 96, 100, 117, 157, 160, 163, 173, 174, 189, 190, 199};

    /* renamed from: a */
    private final String f5426a = "stamp_tr_hp";

    /* renamed from: b */
    private final String f5427b = "flashcon_ani_hp";

    /* renamed from: d */
    private Context f5428d = null;

    /* renamed from: e */
    private int f5429e = 0;

    /* renamed from: f */
    private ArrayList f5430f = null;

    /* renamed from: g */
    private int f5431g = 0;

    /* renamed from: h */
    private ArrayList f5432h = null;

    /* renamed from: i */
    private int f5433i = 0;

    private C1561z() {
    }

    /* renamed from: a */
    public static C1561z m5654a() {
        return f5424c;
    }

    /* renamed from: a */
    public void m5660a(Context context, AssetManager assetManager, String str) {
        this.f5428d = context;
        m5659a(context, assetManager);
        m5661a(str);
    }

    /* renamed from: a */
    public void m5659a(Context context, AssetManager assetManager) {
        try {
            if (assetManager.list("stamp_tr_hp").length > 0) {
                this.f5429e = f5425j.length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m5661a(String str) {
        File file = new File(str);
        file.mkdir();
        if (!file.exists()) {
            C1341p.m4651a("[loadUserStamp] There is no directory!", getClass().getSimpleName());
            return;
        }
        String[] list = file.list();
        if (list != null) {
            m5655a(list);
            this.f5431g = list.length;
            this.f5430f = new ArrayList();
            this.f5430f.clear();
            if (this.f5431g > 0) {
                for (int i = 0; i < this.f5431g; i++) {
                    this.f5430f.add(str + list[i]);
                }
            }
        }
    }

    /* renamed from: a */
    public Bitmap m5657a(int i, boolean z) {
        Bitmap bitmapDecodeStream = null;
        if (!m5666c(i)) {
            if (z) {
                return BitmapFactory.decodeResource(this.f5428d.getResources(), R.drawable.more_option_icon_help);
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 2;
            options.inPurgeable = true;
            return BitmapFactory.decodeResource(this.f5428d.getResources(), R.drawable.more_option_icon_help, options);
        }
        try {
            if (z) {
                bitmapDecodeStream = BitmapFactory.decodeStream(this.f5428d.getAssets().open(String.format("stamp_tr_hp/stamp_%03d.png", Integer.valueOf(i + 1))));
            } else {
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inSampleSize = 2;
                options2.inPurgeable = true;
                bitmapDecodeStream = BitmapFactory.decodeStream(this.f5428d.getAssets().open(String.format("stamp_tr_hp/stamp_%03d.png", Integer.valueOf(i + 1))), null, options2);
            }
            return bitmapDecodeStream;
        } catch (IOException e) {
            e.printStackTrace();
            return bitmapDecodeStream;
        }
    }

    /* renamed from: b */
    public int m5662b() {
        return this.f5429e;
    }

    /* renamed from: b */
    public Bitmap m5664b(int i, boolean z) {
        if (i < 0 || i >= m5665c()) {
            return null;
        }
        if (z) {
            return BitmapFactory.decodeFile((String) this.f5430f.get(i));
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        options.inPurgeable = true;
        return BitmapFactory.decodeFile((String) this.f5430f.get(i), options);
    }

    /* renamed from: c */
    public int m5665c() {
        return this.f5431g;
    }

    /* renamed from: a */
    public String m5658a(int i) {
        if (this.f5430f == null) {
            return null;
        }
        return (String) this.f5430f.get(i);
    }

    /* renamed from: a */
    public Bitmap m5656a(int i, int i2) {
        if (this.f5432h == null) {
            return null;
        }
        return (Bitmap) this.f5432h.get((i * 8) + i2);
    }

    /* renamed from: d */
    public int m5667d() {
        return this.f5433i;
    }

    /* renamed from: a */
    private void m5655a(String[] strArr) {
        Arrays.sort(strArr, new C1558w(this));
    }

    /* renamed from: e */
    public boolean m5669e() {
        return this.f5430f == null;
    }

    /* renamed from: b */
    public int m5663b(int i) {
        if (i < 0 || i >= f5425j.length) {
            return -1;
        }
        return f5425j[i];
    }

    /* renamed from: c */
    public boolean m5666c(int i) {
        for (int i2 : f5425j) {
            if (i == i2) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: d */
    public int m5668d(int i) {
        int i2 = 0;
        int[] iArr = f5425j;
        int length = iArr.length;
        int i3 = 0;
        while (i3 < length) {
            if (i != iArr[i3]) {
                i3++;
                i2++;
            } else {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: f */
    public int m5670f() {
        return 211;
    }
}
