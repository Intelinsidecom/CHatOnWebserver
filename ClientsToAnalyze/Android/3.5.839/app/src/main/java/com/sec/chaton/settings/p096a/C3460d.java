package com.sec.chaton.settings.p096a;

import android.content.ContentProviderOperation;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.p049b.C1057b;
import com.sec.chaton.p057e.C2255ba;
import com.sec.chaton.p057e.C2257bc;
import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.p057e.p058a.C2196j;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4821am;
import com.sec.chaton.util.C4835b;
import com.sec.chaton.util.C4881d;
import com.sec.chaton.util.C4904y;
import com.sec.common.C4996f;
import com.sec.common.CommonApplication;
import com.sec.common.util.C5034k;
import com.sec.common.util.C5035l;
import com.sec.common.util.C5048n;
import com.sec.common.util.C5052r;
import com.sec.common.util.C5055u;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* compiled from: AniconHelper.java */
/* renamed from: com.sec.chaton.settings.a.d */
/* loaded from: classes.dex */
public class C3460d {

    /* renamed from: k */
    private static boolean f12923k;

    /* renamed from: b */
    private static final String f12914b = C3460d.class.getSimpleName();

    /* renamed from: c */
    private static final Random f12915c = new Random(System.currentTimeMillis());

    /* renamed from: d */
    private static final List<InterfaceC3467k> f12916d = new ArrayList();

    /* renamed from: e */
    private static final List<InterfaceC3468l> f12917e = new ArrayList();

    /* renamed from: a */
    public static HashMap<String, Boolean> f12913a = new HashMap<>();

    /* renamed from: f */
    private static final FilenameFilter f12918f = new C3461e();

    /* renamed from: g */
    private static final FilenameFilter f12919g = new C3462f();

    /* renamed from: h */
    private static final FilenameFilter f12920h = new C3463g();

    /* renamed from: i */
    private static final FilenameFilter f12921i = new C3464h();

    /* renamed from: j */
    private static final FilenameFilter f12922j = new C3466j(Spam.ACTIVITY_CANCEL, null);

    static {
        try {
            CommonApplication.m18732r().getSystemService("vibrator").getClass().getMethod("vibrateImmVibe", byte[].class);
            f12923k = true;
        } catch (NoSuchMethodException e) {
            f12923k = false;
        }
    }

    /* renamed from: a */
    public static boolean m13769a(Context context, String str) {
        File file = new File(m13763a(context), str);
        return (!file.exists() || file.listFiles() == null || file.listFiles().length == 0) ? false : true;
    }

    /* renamed from: b */
    public static AnimationDrawable m13772b(Context context, String str) {
        return m13761a(context, str, C5034k.m19096b(), C5034k.m19098c());
    }

    /* renamed from: a */
    public static AnimationDrawable m13761a(Context context, String str, int i, int i2) {
        if (!m13769a(context, str)) {
            return null;
        }
        return C4835b.m18305a(context, new File(m13763a(context), str), f12918f, i, i2);
    }

    /* renamed from: a */
    public static AnimationDrawable m13762a(Context context, List<C4881d> list) {
        AnimationDrawable animationDrawable = new AnimationDrawable();
        for (C4881d c4881d : list) {
            animationDrawable.addFrame(c4881d.m18530b(), c4881d.m18527a());
        }
        animationDrawable.selectDrawable(0);
        animationDrawable.setOneShot(false);
        return animationDrawable;
    }

    /* renamed from: b */
    public static List<C4881d> m13774b(Context context, String str, int i, int i2) {
        if (!m13769a(context, str)) {
            return new ArrayList();
        }
        return C4835b.m18306b(context, new File(m13763a(context), str), f12918f, i, i2);
    }

    /* renamed from: c */
    public static Drawable m13779c(Context context, String str, int i, int i2) {
        File fileM13780c;
        if (m13769a(context, str) && (fileM13780c = m13780c(context, str)) != null) {
            try {
                Bitmap bitmapM19109a = C5035l.m19109a(context, fileM13780c, i, i2);
                bitmapM19109a.setDensity(160);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmapM19109a);
                bitmapDrawable.setAntiAlias(true);
                return bitmapDrawable;
            } catch (IOException e) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, f12914b);
                }
            }
        }
        return null;
    }

    /* renamed from: c */
    public static File m13780c(Context context, String str) {
        if (!m13769a(context, str)) {
            return null;
        }
        File fileM13787g = m13787g(context, str);
        if (!fileM13787g.isDirectory()) {
            return null;
        }
        File[] fileArrListFiles = fileM13787g.listFiles(f12921i);
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            fileArrListFiles = new File[1];
            try {
                fileArrListFiles[0] = m13790j(context, str);
            } catch (IOException e) {
                fileArrListFiles = null;
            }
        }
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            fileArrListFiles = fileM13787g.listFiles(f12922j);
            if (C4904y.f17872b && fileArrListFiles != null && fileArrListFiles.length != 0) {
                C4904y.m18639b(C5052r.m19199a("AniconId: ", str, ", Can't find thumbnail image using alternative image(first frame image)."), f12914b);
            }
        }
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            return null;
        }
        return fileArrListFiles[0];
    }

    /* renamed from: d */
    public static File m13783d(Context context, String str) {
        File[] fileArrListFiles;
        if (!m13769a(context, str)) {
            return null;
        }
        File fileM13787g = m13787g(context, str);
        if (!fileM13787g.isDirectory() || (fileArrListFiles = fileM13787g.listFiles(f12920h)) == null || fileArrListFiles.length == 0) {
            return null;
        }
        return fileArrListFiles[0];
    }

    /* renamed from: e */
    public static File m13785e(Context context, String str) {
        File[] fileArrListFiles;
        if (!m13769a(context, str)) {
            return null;
        }
        File fileM13787g = m13787g(context, str);
        if (!fileM13787g.isDirectory() || (fileArrListFiles = fileM13787g.listFiles(f12919g)) == null || fileArrListFiles.length == 0) {
            return null;
        }
        return fileArrListFiles[0];
    }

    /* renamed from: d */
    public static BitmapDrawable m13782d(Context context, String str, int i, int i2) {
        File file = new File(m13763a(context), C5052r.m19199a(str, ".panel"));
        if (file.exists()) {
            try {
                Bitmap bitmapM19109a = C5035l.m19109a(context, file, i, i2);
                bitmapM19109a.setDensity(160);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmapM19109a);
                bitmapDrawable.setAntiAlias(true);
                return bitmapDrawable;
            } catch (IOException e) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, f12914b);
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public static synchronized void m13766a(Context context, String str, File file, File file2) {
        Cursor cursorQuery;
        try {
            m13773b(context, str, file2);
            File fileM13763a = m13763a(context);
            if (C4904y.f17872b) {
                C4904y.m18639b("download_anicon, installPackage, unzip from : " + file.getPath(), f12914b);
                C4904y.m18639b("download_anicon, installPackage, unzip to : " + fileM13763a.getPath(), f12914b);
            }
            C5055u.m19203a(context, file, fileM13763a);
            try {
                cursorQuery = context.getContentResolver().query(C2255ba.f8038a, new String[]{"anicon_id"}, C5052r.m19199a("package_id", "=?"), new String[]{str}, null);
                if (cursorQuery != null) {
                    while (cursorQuery.moveToNext()) {
                        try {
                            try {
                                m13790j(context, cursorQuery.getString(cursorQuery.getColumnIndex("anicon_id")));
                            } catch (IOException e) {
                                if (C4904y.f17875e) {
                                    C4904y.m18635a(e, f12914b);
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            throw th;
                        }
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                try {
                    C4821am.m18189a(context, "com.sec.chaton.provider2", C2196j.m9898a(EnumC2258bd.Anicon, str, C5034k.m19090a()));
                } catch (OperationApplicationException e2) {
                    throw C1057b.m6157a(e2);
                } catch (RemoteException e3) {
                    throw C1057b.m6157a(e3);
                }
            } catch (Throwable th2) {
                th = th2;
                cursorQuery = null;
            }
        } catch (IOException e4) {
            if (C4996f.f18229a.f18174f) {
                C4996f.f18229a.mo18649a(f12914b, e4.getMessage(), e4);
            }
            throw e4;
        }
    }

    /* renamed from: a */
    public static synchronized boolean m13770a(Context context, String str, EnumC2258bd enumC2258bd) {
        Cursor cursor;
        Cursor cursorQuery;
        boolean z = true;
        synchronized (C3460d.class) {
            if (C4904y.f17872b) {
                C4904y.m18639b(C5052r.m19199a("Uninstall anicon package. ", str), f12914b);
            }
            m13789i(context, str);
            Uri uriBuild = C2257bc.m10121a(enumC2258bd).buildUpon().appendPath(str).build();
            try {
                cursorQuery = context.getContentResolver().query(uriBuild, null, null, null, null);
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
            try {
                if (!cursorQuery.moveToNext()) {
                    z = false;
                } else if (cursorQuery.getLong(cursorQuery.getColumnIndex("expiration_time")) > C5034k.m19090a()) {
                    z = false;
                }
                try {
                    try {
                        m13786f(context, str);
                        Cursor cursorQuery2 = context.getContentResolver().query(C2255ba.f8038a, new String[]{"anicon_id"}, C5052r.m19199a("package_id", "=?"), new String[]{str}, null);
                        while (cursorQuery2.moveToNext()) {
                            String string = cursorQuery2.getString(cursorQuery2.getColumnIndex("anicon_id"));
                            if (C4904y.f17872b) {
                                C4904y.m18639b(C5052r.m19199a("Delete anicon. ", string), f12914b);
                            }
                            C5048n.m19193a(m13787g(context, string));
                        }
                        try {
                            C4821am.m18189a(context, "com.sec.chaton.provider2", ContentProviderOperation.newDelete(uriBuild).build());
                            if (C4904y.f17872b) {
                                C4904y.m18639b("Anicon package is expired. Delete from database.", f12914b);
                            }
                            Iterator<InterfaceC3468l> it = f12917e.iterator();
                            while (it.hasNext()) {
                                it.next().mo11668b(str);
                            }
                            if (cursorQuery2 != null) {
                                cursorQuery2.close();
                            }
                        } catch (OperationApplicationException e) {
                            throw C1057b.m6157a(e);
                        } catch (RemoteException e2) {
                            throw C1057b.m6157a(e2);
                        }
                    } catch (IOException e3) {
                        if (C4996f.f18229a.f18174f) {
                            C4996f.f18229a.mo18649a(f12914b, e3.getMessage(), e3);
                        }
                        throw e3;
                    }
                } finally {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = cursorQuery;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
        return z;
    }

    /* renamed from: i */
    private static void m13789i(Context context, String str) throws Throwable {
        Cursor cursorQuery;
        try {
            cursorQuery = context.getContentResolver().query(C2255ba.f8038a.buildUpon().appendPath("group").appendPath(str).build(), null, null, null, null);
            try {
                cursorQuery.moveToPosition(-1);
                while (cursorQuery.moveToNext()) {
                    cursorQuery.getString(cursorQuery.getColumnIndex("anicon_id"));
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th) {
                th = th;
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    /* renamed from: a */
    public static synchronized File m13764a(Context context, String str, File file) {
        File file2;
        File fileM13787g;
        File file3 = null;
        synchronized (C3460d.class) {
            File file4 = null;
            try {
                try {
                    if (m13769a(context, str)) {
                        if (C4996f.f18229a.f18171c) {
                            C4996f.f18229a.m18892f(f12914b, C5052r.m19199a(str, " is already cached."));
                        }
                        fileM13787g = m13787g(context, str);
                        if (0 != 0 && file4.exists()) {
                            C5048n.m19193a((File) null);
                        }
                    } else {
                        File file5 = new File(file.getParentFile(), String.valueOf(f12915c.nextInt()));
                        try {
                            try {
                                C5055u.m19203a(context, file, file5);
                                fileM13787g = m13787g(context, str);
                                try {
                                    if (!file5.renameTo(fileM13787g)) {
                                        throw new IOException(C5052r.m19199a("Can't rename directory.", file5));
                                    }
                                    if (file5 != null && file5.exists()) {
                                        C5048n.m19193a(file5);
                                    }
                                } catch (IOException e) {
                                    file2 = fileM13787g;
                                    e = e;
                                    if (C4996f.f18229a.f18174f) {
                                        C4996f.f18229a.mo18649a(f12914b, e.getMessage(), e);
                                    }
                                    if (file2 == null || !file2.exists()) {
                                        throw e;
                                    }
                                    C5048n.m19193a(file2);
                                    throw e;
                                }
                            } catch (Throwable th) {
                                th = th;
                                file3 = file5;
                                if (file3 != null && file3.exists()) {
                                    C5048n.m19193a(file3);
                                }
                                throw th;
                            }
                        } catch (IOException e2) {
                            e = e2;
                            file2 = null;
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    file2 = null;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return fileM13787g;
    }

    /* renamed from: b */
    public static synchronized File m13773b(Context context, String str, File file) {
        File file2;
        IOException e;
        try {
            file2 = new File(m13763a(context), C5052r.m19199a(str, ".panel"));
        } catch (IOException e2) {
            file2 = null;
            e = e2;
        }
        try {
            boolean zRenameTo = file.renameTo(file2);
            if (C4904y.f17872b) {
                C4904y.m18639b("download_anicon, savePackagePanelImage, rename result : " + zRenameTo, f12914b);
                C4904y.m18639b("download_anicon, savePackagePanelImage, from cache : " + file.getPath(), f12914b);
                C4904y.m18639b("download_anicon, savePackagePanelImage, to storage : " + file2.toString(), f12914b);
            }
            if (!zRenameTo && !file2.exists()) {
                throw new IOException(C5052r.m19199a("Can't rename anicon panel file.", file2));
            }
        } catch (IOException e3) {
            e = e3;
            if (C4996f.f18229a.f18174f) {
                C4996f.f18229a.mo18649a(f12914b, e.getMessage(), e);
            }
            return file2;
        }
        return file2;
    }

    /* renamed from: f */
    public static synchronized void m13786f(Context context, String str) {
        boolean z = true;
        synchronized (C3460d.class) {
            File file = new File(m13763a(context), C5052r.m19199a(str, ".panel"));
            if (file.exists()) {
                file.delete();
            } else {
                z = false;
            }
            if (C4904y.f17872b) {
                C4904y.m18639b("download_anicon, removePackagePanelImage, [deleteExist: " + z + "], panelImageDir : " + file.getPath(), f12914b);
            }
        }
    }

    /* renamed from: a */
    public static File m13763a(Context context) {
        File file = new File(C5048n.m19196b(context), "anicon");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* renamed from: g */
    public static File m13787g(Context context, String str) {
        return new File(m13763a(context), str);
    }

    /* renamed from: a */
    public static boolean m13771a(String str) {
        return !TextUtils.isEmpty(str) && str.contains("file/download/anicon");
    }

    /* renamed from: b */
    public static boolean m13778b(String str) {
        String[] strArrSplit = str.split("\n");
        if (strArrSplit == null || strArrSplit.length < 3) {
            return false;
        }
        return m13771a(strArrSplit[2]);
    }

    /* renamed from: a */
    public static String m13765a(String str, String str2) {
        return C5052r.m19199a(str, "/", str2);
    }

    /* renamed from: c */
    public static String m13781c(String str) {
        int iLastIndexOf;
        if (m13771a(str) && (iLastIndexOf = str.lastIndexOf("/")) != -1) {
            return str.substring(iLastIndexOf + 1, str.length());
        }
        return null;
    }

    /* renamed from: a */
    public static int m13760a() {
        return C4809aa.m18104a().m18120a("new_anicon_count", (Integer) 0).intValue();
    }

    /* renamed from: j */
    private static File m13790j(Context context, String str) throws IOException {
        File fileM13787g = m13787g(context, str);
        File[] fileArrListFiles = fileM13787g.listFiles(f12922j);
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            throw new IOException("Can't find first frame file.");
        }
        String[] strArrSplit = C5048n.m19192a(fileArrListFiles[0].getName()).split("_");
        if (strArrSplit == null || strArrSplit.length <= 6) {
            throw new IOException("Can't shortcut index.");
        }
        File[] fileArrListFiles2 = fileM13787g.listFiles(new C3466j(strArrSplit[6], null));
        if (fileArrListFiles2 == null || fileArrListFiles2.length == 0) {
            throw new IOException("Can't find target frame file.");
        }
        File file = new File(fileM13787g, fileArrListFiles2[0].getName().replace(".png", ".th.png"));
        if (!fileArrListFiles2[0].renameTo(file)) {
            throw new IOException("Can't rename shortcut file name.");
        }
        return file;
    }

    /* renamed from: h */
    public static EnumC3465i m13788h(Context context, String str) {
        File fileM13787g = m13787g(context, str);
        if (fileM13787g == null) {
            return EnumC3465i.NORMAL;
        }
        File[] fileArrListFiles = fileM13787g.listFiles(f12922j);
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            return EnumC3465i.NORMAL;
        }
        String[] strArrSplit = C5048n.m19192a(fileArrListFiles[0].getName()).split("_");
        if (strArrSplit == null || strArrSplit.length <= 7) {
            return EnumC3465i.NORMAL;
        }
        String str2 = strArrSplit[7];
        int iM13792a = EnumC3465i.NORMAL.m13792a();
        if (str2 == null) {
            return EnumC3465i.NORMAL;
        }
        if (str2.contains("h") && m13777b()) {
            iM13792a += EnumC3465i.HAPTIC.m13792a();
        }
        if (str2.contains("s")) {
            iM13792a += EnumC3465i.SOUND.m13792a();
        }
        if (str2.contains("m")) {
            iM13792a += EnumC3465i.MOTION.m13792a();
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("AniconType : " + EnumC3465i.m13791a(iM13792a) + ", aniconId : " + str, f12914b);
        }
        return EnumC3465i.m13791a(iM13792a);
    }

    /* renamed from: b */
    public static boolean m13777b() {
        return f12923k;
    }

    /* renamed from: a */
    public static void m13767a(InterfaceC3467k interfaceC3467k) {
        if (!f12916d.contains(interfaceC3467k)) {
            f12916d.add(interfaceC3467k);
        }
    }

    /* renamed from: b */
    public static void m13775b(InterfaceC3467k interfaceC3467k) {
        f12916d.remove(interfaceC3467k);
    }

    /* renamed from: a */
    public static void m13768a(InterfaceC3468l interfaceC3468l) {
        if (!f12917e.contains(interfaceC3468l)) {
            f12917e.add(interfaceC3468l);
        }
    }

    /* renamed from: b */
    public static void m13776b(InterfaceC3468l interfaceC3468l) {
        f12917e.remove(interfaceC3468l);
    }

    /* renamed from: d */
    public static void m13784d(String str) {
        Iterator<InterfaceC3467k> it = f12916d.iterator();
        while (it.hasNext()) {
            it.next().mo11667a(str);
        }
    }
}
