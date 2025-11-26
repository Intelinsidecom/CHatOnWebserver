package com.sec.google.android.p134a.p135a;

import com.sec.google.android.p134a.C5104b;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: PduHeaders.java */
/* renamed from: com.sec.google.android.a.a.p */
/* loaded from: classes.dex */
public class C5093p {

    /* renamed from: a */
    private HashMap<Integer, Object> f18551a;

    public C5093p() {
        this.f18551a = null;
        this.f18551a = new HashMap<>();
    }

    /* renamed from: a */
    protected int m19368a(int i) {
        Integer num = (Integer) this.f18551a.get(Integer.valueOf(i));
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    /* renamed from: a */
    protected void m19369a(int i, int i2) throws C5104b {
        switch (i2) {
            case 134:
            case 144:
            case 145:
            case 148:
            case 162:
            case 167:
            case 169:
            case 171:
            case 177:
            case 187:
            case 188:
                if (128 != i && 129 != i) {
                    throw new C5104b("Invalid Octet value!");
                }
                break;
            case 135:
            case 136:
            case 137:
            case 138:
            case 139:
            case 142:
            case 147:
            case 150:
            case 151:
            case 152:
            case 154:
            case 157:
            case 158:
            case 159:
            case 160:
            case 161:
            case 164:
            case 166:
            case 168:
            case 170:
            case 172:
            case 173:
            case 174:
            case 175:
            case 176:
            case 178:
            case 179:
            case 181:
            case 182:
            case 183:
            case 184:
            case 185:
            case 189:
            case 190:
            default:
                throw new RuntimeException("Invalid header field!");
            case 140:
                if (i < 128 || i > 151) {
                    throw new C5104b("Invalid Octet value!");
                }
                break;
            case 141:
                if (i < 16 || i > 19) {
                    i = 18;
                    break;
                }
                break;
            case 143:
                if (i < 128 || i > 130) {
                    throw new C5104b("Invalid Octet value!");
                }
                break;
            case 146:
                if (i > 196 && i < 224) {
                    i = 192;
                    break;
                } else if ((i > 235 && i <= 255) || i < 128 || ((i > 136 && i < 192) || i > 255)) {
                    i = 224;
                    break;
                }
            case 149:
                if (i < 128 || i > 135) {
                    throw new C5104b("Invalid Octet value!");
                }
                break;
            case 153:
                if (i > 194 && i < 224) {
                    i = 192;
                    break;
                } else if ((i > 227 && i <= 255) || i < 128 || ((i > 128 && i < 192) || i > 255)) {
                    i = 224;
                    break;
                }
            case 155:
                if (128 != i && 129 != i) {
                    throw new C5104b("Invalid Octet value!");
                }
                break;
            case 156:
                if (i < 128 || i > 131) {
                    throw new C5104b("Invalid Octet value!");
                }
                break;
            case 163:
                if (i < 128 || i > 132) {
                    throw new C5104b("Invalid Octet value!");
                }
                break;
            case 165:
                if (i > 193 && i < 224) {
                    i = 192;
                    break;
                } else if ((i > 228 && i <= 255) || i < 128 || ((i > 128 && i < 192) || i > 255)) {
                    i = 224;
                    break;
                }
            case 180:
                if (128 != i) {
                    throw new C5104b("Invalid Octet value!");
                }
                break;
            case 186:
                if (i < 128 || i > 135) {
                    throw new C5104b("Invalid Octet value!");
                }
                break;
            case 191:
                if (128 != i && 129 != i) {
                    throw new C5104b("Invalid Octet value!");
                }
                break;
        }
        this.f18551a.put(Integer.valueOf(i2), Integer.valueOf(i));
    }

    /* renamed from: b */
    protected byte[] m19375b(int i) {
        return (byte[]) this.f18551a.get(Integer.valueOf(i));
    }

    /* renamed from: a */
    protected void m19372a(byte[] bArr, int i) {
        if (bArr == null) {
            throw new NullPointerException();
        }
        switch (i) {
            case 131:
            case 132:
            case 138:
            case 139:
            case 152:
            case 158:
            case 183:
            case 184:
            case 185:
            case 189:
            case 190:
                this.f18551a.put(Integer.valueOf(i), bArr);
                return;
            default:
                throw new RuntimeException("Invalid header field!");
        }
    }

    /* renamed from: c */
    protected C5082e m19376c(int i) {
        return (C5082e) this.f18551a.get(Integer.valueOf(i));
    }

    /* renamed from: d */
    protected C5082e[] m19377d(int i) {
        ArrayList arrayList = (ArrayList) this.f18551a.get(Integer.valueOf(i));
        if (arrayList == null) {
            return null;
        }
        return (C5082e[]) arrayList.toArray(new C5082e[arrayList.size()]);
    }

    /* renamed from: a */
    protected void m19371a(C5082e c5082e, int i) {
        if (c5082e == null) {
            throw new NullPointerException();
        }
        switch (i) {
            case 137:
            case 147:
            case 150:
            case 154:
            case 160:
            case 164:
            case 166:
            case 181:
            case 182:
                this.f18551a.put(Integer.valueOf(i), c5082e);
                return;
            default:
                throw new RuntimeException("Invalid header field!");
        }
    }

    /* renamed from: a */
    protected void m19373a(C5082e[] c5082eArr, int i) {
        if (c5082eArr == null) {
            throw new NullPointerException();
        }
        switch (i) {
            case 129:
            case 130:
            case 151:
                ArrayList arrayList = new ArrayList();
                for (C5082e c5082e : c5082eArr) {
                    arrayList.add(c5082e);
                }
                this.f18551a.put(Integer.valueOf(i), arrayList);
                return;
            default:
                throw new RuntimeException("Invalid header field!");
        }
    }

    /* renamed from: b */
    protected void m19374b(C5082e c5082e, int i) {
        if (c5082e == null) {
            throw new NullPointerException();
        }
        switch (i) {
            case 129:
            case 130:
            case 151:
                ArrayList arrayList = (ArrayList) this.f18551a.get(Integer.valueOf(i));
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(c5082e);
                this.f18551a.put(Integer.valueOf(i), arrayList);
                return;
            default:
                throw new RuntimeException("Invalid header field!");
        }
    }

    /* renamed from: e */
    protected long m19378e(int i) {
        Long l = (Long) this.f18551a.get(Integer.valueOf(i));
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    /* renamed from: a */
    protected void m19370a(long j, int i) {
        switch (i) {
            case 133:
            case 135:
            case 136:
            case 142:
            case 157:
            case 159:
            case 161:
            case 173:
            case 175:
            case 179:
            case 192:
                this.f18551a.put(Integer.valueOf(i), Long.valueOf(j));
                return;
            default:
                throw new RuntimeException("Invalid header field!");
        }
    }
}
