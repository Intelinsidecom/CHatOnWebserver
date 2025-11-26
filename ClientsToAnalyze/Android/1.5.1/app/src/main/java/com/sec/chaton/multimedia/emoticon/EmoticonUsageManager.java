package com.sec.chaton.multimedia.emoticon;

import android.content.Context;
import com.sec.chaton.util.ChatONLogWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes.dex */
public class EmoticonUsageManager {

    /* renamed from: a */
    EmoticonUsage f2130a;

    /* renamed from: b */
    Boolean f2131b = false;

    /* renamed from: c */
    private Context f2132c;

    public EmoticonUsageManager(Context context, int i) {
        this.f2132c = context;
        if (i == 1) {
            this.f2130a = m2520e();
        } else if (i == 2) {
            this.f2130a = m2521f();
        }
    }

    /* renamed from: a */
    public ArrayList m2515a() {
        return this.f2130a.f2125a;
    }

    /* renamed from: a */
    public void m2516a(String str, int i, int i2) {
        this.f2130a.m2512a(str, i, i2);
    }

    /* renamed from: b */
    public boolean m2517b() {
        return this.f2131b.booleanValue();
    }

    /* renamed from: c */
    public int m2518c() {
        return this.f2130a.f2125a.size();
    }

    /* renamed from: d */
    public EmoticonUsage m2519d() {
        return this.f2130a;
    }

    /* renamed from: e */
    public EmoticonUsage m2520e() throws IOException {
        this.f2130a = null;
        try {
            if (new File(this.f2132c.getFilesDir(), "emoticonUsage").exists()) {
                ObjectInputStream objectInputStream = new ObjectInputStream(this.f2132c.openFileInput("emoticonUsage"));
                try {
                    this.f2130a = (EmoticonUsage) objectInputStream.readObject();
                    if (this.f2130a != null) {
                        this.f2130a.m2513b();
                        Collections.sort(this.f2130a.f2125a);
                    }
                } finally {
                    objectInputStream.close();
                    this.f2131b = Boolean.valueOf(true);
                }
            }
        } catch (FileNotFoundException e) {
            ChatONLogWriter.m3501a(e, getClass().getSimpleName());
        } catch (StreamCorruptedException e2) {
            ChatONLogWriter.m3501a(e2, getClass().getSimpleName());
        } catch (IOException e3) {
            ChatONLogWriter.m3501a(e3, getClass().getSimpleName());
        } catch (ClassNotFoundException e4) {
            ChatONLogWriter.m3501a(e4, getClass().getSimpleName());
        }
        if (this.f2130a == null) {
            this.f2130a = new EmoticonUsage(1);
            this.f2131b = false;
        }
        return this.f2130a;
    }

    /* renamed from: f */
    public EmoticonUsage m2521f() {
        this.f2130a = null;
        this.f2130a = new EmoticonUsage();
        return this.f2130a;
    }

    /* renamed from: g */
    public void m2522g() throws IOException {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(this.f2132c.openFileOutput("emoticonUsage", 0));
            try {
                objectOutputStream.writeObject(this.f2130a);
            } finally {
                objectOutputStream.close();
            }
        } catch (FileNotFoundException e) {
            ChatONLogWriter.m3501a(e, getClass().getSimpleName());
        } catch (IOException e2) {
            ChatONLogWriter.m3501a(e2, getClass().getSimpleName());
        }
    }
}
