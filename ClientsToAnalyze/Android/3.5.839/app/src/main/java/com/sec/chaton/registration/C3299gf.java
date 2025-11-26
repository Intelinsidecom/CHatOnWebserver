package com.sec.chaton.registration;

import android.content.Context;
import android.text.TextUtils;
import com.sec.chaton.settings.p096a.C3474r;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4894o;
import com.sec.chaton.util.C4904y;
import com.sec.common.util.C5048n;
import java.io.File;
import java.io.IOException;

/* compiled from: SplashThemeDownload.java */
/* renamed from: com.sec.chaton.registration.gf */
/* loaded from: classes.dex */
public class C3299gf {

    /* renamed from: b */
    public static File f12073b;

    /* renamed from: c */
    public static String f12074c;

    /* renamed from: d */
    private static final String f12075d = C3299gf.class.getSimpleName();

    /* renamed from: a */
    Context f12076a;

    public C3299gf(Context context) {
        this.f12076a = context;
        f12073b = C5048n.m19190a(this.f12076a);
        f12074c = f12073b.getAbsolutePath() + "/Theme/";
    }

    /* renamed from: a */
    public void m13041a() {
        String strM18121a = C4809aa.m18104a().m18121a("new_seasonal_theme_id", "");
        String strM18121a2 = C4809aa.m18104a().m18121a("new_seasonal_theme_url", "");
        if (C4904y.f17872b) {
            C4904y.m18639b("THEME_LCS", "ID: " + strM18121a + "url: " + strM18121a2);
        }
        if (!TextUtils.isEmpty(strM18121a) && !TextUtils.isEmpty(strM18121a2)) {
            File file = new File(f12074c + "/" + strM18121a);
            if (!file.isDirectory() && !file.exists()) {
                m13039a(strM18121a2);
            }
        }
    }

    /* renamed from: b */
    public void m13042b() {
        String strM18121a = C4809aa.m18104a().m18121a("theme_ids", "");
        if (!TextUtils.isEmpty(strM18121a)) {
            String strSubstring = strM18121a.substring(0, strM18121a.indexOf(","));
            String strM18121a2 = C4809aa.m18104a().m18121a("setting_change_skin", "");
            File fileM13814a = C3474r.m13814a(this.f12076a, strSubstring, true);
            if (fileM13814a.exists()) {
                if (strSubstring.equals(strM18121a2)) {
                    if (fileM13814a.listFiles().length == 0) {
                        m13043c();
                        return;
                    }
                    return;
                }
                String strM18121a3 = C4809aa.m18104a().m18121a("setting_change_skin", "-1");
                Long lValueOf = Long.valueOf(C4809aa.m18104a().m18118a("theme_applied_time", 0L));
                String strM18121a4 = C4809aa.m18104a().m18121a("start_date", "");
                String strSubstring2 = strM18121a4.substring(0, strM18121a4.indexOf(","));
                if (strM18121a3.contains("skin") || Long.valueOf(strM18121a3).longValue() >= 0 || fileM13814a == null || Long.valueOf(strSubstring2).longValue() < lValueOf.longValue()) {
                    return;
                }
                if (0 == lValueOf.longValue() || Long.valueOf(strSubstring2).longValue() > lValueOf.longValue()) {
                    File[] fileArrListFiles = fileM13814a.listFiles();
                    if (fileArrListFiles.length == 0) {
                        m13043c();
                        return;
                    }
                    char c2 = 0;
                    for (int i = 0; i < fileArrListFiles.length; i++) {
                        if (fileArrListFiles[i].getAbsolutePath().toString().contains("_pa_")) {
                            c2 = 2;
                        } else if (fileArrListFiles[i].getAbsolutePath().toString().contains("_ma_")) {
                            c2 = 1;
                        }
                    }
                    if (c2 == 2) {
                        C3474r.m13821a(strSubstring, "pa", true);
                        return;
                    } else {
                        C3474r.m13821a(strSubstring, "ma", true);
                        return;
                    }
                }
                return;
            }
            m13043c();
        }
    }

    /* renamed from: c */
    public void m13043c() {
        String strM18121a = C4809aa.m18104a().m18121a("theme_ids", "");
        if (!TextUtils.isEmpty(strM18121a)) {
            C3474r.m13824b(strM18121a.substring(0, strM18121a.indexOf(",")));
        }
    }

    /* renamed from: d */
    public void m13044d() {
        String strM18121a = C4809aa.m18104a().m18121a("start_date", "");
        String strM18121a2 = C4809aa.m18104a().m18121a("end_date", "");
        String strM18121a3 = C4809aa.m18104a().m18121a("theme_file_name", "");
        String strM18121a4 = C4809aa.m18104a().m18121a("theme_ids", "");
        if (!TextUtils.isEmpty(strM18121a) && !TextUtils.isEmpty(strM18121a2) && !TextUtils.isEmpty(strM18121a3) && !TextUtils.isEmpty(strM18121a4)) {
            String str = f12074c + strM18121a3;
            String strSubstring = str.substring(0, str.indexOf(","));
            if (C4904y.f17872b) {
                C4904y.m18639b("delete dir: " + strSubstring, f12075d);
            }
            try {
                C3474r.m13841j(this.f12076a, strM18121a4.substring(0, strM18121a4.indexOf(",")));
            } catch (IOException e) {
                e.printStackTrace();
            }
            C4894o.m18606a(strSubstring.substring(0, strSubstring.lastIndexOf("/")));
            C4809aa.m18104a().m18128b("theme_file_name", strM18121a3.substring(strM18121a3.indexOf(",") + 1, strM18121a3.length()));
            C4809aa.m18104a().m18128b("start_date", strM18121a.substring(strM18121a.indexOf(",") + 1, strM18121a.length()));
            C4809aa.m18104a().m18128b("end_date", strM18121a2.substring(strM18121a2.indexOf(",") + 1, strM18121a2.length()));
            String strSubstring2 = strM18121a4.substring(strM18121a4.indexOf(",") + 1, strM18121a4.length());
            C4809aa.m18104a().m18128b("theme_ids", strSubstring2);
            if (TextUtils.isEmpty(strSubstring2)) {
                C4809aa.m18104a().m18128b("seasonal_theme_last_downloaded_id", "");
            }
        }
    }

    /* renamed from: e */
    public int m13045e() {
        String strM18121a = C4809aa.m18104a().m18121a("start_date", "");
        String strM18121a2 = C4809aa.m18104a().m18121a("end_date", "");
        if (C4904y.f17872b) {
            C4904y.m18639b("long Start Date: " + strM18121a + "long End Date " + strM18121a2, f12075d);
        }
        if (!TextUtils.isEmpty(strM18121a) && !TextUtils.isEmpty(strM18121a2)) {
            String strSubstring = strM18121a.substring(0, strM18121a.indexOf(","));
            String strSubstring2 = strM18121a2.substring(0, strM18121a2.indexOf(","));
            if (C4904y.f17872b) {
                C4904y.m18639b("ltst Start Date: " + strSubstring + "ltst End Date " + strSubstring2, f12075d);
            }
            Long lValueOf = Long.valueOf(System.currentTimeMillis());
            if (C4904y.f17872b) {
                C4904y.m18639b("System Time: " + String.valueOf(lValueOf), f12075d);
            }
            if (lValueOf.longValue() >= Long.valueOf(strSubstring).longValue()) {
                if (lValueOf.longValue() <= Long.valueOf(strSubstring2).longValue()) {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("In Range ", f12075d);
                    }
                    return 1;
                }
                if (lValueOf.longValue() > Long.valueOf(strSubstring2).longValue()) {
                    return 3;
                }
                if (C4904y.f17872b) {
                    C4904y.m18639b("Not in Range ", f12075d);
                }
            }
        }
        return 2;
    }

    /* renamed from: f */
    public String m13046f() {
        String strM18121a = C4809aa.m18104a().m18121a("theme_file_name", "");
        if (TextUtils.isEmpty(strM18121a)) {
            return null;
        }
        String str = f12074c + strM18121a;
        if (C4904y.f17872b) {
            C4904y.m18639b("Splash them " + str, f12075d);
        }
        String strSubstring = str.substring(0, str.indexOf(","));
        if (C4904y.f17872b) {
            C4904y.m18639b("Splash them " + strSubstring, f12075d);
        }
        File file = new File(strSubstring);
        if (!file.exists()) {
            return null;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles.length == 1) {
            if (new File(fileArrListFiles[0].getAbsolutePath().toString()).exists()) {
                return fileArrListFiles[0].getAbsolutePath().toString();
            }
            return null;
        }
        String string = null;
        String string2 = null;
        for (int i = 0; i < fileArrListFiles.length; i++) {
            if (fileArrListFiles[i].getAbsolutePath().toString().contains("_port_")) {
                string = fileArrListFiles[i].getAbsolutePath().toString();
            } else if (fileArrListFiles[i].getAbsolutePath().toString().contains("_land_")) {
                string2 = fileArrListFiles[i].getAbsolutePath().toString();
            }
        }
        int i2 = this.f12076a.getResources().getConfiguration().orientation;
        if (i2 == 2) {
            return string2;
        }
        if (i2 == 1) {
            return string;
        }
        return null;
    }

    /* renamed from: a */
    private void m13039a(String str) {
        new AsyncTaskC3300gg(this).execute(str);
    }
}
