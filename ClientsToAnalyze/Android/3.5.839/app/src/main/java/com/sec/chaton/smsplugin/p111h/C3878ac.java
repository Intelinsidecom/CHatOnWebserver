package com.sec.chaton.smsplugin.p111h;

import android.R;
import android.content.Context;
import android.text.TextUtils;
import com.sec.chaton.smsplugin.C3847e;

/* compiled from: TelephonyUtils.java */
/* renamed from: com.sec.chaton.smsplugin.h.ac */
/* loaded from: classes.dex */
public class C3878ac {
    /* renamed from: a */
    public static String m14956a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (C3847e.m14669aa()) {
            return m14960c(str, i);
        }
        return m14959b(str, i);
    }

    /* renamed from: b */
    public static String m14959b(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int iM14955a = m14955a(str);
        if (!str.equals("") && iM14955a > i) {
            String strSubstring = str.substring(0, 1);
            StringBuilder sb = new StringBuilder("");
            String strSubstring2 = strSubstring;
            String strSubstring3 = str;
            int i2 = 0;
            while (i2 < i) {
                if (strSubstring2.charAt(0) <= 127) {
                    i2++;
                } else if (strSubstring2.charAt(0) <= 2047) {
                    i2 += 2;
                } else if (strSubstring2.charAt(0) <= 65535) {
                    i2 += 3;
                } else {
                    i2 += 4;
                }
                if (i2 > i || strSubstring3 == null || strSubstring3.length() == 0) {
                    break;
                }
                sb.append(strSubstring2);
                strSubstring3 = strSubstring3.substring(1);
                if (strSubstring3.length() == 1) {
                    strSubstring2 = strSubstring3;
                } else if (strSubstring3.length() > 1) {
                    strSubstring2 = strSubstring3.substring(0, 1);
                }
            }
            return sb.toString();
        }
        return str;
    }

    /* renamed from: c */
    public static String m14960c(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (m14958b(str) > i) {
            StringBuilder sb = new StringBuilder("");
            String strSubstring = str.substring(0, 1);
            int i2 = 0;
            while (i2 < i) {
                i2 += strSubstring.charAt(0) > 127 ? 2 : 1;
                if (i2 > i || str == null || str.length() == 0) {
                    break;
                }
                sb.append(strSubstring);
                String strSubstring2 = str.substring(1);
                if (strSubstring2.length() == 1) {
                    strSubstring = strSubstring2;
                    str = strSubstring2;
                } else if (strSubstring2.length() > 1) {
                    strSubstring = strSubstring2.substring(0, 1);
                    str = strSubstring2;
                } else {
                    str = strSubstring2;
                }
            }
            return sb.toString();
        }
        return str;
    }

    /* renamed from: a */
    public static int m14955a(String str) {
        int i = 0;
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (str.charAt(i2) <= 127) {
                i++;
            } else if (str.charAt(i2) <= 2047) {
                i += 2;
            } else if (str.charAt(i2) <= 65535) {
                i += 3;
            } else {
                i += 4;
            }
        }
        return i;
    }

    /* renamed from: b */
    public static int m14958b(String str) {
        if (str == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            i += str.charAt(i2) > 127 ? 2 : 1;
        }
        return i;
    }

    /* renamed from: a */
    public static boolean m14957a(Context context) {
        try {
            return context.getResources().getBoolean(R.bool.config_assistTouchGestureEnabledDefault);
        } catch (Exception e) {
            return false;
        }
    }
}
