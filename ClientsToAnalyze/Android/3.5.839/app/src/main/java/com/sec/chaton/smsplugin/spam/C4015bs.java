package com.sec.chaton.smsplugin.spam;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SqliteWrapper;
import android.provider.Settings;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.p112ui.SpamSettingActivity;
import com.sec.chaton.smsplugin.provider.C3959q;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.google.android.p134a.p135a.C5082e;
import com.sec.google.android.p134a.p135a.C5083f;
import com.sec.google.android.p134a.p135a.C5086i;
import com.sec.google.android.p134a.p135a.C5094q;
import com.sec.google.android.p134a.p135a.C5095r;
import com.sec.google.android.p134a.p135a.C5097t;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: SpamFilter.java */
/* renamed from: com.sec.chaton.smsplugin.spam.bs */
/* loaded from: classes.dex */
public class C4015bs {

    /* renamed from: a */
    private static C4015bs f14479a;

    /* renamed from: b */
    private final ConcurrentHashMap<Integer, C4017bu> f14480b = new ConcurrentHashMap<>();

    /* renamed from: c */
    private final Context f14481c;

    /* renamed from: a */
    public static void m15437a(Context context) {
        f14479a = new C4015bs(context);
        new Thread(new RunnableC4016bt()).start();
    }

    C4015bs(Context context) {
        this.f14481c = context;
    }

    /* renamed from: a */
    public static void m15431a() {
        C3890m.m14996b("Mms/SpamFilter", "SpamFilter fill() begin");
        Context context = f14479a.f14481c;
        Cursor cursorQuery = SqliteWrapper.query(context, context.getContentResolver(), C4012bp.f14468d, (String[]) null, (String) null, (String[]) null, (String) null);
        if (cursorQuery == null) {
            C3890m.m14998d("Mms/SpamFilter", "null Cursor in fill()");
            return;
        }
        try {
            synchronized (f14479a) {
                f14479a.f14480b.clear();
                while (cursorQuery.moveToNext()) {
                    int i = cursorQuery.getInt(0);
                    int i2 = cursorQuery.getInt(1);
                    boolean z = cursorQuery.getInt(2) != 0;
                    String string = cursorQuery.getString(3);
                    int i3 = cursorQuery.getInt(4);
                    if (z) {
                        f14479a.f14480b.put(Integer.valueOf(i), new C4017bu(i, i2, z, string, i3));
                    }
                }
            }
            cursorQuery.close();
            C3890m.m14994a("Mms/SpamFilter", "SpamFilter fill() finished");
            m15445c();
        } catch (Throwable th) {
            cursorQuery.close();
            throw th;
        }
    }

    /* renamed from: b */
    public static void m15443b() {
        C3890m.m14996b("Mms/SpamFilter", "SpamFilter fillIfCountChanged() begin");
        try {
            Context context = f14479a.f14481c;
            Cursor cursorQuery = SqliteWrapper.query(context, context.getContentResolver(), C4012bp.f14468d, (String[]) null, (String) null, (String[]) null, (String) null);
            if (cursorQuery == null) {
                C3890m.m14997c("Mms/SpamFilter", "null Cursor in fill()");
                return;
            }
            if (cursorQuery != null) {
                try {
                    C3890m.m14996b("Mms/SpamFilter", "###fillIfCountChanged c.getCount():" + cursorQuery.getCount() + " sInstance.mCache.size()" + f14479a.f14480b.size());
                    if (cursorQuery.getCount() == f14479a.f14480b.size()) {
                        C3890m.m14999e("Mms/SpamFilter", "count of db and cache is same. Skip refreshing cache !");
                        cursorQuery.close();
                        return;
                    }
                    synchronized (f14479a) {
                        f14479a.f14480b.clear();
                        while (cursorQuery.moveToNext()) {
                            int i = cursorQuery.getInt(0);
                            int i2 = cursorQuery.getInt(1);
                            boolean z = cursorQuery.getInt(2) != 0;
                            String string = cursorQuery.getString(3);
                            int i3 = cursorQuery.getInt(4);
                            if (z) {
                                f14479a.f14480b.put(Integer.valueOf(i), new C4017bu(i, i2, z, string, i3));
                            }
                        }
                    }
                } finally {
                    cursorQuery.close();
                }
            }
            C3890m.m14996b("Mms/SpamFilter", "SpamFilter fillIfCountChanged() finished");
            m15445c();
        } catch (NullPointerException e) {
            C3890m.m14998d("Mms/SpamFilter", "sInstance is null in fillIfCountChanged()");
        }
    }

    /* renamed from: a */
    public static void m15433a(int i, C4017bu c4017bu) {
        f14479a.f14480b.put(Integer.valueOf(i), c4017bu);
        m15445c();
    }

    /* renamed from: a */
    public static void m15434a(int i, String str) {
        if (!f14479a.f14480b.containsKey(Integer.valueOf(i))) {
            return;
        }
        f14479a.f14480b.get(Integer.valueOf(i)).f14485d = str;
        m15445c();
    }

    /* renamed from: a */
    public static void m15436a(int i, String str, boolean z, int i2) {
        if (f14479a.f14480b.containsKey(Integer.valueOf(i))) {
            C4017bu c4017bu = f14479a.f14480b.get(Integer.valueOf(i));
            c4017bu.f14485d = str;
            c4017bu.f14484c = z;
            c4017bu.f14486e = i2;
            m15445c();
        }
    }

    /* renamed from: a */
    public static void m15435a(int i, String str, boolean z) {
        if (f14479a.f14480b.containsKey(Integer.valueOf(i))) {
            C4017bu c4017bu = f14479a.f14480b.get(Integer.valueOf(i));
            c4017bu.f14485d = str;
            c4017bu.f14484c = z;
            m15445c();
        }
    }

    /* renamed from: a */
    public static void m15432a(int i) {
        if (f14479a.f14480b.containsKey(Integer.valueOf(i))) {
            f14479a.f14480b.remove(Integer.valueOf(i));
        }
        m15445c();
    }

    /* renamed from: b */
    public static void m15444b(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            Iterator<Integer> it = f14479a.f14480b.keySet().iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                C4017bu c4017bu = f14479a.f14480b.get(Integer.valueOf(iIntValue));
                if (C3847e.m14680al()) {
                    if (c4017bu.f14483b == i && str != null && c4017bu.f14485d != null && c4017bu.f14485d.length() != 0 && str.length() != 0) {
                        if (C3959q.m15277a(str)) {
                            str = str.replace(" ", "").replace("-", "");
                        }
                        if (TextUtils.equals(str, c4017bu.f14485d)) {
                            f14479a.f14480b.remove(Integer.valueOf(iIntValue));
                            return;
                        }
                    }
                } else if (c4017bu.f14483b == i && PhoneNumberUtils.compareStrictly(str, c4017bu.f14485d)) {
                    f14479a.f14480b.remove(Integer.valueOf(iIntValue));
                    C3890m.m14996b("Mms/SpamFilter", "SpamFilter delete id : " + iIntValue);
                    return;
                }
                m15445c();
            }
        }
    }

    /* renamed from: a */
    public static boolean m15441a(Context context, C5095r c5095r) {
        C5086i c5086iM19309a;
        if (!C3847e.m14671ac()) {
            return false;
        }
        if (C3847e.m14671ac() && C3847e.m14672ad()) {
            int i = Settings.System.getInt(context.getContentResolver(), "messageblock_mode", 2);
            if (i == 0) {
                return false;
            }
            if (i == 1) {
                return true;
            }
        }
        if ((!C3847e.m14672ad() && !Boolean.valueOf(SpamSettingActivity.m16242a(context)).booleanValue()) || !(c5095r instanceof C5083f) || (c5086iM19309a = ((C5083f) c5095r).m19309a()) == null) {
            return false;
        }
        int iM19333b = c5086iM19309a.m19333b();
        for (int i2 = 0; i2 < iM19333b; i2++) {
            C5094q c5094qM19328a = c5086iM19309a.m19328a(i2);
            try {
                if (c5094qM19328a.m19394g() != null) {
                    String strM19428a = C5097t.m19428a(c5094qM19328a.m19394g());
                    byte[] bArrM19382a = c5094qM19328a.m19382a();
                    if ("text/plain".equals(strM19428a) && bArrM19382a != null && m15439a(context, new C5082e(bArrM19382a))) {
                        return true;
                    }
                } else {
                    continue;
                }
            } catch (Exception e) {
                C3890m.m14999e("Mms/SpamFilter", " isSpam Error..");
            }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m15439a(Context context, C5082e c5082e) {
        String lowerCase;
        if (c5082e == null) {
            lowerCase = null;
        } else {
            lowerCase = c5082e.m19308c().toLowerCase();
        }
        if (TextUtils.isEmpty(lowerCase)) {
            return false;
        }
        try {
        } catch (NullPointerException e) {
            C3890m.m14998d("Mms/SpamFilter", "NullPointerExcetpion occurred. isSpam(context, encText)");
        }
        synchronized (f14479a) {
            Iterator<Integer> it = f14479a.f14480b.keySet().iterator();
            while (it.hasNext()) {
                C4017bu c4017bu = f14479a.f14480b.get(Integer.valueOf(it.next().intValue()));
                if (c4017bu.f14483b != 0 && lowerCase != null && lowerCase.contains(c4017bu.f14485d)) {
                    C3890m.m14996b("Mms/SpamFilter", "filtered by string");
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m15440a(Context context, C5082e c5082e, C5082e c5082e2) {
        return m15442a(context, c5082e != null ? c5082e.m19308c() : null, c5082e2 != null ? c5082e2.m19308c().toLowerCase() : null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: a */
    public static boolean m15442a(Context context, String str, String str2) {
        if (!C3847e.m14671ac()) {
            return false;
        }
        if (C3847e.m14671ac() && C3847e.m14672ad()) {
            int i = Settings.System.getInt(context.getContentResolver(), "messageblock_mode", 2);
            if (i == 0) {
                return false;
            }
            if (i == 1) {
                return true;
            }
            if (C4809aa.m18104a().m18119a("pref_key_spam_option_unknown_num", (Boolean) false).booleanValue() && TextUtils.isEmpty(str)) {
                return true;
            }
        }
        if (!C3847e.m14672ad() && !Boolean.valueOf(SpamSettingActivity.m16242a(context)).booleanValue()) {
            return false;
        }
        boolean zIsEmpty = TextUtils.isEmpty(str);
        boolean zIsEmpty2 = TextUtils.isEmpty(str2);
        if (zIsEmpty && zIsEmpty2) {
            return false;
        }
        m15443b();
        try {
        } catch (NullPointerException e) {
            C3890m.m14998d("Mms/SpamFilter", "NullPointerExcetpion occurred.");
        }
        synchronized (f14479a) {
            Iterator<Integer> it = f14479a.f14480b.keySet().iterator();
            String lowerCase = str2;
            String strReplace = str;
            while (it.hasNext()) {
                C4017bu c4017bu = f14479a.f14480b.get(Integer.valueOf(it.next().intValue()));
                if (c4017bu.f14483b == 0) {
                    if (!zIsEmpty && c4017bu.f14484c) {
                        switch (c4017bu.f14486e) {
                            case 0:
                                C3890m.m14996b("Mms/SpamFilter", "exactly same as data.mFilter: " + c4017bu.f14485d + "number" + strReplace);
                                if (C3847e.m14680al()) {
                                    if (strReplace != null && c4017bu.f14485d != null && c4017bu.f14485d.length() != 0 && strReplace.length() != 0) {
                                        if (C3959q.m15277a(strReplace)) {
                                            strReplace = strReplace.replace(" ", "").replace("-", "");
                                        }
                                        if (TextUtils.equals(strReplace, c4017bu.f14485d)) {
                                            C3890m.m14996b("Mms/SpamFilter", "filtered by number CRITERIA_EXACTLY_SAME");
                                            return true;
                                        }
                                    }
                                } else if (C4013bq.m15428a(strReplace, c4017bu.f14485d)) {
                                    C3890m.m14996b("Mms/SpamFilter", "filtered by number CRITERIA_EXACTLY_SAME");
                                    return true;
                                }
                                strReplace = strReplace;
                                lowerCase = lowerCase;
                                break;
                            case 1:
                                if (strReplace != null && strReplace.startsWith(c4017bu.f14485d)) {
                                    C3890m.m14996b("Mms/SpamFilter", "filtered by number");
                                    return true;
                                }
                                strReplace = strReplace;
                                lowerCase = lowerCase;
                                break;
                            case 2:
                                if (strReplace != null && strReplace.endsWith(c4017bu.f14485d)) {
                                    C3890m.m14996b("Mms/SpamFilter", "filtered by number");
                                    return true;
                                }
                                strReplace = strReplace;
                                lowerCase = lowerCase;
                                break;
                            case 3:
                                if (strReplace != null && strReplace.contains(c4017bu.f14485d)) {
                                    C3890m.m14996b("Mms/SpamFilter", "filtered by number");
                                    return true;
                                }
                                strReplace = strReplace;
                                lowerCase = lowerCase;
                                break;
                            default:
                                strReplace = strReplace;
                                lowerCase = lowerCase;
                                break;
                        }
                    }
                } else if (!zIsEmpty2 && c4017bu.f14484c) {
                    if (lowerCase != null) {
                        lowerCase = lowerCase.toLowerCase();
                        if (lowerCase.contains(c4017bu.f14485d)) {
                            C3890m.m14996b("Mms/SpamFilter", "filtered by string");
                            return true;
                        }
                    }
                    lowerCase = lowerCase;
                }
            }
            C3890m.m14996b("Mms/SpamFilter", "isSpam return false");
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m15438a(Context context, int i, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (f14479a == null) {
            C3890m.m14996b("Mms/SpamFilter", "sInstance == null");
            m15437a(context);
            return false;
        }
        if (!f14479a.f14480b.isEmpty()) {
            Iterator<Integer> it = f14479a.f14480b.keySet().iterator();
            while (it.hasNext()) {
                C4017bu c4017bu = f14479a.f14480b.get(Integer.valueOf(it.next().intValue()));
                if (C3847e.m14680al()) {
                    if (c4017bu.f14483b == i && str != null && c4017bu.f14485d != null && c4017bu.f14485d.length() != 0 && str.length() != 0) {
                        if (C3959q.m15277a(str)) {
                            str = str.replace(" ", "").replace("-", "");
                        }
                        if (TextUtils.equals(str, c4017bu.f14485d)) {
                            C3890m.m14996b("Mms/SpamFilter", "*** checkAlreadyInUse filter:" + str + "data.mFilter" + c4017bu.f14485d);
                            return true;
                        }
                    }
                } else if (c4017bu.f14483b == i && C4013bq.m15428a(str, c4017bu.f14485d)) {
                    return c4017bu.f14486e != 1 || str == null || str.startsWith(c4017bu.f14485d);
                }
            }
        }
        return false;
    }

    /* renamed from: c */
    public static void m15445c() {
        if (C4904y.m18630a() > 0) {
            synchronized (f14479a) {
                C3890m.m14996b("Mms/SpamFilter", "*** Spam cache dump ***");
                Iterator<Integer> it = f14479a.f14480b.keySet().iterator();
                while (it.hasNext()) {
                    int iIntValue = it.next().intValue();
                    C4017bu c4017bu = f14479a.f14480b.get(Integer.valueOf(iIntValue));
                    C3890m.m14996b("Mms/SpamFilter", iIntValue + ": id=" + c4017bu.f14482a + " | filter=" + c4017bu.f14485d + " | type=" + c4017bu.f14483b + " | enable=" + c4017bu.f14484c + " | criteria=" + c4017bu.f14486e);
                }
            }
        }
    }
}
