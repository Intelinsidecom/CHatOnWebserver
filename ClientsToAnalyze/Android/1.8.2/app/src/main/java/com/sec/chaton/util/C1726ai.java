package com.sec.chaton.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.http.AndroidHttpClient;
import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.p008a.C0102c;
import com.sec.chaton.p022h.C0776c;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
/* renamed from: com.sec.chaton.util.ai */
/* loaded from: classes.dex */
public class C1726ai {

    /* renamed from: a */
    private static C1726ai f6325a;

    /* renamed from: b */
    private static final ConcurrentHashMap f6326b = new ConcurrentHashMap(2);

    /* renamed from: c */
    private String f6327c;

    /* renamed from: d */
    private String f6328d;

    /* renamed from: e */
    private final HashMap f6329e = new C1727aj(this, 2, 0.75f, true);

    /* renamed from: f */
    private final Handler f6330f = new Handler();

    /* renamed from: g */
    private final Runnable f6331g = new RunnableC1728ak(this);

    private C1726ai() {
    }

    /* renamed from: a */
    public static C1726ai m5903a() {
        return f6325a == null ? new C1726ai() : f6325a;
    }

    /* renamed from: a */
    public void m5909a(String str, String str2, String str3, String str4, Bitmap.CompressFormat compressFormat, InterfaceC1731an interfaceC1731an) {
        this.f6327c = str3;
        this.f6328d = str4;
        try {
            m5906d();
            Bitmap bitmapM5910b = m5910b(str2);
            if (bitmapM5910b == null) {
                File file = new File(GlobalApplication.m3260b().getExternalFilesDir(null) + "/profile/", this.f6328d);
                if (file.exists()) {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(new C1792x(fileInputStream));
                    fileInputStream.close();
                    m5908a(str2, bitmapDecodeStream);
                    C1786r.m6066e("Profile image, use exist image", "ImageDownloader");
                    interfaceC1731an.mo2412a(str, bitmapDecodeStream, EnumC1730am.SUCCESS);
                } else {
                    C1786r.m6066e("Profile image, download from Server", "ImageDownloader");
                    m5904a(str2, str, interfaceC1731an);
                }
            } else {
                C1786r.m6066e("Profile image, use from cache", "ImageDownloader");
                interfaceC1731an.mo2412a(str, bitmapM5910b, EnumC1730am.SUCCESS);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (OutOfMemoryError e3) {
            C1786r.m6056a(e3, getClass().getName().toString());
        }
    }

    /* renamed from: a */
    private void m5904a(String str, String str2, InterfaceC1731an interfaceC1731an) {
        if (str != null) {
            new AsyncTaskC1729al(this, interfaceC1731an).execute(str, str2);
        }
    }

    /* renamed from: a */
    C0102c m5907a(String str) {
        HttpResponse httpResponseExecute;
        int statusCode;
        InputStream content;
        HttpGet httpGet = new HttpGet(str);
        HttpClient httpClientM3323b = C0776c.m3323b();
        try {
            try {
                C1786r.m6061b("execute to : " + httpGet.getURI().toString(), "ImageDownloader");
                httpResponseExecute = httpClientM3323b.execute(httpGet);
                statusCode = httpResponseExecute.getStatusLine().getStatusCode();
                C1786r.m6061b("execute end, status code : " + statusCode, "ImageDownloader");
            } catch (IOException e) {
                httpGet.abort();
                C1786r.m6065d("I/O error while retrieving bitmap from " + str, "ImageDownloader");
                if (httpClientM3323b instanceof AndroidHttpClient) {
                    ((AndroidHttpClient) httpClientM3323b).close();
                }
            } catch (IllegalStateException e2) {
                httpGet.abort();
                C1786r.m6065d("Incorrect URL: " + str, "ImageDownloader");
                if (httpClientM3323b instanceof AndroidHttpClient) {
                    ((AndroidHttpClient) httpClientM3323b).close();
                }
            } catch (Exception e3) {
                httpGet.abort();
                C1786r.m6065d("Error while retrieving bitmap", "ImageDownloader");
                if (httpClientM3323b instanceof AndroidHttpClient) {
                    ((AndroidHttpClient) httpClientM3323b).close();
                }
            }
            if (statusCode != 200) {
                if (statusCode == 204) {
                    C0102c c0102c = new C0102c(null, EnumC1730am.NO_CONTENT);
                    if (httpClientM3323b instanceof AndroidHttpClient) {
                        ((AndroidHttpClient) httpClientM3323b).close();
                    }
                    return c0102c;
                }
                C0102c c0102c2 = new C0102c(null, EnumC1730am.ERROR);
                if (httpClientM3323b instanceof AndroidHttpClient) {
                    ((AndroidHttpClient) httpClientM3323b).close();
                }
                return c0102c2;
            }
            HttpEntity entity = httpResponseExecute.getEntity();
            if (entity == null) {
                if (httpClientM3323b instanceof AndroidHttpClient) {
                    ((AndroidHttpClient) httpClientM3323b).close();
                }
                return new C0102c(null, EnumC1730am.ERROR);
            }
            try {
                content = entity.getContent();
                try {
                    try {
                        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(new C1792x(content));
                        if (!TextUtils.isEmpty(this.f6328d) && C1767bw.m6002a()) {
                            C1791w.m6096a(bitmapDecodeStream, new File(GlobalApplication.m3260b().getExternalFilesDir(null).getAbsolutePath(), this.f6327c), this.f6328d, Bitmap.CompressFormat.JPEG, 100);
                        }
                        C0102c c0102c3 = new C0102c(bitmapDecodeStream, EnumC1730am.SUCCESS);
                        if (content != null) {
                            content.close();
                        }
                        entity.consumeContent();
                        if (httpClientM3323b instanceof AndroidHttpClient) {
                            ((AndroidHttpClient) httpClientM3323b).close();
                        }
                        return c0102c3;
                    } catch (Throwable th) {
                        th = th;
                        if (content != null) {
                            content.close();
                        }
                        entity.consumeContent();
                        throw th;
                    }
                } catch (OutOfMemoryError e4) {
                    C0102c c0102c4 = new C0102c(null, EnumC1730am.ERROR);
                    if (content != null) {
                        content.close();
                    }
                    entity.consumeContent();
                    if (httpClientM3323b instanceof AndroidHttpClient) {
                        ((AndroidHttpClient) httpClientM3323b).close();
                    }
                    return c0102c4;
                }
            } catch (Throwable th2) {
                th = th2;
                content = null;
            }
        } catch (Throwable th3) {
            if (httpClientM3323b instanceof AndroidHttpClient) {
                ((AndroidHttpClient) httpClientM3323b).close();
            }
            throw th3;
        }
    }

    /* renamed from: a */
    public void m5908a(String str, Bitmap bitmap) {
        if (bitmap != null) {
            synchronized (this.f6329e) {
                this.f6329e.put(str, bitmap);
            }
        }
    }

    /* renamed from: b */
    public Bitmap m5910b(String str) {
        synchronized (this.f6329e) {
            Bitmap bitmap = (Bitmap) this.f6329e.get(str);
            if (bitmap != null) {
                this.f6329e.remove(str);
                this.f6329e.put(str, bitmap);
                return bitmap;
            }
            SoftReference softReference = (SoftReference) f6326b.get(str);
            if (softReference != null) {
                Bitmap bitmap2 = (Bitmap) softReference.get();
                if (bitmap2 == null) {
                    f6326b.remove(str);
                } else {
                    return bitmap2;
                }
            }
            return null;
        }
    }

    /* renamed from: b */
    public void m5911b() {
        synchronized (this.f6329e) {
            this.f6329e.clear();
        }
        f6326b.clear();
    }

    /* renamed from: d */
    private void m5906d() {
        this.f6330f.removeCallbacks(this.f6331g);
        this.f6330f.postDelayed(this.f6331g, 10000L);
    }
}
