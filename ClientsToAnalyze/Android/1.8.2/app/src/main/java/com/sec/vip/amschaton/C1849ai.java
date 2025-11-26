package com.sec.vip.amschaton;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: AMSStampManager.java */
/* renamed from: com.sec.vip.amschaton.ai */
/* loaded from: classes.dex */
public class C1849ai {

    /* renamed from: c */
    private static final C1849ai f6778c = new C1849ai();

    /* renamed from: j */
    private static int[] f6779j = {0, 3, 6, 29, 30, 31, 33, 34, 36, 40, 41, 55, 56, 57, 61, 63, 65, 75, 76, 77, 78, 81, 82, 84, 90, 96, 100, 117, 157, 160, 163, 173, 174, 189, 190, 199};

    /* renamed from: a */
    private final String f6780a = "stamp_tr_hp";

    /* renamed from: b */
    private final String f6781b = "flashcon_ani_hp";

    /* renamed from: d */
    private Context f6782d = null;

    /* renamed from: e */
    private int f6783e = 0;

    /* renamed from: f */
    private ArrayList f6784f = null;

    /* renamed from: g */
    private int f6785g = 0;

    /* renamed from: h */
    private ArrayList f6786h = null;

    /* renamed from: i */
    private int f6787i = 0;

    private C1849ai() {
    }

    /* renamed from: a */
    public static C1849ai m6394a() {
        return f6778c;
    }

    /* renamed from: a */
    public void m6400a(Context context, AssetManager assetManager, String str) {
        this.f6782d = context;
        m6399a(context, assetManager);
        m6401a(str);
    }

    /* renamed from: a */
    public void m6399a(Context context, AssetManager assetManager) {
        try {
            if (assetManager.list("stamp_tr_hp").length > 0) {
                this.f6783e = f6779j.length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m6401a(String str) {
        File file = new File(str);
        file.mkdir();
        if (!file.exists()) {
            C1786r.m6054a("[loadUserStamp] There is no directory!", getClass().getSimpleName());
            return;
        }
        String[] list = file.list();
        if (list != null) {
            m6395a(list);
            this.f6785g = list.length;
            this.f6784f = new ArrayList();
            this.f6784f.clear();
            if (this.f6785g > 0) {
                for (int i = 0; i < this.f6785g; i++) {
                    this.f6784f.add(str + list[i]);
                }
            }
        }
    }

    /* renamed from: a */
    public Bitmap m6397a(int i, boolean z) {
        Bitmap bitmapDecodeStream = null;
        if (!m6406c(i)) {
            if (z) {
                return BitmapFactory.decodeResource(this.f6782d.getResources(), R.drawable.more_option_icon_help);
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 2;
            options.inPurgeable = true;
            return BitmapFactory.decodeResource(this.f6782d.getResources(), R.drawable.more_option_icon_help, options);
        }
        try {
            if (z) {
                bitmapDecodeStream = BitmapFactory.decodeStream(this.f6782d.getAssets().open(String.format("stamp_tr_hp/stamp_%03d.png", Integer.valueOf(i + 1))));
            } else {
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inSampleSize = 2;
                options2.inPurgeable = true;
                bitmapDecodeStream = BitmapFactory.decodeStream(this.f6782d.getAssets().open(String.format("stamp_tr_hp/stamp_%03d.png", Integer.valueOf(i + 1))), null, options2);
            }
            return bitmapDecodeStream;
        } catch (IOException e) {
            e.printStackTrace();
            return bitmapDecodeStream;
        }
    }

    /* renamed from: b */
    public int m6402b() {
        return this.f6783e;
    }

    /* renamed from: b */
    public Bitmap m6404b(int i, boolean z) {
        if (i < 0 || i >= m6405c()) {
            return null;
        }
        if (z) {
            return BitmapFactory.decodeFile((String) this.f6784f.get(i));
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        options.inPurgeable = true;
        return BitmapFactory.decodeFile((String) this.f6784f.get(i), options);
    }

    /* renamed from: c */
    public int m6405c() {
        return this.f6785g;
    }

    /* renamed from: a */
    public String m6398a(int i) {
        if (this.f6784f == null) {
            return null;
        }
        return (String) this.f6784f.get(i);
    }

    /* renamed from: a */
    public Bitmap m6396a(int i, int i2) {
        if (this.f6786h == null) {
            return null;
        }
        return (Bitmap) this.f6786h.get((i * 8) + i2);
    }

    /* renamed from: d */
    public int m6407d() {
        return this.f6787i;
    }

    /* renamed from: a */
    private void m6395a(String[] strArr) {
        Arrays.sort(strArr, new C1850aj(this));
    }

    /* renamed from: e */
    public boolean m6409e() {
        return this.f6784f == null;
    }

    /* renamed from: b */
    public int m6403b(int i) {
        if (i < 0 || i >= f6779j.length) {
            return -1;
        }
        return f6779j[i];
    }

    /* renamed from: c */
    public boolean m6406c(int i) {
        for (int i2 : f6779j) {
            if (i == i2) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: d */
    public int m6408d(int i) {
        int i2 = 0;
        int[] iArr = f6779j;
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
    public int m6410f() {
        return 211;
    }
}
