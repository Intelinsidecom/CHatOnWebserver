package com.sec.vip.amschaton;

import android.content.res.AssetManager;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class AMSBGMManager {

    /* renamed from: b */
    private static final AMSBGMManager f3820b = new AMSBGMManager();

    /* renamed from: a */
    private final String f3821a = "sound";

    /* renamed from: c */
    private ArrayList f3822c = new ArrayList();

    /* renamed from: d */
    private int f3823d = 0;

    private AMSBGMManager() {
    }

    /* renamed from: a */
    public static AMSBGMManager m3719a() {
        return f3820b;
    }

    /* renamed from: a */
    public String m3720a(int i) {
        if (i >= this.f3822c.size()) {
            return null;
        }
        return (String) this.f3822c.get(i);
    }

    /* renamed from: a */
    public void m3721a(AssetManager assetManager) throws IOException {
        try {
            String[] list = assetManager.list("sound");
            if (list.length <= 0) {
                return;
            }
            if (this.f3822c == null) {
                this.f3822c = new ArrayList();
            }
            this.f3822c.clear();
            this.f3823d = list.length;
            for (int i = 0; i < this.f3823d; i++) {
                int i2 = 0;
                while (true) {
                    if (i2 >= this.f3823d) {
                        i2 = 0;
                        break;
                    }
                    if (list[i2].endsWith("backmusic" + (i + 1) + ".mp3")) {
                        break;
                    } else {
                        i2++;
                    }
                }
                this.f3822c.add("sound/" + list[i2]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public int m3722b() {
        return this.f3823d;
    }
}
