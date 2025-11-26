package com.sec.chaton.chat;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1007af;
import com.sec.chaton.EnumC1008ag;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.settings.p096a.C3474r;
import com.sec.chaton.settings.p096a.C3481y;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4812ad;
import com.sec.chaton.util.C4822an;
import com.sec.common.util.C5034k;
import java.io.IOException;

/* compiled from: ChatRoomSkinUtil.java */
/* renamed from: com.sec.chaton.chat.gh */
/* loaded from: classes.dex */
public class C1735gh {

    /* renamed from: a */
    private static Bitmap f6534a;

    /* renamed from: b */
    private static Bitmap f6535b;

    /* renamed from: c */
    private static Drawable f6536c;

    /* renamed from: d */
    private static Drawable f6537d;

    /* renamed from: a */
    public static void m8613a() throws IOException {
        m8622c();
        m8624d();
        m8626e();
    }

    /* renamed from: b */
    public static void m8621b() {
        m8614a(f6534a);
        f6534a = null;
        m8614a(f6535b);
        f6535b = null;
        C0991aa.m6037a().m18962d(new C1007af(EnumC1008ag.BACKGROUND));
        C3474r.m13818a(f6536c);
        f6536c = null;
        C0991aa.m6037a().m18962d(new C1007af(EnumC1008ag.SEND_BUBBLE));
        C3474r.m13818a(f6537d);
        f6537d = null;
        C0991aa.m6037a().m18962d(new C1007af(EnumC1008ag.RECEIVE_BUBBLE));
    }

    /* renamed from: c */
    private static void m8622c() throws IOException {
        m8618b(C4822an.m18240i(GlobalApplication.m18732r()), C4809aa.m18104a().m18121a("setting_change_skin", "-1"));
    }

    /* renamed from: a */
    private static void m8617a(boolean z) throws IOException {
        if (z) {
            m8611a(C4822an.m18240i(GlobalApplication.m18732r()), C4809aa.m18104a().m18121a("setting_change_skin", "-1"), z);
        } else {
            m8622c();
        }
    }

    /* renamed from: b */
    private static Bitmap m8618b(int i, String str) throws IOException {
        Context contextR = GlobalApplication.m18732r();
        if ("skin_myskin.png_".equals(str)) {
            if (i == 1) {
                Bitmap bitmapM18156b = C4812ad.m18156b(contextR, C5034k.m19096b(), C5034k.m19098c(), (int) C5034k.m19088a(59.0f));
                f6534a = bitmapM18156b;
                return bitmapM18156b;
            }
            Bitmap bitmapM18139a = C4812ad.m18139a(contextR, C5034k.m19096b(), C5034k.m19098c(), (int) C5034k.m19088a(59.0f));
            f6535b = bitmapM18139a;
            return bitmapM18139a;
        }
        C3481y c3481yM13837f = C3474r.m13837f(contextR, str, true);
        if (c3481yM13837f == null) {
            return null;
        }
        Bitmap bitmap = c3481yM13837f.f12970b;
        f6534a = bitmap;
        return bitmap;
    }

    /* renamed from: a */
    private static Bitmap m8611a(int i, String str, boolean z) throws IOException {
        if (!z) {
            return m8618b(i, str);
        }
        C3481y c3481yM13837f = C3474r.m13837f(GlobalApplication.m18732r(), str, z);
        if (c3481yM13837f == null) {
            return null;
        }
        Bitmap bitmap = c3481yM13837f.f12970b;
        f6534a = bitmap;
        return bitmap;
    }

    /* renamed from: d */
    private static Drawable m8624d() {
        f6536c = C3474r.m13838g(GlobalApplication.m18732r(), C4809aa.m18104a().m18121a("setting_change_bubble_send", "-1"));
        return f6536c;
    }

    /* renamed from: e */
    private static Drawable m8626e() {
        f6537d = C3474r.m13840i(GlobalApplication.m18732r(), C4809aa.m18104a().m18121a("setting_change_bubble_receive", "-1"));
        return f6537d;
    }

    /* renamed from: a */
    public static Bitmap m8610a(int i, String str) {
        Bitmap bitmapM8619b;
        if ("skin_myskin.png_".equals(str) && i == 2) {
            bitmapM8619b = m8619b(f6535b);
        } else {
            bitmapM8619b = m8619b(f6534a);
        }
        return bitmapM8619b != null ? bitmapM8619b : m8618b(i, str);
    }

    /* renamed from: a */
    public static Drawable m8612a(String str) {
        return f6536c != null ? f6536c : m8624d();
    }

    /* renamed from: b */
    public static Drawable m8620b(String str) {
        return f6537d != null ? f6537d : m8626e();
    }

    /* renamed from: a */
    public static void m8615a(String str, String str2) {
        C4809aa.m18104a().m18128b("setting_change_skin", str);
        C4809aa.m18104a().m18128b("setting_change_skin_type", str2);
        m8614a(f6534a);
        f6534a = null;
        m8614a(f6535b);
        f6535b = null;
        m8622c();
        C0991aa.m6037a().m18962d(new C1007af(EnumC1008ag.BACKGROUND));
    }

    /* renamed from: a */
    public static void m8616a(String str, String str2, boolean z) {
        if (z) {
            C4809aa.m18104a().m18128b("setting_change_skin", str);
            C4809aa.m18104a().m18128b("setting_change_skin_type", str2);
            m8614a(f6534a);
            f6534a = null;
            m8614a(f6535b);
            f6535b = null;
            m8617a(z);
            C0991aa.m6037a().m18962d(new C1007af(EnumC1008ag.BACKGROUND));
            return;
        }
        m8615a(str, str2);
    }

    /* renamed from: c */
    public static void m8623c(String str) {
        C4809aa.m18104a().m18128b("setting_change_bubble_send", str);
        C3474r.m13818a(f6536c);
        f6536c = null;
        m8624d();
        C0991aa.m6037a().m18962d(new C1007af(EnumC1008ag.SEND_BUBBLE));
    }

    /* renamed from: d */
    public static void m8625d(String str) {
        C4809aa.m18104a().m18128b("setting_change_bubble_receive", str);
        C3474r.m13818a(f6537d);
        f6537d = null;
        m8626e();
        C0991aa.m6037a().m18962d(new C1007af(EnumC1008ag.RECEIVE_BUBBLE));
    }

    /* renamed from: a */
    private static void m8614a(Bitmap bitmap) {
        Bitmap bitmapM8619b = m8619b(bitmap);
        if (bitmapM8619b != null) {
            bitmapM8619b.recycle();
        }
    }

    /* renamed from: b */
    private static Bitmap m8619b(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }
}
