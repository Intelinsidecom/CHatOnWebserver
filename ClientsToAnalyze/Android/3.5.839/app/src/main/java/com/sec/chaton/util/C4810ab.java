package com.sec.chaton.util;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.sec.common.CommonApplication;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ChatONPrefManager.java */
/* renamed from: com.sec.chaton.util.ab */
/* loaded from: classes.dex */
public class C4810ab {

    /* renamed from: a */
    private static final int f17572a = Build.VERSION.SDK_INT;

    /* renamed from: b */
    private Map<String, Object> f17573b = new HashMap();

    /* renamed from: c */
    private SharedPreferences f17574c = CommonApplication.m18732r().getSharedPreferences("ChatON", 0);

    /* renamed from: d */
    private C4808a f17575d;

    public C4810ab() {
        m18110b();
    }

    /* renamed from: b */
    private boolean m18110b() {
        this.f17575d = null;
        byte[] bArrM18100b = C4808a.m18100b("308b4ba610cf3f1eeac517d98a534932cc70c28f0da6036b2e7091ccf80f42dd");
        byte[] bArrM18101c = C4808a.m18101c("308b4ba610cf3f1eeac517d98a534932cc70c28f0da6036b2e7091ccf80f42dd");
        if (bArrM18100b != null && bArrM18101c != null) {
            try {
                this.f17575d = new C4808a(bArrM18100b, bArrM18101c);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* renamed from: c */
    private String m18111c(String str) {
        byte[] bArrM18102b;
        return (this.f17575d == null || (bArrM18102b = this.f17575d.m18102b(str.getBytes())) == null) ? str : C4808a.m18098a(bArrM18102b);
    }

    /* renamed from: d */
    private String m18115d(String str) {
        byte[] bArrM18099a;
        byte[] bArrM18103c;
        return (this.f17575d == null || (bArrM18099a = C4808a.m18099a(str)) == null || (bArrM18103c = this.f17575d.m18103c(bArrM18099a)) == null) ? str : new String(bArrM18103c);
    }

    /* renamed from: a */
    public synchronized String m18121a(String str, String str2) {
        if (str != null) {
            if (m18116d(str, "get")) {
                if (this.f17573b.containsKey(str)) {
                    str2 = (String) this.f17573b.get(str);
                } else {
                    String strM18111c = m18111c(str);
                    if (!TextUtils.isEmpty(strM18111c) && this.f17574c.contains(strM18111c)) {
                        String string = this.f17574c.getString(strM18111c, str2);
                        if (!TextUtils.isEmpty(string)) {
                            str2 = m18115d(string);
                        }
                        this.f17573b.put(str, str2);
                    } else if (this.f17574c.contains(str)) {
                        str2 = this.f17574c.getString(str, str2);
                        if (!TextUtils.isEmpty(str2)) {
                            String strM18111c2 = m18111c(str2);
                            if (!TextUtils.isEmpty(strM18111c) && !TextUtils.isEmpty(strM18111c2) && this.f17574c.edit().putString(strM18111c, strM18111c2).commit()) {
                                this.f17574c.edit().remove(str).commit();
                            }
                        }
                        this.f17573b.put(str, str2);
                    }
                }
            } else if (this.f17574c.contains(str)) {
                try {
                    str2 = this.f17574c.getString(str, str2);
                } catch (Exception e) {
                    C4904y.m18634a("Error occured while trying to get string from key", getClass().getSimpleName());
                }
            }
        }
        return str2;
    }

    /* renamed from: b */
    public synchronized void m18128b(String str, String str2) {
        if (str != null) {
            if (str2 == null) {
                str2 = "";
            }
            if (m18116d(str, "put")) {
                m18114c(m18111c(str), m18111c(str2));
                this.f17573b.put(str, str2);
            } else {
                m18114c(str, str2);
            }
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: c */
    private void m18114c(String str, String str2) {
        if (f17572a > 8) {
            this.f17574c.edit().putString(str, str2).apply();
        } else {
            this.f17574c.edit().putString(str, str2).commit();
        }
    }

    /* renamed from: a */
    public synchronized Boolean m18119a(String str, Boolean bool) {
        if (str != null) {
            bool = Boolean.valueOf(this.f17574c.getBoolean(str, bool.booleanValue()));
        }
        return bool;
    }

    /* renamed from: b */
    public synchronized void m18125b(String str, Boolean bool) {
        if (str != null && bool != null) {
            m18113c(str, bool);
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: c */
    private void m18113c(String str, Boolean bool) {
        if (f17572a > 8) {
            this.f17574c.edit().putBoolean(str, bool.booleanValue()).apply();
        } else {
            this.f17574c.edit().putBoolean(str, bool.booleanValue()).commit();
        }
    }

    /* renamed from: a */
    public synchronized long m18118a(String str, long j) {
        if (str != null) {
            j = Long.valueOf(this.f17574c.getLong(str, j)).longValue();
        }
        return j;
    }

    /* renamed from: a */
    public synchronized void m18124a(String str, Long l) {
        if (str != null && l != null) {
            m18127b(str, l);
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: b */
    public void m18127b(String str, Long l) {
        if (f17572a > 8) {
            this.f17574c.edit().putLong(str, l.longValue()).apply();
        } else {
            this.f17574c.edit().putLong(str, l.longValue()).commit();
        }
    }

    /* renamed from: a */
    public synchronized Integer m18120a(String str, Integer num) {
        if (str != null) {
            num = Integer.valueOf(this.f17574c.getInt(str, num.intValue()));
        }
        return num;
    }

    /* renamed from: b */
    public synchronized void m18126b(String str, Integer num) {
        if (str != null && num != null) {
            m18130c(str, num);
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: c */
    public void m18130c(String str, Integer num) {
        if (f17572a > 8) {
            this.f17574c.edit().putInt(str, num.intValue()).apply();
        } else {
            this.f17574c.edit().putInt(str, num.intValue()).commit();
        }
    }

    /* renamed from: a */
    public synchronized void m18123a(String str) {
        if (str != null) {
            if ("msisdn".equals(str)) {
                this.f17573b.remove(str);
                if (this.f17574c.edit().remove(m18111c(str)).commit()) {
                }
            } else {
                m18117e(str);
            }
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: e */
    private void m18117e(String str) {
        if (f17572a > 8) {
            this.f17574c.edit().remove(str).apply();
        } else {
            this.f17574c.edit().remove(str).commit();
        }
    }

    /* renamed from: a */
    public synchronized void m18122a() {
        this.f17573b.clear();
        m18112c();
    }

    @SuppressLint({"NewApi"})
    /* renamed from: c */
    private void m18112c() {
        if (f17572a > 8) {
            this.f17574c.edit().clear().apply();
        } else {
            this.f17574c.edit().clear().commit();
        }
    }

    /* renamed from: b */
    public synchronized boolean m18129b(String str) {
        boolean z = false;
        synchronized (this) {
            if (str != null) {
                if (m18116d(str, "contains")) {
                    String strM18111c = m18111c(str);
                    if (this.f17573b.containsKey(str) || this.f17574c.contains(str) || (!TextUtils.isEmpty(strM18111c) && this.f17574c.contains(strM18111c))) {
                        z = true;
                    }
                } else if (this.f17573b.containsKey(str) || this.f17574c.contains(str)) {
                    z = true;
                }
            }
        }
        return z;
    }

    /* renamed from: d */
    private boolean m18116d(String str, String str2) {
        if (!"msisdn".equals(str) && !"imei".equals(str) && !"samsung_account_user_id".equals(str) && !"birthday".equals(str) && !"samsung_account_birthday".equals(str) && !"birthday_server".equals(str) && !"samsung_account_email".equals(str)) {
            return false;
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("This is Encrypt Key : " + str + " , type : " + str2, "ChatONPrefManager");
        }
        return true;
    }
}
