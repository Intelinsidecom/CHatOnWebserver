package com.sec.vip.amschaton;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.emoticon.C1833h;
import com.sec.chaton.p025d.EnumC1327e;
import com.sec.chaton.settings.downloads.C2642q;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.vip.amschaton.p071a.C3395c;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/* compiled from: AMSStampManager.java */
/* renamed from: com.sec.vip.amschaton.al */
/* loaded from: classes.dex */
public class C3410al {

    /* renamed from: e */
    private static final C3410al f12480e = new C3410al();

    /* renamed from: l */
    private static int[] f12481l = {0, 3, 6, 29, 30, 31, 33, 34, 36, 40, 41, 55, 56, 57, 61, 63, 65, 75, 76, 77, 78, 81, 82, 84, 90, 96, 100, 117, 157, 160, 163, 173, 174, 189, 190, 199};

    /* renamed from: c */
    private String f12484c;

    /* renamed from: d */
    private String f12485d;

    /* renamed from: a */
    private final String f12482a = "stamp_tr_hp";

    /* renamed from: b */
    private final String f12483b = "flashcon_ani_hp";

    /* renamed from: f */
    private Context f12486f = null;

    /* renamed from: g */
    private int f12487g = 0;

    /* renamed from: h */
    private ArrayList<String> f12488h = null;

    /* renamed from: i */
    private int f12489i = 0;

    /* renamed from: j */
    private ArrayList<Bitmap> f12490j = null;

    /* renamed from: k */
    private int f12491k = 0;

    /* renamed from: m */
    private ArrayList<Integer> f12492m = null;

    /* renamed from: n */
    private int f12493n = 0;

    /* renamed from: o */
    private ArrayList<Integer> f12494o = null;

    /* renamed from: p */
    private int f12495p = 0;

    /* renamed from: q */
    private ArrayList<String> f12496q = null;

    /* renamed from: r */
    private int f12497r = 0;

    /* renamed from: s */
    private int f12498s = 0;

    private C3410al() {
    }

    /* renamed from: a */
    public static C3410al m12173a() {
        return f12480e;
    }

    /* renamed from: a */
    public void m12182a(Context context) {
        if (context != null) {
            this.f12484c = (C3223ck.m11327a() ? CommonApplication.m11493l().getExternalFilesDir(null).getAbsolutePath() : CommonApplication.m11493l().getFilesDir().getAbsolutePath()) + "/AMS/";
            this.f12485d = this.f12484c + "userstamp/";
            new File(this.f12484c).mkdirs();
            new File(this.f12485d).mkdirs();
            if (!m12189b(context)) {
                C3250y.m11450b("[loadDownloadStamp] false", getClass().getSimpleName());
            }
            m12184a(context, context.getAssets(), this.f12485d);
        }
    }

    /* renamed from: a */
    public void m12184a(Context context, AssetManager assetManager, String str) {
        this.f12486f = context;
        m12183a(context, assetManager);
        m12185a(str);
        m12188b();
    }

    /* renamed from: a */
    public void m12183a(Context context, AssetManager assetManager) {
        try {
            if (assetManager.list("stamp_tr_hp").length > 0) {
                this.f12487g = f12481l.length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m12185a(String str) {
        File file = new File(str);
        file.mkdir();
        if (!file.exists()) {
            C3250y.m11442a("[loadUserStamp] There is no directory!", getClass().getSimpleName());
            return;
        }
        String[] list = file.list();
        if (list != null) {
            m12175a(list);
            this.f12489i = list.length;
            this.f12488h = new ArrayList<>();
            this.f12488h.clear();
            if (this.f12489i > 0) {
                for (int i = 0; i < this.f12489i; i++) {
                    this.f12488h.add(str + list[i]);
                }
            }
        }
    }

    /* renamed from: b */
    public void m12188b() {
        Map<String, Integer> mapM7504a = C1833h.m7504a();
        this.f12493n = mapM7504a.size();
        this.f12492m = new ArrayList<>();
        this.f12492m.clear();
        Iterator<String> it = mapM7504a.keySet().iterator();
        while (it.hasNext()) {
            this.f12492m.add(mapM7504a.get(it.next()));
        }
        m12192c();
    }

    /* renamed from: c */
    public void m12192c() {
        boolean z;
        if (this.f12494o != null) {
            this.f12494o = null;
        }
        this.f12494o = new ArrayList<>();
        this.f12494o.clear();
        this.f12495p = 0;
        C3395c c3395c = new C3395c(this.f12486f);
        c3395c.m12102b();
        Cursor cursorM12104c = c3395c.m12104c();
        if (cursorM12104c != null) {
            for (boolean zMoveToFirst = cursorM12104c.moveToFirst(); zMoveToFirst; zMoveToFirst = cursorM12104c.moveToNext()) {
                int i = cursorM12104c.getInt(cursorM12104c.getColumnIndex("ams_index"));
                int i2 = 0;
                while (true) {
                    if (i2 < this.f12492m.size()) {
                        if (i != this.f12492m.get(i2).intValue()) {
                            i2++;
                        } else {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    this.f12494o.add(Integer.valueOf(i));
                } else {
                    c3395c.m12103b(String.valueOf(i));
                }
            }
            this.f12495p = this.f12494o.size();
            cursorM12104c.close();
        }
        c3395c.mo12098a();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0071  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m12189b(android.content.Context r9) throws java.lang.Throwable {
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
            com.sec.chaton.e.aq r1 = com.sec.chaton.p027e.EnumC1399aq.AmsStamp     // Catch: android.database.sqlite.SQLiteException -> L58 java.lang.Throwable -> L6e
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
            java.util.ArrayList<java.lang.String> r1 = r8.f12496q     // Catch: java.lang.Throwable -> L93 android.database.sqlite.SQLiteException -> L97
            if (r1 != 0) goto L2d
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L93 android.database.sqlite.SQLiteException -> L97
            r1.<init>()     // Catch: java.lang.Throwable -> L93 android.database.sqlite.SQLiteException -> L97
            r8.f12496q = r1     // Catch: java.lang.Throwable -> L93 android.database.sqlite.SQLiteException -> L97
        L2d:
            java.util.ArrayList<java.lang.String> r1 = r8.f12496q     // Catch: java.lang.Throwable -> L93 android.database.sqlite.SQLiteException -> L97
            r1.clear()     // Catch: java.lang.Throwable -> L93 android.database.sqlite.SQLiteException -> L97
            boolean r1 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L93 android.database.sqlite.SQLiteException -> L97
        L36:
            if (r1 == 0) goto L75
            java.lang.String r1 = "item_id"
            int r1 = r0.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L93 android.database.sqlite.SQLiteException -> L97
            java.lang.String r1 = r0.getString(r1)     // Catch: java.lang.Throwable -> L93 android.database.sqlite.SQLiteException -> L97
            com.sec.chaton.d.e r2 = com.sec.chaton.p025d.EnumC1327e.Stamp     // Catch: java.lang.Throwable -> L93 android.database.sqlite.SQLiteException -> L97
            java.io.File r2 = com.sec.chaton.settings.downloads.C2642q.m9638b(r9, r2, r1)     // Catch: java.lang.Throwable -> L93 android.database.sqlite.SQLiteException -> L97
            boolean r2 = r2.exists()     // Catch: java.lang.Throwable -> L93 android.database.sqlite.SQLiteException -> L97
            if (r2 == 0) goto L53
            java.util.ArrayList<java.lang.String> r2 = r8.f12496q     // Catch: java.lang.Throwable -> L93 android.database.sqlite.SQLiteException -> L97
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
            java.util.ArrayList<java.lang.String> r0 = r8.f12496q
            int r0 = r0.size()
            r8.f12497r = r0
            com.sec.chaton.d.e r0 = com.sec.chaton.p025d.EnumC1327e.Stamp
            int r0 = com.sec.chaton.settings.downloads.C2642q.m9632a(r0)
            r8.f12498s = r0
            int r0 = r8.f12498s
            if (r0 >= 0) goto L90
            r8.f12498s = r6
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
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.amschaton.C3410al.m12189b(android.content.Context):boolean");
    }

    /* renamed from: d */
    public int m12193d() {
        return this.f12497r;
    }

    /* renamed from: a */
    public String m12179a(int i) {
        if (this.f12496q != null && i >= 0 && i < this.f12496q.size()) {
            return this.f12496q.get(i);
        }
        return null;
    }

    /* renamed from: a */
    public String m12181a(Context context, String str) {
        return C2642q.m9638b(context, EnumC1327e.Stamp, str).getAbsolutePath();
    }

    /* renamed from: a */
    public String m12180a(Context context, int i) {
        if (this.f12496q == null || i < 0 || i >= this.f12496q.size()) {
            return null;
        }
        return C2642q.m9638b(context, EnumC1327e.Stamp, this.f12496q.get(i)).getAbsolutePath();
    }

    /* renamed from: a */
    public Bitmap m12178a(String str, boolean z) {
        String absolutePath = C2642q.m9638b(this.f12486f, EnumC1327e.Stamp, str).getAbsolutePath();
        if (z) {
            return BitmapFactory.decodeFile(absolutePath);
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        options.inPurgeable = true;
        return BitmapFactory.decodeFile(absolutePath, options);
    }

    /* renamed from: a */
    public Bitmap m12177a(int i, boolean z) {
        if (this.f12496q == null || i < 0 || i >= this.f12496q.size()) {
            return null;
        }
        String strM12180a = m12180a(this.f12486f, i);
        if (z) {
            return BitmapFactory.decodeFile(strM12180a);
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        options.inPurgeable = true;
        return BitmapFactory.decodeFile(strM12180a, options);
    }

    /* renamed from: b */
    public int m12186b(int i) {
        return (this.f12492m != null && i >= 0 && i < this.f12492m.size()) ? this.f12492m.get(i).intValue() : R.drawable.emoticon_01_01;
    }

    /* renamed from: c */
    public int m12190c(int i) {
        int i2;
        if (this.f12492m == null) {
            return -1;
        }
        int i3 = 0;
        while (true) {
            i2 = i3;
            if (i2 >= this.f12492m.size()) {
                i2 = -1;
                break;
            }
            if (this.f12492m.get(i2).intValue() == i) {
                break;
            }
            i3 = i2 + 1;
        }
        return i2;
    }

    /* renamed from: b */
    public Bitmap m12187b(int i, boolean z) {
        if (i < 0 || i >= m12196e()) {
            return null;
        }
        if (z) {
            Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(this.f12486f.getResources(), this.f12492m.get(i).intValue());
            C3250y.m11453c("srcBmp: " + bitmapDecodeResource.getWidth() + ", " + bitmapDecodeResource.getHeight(), getClass().getSimpleName());
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeResource, 72, 72, true);
            C3250y.m11453c("retBmp: " + bitmapCreateScaledBitmap.getWidth() + ", " + bitmapCreateScaledBitmap.getHeight(), getClass().getSimpleName());
            if (bitmapDecodeResource != null && !bitmapDecodeResource.isRecycled() && !bitmapCreateScaledBitmap.equals(bitmapDecodeResource)) {
                bitmapDecodeResource.recycle();
                return bitmapCreateScaledBitmap;
            }
            return bitmapCreateScaledBitmap;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 1;
        options.inPurgeable = true;
        return BitmapFactory.decodeResource(this.f12486f.getResources(), this.f12492m.get(i).intValue(), options);
    }

    /* renamed from: e */
    public int m12196e() {
        return this.f12493n;
    }

    /* renamed from: d */
    public int m12194d(int i) {
        int i2;
        if (this.f12494o == null) {
            return -1;
        }
        int i3 = 0;
        while (true) {
            i2 = i3;
            if (i2 >= this.f12494o.size()) {
                i2 = -1;
                break;
            }
            if (this.f12494o.get(i2).intValue() == i) {
                break;
            }
            i3 = i2 + 1;
        }
        return i2;
    }

    /* renamed from: e */
    public int m12197e(int i) {
        if (this.f12494o != null && i >= 0 && i < this.f12494o.size()) {
            return this.f12494o.get(i).intValue();
        }
        return -1;
    }

    /* renamed from: c */
    public Bitmap m12191c(int i, boolean z) {
        if (i < 0 || i >= m12199f()) {
            return null;
        }
        if (z) {
            Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(this.f12486f.getResources(), this.f12494o.get(i).intValue());
            if (bitmapDecodeResource == null) {
                return null;
            }
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeResource, 72, 72, true);
            if (!bitmapDecodeResource.isRecycled() && !bitmapCreateScaledBitmap.equals(bitmapDecodeResource)) {
                bitmapDecodeResource.recycle();
                return bitmapCreateScaledBitmap;
            }
            return bitmapCreateScaledBitmap;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 1;
        options.inPurgeable = true;
        return BitmapFactory.decodeResource(this.f12486f.getResources(), this.f12494o.get(i).intValue(), options);
    }

    /* renamed from: f */
    public int m12199f() {
        return this.f12495p;
    }

    /* renamed from: d */
    public Bitmap m12195d(int i, boolean z) {
        Bitmap bitmapDecodeStream = null;
        if (!m12204h(i)) {
            if (z) {
                return BitmapFactory.decodeResource(this.f12486f.getResources(), R.drawable.more_option_support_white);
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 2;
            options.inPurgeable = true;
            return BitmapFactory.decodeResource(this.f12486f.getResources(), R.drawable.more_option_support_white, options);
        }
        try {
            if (z) {
                bitmapDecodeStream = BitmapFactory.decodeStream(this.f12486f.getAssets().open(String.format(Locale.US, "stamp_tr_hp/stamp_%03d.png", Integer.valueOf(i + 1))));
            } else {
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inSampleSize = 2;
                options2.inPurgeable = true;
                bitmapDecodeStream = BitmapFactory.decodeStream(this.f12486f.getAssets().open(String.format(Locale.US, "stamp_tr_hp/stamp_%03d.png", Integer.valueOf(i + 1))), null, options2);
            }
            return bitmapDecodeStream;
        } catch (IOException e) {
            e.printStackTrace();
            return bitmapDecodeStream;
        }
    }

    /* renamed from: g */
    public int m12201g() {
        return this.f12487g;
    }

    /* renamed from: e */
    public Bitmap m12198e(int i, boolean z) {
        if (i < 0 || i >= m12203h()) {
            return null;
        }
        if (z) {
            return BitmapFactory.decodeFile(this.f12488h.get(i));
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        options.inPurgeable = true;
        return BitmapFactory.decodeFile(this.f12488h.get(i), options);
    }

    /* renamed from: h */
    public int m12203h() {
        return this.f12489i;
    }

    /* renamed from: f */
    public String m12200f(int i) {
        if (this.f12488h != null && i >= 0 && i < this.f12488h.size()) {
            return this.f12488h.get(i);
        }
        return null;
    }

    /* renamed from: a */
    public Bitmap m12176a(int i, int i2) {
        if (this.f12490j == null) {
            return null;
        }
        return this.f12490j.get((i * 8) + i2);
    }

    /* renamed from: i */
    public int m12205i() {
        return this.f12491k;
    }

    /* renamed from: a */
    private void m12175a(String[] strArr) {
        Arrays.sort(strArr, new C3411am(this));
    }

    /* renamed from: j */
    public boolean m12207j() {
        return this.f12488h == null;
    }

    /* renamed from: g */
    public int m12202g(int i) {
        if (i < 0 || i >= f12481l.length) {
            return -1;
        }
        return f12481l[i];
    }

    /* renamed from: h */
    public boolean m12204h(int i) {
        for (int i2 : f12481l) {
            if (i == i2) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: i */
    public int m12206i(int i) {
        int i2 = 0;
        int[] iArr = f12481l;
        int length = iArr.length;
        int i3 = 0;
        while (i3 < length) {
            if (i != iArr[i3]) {
                i3++;
                i2++;
            } else {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: k */
    public int m12208k() {
        return 211;
    }
}
