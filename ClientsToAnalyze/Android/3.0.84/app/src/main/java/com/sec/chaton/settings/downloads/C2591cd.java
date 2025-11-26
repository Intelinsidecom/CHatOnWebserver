package com.sec.chaton.settings.downloads;

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
import com.sec.chaton.p027e.EnumC1399aq;
import com.sec.chaton.p027e.p028a.C1366j;
import com.sec.chaton.p035io.entry.inner.Skin;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3170al;
import com.sec.chaton.util.C3250y;
import com.sec.common.C3330f;
import com.sec.common.CommonApplication;
import com.sec.common.util.C3347i;
import com.sec.common.util.C3350l;
import com.sec.common.util.C3364o;
import com.sec.common.util.C3367r;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: SkinHelper.java */
/* renamed from: com.sec.chaton.settings.downloads.cd */
/* loaded from: classes.dex */
public class C2591cd {

    /* renamed from: a */
    private static final String f9814a = C2591cd.class.getSimpleName();

    /* renamed from: b */
    private static Map<String, Integer> f9815b = new HashMap();

    /* renamed from: c */
    private static Map<String, Integer> f9816c;

    /* renamed from: d */
    private static Map<String, Integer> f9817d;

    /* renamed from: e */
    private static Map<String, Integer> f9818e;

    /* renamed from: f */
    private static final FilenameFilter f9819f;

    /* renamed from: g */
    private static final FilenameFilter f9820g;

    /* renamed from: h */
    private static final FilenameFilter f9821h;

    /* renamed from: i */
    private static final FilenameFilter f9822i;

    /* renamed from: j */
    private static final FilenameFilter f9823j;

    /* renamed from: k */
    private static final FilenameFilter f9824k;

    static {
        f9815b.put("-1", Integer.valueOf(R.drawable.thumb_bg_01));
        f9815b.put("-2", Integer.valueOf(R.drawable.thumb_bg_02));
        f9815b.put("-3", Integer.valueOf(R.drawable.thumb_bg_03));
        f9815b.put("-4", Integer.valueOf(R.drawable.thumb_bg_04));
        f9815b.put("-5", Integer.valueOf(R.drawable.thumb_bg_05));
        f9816c = new HashMap();
        f9816c.put("-1", Integer.valueOf(R.drawable.skin_01));
        f9816c.put("-2", Integer.valueOf(R.drawable.skin_02));
        f9816c.put("-3", Integer.valueOf(R.drawable.skin_03));
        f9816c.put("-4", Integer.valueOf(R.drawable.skin_04));
        f9816c.put("-5", Integer.valueOf(R.drawable.skin_05));
        f9817d = new HashMap();
        f9817d.put("-1", Integer.valueOf(R.drawable.message_bubble_sent1));
        f9817d.put("-2", Integer.valueOf(R.drawable.message_bubble_sent2));
        f9817d.put("-3", Integer.valueOf(R.drawable.message_bubble_sent3));
        f9817d.put("-4", Integer.valueOf(R.drawable.message_bubble_sent4));
        f9817d.put("-5", Integer.valueOf(R.drawable.message_bubble_sent5));
        f9818e = new HashMap();
        f9818e.put("-1", Integer.valueOf(R.drawable.message_bubble_receive1));
        f9818e.put("-2", Integer.valueOf(R.drawable.message_bubble_receive2));
        f9818e.put("-3", Integer.valueOf(R.drawable.message_bubble_receive3));
        f9818e.put("-4", Integer.valueOf(R.drawable.message_bubble_receive4));
        f9818e.put("-5", Integer.valueOf(R.drawable.message_bubble_receive5));
        f9819f = new C2592ce();
        f9820g = new C2593cf();
        f9821h = new C2594cg();
        f9822i = new C2595ch();
        f9823j = new C2596ci();
        f9824k = new C2597cj();
    }

    /* renamed from: a */
    public static File m9566a(Context context) {
        File file = new File(C3350l.m11800a(context), "skin");
        if (file != null && !file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* renamed from: a */
    public static File m9567a(Context context, String str) {
        return new File(m9566a(context), str);
    }

    /* renamed from: b */
    public static boolean m9574b(Context context, String str) {
        if (m9570a(str)) {
            return true;
        }
        return (m9581e(context, str) == null || m9588k(context, str) == null || m9585h(context, str) == null || m9577c(context, str) == null) ? false : true;
    }

    /* renamed from: a */
    public static boolean m9570a(String str) {
        try {
            return f9815b.containsKey(str);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /* renamed from: c */
    public static File m9577c(Context context, String str) {
        try {
            return m9567a(context, str).listFiles(f9819f)[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        } catch (NullPointerException e2) {
            return null;
        }
    }

    /* renamed from: d */
    public static Drawable m9579d(Context context, String str) throws Throwable {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2;
        if (m9570a(str)) {
            return context.getResources().getDrawable(f9815b.get(str).intValue());
        }
        File fileM9577c = m9577c(context, str);
        if (fileM9577c == null) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(fileM9577c);
            try {
                C2599cl c2599cl = new C2599cl(fileInputStream);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e) {
                    }
                }
                return c2599cl;
            } catch (IOException e2) {
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 == null) {
                    return null;
                }
                try {
                    fileInputStream2.close();
                    return null;
                } catch (Exception e3) {
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e4) {
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            fileInputStream2 = null;
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
        }
    }

    /* renamed from: e */
    public static File m9581e(Context context, String str) {
        try {
            return m9567a(context, str).listFiles(f9822i)[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        } catch (NullPointerException e2) {
            return null;
        }
    }

    /* renamed from: f */
    public static C2598ck m9582f(Context context, String str) throws Throwable {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2;
        C2598ck c2598ck = new C2598ck();
        if (m9570a(str)) {
            int iIntValue = f9816c.get(str).intValue();
            c2598ck.f9825a = "pa";
            c2598ck.f9826b = BitmapFactory.decodeResource(context.getResources(), iIntValue);
            return c2598ck;
        }
        File fileM9581e = m9581e(context, str);
        if (fileM9581e == null) {
            return null;
        }
        try {
            if (C3350l.m11802a(fileM9581e.getName()).split("_")[3].equals("ma")) {
                c2598ck.f9825a = "ma";
            } else {
                c2598ck.f9825a = "pa";
            }
            fileInputStream = new FileInputStream(fileM9581e);
        } catch (IOException e) {
            fileInputStream2 = null;
        } catch (Throwable th2) {
            fileInputStream = null;
            th = th2;
        }
        try {
            c2598ck.f9826b = BitmapFactory.decodeStream(fileInputStream);
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e2) {
                }
            }
            return c2598ck;
        } catch (IOException e3) {
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 == null) {
                return null;
            }
            try {
                fileInputStream2.close();
                return null;
            } catch (Exception e4) {
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e5) {
                }
            }
            throw th;
        }
    }

    /* renamed from: a */
    private static Drawable m9565a(Context context, String str, File[] fileArr) throws Throwable {
        FileInputStream fileInputStream;
        Throwable th;
        if (fileArr == null || fileArr.length == 0) {
            return null;
        }
        C2600cm c2600cm = new C2600cm(null);
        NinePatchDrawable ninePatchDrawable = null;
        for (File file : fileArr) {
            String strM11802a = C3350l.m11802a(file.getName());
            FileInputStream fileInputStream2 = null;
            try {
                Rect rect = new Rect();
                fileInputStream = new FileInputStream(file);
                try {
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(fileInputStream, rect, new BitmapFactory.Options());
                    NinePatchDrawable ninePatchDrawable2 = new NinePatchDrawable(context.getResources(), bitmapDecodeStream, bitmapDecodeStream.getNinePatchChunk(), rect, null);
                    c2600cm.m9590a(bitmapDecodeStream);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e) {
                        }
                    }
                    String[] strArrSplit = strM11802a.split("_");
                    try {
                        if (!strArrSplit[4].equals("no")) {
                            if (strArrSplit[4].equals("ps")) {
                                c2600cm.addState(new int[]{android.R.attr.state_pressed}, ninePatchDrawable2);
                                ninePatchDrawable2 = ninePatchDrawable;
                            } else {
                                if (strArrSplit[4].equals("fo")) {
                                    c2600cm.addState(new int[]{android.R.attr.state_focused}, ninePatchDrawable2);
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
            c2600cm.addState(new int[]{0}, ninePatchDrawable);
        }
        return c2600cm;
    }

    /* renamed from: k */
    private static File[] m9588k(Context context, String str) {
        try {
            return m9567a(context, str).listFiles(f9824k);
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        } catch (NullPointerException e2) {
            return null;
        }
    }

    /* renamed from: g */
    public static Drawable m9584g(Context context, String str) {
        if (!m9570a(str)) {
            return m9565a(context, str, m9588k(context, str));
        }
        return context.getResources().getDrawable(f9817d.get(str).intValue());
    }

    /* renamed from: h */
    public static File[] m9585h(Context context, String str) {
        try {
            return m9567a(context, str).listFiles(f9823j);
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        } catch (NullPointerException e2) {
            return null;
        }
    }

    /* renamed from: i */
    public static Drawable m9586i(Context context, String str) {
        if (!m9570a(str)) {
            return m9565a(context, str, m9585h(context, str));
        }
        return context.getResources().getDrawable(f9818e.get(str).intValue());
    }

    /* renamed from: a */
    public static void m9569a(Drawable drawable) {
        if (drawable instanceof C2599cl) {
            Bitmap bitmap = ((C2599cl) drawable).getBitmap();
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
                return;
            }
            return;
        }
        if (drawable instanceof C2600cm) {
            List<Bitmap> listM9589a = ((C2600cm) drawable).m9589a();
            for (Bitmap bitmap2 : listM9589a) {
                if (bitmap2 != null && !bitmap2.isRecycled()) {
                    bitmap2.recycle();
                }
            }
            listM9589a.clear();
        }
    }

    /* renamed from: a */
    public static void m9568a(Context context, String str, File file, File file2) throws Throwable {
        try {
            File fileM9567a = m9567a(context, str);
            if (C3250y.f11734b) {
                C3250y.m11450b("download_skin, installSkin, id/install : " + str.toString() + "/" + fileM9567a.getPath(), f9814a);
            }
            C3367r.m11853a(context, file, fileM9567a);
            C3367r.m11853a(context, file2, fileM9567a);
            try {
                C3170al.m11042a(context, "com.sec.chaton.provider2", C1366j.m6093a(EnumC1399aq.Skin, str, C3347i.m11774a()));
            } catch (OperationApplicationException e) {
                throw new IOException(e);
            } catch (RemoteException e2) {
                throw new IOException(e2);
            }
        } catch (IOException e3) {
            if (C3330f.f12033a.f11975e) {
                C3330f.f12033a.m11652a(f9814a, e3.getMessage(), e3);
            }
            if (file != null && file.exists()) {
                file.delete();
            }
            if (file2 != null && file2.exists()) {
                file2.delete();
            }
            throw e3;
        } catch (InterruptedException e4) {
            if (C3330f.f12033a.f11975e) {
                C3330f.f12033a.m11652a(f9814a, e4.getMessage(), e4);
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

    /* renamed from: j */
    public static void m9587j(Context context, String str) throws IOException {
        try {
            File fileM9567a = m9567a(context, str);
            if (C3250y.f11734b) {
                C3250y.m11450b("download_skin, uninstallSkin, id/uninstall : " + str.toString() + "/" + fileM9567a.getPath(), f9814a);
            }
            C3350l.m11803a(fileM9567a);
            try {
                C3170al.m11042a(context, "com.sec.chaton.provider2", C1366j.m6092a(EnumC1399aq.Skin, str));
            } catch (OperationApplicationException e) {
                throw new IOException(e);
            } catch (RemoteException e2) {
                throw new IOException(e2);
            }
        } catch (IOException e3) {
            if (C3330f.f12033a.f11975e) {
                C3330f.f12033a.m11652a(f9814a, e3.getMessage(), e3);
            }
            throw e3;
        }
    }

    /* renamed from: b */
    public static List<Skin> m9573b(Context context) {
        ArrayList arrayList = new ArrayList();
        Skin skin = new Skin();
        skin.f5654id = "-1";
        skin.bgtype = "pa";
        skin.newitem = false;
        skin.special = 0;
        skin.thumbnailurl = C3364o.m11849a("android.resource", "://", context.getPackageName(), "/drawable/default_preview_01");
        skin.expirationdate = Long.MAX_VALUE;
        Skin skin2 = new Skin();
        skin2.f5654id = "-2";
        skin2.bgtype = "pa";
        skin2.newitem = false;
        skin2.special = 0;
        skin2.thumbnailurl = C3364o.m11849a("android.resource", "://", context.getPackageName(), "/drawable/default_preview_02");
        skin2.expirationdate = Long.MAX_VALUE;
        Skin skin3 = new Skin();
        skin3.f5654id = "-3";
        skin3.bgtype = "pa";
        skin3.newitem = false;
        skin3.special = 0;
        skin3.thumbnailurl = C3364o.m11849a("android.resource", "://", context.getPackageName(), "/drawable/default_preview_03");
        skin3.expirationdate = Long.MAX_VALUE;
        Skin skin4 = new Skin();
        skin4.f5654id = "-4";
        skin4.bgtype = "pa";
        skin4.newitem = false;
        skin4.special = 0;
        skin4.thumbnailurl = C3364o.m11849a("android.resource", "://", context.getPackageName(), "/drawable/default_preview_04");
        skin4.expirationdate = Long.MAX_VALUE;
        arrayList.add(skin);
        arrayList.add(skin2);
        arrayList.add(skin3);
        arrayList.add(skin4);
        return arrayList;
    }

    /* renamed from: a */
    public static int m9564a() {
        int i = 240;
        int iM11782e = C3347i.m11782e();
        int iM11783f = C3347i.m11783f();
        if (iM11782e == 240 && iM11783f == 320) {
            i = 56;
        } else if (iM11782e == 320 && iM11783f == 480) {
            i = 75;
        } else if (iM11782e == 480 && iM11783f == 800) {
            i = 112;
        } else if (iM11782e == 800 && iM11783f == 1280) {
            i = 150;
        } else if (iM11782e == 720 && iM11783f == 1280) {
            i = 150;
        } else if (iM11782e == 1280 && iM11783f == 800) {
            i = 120;
        } else if (iM11782e != 2560 || iM11783f != 1600) {
            i = 0;
        }
        if (i == 0) {
            return 150;
        }
        return i;
    }

    /* renamed from: b */
    public static int m9572b() {
        int i = 0;
        int iM11782e = C3347i.m11782e();
        int iM11783f = C3347i.m11783f();
        if (iM11782e == 240 && iM11783f == 320) {
            i = 84;
        } else if (iM11782e == 320 && iM11783f == 480) {
            i = 112;
        } else if (iM11782e == 480 && iM11783f == 800) {
            i = 168;
        } else if (iM11782e == 800 && iM11783f == 1280) {
            i = 224;
        } else if (iM11782e == 720 && iM11783f == 1280) {
            i = 224;
        } else if (iM11782e == 1280 && iM11783f == 800) {
            i = 170;
        } else if (iM11782e == 2560 && iM11783f == 1600) {
            i = 340;
        }
        if (i == 0) {
            return 224;
        }
        return i;
    }

    /* renamed from: c */
    public static int m9576c() {
        return 640;
    }

    /* renamed from: d */
    public static int m9578d() {
        return 640;
    }

    /* renamed from: e */
    public static int m9580e() {
        return C3159aa.m10962a().m10978a("new_skin_count", (Integer) 0).intValue();
    }

    /* renamed from: b */
    public static boolean m9575b(String str) {
        String strM10979a = C3159aa.m10962a().m10979a("setting_change_skin", (String) null);
        String strM10979a2 = C3159aa.m10962a().m10979a("setting_change_bubble_send", (String) null);
        String strM10979a3 = C3159aa.m10962a().m10979a("setting_change_bubble_receive", (String) null);
        if (TextUtils.isEmpty(str)) {
            if (!C3250y.f11734b) {
                return false;
            }
            C3250y.m11450b("isAppliedItem(), request parameter could be (null)", f9814a);
            return false;
        }
        if (strM10979a == null || strM10979a2 == null || strM10979a3 == null) {
            if (!C3250y.f11734b) {
                return false;
            }
            C3250y.m11450b("isAppliedItem(), saved item could be (null)", f9814a);
            return false;
        }
        if (C3250y.f11734b) {
            C3250y.m11450b("isAppliedItem(), saved/new : " + strM10979a + "," + strM10979a2 + "," + strM10979a3 + "/" + str, f9814a);
        }
        return strM10979a.equalsIgnoreCase(str) && strM10979a2.equalsIgnoreCase(str) && strM10979a3.equalsIgnoreCase(str);
    }

    /* renamed from: a */
    public static boolean m9571a(String str, String str2) {
        if (!m9574b(CommonApplication.m11493l(), str)) {
            if (!C3250y.f11734b) {
                return false;
            }
            C3250y.m11450b("download_skin, apply(), not valid", f9814a);
            return false;
        }
        C3159aa.m10962a().m10986b("setting_change_skin", str);
        C3159aa.m10962a().m10986b("setting_change_skin_type", str2);
        C3159aa.m10962a().m10986b("setting_change_bubble_send", str);
        C3159aa.m10962a().m10986b("setting_change_bubble_receive", str);
        if (C3250y.f11734b) {
            C3250y.m11450b(C3364o.m11849a("download_skin, apply(), itemId/type : ", str.toString(), "/", str2.toString()), f9814a);
        }
        return true;
    }

    /* renamed from: f */
    public static void m9583f() {
        C3159aa.m10962a().m10981a("setting_change_skin");
        C3159aa.m10962a().m10981a("setting_change_skin_type");
        C3159aa.m10962a().m10981a("setting_change_bubble_send");
        C3159aa.m10962a().m10981a("setting_change_bubble_receive");
    }
}
