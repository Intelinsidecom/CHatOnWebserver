package com.sec.chaton.settings.tellfriends;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.widget.ImageView;
import com.sec.chaton.util.C1786r;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/* compiled from: TellFriendsImageDownloader.java */
/* renamed from: com.sec.chaton.settings.tellfriends.bt */
/* loaded from: classes.dex */
class C1392bt {

    /* renamed from: a */
    private static final String f5247a = C1392bt.class.getSimpleName();

    /* renamed from: d */
    private static final ConcurrentHashMap f5248d = new ConcurrentHashMap(50);

    /* renamed from: b */
    private AsyncTaskC1395bw f5249b;

    /* renamed from: c */
    private final HashMap f5250c = new C1393bu(this, 50, 0.75f, true);

    /* renamed from: e */
    private final Handler f5251e = new Handler();

    /* renamed from: f */
    private final Runnable f5252f = new RunnableC1394bv(this);

    C1392bt() {
    }

    /* renamed from: a */
    public void m5145a(String str, ImageView imageView) {
        m5141c();
        Bitmap bitmapM5137b = m5137b(str);
        if (bitmapM5137b == null) {
            m5140b(str, imageView);
        } else {
            m5142c(str, imageView);
            imageView.setImageBitmap(bitmapM5137b);
        }
    }

    /* renamed from: b */
    private void m5140b(String str, ImageView imageView) {
        if (str == null) {
            imageView.setImageDrawable(null);
        } else if (m5142c(str, imageView)) {
            this.f5249b = new AsyncTaskC1395bw(this, imageView);
            imageView.setImageDrawable(new C1396bx(this.f5249b));
            this.f5249b.execute(str);
        }
    }

    /* renamed from: c */
    private static boolean m5142c(String str, ImageView imageView) {
        AsyncTaskC1395bw asyncTaskC1395bwM5138b = m5138b(imageView);
        if (asyncTaskC1395bwM5138b == null) {
            return true;
        }
        String str2 = asyncTaskC1395bwM5138b.f5256b;
        if (str2 == null || !str2.equals(str)) {
            asyncTaskC1395bwM5138b.cancel(true);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static AsyncTaskC1395bw m5138b(ImageView imageView) {
        if (imageView != null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable instanceof C1396bx) {
                return ((C1396bx) drawable).m5149a();
            }
        }
        return null;
    }

    /* renamed from: a */
    Bitmap m5143a(String str) throws Throwable {
        InputStream content;
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(str);
        try {
            HttpResponse httpResponseExecute = defaultHttpClient.execute(httpGet);
            int statusCode = httpResponseExecute.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                C1786r.m6065d("Error " + statusCode + " while retrieving bitmap from " + str, f5247a);
                return null;
            }
            C1786r.m6061b("Success " + statusCode + " while retrieving bitmap from " + str, f5247a);
            HttpEntity entity = httpResponseExecute.getEntity();
            if (entity == null) {
                return null;
            }
            try {
                content = entity.getContent();
            } catch (Throwable th) {
                th = th;
                content = null;
            }
            try {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(new C1397by(content));
                if (content != null) {
                    content.close();
                }
                entity.consumeContent();
                return bitmapDecodeStream;
            } catch (Throwable th2) {
                th = th2;
                if (content != null) {
                    content.close();
                }
                entity.consumeContent();
                throw th;
            }
        } catch (IOException e) {
            httpGet.abort();
            C1786r.m6065d("I/O error while retrieving bitmap from " + str, f5247a);
            return null;
        } catch (IllegalStateException e2) {
            httpGet.abort();
            C1786r.m6065d("Incorrect URL: " + str, f5247a);
            return null;
        } catch (Exception e3) {
            httpGet.abort();
            C1786r.m6065d("Error while retrieving bitmap from " + str, f5247a);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5136a(String str, Bitmap bitmap) {
        if (bitmap != null) {
            synchronized (this.f5250c) {
                this.f5250c.put(str, bitmap);
            }
        }
    }

    /* renamed from: b */
    private Bitmap m5137b(String str) {
        Bitmap bitmap;
        if (str == null) {
            return null;
        }
        synchronized (this.f5250c) {
            bitmap = (Bitmap) this.f5250c.get(str);
            if (bitmap != null) {
                this.f5250c.remove(str);
                this.f5250c.put(str, bitmap);
            } else {
                SoftReference softReference = (SoftReference) f5248d.get(str);
                if (softReference == null) {
                    bitmap = null;
                } else {
                    bitmap = (Bitmap) softReference.get();
                    if (bitmap == null) {
                        f5248d.remove(str);
                        bitmap = null;
                    }
                }
            }
        }
        return bitmap;
    }

    /* renamed from: a */
    public void m5144a() {
        this.f5250c.clear();
        f5248d.clear();
    }

    /* renamed from: c */
    private void m5141c() {
        this.f5251e.removeCallbacks(this.f5252f);
        this.f5251e.postDelayed(this.f5252f, 120000L);
    }
}
