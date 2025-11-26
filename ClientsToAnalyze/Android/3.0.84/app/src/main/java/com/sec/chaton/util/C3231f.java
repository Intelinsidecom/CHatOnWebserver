package com.sec.chaton.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.net.http.AndroidHttpClient;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.buddy.C0699fj;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p037j.C1554c;
import com.sec.chaton.p037j.p039b.C1552a;
import com.sec.chaton.p037j.p039b.C1553b;
import com.sec.common.CommonApplication;
import com.sec.common.util.C3350l;
import com.sec.widget.C3641ai;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpResponse;

/* compiled from: BuddyProfileImageLoader.java */
/* renamed from: com.sec.chaton.util.f */
/* loaded from: classes.dex */
public class C3231f implements Handler.Callback {

    /* renamed from: a */
    private static C3231f f11665a = null;

    /* renamed from: k */
    private static Paint f11666k;

    /* renamed from: l */
    private static Paint f11667l;

    /* renamed from: b */
    private final Context f11668b;

    /* renamed from: f */
    private boolean f11672f;

    /* renamed from: g */
    private HandlerThreadC3236k f11673g;

    /* renamed from: c */
    private final String f11669c = "list.txt";

    /* renamed from: d */
    private final String f11670d = "timestamp.txt";

    /* renamed from: e */
    private boolean f11671e = false;

    /* renamed from: h */
    private final ConcurrentHashMap<String, C3233h> f11674h = new ConcurrentHashMap<>();

    /* renamed from: i */
    private final ConcurrentHashMap<ImageView, C3237l> f11675i = new ConcurrentHashMap<>();

    /* renamed from: j */
    private final Handler f11676j = new Handler(Looper.getMainLooper(), this);

    /* renamed from: m */
    private final int f11677m = 5;

    /* renamed from: n */
    private Bitmap[] f11678n = new Bitmap[5];

    /* renamed from: a */
    public static C3231f m11361a(Context context) {
        if (f11665a == null) {
            f11665a = new C3231f(context);
        }
        return f11665a;
    }

    private C3231f(Context context) {
        this.f11668b = context;
    }

    /* renamed from: a */
    private void m11364a() {
        if (!this.f11672f) {
            this.f11672f = true;
            this.f11676j.sendEmptyMessage(1);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.f11672f = false;
                if (this.f11671e) {
                    return true;
                }
                if (this.f11673g == null) {
                    this.f11673g = new HandlerThreadC3236k(this, this.f11668b);
                    this.f11673g.start();
                }
                this.f11673g.m11392a();
                return true;
            case 2:
                if (this.f11671e) {
                    return true;
                }
                m11371b();
                return true;
            default:
                return false;
        }
    }

    /* renamed from: a */
    public void m11381a(String str) throws Throwable {
        ArrayList<HashMap<String, String>> arrayListM11389d = m11389d(str);
        if (arrayListM11389d.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayListM11389d.size()) {
                    HashMap<String, String> map = arrayListM11389d.get(i2);
                    if (map.containsKey("0")) {
                        String str2 = map.get("0");
                        File file = new File(this.f11668b.getCacheDir() + "/" + str + "/" + str2);
                        if (file.exists()) {
                            file.delete();
                        }
                        String str3 = this.f11668b.getCacheDir() + "/profilehistory/" + str + "/";
                        File file2 = new File(str3, "buddy_f_" + str + "_" + str2);
                        if (file2.exists()) {
                            file2.delete();
                        }
                        File file3 = new File(str3, "buddy_t_" + str + "_" + str2);
                        if (file3.exists()) {
                            file3.delete();
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: b */
    public void m11386b(String str) {
        String[] list;
        C3250y.m11456e("deleteImage : " + str, "BuddyProfileImageLoader");
        if (str != null) {
            try {
                this.f11674h.remove(str);
                File file = new File(this.f11668b.getFilesDir(), str + ".jpeg_");
                if (file.exists()) {
                    file.delete();
                }
                File file2 = new File(this.f11668b.getCacheDir() + "/" + str + "/");
                if (file2.exists() && (list = file2.list()) != null) {
                    for (String str2 : list) {
                        File file3 = new File(this.f11668b.getCacheDir() + "/" + str + "/" + str2);
                        if (file3.exists() && !file3.isDirectory()) {
                            file3.delete();
                        }
                    }
                }
                File file4 = new File(this.f11668b.getCacheDir() + "/profilehistory/" + str + "/");
                if (file4.exists()) {
                    C3350l.m11803a(file4);
                }
            } catch (Exception e) {
                C3250y.m11443a(e, getClass().getSimpleName());
            }
        }
    }

    /* renamed from: a */
    public void m11383a(String str, String str2) {
        C3250y.m11456e("deleteImageMain : " + str + ", " + str2, "BuddyProfileImageLoader");
        if (str != null && str2 != null) {
            File file = new File(this.f11668b.getCacheDir() + "/" + str + "/", str2);
            if (file.exists()) {
                file.delete();
            }
            String str3 = this.f11668b.getCacheDir() + "/profilehistory/" + str + "/";
            File file2 = new File(str3, "buddy_f_" + str + "_" + str2);
            if (file2.exists()) {
                file2.delete();
            }
            File file3 = new File(str3, "buddy_t_" + str + "_" + str2);
            if (file3.exists()) {
                file3.delete();
            }
        }
    }

    /* renamed from: a */
    public void m11378a(C0699fj c0699fj, C0699fj c0699fj2, C0699fj c0699fj3, C0699fj c0699fj4, ImageView imageView, String str) {
        m11372b(imageView, str);
        if (!m11374c(c0699fj, c0699fj2, c0699fj3, c0699fj4, str)) {
            Bitmap bitmapM11357a = m11357a(this.f11668b, str);
            if (bitmapM11357a != null) {
                c0699fj.m4339a().setImageBitmap(bitmapM11357a);
            } else {
                c0699fj.m4339a().setImageBitmap(m11369b(c0699fj.m4339a().getContext()));
            }
        }
    }

    /* renamed from: a */
    public void m11379a(C0699fj c0699fj, C0699fj c0699fj2, C0699fj c0699fj3, C0699fj c0699fj4, String str) {
        if (!m11374c(c0699fj, c0699fj2, c0699fj3, c0699fj4, str)) {
            Bitmap bitmapM11357a = m11357a(this.f11668b, str);
            if (bitmapM11357a != null) {
                c0699fj.m4339a().setImageBitmap(bitmapM11357a);
            } else {
                c0699fj.m4339a().setImageBitmap(m11369b(c0699fj.m4339a().getContext()));
            }
        }
    }

    /* renamed from: b */
    public void m11385b(C0699fj c0699fj, C0699fj c0699fj2, C0699fj c0699fj3, C0699fj c0699fj4, String str) {
        if (c0699fj.m4342b() != null) {
            c0699fj.m4339a().setImageBitmap(m11369b(c0699fj.m4339a().getContext()));
            c0699fj.m4341a(false);
        }
        if (c0699fj2.m4342b() != null) {
            c0699fj2.m4339a().setVisibility(8);
            c0699fj2.m4341a(false);
        }
        if (c0699fj3.m4342b() != null) {
            c0699fj3.m4339a().setVisibility(8);
            c0699fj3.m4341a(false);
        }
        if (c0699fj4.m4342b() != null) {
            c0699fj4.m4339a().setVisibility(8);
            c0699fj4.m4341a(false);
        }
        m11386b(str);
    }

    /* renamed from: a */
    public void m11380a(C0699fj c0699fj, C0699fj c0699fj2, C0699fj c0699fj3, String str, int i) {
        if (i == 0) {
            if (c0699fj.m4342b() != null) {
                c0699fj.m4339a().setVisibility(8);
                c0699fj.m4341a(false);
            }
            if (c0699fj2.m4342b() != null) {
                c0699fj2.m4339a().setVisibility(8);
                c0699fj2.m4341a(false);
            }
            if (c0699fj3.m4342b() != null) {
                c0699fj3.m4339a().setVisibility(8);
                c0699fj3.m4341a(false);
                return;
            }
            return;
        }
        if (i == 1) {
            if (c0699fj2.m4342b() != null) {
                c0699fj2.m4339a().setVisibility(8);
                c0699fj2.m4341a(false);
            }
            if (c0699fj3.m4342b() != null) {
                c0699fj3.m4339a().setVisibility(8);
                c0699fj3.m4341a(false);
                return;
            }
            return;
        }
        if (i == 2 && c0699fj3.m4342b() != null) {
            c0699fj3.m4339a().setVisibility(8);
            c0699fj3.m4341a(false);
        }
    }

    /* renamed from: b */
    private void m11371b() {
        Iterator<Map.Entry<ImageView, C3237l>> it = this.f11675i.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<ImageView, C3237l> next = it.next();
            EnumC3235j enumC3235jM11362a = m11362a(next.getKey(), next.getValue().m11393a());
            if (enumC3235jM11362a == EnumC3235j.CACHED || enumC3235jM11362a == EnumC3235j.ERROR) {
                it.remove();
            }
        }
        if (!this.f11675i.isEmpty()) {
            m11364a();
        }
    }

    /* renamed from: a */
    private EnumC3235j m11362a(ImageView imageView, String str) {
        C3233h c3233h = this.f11674h.get(str);
        if (c3233h == null) {
            c3233h = new C3233h(null);
            this.f11674h.put(str, c3233h);
        } else if (c3233h.f11680a == 2) {
            if (c3233h.f11681b == null) {
                imageView.setImageBitmap(m11369b(imageView.getContext()));
                return EnumC3235j.CACHED;
            }
            Bitmap bitmap = c3233h.f11681b.get();
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
                return EnumC3235j.CACHED;
            }
            c3233h.f11681b = null;
        } else if (c3233h.f11680a == 3) {
            return EnumC3235j.ERROR;
        }
        imageView.setImageBitmap(m11369b(imageView.getContext()));
        c3233h.f11680a = 0;
        return EnumC3235j.NO_CACHED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11367a(ArrayList<C3237l> arrayList, ArrayList<C3237l> arrayList2) {
        arrayList.clear();
        arrayList2.clear();
        for (C3237l c3237l : this.f11675i.values()) {
            C3233h c3233h = this.f11674h.get(c3237l.m11393a());
            if (c3233h != null && c3233h.f11680a == 0) {
                c3233h.f11680a = 1;
                arrayList.add(c3237l);
                arrayList2.add(c3237l);
            }
        }
    }

    /* renamed from: b */
    private void m11373b(String str, ArrayList<String> arrayList) {
        File[] fileArrListFiles;
        int length;
        boolean z;
        ArrayList arrayList2 = new ArrayList();
        if (arrayList.size() > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                int iIndexOf = arrayList.get(i).indexOf(":");
                if (iIndexOf > 0) {
                    arrayList2.add(arrayList.get(i).substring(iIndexOf + 1));
                }
            }
            File file = new File(this.f11668b.getCacheDir() + "/" + str + "/");
            if (file.exists() && (fileArrListFiles = file.listFiles()) != null && (length = fileArrListFiles.length) > 0) {
                for (int i2 = 0; i2 < length; i2++) {
                    int i3 = 0;
                    while (true) {
                        if (i3 < arrayList2.size()) {
                            if (!fileArrListFiles[i2].getName().equals(arrayList2.get(i3))) {
                                i3++;
                            } else {
                                z = true;
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (!z) {
                        File file2 = new File(fileArrListFiles[i2].toString());
                        if (file2.exists() && !fileArrListFiles[i2].getName().equals("list.txt") && !fileArrListFiles[i2].getName().equals("timestamp.txt")) {
                            file2.delete();
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void m11384a(String str, ArrayList<String> arrayList) throws Throwable {
        String simpleName;
        String str2 = this.f11668b.getCacheDir() + "/" + str + "/list.txt";
        String str3 = this.f11668b.getCacheDir() + "/" + str + "/";
        File file = new File(str2);
        File file2 = new File(str3);
        BufferedWriter bufferedWriter = null;
        try {
            try {
                if (!file2.exists()) {
                    file2.mkdir();
                    file.createNewFile();
                }
                BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(str2));
                int i = 0;
                while (true) {
                    try {
                        int i2 = i;
                        if (i2 >= arrayList.size()) {
                            break;
                        }
                        bufferedWriter2.write(arrayList.get(i2));
                        bufferedWriter2.newLine();
                        i = i2 + 1;
                    } catch (Exception e) {
                        e = e;
                        bufferedWriter = bufferedWriter2;
                        C3250y.m11443a(e, getClass().getSimpleName());
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (IOException e2) {
                                e = e2;
                                simpleName = getClass().getSimpleName();
                                C3250y.m11443a(e, simpleName);
                                m11373b(str, arrayList);
                            }
                        }
                        m11373b(str, arrayList);
                    } catch (Throwable th) {
                        th = th;
                        bufferedWriter = bufferedWriter2;
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (IOException e3) {
                                C3250y.m11443a(e3, getClass().getSimpleName());
                            }
                        }
                        throw th;
                    }
                }
                if (bufferedWriter2 != null) {
                    try {
                        bufferedWriter2.close();
                    } catch (IOException e4) {
                        e = e4;
                        simpleName = getClass().getSimpleName();
                        C3250y.m11443a(e, simpleName);
                        m11373b(str, arrayList);
                    }
                }
            } catch (Exception e5) {
                e = e5;
            }
            m11373b(str, arrayList);
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: b */
    public void m11387b(String str, String str2) throws Throwable {
        String simpleName;
        String str3 = this.f11668b.getCacheDir() + "/" + str + "/timestamp.txt";
        String str4 = this.f11668b.getCacheDir() + "/" + str + "/";
        File file = new File(str3);
        File file2 = new File(str4);
        BufferedWriter bufferedWriter = null;
        try {
            try {
                if (!file2.exists()) {
                    file2.mkdir();
                }
                if (!file.exists()) {
                    file.createNewFile();
                }
                BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(str3));
                try {
                    bufferedWriter2.write(str2);
                    bufferedWriter2.flush();
                    if (bufferedWriter2 != null) {
                        try {
                            bufferedWriter2.close();
                        } catch (IOException e) {
                            e = e;
                            simpleName = getClass().getSimpleName();
                            C3250y.m11443a(e, simpleName);
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    bufferedWriter = bufferedWriter2;
                    C3250y.m11443a(e, getClass().getSimpleName());
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (IOException e3) {
                            e = e3;
                            simpleName = getClass().getSimpleName();
                            C3250y.m11443a(e, simpleName);
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (IOException e4) {
                            C3250y.m11443a(e4, getClass().getSimpleName());
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e5) {
            e = e5;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x007f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String m11388c(java.lang.String r6) throws java.lang.Throwable {
        /*
            r5 = this;
            r1 = 0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            android.content.Context r2 = r5.f11668b
            java.io.File r2 = r2.getCacheDir()
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r2 = "/"
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.StringBuilder r0 = r0.append(r6)
            java.lang.String r2 = "/"
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r2 = "timestamp.txt"
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.io.File r2 = new java.io.File
            r2.<init>(r0)
            boolean r2 = r2.exists()
            if (r2 == 0) goto L83
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Exception -> L58 java.lang.Throwable -> L7b
            r3.<init>(r0)     // Catch: java.lang.Exception -> L58 java.lang.Throwable -> L7b
            java.io.DataInputStream r2 = new java.io.DataInputStream     // Catch: java.lang.Exception -> L58 java.lang.Throwable -> L7b
            r2.<init>(r3)     // Catch: java.lang.Exception -> L58 java.lang.Throwable -> L7b
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> L9f
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> L9f
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> L9f
            r0.<init>(r3)     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> L9f
            java.lang.String r0 = r0.readLine()     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> L9f
            if (r0 == 0) goto La6
        L4f:
            r2.close()     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La4
            if (r2 == 0) goto L57
            r2.close()     // Catch: java.io.IOException -> L93
        L57:
            return r0
        L58:
            r0 = move-exception
            r2 = r1
            r4 = r0
            r0 = r1
            r1 = r4
        L5d:
            java.lang.Class r3 = r5.getClass()     // Catch: java.lang.Throwable -> L9d
            java.lang.String r3 = r3.getSimpleName()     // Catch: java.lang.Throwable -> L9d
            com.sec.chaton.util.C3250y.m11443a(r1, r3)     // Catch: java.lang.Throwable -> L9d
            if (r2 == 0) goto L57
            r2.close()     // Catch: java.io.IOException -> L6e
            goto L57
        L6e:
            r1 = move-exception
            java.lang.Class r2 = r5.getClass()
            java.lang.String r2 = r2.getSimpleName()
        L77:
            com.sec.chaton.util.C3250y.m11443a(r1, r2)
            goto L57
        L7b:
            r0 = move-exception
            r2 = r1
        L7d:
            if (r2 == 0) goto L82
            r2.close()     // Catch: java.io.IOException -> L86
        L82:
            throw r0
        L83:
            java.lang.String r0 = "0"
            goto L57
        L86:
            r1 = move-exception
            java.lang.Class r2 = r5.getClass()
            java.lang.String r2 = r2.getSimpleName()
            com.sec.chaton.util.C3250y.m11443a(r1, r2)
            goto L82
        L93:
            r1 = move-exception
            java.lang.Class r2 = r5.getClass()
            java.lang.String r2 = r2.getSimpleName()
            goto L77
        L9d:
            r0 = move-exception
            goto L7d
        L9f:
            r0 = move-exception
            r4 = r0
            r0 = r1
            r1 = r4
            goto L5d
        La4:
            r1 = move-exception
            goto L5d
        La6:
            r0 = r1
            goto L4f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C3231f.m11388c(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.String>> m11389d(java.lang.String r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            android.content.Context r1 = r7.f11668b
            java.io.File r1 = r1.getCacheDir()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = "/"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r8)
            java.lang.String r1 = "/"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = "list.txt"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            r2 = 0
            java.io.File r1 = new java.io.File
            r1.<init>(r0)
            boolean r1 = r1.exists()
            if (r1 == 0) goto L88
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> Lc0
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> Lc0
            java.io.DataInputStream r1 = new java.io.DataInputStream     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> Lc0
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> Lc0
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Exception -> L77 java.lang.Throwable -> Lbe
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Exception -> L77 java.lang.Throwable -> Lbe
            r2.<init>(r1)     // Catch: java.lang.Exception -> L77 java.lang.Throwable -> Lbe
            r0.<init>(r2)     // Catch: java.lang.Exception -> L77 java.lang.Throwable -> Lbe
        L4e:
            java.lang.String r2 = r0.readLine()     // Catch: java.lang.Exception -> L77 java.lang.Throwable -> Lbe
            if (r2 == 0) goto L89
            java.lang.String r4 = ":"
            int r4 = r2.indexOf(r4)     // Catch: java.lang.Exception -> L77 java.lang.Throwable -> Lbe
            if (r4 <= 0) goto L4e
            java.util.HashMap r5 = new java.util.HashMap     // Catch: java.lang.Exception -> L77 java.lang.Throwable -> Lbe
            r5.<init>()     // Catch: java.lang.Exception -> L77 java.lang.Throwable -> Lbe
            r6 = 0
            char r6 = r2.charAt(r6)     // Catch: java.lang.Exception -> L77 java.lang.Throwable -> Lbe
            java.lang.String r6 = java.lang.Character.toString(r6)     // Catch: java.lang.Exception -> L77 java.lang.Throwable -> Lbe
            int r4 = r4 + 1
            java.lang.String r2 = r2.substring(r4)     // Catch: java.lang.Exception -> L77 java.lang.Throwable -> Lbe
            r5.put(r6, r2)     // Catch: java.lang.Exception -> L77 java.lang.Throwable -> Lbe
            r3.add(r5)     // Catch: java.lang.Exception -> L77 java.lang.Throwable -> Lbe
            goto L4e
        L77:
            r0 = move-exception
        L78:
            java.lang.Class r2 = r7.getClass()     // Catch: java.lang.Throwable -> Lbe
            java.lang.String r2 = r2.getSimpleName()     // Catch: java.lang.Throwable -> Lbe
            com.sec.chaton.util.C3250y.m11443a(r0, r2)     // Catch: java.lang.Throwable -> Lbe
            if (r1 == 0) goto L88
            r1.close()     // Catch: java.io.IOException -> Lb4
        L88:
            return r3
        L89:
            r1.close()     // Catch: java.lang.Exception -> L77 java.lang.Throwable -> Lbe
            if (r1 == 0) goto L88
            r1.close()     // Catch: java.io.IOException -> L92
            goto L88
        L92:
            r0 = move-exception
            java.lang.Class r1 = r7.getClass()
            java.lang.String r1 = r1.getSimpleName()
        L9b:
            com.sec.chaton.util.C3250y.m11443a(r0, r1)
            goto L88
        L9f:
            r0 = move-exception
            r1 = r2
        La1:
            if (r1 == 0) goto La6
            r1.close()     // Catch: java.io.IOException -> La7
        La6:
            throw r0
        La7:
            r1 = move-exception
            java.lang.Class r2 = r7.getClass()
            java.lang.String r2 = r2.getSimpleName()
            com.sec.chaton.util.C3250y.m11443a(r1, r2)
            goto La6
        Lb4:
            r0 = move-exception
            java.lang.Class r1 = r7.getClass()
            java.lang.String r1 = r1.getSimpleName()
            goto L9b
        Lbe:
            r0 = move-exception
            goto La1
        Lc0:
            r0 = move-exception
            r1 = r2
            goto L78
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C3231f.m11389d(java.lang.String):java.util.ArrayList");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0179  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m11374c(com.sec.chaton.buddy.C0699fj r8, com.sec.chaton.buddy.C0699fj r9, com.sec.chaton.buddy.C0699fj r10, com.sec.chaton.buddy.C0699fj r11, java.lang.String r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 382
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C3231f.m11374c(com.sec.chaton.buddy.fj, com.sec.chaton.buddy.fj, com.sec.chaton.buddy.fj, com.sec.chaton.buddy.fj, java.lang.String):boolean");
    }

    /* renamed from: b */
    private void m11372b(ImageView imageView, String str) throws Resources.NotFoundException {
        int dimensionPixelSize;
        Bitmap bitmapM11012b;
        if (this.f11668b.getResources().getConfiguration().orientation == 1) {
            dimensionPixelSize = this.f11668b.getResources().getDimensionPixelSize(R.dimen.buddy_popup_boddy_height);
        } else {
            dimensionPixelSize = this.f11668b.getResources().getDimensionPixelSize(R.dimen.buddy_popup_whole_width);
        }
        File file = new File(this.f11668b.getCacheDir() + "/" + str + "/coverstory/");
        if (!file.exists()) {
            C3250y.m11450b("loadCoverStoryImages !tmpFile.exists(). loadDefaultCoverStory()", "BuddyProfileImageLoader");
            m11368a(imageView);
            return;
        }
        try {
            bitmapM11012b = C3162ad.m11012b(this.f11668b, Uri.parse(file + "/coverstory.jpg"), dimensionPixelSize);
        } catch (IOException e) {
            e.printStackTrace();
            bitmapM11012b = null;
        }
        if (bitmapM11012b != null) {
            imageView.setImageBitmap(bitmapM11012b);
        } else {
            C3250y.m11450b("loadCoverStoryImages bitmap is null. loadDefaultCoverStory", "BuddyProfileImageLoader");
            m11368a(imageView);
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
    /* renamed from: a */
    public Bitmap m11357a(Context context, String str) throws Throwable {
        FileInputStream fileInputStreamOpenFileInput;
        String simpleName;
        Bitmap bitmapDecodeStream = null;
        String strM11375e = m11375e(str);
        ?? Exists = new File(context.getFilesDir(), strM11375e).exists();
        try {
            if (Exists != 0) {
                try {
                    fileInputStreamOpenFileInput = context.openFileInput(strM11375e);
                    try {
                        bitmapDecodeStream = BitmapFactory.decodeStream(fileInputStreamOpenFileInput);
                        Exists = fileInputStreamOpenFileInput;
                        if (fileInputStreamOpenFileInput != null) {
                            try {
                                fileInputStreamOpenFileInput.close();
                                Exists = fileInputStreamOpenFileInput;
                            } catch (IOException e) {
                                e = e;
                                simpleName = getClass().getSimpleName();
                                C3250y.m11443a(e, simpleName);
                                return bitmapDecodeStream;
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        C3250y.m11443a(e, getClass().getSimpleName());
                        Exists = fileInputStreamOpenFileInput;
                        if (fileInputStreamOpenFileInput != null) {
                            try {
                                fileInputStreamOpenFileInput.close();
                                Exists = fileInputStreamOpenFileInput;
                            } catch (IOException e3) {
                                e = e3;
                                simpleName = getClass().getSimpleName();
                                C3250y.m11443a(e, simpleName);
                                return bitmapDecodeStream;
                            }
                        }
                        return bitmapDecodeStream;
                    } catch (OutOfMemoryError e4) {
                        e = e4;
                        C3641ai.m13210a(CommonApplication.m11493l(), R.string.chat_view_memory_error, 0).show();
                        C3250y.m11443a(e, getClass().getSimpleName());
                        Exists = fileInputStreamOpenFileInput;
                        if (fileInputStreamOpenFileInput != null) {
                            try {
                                fileInputStreamOpenFileInput.close();
                                Exists = fileInputStreamOpenFileInput;
                            } catch (IOException e5) {
                                e = e5;
                                simpleName = getClass().getSimpleName();
                                C3250y.m11443a(e, simpleName);
                                return bitmapDecodeStream;
                            }
                        }
                        return bitmapDecodeStream;
                    }
                } catch (Exception e6) {
                    e = e6;
                    fileInputStreamOpenFileInput = null;
                } catch (OutOfMemoryError e7) {
                    e = e7;
                    fileInputStreamOpenFileInput = null;
                } catch (Throwable th) {
                    Exists = 0;
                    th = th;
                    if (Exists != 0) {
                        try {
                            Exists.close();
                        } catch (IOException e8) {
                            C3250y.m11443a(e8, getClass().getSimpleName());
                        }
                    }
                    throw th;
                }
            }
            return bitmapDecodeStream;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: e */
    public static String m11375e(String str) {
        return str + ".jpeg_";
    }

    /* renamed from: a */
    public void m11377a(Bitmap bitmap, String str) throws IOException {
        String simpleName;
        FileOutputStream fileOutputStreamOpenFileOutput = null;
        try {
            try {
                fileOutputStreamOpenFileOutput = this.f11668b.openFileOutput(str + ".jpeg_", 0);
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

    /* JADX WARN: Removed duplicated region for block: B:33:0x00c6 A[Catch: ClientProtocolException -> 0x00cd, IOException -> 0x0150, Exception -> 0x0161, all -> 0x0172, TRY_ENTER, TryCatch #5 {IOException -> 0x0150, blocks: (B:7:0x0031, B:9:0x0079, B:14:0x0095, B:15:0x0098, B:33:0x00c6, B:34:0x00c9, B:35:0x00cc, B:24:0x00b0, B:25:0x00b3, B:45:0x00ec, B:50:0x0100, B:61:0x013c, B:56:0x0128), top: B:88:0x0031, outer: #1 }] */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    com.sec.chaton.p016a.p017a.C0271h m11390f(java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 395
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C3231f.m11390f(java.lang.String):com.sec.chaton.a.a.h");
    }

    /* renamed from: a */
    private int m11356a(HttpResponse httpResponse) throws IOException {
        if (httpResponse.getEntity() == null) {
            return -1;
        }
        try {
            InputStream ungzippedContent = AndroidHttpClient.getUngzippedContent(httpResponse.getEntity());
            if (ungzippedContent == null) {
                return -1;
            }
            String strM6591a = C1554c.m6591a(ungzippedContent);
            C3250y.m11456e("errorMessage : " + strM6591a, "BuddyProfileImageLoader");
            return C1552a.m6587a(C1553b.m6588a(strM6591a));
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /* renamed from: a */
    public void m11382a(String str, Bitmap bitmap) {
        if (!this.f11671e) {
            C3233h c3233h = new C3233h(null);
            c3233h.f11680a = 2;
            if (bitmap != null) {
                c3233h.f11681b = new SoftReference<>(m11358a(bitmap));
            }
            this.f11674h.put(str, c3233h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m11376g(String str) {
        C3233h c3233h = new C3233h(null);
        c3233h.f11680a = 3;
        this.f11674h.put(str, c3233h);
    }

    /* renamed from: a */
    public static String m11363a(String str, int i) {
        String str2 = C3216cd.m11282b(EnumC3218cf.PRIMARY) + "/check/" + str + "/image/?uid=" + C3159aa.m10962a().m10979a("uid", "") + "&imei=" + C3171am.m11045a();
        if (i > 0) {
            return str2 + "&size=" + i;
        }
        return str2;
    }

    /* renamed from: a */
    public static Bitmap m11358a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            RectF rectF = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
            float width = (float) (bitmap.getWidth() * 0.06d);
            if (f11666k == null) {
                f11666k = new Paint();
                f11666k.setAntiAlias(true);
                f11666k.setColor(-12434878);
                f11667l = new Paint(f11666k);
                f11667l.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            }
            canvas.drawARGB(0, 0, 0, 0);
            canvas.drawRoundRect(rectF, width, width, f11666k);
            canvas.drawBitmap(bitmap, (Rect) null, rectF, f11667l);
            bitmap.recycle();
            return bitmapCreateBitmap;
        } catch (Exception e) {
            C3250y.m11443a(e, "ProfileDownloader");
            return null;
        } catch (OutOfMemoryError e2) {
            C3250y.m11443a(e2, "ProfileDownloader");
            return null;
        }
    }

    /* renamed from: b */
    public static Bitmap m11370b(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            RectF rectF = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
            float width = (float) (bitmap.getWidth() * 0.026d);
            if (f11666k == null) {
                f11666k = new Paint();
                f11666k.setAntiAlias(true);
                f11666k.setColor(-12434878);
                f11667l = new Paint(f11666k);
                f11667l.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            }
            canvas.drawARGB(0, 0, 0, 0);
            canvas.drawRoundRect(rectF, width, width, f11666k);
            canvas.drawBitmap(bitmap, (Rect) null, rectF, f11667l);
            bitmap.recycle();
            return bitmapCreateBitmap;
        } catch (Exception e) {
            C3250y.m11443a(e, "ProfileDownloader");
            return null;
        } catch (OutOfMemoryError e2) {
            C3250y.m11443a(e2, "ProfileDownloader");
            return null;
        }
    }

    /* renamed from: b */
    private Bitmap m11369b(Context context) {
        if (this.f11678n[0] == null) {
            this.f11678n[0] = BitmapFactory.decodeResource(context.getResources(), R.drawable.profile_photo_buddy_default);
        }
        return this.f11678n[0];
    }

    /* renamed from: a */
    public static boolean m11368a(ImageView imageView) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(BitmapFactory.decodeResource(GlobalApplication.m6451b(), R.drawable.mypage_bg_default));
        bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        imageView.setImageBitmap(null);
        imageView.setBackgroundDrawable(bitmapDrawable);
        return true;
    }
}
