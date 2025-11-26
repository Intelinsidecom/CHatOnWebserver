package com.sec.vip.amschaton;

import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import com.sec.chaton.util.ChatONLogWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes.dex */
public class AMSFileManager {

    /* renamed from: b */
    private static final AMSFileManager f3952b = new AMSFileManager();

    /* renamed from: a */
    private String f3953a = AMSActivity.f3810g;

    /* renamed from: c */
    private ArrayList f3954c = new ArrayList();

    /* renamed from: d */
    private int f3955d = 0;

    /* renamed from: e */
    private ArrayList f3956e = new ArrayList();

    /* renamed from: f */
    private int f3957f = 0;

    private AMSFileManager() {
    }

    /* renamed from: a */
    public static AMSFileManager m3931a() {
        return f3952b;
    }

    /* renamed from: a */
    private void m3933a(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private void m3934a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, i);
            }
        }
    }

    /* renamed from: a */
    private void m3935a(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            try {
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private void m3936a(String[] strArr) {
        Arrays.sort(strArr, new C0631ae(this));
    }

    /* renamed from: a */
    private boolean m3937a(AssetManager assetManager, String str) throws Throwable {
        boolean z;
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
            for (int i = 0; i < list2.length; i++) {
                int i2 = 0;
                while (true) {
                    if (i2 >= list.length) {
                        z = false;
                        break;
                    }
                    if (list2[i].equals(list[i2])) {
                        z = true;
                        break;
                    }
                    i2++;
                }
                if (!z) {
                    ChatONLogWriter.m3506b("[copyAssetBasicFileToLocalFolder] " + list2[i], getClass().getSimpleName());
                    m3938b(assetManager, "basic_ams_files/" + list2[i], str + list2[i]);
                }
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    private void m3938b(AssetManager assetManager, String str, String str2) throws Throwable {
        FileOutputStream fileOutputStream;
        InputStream inputStreamOpen;
        InputStream inputStream = null;
        try {
            inputStreamOpen = assetManager.open(str);
            try {
                fileOutputStream = new FileOutputStream(str2);
            } catch (Exception e) {
                fileOutputStream = null;
                inputStream = inputStreamOpen;
                e = e;
            } catch (Throwable th) {
                fileOutputStream = null;
                inputStream = inputStreamOpen;
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
        try {
            m3934a(inputStreamOpen, fileOutputStream);
            m3933a(inputStreamOpen);
            m3935a(fileOutputStream);
        } catch (Exception e3) {
            inputStream = inputStreamOpen;
            e = e3;
            try {
                ChatONLogWriter.m3499a(e.getMessage(), getClass().getSimpleName());
                m3933a(inputStream);
                m3935a(fileOutputStream);
                m3939b(fileOutputStream);
            } catch (Throwable th3) {
                th = th3;
                m3933a(inputStream);
                m3935a(fileOutputStream);
                m3939b(fileOutputStream);
                throw th;
            }
        } catch (Throwable th4) {
            inputStream = inputStreamOpen;
            th = th4;
            m3933a(inputStream);
            m3935a(fileOutputStream);
            m3939b(fileOutputStream);
            throw th;
        }
        m3939b(fileOutputStream);
    }

    /* renamed from: b */
    private void m3939b(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: c */
    private boolean m3940c(String str) {
        File file = new File(str);
        file.mkdir();
        String[] list = file.list();
        if (list == null) {
            return false;
        }
        if (this.f3954c == null) {
            this.f3954c = new ArrayList();
        }
        this.f3954c.clear();
        this.f3955d = list.length;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        for (int i = 0; i < this.f3955d; i++) {
            String str2 = str + list[i];
            if (new File(str2).exists()) {
                this.f3954c.add(new AMSFileInfo(str2, BitmapFactory.decodeFile(str2, options)));
            }
        }
        return true;
    }

    /* renamed from: d */
    private boolean m3941d(String str) {
        File file = new File(str);
        file.mkdir();
        this.f3953a = str;
        String[] list = file.list();
        if (list == null) {
            return false;
        }
        m3936a(list);
        if (this.f3956e == null) {
            this.f3956e = new ArrayList();
        }
        this.f3956e.clear();
        this.f3957f = list.length;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        for (int i = 0; i < this.f3957f; i++) {
            String str2 = str + list[i];
            if (new File(str2).exists()) {
                this.f3956e.add(new AMSFileInfo(str2, BitmapFactory.decodeFile(str2, options)));
            }
        }
        return true;
    }

    /* renamed from: a */
    public int m3942a(String str) {
        if (this.f3954c == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f3954c.size()) {
                return -1;
            }
            if (str.equals(((AMSFileInfo) this.f3954c.get(i2)).m3898a())) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    /* renamed from: a */
    public AMSFileInfo m3943a(int i) {
        if (i < 0 || i >= this.f3954c.size()) {
            return null;
        }
        return (AMSFileInfo) this.f3954c.get(i);
    }

    /* renamed from: a */
    public boolean m3944a(AssetManager assetManager, String str, String str2) {
        ChatONLogWriter.m3506b("basicFilePath : " + str, getClass().getSimpleName());
        ChatONLogWriter.m3506b("userFilePath  : " + str2, getClass().getSimpleName());
        if (assetManager == null || str == null || str2 == null) {
            return false;
        }
        if (!m3937a(assetManager, str)) {
            ChatONLogWriter.m3506b("[copyAssetBasicFileToLocalFolder] false", getClass().getSimpleName());
        }
        if (!m3940c(str)) {
            ChatONLogWriter.m3506b("[loadLocalBasicAMSFiles] false", getClass().getSimpleName());
        }
        return m3941d(str2);
    }

    /* renamed from: b */
    public int m3945b() {
        return this.f3955d;
    }

    /* renamed from: b */
    public int m3946b(String str) {
        if (this.f3956e == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f3956e.size()) {
                return -1;
            }
            if (str.equals(((AMSFileInfo) this.f3956e.get(i2)).m3898a())) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    /* renamed from: b */
    public boolean m3947b(int i) {
        if (this.f3954c != null && i != this.f3954c.size() - 1) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public int m3948c() {
        return this.f3957f;
    }

    /* renamed from: c */
    public boolean m3949c(int i) {
        return (this.f3954c == null || i == 0) ? false : true;
    }

    /* renamed from: d */
    public AMSFileInfo m3950d(int i) {
        if (i < 0 || i >= this.f3956e.size()) {
            return null;
        }
        return (AMSFileInfo) this.f3956e.get(i);
    }

    /* renamed from: e */
    public boolean m3951e(int i) {
        if (this.f3956e != null && i != this.f3956e.size() - 1) {
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public boolean m3952f(int i) {
        return (this.f3956e == null || i == 0) ? false : true;
    }
}
