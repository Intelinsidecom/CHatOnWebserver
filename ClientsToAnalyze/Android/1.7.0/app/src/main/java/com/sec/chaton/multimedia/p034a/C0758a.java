package com.sec.chaton.multimedia.p034a;

import android.content.Context;
import com.sec.chaton.util.C1341p;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: EmoticonUsageManager.java */
/* renamed from: com.sec.chaton.multimedia.a.a */
/* loaded from: classes.dex */
public class C0758a {

    /* renamed from: a */
    C0761d f2579a;

    /* renamed from: b */
    Boolean f2580b = false;

    /* renamed from: c */
    private Context f2581c;

    public C0758a(Context context, int i) {
        this.f2581c = context;
        if (i == 1) {
            this.f2579a = m3189e();
        } else if (i == 2) {
            this.f2579a = m3190f();
        }
    }

    /* renamed from: a */
    public ArrayList m3184a() {
        return this.f2579a.f2594a;
    }

    /* renamed from: b */
    public boolean m3186b() {
        return this.f2580b.booleanValue();
    }

    /* renamed from: a */
    public void m3185a(String str, int i, int i2) {
        this.f2579a.m3204a(str, i, i2);
    }

    /* renamed from: c */
    public int m3187c() {
        return this.f2579a.f2594a.size();
    }

    /* renamed from: d */
    public C0761d m3188d() {
        return this.f2579a;
    }

    /* renamed from: e */
    public C0761d m3189e() throws IOException {
        this.f2579a = null;
        try {
            if (new File(this.f2581c.getFilesDir(), "emoticonUsage").exists()) {
                ObjectInputStream objectInputStream = new ObjectInputStream(this.f2581c.openFileInput("emoticonUsage"));
                try {
                    this.f2579a = (C0761d) objectInputStream.readObject();
                    if (this.f2579a != null) {
                        this.f2579a.m3205b();
                        Collections.sort(this.f2579a.f2594a);
                    }
                } finally {
                    objectInputStream.close();
                    this.f2580b = Boolean.valueOf(true);
                }
            }
        } catch (FileNotFoundException e) {
            C1341p.m4653a(e, getClass().getSimpleName());
        } catch (StreamCorruptedException e2) {
            C1341p.m4653a(e2, getClass().getSimpleName());
        } catch (IOException e3) {
            C1341p.m4653a(e3, getClass().getSimpleName());
        } catch (ClassNotFoundException e4) {
            C1341p.m4653a(e4, getClass().getSimpleName());
        }
        if (this.f2579a == null) {
            this.f2579a = new C0761d(1);
            this.f2580b = false;
        }
        return this.f2579a;
    }

    /* renamed from: f */
    public C0761d m3190f() {
        this.f2579a = null;
        this.f2579a = new C0761d();
        return this.f2579a;
    }

    /* renamed from: g */
    public void m3191g() {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(this.f2581c.openFileOutput("emoticonUsage", 0));
            try {
                objectOutputStream.writeObject(this.f2579a);
            } finally {
                objectOutputStream.close();
            }
        } catch (FileNotFoundException e) {
            C1341p.m4653a(e, getClass().getSimpleName());
        } catch (IOException e2) {
            C1341p.m4653a(e2, getClass().getSimpleName());
        }
    }
}
