package com.sec.chaton.smsplugin.p102b;

import android.net.Uri;
import android.os.Parcelable;
import android.os.SystemProperties;
import android.text.TextUtils;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.p112ui.C4149cd;
import com.sec.spp.push.Config;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ContactList.java */
/* renamed from: com.sec.chaton.smsplugin.b.h */
/* loaded from: classes.dex */
public class C3789h extends ArrayList<C3782a> {
    /* renamed from: a */
    public static C3789h m14301a(Iterable<String> iterable, boolean z) {
        C3789h c3789h = new C3789h();
        for (String str : iterable) {
            if (!TextUtils.isEmpty(str)) {
                c3789h.add(C3782a.m14204a(str, z));
            }
        }
        return c3789h;
    }

    /* renamed from: a */
    public static C3789h m14302a(Iterable<String> iterable, boolean z, boolean z2) {
        C3789h c3789h = new C3789h();
        for (String str : iterable) {
            if (!TextUtils.isEmpty(str)) {
                C3782a c3782aM14204a = C3782a.m14204a(str, z);
                if (z2) {
                    c3782aM14204a.m14258b(str);
                }
                c3789h.add(c3782aM14204a);
            }
        }
        return c3789h;
    }

    /* renamed from: a */
    public static C3789h m14304a(String str, boolean z, boolean z2) {
        C3789h c3789h = new C3789h();
        for (String str2 : str.split(Config.KEYVALUE_SPLIT)) {
            if (!TextUtils.isEmpty(str2)) {
                C3782a c3782aM14204a = C3782a.m14204a(str2, z);
                if (z2) {
                    c3782aM14204a.m14258b(str2);
                }
                c3789h.add(c3782aM14204a);
            }
        }
        return c3789h;
    }

    /* renamed from: a */
    public static ArrayList<String> m14306a(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str2 : str.split(Config.KEYVALUE_SPLIT)) {
            if (!TextUtils.isEmpty(str2)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static C3789h m14305a(Parcelable[] parcelableArr) {
        C3789h c3789h = new C3789h();
        if (parcelableArr != null && parcelableArr.length > 0) {
            for (Parcelable parcelable : parcelableArr) {
                Uri uri = (Uri) parcelable;
                if ("tel".equals(uri.getScheme())) {
                    c3789h.add(C3782a.m14204a(uri.getSchemeSpecificPart(), true));
                }
            }
            List<C3782a> listM14209a = C3782a.m14209a(parcelableArr);
            if (listM14209a != null) {
                c3789h.addAll(listM14209a);
            }
        }
        return c3789h;
    }

    /* renamed from: a */
    public static C3789h m14303a(String str, boolean z) {
        C3789h c3789h = new C3789h();
        if (C3795n.m14378a() == null) {
            return c3789h;
        }
        for (C3798q c3798q : C3795n.m14380a(str)) {
            if (c3798q != null && !TextUtils.isEmpty(c3798q.f13626b)) {
                C3782a c3782aM14204a = C3782a.m14204a(c3798q.f13626b, z);
                c3782aM14204a.m14257a(c3798q.f13625a);
                c3789h.add(c3782aM14204a);
            }
        }
        return c3789h;
    }

    /* renamed from: b */
    public String m14310b(String str) {
        String[] strArr = new String[size()];
        Iterator<C3782a> it = iterator();
        int i = 0;
        while (it.hasNext()) {
            strArr[i] = it.next().m14264f();
            i++;
        }
        return TextUtils.join(str, strArr);
    }

    /* renamed from: a */
    public String m14308a() {
        return TextUtils.join(Config.KEYVALUE_SPLIT, m14313c());
    }

    /* renamed from: b */
    public boolean m14311b() {
        Iterator<C3782a> it = iterator();
        while (it.hasNext()) {
            if (it.next().m14272n()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    public String[] m14313c() {
        return m14312b(false);
    }

    /* renamed from: a */
    public String[] m14309a(boolean z) {
        ArrayList arrayList = new ArrayList();
        Iterator<C3782a> it = iterator();
        while (it.hasNext()) {
            String strM14307c = m14307c(it.next().m14262d());
            if (z) {
                strM14307c = C4149cd.m16437g(strM14307c);
            }
            if (!TextUtils.isEmpty(strM14307c) && !arrayList.contains(strM14307c)) {
                arrayList.add(strM14307c);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* renamed from: b */
    public String[] m14312b(boolean z) {
        ArrayList arrayList = new ArrayList();
        Iterator<C3782a> it = iterator();
        while (it.hasNext()) {
            String strM14262d = it.next().m14262d();
            if (z) {
                strM14262d = C4149cd.m16437g(strM14262d);
            }
            if (!TextUtils.isEmpty(strM14262d) && !arrayList.contains(strM14262d)) {
                arrayList.add(strM14262d);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            C3789h c3789h = (C3789h) obj;
            if (size() != c3789h.size()) {
                return false;
            }
            Iterator<C3782a> it = iterator();
            while (it.hasNext()) {
                if (!c3789h.contains(it.next())) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException e) {
            return false;
        }
    }

    /* renamed from: c */
    public static String m14307c(String str) {
        String str2 = SystemProperties.get("gsm.operator.numeric", "");
        if (!TextUtils.isEmpty(str2)) {
            if (str2.equals("45006") || str2.equals("450 06")) {
                if (!TextUtils.isEmpty(str)) {
                    if (str.startsWith("+821")) {
                        str = str.replace("+821", "01");
                    } else if (str.startsWith("+820")) {
                        str = str.replace("+820", Spam.ACTIVITY_CANCEL);
                    }
                    C3890m.m14996b("Mms", "normalizeNumber: returning number string=" + str);
                    return str;
                }
                return str;
            }
            if (str2.substring(0, 3).equals("450") && !TextUtils.isEmpty(str)) {
                if (str.startsWith("820")) {
                    return Spam.ACTIVITY_CANCEL + str.substring("820".length());
                }
                if (str.startsWith("+820") || str.startsWith("0820")) {
                    return Spam.ACTIVITY_CANCEL + str.substring("+820".length());
                }
                if (str.startsWith("+0820") || str.startsWith("00820")) {
                    return Spam.ACTIVITY_CANCEL + str.substring("+0820".length());
                }
                if (str.startsWith("8210")) {
                    return "010" + str.substring("8210".length());
                }
                if (str.startsWith("08210")) {
                    return "010" + str.substring("08210".length());
                }
                if (str.startsWith("0082010")) {
                    return "010" + str.substring("0082010".length());
                }
                return str;
            }
            return str;
        }
        return str;
    }
}
