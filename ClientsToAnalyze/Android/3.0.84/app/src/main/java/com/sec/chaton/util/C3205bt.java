package com.sec.chaton.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.http.AndroidHttpClient;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p027e.C1449q;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.p028a.C1362f;
import com.sec.chaton.p035io.entry.inner.Buddy;
import com.sec.chaton.p037j.C1554c;
import com.sec.chaton.p037j.p039b.C1552a;
import com.sec.chaton.p037j.p039b.C1553b;
import com.sec.chaton.trunk.p061c.C3020a;
import com.sec.common.CommonApplication;
import com.sec.common.util.C3350l;
import com.sec.widget.C3641ai;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.ref.SoftReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpResponse;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;

/* compiled from: ProfileImageLoader.java */
/* renamed from: com.sec.chaton.util.bt */
/* loaded from: classes.dex */
public class C3205bt implements Handler.Callback {

    /* renamed from: a */
    private static C3205bt f11560a = null;

    /* renamed from: j */
    private static Paint f11561j;

    /* renamed from: k */
    private static Paint f11562k;

    /* renamed from: b */
    private final Context f11563b;

    /* renamed from: d */
    private boolean f11565d;

    /* renamed from: e */
    private HandlerThreadC3210by f11566e;

    /* renamed from: f */
    private String f11567f;

    /* renamed from: c */
    private boolean f11564c = false;

    /* renamed from: g */
    private final ConcurrentHashMap<String, C3213ca> f11568g = new ConcurrentHashMap<>();

    /* renamed from: h */
    private final ConcurrentHashMap<ImageView, C3211bz> f11569h = new ConcurrentHashMap<>();

    /* renamed from: i */
    private final Handler f11570i = new Handler(Looper.getMainLooper(), this);

    /* renamed from: l */
    private final int f11571l = 5;

    /* renamed from: m */
    private Bitmap[] f11572m = new Bitmap[5];

    /* renamed from: a */
    public static C3205bt m11182a(Context context) {
        if (f11560a == null) {
            f11560a = new C3205bt(context);
        }
        return f11560a;
    }

    private C3205bt(Context context) {
        this.f11563b = context;
    }

    /* renamed from: e */
    private void m11199e() {
        if (!this.f11565d) {
            this.f11565d = true;
            this.f11570i.sendEmptyMessage(1);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.f11565d = false;
                if (this.f11564c) {
                    return true;
                }
                if (this.f11566e == null) {
                    this.f11566e = new HandlerThreadC3210by(this, this.f11563b);
                    this.f11566e.start();
                }
                this.f11566e.m11238a();
                return true;
            case 2:
                if (this.f11564c) {
                    return true;
                }
                m11200f();
                return true;
            default:
                return false;
        }
    }

    /* renamed from: a */
    public void m11206a() {
        C3250y.m11456e("deleteMeImage ", "ProfileImageLoader");
        this.f11568g.remove(C3159aa.m10962a().m10979a("chaton_id", ""));
        File file = new File(this.f11563b.getFilesDir(), "myprofile.png_");
        if (file.exists()) {
            file.delete();
        }
        File file2 = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "//profile");
        if (file2.exists()) {
            File file3 = new File(file2, String.format("%s_big.jpeg_", "myprofile.png_"));
            if (file3.exists()) {
                file3.delete();
            }
        }
        File file4 = new File(CommonApplication.m11493l().getExternalFilesDir(null) + "/profile/", String.format("%s_big.jpeg_", "myprofile.png_"));
        if (file4.exists()) {
            file4.delete();
        }
        File file5 = new File(C3223ck.m11329c() + "/myprofile.png_/");
        if (file5.exists()) {
            C3350l.m11803a(file5);
        }
    }

    /* renamed from: a */
    public void m11219a(String str, boolean z) throws UnsupportedEncodingException {
        C3250y.m11456e("deleteImage " + str, "ProfileImageLoader");
        this.f11568g.remove(str);
        try {
            str = URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (z) {
            File file = new File(this.f11563b.getFilesDir(), str + "_group_profile.png_");
            if (file.exists()) {
                file.delete();
            }
            File file2 = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "//profile");
            if (file2.exists()) {
                File file3 = new File(file2, String.format("%s_big.jpeg_", str));
                if (file3.exists()) {
                    file3.delete();
                }
            }
            File file4 = new File(CommonApplication.m11493l().getExternalFilesDir(null) + "/profile/", String.format("%s_big.jpeg_", str));
            if (file4.exists()) {
                file4.delete();
            }
            File file5 = new File(C3223ck.m11329c() + "/" + str + "/");
            if (file5.exists()) {
                C3350l.m11803a(file5);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0077  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m11217a(java.lang.String r9, java.lang.String r10) throws java.io.UnsupportedEncodingException {
        /*
            r8 = this;
            r7 = 1
            r6 = 0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "renameImage "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r9)
            java.lang.String r1 = " to "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r10)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "ProfileImageLoader"
            com.sec.chaton.util.C3250y.m11456e(r0, r1)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.sec.chaton.util.ca> r0 = r8.f11568g
            r0.remove(r9)
            java.lang.String r0 = "UTF-8"
            java.lang.String r0 = java.net.URLEncoder.encode(r9, r0)     // Catch: java.io.UnsupportedEncodingException -> L10b
            java.lang.String r1 = "UTF-8"
            java.lang.String r10 = java.net.URLEncoder.encode(r10, r1)     // Catch: java.io.UnsupportedEncodingException -> L113
        L35:
            java.io.File r1 = new java.io.File
            android.content.Context r2 = r8.f11563b
            java.io.File r2 = r2.getFilesDir()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.StringBuilder r3 = r3.append(r0)
            java.lang.String r4 = "_group_profile.png_"
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            r1.<init>(r2, r3)
            java.io.File r2 = new java.io.File
            android.content.Context r3 = r8.f11563b
            java.io.File r3 = r3.getFilesDir()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.StringBuilder r4 = r4.append(r10)
            java.lang.String r5 = "_group_profile.png_"
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r4 = r4.toString()
            r2.<init>(r3, r4)
            boolean r3 = r1.exists()
            if (r3 == 0) goto L7a
            r1.renameTo(r2)
        L7a:
            java.io.File r1 = new java.io.File
            java.io.File r3 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r3 = r3.getAbsolutePath()
            java.lang.String r4 = "//profile"
            r1.<init>(r3, r4)
            boolean r3 = r1.exists()
            if (r3 == 0) goto La7
            java.io.File r3 = new java.io.File
            java.lang.String r4 = "%s_big.jpeg_"
            java.lang.Object[] r5 = new java.lang.Object[r7]
            r5[r6] = r0
            java.lang.String r4 = java.lang.String.format(r4, r5)
            r3.<init>(r1, r4)
            boolean r1 = r3.exists()
            if (r1 == 0) goto La7
            r3.renameTo(r2)
        La7:
            java.io.File r1 = new java.io.File
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            android.content.Context r4 = com.sec.common.CommonApplication.m11493l()
            r5 = 0
            java.io.File r4 = r4.getExternalFilesDir(r5)
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r4 = "/profile/"
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "%s_big.jpeg_"
            java.lang.Object[] r5 = new java.lang.Object[r7]
            r5[r6] = r0
            java.lang.String r4 = java.lang.String.format(r4, r5)
            r1.<init>(r3, r4)
            boolean r3 = r1.exists()
            if (r3 == 0) goto Ldb
            r1.renameTo(r2)
        Ldb:
            java.io.File r1 = new java.io.File
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = com.sec.chaton.util.C3223ck.m11329c()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = "/"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r0 = r2.append(r0)
            java.lang.String r2 = "/"
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            boolean r0 = r1.exists()
            if (r0 == 0) goto L10a
            com.sec.common.util.C3350l.m11803a(r1)
        L10a:
            return
        L10b:
            r0 = move-exception
            r1 = r0
            r0 = r9
        L10e:
            r1.printStackTrace()
            goto L35
        L113:
            r1 = move-exception
            goto L10e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C3205bt.m11217a(java.lang.String, java.lang.String):void");
    }

    /* renamed from: a */
    public boolean m11220a(String str) {
        return this.f11568g.get(str) != null;
    }

    /* renamed from: b */
    public void m11227b(String str) {
        C3250y.m11456e("deleteImage " + str, "ProfileImageLoader");
        this.f11568g.remove(str);
        File file = new File(this.f11563b.getFilesDir(), str + ".jpeg_");
        if (file.exists()) {
            file.delete();
        }
        File file2 = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "//profile");
        if (file2.exists()) {
            File file3 = new File(file2, String.format("%s_big.jpeg_", str));
            if (file3.exists()) {
                file3.delete();
            }
        }
        File file4 = new File(CommonApplication.m11493l().getExternalFilesDir(null) + "/profile/", String.format("%s_big.jpeg_", str));
        if (file4.exists()) {
            file4.delete();
        }
        File file5 = new File(C3223ck.m11329c() + "/" + str + "/");
        if (file5.exists()) {
            C3350l.m11803a(file5);
        }
    }

    @Deprecated
    /* renamed from: b */
    public void m11223b() {
        this.f11564c = true;
    }

    @Deprecated
    /* renamed from: c */
    public void m11229c() {
        this.f11564c = false;
        if (!this.f11569h.isEmpty()) {
            m11199e();
        }
    }

    /* renamed from: a */
    public void m11210a(ImageView imageView, String str) {
        m11211a(imageView, str, Buddy.BuddyImageStatus.NOT_CHANGE.getCode());
    }

    /* renamed from: a */
    public void m11214a(ImageView imageView, String str, boolean z) {
        m11210a(imageView, str);
    }

    /* renamed from: a */
    public void m11211a(ImageView imageView, String str, int i) {
        EnumC3209bx enumC3209bxM11192b = m11192b(imageView, str, false);
        if (enumC3209bxM11192b == EnumC3209bx.CACHED) {
            this.f11569h.remove(imageView);
            return;
        }
        if (enumC3209bxM11192b == EnumC3209bx.ERROR) {
            this.f11568g.remove(str);
        }
        this.f11569h.put(imageView, new C3211bz(this, str, i));
        if (!this.f11564c) {
            m11199e();
        }
    }

    /* renamed from: a */
    public void m11213a(ImageView imageView, String str, String str2, EnumC1450r enumC1450r) {
        m11212a(imageView, str, str2, Buddy.BuddyImageStatus.NOT_CHANGE.getCode(), enumC1450r);
    }

    /* renamed from: a */
    public void m11212a(ImageView imageView, String str, String str2, int i, EnumC1450r enumC1450r) {
        EnumC3209bx enumC3209bxM11183a = m11183a(imageView, str, enumC1450r);
        if (enumC3209bxM11183a == EnumC3209bx.CACHED) {
            this.f11569h.remove(imageView);
            return;
        }
        if (enumC3209bxM11183a == EnumC3209bx.ERROR) {
            this.f11568g.remove(str);
        }
        this.f11569h.put(imageView, new C3211bz(this, str, str2, Buddy.BuddyImageStatus.NOT_CHANGE.getCode(), enumC1450r));
        if (!this.f11564c) {
            m11199e();
        }
    }

    /* renamed from: b */
    public void m11226b(ImageView imageView, String str) {
        EnumC3209bx enumC3209bxM11192b = m11192b(imageView, str, true);
        if (enumC3209bxM11192b == EnumC3209bx.CACHED) {
            this.f11569h.remove(imageView);
            return;
        }
        if (enumC3209bxM11192b == EnumC3209bx.ERROR) {
            this.f11568g.remove(str);
        }
        this.f11569h.put(imageView, new C3211bz(this, str, Buddy.BuddyImageStatus.GROUP_IMAGE.getCode()));
        if (!this.f11564c) {
            m11199e();
        }
    }

    /* renamed from: c */
    public void m11231c(ImageView imageView, String str) {
        EnumC3209bx enumC3209bxM11192b = m11192b(imageView, str, false);
        if (enumC3209bxM11192b == EnumC3209bx.CACHED) {
            this.f11569h.remove(imageView);
            return;
        }
        if (enumC3209bxM11192b == EnumC3209bx.ERROR) {
            this.f11568g.remove(str);
        }
        this.f11569h.put(imageView, new C3211bz(this, str, Buddy.BuddyImageStatus.ME_IMAGE.getCode()));
        if (!this.f11564c) {
            m11199e();
        }
    }

    /* renamed from: a */
    public void m11216a(String str, EnumC1450r enumC1450r) {
        C3213ca c3213ca;
        if (enumC1450r != EnumC1450r.ONETOONE && m11196d(str, enumC1450r) == EnumC3209bx.CACHED && (c3213ca = this.f11568g.get(str)) != null) {
            if (c3213ca.f11596b != null && c3213ca.f11596b.get() != null) {
                c3213ca.f11596b = null;
            }
            this.f11568g.remove(str);
        }
    }

    /* renamed from: a */
    public void m11209a(ImageView imageView, EnumC3208bw enumC3208bw) {
        this.f11569h.remove(imageView);
        switch (C3207bv.f11574a[enumC3208bw.ordinal()]) {
            case 1:
                imageView.setImageBitmap(m11177a(imageView.getContext(), R.drawable.chat_ic_broadcast));
                break;
            case 2:
                imageView.setImageBitmap(m11177a(imageView.getContext(), R.drawable.contacts_default_group));
                break;
            case 3:
                imageView.setImageBitmap(m11177a(imageView.getContext(), R.drawable.contacts_default_01));
                break;
            case 4:
                imageView.setImageBitmap(m11177a(imageView.getContext(), R.drawable.contacts_default_group));
                break;
        }
    }

    /* renamed from: b */
    public void m11225b(ImageView imageView, EnumC3208bw enumC3208bw) {
        this.f11569h.remove(imageView);
        switch (C3207bv.f11574a[enumC3208bw.ordinal()]) {
            case 1:
                imageView.setImageResource(R.drawable.chat_ic_broadcast);
                break;
            case 2:
                imageView.setImageResource(R.drawable.contacts_default_group);
                break;
            case 3:
                imageView.setImageResource(R.drawable.contacts_default_01);
                break;
            case 4:
                imageView.setImageResource(R.drawable.contacts_default_group);
                break;
        }
    }

    /* renamed from: f */
    private void m11200f() {
        EnumC3209bx enumC3209bxM11192b;
        Iterator<ImageView> it = this.f11569h.keySet().iterator();
        while (it.hasNext()) {
            ImageView next = it.next();
            C3211bz c3211bz = this.f11569h.get(next);
            if (c3211bz.f11592c == Buddy.BuddyImageStatus.GROUP_IMAGE.getCode()) {
                enumC3209bxM11192b = m11192b(next, c3211bz.m11240a(), true);
            } else if (!c3211bz.m11242c().equals(EnumC1450r.UNKNOWN)) {
                enumC3209bxM11192b = m11183a(next, c3211bz.m11240a(), c3211bz.m11242c());
            } else {
                enumC3209bxM11192b = m11192b(next, c3211bz.m11240a(), false);
            }
            if (enumC3209bxM11192b == EnumC3209bx.CACHED || enumC3209bxM11192b == EnumC3209bx.ERROR) {
                it.remove();
            }
        }
        if (!this.f11569h.isEmpty()) {
            m11199e();
        }
    }

    /* renamed from: b */
    private EnumC3209bx m11192b(ImageView imageView, String str, boolean z) {
        C3213ca c3213ca = this.f11568g.get(str);
        if (c3213ca == null) {
            c3213ca = new C3213ca(null);
            this.f11568g.put(str, c3213ca);
        } else if (c3213ca.f11595a == 2) {
            if (c3213ca.f11596b == null) {
                imageView.setImageBitmap(m11178a(imageView.getContext(), str, z));
                return EnumC3209bx.CACHED;
            }
            Bitmap bitmap = c3213ca.f11596b.get();
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
                return EnumC3209bx.CACHED;
            }
            c3213ca.f11596b = null;
        } else if (c3213ca.f11595a == 3) {
            imageView.setImageBitmap(m11178a(imageView.getContext(), str, z));
            return EnumC3209bx.ERROR;
        }
        imageView.setImageBitmap(m11178a(imageView.getContext(), str, z));
        c3213ca.f11595a = 0;
        return EnumC3209bx.NO_CACHED;
    }

    /* renamed from: d */
    private EnumC3209bx m11196d(String str, EnumC1450r enumC1450r) {
        C3213ca c3213ca = this.f11568g.get(str);
        if (c3213ca != null && c3213ca.f11595a == 2) {
            if (c3213ca.f11596b != null && c3213ca.f11596b.get() != null) {
                return EnumC3209bx.CACHED;
            }
        } else if (c3213ca != null && c3213ca.f11595a == 3) {
            return EnumC3209bx.ERROR;
        }
        return EnumC3209bx.NO_CACHED;
    }

    /* renamed from: a */
    private EnumC3209bx m11183a(ImageView imageView, String str, EnumC1450r enumC1450r) {
        C3213ca c3213ca = this.f11568g.get(str);
        if (c3213ca == null) {
            c3213ca = new C3213ca(null);
            this.f11568g.put(str, c3213ca);
        } else if (c3213ca.f11595a == 2) {
            if (c3213ca.f11596b == null) {
                imageView.setImageBitmap(m11205a(imageView.getContext(), str, enumC1450r));
                return EnumC3209bx.CACHED;
            }
            Bitmap bitmap = c3213ca.f11596b.get();
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
                return EnumC3209bx.CACHED;
            }
            c3213ca.f11596b = null;
        } else if (c3213ca.f11595a == 3) {
            imageView.setImageBitmap(m11205a(imageView.getContext(), str, enumC1450r));
            return EnumC3209bx.ERROR;
        }
        imageView.setImageBitmap(m11205a(imageView.getContext(), str, enumC1450r));
        c3213ca.f11595a = 0;
        return EnumC3209bx.NO_CACHED;
    }

    /* renamed from: k */
    private static String m11202k(String str) {
        File[] fileArrListFiles = GlobalApplication.m11493l().getFilesDir().listFiles(new C3206bu(str));
        return fileArrListFiles.length == 0 ? "" : fileArrListFiles[0].getName();
    }

    /* renamed from: c */
    public static String m11195c(String str) {
        String strM11202k = m11202k(str);
        if (TextUtils.isEmpty(strM11202k)) {
            return "";
        }
        return strM11202k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v16, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* renamed from: b */
    public Bitmap m11190b(Context context, String str, EnumC1450r enumC1450r) throws Throwable {
        FileInputStream fileInputStreamOpenFileInput;
        Bitmap bitmapDecodeStream;
        String strM11197d = enumC1450r == EnumC1450r.ONETOONE ? m11197d(str) : m11202k(str);
        if (TextUtils.isEmpty(strM11197d)) {
            return null;
        }
        ?? Exists = new File(context.getFilesDir(), strM11197d).exists();
        try {
            if (Exists == 0) {
                return null;
            }
            try {
                fileInputStreamOpenFileInput = context.openFileInput(strM11197d);
            } catch (Exception e) {
                e = e;
                fileInputStreamOpenFileInput = null;
            } catch (OutOfMemoryError e2) {
                e = e2;
                fileInputStreamOpenFileInput = null;
            } catch (Throwable th) {
                th = th;
                Exists = 0;
                if (Exists != 0) {
                    try {
                        Exists.close();
                    } catch (IOException e3) {
                        C3250y.m11443a(e3, getClass().getSimpleName());
                    }
                }
                throw th;
            }
            try {
                bitmapDecodeStream = BitmapFactory.decodeStream(fileInputStreamOpenFileInput);
                Exists = fileInputStreamOpenFileInput;
                if (fileInputStreamOpenFileInput != null) {
                    try {
                        fileInputStreamOpenFileInput.close();
                        Exists = fileInputStreamOpenFileInput;
                    } catch (IOException e4) {
                        String simpleName = getClass().getSimpleName();
                        C3250y.m11443a(e4, simpleName);
                        Exists = simpleName;
                    }
                }
            } catch (Exception e5) {
                e = e5;
                C3250y.m11443a(e, getClass().getSimpleName());
                FileInputStream fileInputStream = fileInputStreamOpenFileInput;
                if (fileInputStreamOpenFileInput != null) {
                    try {
                        fileInputStreamOpenFileInput.close();
                        fileInputStream = fileInputStreamOpenFileInput;
                    } catch (IOException e6) {
                        ?? simpleName2 = getClass().getSimpleName();
                        C3250y.m11443a(e6, (String) simpleName2);
                        fileInputStream = simpleName2;
                    }
                }
                bitmapDecodeStream = null;
                Exists = fileInputStream;
                return bitmapDecodeStream;
            } catch (OutOfMemoryError e7) {
                e = e7;
                C3641ai.m13210a(CommonApplication.m11493l(), R.string.chat_view_memory_error, 0).show();
                C3250y.m11443a(e, getClass().getSimpleName());
                FileInputStream fileInputStream2 = fileInputStreamOpenFileInput;
                if (fileInputStreamOpenFileInput != null) {
                    try {
                        fileInputStreamOpenFileInput.close();
                        fileInputStream2 = fileInputStreamOpenFileInput;
                    } catch (IOException e8) {
                        ?? simpleName3 = getClass().getSimpleName();
                        C3250y.m11443a(e8, (String) simpleName3);
                        fileInputStream2 = simpleName3;
                    }
                }
                bitmapDecodeStream = null;
                Exists = fileInputStream2;
                return bitmapDecodeStream;
            }
            return bitmapDecodeStream;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11188a(ArrayList<C3211bz> arrayList, ArrayList<C3211bz> arrayList2) {
        arrayList.clear();
        arrayList2.clear();
        for (C3211bz c3211bz : this.f11569h.values()) {
            C3213ca c3213ca = this.f11568g.get(c3211bz.m11240a());
            if (c3213ca != null && c3213ca.f11595a == 0) {
                c3213ca.f11595a = 1;
                arrayList.add(c3211bz);
                arrayList2.add(c3211bz);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* renamed from: a */
    public Bitmap m11204a(Context context, String str) {
        FileInputStream fileInputStreamOpenFileInput;
        String simpleName;
        Bitmap bitmapDecodeStream = null;
        if (str.indexOf("myprofile.png_") != -1) {
            str = str + "myprofile.png_";
        } else if (str.indexOf("_group_profile.png_") == -1) {
            str = m11197d(str);
        }
        ?? filesDir = context.getFilesDir();
        try {
            if (new File((File) filesDir, str).exists()) {
                try {
                    fileInputStreamOpenFileInput = context.openFileInput(str);
                } catch (Exception e) {
                    e = e;
                    fileInputStreamOpenFileInput = null;
                } catch (OutOfMemoryError e2) {
                    e = e2;
                    fileInputStreamOpenFileInput = null;
                } catch (Throwable th) {
                    filesDir = 0;
                    th = th;
                    if (filesDir != 0) {
                        try {
                            filesDir.close();
                        } catch (IOException e3) {
                            C3250y.m11443a(e3, getClass().getSimpleName());
                        }
                    }
                    throw th;
                }
                try {
                    bitmapDecodeStream = BitmapFactory.decodeStream(fileInputStreamOpenFileInput);
                    filesDir = fileInputStreamOpenFileInput;
                    if (fileInputStreamOpenFileInput != null) {
                        try {
                            fileInputStreamOpenFileInput.close();
                            filesDir = fileInputStreamOpenFileInput;
                        } catch (IOException e4) {
                            e = e4;
                            simpleName = getClass().getSimpleName();
                            C3250y.m11443a(e, simpleName);
                            return bitmapDecodeStream;
                        }
                    }
                } catch (Exception e5) {
                    e = e5;
                    C3250y.m11443a(e, getClass().getSimpleName());
                    filesDir = fileInputStreamOpenFileInput;
                    if (fileInputStreamOpenFileInput != null) {
                        try {
                            fileInputStreamOpenFileInput.close();
                            filesDir = fileInputStreamOpenFileInput;
                        } catch (IOException e6) {
                            e = e6;
                            simpleName = getClass().getSimpleName();
                            C3250y.m11443a(e, simpleName);
                            return bitmapDecodeStream;
                        }
                    }
                    return bitmapDecodeStream;
                } catch (OutOfMemoryError e7) {
                    e = e7;
                    C3641ai.m13210a(CommonApplication.m11493l(), R.string.chat_view_memory_error, 0).show();
                    C3250y.m11443a(e, getClass().getSimpleName());
                    filesDir = fileInputStreamOpenFileInput;
                    if (fileInputStreamOpenFileInput != null) {
                        try {
                            fileInputStreamOpenFileInput.close();
                            filesDir = fileInputStreamOpenFileInput;
                        } catch (IOException e8) {
                            e = e8;
                            simpleName = getClass().getSimpleName();
                            C3250y.m11443a(e, simpleName);
                            return bitmapDecodeStream;
                        }
                    }
                    return bitmapDecodeStream;
                }
            }
            return bitmapDecodeStream;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v13, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v17, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* renamed from: b */
    public Bitmap m11221b(Context context, String str) {
        FileInputStream fileInputStreamOpenFileInput;
        Bitmap bitmapDecodeStream;
        String strEncode = str + "_group_profile.png_";
        try {
            strEncode = URLEncoder.encode(strEncode, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, getClass().getSimpleName());
            }
        }
        ?? Exists = new File(context.getFilesDir(), strEncode).exists();
        try {
            if (Exists == 0) {
                return null;
            }
            try {
                fileInputStreamOpenFileInput = context.openFileInput(strEncode);
            } catch (Exception e2) {
                e = e2;
                fileInputStreamOpenFileInput = null;
            } catch (OutOfMemoryError e3) {
                e = e3;
                fileInputStreamOpenFileInput = null;
            } catch (Throwable th) {
                th = th;
                Exists = 0;
                if (Exists != 0) {
                    try {
                        Exists.close();
                    } catch (IOException e4) {
                        C3250y.m11443a(e4, getClass().getSimpleName());
                    }
                }
                throw th;
            }
            try {
                bitmapDecodeStream = BitmapFactory.decodeStream(fileInputStreamOpenFileInput);
                Exists = fileInputStreamOpenFileInput;
                if (fileInputStreamOpenFileInput != null) {
                    try {
                        fileInputStreamOpenFileInput.close();
                        Exists = fileInputStreamOpenFileInput;
                    } catch (IOException e5) {
                        String simpleName = getClass().getSimpleName();
                        C3250y.m11443a(e5, simpleName);
                        Exists = simpleName;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                C3250y.m11443a(e, getClass().getSimpleName());
                FileInputStream fileInputStream = fileInputStreamOpenFileInput;
                if (fileInputStreamOpenFileInput != null) {
                    try {
                        fileInputStreamOpenFileInput.close();
                        fileInputStream = fileInputStreamOpenFileInput;
                    } catch (IOException e7) {
                        ?? simpleName2 = getClass().getSimpleName();
                        C3250y.m11443a(e7, (String) simpleName2);
                        fileInputStream = simpleName2;
                    }
                }
                bitmapDecodeStream = null;
                Exists = fileInputStream;
                return bitmapDecodeStream;
            } catch (OutOfMemoryError e8) {
                e = e8;
                C3641ai.m13210a(CommonApplication.m11493l(), R.string.chat_view_memory_error, 0).show();
                C3250y.m11443a(e, getClass().getSimpleName());
                FileInputStream fileInputStream2 = fileInputStreamOpenFileInput;
                if (fileInputStreamOpenFileInput != null) {
                    try {
                        fileInputStreamOpenFileInput.close();
                        fileInputStream2 = fileInputStreamOpenFileInput;
                    } catch (IOException e9) {
                        ?? simpleName3 = getClass().getSimpleName();
                        C3250y.m11443a(e9, (String) simpleName3);
                        fileInputStream2 = simpleName3;
                    }
                }
                bitmapDecodeStream = null;
                Exists = fileInputStream2;
                return bitmapDecodeStream;
            }
            return bitmapDecodeStream;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: a */
    public void m11218a(String str, String str2, String str3) {
        String strM6590a;
        File absoluteFile = GlobalApplication.m11493l().getFilesDir().getAbsoluteFile();
        String str4 = "tmp_" + System.currentTimeMillis() + ".jpeg_";
        File file = new File(absoluteFile, m11194b(str, str4));
        if (C3159aa.m10962a().m10977a("is_file_server_primary ", (Boolean) true).booleanValue()) {
            strM6590a = C1554c.m6590a(EnumC3218cf.PRIMARY, EnumC3219cg.FILE);
        } else {
            strM6590a = C1554c.m6590a(EnumC3218cf.SECONDARY, EnumC3219cg.FILE);
        }
        String str5 = String.format("%s%s?%s=%s&%s=%s&%s=%s&%s=%s", strM6590a, "/profileimage", "uid", C3159aa.m10962a().m10979a("uid", ""), "imei", C3171am.m11045a(), "size", 160, "filename", str4);
        ContentValues contentValues = new ContentValues();
        C3250y.m11450b("setGroupChatImage()", getClass().getSimpleName());
        if (!file.exists()) {
            String strM6073e = "";
            if (!TextUtils.isEmpty(str2)) {
                strM6073e = C1362f.m6073e(GlobalApplication.m6447a().getContentResolver(), str2);
            }
            File file2 = new File(this.f11563b.getFilesDir(), m11198e(strM6073e));
            if (file2.exists()) {
                C3020a.m10525a(file2, file);
                contentValues.put("profile_url", str5);
                GlobalApplication.m11493l().getContentResolver().update(C1449q.f5381a, contentValues, "inbox_no='" + str + "'", null);
            }
        }
    }

    /* renamed from: b */
    public static String m11194b(String str, String str2) {
        String str3 = str + "_chat_profile.png_." + str2;
        try {
            return URLEncoder.encode(str3, "UTF-8");
        } catch (Exception e) {
            return str3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* renamed from: b */
    public Bitmap m11189b(Context context) throws Throwable {
        FileInputStream fileInputStreamOpenFileInput;
        String simpleName;
        Bitmap bitmapDecodeStream = null;
        ?? Exists = new File(context.getFilesDir(), "myprofile.png_").exists();
        try {
            if (Exists != 0) {
                try {
                    fileInputStreamOpenFileInput = context.openFileInput("myprofile.png_");
                } catch (Exception e) {
                    e = e;
                    fileInputStreamOpenFileInput = null;
                } catch (OutOfMemoryError e2) {
                    e = e2;
                    fileInputStreamOpenFileInput = null;
                } catch (Throwable th) {
                    Exists = 0;
                    th = th;
                    if (Exists != 0) {
                        try {
                            Exists.close();
                        } catch (IOException e3) {
                            C3250y.m11443a(e3, getClass().getSimpleName());
                        }
                    }
                    throw th;
                }
                try {
                    bitmapDecodeStream = BitmapFactory.decodeStream(fileInputStreamOpenFileInput);
                    Exists = fileInputStreamOpenFileInput;
                    if (fileInputStreamOpenFileInput != null) {
                        try {
                            fileInputStreamOpenFileInput.close();
                            Exists = fileInputStreamOpenFileInput;
                        } catch (IOException e4) {
                            e = e4;
                            simpleName = getClass().getSimpleName();
                            C3250y.m11443a(e, simpleName);
                            return bitmapDecodeStream;
                        }
                    }
                } catch (Exception e5) {
                    e = e5;
                    C3250y.m11443a(e, getClass().getSimpleName());
                    Exists = fileInputStreamOpenFileInput;
                    if (fileInputStreamOpenFileInput != null) {
                        try {
                            fileInputStreamOpenFileInput.close();
                            Exists = fileInputStreamOpenFileInput;
                        } catch (IOException e6) {
                            e = e6;
                            simpleName = getClass().getSimpleName();
                            C3250y.m11443a(e, simpleName);
                            return bitmapDecodeStream;
                        }
                    }
                    return bitmapDecodeStream;
                } catch (OutOfMemoryError e7) {
                    e = e7;
                    C3641ai.m13210a(CommonApplication.m11493l(), R.string.chat_view_memory_error, 0).show();
                    C3250y.m11443a(e, getClass().getSimpleName());
                    Exists = fileInputStreamOpenFileInput;
                    if (fileInputStreamOpenFileInput != null) {
                        try {
                            fileInputStreamOpenFileInput.close();
                            Exists = fileInputStreamOpenFileInput;
                        } catch (IOException e8) {
                            e = e8;
                            simpleName = getClass().getSimpleName();
                            C3250y.m11443a(e, simpleName);
                            return bitmapDecodeStream;
                        }
                    }
                    return bitmapDecodeStream;
                }
            }
            return bitmapDecodeStream;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: d */
    public static String m11197d(String str) {
        return str + ".jpeg_";
    }

    /* renamed from: e */
    public static String m11198e(String str) {
        return str + "_group_profile.png_";
    }

    /* renamed from: a */
    public void m11208a(Bitmap bitmap, String str) throws IOException {
        String simpleName;
        String strEncode = str + "_group_profile.png_";
        try {
            strEncode = URLEncoder.encode(strEncode, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, getClass().getSimpleName());
            }
        }
        FileOutputStream fileOutputStreamOpenFileOutput = null;
        try {
            try {
                fileOutputStreamOpenFileOutput = CommonApplication.m11493l().openFileOutput(strEncode, 0);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStreamOpenFileOutput);
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (IOException e2) {
                        e = e2;
                        simpleName = getClass().getSimpleName();
                        C3250y.m11443a(e, simpleName);
                    }
                }
            } catch (FileNotFoundException e3) {
                C3250y.m11443a(e3, getClass().getSimpleName());
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (IOException e4) {
                        e = e4;
                        simpleName = getClass().getSimpleName();
                        C3250y.m11443a(e, simpleName);
                    }
                }
            }
        } catch (Throwable th) {
            if (fileOutputStreamOpenFileOutput != null) {
                try {
                    fileOutputStreamOpenFileOutput.close();
                } catch (IOException e5) {
                    C3250y.m11443a(e5, getClass().getSimpleName());
                }
            }
            throw th;
        }
    }

    /* renamed from: a */
    public void m11207a(Bitmap bitmap) throws IOException {
        String simpleName;
        FileOutputStream fileOutputStreamOpenFileOutput = null;
        try {
            try {
                fileOutputStreamOpenFileOutput = CommonApplication.m11493l().openFileOutput("myprofile.png_", 0);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStreamOpenFileOutput);
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (IOException e) {
                        e = e;
                        simpleName = getClass().getSimpleName();
                        C3250y.m11443a(e, simpleName);
                    }
                }
            } catch (FileNotFoundException e2) {
                C3250y.m11443a(e2, getClass().getSimpleName());
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (IOException e3) {
                        e = e3;
                        simpleName = getClass().getSimpleName();
                        C3250y.m11443a(e, simpleName);
                    }
                }
            }
        } catch (Throwable th) {
            if (fileOutputStreamOpenFileOutput != null) {
                try {
                    fileOutputStreamOpenFileOutput.close();
                } catch (IOException e4) {
                    C3250y.m11443a(e4, getClass().getSimpleName());
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00ea A[Catch: IllegalArgumentException -> 0x00f1, ClientProtocolException -> 0x0138, IOException -> 0x0148, Exception -> 0x0158, all -> 0x0168, TRY_ENTER, TryCatch #6 {Exception -> 0x0158, blocks: (B:9:0x0037, B:11:0x007f, B:16:0x009b, B:17:0x009e, B:42:0x00ea, B:43:0x00ed, B:44:0x00f0, B:33:0x00d4, B:34:0x00d7, B:54:0x0110, B:59:0x0124), top: B:93:0x0037, outer: #5 }] */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    com.sec.chaton.p016a.p017a.C0271h m11233f(java.lang.String r9) throws java.io.UnsupportedEncodingException {
        /*
            Method dump skipped, instructions count: 384
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C3205bt.m11233f(java.lang.String):com.sec.chaton.a.a.h");
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00de A[Catch: IllegalArgumentException -> 0x00e5, ClientProtocolException -> 0x012c, IOException -> 0x013c, Exception -> 0x014c, all -> 0x015c, TRY_ENTER, TryCatch #6 {ClientProtocolException -> 0x012c, blocks: (B:8:0x0031, B:10:0x0079, B:15:0x0095, B:16:0x0098, B:39:0x00de, B:40:0x00e1, B:41:0x00e4, B:30:0x00c8, B:31:0x00cb, B:51:0x0104, B:56:0x0118), top: B:88:0x0031, outer: #4 }] */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    com.sec.chaton.p016a.p017a.C0271h m11232d() {
        /*
            Method dump skipped, instructions count: 372
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C3205bt.m11232d():com.sec.chaton.a.a.h");
    }

    /* renamed from: b */
    public void m11224b(Bitmap bitmap, String str) throws IOException {
        String simpleName;
        FileOutputStream fileOutputStreamOpenFileOutput = null;
        try {
            try {
                fileOutputStreamOpenFileOutput = this.f11563b.openFileOutput(str + ".jpeg_", 0);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStreamOpenFileOutput);
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (IOException e) {
                        e = e;
                        simpleName = getClass().getSimpleName();
                        C3250y.m11443a(e, simpleName);
                    }
                }
            } catch (FileNotFoundException e2) {
                C3250y.m11443a(e2, getClass().getSimpleName());
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (IOException e3) {
                        e = e3;
                        simpleName = getClass().getSimpleName();
                        C3250y.m11443a(e, simpleName);
                    }
                }
            }
        } catch (Throwable th) {
            if (fileOutputStreamOpenFileOutput != null) {
                try {
                    fileOutputStreamOpenFileOutput.close();
                } catch (IOException e4) {
                    C3250y.m11443a(e4, getClass().getSimpleName());
                }
            }
            throw th;
        }
    }

    /* renamed from: c */
    public void m11230c(Bitmap bitmap, String str) throws IOException {
        String simpleName;
        FileOutputStream fileOutputStreamOpenFileOutput = null;
        try {
            try {
                fileOutputStreamOpenFileOutput = this.f11563b.openFileOutput(str + "_chat_profile.png_." + this.f11567f.split("&filename=")[1], 0);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStreamOpenFileOutput);
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (IOException e) {
                        e = e;
                        simpleName = getClass().getSimpleName();
                        C3250y.m11443a(e, simpleName);
                    }
                }
            } catch (FileNotFoundException e2) {
                C3250y.m11443a(e2, getClass().getSimpleName());
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (IOException e3) {
                        e = e3;
                        simpleName = getClass().getSimpleName();
                        C3250y.m11443a(e, simpleName);
                    }
                }
            }
        } catch (Throwable th) {
            if (fileOutputStreamOpenFileOutput != null) {
                try {
                    fileOutputStreamOpenFileOutput.close();
                } catch (IOException e4) {
                    C3250y.m11443a(e4, getClass().getSimpleName());
                }
            }
            throw th;
        }
    }

    /* renamed from: g */
    public String m11234g(String str) {
        String str2 = null;
        Cursor cursorQuery = CommonApplication.m11493l().getContentResolver().query(C1449q.f5381a, null, "inbox_no=?", new String[]{str}, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.moveToFirst();
            String string = cursorQuery.getString(cursorQuery.getColumnIndex("profile_url"));
            String strM11202k = m11202k(str);
            if (TextUtils.isEmpty(strM11202k) || TextUtils.isEmpty(string) || !string.equals(strM11202k)) {
                str2 = string;
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00c0 A[Catch: ClientProtocolException -> 0x00c7, IOException -> 0x014a, Exception -> 0x015b, all -> 0x016c, TRY_ENTER, TryCatch #7 {ClientProtocolException -> 0x00c7, IOException -> 0x014a, Exception -> 0x015b, blocks: (B:13:0x002b, B:15:0x0073, B:20:0x008f, B:21:0x0092, B:39:0x00c0, B:40:0x00c3, B:41:0x00c6, B:30:0x00aa, B:31:0x00ad, B:51:0x00e6, B:56:0x00fa, B:67:0x0136, B:62:0x0122), top: B:94:0x002b, outer: #4 }] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    com.sec.chaton.p016a.p017a.C0271h m11222b(java.lang.String r9, com.sec.chaton.p027e.EnumC1450r r10) {
        /*
            Method dump skipped, instructions count: 389
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C3205bt.m11222b(java.lang.String, com.sec.chaton.e.r):com.sec.chaton.a.a.h");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00c6 A[Catch: ClientProtocolException -> 0x00cd, IOException -> 0x0150, Exception -> 0x0161, all -> 0x0172, TRY_ENTER, TryCatch #5 {IOException -> 0x0150, blocks: (B:7:0x0031, B:9:0x0079, B:14:0x0095, B:15:0x0098, B:33:0x00c6, B:34:0x00c9, B:35:0x00cc, B:24:0x00b0, B:25:0x00b3, B:45:0x00ec, B:50:0x0100, B:61:0x013c, B:56:0x0128), top: B:88:0x0031, outer: #1 }] */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    com.sec.chaton.p016a.p017a.C0271h m11235h(java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 395
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C3205bt.m11235h(java.lang.String):com.sec.chaton.a.a.h");
    }

    /* renamed from: a */
    private int m11176a(HttpResponse httpResponse) throws IOException {
        if (httpResponse.getEntity() == null) {
            return -1;
        }
        try {
            InputStream ungzippedContent = AndroidHttpClient.getUngzippedContent(httpResponse.getEntity());
            if (ungzippedContent == null) {
                return -1;
            }
            String strM6591a = C1554c.m6591a(ungzippedContent);
            C3250y.m11456e("errorMessage : " + strM6591a, "ProfileImageLoader");
            return C1552a.m6587a(C1553b.m6588a(strM6591a));
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /* renamed from: a */
    public void m11215a(String str, Bitmap bitmap) {
        if (!this.f11564c) {
            C3213ca c3213ca = new C3213ca(null);
            c3213ca.f11595a = 2;
            if (bitmap != null) {
                c3213ca.f11596b = new SoftReference<>(bitmap);
            }
            this.f11568g.put(str, c3213ca);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m11203l(String str) {
        C3213ca c3213ca = new C3213ca(null);
        c3213ca.f11595a = 3;
        this.f11568g.put(str, c3213ca);
    }

    /* renamed from: a */
    public static String m11184a(int i) {
        String str = C3216cd.m11287d(EnumC3218cf.PRIMARY) + "/profileimage?uid=" + C3159aa.m10962a().m10979a("uid", "") + "&imei=" + C3171am.m11045a();
        if (i > 0) {
            return str + "&size=" + i;
        }
        return str;
    }

    /* renamed from: a */
    public static String m11185a(String str, int i) {
        String str2 = C3216cd.m11287d(EnumC3218cf.PRIMARY) + "/buddy/group/" + str + "/image/?uid=" + C3159aa.m10962a().m10979a("uid", "") + "&imei=" + C3171am.m11045a();
        if (i > 0) {
            return str2 + "&size=" + i;
        }
        return str2;
    }

    /* renamed from: b */
    public static String m11193b(String str, int i) {
        String str2 = C3216cd.m11282b(EnumC3218cf.PRIMARY) + "/check/" + str + "/image/?uid=" + C3159aa.m10962a().m10979a("uid", "") + "&imei=" + C3171am.m11045a() + "&" + RtspHeaders.Values.MODE + "=nonbuddy";
        if (i > 0) {
            return str2 + "&size=" + i;
        }
        return str2;
    }

    /* renamed from: i */
    public static String m11201i(String str) {
        return m11193b(str, -1);
    }

    /* renamed from: b */
    public static Bitmap m11191b(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        RectF rectF = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
        float width = (float) (bitmap.getWidth() * 0.06d);
        if (f11561j == null) {
            f11561j = new Paint();
            f11561j.setAntiAlias(true);
            f11561j.setColor(-12434878);
            f11562k = new Paint(f11561j);
            f11562k.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        }
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawRoundRect(rectF, width, width, f11561j);
        canvas.drawBitmap(bitmap, (Rect) null, rectF, f11562k);
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    /* renamed from: a */
    public static Bitmap m11177a(Context context, int i) {
        return m11191b(BitmapFactory.decodeResource(context.getResources(), i));
    }

    /* renamed from: a */
    private Bitmap m11178a(Context context, String str, boolean z) {
        char c = 0;
        int i = R.drawable.contacts_default_01;
        if (z) {
            c = 1;
            i = R.drawable.contacts_default_group;
        }
        if (this.f11572m[c] == null) {
            this.f11572m[c] = BitmapFactory.decodeResource(context.getResources(), i);
        }
        return this.f11572m[c];
    }

    /* renamed from: a */
    public Bitmap m11205a(Context context, String str, EnumC1450r enumC1450r) {
        int i = R.drawable.contacts_default_01;
        char c = 0;
        Bitmap bitmapM11228c = m11228c(str, enumC1450r);
        if (bitmapM11228c != null) {
            return bitmapM11228c;
        }
        switch (C3207bv.f11575b[enumC1450r.ordinal()]) {
            case 2:
                c = 1;
                i = R.drawable.contacts_default_group;
                break;
            case 3:
            case 4:
                c = 2;
                i = R.drawable.chat_ic_broadcast;
                break;
        }
        if (this.f11572m[c] == null) {
            this.f11572m[c] = BitmapFactory.decodeResource(context.getResources(), i);
        }
        return this.f11572m[c];
    }

    /* renamed from: c */
    public Bitmap m11228c(String str, EnumC1450r enumC1450r) {
        return m11190b(this.f11563b, str, enumC1450r);
    }

    /* renamed from: j */
    public Bitmap m11236j(String str) {
        C3213ca c3213ca = this.f11568g.get(str);
        if (c3213ca != null && c3213ca.f11595a == 2 && c3213ca.f11596b != null && c3213ca.f11596b.get() != null) {
            return c3213ca.f11596b.get();
        }
        Bitmap bitmapM11204a = m11204a(CommonApplication.m11493l(), str);
        if (bitmapM11204a == null) {
            return null;
        }
        return bitmapM11204a;
    }
}
