package com.sec.chaton.p074l;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.common.p131f.C4999c;
import com.sec.common.p132g.AbstractRunnableC5005a;
import com.sec.common.p132g.C5007c;
import com.sec.common.util.C5051q;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: ProfileImageManager.java */
/* renamed from: com.sec.chaton.l.n */
/* loaded from: classes.dex */
public class C2496n {

    /* renamed from: c */
    private static C5007c f8948c;

    /* renamed from: f */
    private static boolean f8951f;

    /* renamed from: g */
    private static Map<ImageView, AbstractRunnableC5005a<?>> f8952g;

    /* renamed from: b */
    private static final String f8947b = C2496n.class.getSimpleName();

    /* renamed from: a */
    static final Bitmap f8946a = Bitmap.createBitmap(1, 1, Bitmap.Config.RGB_565);

    /* renamed from: e */
    private static BlockingQueue<Runnable> f8950e = new PriorityBlockingQueue();

    /* renamed from: d */
    private static ThreadPoolExecutor f8949d = new C2506x(f8950e);

    static {
        f8949d.prestartAllCoreThreads();
        f8948c = new C5007c(f8949d);
        f8951f = false;
        f8952g = new HashMap();
        f8949d.submit(new CallableC2494l(GlobalApplication.m18732r()));
    }

    /* renamed from: a */
    static File m10755a(Context context) {
        return context.getFilesDir();
    }

    /* renamed from: a */
    public static boolean m10767a(File file) {
        return (file == null || !file.exists() || file.length() == 0) ? false : true;
    }

    /* renamed from: a */
    public static int m10751a() {
        return R.drawable.profile_photo_buddy_default;
    }

    /* renamed from: a */
    public static Drawable m10754a(EnumC2498p enumC2498p) throws Resources.NotFoundException {
        Drawable drawable = GlobalApplication.m18732r().getResources().getDrawable(m10751a());
        if (enumC2498p == EnumC2498p.ROUND) {
            return new C5051q(((BitmapDrawable) drawable).getBitmap());
        }
        return drawable;
    }

    /* renamed from: b */
    public static Drawable m10769b(EnumC2498p enumC2498p) {
        return m10754a(enumC2498p);
    }

    /* renamed from: a */
    public static int m10752a(EnumC2300t enumC2300t) {
        switch (C2497o.f8953a[enumC2300t.ordinal()]) {
            case 1:
            case 2:
                return R.drawable.contacts_default_broadcast;
            case 3:
                return R.drawable.profile_photo_group_default;
            case 4:
                return R.drawable.contacts_default_topic_chat;
            default:
                return R.drawable.profile_photo_buddy_default;
        }
    }

    /* renamed from: a */
    public static Drawable m10753a(EnumC2300t enumC2300t, EnumC2498p enumC2498p) throws Resources.NotFoundException {
        Drawable drawable = GlobalApplication.m18732r().getResources().getDrawable(m10752a(enumC2300t));
        if (enumC2498p == EnumC2498p.ROUND) {
            return new C5051q(((BitmapDrawable) drawable).getBitmap());
        }
        return drawable;
    }

    /* renamed from: b */
    public static int m10768b() {
        return R.drawable.profile_photo_group_default;
    }

    /* renamed from: c */
    public static Drawable m10779c(EnumC2498p enumC2498p) throws Resources.NotFoundException {
        Drawable drawable = GlobalApplication.m18732r().getResources().getDrawable(m10768b());
        if (enumC2498p == EnumC2498p.ROUND) {
            return new C5051q(((BitmapDrawable) drawable).getBitmap());
        }
        return drawable;
    }

    /* renamed from: c */
    public static int m10778c() {
        return R.drawable.profile_photo_buddy_default;
    }

    /* renamed from: d */
    public static Drawable m10786d(EnumC2498p enumC2498p) throws Resources.NotFoundException {
        Drawable drawable = GlobalApplication.m18732r().getResources().getDrawable(m10778c());
        if (enumC2498p == EnumC2498p.ROUND) {
            return new C5051q(((BitmapDrawable) drawable).getBitmap());
        }
        return drawable;
    }

    /* renamed from: a */
    public static Future<Bitmap> m10758a(Context context, String str, int i) {
        return f8949d.submit(new CallableC2487e(context, str, EnumC2508z.GET, i));
    }

    /* renamed from: b */
    public static Future<Bitmap> m10772b(Context context, String str, int i) {
        return f8949d.submit(new CallableC2491i(context, str, EnumC2508z.GET, i));
    }

    /* renamed from: a */
    public static void m10764a(ImageView imageView, String str) {
        m10765a(imageView, str, EnumC2498p.SQUARE);
    }

    /* renamed from: a */
    public static void m10765a(ImageView imageView, String str, EnumC2498p enumC2498p) {
        C2499q c2499q = new C2499q(str, enumC2498p);
        if (f8951f) {
            if (!f8948c.m19022a(imageView, c2499q)) {
                f8948c.m19015a((View) imageView);
                c2499q.m18990a((View) imageView);
                c2499q.mo7450m_();
                f8952g.put(imageView, c2499q);
                return;
            }
            f8952g.remove(imageView);
            return;
        }
        f8948c.m19023b(imageView, c2499q);
    }

    /* renamed from: a */
    public static void m10766a(ImageView imageView, String str, String str2, EnumC2300t enumC2300t, EnumC2498p enumC2498p) {
        C2500r c2500r = new C2500r(str, str2, enumC2300t, enumC2498p);
        if (f8951f) {
            if (!f8948c.m19022a(imageView, c2500r)) {
                f8948c.m19015a((View) imageView);
                c2500r.m18990a((View) imageView);
                c2500r.mo7450m_();
                f8952g.put(imageView, c2500r);
                return;
            }
            f8952g.remove(imageView);
            return;
        }
        f8948c.m19023b(imageView, c2500r);
    }

    /* renamed from: b */
    public static void m10776b(ImageView imageView, String str) {
        m10777b(imageView, str, EnumC2498p.SQUARE);
    }

    /* renamed from: b */
    public static void m10777b(ImageView imageView, String str, EnumC2498p enumC2498p) {
        C2504v c2504v = new C2504v(str, enumC2498p);
        if (f8951f) {
            if (!f8948c.m19022a(imageView, c2504v)) {
                f8948c.m19015a((View) imageView);
                c2504v.m18990a((View) imageView);
                c2504v.mo7450m_();
                f8952g.put(imageView, c2504v);
                return;
            }
            f8952g.remove(imageView);
            return;
        }
        f8948c.m19023b(imageView, c2504v);
    }

    /* renamed from: a */
    public static void m10763a(ImageView imageView, EnumC2498p enumC2498p) {
        C2505w c2505w = new C2505w(enumC2498p);
        if (f8951f) {
            if (!f8948c.m19022a(imageView, c2505w)) {
                f8948c.m19015a((View) imageView);
                c2505w.m18990a((View) imageView);
                c2505w.mo7450m_();
                f8952g.put(imageView, c2505w);
                return;
            }
            f8952g.remove(imageView);
            return;
        }
        f8948c.m19023b(imageView, c2505w);
    }

    /* renamed from: c */
    public static void m10784c(ImageView imageView, String str, EnumC2498p enumC2498p) {
        C2502t c2502t = new C2502t(str, enumC2498p);
        if (f8951f) {
            if (!f8948c.m19022a(imageView, c2502t)) {
                f8948c.m19015a((View) imageView);
                c2502t.m18990a((View) imageView);
                c2502t.mo7450m_();
                f8952g.put(imageView, c2502t);
                return;
            }
            f8952g.remove(imageView);
            return;
        }
        f8948c.m19023b(imageView, c2502t);
    }

    /* renamed from: b */
    public static void m10775b(ImageView imageView, EnumC2498p enumC2498p) {
        C2501s c2501s = new C2501s(enumC2498p);
        if (f8951f) {
            if (!f8948c.m19022a(imageView, c2501s)) {
                f8948c.m19015a((View) imageView);
                c2501s.m18990a((View) imageView);
                c2501s.mo7450m_();
                f8952g.put(imageView, c2501s);
                return;
            }
            f8952g.remove(imageView);
            return;
        }
        f8948c.m19023b(imageView, c2501s);
    }

    /* renamed from: a */
    public static void m10762a(ImageView imageView) {
        f8948c.m19015a((View) imageView);
        if (f8951f) {
            f8952g.remove(imageView);
        }
    }

    /* renamed from: a */
    public static File m10757a(Context context, String str) {
        return new File(m10755a(context), str + ".jpeg_");
    }

    /* renamed from: c */
    public static File m10781c(Context context, String str, int i) {
        return i == 160 ? m10757a(context, str) : new File(m10755a(context), str + "_" + i + ".jpeg_");
    }

    /* renamed from: b */
    public static File m10771b(Context context, String str) {
        return new File(m10755a(context), str + "_chat_profile.png_");
    }

    /* renamed from: c */
    public static File m10780c(Context context, String str) {
        return new File(m10755a(context), URLEncoder.encode(str + "_group_profile.png_", "UTF-8"));
    }

    /* renamed from: d */
    public static File m10787d(Context context, String str, int i) {
        return i == 160 ? m10780c(context, str) : new File(m10755a(context), URLEncoder.encode(str + "_" + i + "_group_profile.png_", "UTF-8"));
    }

    /* renamed from: b */
    public static File m10770b(Context context) {
        return new File(m10755a(context), "myprofile.png_");
    }

    /* renamed from: a */
    public static File m10756a(Context context, int i) {
        return i == 160 ? m10770b(context) : new File(m10755a(context), i + "_myprofile.png_");
    }

    /* renamed from: d */
    public static Bitmap m10785d(Context context, String str) {
        return m10789e(context, str, 160);
    }

    /* renamed from: e */
    public static Bitmap m10789e(Context context, String str, int i) {
        File fileM10781c = m10781c(context, str, i);
        if (!fileM10781c.exists() || fileM10781c.length() == 0) {
            return null;
        }
        return new C4999c().m18976a(fileM10781c).m18969a();
    }

    /* renamed from: a */
    public static Future<Void> m10759a(Context context, String str, Bitmap bitmap) {
        f8948c.m19021a((Object) (str + 160), true);
        return f8949d.submit(new CallableC2481ab(context, str, bitmap, true));
    }

    /* renamed from: b */
    public static Future<Void> m10773b(Context context, String str, Bitmap bitmap) {
        f8948c.m19021a((Object) str, true);
        return f8949d.submit(new CallableC2482ac(context, str, bitmap, true));
    }

    /* renamed from: c */
    public static Future<Void> m10783c(Context context, String str, Bitmap bitmap) {
        f8948c.m19021a((Object) (str + 160), true);
        return f8949d.submit(new CallableC2483ad(context, str, bitmap, true));
    }

    /* renamed from: a */
    public static Future<Void> m10760a(Context context, String str, String str2) {
        f8948c.m19021a((Object) (str + 160), true);
        return f8949d.submit(new CallableC2480aa(context, str, str2));
    }

    /* renamed from: e */
    public static Future<Void> m10790e(Context context, String str) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(str);
        return m10761a(context, (List<String>) Collections.unmodifiableList(arrayList));
    }

    /* renamed from: a */
    public static Future<Void> m10761a(Context context, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            f8948c.m19021a((Object) (it.next() + 160), true);
        }
        return f8949d.submit(new CallableC2479a(context, list, true));
    }

    /* renamed from: f */
    public static Future<Void> m10793f(Context context, String str) {
        f8948c.m19021a((Object) str, true);
        return f8949d.submit(new CallableC2484b(context, str, true));
    }

    /* renamed from: g */
    public static Future<Void> m10794g(Context context, String str) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(str);
        return m10774b(context, arrayList);
    }

    /* renamed from: b */
    public static Future<Void> m10774b(Context context, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            f8948c.m19021a((Object) (it.next() + 160), true);
        }
        return f8949d.submit(new CallableC2485c(context, list, true));
    }

    /* renamed from: c */
    public static Future<Void> m10782c(Context context) {
        f8948c.m19021a((Object) "myprofile.png_", true);
        return f8949d.submit(new CallableC2486d(context, true));
    }

    /* renamed from: d */
    public static void m10788d() {
        f8951f = true;
    }

    /* renamed from: e */
    public static void m10791e() {
        f8951f = false;
        for (Map.Entry<ImageView, AbstractRunnableC5005a<?>> entry : f8952g.entrySet()) {
            f8948c.m19023b(entry.getKey(), entry.getValue());
        }
        f8952g.clear();
    }
}
