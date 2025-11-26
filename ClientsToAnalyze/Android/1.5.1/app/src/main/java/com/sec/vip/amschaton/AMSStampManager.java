package com.sec.vip.amschaton;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.sec.chaton.util.ChatONLogWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes.dex */
public class AMSStampManager {

    /* renamed from: c */
    private static final AMSStampManager f4040c = new AMSStampManager();

    /* renamed from: a */
    private final String f4041a = "stamp_tr_hp";

    /* renamed from: b */
    private final String f4042b = "flashcon_ani_hp";

    /* renamed from: d */
    private ArrayList f4043d = null;

    /* renamed from: e */
    private int f4044e = 0;

    /* renamed from: f */
    private ArrayList f4045f = null;

    /* renamed from: g */
    private ArrayList f4046g = null;

    /* renamed from: h */
    private int f4047h = 0;

    /* renamed from: i */
    private ArrayList f4048i = null;

    /* renamed from: j */
    private int f4049j = 0;

    private AMSStampManager() {
    }

    /* renamed from: a */
    public static AMSStampManager m4056a() {
        return f4040c;
    }

    /* renamed from: a */
    private void m4057a(String[] strArr) {
        Arrays.sort(strArr, new C0721x(this));
    }

    /* renamed from: a */
    public Bitmap m4058a(int i) {
        if (this.f4043d == null) {
            return null;
        }
        if (i < 0 || i >= m4063b()) {
            return null;
        }
        return (Bitmap) this.f4043d.get(i);
    }

    /* renamed from: a */
    public Bitmap m4059a(int i, int i2) {
        if (this.f4048i == null) {
            return null;
        }
        return (Bitmap) this.f4048i.get((i * 8) + i2);
    }

    /* renamed from: a */
    public void m4060a(Context context, AssetManager assetManager) throws IOException {
        try {
            String[] list = assetManager.list("stamp_tr_hp");
            if (list.length > 0 && this.f4043d == null) {
                this.f4043d = new ArrayList();
                this.f4043d.clear();
                this.f4044e = list.length;
                for (int i = 0; i < this.f4044e; i++) {
                    try {
                        this.f4043d.add(BitmapFactory.decodeStream(context.getAssets().open("stamp_tr_hp/" + list[i])));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m4061a(Context context, AssetManager assetManager, String str) throws IOException {
        m4060a(context, assetManager);
        m4062a(str);
    }

    /* renamed from: a */
    public void m4062a(String str) {
        File file = new File(str);
        file.mkdir();
        if (!file.exists()) {
            ChatONLogWriter.m3499a("[loadUserStamp] There is no directory!", getClass().getSimpleName());
            return;
        }
        String[] list = file.list();
        if (list != null) {
            m4057a(list);
            this.f4045f = new ArrayList();
            this.f4045f.clear();
            this.f4046g = new ArrayList();
            this.f4046g.clear();
            this.f4047h = list.length;
            if (this.f4047h > 0) {
                for (int i = 0; i < this.f4047h; i++) {
                    String str2 = str + list[i];
                    this.f4045f.add(str2);
                    this.f4046g.add(BitmapFactory.decodeFile(str2));
                }
            }
        }
    }

    /* renamed from: b */
    public int m4063b() {
        return this.f4044e;
    }

    /* renamed from: b */
    public Bitmap m4064b(int i) {
        if (this.f4046g == null) {
            return null;
        }
        if (i < 0 || i >= m4065c()) {
            return null;
        }
        return (Bitmap) this.f4046g.get(i);
    }

    /* renamed from: c */
    public int m4065c() {
        return this.f4047h;
    }

    /* renamed from: c */
    public String m4066c(int i) {
        if (this.f4045f == null) {
            return null;
        }
        return (String) this.f4045f.get(i);
    }

    /* renamed from: d */
    public int m4067d() {
        return this.f4049j;
    }
}
