package com.sec.chaton.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.http.AndroidHttpClient;
import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.common.entry.ImageRequestResult;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.network.ChatONHttpClient2;
import com.sec.chaton.util.ChatOnGraphics;
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

/* loaded from: classes.dex */
public class ImageDownloader {

    /* renamed from: a */
    private static ImageDownloader f3678a;

    /* renamed from: b */
    private static final ConcurrentHashMap f3679b = new ConcurrentHashMap(2);

    /* renamed from: c */
    private String f3680c;

    /* renamed from: d */
    private String f3681d;

    /* renamed from: e */
    private final HashMap f3682e = new C0604b(this, 2, 0.75f, true);

    /* renamed from: f */
    private final Handler f3683f = new Handler();

    /* renamed from: g */
    private final Runnable f3684g = new RunnableC0603a(this);

    public enum ImageDownResult {
        SUCCESS,
        NO_CONTENT,
        ERROR
    }

    public enum Mode {
        CORRECT
    }

    public interface OnImageLoaded {
        /* renamed from: a */
        void mo653a(String str, Bitmap bitmap, ImageDownResult imageDownResult);
    }

    private ImageDownloader() {
    }

    /* renamed from: a */
    public static ImageDownloader m3585a() {
        return f3678a == null ? new ImageDownloader() : f3678a;
    }

    /* renamed from: a */
    private void m3586a(String str, String str2, OnImageLoaded onImageLoaded) {
        if (str == null) {
            return;
        }
        new AsyncTaskC0617o(this, onImageLoaded).execute(str, str2);
    }

    /* renamed from: d */
    private void m3588d() {
        this.f3683f.removeCallbacks(this.f3684g);
        this.f3683f.postDelayed(this.f3684g, 10000L);
    }

    /* renamed from: a */
    ImageRequestResult m3589a(String str) {
        HttpResponse httpResponseExecute;
        int statusCode;
        InputStream inputStream;
        HttpGet httpGet = new HttpGet(str);
        HttpClient httpClientM2721b = ChatONHttpClient2.m2721b();
        try {
            try {
                ChatONLogWriter.m3506b("execute to : " + httpGet.getURI().toString(), "ImageDownloader");
                httpResponseExecute = httpClientM2721b.execute(httpGet);
                statusCode = httpResponseExecute.getStatusLine().getStatusCode();
                ChatONLogWriter.m3506b("execute end, status code : " + statusCode, "ImageDownloader");
            } catch (IOException e) {
                httpGet.abort();
                ChatONLogWriter.m3510d("I/O error while retrieving bitmap from " + str, "ImageDownloader");
                if (httpClientM2721b instanceof AndroidHttpClient) {
                    ((AndroidHttpClient) httpClientM2721b).close();
                }
            } catch (IllegalStateException e2) {
                httpGet.abort();
                ChatONLogWriter.m3510d("Incorrect URL: " + str, "ImageDownloader");
                if (httpClientM2721b instanceof AndroidHttpClient) {
                    ((AndroidHttpClient) httpClientM2721b).close();
                }
            } catch (Exception e3) {
                httpGet.abort();
                ChatONLogWriter.m3510d("Error while retrieving bitmap", "ImageDownloader");
                if (httpClientM2721b instanceof AndroidHttpClient) {
                    ((AndroidHttpClient) httpClientM2721b).close();
                }
            }
            if (statusCode != 200) {
                if (statusCode == 204) {
                    ImageRequestResult imageRequestResult = new ImageRequestResult(null, ImageDownResult.NO_CONTENT);
                    if (httpClientM2721b instanceof AndroidHttpClient) {
                        ((AndroidHttpClient) httpClientM2721b).close();
                    }
                    return imageRequestResult;
                }
                ImageRequestResult imageRequestResult2 = new ImageRequestResult(null, ImageDownResult.ERROR);
                if (httpClientM2721b instanceof AndroidHttpClient) {
                    ((AndroidHttpClient) httpClientM2721b).close();
                }
                return imageRequestResult2;
            }
            HttpEntity entity = httpResponseExecute.getEntity();
            if (entity == null) {
                if (httpClientM2721b instanceof AndroidHttpClient) {
                    ((AndroidHttpClient) httpClientM2721b).close();
                }
                return new ImageRequestResult(null, ImageDownResult.ERROR);
            }
            try {
                InputStream content = entity.getContent();
                try {
                    try {
                        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(new ChatOnGraphics.FlushedInputStream(content));
                        if (!TextUtils.isEmpty(this.f3681d) && StorageStateInfoUtil.m3677a()) {
                            ChatOnGraphics.m3538a(bitmapDecodeStream, new File(GlobalApplication.m2387e().getExternalFilesDir(null).getAbsolutePath(), this.f3680c), this.f3681d, Bitmap.CompressFormat.JPEG, 100);
                        }
                        ImageRequestResult imageRequestResult3 = new ImageRequestResult(bitmapDecodeStream, ImageDownResult.SUCCESS);
                        if (content != null) {
                            content.close();
                        }
                        entity.consumeContent();
                        if (httpClientM2721b instanceof AndroidHttpClient) {
                            ((AndroidHttpClient) httpClientM2721b).close();
                        }
                        return imageRequestResult3;
                    } catch (Throwable th) {
                        inputStream = content;
                        th = th;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        entity.consumeContent();
                        throw th;
                    }
                } catch (OutOfMemoryError e4) {
                    ImageRequestResult imageRequestResult4 = new ImageRequestResult(null, ImageDownResult.ERROR);
                    if (content != null) {
                        content.close();
                    }
                    entity.consumeContent();
                    if (httpClientM2721b instanceof AndroidHttpClient) {
                        ((AndroidHttpClient) httpClientM2721b).close();
                    }
                    return imageRequestResult4;
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
            }
        } catch (Throwable th3) {
            if (httpClientM2721b instanceof AndroidHttpClient) {
                ((AndroidHttpClient) httpClientM2721b).close();
            }
            throw th3;
        }
    }

    /* renamed from: a */
    public void m3590a(String str, Bitmap bitmap) {
        if (bitmap != null) {
            synchronized (this.f3682e) {
                this.f3682e.put(str, bitmap);
            }
        }
    }

    /* renamed from: a */
    public void m3591a(String str, String str2, String str3, String str4, Bitmap.CompressFormat compressFormat, OnImageLoaded onImageLoaded) {
        this.f3680c = str3;
        this.f3681d = str4;
        m3588d();
        Bitmap bitmapM3592b = m3592b(str2);
        if (bitmapM3592b != null) {
            ChatONLogWriter.m3511e("Profile image, use from cache", "ImageDownloader");
            onImageLoaded.mo653a(str, bitmapM3592b, ImageDownResult.SUCCESS);
            return;
        }
        File file = new File(GlobalApplication.m2387e().getExternalFilesDir(null) + "/profile/", this.f3681d);
        if (!file.exists()) {
            ChatONLogWriter.m3511e("Profile image, download from Server", "ImageDownloader");
            m3586a(str2, str, onImageLoaded);
        } else {
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(file.toString());
            m3590a(str2, bitmapDecodeFile);
            ChatONLogWriter.m3511e("Profile image, use exist image", "ImageDownloader");
            onImageLoaded.mo653a(str, bitmapDecodeFile, ImageDownResult.SUCCESS);
        }
    }

    /* renamed from: b */
    public Bitmap m3592b(String str) {
        synchronized (this.f3682e) {
            Bitmap bitmap = (Bitmap) this.f3682e.get(str);
            if (bitmap != null) {
                this.f3682e.remove(str);
                this.f3682e.put(str, bitmap);
                return bitmap;
            }
            SoftReference softReference = (SoftReference) f3679b.get(str);
            if (softReference != null) {
                Bitmap bitmap2 = (Bitmap) softReference.get();
                if (bitmap2 != null) {
                    return bitmap2;
                }
                f3679b.remove(str);
            }
            return null;
        }
    }

    /* renamed from: b */
    public void m3593b() {
        synchronized (this.f3682e) {
            this.f3682e.clear();
        }
        f3679b.clear();
    }
}
