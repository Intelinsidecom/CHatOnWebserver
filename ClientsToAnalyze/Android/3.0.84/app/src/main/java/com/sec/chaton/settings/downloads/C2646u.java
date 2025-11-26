package com.sec.chaton.settings.downloads;

import android.content.ContentProviderOperation;
import android.content.Context;
import android.content.OperationApplicationException;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.p027e.C1396an;
import com.sec.chaton.p027e.C1398ap;
import com.sec.chaton.p027e.EnumC1399aq;
import com.sec.chaton.p027e.p028a.C1366j;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3170al;
import com.sec.chaton.util.C3185b;
import com.sec.chaton.util.C3229d;
import com.sec.chaton.util.C3250y;
import com.sec.common.C3330f;
import com.sec.common.CommonApplication;
import com.sec.common.util.C3347i;
import com.sec.common.util.C3348j;
import com.sec.common.util.C3350l;
import com.sec.common.util.C3364o;
import com.sec.common.util.C3367r;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* compiled from: AniconHelper.java */
/* renamed from: com.sec.chaton.settings.downloads.u */
/* loaded from: classes.dex */
public class C2646u {

    /* renamed from: k */
    private static boolean f9901k;

    /* renamed from: b */
    private static final String f9892b = C2646u.class.getSimpleName();

    /* renamed from: c */
    private static final Random f9893c = new Random(System.currentTimeMillis());

    /* renamed from: d */
    private static final List<InterfaceC2535ab> f9894d = new ArrayList();

    /* renamed from: e */
    private static final List<InterfaceC2536ac> f9895e = new ArrayList();

    /* renamed from: a */
    public static HashMap<String, Boolean> f9891a = new HashMap<>();

    /* renamed from: f */
    private static final FilenameFilter f9896f = new C2647v();

    /* renamed from: g */
    private static final FilenameFilter f9897g = new C2648w();

    /* renamed from: h */
    private static final FilenameFilter f9898h = new C2649x();

    /* renamed from: i */
    private static final FilenameFilter f9899i = new C2650y();

    /* renamed from: j */
    private static final FilenameFilter f9900j = new C2534aa("0");

    static {
        try {
            CommonApplication.m11493l().getSystemService("vibrator").getClass().getMethod("vibrateImmVibe", byte[].class);
            f9901k = true;
        } catch (NoSuchMethodException e) {
            f9901k = false;
        }
    }

    /* renamed from: a */
    public static boolean m9652a(Context context, String str) {
        File file = new File(m9645a(context), str);
        return file.exists() && file.listFiles().length != 0;
    }

    /* renamed from: b */
    public static AnimationDrawable m9654b(Context context, String str) {
        return m9643a(context, str, C3347i.m11779b(), C3347i.m11780c());
    }

    /* renamed from: a */
    public static AnimationDrawable m9643a(Context context, String str, int i, int i2) {
        if (!m9652a(context, str)) {
            return null;
        }
        return C3185b.m11132a(context, new File(m9645a(context), str), f9896f, i, i2);
    }

    /* renamed from: a */
    public static AnimationDrawable m9644a(Context context, List<C3229d> list) {
        AnimationDrawable animationDrawable = new AnimationDrawable();
        for (C3229d c3229d : list) {
            animationDrawable.addFrame(c3229d.m11350b(), c3229d.m11347a());
        }
        animationDrawable.selectDrawable(0);
        animationDrawable.setOneShot(false);
        return animationDrawable;
    }

    /* renamed from: b */
    public static List<C3229d> m9656b(Context context, String str, int i, int i2) {
        if (!m9652a(context, str)) {
            return new ArrayList();
        }
        return C3185b.m11133b(context, new File(m9645a(context), str), f9896f, i, i2);
    }

    /* renamed from: c */
    public static Drawable m9662c(Context context, String str, int i, int i2) {
        File fileM9663c;
        Bitmap bitmapM11791a;
        if (!m9652a(context, str) || (fileM9663c = m9663c(context, str)) == null || (bitmapM11791a = C3348j.m11791a(context, fileM9663c, i, i2)) == null) {
            return null;
        }
        bitmapM11791a.setDensity(160);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmapM11791a);
        bitmapDrawable.setAntiAlias(true);
        return bitmapDrawable;
    }

    /* renamed from: c */
    public static File m9663c(Context context, String str) {
        File fileM9672h;
        if (!m9652a(context, str) || (fileM9672h = m9672h(context, str)) == null || !fileM9672h.isDirectory()) {
            return null;
        }
        File[] fileArrListFiles = fileM9672h.listFiles(f9899i);
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            fileArrListFiles = new File[1];
            try {
                fileArrListFiles[0] = m9674j(context, str);
            } catch (IOException e) {
                fileArrListFiles = null;
            }
        }
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            fileArrListFiles = fileM9672h.listFiles(f9900j);
            if (C3250y.f11734b && fileArrListFiles != null && fileArrListFiles.length != 0) {
                C3250y.m11450b(C3364o.m11849a("AniconId: ", str, ", Can't find thumbnail image using alternative image(first frame image)."), f9892b);
            }
        }
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            return null;
        }
        return fileArrListFiles[0];
    }

    /* renamed from: d */
    public static File m9667d(Context context, String str) {
        File fileM9672h;
        File[] fileArrListFiles;
        if (!m9652a(context, str) || (fileM9672h = m9672h(context, str)) == null || !fileM9672h.isDirectory() || (fileArrListFiles = fileM9672h.listFiles(f9898h)) == null || fileArrListFiles.length == 0) {
            return null;
        }
        return fileArrListFiles[0];
    }

    /* renamed from: e */
    public static File m9669e(Context context, String str) {
        File fileM9672h;
        File[] fileArrListFiles;
        if (!m9652a(context, str) || (fileM9672h = m9672h(context, str)) == null || !fileM9672h.isDirectory() || (fileArrListFiles = fileM9672h.listFiles(f9897g)) == null || fileArrListFiles.length == 0) {
            return null;
        }
        return fileArrListFiles[0];
    }

    /* renamed from: d */
    public static BitmapDrawable m9666d(Context context, String str, int i, int i2) {
        Bitmap bitmapM11791a;
        File file = new File(m9645a(context), C3364o.m11849a(str, ".panel"));
        if (file == null || !file.exists() || (bitmapM11791a = C3348j.m11791a(context, file, i, i2)) == null) {
            return null;
        }
        bitmapM11791a.setDensity(160);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmapM11791a);
        bitmapDrawable.setAntiAlias(true);
        return bitmapDrawable;
    }

    /* renamed from: a */
    public static synchronized void m9648a(Context context, String str, File file, File file2) {
        Cursor cursorQuery;
        try {
            m9655b(context, str, file2);
            File fileM9645a = m9645a(context);
            if (C3250y.f11734b) {
                C3250y.m11450b("download_anicon, installPackage, unzip from : " + file.getPath(), f9892b);
                C3250y.m11450b("download_anicon, installPackage, unzip to : " + fileM9645a.getPath(), f9892b);
            }
            C3367r.m11853a(context, file, fileM9645a);
            try {
                cursorQuery = context.getContentResolver().query(C1396an.f5203a, new String[]{"anicon_id"}, C3364o.m11849a("package_id", "=?"), new String[]{str}, null);
                if (cursorQuery != null) {
                    while (cursorQuery.moveToNext()) {
                        try {
                            try {
                                m9674j(context, cursorQuery.getString(cursorQuery.getColumnIndex("anicon_id")));
                            } catch (IOException e) {
                                if (C3250y.f11737e) {
                                    C3250y.m11443a(e, f9892b);
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
                    C3170al.m11042a(context, "com.sec.chaton.provider2", C1366j.m6093a(EnumC1399aq.Anicon, str, C3347i.m11774a()));
                    Iterator<InterfaceC2535ab> it = f9894d.iterator();
                    while (it.hasNext()) {
                        it.next().mo7473a(str);
                    }
                } catch (OperationApplicationException e2) {
                    throw new IOException(e2);
                } catch (RemoteException e3) {
                    throw new IOException(e3);
                }
            } catch (Throwable th2) {
                th = th2;
                cursorQuery = null;
            }
        } catch (IOException e4) {
            if (C3330f.f12033a.f11975e) {
                C3330f.f12033a.m11652a(f9892b, e4.getMessage(), e4);
            }
            throw e4;
        }
    }

    /* renamed from: f */
    public static synchronized boolean m9670f(Context context, String str) {
        Cursor cursor;
        boolean z = true;
        synchronized (C2646u.class) {
            if (C3250y.f11734b) {
                C3250y.m11450b(C3364o.m11849a("Uninstall anicon package. ", str), f9892b);
            }
            Uri uriBuild = C1398ap.m6249a(EnumC1399aq.Anicon).buildUpon().appendPath(str).build();
            try {
                Cursor cursorQuery = context.getContentResolver().query(uriBuild, null, null, null, null);
                try {
                    if (!cursorQuery.moveToNext()) {
                        z = false;
                    } else if (cursorQuery.getLong(cursorQuery.getColumnIndex("expiration_time")) > C3347i.m11774a()) {
                        z = false;
                    }
                    try {
                        try {
                            m9671g(context, str);
                            Cursor cursorQuery2 = context.getContentResolver().query(C1396an.f5203a, new String[]{"anicon_id"}, C3364o.m11849a("package_id", "=?"), new String[]{str}, null);
                            while (cursorQuery2.moveToNext()) {
                                String string = cursorQuery2.getString(cursorQuery2.getColumnIndex("anicon_id"));
                                if (C3250y.f11734b) {
                                    C3250y.m11450b(C3364o.m11849a("Delete anicon. ", string), f9892b);
                                }
                                C3350l.m11803a(m9672h(context, string));
                            }
                            try {
                                if (z) {
                                    C3170al.m11042a(context, "com.sec.chaton.provider2", ContentProviderOperation.newDelete(uriBuild).build());
                                    if (C3250y.f11734b) {
                                        C3250y.m11450b("Anicon package is expired. Delete from database.", f9892b);
                                    }
                                } else {
                                    C3170al.m11042a(context, "com.sec.chaton.provider2", C1366j.m6092a(EnumC1399aq.Anicon, str));
                                }
                                Iterator<InterfaceC2536ac> it = f9895e.iterator();
                                while (it.hasNext()) {
                                    it.next().mo7474b(str);
                                }
                                if (cursorQuery2 != null) {
                                    cursorQuery2.close();
                                }
                            } catch (OperationApplicationException e) {
                                throw new IOException(e);
                            } catch (RemoteException e2) {
                                throw new IOException(e2);
                            }
                        } finally {
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                        }
                    } catch (IOException e3) {
                        if (C3330f.f12033a.f11975e) {
                            C3330f.f12033a.m11652a(f9892b, e3.getMessage(), e3);
                        }
                        throw e3;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
            }
        }
        return z;
    }

    /* renamed from: a */
    public static synchronized File m9646a(Context context, String str, File file) {
        File file2;
        File fileM9672h;
        File file3 = null;
        synchronized (C2646u.class) {
            File file4 = null;
            try {
                try {
                    if (m9652a(context, str)) {
                        if (C3330f.f12033a.f11972b) {
                            C3330f.f12033a.m11651a(f9892b, C3364o.m11849a(str, " is already cached."));
                        }
                        fileM9672h = m9672h(context, str);
                        if (0 != 0 && file4.exists()) {
                            C3350l.m11803a((File) null);
                        }
                    } else {
                        File file5 = new File(file.getParentFile(), String.valueOf(f9893c.nextInt()));
                        try {
                            try {
                                C3367r.m11853a(context, file, file5);
                                fileM9672h = m9672h(context, str);
                                try {
                                    if (!file5.renameTo(fileM9672h)) {
                                        throw new IOException(C3364o.m11849a("Can't rename directory.", file5));
                                    }
                                    if (file5 != null && file5.exists()) {
                                        C3350l.m11803a(file5);
                                    }
                                } catch (IOException e) {
                                    file2 = fileM9672h;
                                    e = e;
                                    if (C3330f.f12033a.f11975e) {
                                        C3330f.f12033a.m11652a(f9892b, e.getMessage(), e);
                                    }
                                    if (file2 == null || !file2.exists()) {
                                        throw e;
                                    }
                                    C3350l.m11803a(file2);
                                    throw e;
                                }
                            } catch (Throwable th) {
                                th = th;
                                file3 = file5;
                                if (file3 != null && file3.exists()) {
                                    C3350l.m11803a(file3);
                                }
                                throw th;
                            }
                        } catch (IOException e2) {
                            e = e2;
                            file2 = null;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e3) {
                e = e3;
                file2 = null;
            }
        }
        return fileM9672h;
    }

    /* renamed from: b */
    public static synchronized File m9655b(Context context, String str, File file) {
        File file2;
        IOException e;
        try {
            file2 = new File(m9645a(context), C3364o.m11849a(str, ".panel"));
            try {
                boolean zRenameTo = file.renameTo(file2);
                if (C3250y.f11734b) {
                    C3250y.m11450b("download_anicon, savePackagePanelImage, rename result : " + zRenameTo, f9892b);
                    C3250y.m11450b("download_anicon, savePackagePanelImage, from cache : " + file.getPath(), f9892b);
                    C3250y.m11450b("download_anicon, savePackagePanelImage, to storage : " + file2.toString(), f9892b);
                }
                if (!zRenameTo) {
                    throw new IOException(C3364o.m11849a("Can't rename anicon panel file.", file2));
                }
            } catch (IOException e2) {
                e = e2;
                if (C3330f.f12033a.f11975e) {
                    C3330f.f12033a.m11652a(f9892b, e.getMessage(), e);
                }
                return file2;
            }
        } catch (IOException e3) {
            file2 = null;
            e = e3;
        }
        return file2;
    }

    /* renamed from: g */
    public static synchronized void m9671g(Context context, String str) {
        boolean z = true;
        synchronized (C2646u.class) {
            File file = new File(m9645a(context), C3364o.m11849a(str, ".panel"));
            if (file.exists()) {
                file.delete();
            } else {
                z = false;
            }
            if (C3250y.f11734b) {
                C3250y.m11450b("download_anicon, removePackagePanelImage, [deleteExist: " + z + "], panelImageDir : " + file.getPath(), f9892b);
            }
        }
    }

    /* renamed from: a */
    public static File m9645a(Context context) {
        File file = new File(C3350l.m11806b(context), "anicon");
        if (file != null && !file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* renamed from: h */
    public static File m9672h(Context context, String str) {
        return new File(m9645a(context), str);
    }

    /* renamed from: a */
    public static boolean m9653a(String str) {
        return !TextUtils.isEmpty(str) && str.contains("file/download/anicon");
    }

    /* renamed from: b */
    public static boolean m9661b(String str) {
        String[] strArrSplit = str.split("\n");
        if (strArrSplit == null || strArrSplit.length < 3) {
            return false;
        }
        return m9653a(strArrSplit[2]);
    }

    /* renamed from: a */
    public static String m9647a(String str, String str2) {
        return C3364o.m11849a(str, "/", str2);
    }

    /* renamed from: c */
    public static String m9664c(String str) {
        int iLastIndexOf;
        if (m9653a(str) && (iLastIndexOf = str.lastIndexOf("/")) != -1) {
            return str.substring(iLastIndexOf + 1, str.length());
        }
        return null;
    }

    /* renamed from: a */
    public static int m9642a() {
        return C3159aa.m10962a().m10978a("new_anicon_count", (Integer) 0).intValue();
    }

    /* renamed from: j */
    private static File m9674j(Context context, String str) throws IOException {
        File fileM9672h = m9672h(context, str);
        File[] fileArrListFiles = fileM9672h.listFiles(f9900j);
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            throw new IOException("Can't find first frame file.");
        }
        String[] strArrSplit = C3350l.m11802a(fileArrListFiles[0].getName()).split("_");
        if (strArrSplit == null || strArrSplit.length <= 6) {
            throw new IOException("Can't shortcut index.");
        }
        File[] fileArrListFiles2 = fileM9672h.listFiles(new C2534aa(strArrSplit[6]));
        if (fileArrListFiles2 == null || fileArrListFiles2.length == 0) {
            throw new IOException("Can't find target frame file.");
        }
        File file = new File(fileM9672h, fileArrListFiles2[0].getName().replace(".png", ".th.png"));
        if (!fileArrListFiles2[0].renameTo(file)) {
            throw new IOException("Can't rename shortcut file name.");
        }
        return file;
    }

    /* renamed from: i */
    public static EnumC2651z m9673i(Context context, String str) {
        File[] fileArrListFiles = m9672h(context, str).listFiles(f9900j);
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            return EnumC2651z.NORMAL;
        }
        String[] strArrSplit = C3350l.m11802a(fileArrListFiles[0].getName()).split("_");
        if (strArrSplit == null || strArrSplit.length <= 7) {
            return EnumC2651z.NORMAL;
        }
        String str2 = strArrSplit[7];
        int iM9676a = EnumC2651z.NORMAL.m9676a();
        if (str2 == null) {
            return EnumC2651z.NORMAL;
        }
        if (str2.contains("h") && m9660b()) {
            iM9676a += EnumC2651z.HAPTIC.m9676a();
        }
        if (str2.contains("s")) {
            iM9676a += EnumC2651z.SOUND.m9676a();
        }
        if (str2.contains("m")) {
            iM9676a += EnumC2651z.MOTION.m9676a();
        }
        return EnumC2651z.m9675a(iM9676a);
    }

    /* renamed from: b */
    public static boolean m9660b() {
        return f9901k;
    }

    /* renamed from: a */
    public static void m9649a(TextView textView) {
        Resources resources = textView.getContext().getResources();
        textView.setTextSize(0, resources.getDimensionPixelOffset(R.dimen.ams_background_dwnld_Title_font_size));
        textView.setTextColor(resources.getColor(R.color.download_before_color));
    }

    /* renamed from: b */
    public static void m9657b(TextView textView) {
        Resources resources = textView.getContext().getResources();
        textView.setTextSize(0, resources.getDimensionPixelOffset(R.dimen.ams_background_dwnld_Title_font_size));
        textView.setTextColor(resources.getColor(R.color.download_after_color));
    }

    /* renamed from: c */
    public static void m9665c(TextView textView) {
        Resources resources = textView.getContext().getResources();
        textView.setTextSize(0, resources.getDimensionPixelOffset(R.dimen.ams_background_dwnld_Title_font_size));
        textView.setTextColor(resources.getColor(R.color.black));
    }

    /* renamed from: d */
    public static void m9668d(TextView textView) {
        Resources resources = textView.getContext().getResources();
        textView.setTextSize(0, resources.getDimensionPixelOffset(R.dimen.ams_background_dwnld_Title_font_size));
        textView.setTextColor(resources.getColor(R.color.black));
    }

    /* renamed from: a */
    public static void m9650a(InterfaceC2535ab interfaceC2535ab) {
        if (!f9894d.contains(interfaceC2535ab)) {
            f9894d.add(interfaceC2535ab);
        }
    }

    /* renamed from: b */
    public static void m9658b(InterfaceC2535ab interfaceC2535ab) {
        f9894d.remove(interfaceC2535ab);
    }

    /* renamed from: a */
    public static void m9651a(InterfaceC2536ac interfaceC2536ac) {
        if (!f9895e.contains(interfaceC2536ac)) {
            f9895e.add(interfaceC2536ac);
        }
    }

    /* renamed from: b */
    public static void m9659b(InterfaceC2536ac interfaceC2536ac) {
        f9895e.remove(interfaceC2536ac);
    }
}
