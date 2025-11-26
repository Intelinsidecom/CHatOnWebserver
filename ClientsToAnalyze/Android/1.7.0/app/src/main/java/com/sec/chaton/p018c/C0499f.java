package com.sec.chaton.p018c;

import android.hardware.motion.MREvent;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.sec.chaton.p015b.C0263ac;
import com.sec.chaton.p015b.C0266af;
import com.sec.chaton.p015b.C0267ag;
import com.sec.chaton.p015b.C0268ah;
import com.sec.chaton.p015b.C0270aj;
import com.sec.chaton.p015b.C0277aq;
import com.sec.chaton.p015b.C0280at;
import com.sec.chaton.p015b.C0283aw;
import com.sec.chaton.p015b.C0301bn;
import com.sec.chaton.p015b.C0305br;
import com.sec.chaton.p015b.C0314c;
import com.sec.chaton.p015b.C0315ca;
import com.sec.chaton.p015b.C0317cc;
import com.sec.chaton.p015b.C0322ch;
import com.sec.chaton.p015b.C0328cn;
import com.sec.chaton.p015b.C0331e;
import com.sec.chaton.p015b.C0332f;
import com.sec.chaton.p015b.C0339m;
import com.sec.chaton.p015b.C0348v;
import com.sec.chaton.p015b.C0352z;

/* compiled from: GpbTypeValue.java */
/* renamed from: com.sec.chaton.c.f */
/* loaded from: classes.dex */
public class C0499f {
    /* renamed from: a */
    public static boolean m2523a(int i) {
        switch (i) {
            case 0:
            case 2:
            case 4:
            case 6:
            case 8:
            case 10:
            case MREvent.TILT_PORTRAIT_BACK /* 12 */:
            case 14:
            case 16:
            case MREvent.TILT_LANDSCAPE_LEFT_LEVEL_2 /* 18 */:
                return true;
            case 1:
            case 3:
            case 5:
            case 7:
            case 9:
            case 11:
            case MREvent.TILT_PORTRAIT_FRONT_BACK_STOP /* 13 */:
            case 15:
            case MREvent.TILT_LANDSCAPE_LEFT_LEVEL_1 /* 17 */:
            default:
                return false;
        }
    }

    /* renamed from: a */
    public static long m2521a(int i, GeneratedMessageLite generatedMessageLite) {
        if (generatedMessageLite == null) {
            return -1L;
        }
        switch (i) {
            case 0:
                if (((C0268ah) generatedMessageLite).m1101c()) {
                    return ((C0268ah) generatedMessageLite).m1102d();
                }
                break;
            case 1:
                if (((C0277aq) generatedMessageLite).m1200c()) {
                    return ((C0277aq) generatedMessageLite).m1201d();
                }
                break;
            case 2:
                if (((C0331e) generatedMessageLite).m1852c()) {
                    return ((C0331e) generatedMessageLite).m1853d();
                }
                break;
            case 3:
                if (((C0263ac) generatedMessageLite).m991c()) {
                    return ((C0263ac) generatedMessageLite).m992d();
                }
                break;
            case 4:
                if (((C0332f) generatedMessageLite).m1891c()) {
                    return ((C0332f) generatedMessageLite).m1892d();
                }
                break;
            case 5:
                if (((C0283aw) generatedMessageLite).m1250c()) {
                    return ((C0283aw) generatedMessageLite).m1251d();
                }
                break;
            case 8:
                if (((C0267ag) generatedMessageLite).m1068c()) {
                    return ((C0267ag) generatedMessageLite).m1069d();
                }
                break;
            case 9:
                if (((C0339m) generatedMessageLite).m1939c()) {
                    return ((C0339m) generatedMessageLite).m1940d();
                }
                break;
            case MREvent.TILT_PORTRAIT_BACK /* 12 */:
                if (((C0352z) generatedMessageLite).m2029c()) {
                    return ((C0352z) generatedMessageLite).m2030d();
                }
                break;
            case MREvent.TILT_PORTRAIT_FRONT_BACK_STOP /* 13 */:
                if (((C0348v) generatedMessageLite).m2005c()) {
                    return ((C0348v) generatedMessageLite).m2006d();
                }
                break;
            case 14:
                if (((C0270aj) generatedMessageLite).m1149c()) {
                    return ((C0270aj) generatedMessageLite).m1150d();
                }
                break;
            case 15:
                if (((C0266af) generatedMessageLite).m1044c()) {
                    return ((C0266af) generatedMessageLite).m1045d();
                }
                break;
            case 16:
                if (((C0314c) generatedMessageLite).m1648c()) {
                    return ((C0314c) generatedMessageLite).m1649d();
                }
                break;
            case MREvent.TILT_LANDSCAPE_LEFT_LEVEL_1 /* 17 */:
                if (((C0328cn) generatedMessageLite).m1795c()) {
                    return ((C0328cn) generatedMessageLite).m1796d();
                }
                break;
            case MREvent.TILT_LANDSCAPE_LEFT_LEVEL_2 /* 18 */:
                if (((C0280at) generatedMessageLite).m1221c()) {
                    return ((C0280at) generatedMessageLite).m1222d();
                }
                break;
            case 19:
                if (((C0301bn) generatedMessageLite).m1439c()) {
                    return ((C0301bn) generatedMessageLite).m1440d();
                }
                break;
        }
        return -1L;
    }

    /* renamed from: a */
    public static GeneratedMessageLite m2522a(int i, byte[] bArr) {
        GeneratedMessageLite generatedMessageLiteM1433a;
        try {
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        switch (i) {
            case 0:
                generatedMessageLiteM1433a = C0268ah.m1085a(bArr);
                break;
            case 1:
                generatedMessageLiteM1433a = C0277aq.m1192a(bArr);
                break;
            case 2:
                generatedMessageLiteM1433a = C0331e.m1839a(bArr);
                break;
            case 3:
                generatedMessageLiteM1433a = C0263ac.m986a(bArr);
                break;
            case 4:
                generatedMessageLiteM1433a = C0332f.m1879a(bArr);
                break;
            case 5:
                generatedMessageLiteM1433a = C0283aw.m1241a(bArr);
                break;
            case 6:
                generatedMessageLiteM1433a = C0305br.m1495a(bArr);
                break;
            case 7:
                generatedMessageLiteM1433a = C0315ca.m1665a(bArr);
                break;
            case 8:
                generatedMessageLiteM1433a = C0267ag.m1056a(bArr);
                break;
            case 9:
                generatedMessageLiteM1433a = C0339m.m1936a(bArr);
                break;
            case 10:
                generatedMessageLiteM1433a = C0322ch.m1740a(bArr);
                break;
            case 11:
                generatedMessageLiteM1433a = C0317cc.m1687a(bArr);
                break;
            case MREvent.TILT_PORTRAIT_BACK /* 12 */:
                generatedMessageLiteM1433a = C0352z.m2019a(bArr);
                break;
            case MREvent.TILT_PORTRAIT_FRONT_BACK_STOP /* 13 */:
                generatedMessageLiteM1433a = C0348v.m2001a(bArr);
                break;
            case 14:
                generatedMessageLiteM1433a = C0270aj.m1143a(bArr);
                break;
            case 15:
                generatedMessageLiteM1433a = C0266af.m1038a(bArr);
                break;
            case 16:
                generatedMessageLiteM1433a = C0314c.m1636a(bArr);
                break;
            case MREvent.TILT_LANDSCAPE_LEFT_LEVEL_1 /* 17 */:
                generatedMessageLiteM1433a = C0328cn.m1792a(bArr);
                break;
            case MREvent.TILT_LANDSCAPE_LEFT_LEVEL_2 /* 18 */:
                generatedMessageLiteM1433a = C0280at.m1216a(bArr);
                break;
            case 19:
                generatedMessageLiteM1433a = C0301bn.m1433a(bArr);
                break;
            default:
                return null;
        }
        return generatedMessageLiteM1433a;
    }

    /* renamed from: a */
    public static boolean m2524a(GeneratedMessageLite generatedMessageLite) {
        if (generatedMessageLite instanceof C0268ah) {
            if (((C0268ah) generatedMessageLite).isInitialized()) {
                return true;
            }
        } else if (generatedMessageLite instanceof C0277aq) {
            if (((C0277aq) generatedMessageLite).isInitialized()) {
                return true;
            }
        } else if (generatedMessageLite instanceof C0331e) {
            if (((C0331e) generatedMessageLite).isInitialized()) {
                return true;
            }
        } else if (generatedMessageLite instanceof C0263ac) {
            if (((C0263ac) generatedMessageLite).isInitialized()) {
                return true;
            }
        } else if (generatedMessageLite instanceof C0332f) {
            if (((C0332f) generatedMessageLite).isInitialized()) {
                return true;
            }
        } else if (generatedMessageLite instanceof C0283aw) {
            if (((C0283aw) generatedMessageLite).isInitialized()) {
                return true;
            }
        } else if (generatedMessageLite instanceof C0305br) {
            if (((C0305br) generatedMessageLite).isInitialized()) {
                return true;
            }
        } else if (generatedMessageLite instanceof C0315ca) {
            if (((C0315ca) generatedMessageLite).isInitialized()) {
                return true;
            }
        } else if (generatedMessageLite instanceof C0267ag) {
            if (((C0267ag) generatedMessageLite).isInitialized()) {
                return true;
            }
        } else if (generatedMessageLite instanceof C0339m) {
            if (((C0339m) generatedMessageLite).isInitialized()) {
                return true;
            }
        } else if (generatedMessageLite instanceof C0322ch) {
            if (((C0322ch) generatedMessageLite).isInitialized()) {
                return true;
            }
        } else if (generatedMessageLite instanceof C0317cc) {
            if (((C0317cc) generatedMessageLite).isInitialized()) {
                return true;
            }
        } else if (generatedMessageLite instanceof C0352z) {
            if (((C0352z) generatedMessageLite).isInitialized()) {
                return true;
            }
        } else if (generatedMessageLite instanceof C0348v) {
            if (((C0348v) generatedMessageLite).isInitialized()) {
                return true;
            }
        } else if (generatedMessageLite instanceof C0270aj) {
            if (((C0270aj) generatedMessageLite).isInitialized()) {
                return true;
            }
        } else if (generatedMessageLite instanceof C0266af) {
            if (((C0266af) generatedMessageLite).isInitialized()) {
                return true;
            }
        } else if (generatedMessageLite instanceof C0314c) {
            if (((C0314c) generatedMessageLite).isInitialized()) {
                return true;
            }
        } else if (generatedMessageLite instanceof C0328cn) {
            if (((C0328cn) generatedMessageLite).isInitialized()) {
                return true;
            }
        } else if (generatedMessageLite instanceof C0280at) {
            if (((C0280at) generatedMessageLite).isInitialized()) {
                return true;
            }
        } else if ((generatedMessageLite instanceof C0301bn) && ((C0301bn) generatedMessageLite).isInitialized()) {
            return true;
        }
        return false;
    }
}
