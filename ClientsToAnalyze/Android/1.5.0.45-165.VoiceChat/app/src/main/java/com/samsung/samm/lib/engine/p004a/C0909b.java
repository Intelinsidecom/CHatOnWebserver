package com.samsung.samm.lib.engine.p004a;

import android.content.Context;
import android.media.SoundPool;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.samsung.samm.lib.engine.a.b */
/* loaded from: classes.dex */
public class C0909b {

    /* renamed from: c */
    private SoundPool f647c;

    /* renamed from: h */
    private Context f652h;

    /* renamed from: d */
    private int f648d = 0;

    /* renamed from: e */
    private int f649e = 0;

    /* renamed from: f */
    private boolean f650f = false;

    /* renamed from: g */
    private boolean f651g = false;

    /* renamed from: a */
    String f645a = null;

    /* renamed from: b */
    String f646b = null;

    public C0909b() {
        this.f647c = null;
        this.f647c = new SoundPool(1, 3, 0);
    }

    /* renamed from: a */
    public void m649a() {
        this.f647c.release();
        this.f647c = null;
    }

    /* renamed from: a */
    public boolean m650a(Context context, String str, int i) throws IOException {
        this.f652h = context;
        this.f645a = this.f652h.getFilesDir().getParent();
        if (this.f645a == null) {
            return false;
        }
        this.f646b = "soundeffect_" + i + ".ogg";
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(str);
        if (resourceAsStream == null) {
            return false;
        }
        if (!m648a(resourceAsStream)) {
            try {
                resourceAsStream.close();
                return false;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        this.f648d = this.f647c.load(String.valueOf(this.f645a) + "/files/" + this.f646b, 1);
        try {
            resourceAsStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return true;
    }

    /* renamed from: a */
    public boolean m651a(String str) {
        int iLoad = this.f647c.load(str, 1);
        if (iLoad < 0) {
            return false;
        }
        this.f648d = iLoad;
        return true;
    }

    /* renamed from: a */
    public boolean m652a(boolean z, float f, float f2) {
        if (z) {
            this.f649e = this.f647c.play(this.f648d, f, f, 1, -1, f2);
            this.f651g = false;
            this.f650f = true;
        } else {
            this.f649e = this.f647c.play(this.f648d, f, f, 1, 0, f2);
            this.f651g = false;
            this.f650f = false;
        }
        return true;
    }

    /* renamed from: b */
    public void m653b() {
        if (this.f650f) {
            this.f647c.stop(this.f649e);
        }
        this.f651g = false;
        this.f650f = false;
    }

    /* renamed from: c */
    public void m654c() {
        if (this.f650f && !this.f651g) {
            this.f647c.pause(this.f649e);
            this.f651g = true;
            this.f650f = false;
        }
    }

    /* renamed from: d */
    public void m655d() {
        if (!this.f650f && this.f651g) {
            this.f647c.resume(this.f649e);
            this.f650f = true;
            this.f651g = false;
        }
    }

    /* renamed from: a */
    private boolean m648a(InputStream inputStream) throws IOException {
        FileOutputStream fileOutputStreamOpenFileOutput = null;
        try {
            fileOutputStreamOpenFileOutput = this.f652h.openFileOutput(this.f646b, 1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStreamOpenFileOutput);
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i = bufferedInputStream.read(bArr, 0, 1024);
                if (i != -1) {
                    bufferedOutputStream.write(bArr, 0, i);
                } else {
                    bufferedOutputStream.close();
                    bufferedInputStream.close();
                    return true;
                }
            }
        } catch (FileNotFoundException e2) {
            Log.e("SAMMLibraryCore", e2.getMessage());
            return false;
        } catch (IOException e3) {
            Log.e("SAMMLibraryCore", e3.getMessage());
            return false;
        }
    }
}
