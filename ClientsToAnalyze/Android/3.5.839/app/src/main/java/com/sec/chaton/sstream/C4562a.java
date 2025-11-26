package com.sec.chaton.sstream;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import com.sec.chaton.R;
import com.sec.chaton.chat.C1736gi;
import com.sec.chaton.chat.notification.C1830s;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.emoticon.C2799k;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.plugin.C2948h;
import com.sec.chaton.plugin.EnumC2949i;
import com.sec.chaton.util.C4904y;
import com.sec.common.util.C5034k;
import com.sec.spp.push.Config;
import java.util.ArrayList;
import p000a.p001a.C0000a;
import p000a.p001a.C0002b;
import p000a.p001a.p003b.C0003a;
import p000a.p001a.p003b.C0004b;
import p000a.p001a.p003b.C0006d;
import p000a.p001a.p003b.EnumC0007e;

/* compiled from: SStream.java */
/* renamed from: com.sec.chaton.sstream.a */
/* loaded from: classes.dex */
public class C4562a {

    /* renamed from: a */
    public static final String f16435a = C4562a.class.getSimpleName();

    /* renamed from: b */
    protected static final Uri f16436b = Uri.parse("content://com.sec.chaton.provider/inbox");

    /* renamed from: a */
    public boolean m17258a(ArrayList<C1830s> arrayList) {
        if (C4904y.f17872b) {
            C4904y.m18639b(":: addStoryItems ::", f16435a);
        }
        if (m17256c() && arrayList != null && arrayList.size() > 0) {
            return m17254a(arrayList.get(0), m17257d(arrayList));
        }
        return false;
    }

    /* renamed from: a */
    private boolean m17254a(C1830s c1830s, boolean z) throws Resources.NotFoundException {
        String strM10073a;
        String strSubstring;
        try {
            Context contextR = GlobalApplication.m18732r();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(GlobalApplication.m10283b(), R.drawable.sstream_bg, options);
            C0004b c0004b = new C0004b(m17255b().toString(), options.outWidth, options.outHeight, null);
            String string = GlobalApplication.m10283b().getString(R.string.unknown);
            if (c1830s.f6928b != null) {
                string = c1830s.f6928b;
            }
            C0003a c0003a = new C0003a(string, null);
            m17253a();
            if (EnumC2214ab.m10070a(c1830s.f6933g) == EnumC2214ab.TEXT) {
                if (C1736gi.m8652d(c1830s.f6929c)) {
                    strSubstring = c1830s.f6929c.substring(1);
                } else {
                    strSubstring = c1830s.f6929c;
                }
                strM10073a = C2799k.m11709a(contextR, C1736gi.m8653e(strSubstring), (int) C5034k.m19088a(30.0f)).toString();
            } else {
                strM10073a = EnumC2214ab.m10073a(EnumC2214ab.m10070a(c1830s.f6933g), c1830s.f6929c, string, c1830s.f6941o);
            }
            C0002b.m2a(contextR, new C0006d(m17251a(c1830s).toString(), "samsung.personal", Config.CHATON_PACKAGE_NAME, strM10073a, null, EnumC0007e.MESSAGE, c0003a, c0004b, c1830s.f6930d.longValue() / 1000, z ? -1 : 0, null));
            if (C4904y.f17872b) {
                C4904y.m18639b("The story item is updated to SSTREAM successfully!!! [true] sentTime[" + (c1830s.f6930d.longValue() / 1000) + "]", f16435a);
                return true;
            }
            return true;
        } catch (C0000a e) {
            e.printStackTrace();
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    private Uri m17251a(C1830s c1830s) {
        Bundle bundle = new Bundle();
        if (c1830s.f6932f == EnumC2300t.GROUPCHAT.m10210a() || c1830s.f6932f == EnumC2300t.TOPIC.m10210a()) {
            bundle.putString("inboxNO", c1830s.f6931e);
        } else {
            bundle.putString("inboxNO", c1830s.f6927a);
        }
        bundle.putString("chatType", String.valueOf(c1830s.f6932f));
        return m17252a("chaton", Config.CHATON_PACKAGE_NAME, "sstream", bundle);
    }

    /* renamed from: d */
    private boolean m17257d(ArrayList<C1830s> arrayList) {
        boolean z = true;
        if (arrayList.size() > 1) {
            for (int i = 1; i < arrayList.size(); i++) {
                if (!arrayList.get(0).f6931e.equals(arrayList.get(i).f6931e)) {
                    break;
                }
            }
            z = false;
        } else {
            z = false;
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("more then two chatrooms with unreadmessage [" + z + "]", f16435a);
        }
        return z;
    }

    /* renamed from: b */
    public void m17259b(ArrayList<C1830s> arrayList) {
        try {
            if (m17256c()) {
                if (C4904y.f17872b) {
                    C4904y.m18639b(":: removeStoryItem ::", f16435a);
                }
                m17253a();
                if (!m17258a(arrayList) && C4904y.f17872b) {
                    C4904y.m18639b("addStoryItems() on removeStoryItem is failed.", f16435a);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    public void m17260c(ArrayList<C1830s> arrayList) {
        try {
            if (m17256c()) {
                m17253a();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m17253a() {
        if (C4904y.f17872b) {
            C4904y.m18639b("removeAllStories()", f16435a);
        }
        try {
            C0002b.m3a(GlobalApplication.m18732r(), Config.CHATON_PACKAGE_NAME, "samsung.personal");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private Uri m17255b() {
        if (C4904y.f17871a) {
            C4904y.m18646e("getIconUri()", f16435a);
        }
        return m17252a("android.resource", Config.CHATON_PACKAGE_NAME, "drawable/sstream_bg", null);
    }

    /* renamed from: a */
    private static Uri m17252a(String str, String str2, String str3, Bundle bundle) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(str);
        builder.authority(str2);
        builder.path(str3);
        if (bundle != null) {
            for (String str4 : bundle.keySet()) {
                Object obj = bundle.get(str4);
                if (obj instanceof String) {
                    builder.appendQueryParameter(str4, (String) obj);
                }
            }
        }
        return builder.build();
    }

    /* renamed from: c */
    private boolean m17256c() {
        return C2948h.m12190a().m12192a(GlobalApplication.m18732r(), EnumC2949i.SStream);
    }
}
