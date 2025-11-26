package com.sec.chaton.settings.p096a;

import android.content.ContentProviderOperation;
import android.content.Context;
import android.content.OperationApplicationException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.chat.C1735gh;
import com.sec.chaton.p049b.C1057b;
import com.sec.chaton.p057e.C2257bc;
import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.p057e.p058a.C2183ai;
import com.sec.chaton.p057e.p058a.C2196j;
import com.sec.chaton.p065io.entry.inner.Skin;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4821am;
import com.sec.chaton.util.C4904y;
import com.sec.common.C4996f;
import com.sec.common.CommonApplication;
import com.sec.common.util.C5034k;
import com.sec.common.util.C5048n;
import com.sec.common.util.C5052r;
import com.sec.common.util.C5055u;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: SkinHelper.java */
/* renamed from: com.sec.chaton.settings.a.r */
/* loaded from: classes.dex */
public class C3474r {

    /* renamed from: a */
    private static final String f12958a = C3474r.class.getSimpleName();

    /* renamed from: b */
    private static Map<String, Integer> f12959b = new HashMap();

    /* renamed from: c */
    private static Map<String, Integer> f12960c;

    /* renamed from: d */
    private static Map<String, Integer> f12961d;

    /* renamed from: e */
    private static Map<String, Integer> f12962e;

    /* renamed from: f */
    private static final FilenameFilter f12963f;

    /* renamed from: g */
    private static final FilenameFilter f12964g;

    /* renamed from: h */
    private static final FilenameFilter f12965h;

    /* renamed from: i */
    private static final FilenameFilter f12966i;

    /* renamed from: j */
    private static final FilenameFilter f12967j;

    /* renamed from: k */
    private static final FilenameFilter f12968k;

    static {
        f12959b.put("-1", Integer.valueOf(R.drawable.thumb_bg_01));
        f12959b.put("-2", Integer.valueOf(R.drawable.thumb_bg_02));
        f12959b.put("-3", Integer.valueOf(R.drawable.thumb_bg_03));
        f12959b.put("-4", Integer.valueOf(R.drawable.thumb_bg_04));
        f12959b.put("-5", Integer.valueOf(R.drawable.thumb_bg_05));
        f12960c = new HashMap();
        f12960c.put("-1", Integer.valueOf(R.drawable.skin_01));
        f12960c.put("-2", Integer.valueOf(R.drawable.skin_02));
        f12960c.put("-3", Integer.valueOf(R.drawable.skin_03));
        f12960c.put("-4", Integer.valueOf(R.drawable.skin_04));
        f12960c.put("-5", Integer.valueOf(R.drawable.skin_05));
        f12961d = new HashMap();
        f12961d.put("-1", Integer.valueOf(R.drawable.message_bubble_sent1));
        f12961d.put("-2", Integer.valueOf(R.drawable.message_bubble_sent2));
        f12961d.put("-3", Integer.valueOf(R.drawable.message_bubble_sent3));
        f12961d.put("-4", Integer.valueOf(R.drawable.message_bubble_sent4));
        f12961d.put("-5", Integer.valueOf(R.drawable.message_bubble_sent5));
        f12962e = new HashMap();
        f12962e.put("-1", Integer.valueOf(R.drawable.message_bubble_receive1));
        f12962e.put("-2", Integer.valueOf(R.drawable.message_bubble_receive2));
        f12962e.put("-3", Integer.valueOf(R.drawable.message_bubble_receive3));
        f12962e.put("-4", Integer.valueOf(R.drawable.message_bubble_receive4));
        f12962e.put("-5", Integer.valueOf(R.drawable.message_bubble_receive5));
        f12963f = new C3475s();
        f12964g = new C3476t();
        f12965h = new C3477u();
        f12966i = new C3478v();
        f12967j = new C3479w();
        f12968k = new C3480x();
    }

    /* renamed from: a */
    public static File m13812a(Context context) {
        File file = new File(C5048n.m19190a(context), "skin");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* renamed from: a */
    public static File m13815a(Context context, boolean z) {
        if (!z) {
            return m13812a(context);
        }
        File file = new File(C5048n.m19190a(context), "skin_theme");
        if (!file.exists()) {
            file.mkdirs();
            return file;
        }
        return file;
    }

    /* renamed from: a */
    public static File m13813a(Context context, String str) {
        return new File(m13812a(context), str);
    }

    /* renamed from: a */
    public static File m13814a(Context context, String str, boolean z) {
        return z ? new File(m13815a(context, z), str) : m13813a(context, str);
    }

    /* renamed from: b */
    public static boolean m13825b(Context context, String str) {
        if (m13819a(str)) {
            return true;
        }
        return (m13833e(context, str) == null || m13843l(context, str) == null || m13839h(context, str) == null || m13827c(context, str) == null) ? false : true;
    }

    /* renamed from: b */
    public static boolean m13826b(Context context, String str, boolean z) {
        if (m13834e(context, str, z) == null || m13828c(context, str, z) == null) {
            return m13825b(context, str);
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m13819a(String str) {
        try {
            return f12959b.containsKey(str);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /* renamed from: c */
    public static File m13827c(Context context, String str) {
        try {
            return m13813a(context, str).listFiles(f12963f)[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        } catch (NullPointerException e2) {
            return null;
        }
    }

    /* renamed from: c */
    public static File m13828c(Context context, String str, boolean z) {
        if (!z) {
            return m13827c(context, str);
        }
        try {
            return m13814a(context, str, z).listFiles(f12963f)[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        } catch (NullPointerException e2) {
            return null;
        }
    }

    /* renamed from: d */
    public static Drawable m13830d(Context context, String str) throws IOException {
        if (m13819a(str)) {
            return context.getResources().getDrawable(f12959b.get(str).intValue());
        }
        File fileM13827c = m13827c(context, str);
        if (fileM13827c == null) {
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(fileM13827c);
            C3482z c3482zM13844a = C3482z.m13844a(fileInputStream);
            fileInputStream.close();
            return c3482zM13844a;
        } catch (IOException e) {
            return null;
        }
    }

    /* renamed from: d */
    public static Drawable m13831d(Context context, String str, boolean z) throws IOException {
        if (z) {
            File fileM13828c = m13828c(context, str, z);
            if (fileM13828c == null) {
                return null;
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(fileM13828c);
                C3482z c3482zM13844a = C3482z.m13844a(fileInputStream);
                fileInputStream.close();
                return c3482zM13844a;
            } catch (IOException e) {
                return null;
            }
        }
        return m13830d(context, str);
    }

    /* renamed from: e */
    public static File m13833e(Context context, String str) {
        try {
            return m13813a(context, str).listFiles(f12966i)[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        } catch (NullPointerException e2) {
            return null;
        }
    }

    /* renamed from: e */
    public static File m13834e(Context context, String str, boolean z) {
        if (!z) {
            return m13833e(context, str);
        }
        try {
            return m13814a(context, str, z).listFiles(f12966i)[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        } catch (NullPointerException e2) {
            return null;
        }
    }

    /* renamed from: f */
    public static C3481y m13836f(Context context, String str) throws IOException {
        C3481y c3481y = null;
        C3481y c3481y2 = new C3481y();
        if (context == null) {
            return null;
        }
        if (m13819a(str)) {
            int iIntValue = f12960c.get(str).intValue();
            c3481y2.f12969a = "pa";
            c3481y2.f12970b = BitmapFactory.decodeResource(context.getResources(), iIntValue);
            return c3481y2;
        }
        File fileM13833e = m13833e(context, str);
        if (fileM13833e == null) {
            return null;
        }
        try {
            if (C5048n.m19192a(fileM13833e.getName()).split("_")[3].equals("ma")) {
                c3481y2.f12969a = "ma";
            } else {
                c3481y2.f12969a = "pa";
            }
            FileInputStream fileInputStream = new FileInputStream(fileM13833e);
            c3481y2.f12970b = BitmapFactory.decodeStream(fileInputStream);
            fileInputStream.close();
            c3481y = c3481y2;
            return c3481y;
        } catch (IOException e) {
            return c3481y;
        }
    }

    /* renamed from: f */
    public static C3481y m13837f(Context context, String str, boolean z) throws IOException {
        C3481y c3481y = null;
        if (z) {
            C3481y c3481y2 = new C3481y();
            if (context == null) {
                return null;
            }
            File fileM13834e = m13834e(context, str, z);
            if (fileM13834e == null) {
                return m13836f(context, str);
            }
            try {
                if (C5048n.m19192a(fileM13834e.getName()).split("_")[3].equals("ma")) {
                    c3481y2.f12969a = "ma";
                } else {
                    c3481y2.f12969a = "pa";
                }
                FileInputStream fileInputStream = new FileInputStream(fileM13834e);
                c3481y2.f12970b = BitmapFactory.decodeStream(fileInputStream);
                fileInputStream.close();
                c3481y = c3481y2;
                return c3481y;
            } catch (IOException e) {
                return c3481y;
            }
        }
        return m13836f(context, str);
    }

    /* renamed from: a */
    private static Drawable m13811a(Context context, String str, File[] fileArr) throws Throwable {
        FileInputStream fileInputStream;
        Throwable th;
        if (fileArr == null || fileArr.length == 0 || context == null) {
            return null;
        }
        C3454aa c3454aa = new C3454aa(null);
        NinePatchDrawable ninePatchDrawable = null;
        for (File file : fileArr) {
            String strM19192a = C5048n.m19192a(file.getName());
            FileInputStream fileInputStream2 = null;
            try {
                Rect rect = new Rect();
                fileInputStream = new FileInputStream(file);
                try {
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(fileInputStream, rect, new BitmapFactory.Options());
                    NinePatchDrawable ninePatchDrawable2 = new NinePatchDrawable(context.getResources(), bitmapDecodeStream, bitmapDecodeStream.getNinePatchChunk(), rect, null);
                    c3454aa.m13742a(bitmapDecodeStream);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e) {
                        }
                    }
                    String[] strArrSplit = strM19192a.split("_");
                    try {
                        if (!strArrSplit[4].equals("no")) {
                            if (strArrSplit[4].equals("ps")) {
                                c3454aa.addState(new int[]{android.R.attr.state_pressed}, ninePatchDrawable2);
                                ninePatchDrawable2 = ninePatchDrawable;
                            } else {
                                if (strArrSplit[4].equals("fo")) {
                                    c3454aa.addState(new int[]{android.R.attr.state_focused}, ninePatchDrawable2);
                                }
                                ninePatchDrawable2 = ninePatchDrawable;
                            }
                        }
                        ninePatchDrawable = ninePatchDrawable2;
                    } catch (IndexOutOfBoundsException e2) {
                    }
                } catch (IOException e3) {
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception e4) {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e5) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e6) {
            } catch (Throwable th3) {
                fileInputStream = null;
                th = th3;
            }
        }
        if (ninePatchDrawable != null) {
            c3454aa.addState(new int[]{0}, ninePatchDrawable);
        }
        return c3454aa;
    }

    /* renamed from: l */
    private static File[] m13843l(Context context, String str) {
        try {
            return m13813a(context, str).listFiles(f12968k);
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        } catch (NullPointerException e2) {
            return null;
        }
    }

    /* renamed from: g */
    public static Drawable m13838g(Context context, String str) {
        if (!m13819a(str)) {
            return m13811a(context, str, m13843l(context, str));
        }
        return context.getResources().getDrawable(f12961d.get(str).intValue());
    }

    /* renamed from: h */
    public static File[] m13839h(Context context, String str) {
        try {
            return m13813a(context, str).listFiles(f12967j);
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        } catch (NullPointerException e2) {
            return null;
        }
    }

    /* renamed from: i */
    public static Drawable m13840i(Context context, String str) {
        if (!m13819a(str)) {
            return m13811a(context, str, m13839h(context, str));
        }
        return context.getResources().getDrawable(f12962e.get(str).intValue());
    }

    /* renamed from: a */
    public static void m13818a(Drawable drawable) {
        if (drawable instanceof C3482z) {
            Bitmap bitmap = ((C3482z) drawable).getBitmap();
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
                return;
            }
            return;
        }
        if (drawable instanceof C3454aa) {
            List<Bitmap> listM13741a = ((C3454aa) drawable).m13741a();
            for (Bitmap bitmap2 : listM13741a) {
                if (bitmap2 != null && !bitmap2.isRecycled()) {
                    bitmap2.recycle();
                }
            }
            listM13741a.clear();
        }
    }

    /* renamed from: a */
    public static void m13816a(Context context, File file, File file2, String str, long j, String str2) throws IOException {
        try {
            File fileM13814a = m13814a(context, str, true);
            if (!fileM13814a.exists()) {
                fileM13814a.mkdirs();
            }
            String absolutePath = fileM13814a.getAbsolutePath();
            file2.renameTo(new File(absolutePath + "/" + file2.getName()));
            file.renameTo(new File(absolutePath + "/" + file.getName()));
            if (C4904y.f17872b) {
                C4904y.m18639b("download_theme_skin, installThemeSkin, id/install : " + str.toString() + "/" + file2.getPath(), f12958a);
                C4904y.m18639b("download_theme_skin, installThemeSkin, id/install : " + str.toString() + "/" + file.getPath(), f12958a);
            }
            try {
                try {
                    C4821am.m18189a(CommonApplication.m18732r(), "com.sec.chaton.provider2", C2183ai.m9745a(str, j, str2));
                } catch (RemoteException e) {
                    if (e == null) {
                        throw new IOException();
                    }
                    throw new IOException(e.getMessage());
                }
            } catch (OperationApplicationException e2) {
                if (e2 == null) {
                    throw new IOException();
                }
                throw new IOException(e2.getMessage());
            }
        } catch (IOException e3) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e3, f12958a);
            }
        }
    }

    /* renamed from: b */
    public static void m13824b(String str) {
        if (m13829c(str)) {
            C1735gh.m8615a("-1", "pa");
        }
        if (m13832d(str)) {
            C1735gh.m8623c("-1");
        }
        if (m13835e(str)) {
            C1735gh.m8625d("-1");
        }
    }

    /* renamed from: j */
    public static void m13841j(Context context, String str) {
        try {
            File fileM13814a = m13814a(context, str, true);
            if (C4904y.f17872b) {
                C4904y.m18639b("download_theme_skin, uninstallThemeSkin, id/uninstall : " + str.toString() + "/" + fileM13814a.getPath(), f12958a);
            }
            C5048n.m19193a(fileM13814a);
            try {
                try {
                    C4821am.m18189a(context, "com.sec.chaton.provider2", ContentProviderOperation.newDelete(C2257bc.m10121a(EnumC2258bd.SkinTheme).buildUpon().appendPath(str).build()).build());
                    m13824b(str);
                } catch (OperationApplicationException e) {
                    if (e == null) {
                        throw new IOException();
                    }
                    throw new IOException(e.getMessage());
                }
            } catch (RemoteException e2) {
                if (e2 == null) {
                    throw new IOException();
                }
                throw new IOException(e2.getMessage());
            }
        } catch (IOException e3) {
            if (C4996f.f18229a.f18174f) {
                C4996f.f18229a.mo18649a(f12958a, e3.getMessage(), e3);
            }
            throw e3;
        }
    }

    /* renamed from: a */
    public static void m13817a(Context context, String str, File file, File file2) throws Throwable {
        try {
            File fileM13813a = m13813a(context, str);
            if (C4904y.f17872b) {
                C4904y.m18639b("download_skin, installSkin, id/install : " + str.toString() + "/" + fileM13813a.getPath(), f12958a);
            }
            C5055u.m19203a(context, file, fileM13813a);
            C5055u.m19203a(context, file2, fileM13813a);
            try {
                C4821am.m18189a(context, "com.sec.chaton.provider2", C2196j.m9898a(EnumC2258bd.Skin, str, C5034k.m19090a()));
            } catch (OperationApplicationException e) {
                throw C1057b.m6157a(e);
            } catch (RemoteException e2) {
                throw C1057b.m6157a(e2);
            }
        } catch (IOException e3) {
            if (C4996f.f18229a.f18174f) {
                C4996f.f18229a.mo18649a(f12958a, e3.getMessage(), e3);
            }
            if (file != null && file.exists()) {
                file.delete();
            }
            if (file2 != null && file2.exists()) {
                file2.delete();
            }
            throw e3;
        } catch (InterruptedException e4) {
            if (C4996f.f18229a.f18174f) {
                C4996f.f18229a.mo18649a(f12958a, e4.getMessage(), e4);
            }
            if (file != null && file.exists()) {
                file.delete();
            }
            if (file2 != null && file2.exists()) {
                file2.delete();
            }
            throw e4;
        }
    }

    /* renamed from: k */
    public static void m13842k(Context context, String str) throws IOException {
        try {
            File fileM13813a = m13813a(context, str);
            if (C4904y.f17872b) {
                C4904y.m18639b("download_skin, uninstallSkin, id/uninstall : " + str.toString() + "/" + fileM13813a.getPath(), f12958a);
            }
            C5048n.m19193a(fileM13813a);
            try {
                C4821am.m18189a(context, "com.sec.chaton.provider2", ContentProviderOperation.newDelete(C2257bc.m10121a(EnumC2258bd.Skin).buildUpon().appendPath(str).build()).build());
            } catch (OperationApplicationException e) {
                throw C1057b.m6157a(e);
            } catch (RemoteException e2) {
                throw C1057b.m6157a(e2);
            }
        } catch (IOException e3) {
            if (C4996f.f18229a.f18174f) {
                C4996f.f18229a.mo18649a(f12958a, e3.getMessage(), e3);
            }
            throw e3;
        }
    }

    /* renamed from: b */
    public static List<Skin> m13823b(Context context) {
        ArrayList arrayList = new ArrayList();
        Skin skin = new Skin();
        skin.f8579id = "-1";
        skin.bgtype = "pa";
        skin.newitem = false;
        skin.special = 0;
        skin.thumbnailurl = C5052r.m19199a("android.resource", "://", context.getPackageName(), "/drawable/default_preview_01");
        skin.expirationdate = Long.MAX_VALUE;
        Skin skin2 = new Skin();
        skin2.f8579id = "-2";
        skin2.bgtype = "pa";
        skin2.newitem = false;
        skin2.special = 0;
        skin2.thumbnailurl = C5052r.m19199a("android.resource", "://", context.getPackageName(), "/drawable/default_preview_02");
        skin2.expirationdate = Long.MAX_VALUE;
        Skin skin3 = new Skin();
        skin3.f8579id = "-3";
        skin3.bgtype = "pa";
        skin3.newitem = false;
        skin3.special = 0;
        skin3.thumbnailurl = C5052r.m19199a("android.resource", "://", context.getPackageName(), "/drawable/default_preview_03");
        skin3.expirationdate = Long.MAX_VALUE;
        Skin skin4 = new Skin();
        skin4.f8579id = "-4";
        skin4.bgtype = "pa";
        skin4.newitem = false;
        skin4.special = 0;
        skin4.thumbnailurl = C5052r.m19199a("android.resource", "://", context.getPackageName(), "/drawable/default_preview_04");
        skin4.expirationdate = Long.MAX_VALUE;
        arrayList.add(skin);
        arrayList.add(skin2);
        arrayList.add(skin3);
        arrayList.add(skin4);
        return arrayList;
    }

    /* renamed from: a */
    public static int m13810a() {
        int i = 240;
        int iM19100e = C5034k.m19100e();
        int iM19101f = C5034k.m19101f();
        if (iM19100e == 240 && iM19101f == 320) {
            i = 56;
        } else if (iM19100e == 320 && iM19101f == 480) {
            i = 75;
        } else if (iM19100e == 480 && iM19101f == 800) {
            i = 112;
        } else if (iM19100e == 800 && iM19101f == 1280) {
            i = 150;
        } else if (iM19100e == 720 && iM19101f == 1280) {
            i = 150;
        } else if (iM19100e == 1280 && iM19101f == 800) {
            i = 120;
        } else if (iM19100e != 2560 || iM19101f != 1600) {
            i = 0;
        }
        if (i == 0) {
            return 150;
        }
        return i;
    }

    /* renamed from: b */
    public static int m13822b() {
        return C4809aa.m18104a().m18120a("new_skin_count", (Integer) 0).intValue();
    }

    /* renamed from: c */
    public static boolean m13829c(String str) {
        String strM18121a = C4809aa.m18104a().m18121a("setting_change_skin", (String) null);
        if (TextUtils.isEmpty(str)) {
            if (!C4904y.f17872b) {
                return false;
            }
            C4904y.m18639b("isAppliedItem(), request parameter could be (null)", f12958a);
            return false;
        }
        if (strM18121a == null) {
            if (!C4904y.f17872b) {
                return false;
            }
            C4904y.m18639b("isAppliedItem(), saved item could be (null)", f12958a);
            return false;
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("isAppliedItem(), saved/new : " + strM18121a + "/" + str, f12958a);
        }
        return strM18121a.equalsIgnoreCase(str);
    }

    /* renamed from: d */
    public static boolean m13832d(String str) {
        String strM18121a = C4809aa.m18104a().m18121a("setting_change_bubble_send", (String) null);
        if (TextUtils.isEmpty(str)) {
            if (!C4904y.f17872b) {
                return false;
            }
            C4904y.m18639b("isAppliedItem(), request parameter could be (null)", f12958a);
            return false;
        }
        if (strM18121a == null) {
            if (!C4904y.f17872b) {
                return false;
            }
            C4904y.m18639b("isAppliedItem(), saved item could be (null)", f12958a);
            return false;
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("isAppliedItem(), saved/new : " + strM18121a + "/" + str, f12958a);
        }
        return strM18121a.equalsIgnoreCase(str);
    }

    /* renamed from: e */
    public static boolean m13835e(String str) {
        String strM18121a = C4809aa.m18104a().m18121a("setting_change_bubble_receive", (String) null);
        if (TextUtils.isEmpty(str)) {
            if (!C4904y.f17872b) {
                return false;
            }
            C4904y.m18639b("isAppliedItem(), request parameter could be (null)", f12958a);
            return false;
        }
        if (strM18121a == null) {
            if (!C4904y.f17872b) {
                return false;
            }
            C4904y.m18639b("isAppliedItem(), saved item could be (null)", f12958a);
            return false;
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("isAppliedItem(), saved/new : " + strM18121a + "/" + str, f12958a);
        }
        return strM18121a.equalsIgnoreCase(str);
    }

    /* renamed from: a */
    public static boolean m13820a(String str, String str2) {
        if (!m13825b(CommonApplication.m18732r(), str)) {
            if (!C4904y.f17872b) {
                return false;
            }
            C4904y.m18639b("download_skin, apply(), not valid", f12958a);
            return false;
        }
        C1735gh.m8615a(str, str2);
        C1735gh.m8623c(str);
        C1735gh.m8625d(str);
        if (C4904y.f17872b) {
            C4904y.m18639b(C5052r.m19199a("download_skin, apply(), itemId/type : ", str.toString(), "/", str2.toString()), f12958a);
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m13821a(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (!C4904y.f17872b) {
                return false;
            }
            C4904y.m18639b("itemid : " + str + " bg_type : " + str2, f12958a);
            return false;
        }
        if (z) {
            if (!m13826b(CommonApplication.m18732r(), str, z)) {
                if (!C4904y.f17872b) {
                    return false;
                }
                C4904y.m18639b("download_skin, apply(), not valid", f12958a);
                return false;
            }
            C1735gh.m8616a(str, str2, true);
            C4809aa.m18104a().m18124a("theme_applied_time", Long.valueOf(C5034k.m19090a()));
            if (C4904y.f17872b) {
                C4904y.m18639b(C5052r.m19199a("download_themeskin, apply(), itemId/type : ", str.toString(), "/", str2.toString()), f12958a);
            }
            return true;
        }
        return m13820a(str, str2);
    }
}
