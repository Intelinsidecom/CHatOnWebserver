package com.sec.chaton.multimedia.skin;

import android.content.Context;
import android.content.OperationApplicationException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.RemoteException;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.skin.entry.inner.Skin;
import com.sec.chaton.multimedia.skin.p037b.p038a.C1000a;
import com.sec.chaton.util.C1789u;
import com.sec.common.p056b.C1816b;
import com.sec.common.p056b.C1825d;
import com.sec.common.p056b.C1829e;
import com.sec.common.p056b.C1838f;
import com.sec.common.p056b.p060d.C1828c;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: SkinHelper.java */
/* renamed from: com.sec.chaton.multimedia.skin.c */
/* loaded from: classes.dex */
public class C1003c {

    /* renamed from: a */
    private static final String f3695a = C1003c.class.getSimpleName();

    /* renamed from: b */
    private static Map f3696b = new HashMap();

    /* renamed from: c */
    private static Map f3697c;

    /* renamed from: d */
    private static Map f3698d;

    /* renamed from: e */
    private static Map f3699e;

    /* renamed from: f */
    private static final FilenameFilter f3700f;

    /* renamed from: g */
    private static final FilenameFilter f3701g;

    /* renamed from: h */
    private static final FilenameFilter f3702h;

    /* renamed from: i */
    private static final FilenameFilter f3703i;

    /* renamed from: j */
    private static final FilenameFilter f3704j;

    /* renamed from: k */
    private static final FilenameFilter f3705k;

    static {
        f3696b.put("-1", Integer.valueOf(R.drawable.thumb_skin_bg_01));
        f3696b.put("-2", Integer.valueOf(R.drawable.thumb_skin_bg_02));
        f3696b.put("-3", Integer.valueOf(R.drawable.thumb_skin_bg_03));
        f3696b.put("-4", Integer.valueOf(R.drawable.thumb_skin_bg_04));
        f3697c = new HashMap();
        f3697c.put("-1", Integer.valueOf(R.drawable.skin_01));
        f3697c.put("-2", Integer.valueOf(R.drawable.skin_02));
        f3697c.put("-3", Integer.valueOf(R.drawable.skin_03));
        f3697c.put("-4", Integer.valueOf(R.drawable.skin_04));
        f3698d = new HashMap();
        f3698d.put("-1", Integer.valueOf(R.drawable.bubble_send_01_normal));
        f3698d.put("-2", Integer.valueOf(R.drawable.bubble_send_02_normal));
        f3698d.put("-3", Integer.valueOf(R.drawable.bubble_send_03_normal));
        f3698d.put("-4", Integer.valueOf(R.drawable.bubble_send_04_normal));
        f3699e = new HashMap();
        f3699e.put("-1", Integer.valueOf(R.drawable.bubble_receive_01_normal));
        f3699e.put("-2", Integer.valueOf(R.drawable.bubble_receive_02_normal));
        f3699e.put("-3", Integer.valueOf(R.drawable.bubble_receive_03_normal));
        f3699e.put("-4", Integer.valueOf(R.drawable.bubble_receive_04_normal));
        f3700f = new C1006d();
        f3701g = new C1007e();
        f3702h = new C1008f();
        f3703i = new C1009g();
        f3704j = new C1010h();
        f3705k = new C1011i();
    }

    /* renamed from: a */
    public static File m3937a(Context context) {
        File file = new File(C1829e.m6208a(context), "skin");
        if (file != null && !file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* renamed from: a */
    public static File m3938a(Context context, String str) {
        return new File(m3937a(context), str);
    }

    /* renamed from: b */
    public static boolean m3944b(Context context, String str) {
        if (m3941a(str)) {
            return true;
        }
        return (m3948e(context, str) == null || m3954k(context, str) == null || m3951h(context, str) == null || m3946c(context, str) == null) ? false : true;
    }

    /* renamed from: a */
    public static boolean m3941a(String str) {
        try {
            return f3696b.containsKey(str);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /* renamed from: c */
    public static File m3946c(Context context, String str) {
        try {
            return m3938a(context, str).listFiles(f3700f)[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        } catch (NullPointerException e2) {
            return null;
        }
    }

    /* renamed from: d */
    public static Drawable m3947d(Context context, String str) throws Throwable {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2;
        if (m3941a(str)) {
            return context.getResources().getDrawable(((Integer) f3696b.get(str)).intValue());
        }
        File fileM3946c = m3946c(context, str);
        if (fileM3946c == null) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(fileM3946c);
            try {
                C1013k c1013k = new C1013k(fileInputStream);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e) {
                    }
                }
                return c1013k;
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
    public static File m3948e(Context context, String str) {
        try {
            return m3938a(context, str).listFiles(f3703i)[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        } catch (NullPointerException e2) {
            return null;
        }
    }

    /* renamed from: f */
    public static C1012j m3949f(Context context, String str) {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2;
        C1012j c1012j = new C1012j();
        if (m3941a(str)) {
            int iIntValue = ((Integer) f3697c.get(str)).intValue();
            c1012j.f3709a = "pa";
            c1012j.f3710b = BitmapFactory.decodeResource(context.getResources(), iIntValue);
            return c1012j;
        }
        File fileM3948e = m3948e(context, str);
        if (fileM3948e == null) {
            return null;
        }
        try {
            if (C1816b.m6158a(fileM3948e.getName()).split("_")[3].equals("ma")) {
                c1012j.f3709a = "ma";
            } else {
                c1012j.f3709a = "pa";
            }
            fileInputStream = new FileInputStream(fileM3948e);
        } catch (IOException e) {
            fileInputStream2 = null;
        } catch (Throwable th2) {
            fileInputStream = null;
            th = th2;
        }
        try {
            c1012j.f3710b = BitmapFactory.decodeStream(fileInputStream);
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e2) {
                }
            }
            return c1012j;
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
    private static Drawable m3936a(Context context, String str, File[] fileArr) throws Throwable {
        FileInputStream fileInputStream;
        Throwable th;
        if (fileArr == null || fileArr.length == 0) {
            return null;
        }
        C1014l c1014l = new C1014l(null);
        NinePatchDrawable ninePatchDrawable = null;
        for (File file : fileArr) {
            String strM6158a = C1816b.m6158a(file.getName());
            FileInputStream fileInputStream2 = null;
            try {
                Rect rect = new Rect();
                fileInputStream = new FileInputStream(file);
                try {
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(fileInputStream, rect, new BitmapFactory.Options());
                    NinePatchDrawable ninePatchDrawable2 = bitmapDecodeStream.getNinePatchChunk() != null ? new NinePatchDrawable(context.getResources(), bitmapDecodeStream, bitmapDecodeStream.getNinePatchChunk(), rect, null) : null;
                    c1014l.m3958a(bitmapDecodeStream);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e) {
                        }
                    }
                    String[] strArrSplit = strM6158a.split("_");
                    try {
                        if (!strArrSplit[4].equals("no")) {
                            if (strArrSplit[4].equals("ps")) {
                                c1014l.addState(new int[]{android.R.attr.state_pressed}, ninePatchDrawable2);
                                ninePatchDrawable2 = ninePatchDrawable;
                            } else {
                                if (strArrSplit[4].equals("fo")) {
                                    c1014l.addState(new int[]{android.R.attr.state_focused}, ninePatchDrawable2);
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
            c1014l.addState(new int[]{0}, ninePatchDrawable);
        }
        return c1014l;
    }

    /* renamed from: k */
    private static File[] m3954k(Context context, String str) {
        try {
            return m3938a(context, str).listFiles(f3705k);
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        } catch (NullPointerException e2) {
            return null;
        }
    }

    /* renamed from: g */
    public static Drawable m3950g(Context context, String str) {
        if (!m3941a(str)) {
            return m3936a(context, str, m3954k(context, str));
        }
        return context.getResources().getDrawable(((Integer) f3698d.get(str)).intValue());
    }

    /* renamed from: h */
    public static File[] m3951h(Context context, String str) {
        try {
            return m3938a(context, str).listFiles(f3704j);
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        } catch (NullPointerException e2) {
            return null;
        }
    }

    /* renamed from: i */
    public static Drawable m3952i(Context context, String str) {
        if (!m3941a(str)) {
            return m3936a(context, str, m3951h(context, str));
        }
        return context.getResources().getDrawable(((Integer) f3699e.get(str)).intValue());
    }

    /* renamed from: a */
    public static void m3940a(Drawable drawable) {
        if (drawable instanceof C1013k) {
            Bitmap bitmap = ((C1013k) drawable).getBitmap();
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
                return;
            }
            return;
        }
        if (drawable instanceof C1014l) {
            List<Bitmap> listM3957a = ((C1014l) drawable).m3957a();
            for (Bitmap bitmap2 : listM3957a) {
                if (bitmap2 != null && !bitmap2.isRecycled()) {
                    bitmap2.recycle();
                }
            }
            listM3957a.clear();
        }
    }

    /* renamed from: a */
    public static void m3939a(Context context, String str, File file, File file2) throws Throwable {
        try {
            File fileM3938a = m3938a(context, str);
            C1838f.m6232a(context, file, fileM3938a);
            C1838f.m6232a(context, file2, fileM3938a);
            try {
                try {
                    C1000a.m3933a(context, C1000a.m3931a(str, C1816b.m6156a()));
                } catch (RemoteException e) {
                    throw new IOException(e);
                }
            } catch (OperationApplicationException e2) {
                throw new IOException(e2);
            }
        } catch (IOException e3) {
            if (C1825d.f6539a.f6544e) {
                C1825d.f6539a.m6201a(f3695a, e3.getMessage(), e3);
            }
            throw e3;
        }
    }

    /* renamed from: j */
    public static void m3953j(Context context, String str) throws IOException {
        try {
            C1829e.m6209a(m3938a(context, str));
            try {
                try {
                    C1000a.m3933a(context, C1000a.m3930a(str));
                } catch (RemoteException e) {
                    throw new IOException(e);
                }
            } catch (OperationApplicationException e2) {
                throw new IOException(e2);
            }
        } catch (IOException e3) {
            if (C1825d.f6539a.f6544e) {
                C1825d.f6539a.m6201a(f3695a, e3.getMessage(), e3);
            }
            throw e3;
        }
    }

    /* renamed from: b */
    public static List m3943b(Context context) {
        ArrayList arrayList = new ArrayList();
        Skin skin = new Skin();
        skin.f3707id = "-1";
        skin.bgtype = "pa";
        skin.newitem = false;
        skin.special = 0;
        skin.thumbnailurl = C1828c.m6207a("android.resource", "://", context.getPackageName(), "/drawable/default_preview_01");
        skin.expirationdate = Long.MAX_VALUE;
        Skin skin2 = new Skin();
        skin2.f3707id = "-2";
        skin2.bgtype = "pa";
        skin2.newitem = false;
        skin2.special = 0;
        skin2.thumbnailurl = C1828c.m6207a("android.resource", "://", context.getPackageName(), "/drawable/default_preview_02");
        skin2.expirationdate = Long.MAX_VALUE;
        Skin skin3 = new Skin();
        skin3.f3707id = "-3";
        skin3.bgtype = "pa";
        skin3.newitem = false;
        skin3.special = 0;
        skin3.thumbnailurl = C1828c.m6207a("android.resource", "://", context.getPackageName(), "/drawable/default_preview_03");
        skin3.expirationdate = Long.MAX_VALUE;
        Skin skin4 = new Skin();
        skin4.f3707id = "-4";
        skin4.bgtype = "pa";
        skin4.newitem = false;
        skin4.special = 0;
        skin4.thumbnailurl = C1828c.m6207a("android.resource", "://", context.getPackageName(), "/drawable/default_preview_04");
        skin4.expirationdate = Long.MAX_VALUE;
        arrayList.add(skin);
        arrayList.add(skin2);
        arrayList.add(skin3);
        arrayList.add(skin4);
        return arrayList;
    }

    /* renamed from: a */
    public static int m3935a() {
        int i = 240;
        int iM6161d = C1816b.m6161d();
        int iM6162e = C1816b.m6162e();
        if (iM6161d == 240 && iM6162e == 320) {
            i = 56;
        } else if (iM6161d == 320 && iM6162e == 480) {
            i = 75;
        } else if (iM6161d == 480 && iM6162e == 800) {
            i = 112;
        } else if (iM6161d == 800 && iM6162e == 1280) {
            i = 150;
        } else if (iM6161d == 720 && iM6162e == 1280) {
            i = 150;
        } else if (iM6161d == 1280 && iM6162e == 800) {
            i = 120;
        } else if (iM6161d != 2560 || iM6162e != 1600) {
            i = 0;
        }
        if (i == 0) {
            return 150;
        }
        return i;
    }

    /* renamed from: b */
    public static int m3942b() {
        int i = 0;
        int iM6161d = C1816b.m6161d();
        int iM6162e = C1816b.m6162e();
        if (iM6161d == 240 && iM6162e == 320) {
            i = 84;
        } else if (iM6161d == 320 && iM6162e == 480) {
            i = 112;
        } else if (iM6161d == 480 && iM6162e == 800) {
            i = 168;
        } else if (iM6161d == 800 && iM6162e == 1280) {
            i = 224;
        } else if (iM6161d == 720 && iM6162e == 1280) {
            i = 224;
        } else if (iM6161d == 1280 && iM6162e == 800) {
            i = 170;
        } else if (iM6161d == 2560 && iM6162e == 1600) {
            i = 340;
        }
        if (i == 0) {
            return 224;
        }
        return i;
    }

    /* renamed from: c */
    public static int m3945c() {
        return C1789u.m6075a().getInt("new_skin_count", 0);
    }
}
