package com.sec.chaton.smsplugin.p111h;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.provider.Telephony;
import android.text.TextUtils;
import android.text.util.Linkify;
import android.view.View;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p057e.C2268bn;
import com.sec.chaton.p057e.C2287g;
import com.sec.chaton.p057e.p058a.C2190d;
import com.sec.chaton.provider.ChatONProvider;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p102b.C3789h;
import com.sec.chaton.smsplugin.p102b.C3790i;
import com.sec.chaton.smsplugin.p110g.C3870p;
import com.sec.chaton.smsplugin.p112ui.C4108aq;
import com.sec.chaton.smsplugin.p112ui.C4149cd;
import com.sec.chaton.smsplugin.p112ui.PluginComposeMessageActivity;
import com.sec.chaton.smsplugin.provider.C3959q;
import com.sec.chaton.smsplugin.provider.C3962t;
import com.sec.chaton.smsplugin.transaction.PrivilegedSmsReceiver;
import com.sec.chaton.smsplugin.transaction.PushReceiver;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.common.CommonApplication;
import com.sec.common.util.log.collector.C5043h;
import com.sec.google.android.p134a.C5077a;
import com.sec.google.android.p134a.C5111c;
import com.sec.google.android.p134a.p135a.C5086i;
import com.sec.google.android.p134a.p135a.C5094q;

/* compiled from: MmsUIUtils.java */
/* renamed from: com.sec.chaton.smsplugin.h.o */
/* loaded from: classes.dex */
public class C3892o {

    /* renamed from: a */
    private static final float f13998a = GlobalApplication.m10279a().getResources().getDisplayMetrics().density;

    /* renamed from: b */
    private static ColorStateList f13999b = null;

    /* renamed from: a */
    public static int m15008a(float f) {
        return (int) ((f13998a * f) + 0.5f);
    }

    /* renamed from: a */
    public static void m15015a(TextView textView, int i) {
        if (textView != null) {
            textView.setAutoLinkMask(i);
            Linkify.addLinks(textView, i);
        }
    }

    /* renamed from: a */
    public static int m15007a() {
        return C3847e.m14680al() ? 46 : 15;
    }

    /* renamed from: a */
    public static void m15014a(View view, boolean z) {
        if (view == null) {
            C3890m.m14999e("Mms/UIUtils", "setVibleView null");
        } else {
            view.setVisibility(z ? 0 : 8);
        }
    }

    /* renamed from: b */
    public static boolean m15023b() {
        if (!C3847e.m14686ar()) {
            return false;
        }
        Context contextM18732r = CommonApplication.m18732r();
        try {
            String strM15011a = m15011a(contextM18732r);
            if (strM15011a != null) {
                return strM15011a.equals(contextM18732r.getPackageName());
            }
            return false;
        } catch (NoSuchMethodError e) {
            return false;
        }
    }

    @TargetApi(19)
    /* renamed from: a */
    public static String m15011a(Context context) {
        if (!C3847e.m14686ar()) {
            return null;
        }
        try {
            return Telephony.Sms.getDefaultSmsPackage(context);
        } catch (NoSuchMethodError e) {
            return null;
        }
    }

    /* renamed from: c */
    public static Intent m15026c() {
        if (!C3847e.m14686ar() || m15023b()) {
            return null;
        }
        Intent intent = new Intent("android.provider.Telephony.ACTION_CHANGE_DEFAULT");
        intent.putExtra("package", CommonApplication.m18732r().getPackageName());
        return intent;
    }

    /* renamed from: d */
    public static boolean m15029d() {
        if (!C2349a.m10301a("sms_feature") || !C3847e.m14686ar() || m15023b()) {
            return false;
        }
        return true;
    }

    /* renamed from: e */
    public static void m15031e() {
        if (C3847e.m14686ar()) {
            try {
                String strM15011a = m15011a(CommonApplication.m18732r());
                if (strM15011a == null || !strM15011a.equals(C4809aa.m18104a().m18121a("pref_key_kikat_default_sms", ""))) {
                    C4809aa.m18104a().m18128b("pref_key_kikat_default_sms", strM15011a);
                    if (m15023b()) {
                        C4809aa.m18104a().m18125b("pref_key_using_sms_mms_mode", (Boolean) true);
                        C5043h.m19179a().m19183a("0300", "2120");
                    } else {
                        C4809aa.m18104a().m18125b("pref_key_using_sms_mms_mode", (Boolean) false);
                        C5043h.m19179a().m19183a("0300", "2119");
                    }
                }
            } catch (NoSuchMethodError e) {
            }
        }
    }

    /* renamed from: b */
    public static String m15022b(Context context) {
        if (!C3847e.m14686ar()) {
            return null;
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            return packageManager.getApplicationLabel(packageManager.getApplicationInfo(m15011a(context), 0)).toString();
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        } catch (NoSuchMethodError e2) {
            return null;
        }
    }

    /* renamed from: a */
    public static void m15016a(C4108aq c4108aq, boolean z) {
        Uri uri;
        if ("sms".equals(c4108aq.f15267b)) {
            if (c4108aq.m16309l()) {
                uri = C4149cd.f15441b;
            } else {
                uri = C3962t.f14263a;
            }
        } else {
            uri = C3959q.f14249a;
        }
        Uri uriWithAppendedId = ContentUris.withAppendedId(uri, c4108aq.f15268c);
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("locked", Integer.valueOf(z ? 1 : 0));
        new Thread(new RunnableC3893p(uriWithAppendedId, contentValues), "lockMessage").start();
    }

    /* renamed from: a */
    public static boolean m15017a(long j) {
        C5086i c5086iM14893b;
        try {
            c5086iM14893b = C3870p.m14893b(CommonApplication.m18732r(), ContentUris.withAppendedId(C3959q.f14249a, j));
        } catch (C5111c e) {
            C3890m.m14999e("Mms/UIUtils", "haveSomethingToCopyToSDCard can't load pdu body: " + j);
            c5086iM14893b = null;
        }
        if (c5086iM14893b == null) {
            return false;
        }
        int iM19333b = c5086iM14893b.m19333b();
        for (int i = 0; i < iM19333b; i++) {
            String str = new String(c5086iM14893b.m19328a(i).m19394g());
            C3890m.m14996b("Mms/UIUtils", "[CMA] haveSomethingToCopyToSDCard: part[" + i + "] contentType=" + str);
            if (C5077a.m19288b(str) || C5077a.m19291d(str) || C5077a.m19290c(str) || C5077a.m19293f(str) || C5077a.m19292e(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m15024b(long j) {
        return m15021a(m15030e(j));
    }

    /* renamed from: c */
    public static boolean m15027c(long j) {
        boolean zM15025b = false;
        C5086i c5086iM14893b = null;
        try {
            c5086iM14893b = C3870p.m14893b(CommonApplication.m18732r(), ContentUris.withAppendedId(C3959q.f14249a, j));
        } catch (C5111c e) {
            C3890m.m14999e("Mms/UIUtils", "copyToDrmProvider can't load pdu body: " + j);
        }
        if (c5086iM14893b != null) {
            int iM19333b = c5086iM14893b.m19333b();
            zM15025b = true;
            for (int i = 0; i < iM19333b; i++) {
                C5094q c5094qM19328a = c5086iM14893b.m19328a(i);
                if (C5077a.m19294g(new String(c5094qM19328a.m19394g()))) {
                    zM15025b &= m15025b(c5094qM19328a);
                }
            }
        }
        return zM15025b;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0061 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String m15013a(com.sec.google.android.p134a.p135a.C5094q r7) throws java.lang.Throwable {
        /*
            r3 = 0
            android.net.Uri r1 = r7.m19383b()
            android.content.Context r2 = com.sec.common.CommonApplication.m18732r()     // Catch: java.io.IOException -> L2f com.sec.google.android.mobile1.C5112a -> L41 java.lang.Throwable -> L5d
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch: java.io.IOException -> L2f com.sec.google.android.mobile1.C5112a -> L41 java.lang.Throwable -> L5d
            java.io.InputStream r2 = r2.openInputStream(r1)     // Catch: java.io.IOException -> L2f com.sec.google.android.mobile1.C5112a -> L41 java.lang.Throwable -> L5d
            boolean r1 = r2 instanceof java.io.FileInputStream     // Catch: java.lang.Throwable -> L91 com.sec.google.android.mobile1.C5112a -> L93 java.io.IOException -> L95
            if (r1 == 0) goto L83
            r0 = r2
            java.io.FileInputStream r0 = (java.io.FileInputStream) r0     // Catch: java.lang.Throwable -> L91 com.sec.google.android.mobile1.C5112a -> L93 java.io.IOException -> L95
            r1 = r0
            com.sec.google.android.mobile1.DrmRawContent r4 = new com.sec.google.android.mobile1.DrmRawContent     // Catch: java.lang.Throwable -> L91 com.sec.google.android.mobile1.C5112a -> L93 java.io.IOException -> L95
            int r5 = r1.available()     // Catch: java.lang.Throwable -> L91 com.sec.google.android.mobile1.C5112a -> L93 java.io.IOException -> L95
            java.lang.String r6 = "application/vnd.oma.drm.message"
            r4.<init>(r1, r5, r6)     // Catch: java.lang.Throwable -> L91 com.sec.google.android.mobile1.C5112a -> L93 java.io.IOException -> L95
            java.lang.String r1 = r4.m19505b()     // Catch: java.lang.Throwable -> L91 com.sec.google.android.mobile1.C5112a -> L93 java.io.IOException -> L95
            if (r2 == 0) goto L2e
            r2.close()     // Catch: java.io.IOException -> L78
        L2e:
            return r1
        L2f:
            r1 = move-exception
            r2 = r3
        L31:
            java.lang.String r4 = "Mms/UIUtils"
            java.lang.String r5 = "IOException caught while opening or reading stream"
            com.sec.chaton.smsplugin.p111h.C3890m.m14995a(r4, r5, r1)     // Catch: java.lang.Throwable -> L91
            if (r2 == 0) goto L3f
            r2.close()     // Catch: java.io.IOException -> L70
        L3f:
            r1 = r3
            goto L2e
        L41:
            r1 = move-exception
            r2 = r3
        L43:
            java.lang.String r4 = "Mms/UIUtils"
            java.lang.String r5 = "DrmException caught "
            com.sec.chaton.smsplugin.p111h.C3890m.m14995a(r4, r5, r1)     // Catch: java.lang.Throwable -> L91
            if (r2 == 0) goto L3f
            r2.close()     // Catch: java.io.IOException -> L52
            goto L3f
        L52:
            r1 = move-exception
            java.lang.String r2 = "Mms/UIUtils"
            java.lang.String r4 = "IOException caught while closing stream"
        L59:
            com.sec.chaton.smsplugin.p111h.C3890m.m14995a(r2, r4, r1)
            goto L3f
        L5d:
            r1 = move-exception
            r2 = r3
        L5f:
            if (r2 == 0) goto L64
            r2.close()     // Catch: java.io.IOException -> L65
        L64:
            throw r1
        L65:
            r2 = move-exception
            java.lang.String r3 = "Mms/UIUtils"
            java.lang.String r4 = "IOException caught while closing stream"
            com.sec.chaton.smsplugin.p111h.C3890m.m14995a(r3, r4, r2)
            goto L64
        L70:
            r1 = move-exception
            java.lang.String r2 = "Mms/UIUtils"
            java.lang.String r4 = "IOException caught while closing stream"
            goto L59
        L78:
            r2 = move-exception
            java.lang.String r3 = "Mms/UIUtils"
            java.lang.String r4 = "IOException caught while closing stream"
            com.sec.chaton.smsplugin.p111h.C3890m.m14995a(r3, r4, r2)
            goto L2e
        L83:
            if (r2 == 0) goto L3f
            r2.close()     // Catch: java.io.IOException -> L89
            goto L3f
        L89:
            r1 = move-exception
            java.lang.String r2 = "Mms/UIUtils"
            java.lang.String r4 = "IOException caught while closing stream"
            goto L59
        L91:
            r1 = move-exception
            goto L5f
        L93:
            r1 = move-exception
            goto L43
        L95:
            r1 = move-exception
            goto L31
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.smsplugin.p111h.C3892o.m15013a(com.sec.google.android.a.a.q):java.lang.String");
    }

    /* renamed from: e */
    private static String m15030e(long j) {
        C5086i c5086iM14893b;
        try {
            c5086iM14893b = C3870p.m14893b(CommonApplication.m18732r(), ContentUris.withAppendedId(C3959q.f14249a, j));
        } catch (C5111c e) {
            C3890m.m14999e("Mms/UIUtils", "getDrmMimeType can't load pdu body: " + j);
            c5086iM14893b = null;
        }
        if (c5086iM14893b == null) {
            return null;
        }
        int iM19333b = c5086iM14893b.m19333b();
        for (int i = 0; i < iM19333b; i++) {
            C5094q c5094qM19328a = c5086iM14893b.m19328a(i);
            if (C5077a.m19294g(new String(c5094qM19328a.m19394g()))) {
                return m15013a(c5094qM19328a);
            }
        }
        return null;
    }

    /* renamed from: d */
    public static int m15028d(long j) {
        if (m15021a(m15030e(j))) {
            return R.string.save_ringtone;
        }
        return 0;
    }

    /* renamed from: a */
    public static int m15009a(long j, boolean z) {
        if (m15021a(m15030e(j))) {
            return z ? R.string.saved_ringtone : R.string.saved_ringtone_fail;
        }
        return 0;
    }

    /* renamed from: a */
    private static boolean m15021a(String str) {
        return str != null && str.startsWith("audio/");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x008a  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean m15025b(com.sec.google.android.p134a.p135a.C5094q r9) throws java.io.IOException {
        /*
            r3 = 0
            android.content.Context r6 = com.sec.common.CommonApplication.m18732r()
            android.net.Uri r7 = r9.m19383b()
            r2 = 0
            android.content.ContentResolver r1 = r6.getContentResolver()     // Catch: java.io.IOException -> L72 java.lang.Throwable -> L83
            java.io.InputStream r2 = r1.openInputStream(r7)     // Catch: java.io.IOException -> L72 java.lang.Throwable -> L83
            boolean r1 = r2 instanceof java.io.FileInputStream     // Catch: java.io.IOException -> L72 java.lang.Throwable -> L83
            if (r1 == 0) goto L8a
            r0 = r2
            java.io.FileInputStream r0 = (java.io.FileInputStream) r0     // Catch: java.io.IOException -> L72 java.lang.Throwable -> L83
            r1 = r0
            byte[] r4 = r9.m19397i()     // Catch: java.io.IOException -> L72 java.lang.Throwable -> L83
            if (r4 != 0) goto L24
            byte[] r4 = r9.m19398j()     // Catch: java.io.IOException -> L72 java.lang.Throwable -> L83
        L24:
            if (r4 != 0) goto Lbe
            byte[] r4 = r9.m19390e()     // Catch: java.io.IOException -> L72 java.lang.Throwable -> L83
            r5 = r4
        L2b:
            java.lang.String r4 = new java.lang.String     // Catch: java.io.IOException -> L72 java.lang.Throwable -> L83
            r4.<init>(r5)     // Catch: java.io.IOException -> L72 java.lang.Throwable -> L83
            java.lang.String r5 = "."
            int r5 = r4.indexOf(r5)     // Catch: java.io.IOException -> L72 java.lang.Throwable -> L83
            r8 = -1
            if (r5 != r8) goto L6c
        L3a:
            android.content.ContentResolver r5 = r6.getContentResolver()     // Catch: java.io.IOException -> L72 java.lang.Throwable -> L83
            android.content.Intent r1 = android.provider.DrmStore.addDrmFile(r5, r1, r4)     // Catch: java.io.IOException -> L72 java.lang.Throwable -> L83
            if (r1 != 0) goto L8a
            java.lang.String r1 = "Mms/UIUtils"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L72 java.lang.Throwable -> L83
            r4.<init>()     // Catch: java.io.IOException -> L72 java.lang.Throwable -> L83
            java.lang.String r5 = "unable to add file "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.io.IOException -> L72 java.lang.Throwable -> L83
            java.lang.StringBuilder r4 = r4.append(r7)     // Catch: java.io.IOException -> L72 java.lang.Throwable -> L83
            java.lang.String r5 = " to DrmProvider"
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.io.IOException -> L72 java.lang.Throwable -> L83
            java.lang.String r4 = r4.toString()     // Catch: java.io.IOException -> L72 java.lang.Throwable -> L83
            com.sec.chaton.smsplugin.p111h.C3890m.m14997c(r1, r4)     // Catch: java.io.IOException -> L72 java.lang.Throwable -> L83
            if (r2 == 0) goto L6a
            r2.close()     // Catch: java.io.IOException -> La8
        L6a:
            r1 = r3
        L6b:
            return r1
        L6c:
            r8 = 0
            java.lang.String r4 = r4.substring(r8, r5)     // Catch: java.io.IOException -> L72 java.lang.Throwable -> L83
            goto L3a
        L72:
            r1 = move-exception
            java.lang.String r4 = "Mms/UIUtils"
            java.lang.String r5 = "IOException caught while opening or reading stream"
            com.sec.chaton.smsplugin.p111h.C3890m.m14995a(r4, r5, r1)     // Catch: java.lang.Throwable -> L83
            if (r2 == 0) goto L81
            r2.close()     // Catch: java.io.IOException -> L9d
        L81:
            r1 = r3
            goto L6b
        L83:
            r1 = move-exception
            if (r2 == 0) goto L89
            r2.close()     // Catch: java.io.IOException -> L91
        L89:
            throw r1
        L8a:
            if (r2 == 0) goto L8f
            r2.close()     // Catch: java.io.IOException -> Lb3
        L8f:
            r1 = 1
            goto L6b
        L91:
            r1 = move-exception
            java.lang.String r2 = "Mms/UIUtils"
            java.lang.String r4 = "IOException caught while closing stream"
            com.sec.chaton.smsplugin.p111h.C3890m.m14995a(r2, r4, r1)
        L9b:
            r1 = r3
            goto L6b
        L9d:
            r1 = move-exception
            java.lang.String r2 = "Mms/UIUtils"
            java.lang.String r4 = "IOException caught while closing stream"
            com.sec.chaton.smsplugin.p111h.C3890m.m14995a(r2, r4, r1)
            goto L9b
        La8:
            r1 = move-exception
            java.lang.String r2 = "Mms/UIUtils"
            java.lang.String r4 = "IOException caught while closing stream"
            com.sec.chaton.smsplugin.p111h.C3890m.m14995a(r2, r4, r1)
            goto L9b
        Lb3:
            r1 = move-exception
            java.lang.String r2 = "Mms/UIUtils"
            java.lang.String r4 = "IOException caught while closing stream"
            com.sec.chaton.smsplugin.p111h.C3890m.m14995a(r2, r4, r1)
            goto L9b
        Lbe:
            r5 = r4
            goto L2b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.smsplugin.p111h.C3892o.m15025b(com.sec.google.android.a.a.q):boolean");
    }

    /* renamed from: a */
    public static Intent m15010a(Context context, long j) {
        Intent intent = new Intent(context, (Class<?>) PluginComposeMessageActivity.class);
        if (j > 0) {
            intent.setData(C3790i.m14315a(j));
        }
        return intent;
    }

    /* renamed from: a */
    public static String m15012a(Context context, ContentResolver contentResolver, C3789h c3789h) {
        String strM12420a;
        if (c3789h == null || c3789h.size() != 1) {
            strM12420a = null;
        } else {
            String strM14262d = c3789h.get(0).m14262d();
            SQLiteDatabase writableDatabase = C2268bn.m10126a(context).getWritableDatabase();
            strM12420a = ChatONProvider.m12420a(writableDatabase, strM14262d);
            if (TextUtils.isEmpty(strM12420a) || !ChatONProvider.m12431b(writableDatabase, strM12420a) || !m15018a(contentResolver, strM12420a)) {
                return null;
            }
        }
        return strM12420a;
    }

    /* renamed from: a */
    public static boolean m15018a(ContentResolver contentResolver, String str) {
        String strM9841g = C2190d.m9841g(contentResolver, str);
        if (TextUtils.isEmpty(strM9841g)) {
            C3896s.m15044b("No phone number of buddy = " + str, "Mms/UIUtils");
            return false;
        }
        String[] strArrSplit = strM9841g.split(" ");
        if (strArrSplit.length == 1) {
            C3896s.m15044b("Buddy (" + str + ") has only 1 number = " + strArrSplit[0], "Mms/UIUtils");
            return true;
        }
        String str2 = strArrSplit[0];
        for (int i = 1; i < strArrSplit.length; i++) {
            String str3 = strArrSplit[i];
            boolean zM15019a = m15019a(contentResolver, str2, str3);
            C3896s.m15044b("PHONE_NUMBERS_EQUAL [" + str2 + (zM15019a ? "== " : "!= ") + str3 + "]", "Mms/UIUtils");
            if (!zM15019a) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m15019a(ContentResolver contentResolver, String str, String str2) {
        Cursor cursorQuery = contentResolver.query(Uri.withAppendedPath(C2287g.f8193a, "phone_numbers_equal"), null, null, new String[]{str, str2}, null);
        if (cursorQuery == null) {
            return false;
        }
        boolean z = cursorQuery.moveToFirst() && cursorQuery.getInt(0) == 1;
        cursorQuery.close();
        return z;
    }

    /* renamed from: f */
    public static void m15032f() {
        if (C3847e.m14686ar()) {
            C3890m.m14997c("Mms/UIUtils", "enableKikatSMS PrivilegedSmsReceiver PushReceiver");
            CommonApplication.m18732r().getPackageManager().setComponentEnabledSetting(new ComponentName(CommonApplication.m18732r(), (Class<?>) PrivilegedSmsReceiver.class), 1, 1);
            CommonApplication.m18732r().getPackageManager().setComponentEnabledSetting(new ComponentName(CommonApplication.m18732r(), (Class<?>) PushReceiver.class), 1, 1);
        }
    }

    /* renamed from: g */
    public static void m15033g() {
        if (C3847e.m14686ar()) {
            C3890m.m14997c("Mms/UIUtils", "disableKikatSMS PrivilegedSmsReceiver PushReceiver");
            CommonApplication.m18732r().getPackageManager().setComponentEnabledSetting(new ComponentName(CommonApplication.m18732r(), (Class<?>) PrivilegedSmsReceiver.class), 2, 1);
            CommonApplication.m18732r().getPackageManager().setComponentEnabledSetting(new ComponentName(CommonApplication.m18732r(), (Class<?>) PushReceiver.class), 2, 1);
        }
    }

    /* renamed from: h */
    public static void m15034h() {
        C3890m.m14997c("Mms/UIUtils", "enablePluginCompose PluginComposeMessageActivity");
        CommonApplication.m18732r().getPackageManager().setComponentEnabledSetting(new ComponentName(CommonApplication.m18732r(), (Class<?>) PluginComposeMessageActivity.class), 1, 1);
    }

    /* renamed from: i */
    public static void m15035i() {
        C3890m.m14997c("Mms/UIUtils", "disblePluginCompose PluginComposeMessageActivity");
        CommonApplication.m18732r().getPackageManager().setComponentEnabledSetting(new ComponentName(CommonApplication.m18732r(), (Class<?>) PluginComposeMessageActivity.class), 2, 1);
    }

    /* renamed from: j */
    public static void m15036j() {
        if (C2349a.m10301a("sms_feature")) {
            m15034h();
            if (C3847e.m14686ar() && (C4822an.m18218a() || C4822an.m18201K())) {
                m15032f();
                return;
            } else {
                if (C3847e.m14686ar()) {
                    m15033g();
                    return;
                }
                return;
            }
        }
        m15035i();
        if (C3847e.m14686ar()) {
            m15033g();
        }
    }

    /* renamed from: a */
    public static boolean m15020a(Intent intent) {
        Context contextM18732r = CommonApplication.m18732r();
        if (intent == null || intent.getAction() == "" || contextM18732r.getPackageName().equals(intent.getPackage())) {
            return false;
        }
        String action = intent.getAction();
        Uri data = intent.getData();
        String string = "";
        if (data != null) {
            string = data.toString();
        }
        return "android.intent.action.SENDTO".equals(action) && (string.startsWith("sms") || string.startsWith("smsto") || string.startsWith("mms") || string.startsWith("mmsto"));
    }
}
