package com.sec.chaton.util;

/* compiled from: LatinUtil.java */
/* renamed from: com.sec.chaton.util.bg */
/* loaded from: classes.dex */
public class C3192bg {
    /* renamed from: a */
    public static boolean m11145a(char c) {
        return c != 215 && c != 247 && c >= 192 && c <= 591;
    }

    /* renamed from: b */
    public static char m11146b(char c) {
        if ((c >= 192 && c <= 198) || (c >= 256 && c <= 261)) {
            return 'A';
        }
        if (c == 199 || (c >= 262 && c <= 269)) {
            return 'C';
        }
        if (c == 208 || (c >= 270 && c <= 273)) {
            return 'D';
        }
        if ((c >= 200 && c <= 203) || (c >= 274 && c <= 283)) {
            return 'E';
        }
        if (c >= 284 && c <= 291) {
            return 'G';
        }
        if (c >= 292 && c <= 295) {
            return 'H';
        }
        if ((c >= 204 && c <= 207) || (c >= 296 && c <= 307)) {
            return 'I';
        }
        if (c >= 310 && c <= 312) {
            return 'K';
        }
        if (c >= 313 && c <= 322) {
            return 'L';
        }
        if (c == 209 || (c >= 323 && c <= 331)) {
            return 'N';
        }
        if ((c >= 210 && c <= 216) || (c >= 332 && c <= 339)) {
            return 'O';
        }
        if (c >= 340 && c <= 345) {
            return 'R';
        }
        if (c >= 346 && c <= 353) {
            return 'S';
        }
        if (c >= 354 && c <= 359) {
            return 'T';
        }
        if ((c >= 217 && c <= 220) || (c >= 360 && c <= 371)) {
            return 'U';
        }
        if (c == 221 || (c >= 374 && c <= 376)) {
            return 'Y';
        }
        if (c >= 377 && c <= 382) {
            return 'Z';
        }
        return c;
    }

    /* renamed from: c */
    public static boolean m11147c(char c) {
        if (c == 215 || c == 247) {
            return true;
        }
        if (c < 0 || c > 191) {
            return (c >= 8192 && c <= 10175) || (c >= 12288 && c <= 12351);
        }
        if (c < 'A' || c > 'Z') {
            return c < 'a' || c > 'z';
        }
        return false;
    }
}
