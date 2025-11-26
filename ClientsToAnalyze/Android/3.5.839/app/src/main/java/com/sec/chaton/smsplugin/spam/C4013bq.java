package com.sec.chaton.smsplugin.spam;

import android.telephony.PhoneNumberUtils;

/* compiled from: SpamFilter.java */
/* renamed from: com.sec.chaton.smsplugin.spam.bq */
/* loaded from: classes.dex */
class C4013bq extends PhoneNumberUtils {

    /* renamed from: a */
    private static final boolean[] f14475a = {true, true, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, true, true, false, true, true, true, true, true, false, true, false, false, true, true, false, false, true, true, true, true, true, true, true, false, true, true, true, true, true, true, true, true, false, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, true, true, true, false, true, false, false, true, true, true, true, true, true, true, false, false, true, false};

    /* renamed from: b */
    private static final int f14476b = f14475a.length;

    /* renamed from: a */
    private static int m15424a(String str, int i) {
        int length = str.length();
        for (int i2 = i; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (m15423a(cCharAt) < 0) {
                if (isDialable(cCharAt)) {
                    return -1;
                }
            } else {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: a */
    private static int m15423a(char c2) {
        if ('0' > c2 || c2 > '9') {
            return -1;
        }
        return c2 - '0';
    }

    /* renamed from: a */
    public static boolean m15428a(String str, String str2) {
        return m15429a(str, str2, true);
    }

    /* renamed from: a */
    public static boolean m15429a(String str, String str2, boolean z) {
        int iM15424a;
        int i;
        boolean z2;
        if (str == null || str2 == null) {
            return str == str2;
        }
        if (str.length() == 0 && str2.length() == 0) {
            return false;
        }
        int i2 = 0;
        int i3 = 0;
        C4014br c4014brM15425a = m15425a(str, z);
        C4014br c4014brM15425a2 = m15425a(str2, z);
        boolean z3 = false;
        boolean z4 = true;
        boolean z5 = false;
        boolean z6 = false;
        if (c4014brM15425a != null && c4014brM15425a2 != null) {
            if (c4014brM15425a.f14477a != c4014brM15425a2.f14477a) {
                return false;
            }
            z4 = false;
            z3 = true;
            i2 = c4014brM15425a.f14478b;
            i3 = c4014brM15425a2.f14478b;
        } else if (c4014brM15425a == null && c4014brM15425a2 == null) {
            z4 = false;
        } else {
            if (c4014brM15425a != null) {
                iM15424a = c4014brM15425a.f14478b;
            } else {
                iM15424a = m15424a(str2, 0);
                if (iM15424a < 0) {
                    iM15424a = 0;
                } else {
                    z5 = true;
                }
            }
            if (c4014brM15425a2 != null) {
                i3 = c4014brM15425a2.f14478b;
                i2 = iM15424a;
            } else {
                int iM15424a2 = m15424a(str2, 0);
                if (iM15424a2 >= 0) {
                    z6 = true;
                    i3 = iM15424a2;
                    i2 = iM15424a;
                } else {
                    i2 = iM15424a;
                }
            }
        }
        int length = str.length() - 1;
        int length2 = str2.length() - 1;
        while (length >= i2 && length2 >= i3) {
            boolean z7 = false;
            char cCharAt = str.charAt(length);
            char cCharAt2 = str2.charAt(length2);
            if (m15430b(cCharAt)) {
                length--;
                z7 = true;
            }
            if (m15430b(cCharAt2)) {
                i = length2 - 1;
                z2 = true;
            } else {
                boolean z8 = z7;
                i = length2;
                z2 = z8;
            }
            if (!z2) {
                if (cCharAt != cCharAt2) {
                    return false;
                }
                length--;
                i--;
            }
            length2 = i;
        }
        if (z4) {
            if ((z5 && i2 <= length) || !m15427a(str, i2, length)) {
                if (z) {
                    return compare(str, str2, false);
                }
                return false;
            }
            if ((z6 && i3 <= length2) || !m15427a(str2, i2, length2)) {
                if (z) {
                    return compare(str, str2, false);
                }
                return false;
            }
        } else {
            boolean z9 = !z3;
            while (length >= i2) {
                char cCharAt3 = str.charAt(length);
                if (isDialable(cCharAt3)) {
                    if (z9 && m15423a(cCharAt3) == 1) {
                        z9 = false;
                    } else {
                        return false;
                    }
                }
                length--;
            }
            for (int i4 = length2; i4 >= i3; i4--) {
                char cCharAt4 = str2.charAt(i4);
                if (isDialable(cCharAt4)) {
                    if (z9 && m15423a(cCharAt4) == 1) {
                        z9 = false;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /* renamed from: a */
    private static C4014br m15425a(String str, boolean z) {
        int i = 0;
        int length = str.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = str.charAt(i3);
            switch (i2) {
                case 0:
                    if (cCharAt == '+') {
                        i2 = 1;
                        break;
                    } else if (cCharAt == '0') {
                        i2 = 2;
                        break;
                    } else if (cCharAt == '1') {
                        if (!z) {
                            return null;
                        }
                        i2 = 8;
                        break;
                    } else {
                        if (isDialable(cCharAt)) {
                            return null;
                        }
                        break;
                    }
                case 1:
                case 3:
                case 5:
                case 6:
                case 7:
                    int iM15423a = m15423a(cCharAt);
                    if (iM15423a > 0) {
                        i = (i * 10) + iM15423a;
                        if (i >= 100 || m15426a(i)) {
                            return new C4014br(i, i3 + 1);
                        }
                        if (i2 == 1 || i2 == 3 || i2 == 5) {
                            i2 = 6;
                            break;
                        } else {
                            i2++;
                            break;
                        }
                    } else {
                        if (isDialable(cCharAt)) {
                            return null;
                        }
                        break;
                    }
                    break;
                case 2:
                    if (cCharAt == '0') {
                        i2 = 3;
                        break;
                    } else if (cCharAt == '1') {
                        i2 = 4;
                        break;
                    } else {
                        if (isDialable(cCharAt)) {
                            return null;
                        }
                        break;
                    }
                case 4:
                    if (cCharAt == '1') {
                        i2 = 5;
                        break;
                    } else {
                        if (isDialable(cCharAt)) {
                            return null;
                        }
                        break;
                    }
                case 8:
                    if (cCharAt == '6') {
                        i2 = 9;
                        break;
                    } else {
                        if (isDialable(cCharAt)) {
                            return null;
                        }
                        break;
                    }
                case 9:
                    if (cCharAt == '6') {
                        return new C4014br(66, i3 + 1);
                    }
                    return null;
                default:
                    return null;
            }
        }
        return null;
    }

    /* renamed from: b */
    private static boolean m15430b(char c2) {
        return !isDialable(c2) && ('a' > c2 || c2 > 'z') && ('A' > c2 || c2 > 'Z');
    }

    /* renamed from: a */
    private static boolean m15427a(String str, int i, int i2) {
        boolean z = false;
        while (i2 >= i) {
            if (m15423a(str.charAt(i2)) >= 0) {
                if (z) {
                    return false;
                }
                z = true;
            } else if (isDialable(str.charAt(i2))) {
                return false;
            }
            i2--;
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m15426a(int i) {
        return i > 0 && i < f14476b && f14475a[i];
    }
}
