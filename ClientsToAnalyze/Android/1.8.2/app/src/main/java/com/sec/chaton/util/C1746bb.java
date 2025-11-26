package com.sec.chaton.util;

import android.content.Context;
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
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p022h.C0776c;
import com.sec.chaton.p022h.p024b.C0774a;
import com.sec.chaton.p022h.p024b.C0775b;
import com.sec.chaton.p028io.entry.inner.Buddy;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpResponse;

/* compiled from: ProfileImageLoader.java */
/* renamed from: com.sec.chaton.util.bb */
/* loaded from: classes.dex */
public class C1746bb implements Handler.Callback {

    /* renamed from: a */
    private static C1746bb f6358a = null;

    /* renamed from: i */
    private static Paint f6359i;

    /* renamed from: j */
    private static Paint f6360j;

    /* renamed from: b */
    private final Context f6361b;

    /* renamed from: d */
    private boolean f6363d;

    /* renamed from: e */
    private HandlerThreadC1750bf f6364e;

    /* renamed from: l */
    private Bitmap f6369l;

    /* renamed from: c */
    private boolean f6362c = false;

    /* renamed from: f */
    private final ConcurrentHashMap f6365f = new ConcurrentHashMap();

    /* renamed from: g */
    private final ConcurrentHashMap f6366g = new ConcurrentHashMap();

    /* renamed from: h */
    private final Handler f6367h = new Handler(Looper.getMainLooper(), this);

    /* renamed from: k */
    private final int f6368k = 5;

    /* renamed from: m */
    private Bitmap[] f6370m = new Bitmap[5];

    /* renamed from: a */
    public static C1746bb m5945a(Context context) {
        if (f6358a == null) {
            synchronized (C1746bb.class) {
                f6358a = new C1746bb(context);
            }
        }
        return f6358a;
    }

    private C1746bb(Context context) {
        this.f6361b = context;
    }

    /* renamed from: a */
    private void m5947a() {
        if (!this.f6363d) {
            this.f6363d = true;
            this.f6367h.sendEmptyMessage(1);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.f6363d = false;
                if (this.f6362c) {
                    return true;
                }
                if (this.f6364e == null) {
                    this.f6364e = new HandlerThreadC1750bf(this, this.f6361b);
                    this.f6364e.start();
                }
                this.f6364e.m5966a();
                return true;
            case 2:
                if (this.f6362c) {
                    return true;
                }
                m5954b();
                return true;
            default:
                return false;
        }
    }

    /* renamed from: a */
    public void m5961a(String str) {
        C1786r.m6066e("deleteImage " + str, "ProfileImageLoader");
        this.f6365f.remove(str);
        File file = new File(this.f6361b.getFilesDir(), str + ".jpeg_");
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
        File file4 = new File(GlobalApplication.m3260b().getExternalFilesDir(null) + "/profile/", String.format("%s_big.jpeg_", str));
        if (file4.exists()) {
            file4.delete();
        }
    }

    /* renamed from: a */
    public void m5959a(ImageView imageView, String str) {
        m5960a(imageView, str, Buddy.BuddyImageStatus.NOT_CHANGE.getCode());
    }

    /* renamed from: a */
    public void m5960a(ImageView imageView, String str, int i) {
        EnumC1749be enumC1749beM5952b = m5952b(imageView, str);
        if (enumC1749beM5952b == EnumC1749be.CACHED) {
            this.f6366g.remove(imageView);
            return;
        }
        if (enumC1749beM5952b == EnumC1749be.ERROR) {
            this.f6365f.remove(str);
        }
        this.f6366g.put(imageView, new C1751bg(this, str, i));
        if (!this.f6362c) {
            m5947a();
        }
    }

    /* renamed from: a */
    public void m5958a(ImageView imageView, EnumC1748bd enumC1748bd) {
        this.f6366g.remove(imageView);
        switch (enumC1748bd) {
            case BROADCAST:
                imageView.setImageBitmap(m5940a(imageView.getContext(), R.drawable.chat_list_broadcast_default));
                break;
            case GROUP:
                imageView.setImageBitmap(m5940a(imageView.getContext(), R.drawable.chat_list_group_chat_default));
                break;
            case BUDDY:
                imageView.setImageBitmap(m5940a(imageView.getContext(), R.drawable.chat_list_single_chat_default));
                break;
            case CHAT_GROUP:
                if (GlobalApplication.m3265f()) {
                    imageView.setImageBitmap(m5940a(imageView.getContext(), R.drawable.chat_list_group_chat_default));
                    break;
                } else {
                    imageView.setImageBitmap(m5940a(imageView.getContext(), R.drawable.contacts_default_image_group));
                    break;
                }
        }
    }

    /* renamed from: b */
    private void m5954b() {
        Iterator it = this.f6366g.keySet().iterator();
        while (it.hasNext()) {
            ImageView imageView = (ImageView) it.next();
            EnumC1749be enumC1749beM5952b = m5952b(imageView, ((C1751bg) this.f6366g.get(imageView)).m5967a());
            if (enumC1749beM5952b == EnumC1749be.CACHED || enumC1749beM5952b == EnumC1749be.ERROR) {
                it.remove();
            }
        }
        if (!this.f6366g.isEmpty()) {
            m5947a();
        }
    }

    /* renamed from: b */
    private EnumC1749be m5952b(ImageView imageView, String str) {
        C1752bh c1752bh = (C1752bh) this.f6365f.get(str);
        if (c1752bh == null) {
            c1752bh = new C1752bh(null);
            this.f6365f.put(str, c1752bh);
        } else if (c1752bh.f6389a == 2) {
            if (c1752bh.f6390b == null) {
                imageView.setImageBitmap(m5951b(imageView.getContext(), str));
                return EnumC1749be.CACHED;
            }
            Bitmap bitmap = (Bitmap) c1752bh.f6390b.get();
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
                return EnumC1749be.CACHED;
            }
            c1752bh.f6390b = null;
        } else if (c1752bh.f6389a == 3) {
            return EnumC1749be.ERROR;
        }
        imageView.setImageBitmap(m5951b(imageView.getContext(), str));
        c1752bh.f6389a = 0;
        return EnumC1749be.NO_CACHED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5950a(ArrayList arrayList, ArrayList arrayList2) {
        arrayList.clear();
        arrayList2.clear();
        for (C1751bg c1751bg : this.f6366g.values()) {
            C1752bh c1752bh = (C1752bh) this.f6365f.get(c1751bg.m5967a());
            if (c1752bh != null && c1752bh.f6389a == 0) {
                c1752bh.f6389a = 1;
                arrayList.add(c1751bg);
                arrayList2.add(c1751bg);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* renamed from: a */
    public Bitmap m5941a(Context context, String str) throws Throwable {
        FileInputStream fileInputStreamOpenFileInput;
        Bitmap bitmapDecodeStream = null;
        String strM5953b = m5953b(str);
        ?? Exists = new File(context.getFilesDir(), strM5953b).exists();
        try {
            if (Exists != 0) {
                try {
                    fileInputStreamOpenFileInput = context.openFileInput(strM5953b);
                } catch (Exception e) {
                    e = e;
                    fileInputStreamOpenFileInput = null;
                } catch (Throwable th) {
                    Exists = 0;
                    th = th;
                    if (Exists != 0) {
                        try {
                            Exists.close();
                        } catch (IOException e2) {
                            C1786r.m6056a(e2, getClass().getSimpleName());
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
                        } catch (IOException e3) {
                            String simpleName = getClass().getSimpleName();
                            C1786r.m6056a(e3, simpleName);
                            Exists = simpleName;
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    C1786r.m6056a(e, getClass().getSimpleName());
                    Exists = fileInputStreamOpenFileInput;
                    if (fileInputStreamOpenFileInput != null) {
                        try {
                            fileInputStreamOpenFileInput.close();
                            Exists = fileInputStreamOpenFileInput;
                        } catch (IOException e5) {
                            String simpleName2 = getClass().getSimpleName();
                            C1786r.m6056a(e5, simpleName2);
                            Exists = simpleName2;
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

    /* renamed from: b */
    public static String m5953b(String str) {
        return str + ".jpeg_";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public void m5957a(Bitmap bitmap, String str) throws IOException {
        FileOutputStream fileOutputStreamOpenFileOutput = null;
        fileOutputStreamOpenFileOutput = null;
        try {
            try {
                fileOutputStreamOpenFileOutput = this.f6361b.openFileOutput(str + ".jpeg_", 0);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStreamOpenFileOutput);
                fileOutputStreamOpenFileOutput = fileOutputStreamOpenFileOutput;
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                        fileOutputStreamOpenFileOutput = fileOutputStreamOpenFileOutput;
                    } catch (IOException e) {
                        String simpleName = getClass().getSimpleName();
                        C1786r.m6056a(e, simpleName);
                        fileOutputStreamOpenFileOutput = simpleName;
                    }
                }
            } catch (FileNotFoundException e2) {
                C1786r.m6056a(e2, getClass().getSimpleName());
                fileOutputStreamOpenFileOutput = fileOutputStreamOpenFileOutput;
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                        fileOutputStreamOpenFileOutput = fileOutputStreamOpenFileOutput;
                    } catch (IOException e3) {
                        String simpleName2 = getClass().getSimpleName();
                        C1786r.m6056a(e3, simpleName2);
                        fileOutputStreamOpenFileOutput = simpleName2;
                    }
                }
            }
        } catch (Throwable th) {
            if (fileOutputStreamOpenFileOutput != null) {
                try {
                    fileOutputStreamOpenFileOutput.close();
                } catch (IOException e4) {
                    C1786r.m6056a(e4, getClass().getSimpleName());
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00c6 A[Catch: ClientProtocolException -> 0x00cd, IOException -> 0x015a, Exception -> 0x016e, all -> 0x0182, TRY_ENTER, TryCatch #7 {ClientProtocolException -> 0x00cd, blocks: (B:7:0x0031, B:9:0x0079, B:14:0x0095, B:15:0x0098, B:33:0x00c6, B:34:0x00c9, B:35:0x00cc, B:24:0x00b0, B:25:0x00b3, B:44:0x00ec, B:49:0x0100, B:60:0x013c, B:55:0x0128), top: B:87:0x0031, outer: #2 }] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    com.sec.chaton.p007a.p008a.C0102c m5963c(java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 403
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C1746bb.m5963c(java.lang.String):com.sec.chaton.a.a.c");
    }

    /* renamed from: a */
    private int m5939a(HttpResponse httpResponse) throws IOException {
        if (httpResponse.getEntity() == null) {
            return -1;
        }
        try {
            InputStream ungzippedContent = AndroidHttpClient.getUngzippedContent(httpResponse.getEntity());
            if (ungzippedContent == null) {
                return -1;
            }
            String strM3309a = C0776c.m3309a(ungzippedContent);
            C1786r.m6066e("errorMessage : " + strM3309a, "ProfileImageLoader");
            return C0774a.m3302a(C0775b.m3303a(strM3309a));
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /* renamed from: a */
    public void m5962a(String str, Bitmap bitmap) {
        if (!this.f6362c) {
            C1752bh c1752bh = new C1752bh(null);
            c1752bh.f6389a = 2;
            if (bitmap != null) {
                c1752bh.f6390b = new SoftReference(m5942a(bitmap));
            }
            this.f6365f.put(str, c1752bh);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m5956f(String str) {
        C1752bh c1752bh = new C1752bh(null);
        c1752bh.f6389a = 3;
        this.f6365f.put(str, c1752bh);
    }

    /* renamed from: a */
    public static String m5946a(String str, int i) {
        String str2 = C1763bs.m5973b(EnumC1764bt.PRIMARY) + "/buddy/" + str + "/image/?uid=" + C1789u.m6075a().getString("uid", "") + "&imei=" + C1721ad.m5873a();
        if (i > 0) {
            return str2 + "&size=" + i;
        }
        return str2;
    }

    /* renamed from: d */
    public static String m5955d(String str) {
        return m5946a(str, -1);
    }

    /* renamed from: a */
    public static Bitmap m5942a(Bitmap bitmap) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        RectF rectF = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
        float width = (float) (bitmap.getWidth() * 0.1d);
        if (f6359i == null) {
            f6359i = new Paint();
            f6359i.setAntiAlias(true);
            f6359i.setColor(-12434878);
            f6360j = new Paint(f6359i);
            f6360j.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        }
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawRoundRect(rectF, width, width, f6359i);
        canvas.drawBitmap(bitmap, (Rect) null, rectF, f6360j);
        bitmap.recycle();
        return bitmapCreateBitmap;
    }

    /* renamed from: a */
    public static Bitmap m5940a(Context context, int i) {
        return m5942a(BitmapFactory.decodeResource(context.getResources(), i));
    }

    /* renamed from: b */
    private Bitmap m5951b(Context context, String str) {
        this.f6369l = m5942a(BitmapFactory.decodeResource(context.getResources(), R.drawable.profile_noimage));
        return this.f6369l;
    }

    /* renamed from: e */
    public Bitmap m5964e(String str) throws Throwable {
        C1752bh c1752bh = (C1752bh) this.f6365f.get(str);
        if (c1752bh != null && c1752bh.f6389a == 2 && c1752bh.f6390b != null) {
            return (Bitmap) c1752bh.f6390b.get();
        }
        Bitmap bitmapM5941a = m5941a(GlobalApplication.m3260b(), str);
        if (bitmapM5941a != null) {
            return m5942a(bitmapM5941a);
        }
        return null;
    }
}
