package com.sec.chaton.util;

/* compiled from: LatinUtil.java */
/* renamed from: com.sec.chaton.util.bg */
/* loaded from: classes.dex */
public class C4842bg {
    /* renamed from: a */
    public static boolean m18319a(char c2) {
        return c2 != 215 && c2 != 247 && c2 >= 192 && c2 <= 591;
    }

    /* renamed from: b */
    public static char m18320b(char c2) {
        if ((c2 >= 192 && c2 <= 198) || (c2 >= 256 && c2 <= 261)) {
            return 'A';
        }
        if (c2 == 199 || (c2 >= 262 && c2 <= 269)) {
            return 'C';
        }
        if (c2 == 208 || (c2 >= 270 && c2 <= 273)) {
            return 'D';
        }
        if ((c2 >= 200 && c2 <= 203) || (c2 >= 274 && c2 <= 283)) {
            return 'E';
        }
        if (c2 >= 284 && c2 <= 291) {
            return 'G';
        }
        if (c2 >= 292 && c2 <= 295) {
            return 'H';
        }
        if ((c2 >= 204 && c2 <= 207) || (c2 >= 296 && c2 <= 307)) {
            return 'I';
        }
        if (c2 >= 310 && c2 <= 312) {
            return 'K';
        }
        if (c2 >= 313 && c2 <= 322) {
            return 'L';
        }
        if (c2 == 209 || (c2 >= 323 && c2 <= 331)) {
            return 'N';
        }
        if ((c2 >= 210 && c2 <= 216) || (c2 >= 332 && c2 <= 339)) {
            return 'O';
        }
        if (c2 >= 340 && c2 <= 345) {
            return 'R';
        }
        if (c2 >= 346 && c2 <= 353) {
            return 'S';
        }
        if (c2 >= 354 && c2 <= 359) {
            return 'T';
        }
        if ((c2 >= 217 && c2 <= 220) || (c2 >= 360 && c2 <= 371)) {
            return 'U';
        }
        if (c2 == 221 || (c2 >= 374 && c2 <= 376)) {
            return 'Y';
        }
        if (c2 >= 377 && c2 <= 382) {
            return 'Z';
        }
        return c2;
    }

    /* renamed from: c */
    public static boolean m18321c(char c2) {
        if (c2 == 215 || c2 == 247) {
            return true;
        }
        if (c2 < 0 || c2 > 191) {
            return (c2 >= 8192 && c2 <= 10175) || (c2 >= 12288 && c2 <= 12351);
        }
        if (c2 < 'A' || c2 > 'Z') {
            return c2 < 'a' || c2 > 'z';
        }
        return false;
    }
}
