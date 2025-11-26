package com.sec.chaton.p046a;

import android.hardware.motion.MotionRecognitionManager;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.UnmodifiableLazyStringList;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.ba */
/* loaded from: classes.dex */
public final class C0820ba extends GeneratedMessageLite.Builder<C0818az, C0820ba> implements InterfaceC0821bb {

    /* renamed from: a */
    private int f2331a;

    /* renamed from: b */
    private long f2332b;

    /* renamed from: l */
    private long f2342l;

    /* renamed from: m */
    private boolean f2343m;

    /* renamed from: p */
    private long f2346p;

    /* renamed from: c */
    private EnumC0908eh f2333c = EnumC0908eh.TEXT;

    /* renamed from: d */
    private EnumC0822bc f2334d = EnumC0822bc.SINGLE;

    /* renamed from: e */
    private Object f2335e = "";

    /* renamed from: f */
    private Object f2336f = "";

    /* renamed from: g */
    private LazyStringList f2337g = LazyStringArrayList.EMPTY;

    /* renamed from: h */
    private Object f2338h = "";

    /* renamed from: i */
    private Object f2339i = "";

    /* renamed from: j */
    private Object f2340j = "";

    /* renamed from: k */
    private Object f2341k = "";

    /* renamed from: n */
    private Object f2344n = "";

    /* renamed from: o */
    private Object f2345o = "";

    /* renamed from: q */
    private Object f2347q = "";

    private C0820ba() {
        m3549g();
    }

    /* renamed from: g */
    private void m3549g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0820ba m3550h() {
        return new C0820ba();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0820ba clear() {
        super.clear();
        this.f2332b = 0L;
        this.f2331a &= -2;
        this.f2333c = EnumC0908eh.TEXT;
        this.f2331a &= -3;
        this.f2334d = EnumC0822bc.SINGLE;
        this.f2331a &= -5;
        this.f2335e = "";
        this.f2331a &= -9;
        this.f2336f = "";
        this.f2331a &= -17;
        this.f2337g = LazyStringArrayList.EMPTY;
        this.f2331a &= -33;
        this.f2338h = "";
        this.f2331a &= -65;
        this.f2339i = "";
        this.f2331a &= -129;
        this.f2340j = "";
        this.f2331a &= -257;
        this.f2341k = "";
        this.f2331a &= -513;
        this.f2342l = 0L;
        this.f2331a &= -1025;
        this.f2343m = false;
        this.f2331a &= -2049;
        this.f2344n = "";
        this.f2331a &= -4097;
        this.f2345o = "";
        this.f2331a &= -8193;
        this.f2346p = 0L;
        this.f2331a &= -16385;
        this.f2347q = "";
        this.f2331a &= -32769;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0820ba mo19949clone() {
        return m3550h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0818az getDefaultInstanceForType() {
        return C0818az.m3495a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0818az build() {
        C0818az c0818azBuildPartial = buildPartial();
        if (!c0818azBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0818azBuildPartial);
        }
        return c0818azBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0818az m3551i() throws InvalidProtocolBufferException {
        C0818az c0818azBuildPartial = buildPartial();
        if (!c0818azBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0818azBuildPartial).asInvalidProtocolBufferException();
        }
        return c0818azBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0818az buildPartial() {
        C0818az c0818az = new C0818az(this);
        int i = this.f2331a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0818az.f2313c = this.f2332b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0818az.f2314d = this.f2333c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0818az.f2315e = this.f2334d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0818az.f2316f = this.f2335e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0818az.f2317g = this.f2336f;
        if ((this.f2331a & 32) == 32) {
            this.f2337g = new UnmodifiableLazyStringList(this.f2337g);
            this.f2331a &= -33;
        }
        c0818az.f2318h = this.f2337g;
        if ((i & 64) == 64) {
            i2 |= 32;
        }
        c0818az.f2319i = this.f2338h;
        if ((i & 128) == 128) {
            i2 |= 64;
        }
        c0818az.f2320j = this.f2339i;
        if ((i & 256) == 256) {
            i2 |= 128;
        }
        c0818az.f2321k = this.f2340j;
        if ((i & MotionRecognitionManager.EVENT_VOLUME_DOWN) == 512) {
            i2 |= 256;
        }
        c0818az.f2322l = this.f2341k;
        if ((i & 1024) == 1024) {
            i2 |= MotionRecognitionManager.EVENT_VOLUME_DOWN;
        }
        c0818az.f2323m = this.f2342l;
        if ((i & MotionRecognitionManager.EVENT_TILT_TO_UNLOCK) == 2048) {
            i2 |= 1024;
        }
        c0818az.f2324n = this.f2343m;
        if ((i & 4096) == 4096) {
            i2 |= MotionRecognitionManager.EVENT_TILT_TO_UNLOCK;
        }
        c0818az.f2325o = this.f2344n;
        if ((i & MotionRecognitionManager.EVENT_FLAT) == 8192) {
            i2 |= 4096;
        }
        c0818az.f2326p = this.f2345o;
        if ((i & MotionRecognitionManager.EVENT_TILT_LEVEL_ZERO_LAND) == 16384) {
            i2 |= MotionRecognitionManager.EVENT_FLAT;
        }
        c0818az.f2327q = this.f2346p;
        if ((i & MotionRecognitionManager.EVENT_SMART_ALERT_SETTING) == 32768) {
            i2 |= MotionRecognitionManager.EVENT_TILT_LEVEL_ZERO_LAND;
        }
        c0818az.f2328r = this.f2347q;
        c0818az.f2312b = i2;
        return c0818az;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0820ba mergeFrom(C0818az c0818az) {
        if (c0818az != C0818az.m3495a()) {
            if (c0818az.m3523c()) {
                m3554a(c0818az.m3524d());
            }
            if (c0818az.m3525e()) {
                m3558a(c0818az.m3526f());
            }
            if (c0818az.m3527g()) {
                m3557a(c0818az.m3528h());
            }
            if (c0818az.m3529i()) {
                m3559a(c0818az.m3530j());
            }
            if (c0818az.m3531k()) {
                m3563b(c0818az.m3532l());
            }
            if (!c0818az.f2318h.isEmpty()) {
                if (this.f2337g.isEmpty()) {
                    this.f2337g = c0818az.f2318h;
                    this.f2331a &= -33;
                } else {
                    m3552j();
                    this.f2337g.addAll(c0818az.f2318h);
                }
            }
            if (c0818az.m3534n()) {
                m3568d(c0818az.m3535o());
            }
            if (c0818az.m3536p()) {
                m3570e(c0818az.m3537q());
            }
            if (c0818az.m3538r()) {
                m3571f(c0818az.m3539s());
            }
            if (c0818az.m3540t()) {
                m3572g(c0818az.m3541u());
            }
            if (c0818az.m3542v()) {
                m3562b(c0818az.m3543w());
            }
            if (c0818az.m3544x()) {
                m3560a(c0818az.m3545y());
            }
            if (c0818az.m3546z()) {
                m3573h(c0818az.m3513A());
            }
            if (c0818az.m3514B()) {
                m3574i(c0818az.m3515C());
            }
            if (c0818az.m3516D()) {
                m3565c(c0818az.m3517E());
            }
            if (c0818az.m3518F()) {
                m3575j(c0818az.m3519G());
            }
        }
        return this;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        return true;
    }

    @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0820ba mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f2331a |= 1;
                    this.f2332b = codedInputStream.readInt64();
                    break;
                case 16:
                    EnumC0908eh enumC0908ehM4887a = EnumC0908eh.m4887a(codedInputStream.readEnum());
                    if (enumC0908ehM4887a == null) {
                        break;
                    } else {
                        this.f2331a |= 2;
                        this.f2333c = enumC0908ehM4887a;
                        break;
                    }
                case 24:
                    EnumC0822bc enumC0822bcM3576a = EnumC0822bc.m3576a(codedInputStream.readEnum());
                    if (enumC0822bcM3576a == null) {
                        break;
                    } else {
                        this.f2331a |= 4;
                        this.f2334d = enumC0822bcM3576a;
                        break;
                    }
                case 34:
                    this.f2331a |= 8;
                    this.f2335e = codedInputStream.readBytes();
                    break;
                case 42:
                    this.f2331a |= 16;
                    this.f2336f = codedInputStream.readBytes();
                    break;
                case 50:
                    m3552j();
                    this.f2337g.add(codedInputStream.readBytes());
                    break;
                case 58:
                    this.f2331a |= 64;
                    this.f2338h = codedInputStream.readBytes();
                    break;
                case 66:
                    this.f2331a |= 128;
                    this.f2339i = codedInputStream.readBytes();
                    break;
                case 74:
                    this.f2331a |= 256;
                    this.f2340j = codedInputStream.readBytes();
                    break;
                case 82:
                    this.f2331a |= MotionRecognitionManager.EVENT_VOLUME_DOWN;
                    this.f2341k = codedInputStream.readBytes();
                    break;
                case 88:
                    this.f2331a |= 1024;
                    this.f2342l = codedInputStream.readInt64();
                    break;
                case 96:
                    this.f2331a |= MotionRecognitionManager.EVENT_TILT_TO_UNLOCK;
                    this.f2343m = codedInputStream.readBool();
                    break;
                case 106:
                    this.f2331a |= 4096;
                    this.f2344n = codedInputStream.readBytes();
                    break;
                case 114:
                    this.f2331a |= MotionRecognitionManager.EVENT_FLAT;
                    this.f2345o = codedInputStream.readBytes();
                    break;
                case 120:
                    this.f2331a |= MotionRecognitionManager.EVENT_TILT_LEVEL_ZERO_LAND;
                    this.f2346p = codedInputStream.readInt64();
                    break;
                case 130:
                    this.f2331a |= MotionRecognitionManager.EVENT_SMART_ALERT_SETTING;
                    this.f2347q = codedInputStream.readBytes();
                    break;
                default:
                    if (!parseUnknownField(codedInputStream, extensionRegistryLite, tag)) {
                        break;
                    } else {
                        break;
                    }
            }
        }
        return this;
    }

    /* renamed from: a */
    public C0820ba m3554a(long j) {
        this.f2331a |= 1;
        this.f2332b = j;
        return this;
    }

    /* renamed from: a */
    public C0820ba m3558a(EnumC0908eh enumC0908eh) {
        if (enumC0908eh == null) {
            throw new NullPointerException();
        }
        this.f2331a |= 2;
        this.f2333c = enumC0908eh;
        return this;
    }

    /* renamed from: a */
    public C0820ba m3557a(EnumC0822bc enumC0822bc) {
        if (enumC0822bc == null) {
            throw new NullPointerException();
        }
        this.f2331a |= 4;
        this.f2334d = enumC0822bc;
        return this;
    }

    /* renamed from: a */
    public C0820ba m3559a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2331a |= 8;
        this.f2335e = str;
        return this;
    }

    /* renamed from: b */
    public C0820ba m3563b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2331a |= 16;
        this.f2336f = str;
        return this;
    }

    /* renamed from: j */
    private void m3552j() {
        if ((this.f2331a & 32) != 32) {
            this.f2337g = new LazyStringArrayList(this.f2337g);
            this.f2331a |= 32;
        }
    }

    /* renamed from: c */
    public C0820ba m3566c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        m3552j();
        this.f2337g.add((LazyStringList) str);
        return this;
    }

    /* renamed from: d */
    public C0820ba m3568d(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2331a |= 64;
        this.f2338h = str;
        return this;
    }

    /* renamed from: e */
    public C0820ba m3570e(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2331a |= 128;
        this.f2339i = str;
        return this;
    }

    /* renamed from: f */
    public C0820ba m3571f(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2331a |= 256;
        this.f2340j = str;
        return this;
    }

    /* renamed from: g */
    public C0820ba m3572g(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2331a |= MotionRecognitionManager.EVENT_VOLUME_DOWN;
        this.f2341k = str;
        return this;
    }

    /* renamed from: b */
    public C0820ba m3562b(long j) {
        this.f2331a |= 1024;
        this.f2342l = j;
        return this;
    }

    /* renamed from: a */
    public C0820ba m3560a(boolean z) {
        this.f2331a |= MotionRecognitionManager.EVENT_TILT_TO_UNLOCK;
        this.f2343m = z;
        return this;
    }

    /* renamed from: h */
    public C0820ba m3573h(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2331a |= 4096;
        this.f2344n = str;
        return this;
    }

    /* renamed from: i */
    public C0820ba m3574i(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2331a |= MotionRecognitionManager.EVENT_FLAT;
        this.f2345o = str;
        return this;
    }

    /* renamed from: c */
    public C0820ba m3565c(long j) {
        this.f2331a |= MotionRecognitionManager.EVENT_TILT_LEVEL_ZERO_LAND;
        this.f2346p = j;
        return this;
    }

    /* renamed from: j */
    public C0820ba m3575j(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2331a |= MotionRecognitionManager.EVENT_SMART_ALERT_SETTING;
        this.f2347q = str;
        return this;
    }
}
