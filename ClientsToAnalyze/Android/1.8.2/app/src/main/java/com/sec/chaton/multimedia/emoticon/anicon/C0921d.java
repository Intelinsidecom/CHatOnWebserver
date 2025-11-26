package com.sec.chaton.multimedia.emoticon.anicon;

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
import com.sec.chaton.multimedia.emoticon.p032b.C0950e;
import com.sec.chaton.multimedia.emoticon.p032b.C0952g;
import com.sec.chaton.multimedia.emoticon.p032b.p033a.C0946a;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.common.p055a.C1811a;
import com.sec.common.p056b.C1816b;
import com.sec.common.p056b.C1825d;
import com.sec.common.p056b.C1829e;
import com.sec.common.p056b.C1838f;
import com.sec.common.p056b.p057a.C1813a;
import com.sec.common.p056b.p057a.C1815c;
import com.sec.common.p056b.p060d.C1828c;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* compiled from: AniconHelper.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.anicon.d */
/* loaded from: classes.dex */
public class C0921d {

    /* renamed from: a */
    private static final String f3468a = C0921d.class.getSimpleName();

    /* renamed from: b */
    private static final Random f3469b = new Random(System.currentTimeMillis());

    /* renamed from: c */
    private static final FilenameFilter f3470c = new C0922e();

    /* renamed from: d */
    private static final FilenameFilter f3471d = new C0923f();

    /* renamed from: a */
    public static boolean m3789a(Context context, String str) {
        File file = new File(m3786a(context), str);
        return file.exists() && file.listFiles().length != 0;
    }

    /* renamed from: b */
    public static AnimationDrawable m3791b(Context context, String str) {
        return m3784a(context, str, C1816b.m6159b(), C1816b.m6160c());
    }

    /* renamed from: a */
    public static AnimationDrawable m3784a(Context context, String str, int i, int i2) {
        if (!m3789a(context, str)) {
            return null;
        }
        return C1813a.m6149a(context, new File(m3786a(context), str), f3470c, i, i2);
    }

    /* renamed from: a */
    public static AnimationDrawable m3785a(Context context, List list) {
        AnimationDrawable animationDrawable = new AnimationDrawable();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C1815c c1815c = (C1815c) it.next();
            animationDrawable.addFrame(c1815c.m6155b(), c1815c.m6152a());
        }
        animationDrawable.selectDrawable(0);
        animationDrawable.setOneShot(false);
        return animationDrawable;
    }

    /* renamed from: b */
    public static List m3793b(Context context, String str, int i, int i2) {
        if (!m3789a(context, str)) {
            return new ArrayList();
        }
        return C1813a.m6150b(context, new File(m3786a(context), str), f3470c, i, i2);
    }

    /* renamed from: c */
    public static Drawable m3795c(Context context, String str, int i, int i2) throws IOException {
        File fileM3796c;
        if (!m3789a(context, str) || (fileM3796c = m3796c(context, str)) == null) {
            return null;
        }
        Bitmap bitmapM6144a = C1811a.m6144a(context, fileM3796c, i, i2);
        bitmapM6144a.setDensity(160);
        if (bitmapM6144a == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmapM6144a);
        bitmapDrawable.setAntiAlias(true);
        return bitmapDrawable;
    }

    /* renamed from: c */
    public static File m3796c(Context context, String str) {
        File fileM3799e;
        if (!m3789a(context, str) || (fileM3799e = m3799e(context, str)) == null || !fileM3799e.isDirectory()) {
            return null;
        }
        File[] fileArrListFiles = fileM3799e.listFiles(f3471d);
        if (fileArrListFiles.length != 0) {
            return fileArrListFiles[0];
        }
        return null;
    }

    /* renamed from: a */
    public static synchronized void m3788a(Context context, String str, File file) {
        try {
            C1838f.m6232a(context, file, m3786a(context));
            try {
                C0946a.m3812a(context, C0946a.m3810a(str, C1816b.m6156a()));
            } catch (OperationApplicationException e) {
                throw new IOException(e);
            } catch (RemoteException e2) {
                throw new IOException(e2);
            }
        } catch (IOException e3) {
            if (C1825d.f6539a.f6544e) {
                C1825d.f6539a.m6201a(f3468a, e3.getMessage(), e3);
            }
            throw e3;
        }
    }

    /* renamed from: d */
    public static synchronized boolean m3798d(Context context, String str) {
        Cursor cursor;
        Cursor cursorQuery;
        boolean z;
        if (C1786r.f6452b) {
            C1786r.m6061b(C1828c.m6207a("Uninstall anicon package. ", str), f3468a);
        }
        Uri uriBuild = C0952g.f3515a.buildUpon().appendPath(str).build();
        try {
            cursorQuery = context.getContentResolver().query(uriBuild, null, null, null, null);
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
            z = cursorQuery.moveToNext() ? cursorQuery.getLong(cursorQuery.getColumnIndex("expiration_time")) <= C1816b.m6156a() : false;
            try {
                try {
                    Cursor cursorQuery2 = context.getContentResolver().query(C0950e.f3514a, new String[]{"anicon_id"}, C1828c.m6207a("package_id", "=?"), new String[]{str}, null);
                    while (cursorQuery2.moveToNext()) {
                        String string = cursorQuery2.getString(cursorQuery2.getColumnIndex("anicon_id"));
                        if (C1786r.f6452b) {
                            C1786r.m6061b(C1828c.m6207a("Delete anicon. ", string), f3468a);
                        }
                        C1829e.m6209a(m3799e(context, string));
                    }
                    try {
                        if (z) {
                            C0946a.m3812a(context, ContentProviderOperation.newDelete(uriBuild).build());
                            if (C1786r.f6452b) {
                                C1786r.m6061b("Anicon package is expired. Delete from database.", f3468a);
                            }
                        } else {
                            C0946a.m3813a(context, C0946a.m3815b(str));
                        }
                        if (cursorQuery2 != null) {
                            cursorQuery2.close();
                        }
                    } catch (OperationApplicationException e) {
                        throw new IOException(e);
                    } catch (RemoteException e2) {
                        throw new IOException(e2);
                    }
                } catch (IOException e3) {
                    if (C1825d.f6539a.f6544e) {
                        C1825d.f6539a.m6201a(f3468a, e3.getMessage(), e3);
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
        return z;
    }

    /* renamed from: b */
    public static synchronized File m3792b(Context context, String str, File file) {
        File file2;
        File fileM3799e;
        File file3 = null;
        synchronized (C0921d.class) {
            File file4 = null;
            try {
                try {
                    if (m3789a(context, str)) {
                        if (C1825d.f6539a.f6541b) {
                            C1825d.f6539a.m6200a(f3468a, C1828c.m6207a(str, " is already cached."));
                        }
                        fileM3799e = m3799e(context, str);
                        if (0 != 0 && file4.exists()) {
                            C1829e.m6209a((File) null);
                        }
                    } else {
                        File file5 = new File(file.getParentFile(), String.valueOf(f3469b.nextInt()));
                        try {
                            try {
                                C1838f.m6232a(context, file, file5);
                                fileM3799e = m3799e(context, str);
                                try {
                                    if (!file5.renameTo(fileM3799e)) {
                                        throw new IOException(C1828c.m6207a("Can't rename directory.", file5));
                                    }
                                    if (file5 != null && file5.exists()) {
                                        C1829e.m6209a(file5);
                                    }
                                } catch (IOException e) {
                                    file2 = fileM3799e;
                                    e = e;
                                    if (C1825d.f6539a.f6544e) {
                                        C1825d.f6539a.m6201a(f3468a, e.getMessage(), e);
                                    }
                                    if (file2 == null || !file2.exists()) {
                                        throw e;
                                    }
                                    C1829e.m6209a(file2);
                                    throw e;
                                }
                            } catch (Throwable th) {
                                th = th;
                                file3 = file5;
                                if (file3 != null && file3.exists()) {
                                    C1829e.m6209a(file3);
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
        return fileM3799e;
    }

    /* renamed from: a */
    public static File m3786a(Context context) {
        File file = new File(C1829e.m6210b(context), "anicon");
        if (file != null && !file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* renamed from: e */
    public static File m3799e(Context context, String str) {
        return new File(m3786a(context), str);
    }

    /* renamed from: a */
    public static boolean m3790a(String str) {
        return !TextUtils.isEmpty(str) && str.contains("file/download/anicon");
    }

    /* renamed from: b */
    public static boolean m3794b(String str) {
        String[] strArrSplit = str.split("\n");
        if (strArrSplit == null || strArrSplit.length < 3) {
            return false;
        }
        return m3790a(strArrSplit[2]);
    }

    /* renamed from: a */
    public static String m3787a(String str, String str2) {
        return C1828c.m6207a(str, "/", str2);
    }

    /* renamed from: c */
    public static String m3797c(String str) {
        int iLastIndexOf;
        if (m3790a(str) && (iLastIndexOf = str.lastIndexOf("/")) != -1) {
            return str.substring(iLastIndexOf + 1, str.length());
        }
        return null;
    }

    /* renamed from: a */
    public static int m3783a() {
        return C1789u.m6075a().getInt("new_anicon_count", 0);
    }
}
