package com.sec.chaton.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.http.AndroidHttpClient;
import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.p046a.p047a.C0787k;
import com.sec.chaton.p067j.C2433c;
import com.sec.common.CommonApplication;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

/* compiled from: ImageDownloader.java */
/* renamed from: com.sec.chaton.util.aw */
/* loaded from: classes.dex */
public class C4831aw {

    /* renamed from: a */
    private static C4831aw f17635a;

    /* renamed from: b */
    private static final ConcurrentHashMap<String, SoftReference<Bitmap>> f17636b = new ConcurrentHashMap<>(2);

    /* renamed from: d */
    private String f17638d;

    /* renamed from: c */
    private String f17637c = null;

    /* renamed from: e */
    private final HashMap<String, Bitmap> f17639e = new C4832ax(this, 2, 0.75f, true);

    /* renamed from: f */
    private final Handler f17640f = new Handler();

    /* renamed from: g */
    private final Runnable f17641g = new RunnableC4833ay(this);

    private C4831aw() {
    }

    /* renamed from: a */
    public static synchronized C4831aw m18293a() {
        if (f17635a == null) {
            f17635a = new C4831aw();
        }
        return f17635a;
    }

    /* renamed from: a */
    public void m18299a(String str, String str2, String str3, String str4, Bitmap.CompressFormat compressFormat, InterfaceC4837bb interfaceC4837bb) {
        this.f17637c = str3;
        this.f17638d = str4;
        m18296d();
        Bitmap bitmapM18300b = m18300b(str2);
        if (bitmapM18300b == null) {
            File file = new File(CommonApplication.m18732r().getExternalFilesDir(null) + "/profile/", this.f17638d);
            if (file.exists()) {
                try {
                    Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(file.toString());
                    m18298a(str2, bitmapDecodeFile);
                    C4904y.m18646e("Profile image, use exist image", "ImageDownloader");
                    interfaceC4837bb.mo7395a(str, bitmapDecodeFile, EnumC4836ba.SUCCESS);
                    return;
                } catch (Exception e) {
                    C4904y.m18635a(e, "ImageDownloader");
                    interfaceC4837bb.mo7395a(str, null, EnumC4836ba.SUCCESS);
                    return;
                } catch (OutOfMemoryError e2) {
                    C4904y.m18635a(e2, "ImageDownloader");
                    interfaceC4837bb.mo7395a(str, null, EnumC4836ba.SUCCESS);
                    return;
                }
            }
            C4904y.m18646e("Profile image, download from Server", "ImageDownloader");
            m18294a(str2, str, interfaceC4837bb);
            return;
        }
        C4904y.m18646e("Profile image, use from cache", "ImageDownloader");
        interfaceC4837bb.mo7395a(str, bitmapM18300b, EnumC4836ba.SUCCESS);
    }

    /* renamed from: a */
    private void m18294a(String str, String str2, InterfaceC4837bb interfaceC4837bb) {
        if (str != null) {
            new AsyncTaskC4834az(this, interfaceC4837bb).execute(str, str2);
        }
    }

    /* renamed from: a */
    C0787k m18297a(String str) {
        AndroidHttpClient androidHttpClient;
        HttpResponse httpResponseExecute;
        int statusCode;
        InputStream content;
        HttpGet httpGet = new HttpGet(str);
        HttpClient httpClientM10539b = C2433c.m10539b();
        try {
            try {
                try {
                    try {
                        C4904y.m18639b("execute to : " + httpGet.getURI().toString(), "ImageDownloader");
                        httpResponseExecute = httpClientM10539b.execute(httpGet);
                        statusCode = httpResponseExecute.getStatusLine().getStatusCode();
                        C4904y.m18639b("execute end, status code : " + statusCode, "ImageDownloader");
                    } catch (IOException e) {
                        httpGet.abort();
                        C4904y.m18645d("I/O error while retrieving bitmap from " + str, "ImageDownloader");
                        if (httpClientM10539b instanceof AndroidHttpClient) {
                            androidHttpClient = (AndroidHttpClient) httpClientM10539b;
                        }
                    }
                } catch (IllegalStateException e2) {
                    httpGet.abort();
                    C4904y.m18645d("Incorrect URL: " + str, "ImageDownloader");
                    if (httpClientM10539b instanceof AndroidHttpClient) {
                        androidHttpClient = (AndroidHttpClient) httpClientM10539b;
                    }
                }
            } catch (Exception e3) {
                httpGet.abort();
                C4904y.m18645d("Error while retrieving bitmap", "ImageDownloader");
                if (httpClientM10539b instanceof AndroidHttpClient) {
                    androidHttpClient = (AndroidHttpClient) httpClientM10539b;
                }
            }
            if (statusCode != 200) {
                if (statusCode == 204) {
                    C0787k c0787k = new C0787k(null, EnumC4836ba.NO_CONTENT);
                    if (httpClientM10539b instanceof AndroidHttpClient) {
                        ((AndroidHttpClient) httpClientM10539b).close();
                    }
                    return c0787k;
                }
                C0787k c0787k2 = new C0787k(null, EnumC4836ba.ERROR);
                if (httpClientM10539b instanceof AndroidHttpClient) {
                    ((AndroidHttpClient) httpClientM10539b).close();
                }
                return c0787k2;
            }
            HttpEntity entity = httpResponseExecute.getEntity();
            if (entity == null) {
                if (httpClientM10539b instanceof AndroidHttpClient) {
                    androidHttpClient = (AndroidHttpClient) httpClientM10539b;
                    androidHttpClient.close();
                }
                return new C0787k(null, EnumC4836ba.ERROR);
            }
            try {
                content = entity.getContent();
            } catch (Throwable th) {
                th = th;
                content = null;
            }
            try {
                try {
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(new C4813ae(content));
                    if (this.f17637c != null) {
                        if (!TextUtils.isEmpty(this.f17638d) && C4873ck.m18500a()) {
                            C4812ad.m18152a(bitmapDecodeStream, new File(CommonApplication.m18732r().getExternalFilesDir(null).getAbsolutePath(), this.f17637c), this.f17638d, Bitmap.CompressFormat.JPEG, 100);
                        }
                    } else if (!TextUtils.isEmpty(this.f17638d) && C4873ck.m18500a()) {
                        C4812ad.m18152a(bitmapDecodeStream, new File(C4873ck.m18502c(), "/profilehistory/"), this.f17638d, Bitmap.CompressFormat.JPEG, 100);
                    }
                    C0787k c0787k3 = new C0787k(bitmapDecodeStream, EnumC4836ba.SUCCESS);
                    if (content != null) {
                        content.close();
                    }
                    entity.consumeContent();
                    return c0787k3;
                } catch (OutOfMemoryError e4) {
                    C0787k c0787k4 = new C0787k(null, EnumC4836ba.ERROR);
                    if (content != null) {
                        content.close();
                    }
                    entity.consumeContent();
                    if (httpClientM10539b instanceof AndroidHttpClient) {
                        ((AndroidHttpClient) httpClientM10539b).close();
                    }
                    return c0787k4;
                }
            } catch (Throwable th2) {
                th = th2;
                if (content != null) {
                    content.close();
                }
                entity.consumeContent();
                throw th;
            }
        } finally {
            if (httpClientM10539b instanceof AndroidHttpClient) {
                ((AndroidHttpClient) httpClientM10539b).close();
            }
        }
    }

    /* renamed from: a */
    public void m18298a(String str, Bitmap bitmap) {
        if (bitmap != null) {
            synchronized (this.f17639e) {
                this.f17639e.put(str, bitmap);
            }
        }
    }

    /* renamed from: b */
    public Bitmap m18300b(String str) {
        synchronized (this.f17639e) {
            Bitmap bitmap = this.f17639e.get(str);
            if (bitmap != null) {
                this.f17639e.remove(str);
                this.f17639e.put(str, bitmap);
                return bitmap;
            }
            SoftReference<Bitmap> softReference = f17636b.get(str);
            if (softReference != null) {
                Bitmap bitmap2 = softReference.get();
                if (bitmap2 == null) {
                    f17636b.remove(str);
                } else {
                    return bitmap2;
                }
            }
            return null;
        }
    }

    /* renamed from: b */
    public void m18301b() {
        synchronized (this.f17639e) {
            this.f17639e.clear();
        }
        f17636b.clear();
    }

    /* renamed from: d */
    private void m18296d() {
        this.f17640f.removeCallbacks(this.f17641g);
        this.f17640f.postDelayed(this.f17641g, 10000L);
    }
}
