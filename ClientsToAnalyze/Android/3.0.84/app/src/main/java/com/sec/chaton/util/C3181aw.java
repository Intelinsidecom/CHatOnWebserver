package com.sec.chaton.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.http.AndroidHttpClient;
import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.p016a.p017a.C0271h;
import com.sec.chaton.p037j.C1554c;
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
public class C3181aw {

    /* renamed from: a */
    private static C3181aw f11520a;

    /* renamed from: b */
    private static final ConcurrentHashMap<String, SoftReference<Bitmap>> f11521b = new ConcurrentHashMap<>(2);

    /* renamed from: d */
    private String f11523d;

    /* renamed from: c */
    private String f11522c = null;

    /* renamed from: e */
    private final HashMap<String, Bitmap> f11524e = new C3182ax(this, 2, 0.75f, true);

    /* renamed from: f */
    private final Handler f11525f = new Handler();

    /* renamed from: g */
    private final Runnable f11526g = new RunnableC3183ay(this);

    private C3181aw() {
    }

    /* renamed from: a */
    public static C3181aw m11120a() {
        return f11520a == null ? new C3181aw() : f11520a;
    }

    /* renamed from: a */
    public void m11126a(String str, String str2, String str3, String str4, Bitmap.CompressFormat compressFormat, InterfaceC3187bb interfaceC3187bb) {
        this.f11522c = str3;
        this.f11523d = str4;
        m11123d();
        Bitmap bitmapM11127b = m11127b(str2);
        if (bitmapM11127b == null) {
            File file = new File(CommonApplication.m11493l().getExternalFilesDir(null) + "/profile/", this.f11523d);
            if (file.exists()) {
                try {
                    Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(file.toString());
                    m11125a(str2, bitmapDecodeFile);
                    C3250y.m11456e("Profile image, use exist image", "ImageDownloader");
                    interfaceC3187bb.mo4324a(str, bitmapDecodeFile, EnumC3186ba.SUCCESS);
                    return;
                } catch (Exception e) {
                    C3250y.m11443a(e, "ImageDownloader");
                    interfaceC3187bb.mo4324a(str, null, EnumC3186ba.SUCCESS);
                    return;
                } catch (OutOfMemoryError e2) {
                    C3250y.m11443a(e2, "ImageDownloader");
                    interfaceC3187bb.mo4324a(str, null, EnumC3186ba.SUCCESS);
                    return;
                }
            }
            C3250y.m11456e("Profile image, download from Server", "ImageDownloader");
            m11121a(str2, str, interfaceC3187bb);
            return;
        }
        C3250y.m11456e("Profile image, use from cache", "ImageDownloader");
        interfaceC3187bb.mo4324a(str, bitmapM11127b, EnumC3186ba.SUCCESS);
    }

    /* renamed from: a */
    private void m11121a(String str, String str2, InterfaceC3187bb interfaceC3187bb) {
        if (str != null) {
            new AsyncTaskC3184az(this, interfaceC3187bb).execute(str, str2);
        }
    }

    /* renamed from: a */
    C0271h m11124a(String str) {
        AndroidHttpClient androidHttpClient;
        HttpResponse httpResponseExecute;
        int statusCode;
        InputStream content;
        HttpGet httpGet = new HttpGet(str);
        HttpClient httpClientM6595b = C1554c.m6595b();
        try {
            try {
                try {
                    C3250y.m11450b("execute to : " + httpGet.getURI().toString(), "ImageDownloader");
                    httpResponseExecute = httpClientM6595b.execute(httpGet);
                    statusCode = httpResponseExecute.getStatusLine().getStatusCode();
                    C3250y.m11450b("execute end, status code : " + statusCode, "ImageDownloader");
                } catch (IOException e) {
                    httpGet.abort();
                    C3250y.m11455d("I/O error while retrieving bitmap from " + str, "ImageDownloader");
                    if (httpClientM6595b instanceof AndroidHttpClient) {
                        androidHttpClient = (AndroidHttpClient) httpClientM6595b;
                    }
                } catch (IllegalStateException e2) {
                    httpGet.abort();
                    C3250y.m11455d("Incorrect URL: " + str, "ImageDownloader");
                    if (httpClientM6595b instanceof AndroidHttpClient) {
                        androidHttpClient = (AndroidHttpClient) httpClientM6595b;
                    }
                }
            } catch (Exception e3) {
                httpGet.abort();
                C3250y.m11455d("Error while retrieving bitmap", "ImageDownloader");
                if (httpClientM6595b instanceof AndroidHttpClient) {
                    androidHttpClient = (AndroidHttpClient) httpClientM6595b;
                }
            }
            if (statusCode != 200) {
                if (statusCode == 204) {
                    C0271h c0271h = new C0271h(null, EnumC3186ba.NO_CONTENT);
                    if (httpClientM6595b instanceof AndroidHttpClient) {
                        ((AndroidHttpClient) httpClientM6595b).close();
                    }
                    return c0271h;
                }
                C0271h c0271h2 = new C0271h(null, EnumC3186ba.ERROR);
                if (httpClientM6595b instanceof AndroidHttpClient) {
                    ((AndroidHttpClient) httpClientM6595b).close();
                }
                return c0271h2;
            }
            HttpEntity entity = httpResponseExecute.getEntity();
            if (entity == null) {
                if (httpClientM6595b instanceof AndroidHttpClient) {
                    androidHttpClient = (AndroidHttpClient) httpClientM6595b;
                    androidHttpClient.close();
                }
                return new C0271h(null, EnumC3186ba.ERROR);
            }
            try {
                content = entity.getContent();
                try {
                    try {
                        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(new C3163ae(content));
                        if (this.f11522c != null) {
                            if (!TextUtils.isEmpty(this.f11523d) && C3223ck.m11327a()) {
                                C3162ad.m11007a(bitmapDecodeStream, new File(CommonApplication.m11493l().getExternalFilesDir(null).getAbsolutePath(), this.f11522c), this.f11523d, Bitmap.CompressFormat.JPEG, 100);
                            }
                        } else if (!TextUtils.isEmpty(this.f11523d) && C3223ck.m11327a()) {
                            C3162ad.m11007a(bitmapDecodeStream, new File(C3223ck.m11329c(), "/profilehistory/"), this.f11523d, Bitmap.CompressFormat.JPEG, 100);
                        }
                        C0271h c0271h3 = new C0271h(bitmapDecodeStream, EnumC3186ba.SUCCESS);
                        if (content != null) {
                            content.close();
                        }
                        entity.consumeContent();
                        return c0271h3;
                    } catch (OutOfMemoryError e4) {
                        C0271h c0271h4 = new C0271h(null, EnumC3186ba.ERROR);
                        if (content != null) {
                            content.close();
                        }
                        entity.consumeContent();
                        if (httpClientM6595b instanceof AndroidHttpClient) {
                            ((AndroidHttpClient) httpClientM6595b).close();
                        }
                        return c0271h4;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (content != null) {
                        content.close();
                    }
                    entity.consumeContent();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                content = null;
            }
        } finally {
            if (httpClientM6595b instanceof AndroidHttpClient) {
                ((AndroidHttpClient) httpClientM6595b).close();
            }
        }
    }

    /* renamed from: a */
    public void m11125a(String str, Bitmap bitmap) {
        if (bitmap != null) {
            synchronized (this.f11524e) {
                this.f11524e.put(str, bitmap);
            }
        }
    }

    /* renamed from: b */
    public Bitmap m11127b(String str) {
        synchronized (this.f11524e) {
            Bitmap bitmap = this.f11524e.get(str);
            if (bitmap != null) {
                this.f11524e.remove(str);
                this.f11524e.put(str, bitmap);
                return bitmap;
            }
            SoftReference<Bitmap> softReference = f11521b.get(str);
            if (softReference != null) {
                Bitmap bitmap2 = softReference.get();
                if (bitmap2 == null) {
                    f11521b.remove(str);
                } else {
                    return bitmap2;
                }
            }
            return null;
        }
    }

    /* renamed from: b */
    public void m11128b() {
        synchronized (this.f11524e) {
            this.f11524e.clear();
        }
        f11521b.clear();
    }

    /* renamed from: d */
    private void m11123d() {
        this.f11525f.removeCallbacks(this.f11526g);
        this.f11525f.postDelayed(this.f11526g, 10000L);
    }
}
