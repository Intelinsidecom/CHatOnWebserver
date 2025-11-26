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
/* renamed from: com.sec.chaton.a.db */
/* loaded from: classes.dex */
public final class C0875db extends GeneratedMessageLite.Builder<C0874da, C0875db> implements InterfaceC0876dc {

    /* renamed from: a */
    private int f2644a;

    /* renamed from: b */
    private long f2645b;

    /* renamed from: g */
    private long f2650g;

    /* renamed from: k */
    private boolean f2654k;

    /* renamed from: m */
    private int f2656m;

    /* renamed from: o */
    private int f2658o;

    /* renamed from: c */
    private EnumC0908eh f2646c = EnumC0908eh.TEXT;

    /* renamed from: d */
    private EnumC0822bc f2647d = EnumC0822bc.SINGLE;

    /* renamed from: e */
    private Object f2648e = "";

    /* renamed from: f */
    private Object f2649f = "";

    /* renamed from: h */
    private Object f2651h = "";

    /* renamed from: i */
    private LazyStringList f2652i = LazyStringArrayList.EMPTY;

    /* renamed from: j */
    private Object f2653j = "";

    /* renamed from: l */
    private Object f2655l = "";

    /* renamed from: n */
    private Object f2657n = "";

    /* renamed from: p */
    private Object f2659p = "";

    private C0875db() {
        m4362g();
    }

    /* renamed from: g */
    private void m4362g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0875db m4363h() {
        return new C0875db();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0875db clear() {
        super.clear();
        this.f2645b = 0L;
        this.f2644a &= -2;
        this.f2646c = EnumC0908eh.TEXT;
        this.f2644a &= -3;
        this.f2647d = EnumC0822bc.SINGLE;
        this.f2644a &= -5;
        this.f2648e = "";
        this.f2644a &= -9;
        this.f2649f = "";
        this.f2644a &= -17;
        this.f2650g = 0L;
        this.f2644a &= -33;
        this.f2651h = "";
        this.f2644a &= -65;
        this.f2652i = LazyStringArrayList.EMPTY;
        this.f2644a &= -129;
        this.f2653j = "";
        this.f2644a &= -257;
        this.f2654k = false;
        this.f2644a &= -513;
        this.f2655l = "";
        this.f2644a &= -1025;
        this.f2656m = 0;
        this.f2644a &= -2049;
        this.f2657n = "";
        this.f2644a &= -4097;
        this.f2658o = 0;
        this.f2644a &= -8193;
        this.f2659p = "";
        this.f2644a &= -16385;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0875db mo19949clone() {
        return m4363h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0874da getDefaultInstanceForType() {
        return C0874da.m4312a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0874da build() {
        C0874da c0874daBuildPartial = buildPartial();
        if (!c0874daBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0874daBuildPartial);
        }
        return c0874daBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0874da m4364i() throws InvalidProtocolBufferException {
        C0874da c0874daBuildPartial = buildPartial();
        if (!c0874daBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0874daBuildPartial).asInvalidProtocolBufferException();
        }
        return c0874daBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0874da buildPartial() {
        C0874da c0874da = new C0874da(this);
        int i = this.f2644a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0874da.f2627c = this.f2645b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0874da.f2628d = this.f2646c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0874da.f2629e = this.f2647d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0874da.f2630f = this.f2648e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0874da.f2631g = this.f2649f;
        if ((i & 32) == 32) {
            i2 |= 32;
        }
        c0874da.f2632h = this.f2650g;
        if ((i & 64) == 64) {
            i2 |= 64;
        }
        c0874da.f2633i = this.f2651h;
        if ((this.f2644a & 128) == 128) {
            this.f2652i = new UnmodifiableLazyStringList(this.f2652i);
            this.f2644a &= -129;
        }
        c0874da.f2634j = this.f2652i;
        if ((i & 256) == 256) {
            i2 |= 128;
        }
        c0874da.f2635k = this.f2653j;
        if ((i & MotionRecognitionManager.EVENT_VOLUME_DOWN) == 512) {
            i2 |= 256;
        }
        c0874da.f2636l = this.f2654k;
        if ((i & 1024) == 1024) {
            i2 |= MotionRecognitionManager.EVENT_VOLUME_DOWN;
        }
        c0874da.f2637m = this.f2655l;
        if ((i & MotionRecognitionManager.EVENT_TILT_TO_UNLOCK) == 2048) {
            i2 |= 1024;
        }
        c0874da.f2638n = this.f2656m;
        if ((i & 4096) == 4096) {
            i2 |= MotionRecognitionManager.EVENT_TILT_TO_UNLOCK;
        }
        c0874da.f2639o = this.f2657n;
        if ((i & MotionRecognitionManager.EVENT_FLAT) == 8192) {
            i2 |= 4096;
        }
        c0874da.f2640p = this.f2658o;
        if ((i & MotionRecognitionManager.EVENT_TILT_LEVEL_ZERO_LAND) == 16384) {
            i2 |= MotionRecognitionManager.EVENT_FLAT;
        }
        c0874da.f2641q = this.f2659p;
        c0874da.f2626b = i2;
        return c0874da;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0875db mergeFrom(C0874da c0874da) {
        if (c0874da != C0874da.m4312a()) {
            if (c0874da.m4336c()) {
                m4368a(c0874da.m4337d());
            }
            if (c0874da.m4338e()) {
                m4372a(c0874da.m4339f());
            }
            if (c0874da.m4340g()) {
                m4370a(c0874da.m4341h());
            }
            if (c0874da.m4342i()) {
                m4373a(c0874da.m4343j());
            }
            if (c0874da.m4344k()) {
                m4378b(c0874da.m4345l());
            }
            if (c0874da.m4346m()) {
                m4377b(c0874da.m4347n());
            }
            if (c0874da.m4348o()) {
                m4380c(c0874da.m4349p());
            }
            if (!c0874da.f2634j.isEmpty()) {
                if (this.f2652i.isEmpty()) {
                    this.f2652i = c0874da.f2634j;
                    this.f2644a &= -129;
                } else {
                    m4365j();
                    this.f2652i.addAll(c0874da.f2634j);
                }
            }
            if (c0874da.m4351r()) {
                m4384e(c0874da.m4352s());
            }
            if (c0874da.m4353t()) {
                m4374a(c0874da.m4354u());
            }
            if (c0874da.m4355v()) {
                m4385f(c0874da.m4356w());
            }
            if (c0874da.m4357x()) {
                m4367a(c0874da.m4358y());
            }
            if (c0874da.m4359z()) {
                m4386g(c0874da.m4328A());
            }
            if (c0874da.m4329B()) {
                m4376b(c0874da.m4330C());
            }
            if (c0874da.m4331D()) {
                m4387h(c0874da.m4332E());
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
    public C0875db mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f2644a |= 1;
                    this.f2645b = codedInputStream.readInt64();
                    break;
                case 16:
                    EnumC0908eh enumC0908ehM4887a = EnumC0908eh.m4887a(codedInputStream.readEnum());
                    if (enumC0908ehM4887a == null) {
                        break;
                    } else {
                        this.f2644a |= 2;
                        this.f2646c = enumC0908ehM4887a;
                        break;
                    }
                case 24:
                    EnumC0822bc enumC0822bcM3576a = EnumC0822bc.m3576a(codedInputStream.readEnum());
                    if (enumC0822bcM3576a == null) {
                        break;
                    } else {
                        this.f2644a |= 4;
                        this.f2647d = enumC0822bcM3576a;
                        break;
                    }
                case 34:
                    this.f2644a |= 8;
                    this.f2648e = codedInputStream.readBytes();
                    break;
                case 42:
                    this.f2644a |= 16;
                    this.f2649f = codedInputStream.readBytes();
                    break;
                case 48:
                    this.f2644a |= 32;
                    this.f2650g = codedInputStream.readInt64();
                    break;
                case 58:
                    this.f2644a |= 64;
                    this.f2651h = codedInputStream.readBytes();
                    break;
                case 66:
                    m4365j();
                    this.f2652i.add(codedInputStream.readBytes());
                    break;
                case 74:
                    this.f2644a |= 256;
                    this.f2653j = codedInputStream.readBytes();
                    break;
                case 80:
                    this.f2644a |= MotionRecognitionManager.EVENT_VOLUME_DOWN;
                    this.f2654k = codedInputStream.readBool();
                    break;
                case 90:
                    this.f2644a |= 1024;
                    this.f2655l = codedInputStream.readBytes();
                    break;
                case 96:
                    this.f2644a |= MotionRecognitionManager.EVENT_TILT_TO_UNLOCK;
                    this.f2656m = codedInputStream.readInt32();
                    break;
                case 106:
                    this.f2644a |= 4096;
                    this.f2657n = codedInputStream.readBytes();
                    break;
                case 112:
                    this.f2644a |= MotionRecognitionManager.EVENT_FLAT;
                    this.f2658o = codedInputStream.readInt32();
                    break;
                case 122:
                    this.f2644a |= MotionRecognitionManager.EVENT_TILT_LEVEL_ZERO_LAND;
                    this.f2659p = codedInputStream.readBytes();
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
    public C0875db m4368a(long j) {
        this.f2644a |= 1;
        this.f2645b = j;
        return this;
    }

    /* renamed from: a */
    public C0875db m4372a(EnumC0908eh enumC0908eh) {
        if (enumC0908eh == null) {
            throw new NullPointerException();
        }
        this.f2644a |= 2;
        this.f2646c = enumC0908eh;
        return this;
    }

    /* renamed from: a */
    public C0875db m4370a(EnumC0822bc enumC0822bc) {
        if (enumC0822bc == null) {
            throw new NullPointerException();
        }
        this.f2644a |= 4;
        this.f2647d = enumC0822bc;
        return this;
    }

    /* renamed from: a */
    public C0875db m4373a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2644a |= 8;
        this.f2648e = str;
        return this;
    }

    /* renamed from: b */
    public C0875db m4378b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2644a |= 16;
        this.f2649f = str;
        return this;
    }

    /* renamed from: b */
    public C0875db m4377b(long j) {
        this.f2644a |= 32;
        this.f2650g = j;
        return this;
    }

    /* renamed from: c */
    public C0875db m4380c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2644a |= 64;
        this.f2651h = str;
        return this;
    }

    /* renamed from: j */
    private void m4365j() {
        if ((this.f2644a & 128) != 128) {
            this.f2652i = new LazyStringArrayList(this.f2652i);
            this.f2644a |= 128;
        }
    }

    /* renamed from: d */
    public C0875db m4382d(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        m4365j();
        this.f2652i.add((LazyStringList) str);
        return this;
    }

    /* renamed from: e */
    public C0875db m4384e(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2644a |= 256;
        this.f2653j = str;
        return this;
    }

    /* renamed from: a */
    public C0875db m4374a(boolean z) {
        this.f2644a |= MotionRecognitionManager.EVENT_VOLUME_DOWN;
        this.f2654k = z;
        return this;
    }

    /* renamed from: f */
    public C0875db m4385f(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2644a |= 1024;
        this.f2655l = str;
        return this;
    }

    /* renamed from: a */
    public C0875db m4367a(int i) {
        this.f2644a |= MotionRecognitionManager.EVENT_TILT_TO_UNLOCK;
        this.f2656m = i;
        return this;
    }

    /* renamed from: g */
    public C0875db m4386g(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2644a |= 4096;
        this.f2657n = str;
        return this;
    }

    /* renamed from: b */
    public C0875db m4376b(int i) {
        this.f2644a |= MotionRecognitionManager.EVENT_FLAT;
        this.f2658o = i;
        return this;
    }

    /* renamed from: h */
    public C0875db m4387h(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2644a |= MotionRecognitionManager.EVENT_TILT_LEVEL_ZERO_LAND;
        this.f2659p = str;
        return this;
    }
}
