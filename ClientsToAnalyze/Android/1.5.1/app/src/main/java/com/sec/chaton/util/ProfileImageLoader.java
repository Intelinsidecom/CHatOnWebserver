package com.sec.chaton.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ImageView;
import com.sec.chaton.C0062R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p000io.entry.inner.Buddy;
import com.sec.chaton.util.ServerAddressMgr;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class ProfileImageLoader implements Handler.Callback {

    /* renamed from: a */
    private static ProfileImageLoader f3700a = null;

    /* renamed from: b */
    private final Context f3701b;

    /* renamed from: e */
    private boolean f3704e;

    /* renamed from: f */
    private HandlerThreadC0614l f3705f;

    /* renamed from: c */
    private boolean f3702c = false;

    /* renamed from: d */
    private final int f3703d = C0062R.drawable.contacts_default_image;

    /* renamed from: g */
    private final ConcurrentHashMap f3706g = new ConcurrentHashMap();

    /* renamed from: h */
    private final ConcurrentHashMap f3707h = new ConcurrentHashMap();

    /* renamed from: i */
    private final Handler f3708i = new Handler(Looper.getMainLooper(), this);

    public enum ImageType {
        BUDDY,
        BROADCAST,
        GROUP
    }

    private ProfileImageLoader(Context context) {
        this.f3701b = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.graphics.Bitmap m3607a(android.content.Context r6, java.lang.String r7) throws java.lang.Throwable {
        /*
            r5 = this;
            r3 = 0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r0 = r0.append(r7)
            java.lang.String r1 = ".jpeg_"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.io.File r1 = new java.io.File
            java.io.File r2 = r6.getFilesDir()
            r1.<init>(r2, r0)
            boolean r1 = r1.exists()
            if (r1 != 0) goto L25
            r0 = r3
        L24:
            return r0
        L25:
            java.io.FileInputStream r0 = r6.openFileInput(r0)     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> L62
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeStream(r0)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L7e
            if (r0 == 0) goto L32
            r0.close()     // Catch: java.io.IOException -> L34
        L32:
            r0 = r1
            goto L24
        L34:
            r0 = move-exception
            java.lang.Class r2 = r5.getClass()
            java.lang.String r2 = r2.getSimpleName()
            com.sec.chaton.util.ChatONLogWriter.m3501a(r0, r2)
            goto L32
        L41:
            r0 = move-exception
            r1 = r3
        L43:
            java.lang.Class r2 = r5.getClass()     // Catch: java.lang.Throwable -> L7c
            java.lang.String r2 = r2.getSimpleName()     // Catch: java.lang.Throwable -> L7c
            com.sec.chaton.util.ChatONLogWriter.m3501a(r0, r2)     // Catch: java.lang.Throwable -> L7c
            if (r1 == 0) goto L53
            r1.close()     // Catch: java.io.IOException -> L55
        L53:
            r0 = r3
            goto L24
        L55:
            r0 = move-exception
            java.lang.Class r1 = r5.getClass()
            java.lang.String r1 = r1.getSimpleName()
            com.sec.chaton.util.ChatONLogWriter.m3501a(r0, r1)
            goto L53
        L62:
            r0 = move-exception
            r1 = r3
        L64:
            if (r1 == 0) goto L69
            r1.close()     // Catch: java.io.IOException -> L6a
        L69:
            throw r0
        L6a:
            r1 = move-exception
            java.lang.Class r2 = r5.getClass()
            java.lang.String r2 = r2.getSimpleName()
            com.sec.chaton.util.ChatONLogWriter.m3501a(r1, r2)
            goto L69
        L77:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L64
        L7c:
            r0 = move-exception
            goto L64
        L7e:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L43
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.ProfileImageLoader.m3607a(android.content.Context, java.lang.String):android.graphics.Bitmap");
    }

    /* renamed from: a */
    public static ProfileImageLoader m3610a(Context context) {
        if (f3700a == null) {
            synchronized (ProfileImageLoader.class) {
                f3700a = new ProfileImageLoader(context);
            }
        }
        return f3700a;
    }

    /* renamed from: a */
    public static String m3611a(String str, int i) {
        return ServerAddressMgr.m3630b(ServerAddressMgr.ServerType.PRIMARY) + "/buddy/" + str + "/image/?uid=" + ChatONPref.m3519a().getString("uid", "") + "&imei=" + DeviceInfoUtil.m3564a() + "&size=" + i;
    }

    /* renamed from: a */
    private void m3612a() {
        if (this.f3704e) {
            return;
        }
        this.f3704e = true;
        this.f3708i.sendEmptyMessage(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3615a(ArrayList arrayList, ArrayList arrayList2) {
        arrayList.clear();
        arrayList2.clear();
        for (C0615m c0615m : this.f3707h.values()) {
            C0619q c0619q = (C0619q) this.f3706g.get(c0615m.m3694a());
            if (c0619q != null && c0619q.f3793a == 0) {
                c0619q.f3793a = 1;
                arrayList.add(c0615m);
                arrayList2.add(c0615m);
            }
        }
    }

    /* renamed from: b */
    private EnumC0608f m3616b(ImageView imageView, String str) {
        C0618p c0618p = null;
        C0619q c0619q = (C0619q) this.f3706g.get(str);
        if (c0619q == null) {
            c0619q = new C0619q(c0618p);
            this.f3706g.put(str, c0619q);
        } else if (c0619q.f3793a == 2) {
            if (c0619q.f3794b == null) {
                imageView.setImageResource(m3619d(str));
                return EnumC0608f.CACHED;
            }
            Bitmap bitmap = (Bitmap) c0619q.f3794b.get();
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
                return EnumC0608f.CACHED;
            }
            c0619q.f3794b = null;
        } else if (c0619q.f3793a == 3) {
            return EnumC0608f.ERROR;
        }
        imageView.setImageResource(m3619d(str));
        c0619q.f3793a = 0;
        return EnumC0608f.NO_CACHED;
    }

    /* renamed from: b */
    private void m3617b() {
        Iterator it = this.f3707h.keySet().iterator();
        while (it.hasNext()) {
            ImageView imageView = (ImageView) it.next();
            EnumC0608f enumC0608fM3616b = m3616b(imageView, ((C0615m) this.f3707h.get(imageView)).m3694a());
            if (enumC0608fM3616b == EnumC0608f.CACHED || enumC0608fM3616b == EnumC0608f.ERROR) {
                it.remove();
            }
        }
        if (this.f3707h.isEmpty()) {
            return;
        }
        m3612a();
    }

    /* renamed from: c */
    public static String m3618c(String str) {
        return ServerAddressMgr.m3630b(ServerAddressMgr.ServerType.PRIMARY) + "/buddy/" + str + "/image/?uid=" + ChatONPref.m3519a().getString("uid", "") + "&imei=" + DeviceInfoUtil.m3564a();
    }

    /* renamed from: d */
    private int m3619d(String str) throws NumberFormatException {
        long j = Long.parseLong(str);
        return j % 5 == 0 ? C0062R.drawable.msg_list_id_1 : j % 5 == 1 ? C0062R.drawable.msg_list_id_2 : j % 5 == 2 ? C0062R.drawable.msg_list_id_3 : j % 5 == 3 ? C0062R.drawable.msg_list_id_4 : j % 5 == 4 ? C0062R.drawable.msg_list_id_5 : C0062R.drawable.contacts_default_image;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m3620e(String str) {
        C0619q c0619q = new C0619q(null);
        c0619q.f3793a = 3;
        this.f3706g.put(str, c0619q);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public void m3621a(Bitmap bitmap, String str) throws Throwable {
        FileOutputStream fileOutputStream = null;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                FileOutputStream fileOutputStreamOpenFileOutput = this.f3701b.openFileOutput(str + ".jpeg_", 0);
                try {
                    Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
                    bitmap.compress(compressFormat, 90, fileOutputStreamOpenFileOutput);
                    fileOutputStream = compressFormat;
                    if (fileOutputStreamOpenFileOutput != null) {
                        try {
                            fileOutputStreamOpenFileOutput.close();
                            fileOutputStream = compressFormat;
                        } catch (IOException e) {
                            String simpleName = getClass().getSimpleName();
                            ChatONLogWriter.m3501a(e, simpleName);
                            fileOutputStream = simpleName;
                        }
                    }
                } catch (FileNotFoundException e2) {
                    fileOutputStream2 = fileOutputStreamOpenFileOutput;
                    e = e2;
                    ChatONLogWriter.m3501a(e, getClass().getSimpleName());
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                            fileOutputStream = fileOutputStream2;
                        } catch (IOException e3) {
                            String simpleName2 = getClass().getSimpleName();
                            ChatONLogWriter.m3501a(e3, simpleName2);
                            fileOutputStream = simpleName2;
                        }
                    }
                } catch (Throwable th) {
                    fileOutputStream = fileOutputStreamOpenFileOutput;
                    th = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            ChatONLogWriter.m3501a(e4, getClass().getSimpleName());
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e5) {
                e = e5;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: a */
    public void m3622a(ImageView imageView, ImageType imageType) {
        this.f3707h.remove(imageView);
        switch (C0618p.f3792a[imageType.ordinal()]) {
            case 1:
                imageView.setImageResource(C0062R.drawable.contacts_default_image_cb);
                break;
            case 2:
                imageView.setImageResource(C0062R.drawable.contacts_default_image_group);
                break;
            case 3:
                imageView.setImageResource(C0062R.drawable.contacts_default_image);
                break;
        }
    }

    /* renamed from: a */
    public void m3623a(ImageView imageView, String str) {
        m3624a(imageView, str, Buddy.BuddyImageStatus.NOT_CHANGE.getCode());
    }

    /* renamed from: a */
    public void m3624a(ImageView imageView, String str, int i) {
        EnumC0608f enumC0608fM3616b = m3616b(imageView, str);
        if (enumC0608fM3616b == EnumC0608f.CACHED) {
            this.f3707h.remove(imageView);
            return;
        }
        if (enumC0608fM3616b == EnumC0608f.ERROR) {
            this.f3706g.remove(str);
        }
        this.f3707h.put(imageView, new C0615m(this, str, i));
        if (this.f3702c) {
            return;
        }
        m3612a();
    }

    /* renamed from: a */
    public void m3625a(String str) {
        this.f3706g.remove(str);
        File file = new File(this.f3701b.getFilesDir(), str + ".jpeg_");
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
        File file4 = new File(GlobalApplication.m2387e().getExternalFilesDir(null) + "/profile/", String.format("%s_big.jpeg_", str));
        if (file4.exists()) {
            file4.delete();
        }
    }

    /* renamed from: a */
    public void m3626a(String str, Bitmap bitmap) {
        if (this.f3702c) {
            return;
        }
        C0619q c0619q = new C0619q(null);
        c0619q.f3793a = 2;
        if (bitmap != null) {
            c0619q.f3794b = new SoftReference(bitmap);
        }
        this.f3706g.put(str, c0619q);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00c6 A[Catch: ClientProtocolException -> 0x00cd, IOException -> 0x011c, Exception -> 0x012f, all -> 0x0142, TRY_ENTER, TryCatch #8 {IOException -> 0x011c, blocks: (B:7:0x0031, B:9:0x0079, B:14:0x0095, B:15:0x0098, B:33:0x00c6, B:34:0x00c9, B:35:0x00cc, B:24:0x00b0, B:25:0x00b3, B:44:0x00ec, B:48:0x00ff), top: B:76:0x0031, outer: #3 }] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    com.sec.chaton.common.entry.ImageRequestResult m3627b(java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 348
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.ProfileImageLoader.m3627b(java.lang.String):com.sec.chaton.common.entry.ImageRequestResult");
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.f3704e = false;
                if (!this.f3702c) {
                    if (this.f3705f == null) {
                        this.f3705f = new HandlerThreadC0614l(this, this.f3701b);
                        this.f3705f.start();
                    }
                    this.f3705f.m3693a();
                }
                return true;
            case 2:
                if (!this.f3702c) {
                    m3617b();
                }
                return true;
            default:
                return false;
        }
    }
}
