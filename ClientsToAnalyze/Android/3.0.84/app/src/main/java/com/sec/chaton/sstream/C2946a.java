package com.sec.chaton.sstream;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import com.sec.chaton.R;
import com.sec.chaton.chat.C1075eq;
import com.sec.chaton.chat.notification.C1111g;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.emoticon.C1835j;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.util.C3172an;
import com.sec.chaton.util.C3250y;
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
public class C2946a {

    /* renamed from: a */
    public static final String f10483a = C2946a.class.getSimpleName();

    /* renamed from: b */
    protected static final Uri f10484b = Uri.parse("content://com.sec.chaton.provider/inbox");

    /* renamed from: a */
    public boolean m10175a(ArrayList<C1111g> arrayList) {
        if (C3250y.f11734b) {
            C3250y.m11450b(":: addStoryItems ::", f10483a);
        }
        if (m10173c() && arrayList != null && arrayList.size() > 0) {
            return m10170a(arrayList.get(0), m10172b(arrayList));
        }
        return false;
    }

    /* renamed from: a */
    private boolean m10170a(C1111g c1111g, boolean z) throws Resources.NotFoundException {
        String strM6361a;
        String strSubstring;
        try {
            Context contextL = GlobalApplication.m11493l();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(GlobalApplication.m6451b(), R.drawable.sstream_bg, options);
            C0004b c0004b = new C0004b(m10171b().toString(), options.outWidth, options.outHeight, null);
            String string = GlobalApplication.m6451b().getString(R.string.unknown);
            if (c1111g.f4499b != null) {
                string = c1111g.f4499b;
            }
            C0003a c0003a = new C0003a(string, null);
            m10169a();
            if (EnumC1455w.m6358a(c1111g.f4504g) == EnumC1455w.TEXT) {
                if (C1075eq.m5326c(c1111g.f4500c)) {
                    strSubstring = c1111g.f4500c.substring(1);
                } else {
                    strSubstring = c1111g.f4500c;
                }
                strM6361a = C1835j.m7508a(contextL, C1075eq.m5327d(strSubstring), (int) C3172an.m11085a(30.0f)).toString();
            } else {
                strM6361a = EnumC1455w.m6361a(EnumC1455w.m6358a(c1111g.f4504g), c1111g.f4500c, string, c1111g.f4512o);
            }
            C0002b.m2a(contextL, new C0006d(m10167a(c1111g.f4502e, c1111g.f4503f).toString(), "samsung.personal", "com.sec.chaton", strM6361a, null, EnumC0007e.MESSAGE, c0003a, c0004b, c1111g.f4501d.longValue() / 1000, z ? -1 : 0, null));
            if (C3250y.f11734b) {
                C3250y.m11450b("The story item is updated to SSTREAM successfully!!! [true] sentTime[" + (c1111g.f4501d.longValue() / 1000) + "]", f10483a);
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
    private Uri m10167a(String str, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("inboxNO", str);
        bundle.putString("chatType", String.valueOf(i));
        return m10168a("chaton", "com.sec.chaton", "sstream", bundle);
    }

    /* renamed from: b */
    private boolean m10172b(ArrayList<C1111g> arrayList) {
        boolean z = true;
        if (arrayList.size() > 1) {
            for (int i = 1; i < arrayList.size(); i++) {
                if (!arrayList.get(0).f4502e.equals(arrayList.get(i).f4502e)) {
                    break;
                }
            }
            z = false;
        } else {
            z = false;
        }
        if (C3250y.f11734b) {
            C3250y.m11450b("more then two chatrooms with unreadmessage [" + z + "]", f10483a);
        }
        return z;
    }

    /* renamed from: a */
    public void m10174a(String str, ArrayList<C1111g> arrayList) {
        try {
            if (m10173c()) {
                if (C3250y.f11734b) {
                    C3250y.m11450b(":: removeStoryItem ::", f10483a);
                }
                m10169a();
                if (!m10175a(arrayList) && C3250y.f11737e) {
                    C3250y.m11442a("addStoryItems() on removeStoryItem is failed.", f10483a);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m10169a() {
        if (C3250y.f11734b) {
            C3250y.m11450b("removeAllStories()", f10483a);
        }
        try {
            C0002b.m3a(GlobalApplication.m11493l(), "com.sec.chaton", "samsung.personal");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private Uri m10171b() {
        if (C3250y.f11733a) {
            C3250y.m11456e("getIconUri()", f10483a);
        }
        return m10168a("android.resource", "com.sec.chaton", "drawable/sstream_bg", null);
    }

    /* renamed from: a */
    private static Uri m10168a(String str, String str2, String str3, Bundle bundle) {
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
    private boolean m10173c() {
        try {
            int applicationEnabledSetting = GlobalApplication.m11493l().getPackageManager().getApplicationEnabledSetting("sstream.app");
            if (applicationEnabledSetting == 3) {
                if (!C3250y.f11734b) {
                    return false;
                }
                C3250y.m11450b("SStream is disabled by user.", f10483a);
                return false;
            }
            if (applicationEnabledSetting == 2) {
                if (!C3250y.f11734b) {
                    return false;
                }
                C3250y.m11450b("SStream is disabled by developer.", f10483a);
                return false;
            }
            if (C3250y.f11734b) {
                C3250y.m11450b("SStream is available.", f10483a);
            }
            return true;
        } catch (IllegalArgumentException e) {
            if (!C3250y.f11737e) {
                return false;
            }
            C3250y.m11442a("Can't retrieve application enabled setting.", f10483a);
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
