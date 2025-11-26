package com.sec.chaton.util;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.sec.common.CommonApplication;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ChatONPrefManager.java */
/* renamed from: com.sec.chaton.util.ab */
/* loaded from: classes.dex */
public class C3160ab {

    /* renamed from: a */
    private static final int f11471a = Build.VERSION.SDK_INT;

    /* renamed from: b */
    private Map<String, Object> f11472b = new HashMap();

    /* renamed from: c */
    private SharedPreferences f11473c = CommonApplication.m11493l().getSharedPreferences("ChatON", 0);

    /* renamed from: d */
    private C3158a f11474d;

    public C3160ab() {
        m10968b();
    }

    /* renamed from: b */
    private boolean m10968b() {
        this.f11474d = null;
        byte[] bArrM10958b = C3158a.m10958b("308b4ba610cf3f1eeac517d98a534932cc70c28f0da6036b2e7091ccf80f42dd");
        byte[] bArrM10959c = C3158a.m10959c("308b4ba610cf3f1eeac517d98a534932cc70c28f0da6036b2e7091ccf80f42dd");
        if (bArrM10958b != null && bArrM10959c != null) {
            try {
                this.f11474d = new C3158a(bArrM10958b, bArrM10959c);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* renamed from: c */
    private String m10969c(String str) {
        byte[] bArrM10960b;
        return (this.f11474d == null || (bArrM10960b = this.f11474d.m10960b(str.getBytes())) == null) ? str : C3158a.m10954a(bArrM10960b);
    }

    /* renamed from: d */
    private String m10973d(String str) {
        byte[] bArrM10956a;
        byte[] bArrM10961c;
        return (this.f11474d == null || (bArrM10956a = C3158a.m10956a(str)) == null || (bArrM10961c = this.f11474d.m10961c(bArrM10956a)) == null) ? str : new String(bArrM10961c);
    }

    /* renamed from: a */
    public synchronized String m10979a(String str, String str2) {
        if (str != null) {
            if (m10974d(str, "get")) {
                if (this.f11472b.containsKey(str)) {
                    str2 = (String) this.f11472b.get(str);
                } else {
                    String strM10969c = m10969c(str);
                    if (!TextUtils.isEmpty(strM10969c) && this.f11473c.contains(strM10969c)) {
                        String string = this.f11473c.getString(strM10969c, str2);
                        if (!TextUtils.isEmpty(string)) {
                            str2 = m10973d(string);
                        }
                    } else if (this.f11473c.contains(str)) {
                        str2 = this.f11473c.getString(str, str2);
                        if (!TextUtils.isEmpty(str2)) {
                            String strM10969c2 = m10969c(str2);
                            if (!TextUtils.isEmpty(strM10969c) && !TextUtils.isEmpty(strM10969c2) && this.f11473c.edit().putString(strM10969c, strM10969c2).commit()) {
                                this.f11473c.edit().remove(str).commit();
                            }
                        }
                    }
                    this.f11472b.put(str, str2);
                }
            } else if (this.f11473c.contains(str)) {
                try {
                    str2 = this.f11473c.getString(str, str2);
                } catch (Exception e) {
                    C3250y.m11442a("Error occured while trying to get string from key", getClass().getSimpleName());
                }
            }
        }
        return str2;
    }

    /* renamed from: b */
    public synchronized void m10986b(String str, String str2) {
        if (str != null) {
            if (str2 == null) {
                str2 = "";
            }
            if (m10974d(str, "put")) {
                m10972c(m10969c(str), m10969c(str2));
                this.f11472b.put(str, str2);
            } else {
                m10972c(str, str2);
            }
        }
    }

    /* renamed from: c */
    private void m10972c(String str, String str2) {
        if (f11471a > 8) {
            this.f11473c.edit().putString(str, str2).apply();
        } else {
            this.f11473c.edit().putString(str, str2).commit();
        }
    }

    /* renamed from: a */
    public synchronized Boolean m10977a(String str, Boolean bool) {
        if (str != null) {
            bool = Boolean.valueOf(this.f11473c.getBoolean(str, bool.booleanValue()));
        }
        return bool;
    }

    /* renamed from: b */
    public synchronized void m10983b(String str, Boolean bool) {
        if (str != null && bool != null) {
            m10971c(str, bool);
        }
    }

    /* renamed from: c */
    private void m10971c(String str, Boolean bool) {
        if (f11471a > 8) {
            this.f11473c.edit().putBoolean(str, bool.booleanValue()).apply();
        } else {
            this.f11473c.edit().putBoolean(str, bool.booleanValue()).commit();
        }
    }

    /* renamed from: a */
    public synchronized long m10976a(String str, long j) {
        if (str != null) {
            j = Long.valueOf(this.f11473c.getLong(str, j)).longValue();
        }
        return j;
    }

    /* renamed from: a */
    public synchronized void m10982a(String str, Long l) {
        if (str != null && l != null) {
            m10985b(str, l);
        }
    }

    /* renamed from: b */
    public void m10985b(String str, Long l) {
        if (f11471a > 8) {
            this.f11473c.edit().putLong(str, l.longValue()).apply();
        } else {
            this.f11473c.edit().putLong(str, l.longValue()).commit();
        }
    }

    /* renamed from: a */
    public synchronized Integer m10978a(String str, Integer num) {
        if (str != null) {
            num = Integer.valueOf(this.f11473c.getInt(str, num.intValue()));
        }
        return num;
    }

    /* renamed from: b */
    public synchronized void m10984b(String str, Integer num) {
        if (str != null && num != null) {
            m10988c(str, num);
        }
    }

    /* renamed from: c */
    public void m10988c(String str, Integer num) {
        if (f11471a > 8) {
            this.f11473c.edit().putInt(str, num.intValue()).apply();
        } else {
            this.f11473c.edit().putInt(str, num.intValue()).commit();
        }
    }

    /* renamed from: a */
    public synchronized void m10981a(String str) {
        if (str != null) {
            if ("msisdn".equals(str)) {
                this.f11472b.remove(str);
                if (this.f11473c.edit().remove(m10969c(str)).commit()) {
                }
            } else {
                m10975e(str);
            }
        }
    }

    /* renamed from: e */
    private void m10975e(String str) {
        if (f11471a > 8) {
            this.f11473c.edit().remove(str).apply();
        } else {
            this.f11473c.edit().remove(str).commit();
        }
    }

    /* renamed from: a */
    public synchronized void m10980a() {
        this.f11472b.clear();
        m10970c();
    }

    /* renamed from: c */
    private void m10970c() {
        if (f11471a > 8) {
            this.f11473c.edit().clear().apply();
        } else {
            this.f11473c.edit().clear().commit();
        }
    }

    /* renamed from: b */
    public synchronized boolean m10987b(String str) {
        boolean z = false;
        synchronized (this) {
            if (str != null) {
                if ("msisdn".equals(str)) {
                    String strM10969c = m10969c(str);
                    if (this.f11472b.containsKey(str) || this.f11473c.contains(str) || (!TextUtils.isEmpty(strM10969c) && this.f11473c.contains(strM10969c))) {
                        z = true;
                    }
                } else if (this.f11472b.containsKey(str) || this.f11473c.contains(str)) {
                    z = true;
                }
            }
        }
        return z;
    }

    /* renamed from: d */
    private boolean m10974d(String str, String str2) {
        if (!"msisdn".equals(str) && !"imei".equals(str) && !"samsung_account_user_id".equals(str) && !"birthday".equals(str) && !"samsung_account_birthday".equals(str) && !"birthday_server".equals(str) && !"samsung_account_email".equals(str)) {
            return false;
        }
        if (C3250y.f11734b) {
            C3250y.m11450b("This is Encrypt Key : " + str + " , type : " + str2, "ChatONPrefManager");
        }
        return true;
    }
}
