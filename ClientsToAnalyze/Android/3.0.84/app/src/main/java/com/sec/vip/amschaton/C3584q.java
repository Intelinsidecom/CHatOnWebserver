package com.sec.vip.amschaton;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.sec.chaton.p025d.EnumC1327e;
import com.sec.chaton.settings.downloads.C2642q;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: AMSFileManager.java */
/* renamed from: com.sec.vip.amschaton.q */
/* loaded from: classes.dex */
public class C3584q {

    /* renamed from: e */
    private static final C3584q f13040e = new C3584q();

    /* renamed from: a */
    private String f13041a;

    /* renamed from: b */
    private String f13042b;

    /* renamed from: c */
    private String f13043c;

    /* renamed from: d */
    private String f13044d = "basic_ams_filename_list.txt";

    /* renamed from: f */
    private ArrayList<String> f13045f = new ArrayList<>();

    /* renamed from: g */
    private int f13046g = 0;

    /* renamed from: h */
    private ArrayList<String> f13047h = new ArrayList<>();

    /* renamed from: i */
    private int f13048i = 0;

    /* renamed from: j */
    private ArrayList<String> f13049j = new ArrayList<>();

    /* renamed from: k */
    private int f13050k = 0;

    /* renamed from: l */
    private int f13051l = 0;

    /* renamed from: m */
    private boolean f13052m = false;

    private C3584q() {
    }

    /* renamed from: a */
    public static C3584q m12778a() {
        return f13040e;
    }

    /* renamed from: b */
    public boolean m12806b() {
        if (this.f13052m) {
            if (this.f13047h == null || this.f13049j == null) {
                return false;
            }
            if (this.f13045f != null) {
                if (this.f13045f.size() > 0) {
                    String str = this.f13045f.get(0);
                    if (TextUtils.isEmpty(str)) {
                        C3250y.m11455d("AMSFileManager - path name is null", getClass().getSimpleName());
                        return false;
                    }
                    if (!new File(str).exists()) {
                        C3250y.m11455d("AMSFileManager - sample file path(" + str + ") is not exist", getClass().getSimpleName());
                        return false;
                    }
                    C3250y.m11455d("AMSFileManager - sample file path(" + str + ") is exist", getClass().getSimpleName());
                } else {
                    C3250y.m11455d("AMSFileManager - mBasicAMSFileList size is zero", getClass().getSimpleName());
                    return false;
                }
            } else {
                C3250y.m11455d("AMSFileManager - mBasicAMSFileList is null", getClass().getSimpleName());
                return false;
            }
        }
        return this.f13052m;
    }

    /* renamed from: a */
    public boolean m12795a(Context context) {
        if (context == null) {
            return false;
        }
        this.f13041a = (C3223ck.m11327a() ? CommonApplication.m11493l().getExternalFilesDir(null).getAbsolutePath() : CommonApplication.m11493l().getFilesDir().getAbsolutePath()) + "/AMS/";
        this.f13043c = this.f13041a + "amsbasicfiles/";
        this.f13042b = this.f13041a + "amsuserfiles/";
        new File(this.f13041a).mkdirs();
        new File(this.f13043c).mkdirs();
        new File(this.f13042b).mkdirs();
        if (!m12807b(context)) {
            C3250y.m11450b("[loadDownloadAMSFiles] false", getClass().getSimpleName());
        }
        if (!m12801a(context.getAssets(), this.f13043c, this.f13042b)) {
            return false;
        }
        this.f13052m = true;
        return true;
    }

    /* renamed from: a */
    public boolean m12801a(AssetManager assetManager, String str, String str2) {
        if (assetManager == null || str == null || str2 == null) {
            return false;
        }
        if (!m12783a(assetManager, this.f13041a)) {
            C3250y.m11450b("[copyAssetSampleFileListToLocalFolder] false", getClass().getSimpleName());
        }
        if (!m12787b(assetManager, str)) {
            C3250y.m11450b("[copyAssetBasicFileToLocalFolder] false", getClass().getSimpleName());
        }
        if (!m12788b(str)) {
            C3250y.m11450b("[loadLocalBasicAMSFiles] false", getClass().getSimpleName());
        }
        return m12789c(str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0071  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m12807b(android.content.Context r9) throws java.lang.Throwable {
        /*
            r8 = this;
            r7 = 0
            r6 = 0
            android.content.ContentResolver r0 = r9.getContentResolver()
            if (r0 != 0) goto La
            r0 = r6
        L9:
            return r0
        La:
            com.sec.chaton.e.aq r1 = com.sec.chaton.p027e.EnumC1399aq.AmsTemplate     // Catch: android.database.sqlite.SQLiteException -> L58 java.lang.Throwable -> L6e
            android.net.Uri r1 = com.sec.chaton.p027e.C1398ap.m6249a(r1)     // Catch: android.database.sqlite.SQLiteException -> L58 java.lang.Throwable -> L6e
            r2 = 0
            r3 = 0
            r4 = 0
            java.lang.String r5 = "install DESC"
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5)     // Catch: android.database.sqlite.SQLiteException -> L58 java.lang.Throwable -> L6e
            if (r0 != 0) goto L22
            if (r0 == 0) goto L20
            r0.close()
        L20:
            r0 = r6
            goto L9
        L22:
            java.util.ArrayList<java.lang.String> r1 = r8.f13049j     // Catch: java.lang.Throwable -> L93 android.database.sqlite.SQLiteException -> L97
            if (r1 != 0) goto L2d
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L93 android.database.sqlite.SQLiteException -> L97
            r1.<init>()     // Catch: java.lang.Throwable -> L93 android.database.sqlite.SQLiteException -> L97
            r8.f13049j = r1     // Catch: java.lang.Throwable -> L93 android.database.sqlite.SQLiteException -> L97
        L2d:
            java.util.ArrayList<java.lang.String> r1 = r8.f13049j     // Catch: java.lang.Throwable -> L93 android.database.sqlite.SQLiteException -> L97
            r1.clear()     // Catch: java.lang.Throwable -> L93 android.database.sqlite.SQLiteException -> L97
            boolean r1 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L93 android.database.sqlite.SQLiteException -> L97
        L36:
            if (r1 == 0) goto L75
            java.lang.String r1 = "item_id"
            int r1 = r0.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L93 android.database.sqlite.SQLiteException -> L97
            java.lang.String r1 = r0.getString(r1)     // Catch: java.lang.Throwable -> L93 android.database.sqlite.SQLiteException -> L97
            com.sec.chaton.d.e r2 = com.sec.chaton.p025d.EnumC1327e.Template     // Catch: java.lang.Throwable -> L93 android.database.sqlite.SQLiteException -> L97
            java.io.File r2 = com.sec.chaton.settings.downloads.C2642q.m9638b(r9, r2, r1)     // Catch: java.lang.Throwable -> L93 android.database.sqlite.SQLiteException -> L97
            boolean r2 = r2.exists()     // Catch: java.lang.Throwable -> L93 android.database.sqlite.SQLiteException -> L97
            if (r2 == 0) goto L53
            java.util.ArrayList<java.lang.String> r2 = r8.f13049j     // Catch: java.lang.Throwable -> L93 android.database.sqlite.SQLiteException -> L97
            r2.add(r1)     // Catch: java.lang.Throwable -> L93 android.database.sqlite.SQLiteException -> L97
        L53:
            boolean r1 = r0.moveToNext()     // Catch: java.lang.Throwable -> L93 android.database.sqlite.SQLiteException -> L97
            goto L36
        L58:
            r0 = move-exception
            r0 = r7
        L5a:
            java.lang.String r1 = "SQLiteException"
            java.lang.Class r2 = r8.getClass()     // Catch: java.lang.Throwable -> L93
            java.lang.String r2 = r2.getSimpleName()     // Catch: java.lang.Throwable -> L93
            com.sec.chaton.util.C3250y.m11442a(r1, r2)     // Catch: java.lang.Throwable -> L93
            if (r0 == 0) goto L6c
            r0.close()
        L6c:
            r0 = r6
            goto L9
        L6e:
            r0 = move-exception
        L6f:
            if (r7 == 0) goto L74
            r7.close()
        L74:
            throw r0
        L75:
            if (r0 == 0) goto L7a
            r0.close()
        L7a:
            java.util.ArrayList<java.lang.String> r0 = r8.f13049j
            int r0 = r0.size()
            r8.f13050k = r0
            com.sec.chaton.d.e r0 = com.sec.chaton.p025d.EnumC1327e.Template
            int r0 = com.sec.chaton.settings.downloads.C2642q.m9632a(r0)
            r8.f13051l = r0
            int r0 = r8.f13051l
            if (r0 >= 0) goto L90
            r8.f13051l = r6
        L90:
            r0 = 1
            goto L9
        L93:
            r1 = move-exception
            r7 = r0
            r0 = r1
            goto L6f
        L97:
            r1 = move-exception
            goto L5a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.amschaton.C3584q.m12807b(android.content.Context):boolean");
    }

    /* renamed from: c */
    public int m12809c() {
        return this.f13050k;
    }

    /* renamed from: a */
    public String m12794a(Context context, int i) {
        if (this.f13049j == null || i < 0 || i >= this.f13049j.size()) {
            return null;
        }
        return C2642q.m9638b(context, EnumC1327e.Template, this.f13049j.get(i)).getAbsolutePath();
    }

    /* renamed from: a */
    public Bitmap m12792a(Context context, int i, boolean z) {
        if (this.f13049j == null || i < 0 || i >= this.f13049j.size()) {
            return null;
        }
        String strM12794a = m12794a(context, i);
        if (z) {
            return BitmapFactory.decodeFile(strM12794a);
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        options.inPurgeable = true;
        return BitmapFactory.decodeFile(strM12794a, options);
    }

    /* renamed from: a */
    public boolean m12799a(Context context, String[] strArr) {
        return m12800a(context, strArr, true);
    }

    /* renamed from: a */
    public boolean m12800a(Context context, String[] strArr, boolean z) {
        if (strArr == null) {
            return false;
        }
        boolean zM12796a = false;
        for (int i = 0; i < strArr.length && (zM12796a = m12796a(context, strArr[i])); i++) {
        }
        return zM12796a;
    }

    /* renamed from: a */
    public boolean m12796a(Context context, String str) {
        return m12798a(context, str, true);
    }

    /* renamed from: a */
    public boolean m12798a(Context context, String str, boolean z) {
        if (this.f13049j == null || str == null) {
            return false;
        }
        int i = 0;
        while (true) {
            if (i >= this.f13049j.size()) {
                i = 0;
                break;
            }
            if (str.equals(m12794a(context, i))) {
                break;
            }
            i++;
        }
        if (i >= 0 && i < this.f13049j.size()) {
            String str2 = this.f13049j.get(i);
            if (z) {
                try {
                    C2642q.m9641c(context, EnumC1327e.Template, str2);
                } catch (IOException e) {
                    return false;
                }
            }
            this.f13049j.remove(str2);
            this.f13050k = this.f13049j.size();
            return true;
        }
        this.f13049j.clear();
        this.f13050k = 0;
        return false;
    }

    /* renamed from: d */
    public int m12810d() {
        return this.f13046g;
    }

    /* renamed from: a */
    public String m12793a(int i) {
        if (i < 0 || i >= this.f13045f.size()) {
            return null;
        }
        return this.f13045f.get(i);
    }

    /* renamed from: a */
    public Bitmap m12791a(int i, boolean z) {
        if (i < 0 || i >= this.f13045f.size()) {
            return null;
        }
        if (z) {
            return BitmapFactory.decodeFile(this.f13045f.get(i));
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        options.inPurgeable = true;
        return BitmapFactory.decodeFile(this.f13045f.get(i), options);
    }

    /* renamed from: b */
    private boolean m12788b(String str) {
        File file = new File(str);
        file.mkdir();
        String[] list = file.list();
        if (list == null) {
            return false;
        }
        if (this.f13045f == null) {
            this.f13045f = new ArrayList<>();
        }
        this.f13045f.clear();
        this.f13046g = list.length;
        for (int i = 0; i < this.f13046g; i++) {
            String str2 = str + list[i];
            if (new File(str2).exists()) {
                this.f13045f.add(str2);
            }
        }
        return true;
    }

    /* renamed from: a */
    private boolean m12783a(AssetManager assetManager, String str) throws Throwable {
        boolean z;
        File file = new File(str);
        file.mkdirs();
        String[] list = file.list();
        if (list == null) {
            return false;
        }
        try {
            String[] list2 = assetManager.list("basic_ams_file_list");
            if (list2.length <= 0) {
                return false;
            }
            if (list2.length > 1) {
                return false;
            }
            int i = 0;
            while (true) {
                if (i >= list.length) {
                    z = false;
                    break;
                }
                if (list2[0].equals(list[i])) {
                    z = true;
                    break;
                }
                i++;
            }
            if (!z) {
                m12784b(assetManager, "basic_ams_file_list/" + list2[0], str + list2[0]);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    private boolean m12787b(AssetManager assetManager, String str) throws Throwable {
        boolean z;
        boolean z2;
        File file = new File(str);
        file.mkdirs();
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
                    C3250y.m11453c("[copyAssetBasicFileToLocalFolder1] " + list2[i2], getClass().getSimpleName());
                    m12784b(assetManager, "basic_ams_files/" + list2[i2], str + list2[i2]);
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
                    if (!z2 && m12790d(list2[i3])) {
                        C3250y.m11453c("[copyAssetBasicFileToLocalFolder2] " + list2[i3], getClass().getSimpleName());
                        m12784b(assetManager, "basic_ams_files/" + list2[i3], str + list2[i3]);
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
    private void m12784b(AssetManager assetManager, String str, String str2) throws Throwable {
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
            m12781a(inputStreamOpen, fileOutputStream);
            m12780a(inputStreamOpen);
            m12782a(fileOutputStream);
        } catch (Exception e3) {
            e = e3;
            inputStream = inputStreamOpen;
            try {
                C3250y.m11442a(e.getMessage(), getClass().getSimpleName());
                m12780a(inputStream);
                m12782a(fileOutputStream);
                m12785b(fileOutputStream);
            } catch (Throwable th3) {
                th = th3;
                m12780a(inputStream);
                m12782a(fileOutputStream);
                m12785b(fileOutputStream);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            inputStream = inputStreamOpen;
            m12780a(inputStream);
            m12782a(fileOutputStream);
            m12785b(fileOutputStream);
            throw th;
        }
        m12785b(fileOutputStream);
    }

    /* renamed from: a */
    private void m12782a(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            try {
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    private void m12785b(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private void m12780a(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private void m12781a(InputStream inputStream, OutputStream outputStream) throws IOException {
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

    /* renamed from: e */
    public int m12811e() {
        return this.f13048i;
    }

    /* renamed from: b */
    public String m12805b(int i) {
        if (i < 0 || i >= this.f13047h.size()) {
            return null;
        }
        return this.f13047h.get(i);
    }

    /* renamed from: b */
    public Bitmap m12804b(int i, boolean z) {
        if (i < 0 || i >= this.f13047h.size()) {
            return null;
        }
        if (z) {
            return BitmapFactory.decodeFile(this.f13047h.get(i));
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        options.inPurgeable = true;
        return BitmapFactory.decodeFile(this.f13047h.get(i), options);
    }

    /* renamed from: a */
    public boolean m12803a(String[] strArr) {
        if (strArr == null) {
            return false;
        }
        boolean zM12802a = false;
        for (int i = 0; i < strArr.length && (zM12802a = m12802a(strArr[i])); i++) {
        }
        return zM12802a;
    }

    /* renamed from: a */
    public boolean m12802a(String str) {
        if (this.f13047h == null || str == null) {
            return false;
        }
        this.f13047h.remove(str);
        this.f13048i = this.f13047h.size();
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        return true;
    }

    /* renamed from: c */
    private boolean m12789c(String str) {
        File file = new File(str);
        file.mkdir();
        this.f13042b = str;
        String[] list = file.list();
        if (list == null) {
            return false;
        }
        m12786b(list);
        if (this.f13047h == null) {
            this.f13047h = new ArrayList<>();
        }
        this.f13047h.clear();
        this.f13048i = list.length;
        for (int i = 0; i < this.f13048i; i++) {
            String str2 = str + list[i];
            if (new File(str2).exists()) {
                this.f13047h.add(str2);
            }
        }
        return true;
    }

    /* renamed from: b */
    private void m12786b(String[] strArr) {
        Arrays.sort(strArr, new C3585r(this));
    }

    /* renamed from: f */
    public boolean m12812f() {
        return this.f13047h == null;
    }

    /* renamed from: b */
    public boolean m12808b(Context context, String str) throws Throwable {
        FileOutputStream fileOutputStream;
        if (this.f13045f == null || str == null) {
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        this.f13045f.remove(str);
        this.f13046g = this.f13045f.size();
        String[] list = new File(this.f13043c).list();
        if (list == null) {
            return false;
        }
        try {
            File file2 = new File(this.f13041a, this.f13044d);
            file2.createNewFile();
            fileOutputStream = new FileOutputStream(file2);
        } catch (Exception e) {
            fileOutputStream = null;
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            for (int i = 0; i < list.length; i++) {
                outputStreamWriter.append((CharSequence) list[i]);
                if (i < list.length - 1) {
                    outputStreamWriter.append('\n');
                }
            }
            outputStreamWriter.close();
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e2) {
                }
            }
            return true;
        } catch (Exception e3) {
            if (fileOutputStream == null) {
                return false;
            }
            try {
                fileOutputStream.close();
                return false;
            } catch (IOException e4) {
                return false;
            }
        } catch (Throwable th2) {
            th = th2;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e5) {
                }
            }
            throw th;
        }
    }

    /* renamed from: d */
    private boolean m12790d(String str) throws Throwable {
        FileReader fileReader;
        File file = new File(this.f13041a, this.f13044d);
        ArrayList arrayList = new ArrayList();
        FileReader fileReader2 = null;
        try {
            fileReader = new FileReader(file);
            try {
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    arrayList.add(line);
                }
                bufferedReader.close();
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e) {
                    }
                }
                for (int i = 0; i < arrayList.size(); i++) {
                    if (str.equals(arrayList.get(i))) {
                        return true;
                    }
                }
                return false;
            } catch (IOException e2) {
                if (fileReader == null) {
                    return false;
                }
                try {
                    fileReader.close();
                    return false;
                } catch (IOException e3) {
                    return false;
                }
            } catch (Throwable th) {
                fileReader2 = fileReader;
                th = th;
                if (fileReader2 != null) {
                    try {
                        fileReader2.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            fileReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: a */
    public boolean m12797a(Context context, String str, int i) {
        if (!new File(str).exists()) {
            return false;
        }
        if (i == 1000) {
            if (this.f13049j != null) {
                this.f13049j.add(0, str);
                this.f13050k = this.f13049j.size();
            }
        } else if (i == 1001) {
            if (this.f13047h != null) {
                this.f13047h.add(0, str);
                this.f13048i = this.f13047h.size();
            }
        } else if (i == 1002 && this.f13045f != null) {
            this.f13045f.add(0, str);
            this.f13046g = this.f13045f.size();
        }
        return true;
    }
}
