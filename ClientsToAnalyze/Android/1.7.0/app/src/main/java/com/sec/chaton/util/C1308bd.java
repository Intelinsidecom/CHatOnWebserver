package com.sec.chaton.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.http.AndroidHttpClient;
import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015b.p016a.C0253a;
import com.sec.chaton.p018c.C0495d;
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
/* renamed from: com.sec.chaton.util.bd */
/* loaded from: classes.dex */
public class C1308bd {

    /* renamed from: a */
    private static C1308bd f4519a;

    /* renamed from: b */
    private static final ConcurrentHashMap f4520b = new ConcurrentHashMap(2);

    /* renamed from: c */
    private String f4521c;

    /* renamed from: d */
    private String f4522d;

    /* renamed from: e */
    private final HashMap f4523e = new C1331f(this, 2, 0.75f, true);

    /* renamed from: f */
    private final Handler f4524f = new Handler();

    /* renamed from: g */
    private final Runnable f4525g = new RunnableC1330e(this);

    private C1308bd() {
    }

    /* renamed from: a */
    public static C1308bd m4555a() {
        return f4519a == null ? new C1308bd() : f4519a;
    }

    /* renamed from: a */
    public void m4561a(String str, String str2, String str3, String str4, Bitmap.CompressFormat compressFormat, InterfaceC1290am interfaceC1290am) {
        this.f4521c = str3;
        this.f4522d = str4;
        m4558d();
        Bitmap bitmapM4562b = m4562b(str2);
        if (bitmapM4562b == null) {
            File file = new File(GlobalApplication.m3100a().getExternalFilesDir(null) + "/profile/", this.f4522d);
            if (file.exists()) {
                Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(file.toString());
                m4560a(str2, bitmapDecodeFile);
                C1341p.m4662e("Profile image, use exist image", "ImageDownloader");
                interfaceC1290am.mo2368a(str, bitmapDecodeFile, EnumC1304b.SUCCESS);
                return;
            }
            C1341p.m4662e("Profile image, download from Server", "ImageDownloader");
            m4556a(str2, str, interfaceC1290am);
            return;
        }
        C1341p.m4662e("Profile image, use from cache", "ImageDownloader");
        interfaceC1290am.mo2368a(str, bitmapM4562b, EnumC1304b.SUCCESS);
    }

    /* renamed from: a */
    private void m4556a(String str, String str2, InterfaceC1290am interfaceC1290am) {
        if (str != null) {
            new AsyncTaskC1298au(this, interfaceC1290am).execute(str, str2);
        }
    }

    /* renamed from: a */
    C0253a m4559a(String str) {
        HttpResponse httpResponseExecute;
        int statusCode;
        InputStream content;
        HttpGet httpGet = new HttpGet(str);
        HttpClient httpClientM2516b = C0495d.m2516b();
        try {
            try {
                C1341p.m4658b("execute to : " + httpGet.getURI().toString(), "ImageDownloader");
                httpResponseExecute = httpClientM2516b.execute(httpGet);
                statusCode = httpResponseExecute.getStatusLine().getStatusCode();
                C1341p.m4658b("execute end, status code : " + statusCode, "ImageDownloader");
            } catch (IOException e) {
                httpGet.abort();
                C1341p.m4661d("I/O error while retrieving bitmap from " + str, "ImageDownloader");
                if (httpClientM2516b instanceof AndroidHttpClient) {
                    ((AndroidHttpClient) httpClientM2516b).close();
                }
            } catch (IllegalStateException e2) {
                httpGet.abort();
                C1341p.m4661d("Incorrect URL: " + str, "ImageDownloader");
                if (httpClientM2516b instanceof AndroidHttpClient) {
                    ((AndroidHttpClient) httpClientM2516b).close();
                }
            } catch (Exception e3) {
                httpGet.abort();
                C1341p.m4661d("Error while retrieving bitmap", "ImageDownloader");
                if (httpClientM2516b instanceof AndroidHttpClient) {
                    ((AndroidHttpClient) httpClientM2516b).close();
                }
            }
            if (statusCode != 200) {
                if (statusCode == 204) {
                    C0253a c0253a = new C0253a(null, EnumC1304b.NO_CONTENT);
                    if (httpClientM2516b instanceof AndroidHttpClient) {
                        ((AndroidHttpClient) httpClientM2516b).close();
                    }
                    return c0253a;
                }
                C0253a c0253a2 = new C0253a(null, EnumC1304b.ERROR);
                if (httpClientM2516b instanceof AndroidHttpClient) {
                    ((AndroidHttpClient) httpClientM2516b).close();
                }
                return c0253a2;
            }
            HttpEntity entity = httpResponseExecute.getEntity();
            if (entity == null) {
                if (httpClientM2516b instanceof AndroidHttpClient) {
                    ((AndroidHttpClient) httpClientM2516b).close();
                }
                return new C0253a(null, EnumC1304b.ERROR);
            }
            try {
                content = entity.getContent();
                try {
                    try {
                        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(new C1305ba(content));
                        if (!TextUtils.isEmpty(this.f4522d) && C1327bw.m4595a()) {
                            C1294aq.m4508a(bitmapDecodeStream, new File(GlobalApplication.m3100a().getExternalFilesDir(null).getAbsolutePath(), this.f4521c), this.f4522d, Bitmap.CompressFormat.JPEG, 100);
                        }
                        C0253a c0253a3 = new C0253a(bitmapDecodeStream, EnumC1304b.SUCCESS);
                        if (content != null) {
                            content.close();
                        }
                        entity.consumeContent();
                        if (httpClientM2516b instanceof AndroidHttpClient) {
                            ((AndroidHttpClient) httpClientM2516b).close();
                        }
                        return c0253a3;
                    } catch (Throwable th) {
                        th = th;
                        if (content != null) {
                            content.close();
                        }
                        entity.consumeContent();
                        throw th;
                    }
                } catch (OutOfMemoryError e4) {
                    C0253a c0253a4 = new C0253a(null, EnumC1304b.ERROR);
                    if (content != null) {
                        content.close();
                    }
                    entity.consumeContent();
                    if (httpClientM2516b instanceof AndroidHttpClient) {
                        ((AndroidHttpClient) httpClientM2516b).close();
                    }
                    return c0253a4;
                }
            } catch (Throwable th2) {
                th = th2;
                content = null;
            }
        } catch (Throwable th3) {
            if (httpClientM2516b instanceof AndroidHttpClient) {
                ((AndroidHttpClient) httpClientM2516b).close();
            }
            throw th3;
        }
    }

    /* renamed from: a */
    public void m4560a(String str, Bitmap bitmap) {
        if (bitmap != null) {
            synchronized (this.f4523e) {
                this.f4523e.put(str, bitmap);
            }
        }
    }

    /* renamed from: b */
    public Bitmap m4562b(String str) {
        synchronized (this.f4523e) {
            Bitmap bitmap = (Bitmap) this.f4523e.get(str);
            if (bitmap != null) {
                this.f4523e.remove(str);
                this.f4523e.put(str, bitmap);
                return bitmap;
            }
            SoftReference softReference = (SoftReference) f4520b.get(str);
            if (softReference != null) {
                Bitmap bitmap2 = (Bitmap) softReference.get();
                if (bitmap2 == null) {
                    f4520b.remove(str);
                } else {
                    return bitmap2;
                }
            }
            return null;
        }
    }

    /* renamed from: b */
    public void m4563b() {
        synchronized (this.f4523e) {
            this.f4523e.clear();
        }
        f4520b.clear();
    }

    /* renamed from: d */
    private void m4558d() {
        this.f4524f.removeCallbacks(this.f4525g);
        this.f4524f.postDelayed(this.f4525g, 10000L);
    }
}
