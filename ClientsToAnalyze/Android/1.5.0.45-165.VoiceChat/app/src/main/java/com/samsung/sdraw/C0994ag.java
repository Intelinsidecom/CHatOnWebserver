package com.samsung.sdraw;

import java.io.Serializable;
import java.util.Comparator;

/* renamed from: com.samsung.sdraw.ag */
/* loaded from: classes.dex */
class C0994ag implements Serializable, Comparator<Object> {
    C0994ag() {
    }

    /* renamed from: a */
    int m1277a(String str, String str2) {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            char cM1276a = m1276a(str, i2);
            char cM1276a2 = m1276a(str2, i);
            if (Character.isDigit(cM1276a) || Character.isDigit(cM1276a2)) {
                if (!Character.isDigit(cM1276a)) {
                    return -1;
                }
                if (!Character.isDigit(cM1276a2)) {
                    return 1;
                }
                if (cM1276a < cM1276a2) {
                    if (i3 == 0) {
                        i3 = -1;
                    }
                } else if (cM1276a > cM1276a2) {
                    if (i3 == 0) {
                        i3 = 1;
                    }
                } else if (cM1276a == 0 && cM1276a2 == 0) {
                    return i3;
                }
                i2++;
                i++;
            } else {
                return i3;
            }
        }
    }

    @Override // java.util.Comparator
    public int compare(Object o1, Object o2) {
        int iM1277a;
        String string = o1.toString();
        String string2 = o2.toString();
        int i = 0;
        int i2 = 0;
        while (true) {
            char cM1276a = m1276a(string, i2);
            char cM1276a2 = m1276a(string2, i);
            int i3 = i2;
            char cM1276a3 = cM1276a;
            int i4 = 0;
            while (true) {
                if (!Character.isSpaceChar(cM1276a3) && cM1276a3 != '0') {
                    break;
                }
                i4 = cM1276a3 == '0' ? i4 + 1 : 0;
                i3++;
                cM1276a3 = m1276a(string, i3);
            }
            int i5 = i;
            char cM1276a4 = cM1276a2;
            int i6 = 0;
            while (true) {
                if (!Character.isSpaceChar(cM1276a4) && cM1276a4 != '0') {
                    break;
                }
                i6 = cM1276a4 == '0' ? i6 + 1 : 0;
                i5++;
                cM1276a4 = m1276a(string2, i5);
            }
            if (Character.isDigit(cM1276a3) && Character.isDigit(cM1276a4) && (iM1277a = m1277a(string.substring(i3), string2.substring(i5))) != 0) {
                return iM1277a;
            }
            if (cM1276a3 == 0 && cM1276a4 == 0) {
                return i4 - i6;
            }
            if (cM1276a3 < cM1276a4) {
                return -1;
            }
            if (cM1276a3 > cM1276a4) {
                return 1;
            }
            i2 = i3 + 1;
            i = i5 + 1;
        }
    }

    /* renamed from: a */
    static char m1276a(String str, int i) {
        if (i >= str.length()) {
            return (char) 0;
        }
        return str.charAt(i);
    }
}
