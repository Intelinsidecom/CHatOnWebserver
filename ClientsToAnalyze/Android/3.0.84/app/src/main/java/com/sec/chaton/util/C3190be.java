package com.sec.chaton.util;

/* compiled from: IndicUtil.java */
/* renamed from: com.sec.chaton.util.be */
/* loaded from: classes.dex */
public class C3190be {
    /* renamed from: a */
    public static int m11138a(char c) {
        if (c >= 2304 && c <= 2431) {
            return 1;
        }
        if (c >= 2432 && c <= 2559) {
            return 2;
        }
        if (c >= 2944 && c <= 3071) {
            return 3;
        }
        if (c >= 3072 && c <= 3199) {
            return 4;
        }
        if (c >= 3200 && c <= 3327) {
            return 5;
        }
        if (c >= 2560 && c <= 2687) {
            return 6;
        }
        if (c >= 2688 && c <= 2815) {
            return 7;
        }
        if (c >= 3328 && c <= 3455) {
            return 8;
        }
        if (c >= 3456 && c <= 3583) {
            return 9;
        }
        if (c >= 2816 && c <= 2943) {
            return 10;
        }
        return -1;
    }

    /* renamed from: b */
    public static boolean m11141b(char c) {
        switch (m11138a(c)) {
            case 1:
                if (c >= 2305 && c <= 2307) {
                    return true;
                }
                if (c < 2366 || c > 2381) {
                    return (c >= 2385 && c <= 2388) || c == 2364 || c == 2402 || c == 2403;
                }
                return true;
            case 2:
                if (c >= 2433 && c <= 2435) {
                    return true;
                }
                if (c < 2492 || c > 2509) {
                    return (c >= 2530 && c <= 2531) || c == 2519;
                }
                return true;
            case 3:
                if (c < 2946 || c > 2947) {
                    return (c >= 3006 && c <= 3021) || c == 3031;
                }
                return true;
            case 4:
                if (c >= 3073 && c <= 3075) {
                    return true;
                }
                if (c < 3134 || c > 3149) {
                    return (c >= 3157 && c <= 3158) || c == 3170 || c == 3171;
                }
                return true;
            case 5:
                if (c >= 3202 && c <= 3203) {
                    return true;
                }
                if (c < 3262 || c > 3277) {
                    return (c >= 3285 && c <= 3286) || c == 3260 || c == 3298 || c == 3299;
                }
                return true;
            case 6:
                if (c >= 2561 && c <= 2563) {
                    return true;
                }
                if (c < 2622 || c > 2637) {
                    return (c >= 2672 && c <= 2673) || c == 2620 || c == 2641 || c == 2677;
                }
                return true;
            case 7:
                if (c < 2689 || c > 2691) {
                    return (c >= 2750 && c <= 2765) || c == 2748 || c == 2786 || c == 2787;
                }
                return true;
            case 8:
                if (c >= 3330 && c <= 3331) {
                    return true;
                }
                if (c < 3390 || c > 3405) {
                    return (c >= 3426 && c <= 3427) || c == 3415;
                }
                return true;
            case 9:
                if (c >= 3458 && c <= 3459) {
                    return true;
                }
                if (c < 3535 || c > 3551) {
                    return (c >= 3570 && c <= 3571) || c == 3530;
                }
                return true;
            case 10:
                if (c >= 2817 && c <= 2307) {
                    return true;
                }
                if (c < 2876 || c > 2893) {
                    return (c >= 2902 && c <= 2903) || c == 2913 || c == 2914 || c == 2915;
                }
                return true;
            default:
                return false;
        }
    }

    /* renamed from: a */
    public static int m11140a(String str, int i, int i2) {
        try {
            if (m11138a(str.charAt(i)) <= -1) {
                return 0;
            }
            int i3 = 0;
            while (i < i2 - 1 && m11138a(str.charAt(i + 1)) > -1) {
                if (!m11142c(str.charAt(i)) && !m11141b(str.charAt(i + 1))) {
                    return i3;
                }
                i3++;
                i++;
                if (i < i2 - 1 && m11138a(str.charAt(i + 1)) != -1 && m11142c(str.charAt(i)) && m11143d(str.charAt(i + 1))) {
                    i3++;
                    i++;
                }
            }
            return i3;
        } catch (Exception e) {
            e.printStackTrace();
            return (i >= i2 + (-1) || !m11141b(str.charAt(i + 1))) ? 0 : 1;
        }
    }

    /* renamed from: a */
    public static int m11139a(String str, int i) {
        int i2 = 0;
        while (i - 2 > -1) {
            try {
                if (!m11142c(str.charAt(i - 1)) || !m11143d(str.charAt(i - 2))) {
                    break;
                }
                i2 += 2;
                i -= 2;
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
        return i2;
    }

    /* renamed from: c */
    public static boolean m11142c(char c) {
        return c == 2381 || c == 3277 || c == 3149 || c == 2765 || c == 3021 || c == 3405 || c == 2637 || c == 2509 || c == 2893 || c == 3530;
    }

    /* renamed from: d */
    public static boolean m11143d(char c) {
        switch (m11138a(c)) {
            case 1:
                if (c < 2305 || c > 2324) {
                    if (c < 2366 || c > 2381) {
                        if ((c < 2385 || c > 2388) && c != 2364 && c != 2402 && c != 2403) {
                            break;
                        }
                    }
                }
                break;
            case 2:
                if (c < 2433 || c > 2452) {
                    if (c < 2492 || c > 2509) {
                        if ((c < 2530 || c > 2531) && c != 2519) {
                            break;
                        }
                    }
                }
                break;
            case 3:
                if (c < 2946 || c > 2964) {
                    if ((c < 3006 || c > 3021) && c != 3031) {
                        break;
                    }
                }
                break;
            case 4:
                if (c < 3073 || c > 3092) {
                    if (c < 3134 || c > 3149) {
                        if ((c < 3157 || c > 3158) && c != 3170 && c != 3171) {
                            break;
                        }
                    }
                }
                break;
            case 5:
                if (c < 3202 || c > 3220) {
                    if (c < 3262 || c > 3277) {
                        if ((c < 3285 || c > 3286) && c != 3260 && c != 3298 && c != 3299) {
                            break;
                        }
                    }
                }
                break;
            case 6:
                if (c < 2561 || c > 2580) {
                    if (c < 2622 || c > 2637) {
                        if ((c < 2672 || c > 2673) && c != 2620 && c != 2641 && c != 2677) {
                            break;
                        }
                    }
                }
                break;
            case 7:
                if (c < 2689 || c > 2708) {
                    if ((c < 2750 || c > 2765) && c != 2748 && c != 2786 && c != 2787) {
                        break;
                    }
                }
                break;
            case 8:
                if (c < 3330 || c > 3348) {
                    if (c < 3390 || c > 3405) {
                        if ((c < 3426 || c > 3427) && c != 3415) {
                            break;
                        }
                    }
                }
                break;
            case 9:
                if (c < 3458 || c > 3476) {
                    if (c < 3535 || c > 3551) {
                        if ((c < 3570 || c > 3571) && c != 3530) {
                            break;
                        }
                    }
                }
                break;
            case 10:
                if (c < 2817 || c > 2307) {
                    if (c < 2876 || c > 2893) {
                        if ((c < 2902 || c > 2903) && c != 2913 && c != 2914 && c != 2915) {
                            break;
                        }
                    }
                }
                break;
        }
        return false;
    }
}
