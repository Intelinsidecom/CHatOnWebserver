package com.sec.vip.amschaton;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.sec.chaton.p025d.EnumC1327e;
import com.sec.chaton.p027e.C1398ap;
import com.sec.chaton.p027e.EnumC1399aq;
import com.sec.chaton.settings.downloads.C2591cd;
import com.sec.chaton.settings.downloads.C2642q;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.util.C3350l;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/* compiled from: AMSBackgroundManager.java */
/* renamed from: com.sec.vip.amschaton.b */
/* loaded from: classes.dex */
public class C3425b {

    /* renamed from: c */
    private static final C3425b f12548c = new C3425b();

    /* renamed from: a */
    private String f12549a;

    /* renamed from: b */
    private String f12550b = "bg_org_filename_list.txt";

    /* renamed from: d */
    private ArrayList<String> f12551d = new ArrayList<>();

    /* renamed from: e */
    private int f12552e = 0;

    /* renamed from: f */
    private ArrayList<String> f12553f = new ArrayList<>();

    /* renamed from: g */
    private int f12554g = 0;

    /* renamed from: h */
    private int f12555h = 0;

    /* renamed from: i */
    private ArrayList<C3448c> f12556i = new ArrayList<>();

    /* renamed from: j */
    private int f12557j = 0;

    private C3425b() {
    }

    /* renamed from: a */
    public static C3425b m12268a() {
        return f12548c;
    }

    /* renamed from: a */
    public boolean m12281a(Context context) {
        if (context == null) {
            return false;
        }
        this.f12549a = (C3223ck.m11327a() ? CommonApplication.m11493l().getExternalFilesDir(null).getAbsolutePath() : CommonApplication.m11493l().getFilesDir().getAbsolutePath()) + "/AMS/";
        new File(this.f12549a).mkdirs();
        if (!m12288c(context)) {
            C3250y.m11450b("[loadDownloadBackground] false", getClass().getSimpleName());
        }
        if (!m12284b(context)) {
            C3250y.m11450b("[loadChatSkinBackgrond] false", getClass().getSimpleName());
        }
        return m12282a(context.getAssets());
    }

    /* renamed from: a */
    public boolean m12282a(AssetManager assetManager) {
        if (assetManager == null) {
            return false;
        }
        if (!m12273a(assetManager, this.f12549a)) {
            C3250y.m11450b("[copyAssetBgListToLocalFolder] false", getClass().getSimpleName());
        }
        if (!m12286b(assetManager)) {
            C3250y.m11450b("[loadBackgroundInList] false", getClass().getSimpleName());
            return false;
        }
        return true;
    }

    /* renamed from: b */
    public boolean m12286b(AssetManager assetManager) throws IOException {
        try {
            String[] list = assetManager.list("bg_org_hp");
            if (list.length <= 0) {
                return false;
            }
            this.f12551d.clear();
            for (String str : list) {
                this.f12551d.add(str);
            }
            this.f12552e = this.f12551d.size();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    public boolean m12284b(Context context) {
        boolean z;
        Cursor cursor = null;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            if (contentResolver == null) {
                return false;
            }
            try {
                Cursor cursorQuery = contentResolver.query(C1398ap.m6249a(EnumC1399aq.Skin).buildUpon().appendPath("install").build(), null, null, null, "install DESC");
                if (cursorQuery != null) {
                    cursorQuery.close();
                    cursorQuery = null;
                }
                if (cursorQuery == null) {
                    z = false;
                } else {
                    if (this.f12556i == null) {
                        this.f12556i = new ArrayList<>();
                    }
                    this.f12556i.clear();
                    boolean zMoveToFirst = cursorQuery.moveToFirst();
                    while (zMoveToFirst) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("item_id"));
                        File fileM9581e = C2591cd.m9581e(context, string);
                        if (fileM9581e == null) {
                            zMoveToFirst = cursorQuery.moveToNext();
                        } else {
                            if (fileM9581e.exists()) {
                                if (C3350l.m11802a(fileM9581e.getName()).split("_")[3].equals("ma")) {
                                    this.f12556i.add(new C3448c(this, string, fileM9581e.getAbsolutePath()));
                                } else {
                                    zMoveToFirst = cursorQuery.moveToNext();
                                }
                            }
                            zMoveToFirst = cursorQuery.moveToNext();
                        }
                    }
                    cursorQuery.close();
                    this.f12557j = this.f12556i.size();
                    z = true;
                }
            } catch (SQLiteException e) {
                C3250y.m11442a("SQLiteException", getClass().getSimpleName());
                if (0 != 0) {
                    cursor.close();
                }
                z = false;
            }
            return z;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0071  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m12288c(android.content.Context r9) throws java.lang.Throwable {
        /*
            r8 = this;
            r6 = 0
            r7 = 0
            android.content.ContentResolver r0 = r9.getContentResolver()
            if (r0 != 0) goto La
            r0 = r6
        L9:
            return r0
        La:
            com.sec.chaton.e.aq r1 = com.sec.chaton.p027e.EnumC1399aq.AmsBackground     // Catch: android.database.sqlite.SQLiteException -> L58 java.lang.Throwable -> L6e
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
            java.util.ArrayList<java.lang.String> r1 = r8.f12553f     // Catch: java.lang.Throwable -> L93 android.database.sqlite.SQLiteException -> L97
            if (r1 != 0) goto L2d
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L93 android.database.sqlite.SQLiteException -> L97
            r1.<init>()     // Catch: java.lang.Throwable -> L93 android.database.sqlite.SQLiteException -> L97
            r8.f12553f = r1     // Catch: java.lang.Throwable -> L93 android.database.sqlite.SQLiteException -> L97
        L2d:
            java.util.ArrayList<java.lang.String> r1 = r8.f12553f     // Catch: java.lang.Throwable -> L93 android.database.sqlite.SQLiteException -> L97
            r1.clear()     // Catch: java.lang.Throwable -> L93 android.database.sqlite.SQLiteException -> L97
            boolean r1 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L93 android.database.sqlite.SQLiteException -> L97
        L36:
            if (r1 == 0) goto L75
            java.lang.String r1 = "item_id"
            int r1 = r0.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L93 android.database.sqlite.SQLiteException -> L97
            java.lang.String r1 = r0.getString(r1)     // Catch: java.lang.Throwable -> L93 android.database.sqlite.SQLiteException -> L97
            com.sec.chaton.d.e r2 = com.sec.chaton.p025d.EnumC1327e.Background     // Catch: java.lang.Throwable -> L93 android.database.sqlite.SQLiteException -> L97
            java.io.File r2 = com.sec.chaton.settings.downloads.C2642q.m9638b(r9, r2, r1)     // Catch: java.lang.Throwable -> L93 android.database.sqlite.SQLiteException -> L97
            boolean r2 = r2.exists()     // Catch: java.lang.Throwable -> L93 android.database.sqlite.SQLiteException -> L97
            if (r2 == 0) goto L53
            java.util.ArrayList<java.lang.String> r2 = r8.f12553f     // Catch: java.lang.Throwable -> L93 android.database.sqlite.SQLiteException -> L97
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
            if (r7 == 0) goto L6c
            r7.close()
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
            java.util.ArrayList<java.lang.String> r0 = r8.f12553f
            int r0 = r0.size()
            r8.f12554g = r0
            com.sec.chaton.d.e r0 = com.sec.chaton.p025d.EnumC1327e.Background
            int r0 = com.sec.chaton.settings.downloads.C2642q.m9632a(r0)
            r8.f12555h = r0
            int r0 = r8.f12555h
            if (r0 >= 0) goto L90
            r8.f12555h = r6
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
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.amschaton.C3425b.m12288c(android.content.Context):boolean");
    }

    /* renamed from: b */
    public int m12283b() {
        return this.f12554g;
    }

    /* renamed from: a */
    public String m12278a(int i) {
        if (this.f12553f != null && i >= 0 && i < this.f12553f.size()) {
            return this.f12553f.get(i);
        }
        return null;
    }

    /* renamed from: a */
    public String m12280a(Context context, String str) {
        return C2642q.m9638b(context, EnumC1327e.Background, str).getAbsolutePath();
    }

    /* renamed from: a */
    public String m12279a(Context context, int i) {
        if (this.f12553f == null || i < 0 || i >= this.f12553f.size()) {
            return null;
        }
        return C2642q.m9638b(context, EnumC1327e.Background, this.f12553f.get(i)).getAbsolutePath();
    }

    /* renamed from: a */
    public Bitmap m12276a(Context context, String str, boolean z) {
        String absolutePath = C2642q.m9638b(context, EnumC1327e.Background, str).getAbsolutePath();
        if (z) {
            return BitmapFactory.decodeFile(absolutePath);
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        options.inPurgeable = true;
        return BitmapFactory.decodeFile(absolutePath, options);
    }

    /* renamed from: a */
    public Bitmap m12275a(Context context, int i, boolean z) {
        if (this.f12553f == null || i < 0 || i >= this.f12553f.size()) {
            return null;
        }
        String strM12279a = m12279a(context, i);
        if (z) {
            return BitmapFactory.decodeFile(strM12279a);
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        options.inPurgeable = true;
        return BitmapFactory.decodeFile(strM12279a, options);
    }

    /* renamed from: b */
    public boolean m12285b(Context context, int i) {
        if (i < 0 || i >= this.f12553f.size()) {
            return false;
        }
        try {
            C2642q.m9641c(context, EnumC1327e.Background, this.f12553f.get(i));
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /* renamed from: c */
    public int m12287c() {
        return this.f12552e;
    }

    /* renamed from: a */
    public Bitmap m12277a(AssetManager assetManager, int i, boolean z) {
        Bitmap bitmapDecodeStream;
        if (i < 0 || i >= this.f12551d.size()) {
            return null;
        }
        try {
            if (z) {
                bitmapDecodeStream = BitmapFactory.decodeStream(assetManager.open("bg_org_hp/" + this.f12551d.get(i)));
            } else {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 2;
                options.inPurgeable = true;
                bitmapDecodeStream = BitmapFactory.decodeStream(assetManager.open("bg_org_hp/" + this.f12551d.get(i)), null, options);
            }
            return bitmapDecodeStream;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private boolean m12273a(AssetManager assetManager, String str) throws Throwable {
        boolean z;
        File file = new File(str);
        file.mkdirs();
        String[] list = file.list();
        if (list == null) {
            return false;
        }
        try {
            String[] list2 = assetManager.list("bg_org_hp_list");
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
                m12269a(assetManager, "bg_org_hp_list/" + list2[0], str + list2[0]);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    private void m12269a(AssetManager assetManager, String str, String str2) throws Throwable {
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
            m12271a(inputStreamOpen, fileOutputStream);
            m12270a(inputStreamOpen);
            m12272a(fileOutputStream);
        } catch (Exception e3) {
            e = e3;
            inputStream = inputStreamOpen;
            try {
                C3250y.m11442a(e.getMessage(), getClass().getSimpleName());
                m12270a(inputStream);
                m12272a(fileOutputStream);
                m12274b(fileOutputStream);
            } catch (Throwable th3) {
                th = th3;
                m12270a(inputStream);
                m12272a(fileOutputStream);
                m12274b(fileOutputStream);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            inputStream = inputStreamOpen;
            m12270a(inputStream);
            m12272a(fileOutputStream);
            m12274b(fileOutputStream);
            throw th;
        }
        m12274b(fileOutputStream);
    }

    /* renamed from: a */
    private void m12272a(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            try {
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    private void m12274b(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private void m12270a(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private void m12271a(InputStream inputStream, OutputStream outputStream) throws IOException {
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
}
