package com.sec.vip.amschaton;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.sec.chaton.util.C1341p;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: AMSFileManager.java */
/* renamed from: com.sec.vip.amschaton.aa */
/* loaded from: classes.dex */
public class C1364aa {

    /* renamed from: b */
    private static final C1364aa f4782b = new C1364aa();

    /* renamed from: a */
    private String f4783a = AMSActivity.f4624f;

    /* renamed from: c */
    private ArrayList f4784c = new ArrayList();

    /* renamed from: d */
    private int f4785d = 0;

    /* renamed from: e */
    private ArrayList f4786e = new ArrayList();

    /* renamed from: f */
    private int f4787f = 0;

    private C1364aa() {
    }

    /* renamed from: a */
    public static C1364aa m4865a() {
        return f4782b;
    }

    /* renamed from: a */
    public boolean m4878a(AssetManager assetManager, String str, String str2) {
        if (assetManager == null || str == null || str2 == null) {
            return false;
        }
        if (!m4871a(assetManager, str)) {
            C1341p.m4658b("[copyAssetBasicFileToLocalFolder] false", getClass().getSimpleName());
        }
        if (!m4872a(str)) {
            C1341p.m4658b("[loadLocalBasicAMSFiles] false", getClass().getSimpleName());
        }
        return m4875b(str2);
    }

    /* renamed from: b */
    public int m4879b() {
        return this.f4785d;
    }

    /* renamed from: a */
    public String m4877a(int i) {
        if (i < 0 || i >= this.f4784c.size()) {
            return null;
        }
        return (String) this.f4784c.get(i);
    }

    /* renamed from: a */
    public Bitmap m4876a(int i, boolean z) {
        if (i < 0 || i >= m4879b()) {
            return null;
        }
        if (z) {
            return BitmapFactory.decodeFile((String) this.f4784c.get(i));
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        options.inPurgeable = true;
        return BitmapFactory.decodeFile((String) this.f4784c.get(i), options);
    }

    /* renamed from: a */
    private boolean m4872a(String str) {
        File file = new File(str);
        file.mkdir();
        String[] list = file.list();
        if (list == null) {
            return false;
        }
        if (this.f4784c == null) {
            this.f4784c = new ArrayList();
        }
        this.f4784c.clear();
        this.f4785d = list.length;
        for (int i = 0; i < this.f4785d; i++) {
            String str2 = str + list[i];
            if (new File(str2).exists()) {
                this.f4784c.add(str2);
            }
        }
        return true;
    }

    /* renamed from: a */
    private boolean m4871a(AssetManager assetManager, String str) throws Throwable {
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
                    C1341p.m4660c("[copyAssetBasicFileToLocalFolder1] " + list2[i2], getClass().getSimpleName());
                    m4873b(assetManager, "basic_ams_files/" + list2[i2], str + list2[i2]);
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
                        C1341p.m4660c("[copyAssetBasicFileToLocalFolder2] " + list2[i3], getClass().getSimpleName());
                        m4873b(assetManager, "basic_ams_files/" + list2[i3], str + list2[i3]);
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
    private void m4873b(AssetManager assetManager, String str, String str2) throws Throwable {
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
            m4868a(inputStreamOpen, fileOutputStream);
            m4867a(inputStreamOpen);
            m4869a(fileOutputStream);
        } catch (Exception e3) {
            e = e3;
            inputStream = inputStreamOpen;
            try {
                C1341p.m4651a(e.getMessage(), getClass().getSimpleName());
                m4867a(inputStream);
                m4869a(fileOutputStream);
                m4874b(fileOutputStream);
            } catch (Throwable th3) {
                th = th3;
                m4867a(inputStream);
                m4869a(fileOutputStream);
                m4874b(fileOutputStream);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            inputStream = inputStreamOpen;
            m4867a(inputStream);
            m4869a(fileOutputStream);
            m4874b(fileOutputStream);
            throw th;
        }
        m4874b(fileOutputStream);
    }

    /* renamed from: a */
    private void m4869a(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            try {
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    private void m4874b(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private void m4867a(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private void m4868a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
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
    public int m4882c() {
        return this.f4787f;
    }

    /* renamed from: b */
    public String m4881b(int i) {
        if (i < 0 || i >= this.f4786e.size()) {
            return null;
        }
        return (String) this.f4786e.get(i);
    }

    /* renamed from: b */
    public Bitmap m4880b(int i, boolean z) {
        if (i < 0 || i >= m4882c()) {
            return null;
        }
        if (z) {
            return BitmapFactory.decodeFile((String) this.f4786e.get(i));
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        options.inPurgeable = true;
        return BitmapFactory.decodeFile((String) this.f4786e.get(i), options);
    }

    /* renamed from: b */
    private boolean m4875b(String str) {
        File file = new File(str);
        file.mkdir();
        this.f4783a = str;
        String[] list = file.list();
        if (list == null) {
            return false;
        }
        m4870a(list);
        if (this.f4786e == null) {
            this.f4786e = new ArrayList();
        }
        this.f4786e.clear();
        this.f4787f = list.length;
        for (int i = 0; i < this.f4787f; i++) {
            String str2 = str + list[i];
            if (new File(str2).exists()) {
                this.f4786e.add(str2);
            }
        }
        return true;
    }

    /* renamed from: a */
    private void m4870a(String[] strArr) {
        Arrays.sort(strArr, new C1365ab(this));
    }

    /* renamed from: d */
    public boolean m4883d() {
        return this.f4786e == null;
    }
}
