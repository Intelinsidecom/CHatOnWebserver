package com.sec.vip.amschaton;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.sec.chaton.util.C1786r;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: AMSFileManager.java */
/* renamed from: com.sec.vip.amschaton.n */
/* loaded from: classes.dex */
public class C2064n {

    /* renamed from: b */
    private static final C2064n f7358b = new C2064n();

    /* renamed from: a */
    private String f7359a = AMSActivity.f6610c;

    /* renamed from: c */
    private ArrayList f7360c = new ArrayList();

    /* renamed from: d */
    private int f7361d = 0;

    /* renamed from: e */
    private ArrayList f7362e = new ArrayList();

    /* renamed from: f */
    private int f7363f = 0;

    private C2064n() {
    }

    /* renamed from: a */
    public static C2064n m7173a() {
        return f7358b;
    }

    /* renamed from: a */
    public boolean m7186a(AssetManager assetManager, String str, String str2) {
        if (assetManager == null || str == null || str2 == null) {
            return false;
        }
        if (!m7179a(assetManager, str)) {
            C1786r.m6061b("[copyAssetBasicFileToLocalFolder] false", getClass().getSimpleName());
        }
        if (!m7180a(str)) {
            C1786r.m6061b("[loadLocalBasicAMSFiles] false", getClass().getSimpleName());
        }
        return m7183b(str2);
    }

    /* renamed from: b */
    public int m7187b() {
        return this.f7361d;
    }

    /* renamed from: a */
    public String m7185a(int i) {
        if (i < 0 || i >= this.f7360c.size()) {
            return null;
        }
        return (String) this.f7360c.get(i);
    }

    /* renamed from: a */
    public Bitmap m7184a(int i, boolean z) {
        if (i < 0 || i >= m7187b()) {
            return null;
        }
        if (z) {
            return BitmapFactory.decodeFile((String) this.f7360c.get(i));
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        options.inPurgeable = true;
        return BitmapFactory.decodeFile((String) this.f7360c.get(i), options);
    }

    /* renamed from: a */
    private boolean m7180a(String str) {
        File file = new File(str);
        file.mkdir();
        String[] list = file.list();
        if (list == null) {
            return false;
        }
        if (this.f7360c == null) {
            this.f7360c = new ArrayList();
        }
        this.f7360c.clear();
        this.f7361d = list.length;
        for (int i = 0; i < this.f7361d; i++) {
            String str2 = str + list[i];
            if (new File(str2).exists()) {
                this.f7360c.add(str2);
            }
        }
        return true;
    }

    /* renamed from: a */
    private boolean m7179a(AssetManager assetManager, String str) throws Throwable {
        boolean z;
        boolean z2;
        File file = new File(str);
        file.mkdir();
        String[] list = file.list();
        if (list == null) {
            return false;
        }
        try {
            String[] list2 = assetManager.list("basic_ams_files");
            if (list2.length <= 0) {
                return false;
            }
            int i = 0;
            while (true) {
                if (i >= list.length) {
                    z = false;
                    break;
                }
                if (list[i].startsWith("1")) {
                    z = true;
                    break;
                }
                i++;
            }
            if (list2[0].startsWith("ics_sample") && z) {
                for (String str2 : list) {
                    new File(str + str2).delete();
                }
                for (int i2 = 0; i2 < list2.length; i2++) {
                    C1786r.m6063c("[copyAssetBasicFileToLocalFolder1] " + list2[i2], getClass().getSimpleName());
                    m7181b(assetManager, "basic_ams_files/" + list2[i2], str + list2[i2]);
                }
            } else {
                for (int i3 = 0; i3 < list2.length; i3++) {
                    int i4 = 0;
                    while (true) {
                        if (i4 >= list.length) {
                            z2 = false;
                            break;
                        }
                        if (list2[i3].equals(list[i4])) {
                            z2 = true;
                            break;
                        }
                        i4++;
                    }
                    if (!z2) {
                        C1786r.m6063c("[copyAssetBasicFileToLocalFolder2] " + list2[i3], getClass().getSimpleName());
                        m7181b(assetManager, "basic_ams_files/" + list2[i3], str + list2[i3]);
                    }
                }
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    private void m7181b(AssetManager assetManager, String str, String str2) throws Throwable {
        FileOutputStream fileOutputStream;
        InputStream inputStreamOpen;
        InputStream inputStream = null;
        try {
            inputStreamOpen = assetManager.open(str);
            try {
                fileOutputStream = new FileOutputStream(str2);
            } catch (Exception e) {
                e = e;
                fileOutputStream = null;
                inputStream = inputStreamOpen;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
                inputStream = inputStreamOpen;
            }
        } catch (Exception e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
        try {
            m7176a(inputStreamOpen, fileOutputStream);
            m7175a(inputStreamOpen);
            m7177a(fileOutputStream);
        } catch (Exception e3) {
            e = e3;
            inputStream = inputStreamOpen;
            try {
                C1786r.m6054a(e.getMessage(), getClass().getSimpleName());
                m7175a(inputStream);
                m7177a(fileOutputStream);
                m7182b(fileOutputStream);
            } catch (Throwable th3) {
                th = th3;
                m7175a(inputStream);
                m7177a(fileOutputStream);
                m7182b(fileOutputStream);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            inputStream = inputStreamOpen;
            m7175a(inputStream);
            m7177a(fileOutputStream);
            m7182b(fileOutputStream);
            throw th;
        }
        m7182b(fileOutputStream);
    }

    /* renamed from: a */
    private void m7177a(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            try {
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    private void m7182b(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private void m7175a(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private void m7176a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END];
        while (true) {
            int i = inputStream.read(bArr);
            if (i != -1) {
                outputStream.write(bArr, 0, i);
            } else {
                return;
            }
        }
    }

    /* renamed from: c */
    public int m7190c() {
        return this.f7363f;
    }

    /* renamed from: b */
    public String m7189b(int i) {
        if (i < 0 || i >= this.f7362e.size()) {
            return null;
        }
        return (String) this.f7362e.get(i);
    }

    /* renamed from: b */
    public Bitmap m7188b(int i, boolean z) {
        if (i < 0 || i >= m7190c()) {
            return null;
        }
        if (z) {
            return BitmapFactory.decodeFile((String) this.f7362e.get(i));
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        options.inPurgeable = true;
        return BitmapFactory.decodeFile((String) this.f7362e.get(i), options);
    }

    /* renamed from: b */
    private boolean m7183b(String str) {
        File file = new File(str);
        file.mkdir();
        this.f7359a = str;
        String[] list = file.list();
        if (list == null) {
            return false;
        }
        m7178a(list);
        if (this.f7362e == null) {
            this.f7362e = new ArrayList();
        }
        this.f7362e.clear();
        this.f7363f = list.length;
        for (int i = 0; i < this.f7363f; i++) {
            String str2 = str + list[i];
            if (new File(str2).exists()) {
                this.f7362e.add(str2);
            }
        }
        return true;
    }

    /* renamed from: a */
    private void m7178a(String[] strArr) {
        Arrays.sort(strArr, new C2065o(this));
    }

    /* renamed from: d */
    public boolean m7191d() {
        return this.f7362e == null;
    }
}
