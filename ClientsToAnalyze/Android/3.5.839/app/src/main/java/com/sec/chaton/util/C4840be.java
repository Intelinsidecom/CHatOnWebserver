package com.sec.chaton.util;

/* compiled from: IndicUtil.java */
/* renamed from: com.sec.chaton.util.be */
/* loaded from: classes.dex */
public class C4840be {
    /* renamed from: a */
    public static int m18312a(char c2) {
        if (c2 >= 2304 && c2 <= 2431) {
            return 1;
        }
        if (c2 >= 2432 && c2 <= 2559) {
            return 2;
        }
        if (c2 >= 2944 && c2 <= 3071) {
            return 3;
        }
        if (c2 >= 3072 && c2 <= 3199) {
            return 4;
        }
        if (c2 >= 3200 && c2 <= 3327) {
            return 5;
        }
        if (c2 >= 2560 && c2 <= 2687) {
            return 6;
        }
        if (c2 >= 2688 && c2 <= 2815) {
            return 7;
        }
        if (c2 >= 3328 && c2 <= 3455) {
            return 8;
        }
        if (c2 >= 3456 && c2 <= 3583) {
            return 9;
        }
        if (c2 >= 2816 && c2 <= 2943) {
            return 10;
        }
        return -1;
    }

    /* renamed from: b */
    public static boolean m18315b(char c2) {
        switch (m18312a(c2)) {
            case 1:
                if (c2 >= 2305 && c2 <= 2307) {
                    return true;
                }
                if (c2 < 2366 || c2 > 2381) {
                    return (c2 >= 2385 && c2 <= 2388) || c2 == 2364 || c2 == 2402 || c2 == 2403;
                }
                return true;
            case 2:
                if (c2 >= 2433 && c2 <= 2435) {
                    return true;
                }
                if (c2 < 2492 || c2 > 2509) {
                    return (c2 >= 2530 && c2 <= 2531) || c2 == 2519;
                }
                return true;
            case 3:
                if (c2 < 2946 || c2 > 2947) {
                    return (c2 >= 3006 && c2 <= 3021) || c2 == 3031;
                }
                return true;
            case 4:
                if (c2 >= 3073 && c2 <= 3075) {
                    return true;
                }
                if (c2 < 3134 || c2 > 3149) {
                    return (c2 >= 3157 && c2 <= 3158) || c2 == 3170 || c2 == 3171;
                }
                return true;
            case 5:
                if (c2 >= 3202 && c2 <= 3203) {
                    return true;
                }
                if (c2 < 3262 || c2 > 3277) {
                    return (c2 >= 3285 && c2 <= 3286) || c2 == 3260 || c2 == 3298 || c2 == 3299;
                }
                return true;
            case 6:
                if (c2 >= 2561 && c2 <= 2563) {
                    return true;
                }
                if (c2 < 2622 || c2 > 2637) {
                    return (c2 >= 2672 && c2 <= 2673) || c2 == 2620 || c2 == 2641 || c2 == 2677;
                }
                return true;
            case 7:
                if (c2 < 2689 || c2 > 2691) {
                    return (c2 >= 2750 && c2 <= 2765) || c2 == 2748 || c2 == 2786 || c2 == 2787;
                }
                return true;
            case 8:
                if (c2 >= 3330 && c2 <= 3331) {
                    return true;
                }
                if (c2 < 3390 || c2 > 3405) {
                    return (c2 >= 3426 && c2 <= 3427) || c2 == 3415;
                }
                return true;
            case 9:
                if (c2 >= 3458 && c2 <= 3459) {
                    return true;
                }
                if (c2 < 3535 || c2 > 3551) {
                    return (c2 >= 3570 && c2 <= 3571) || c2 == 3530;
                }
                return true;
            case 10:
                if (c2 >= 2817 && c2 <= 2307) {
                    return true;
                }
                if (c2 < 2876 || c2 > 2893) {
                    return (c2 >= 2902 && c2 <= 2903) || c2 == 2913 || c2 == 2914 || c2 == 2915;
                }
                return true;
            default:
                return false;
        }
    }

    /* renamed from: a */
    public static int m18314a(String str, int i, int i2) {
        try {
            if (m18312a(str.charAt(i)) <= -1) {
                return 0;
            }
            int i3 = 0;
            while (i < i2 - 1 && m18312a(str.charAt(i + 1)) > -1) {
                if (!m18316c(str.charAt(i)) && !m18315b(str.charAt(i + 1))) {
                    return i3;
                }
                i3++;
                i++;
                if (i < i2 - 1 && m18312a(str.charAt(i + 1)) != -1 && m18316c(str.charAt(i)) && m18317d(str.charAt(i + 1))) {
                    i3++;
                    i++;
                }
            }
            return i3;
        } catch (Exception e) {
            e.printStackTrace();
            return (i >= i2 + (-1) || !m18315b(str.charAt(i + 1))) ? 0 : 1;
        }
    }

    /* renamed from: a */
    public static int m18313a(String str, int i) {
        int i2 = 0;
        while (i - 2 > -1) {
            try {
                if (!m18316c(str.charAt(i - 1)) || !m18317d(str.charAt(i - 2))) {
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
    public static boolean m18316c(char c2) {
        return c2 == 2381 || c2 == 3277 || c2 == 3149 || c2 == 2765 || c2 == 3021 || c2 == 3405 || c2 == 2637 || c2 == 2509 || c2 == 2893 || c2 == 3530;
    }

    /* renamed from: d */
    public static boolean m18317d(char c2) {
        switch (m18312a(c2)) {
            case 1:
                if (c2 < 2305 || c2 > 2324) {
                    if (c2 < 2366 || c2 > 2381) {
                        if ((c2 < 2385 || c2 > 2388) && c2 != 2364 && c2 != 2402 && c2 != 2403) {
                            break;
                        }
                    }
                }
                break;
            case 2:
                if (c2 < 2433 || c2 > 2452) {
                    if (c2 < 2492 || c2 > 2509) {
                        if ((c2 < 2530 || c2 > 2531) && c2 != 2519) {
                            break;
                        }
                    }
                }
                break;
            case 3:
                if (c2 < 2946 || c2 > 2964) {
                    if ((c2 < 3006 || c2 > 3021) && c2 != 3031) {
                        break;
                    }
                }
                break;
            case 4:
                if (c2 < 3073 || c2 > 3092) {
                    if (c2 < 3134 || c2 > 3149) {
                        if ((c2 < 3157 || c2 > 3158) && c2 != 3170 && c2 != 3171) {
                            break;
                        }
                    }
                }
                break;
            case 5:
                if (c2 < 3202 || c2 > 3220) {
                    if (c2 < 3262 || c2 > 3277) {
                        if ((c2 < 3285 || c2 > 3286) && c2 != 3260 && c2 != 3298 && c2 != 3299) {
                            break;
                        }
                    }
                }
                break;
            case 6:
                if (c2 < 2561 || c2 > 2580) {
                    if (c2 < 2622 || c2 > 2637) {
                        if ((c2 < 2672 || c2 > 2673) && c2 != 2620 && c2 != 2641 && c2 != 2677) {
                            break;
                        }
                    }
                }
                break;
            case 7:
                if (c2 < 2689 || c2 > 2708) {
                    if ((c2 < 2750 || c2 > 2765) && c2 != 2748 && c2 != 2786 && c2 != 2787) {
                        break;
                    }
                }
                break;
            case 8:
                if (c2 < 3330 || c2 > 3348) {
                    if (c2 < 3390 || c2 > 3405) {
                        if ((c2 < 3426 || c2 > 3427) && c2 != 3415) {
                            break;
                        }
                    }
                }
                break;
            case 9:
                if (c2 < 3458 || c2 > 3476) {
                    if (c2 < 3535 || c2 > 3551) {
                        if ((c2 < 3570 || c2 > 3571) && c2 != 3530) {
                            break;
                        }
                    }
                }
                break;
            case 10:
                if (c2 < 2817 || c2 > 2307) {
                    if (c2 < 2876 || c2 > 2893) {
                        if ((c2 < 2902 || c2 > 2903) && c2 != 2913 && c2 != 2914 && c2 != 2915) {
                            break;
                        }
                    }
                }
                break;
        }
        return false;
    }
}
