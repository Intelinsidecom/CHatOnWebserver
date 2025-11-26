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
import com.sec.chaton.p018c.C0495d;
import com.sec.chaton.p018c.p022d.C0496a;
import com.sec.chaton.p018c.p022d.C0497b;
import com.sec.chaton.p033io.entry.inner.Buddy;
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
/* renamed from: com.sec.chaton.util.w */
/* loaded from: classes.dex */
public class C1348w implements Handler.Callback {

    /* renamed from: a */
    private static C1348w f4589a = null;

    /* renamed from: i */
    private static Paint f4590i;

    /* renamed from: j */
    private static Paint f4591j;

    /* renamed from: b */
    private final Context f4592b;

    /* renamed from: d */
    private boolean f4594d;

    /* renamed from: e */
    private HandlerThreadC1292ao f4595e;

    /* renamed from: c */
    private boolean f4593c = false;

    /* renamed from: f */
    private final ConcurrentHashMap f4596f = new ConcurrentHashMap();

    /* renamed from: g */
    private final ConcurrentHashMap f4597g = new ConcurrentHashMap();

    /* renamed from: h */
    private final Handler f4598h = new Handler(Looper.getMainLooper(), this);

    /* renamed from: k */
    private final int f4599k = 5;

    /* renamed from: l */
    private Bitmap[] f4600l = new Bitmap[5];

    /* renamed from: a */
    public static C1348w m4685a(Context context) {
        if (f4589a == null) {
            synchronized (C1348w.class) {
                f4589a = new C1348w(context);
            }
        }
        return f4589a;
    }

    private C1348w(Context context) {
        this.f4592b = context;
    }

    /* renamed from: a */
    private void m4687a() {
        if (!this.f4594d) {
            this.f4594d = true;
            this.f4598h.sendEmptyMessage(1);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.f4594d = false;
                if (this.f4593c) {
                    return true;
                }
                if (this.f4595e == null) {
                    this.f4595e = new HandlerThreadC1292ao(this, this.f4592b);
                    this.f4595e.start();
                }
                this.f4595e.m4492a();
                return true;
            case 2:
                if (this.f4593c) {
                    return true;
                }
                m4694b();
                return true;
            default:
                return false;
        }
    }

    /* renamed from: a */
    public void m4701a(String str) {
        C1341p.m4662e("deleteImage " + str, "ProfileImageLoader");
        this.f4596f.remove(str);
        File file = new File(this.f4592b.getFilesDir(), str + ".jpeg_");
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
        File file4 = new File(GlobalApplication.m3100a().getExternalFilesDir(null) + "/profile/", String.format("%s_big.jpeg_", str));
        if (file4.exists()) {
            file4.delete();
        }
    }

    /* renamed from: a */
    public void m4699a(ImageView imageView, String str) {
        m4700a(imageView, str, Buddy.BuddyImageStatus.NOT_CHANGE.getCode());
    }

    /* renamed from: a */
    public void m4700a(ImageView imageView, String str, int i) {
        EnumC1340o enumC1340oM4692b = m4692b(imageView, str);
        if (enumC1340oM4692b == EnumC1340o.CACHED) {
            this.f4597g.remove(imageView);
            return;
        }
        if (enumC1340oM4692b == EnumC1340o.ERROR) {
            this.f4596f.remove(str);
        }
        this.f4597g.put(imageView, new C1293ap(this, str, i));
        if (!this.f4593c) {
            m4687a();
        }
    }

    /* renamed from: a */
    public void m4698a(ImageView imageView, EnumC1310bf enumC1310bf) {
        this.f4597g.remove(imageView);
        switch (enumC1310bf) {
            case BROADCAST:
                imageView.setImageBitmap(m4680a(imageView.getContext(), R.drawable.chat_list_broadcast_default));
                break;
            case GROUP:
                imageView.setImageBitmap(m4680a(imageView.getContext(), R.drawable.contacts_default_image_group));
                break;
            case BUDDY:
                imageView.setImageBitmap(m4680a(imageView.getContext(), R.drawable.contacts_default_image));
                break;
            case CHAT_GROUP:
                imageView.setImageBitmap(m4680a(imageView.getContext(), R.drawable.contacts_default_image_group));
                break;
        }
    }

    /* renamed from: b */
    private void m4694b() {
        Iterator it = this.f4597g.keySet().iterator();
        while (it.hasNext()) {
            ImageView imageView = (ImageView) it.next();
            EnumC1340o enumC1340oM4692b = m4692b(imageView, ((C1293ap) this.f4597g.get(imageView)).m4493a());
            if (enumC1340oM4692b == EnumC1340o.CACHED || enumC1340oM4692b == EnumC1340o.ERROR) {
                it.remove();
            }
        }
        if (!this.f4597g.isEmpty()) {
            m4687a();
        }
    }

    /* renamed from: b */
    private EnumC1340o m4692b(ImageView imageView, String str) {
        C1307bc c1307bc = (C1307bc) this.f4596f.get(str);
        if (c1307bc == null) {
            c1307bc = new C1307bc(null);
            this.f4596f.put(str, c1307bc);
        } else if (c1307bc.f4517a == 2) {
            if (c1307bc.f4518b == null) {
                imageView.setImageBitmap(m4691b(imageView.getContext(), str));
                return EnumC1340o.CACHED;
            }
            Bitmap bitmap = (Bitmap) c1307bc.f4518b.get();
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
                return EnumC1340o.CACHED;
            }
            c1307bc.f4518b = null;
        } else if (c1307bc.f4517a == 3) {
            return EnumC1340o.ERROR;
        }
        imageView.setImageBitmap(m4691b(imageView.getContext(), str));
        c1307bc.f4517a = 0;
        return EnumC1340o.NO_CACHED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4690a(ArrayList arrayList, ArrayList arrayList2) {
        arrayList.clear();
        arrayList2.clear();
        for (C1293ap c1293ap : this.f4597g.values()) {
            C1307bc c1307bc = (C1307bc) this.f4596f.get(c1293ap.m4493a());
            if (c1307bc != null && c1307bc.f4517a == 0) {
                c1307bc.f4517a = 1;
                arrayList.add(c1293ap);
                arrayList2.add(c1293ap);
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
    public Bitmap m4681a(Context context, String str) throws Throwable {
        FileInputStream fileInputStreamOpenFileInput;
        Bitmap bitmapDecodeStream = null;
        String strM4693b = m4693b(str);
        ?? Exists = new File(context.getFilesDir(), strM4693b).exists();
        try {
            if (Exists != 0) {
                try {
                    fileInputStreamOpenFileInput = context.openFileInput(strM4693b);
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
                            C1341p.m4653a(e2, getClass().getSimpleName());
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
                            C1341p.m4653a(e3, simpleName);
                            Exists = simpleName;
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    C1341p.m4653a(e, getClass().getSimpleName());
                    Exists = fileInputStreamOpenFileInput;
                    if (fileInputStreamOpenFileInput != null) {
                        try {
                            fileInputStreamOpenFileInput.close();
                            Exists = fileInputStreamOpenFileInput;
                        } catch (IOException e5) {
                            String simpleName2 = getClass().getSimpleName();
                            C1341p.m4653a(e5, simpleName2);
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
    public static String m4693b(String str) {
        return str + ".jpeg_";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public void m4697a(Bitmap bitmap, String str) throws IOException {
        FileOutputStream fileOutputStreamOpenFileOutput = null;
        fileOutputStreamOpenFileOutput = null;
        try {
            try {
                fileOutputStreamOpenFileOutput = this.f4592b.openFileOutput(str + ".jpeg_", 0);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStreamOpenFileOutput);
                fileOutputStreamOpenFileOutput = fileOutputStreamOpenFileOutput;
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                        fileOutputStreamOpenFileOutput = fileOutputStreamOpenFileOutput;
                    } catch (IOException e) {
                        String simpleName = getClass().getSimpleName();
                        C1341p.m4653a(e, simpleName);
                        fileOutputStreamOpenFileOutput = simpleName;
                    }
                }
            } catch (FileNotFoundException e2) {
                C1341p.m4653a(e2, getClass().getSimpleName());
                fileOutputStreamOpenFileOutput = fileOutputStreamOpenFileOutput;
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                        fileOutputStreamOpenFileOutput = fileOutputStreamOpenFileOutput;
                    } catch (IOException e3) {
                        String simpleName2 = getClass().getSimpleName();
                        C1341p.m4653a(e3, simpleName2);
                        fileOutputStreamOpenFileOutput = simpleName2;
                    }
                }
            }
        } catch (Throwable th) {
            if (fileOutputStreamOpenFileOutput != null) {
                try {
                    fileOutputStreamOpenFileOutput.close();
                } catch (IOException e4) {
                    C1341p.m4653a(e4, getClass().getSimpleName());
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
    com.sec.chaton.p015b.p016a.C0253a m4703c(java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 403
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C1348w.m4703c(java.lang.String):com.sec.chaton.b.a.a");
    }

    /* renamed from: a */
    private int m4679a(HttpResponse httpResponse) throws IOException {
        if (httpResponse.getEntity() == null) {
            return -1;
        }
        try {
            InputStream ungzippedContent = AndroidHttpClient.getUngzippedContent(httpResponse.getEntity());
            if (ungzippedContent == null) {
                return -1;
            }
            String strM2503a = C0495d.m2503a(ungzippedContent);
            C1341p.m4662e("errorMessage : " + strM2503a, "ProfileImageLoader");
            return C0496a.m2519a(C0497b.m2520a(strM2503a));
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /* renamed from: a */
    public void m4702a(String str, Bitmap bitmap) {
        if (!this.f4593c) {
            C1307bc c1307bc = new C1307bc(null);
            c1307bc.f4517a = 2;
            if (bitmap != null) {
                c1307bc.f4518b = new SoftReference(m4682a(bitmap));
            }
            this.f4596f.put(str, c1307bc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m4696e(String str) {
        C1307bc c1307bc = new C1307bc(null);
        c1307bc.f4517a = 3;
        this.f4596f.put(str, c1307bc);
    }

    /* renamed from: a */
    public static String m4686a(String str, int i) {
        String str2 = C1296as.m4521b(EnumC1289al.PRIMARY) + "/check/" + str + "/image/?uid=" + C1323bs.m4575a().getString("uid", "") + "&imei=" + C1336k.m4621a();
        if (i > 0) {
            return str2 + "&size=" + i;
        }
        return str2;
    }

    /* renamed from: d */
    public static String m4695d(String str) {
        return m4686a(str, -1);
    }

    /* renamed from: a */
    public static Bitmap m4682a(Bitmap bitmap) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        RectF rectF = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
        float width = (float) (bitmap.getWidth() * 0.06d);
        if (f4590i == null) {
            f4590i = new Paint();
            f4590i.setAntiAlias(true);
            f4590i.setColor(-12434878);
            f4591j = new Paint(f4590i);
            f4591j.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        }
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawRoundRect(rectF, width, width, f4590i);
        canvas.drawBitmap(bitmap, (Rect) null, rectF, f4591j);
        bitmap.recycle();
        return bitmapCreateBitmap;
    }

    /* renamed from: a */
    public static Bitmap m4680a(Context context, int i) {
        return m4682a(BitmapFactory.decodeResource(context.getResources(), i));
    }

    /* renamed from: b */
    private Bitmap m4691b(Context context, String str) {
        if (this.f4600l[0] == null) {
            this.f4600l[0] = m4682a(BitmapFactory.decodeResource(context.getResources(), R.drawable.contacts_default_image));
        }
        return this.f4600l[0];
    }
}
