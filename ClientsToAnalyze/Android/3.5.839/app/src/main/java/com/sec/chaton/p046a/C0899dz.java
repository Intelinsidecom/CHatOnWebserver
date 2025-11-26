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
/* renamed from: com.sec.chaton.a.dz */
/* loaded from: classes.dex */
public final class C0899dz extends GeneratedMessageLite.Builder<C0898dy, C0899dz> implements InterfaceC0901ea {

    /* renamed from: a */
    private int f2793a;

    /* renamed from: b */
    private long f2794b;

    /* renamed from: i */
    private long f2801i;

    /* renamed from: j */
    private long f2802j;

    /* renamed from: l */
    private long f2804l;

    /* renamed from: n */
    private long f2806n;

    /* renamed from: c */
    private Object f2795c = "";

    /* renamed from: d */
    private Object f2796d = "";

    /* renamed from: e */
    private Object f2797e = "";

    /* renamed from: f */
    private EnumC0822bc f2798f = EnumC0822bc.SINGLE;

    /* renamed from: g */
    private Object f2799g = "";

    /* renamed from: h */
    private Object f2800h = "";

    /* renamed from: k */
    private Object f2803k = "";

    /* renamed from: m */
    private Object f2805m = "";

    /* renamed from: o */
    private LazyStringList f2807o = LazyStringArrayList.EMPTY;

    private C0899dz() {
        m4784g();
    }

    /* renamed from: g */
    private void m4784g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0899dz m4785h() {
        return new C0899dz();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0899dz clear() {
        super.clear();
        this.f2794b = 0L;
        this.f2793a &= -2;
        this.f2795c = "";
        this.f2793a &= -3;
        this.f2796d = "";
        this.f2793a &= -5;
        this.f2797e = "";
        this.f2793a &= -9;
        this.f2798f = EnumC0822bc.SINGLE;
        this.f2793a &= -17;
        this.f2799g = "";
        this.f2793a &= -33;
        this.f2800h = "";
        this.f2793a &= -65;
        this.f2801i = 0L;
        this.f2793a &= -129;
        this.f2802j = 0L;
        this.f2793a &= -257;
        this.f2803k = "";
        this.f2793a &= -513;
        this.f2804l = 0L;
        this.f2793a &= -1025;
        this.f2805m = "";
        this.f2793a &= -2049;
        this.f2806n = 0L;
        this.f2793a &= -4097;
        this.f2807o = LazyStringArrayList.EMPTY;
        this.f2793a &= -8193;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0899dz mo19949clone() {
        return m4785h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0898dy getDefaultInstanceForType() {
        return C0898dy.m4737a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0898dy build() {
        C0898dy c0898dyBuildPartial = buildPartial();
        if (!c0898dyBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0898dyBuildPartial);
        }
        return c0898dyBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0898dy m4786i() throws InvalidProtocolBufferException {
        C0898dy c0898dyBuildPartial = buildPartial();
        if (!c0898dyBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0898dyBuildPartial).asInvalidProtocolBufferException();
        }
        return c0898dyBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0898dy buildPartial() {
        C0898dy c0898dy = new C0898dy(this);
        int i = this.f2793a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0898dy.f2777c = this.f2794b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0898dy.f2778d = this.f2795c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0898dy.f2779e = this.f2796d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0898dy.f2780f = this.f2797e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0898dy.f2781g = this.f2798f;
        if ((i & 32) == 32) {
            i2 |= 32;
        }
        c0898dy.f2782h = this.f2799g;
        if ((i & 64) == 64) {
            i2 |= 64;
        }
        c0898dy.f2783i = this.f2800h;
        if ((i & 128) == 128) {
            i2 |= 128;
        }
        c0898dy.f2784j = this.f2801i;
        if ((i & 256) == 256) {
            i2 |= 256;
        }
        c0898dy.f2785k = this.f2802j;
        if ((i & MotionRecognitionManager.EVENT_VOLUME_DOWN) == 512) {
            i2 |= MotionRecognitionManager.EVENT_VOLUME_DOWN;
        }
        c0898dy.f2786l = this.f2803k;
        if ((i & 1024) == 1024) {
            i2 |= 1024;
        }
        c0898dy.f2787m = this.f2804l;
        if ((i & MotionRecognitionManager.EVENT_TILT_TO_UNLOCK) == 2048) {
            i2 |= MotionRecognitionManager.EVENT_TILT_TO_UNLOCK;
        }
        c0898dy.f2788n = this.f2805m;
        if ((i & 4096) == 4096) {
            i2 |= 4096;
        }
        c0898dy.f2789o = this.f2806n;
        if ((this.f2793a & MotionRecognitionManager.EVENT_FLAT) == 8192) {
            this.f2807o = new UnmodifiableLazyStringList(this.f2807o);
            this.f2793a &= -8193;
        }
        c0898dy.f2790p = this.f2807o;
        c0898dy.f2776b = i2;
        return c0898dy;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0899dz mergeFrom(C0898dy c0898dy) {
        if (c0898dy != C0898dy.m4737a()) {
            if (c0898dy.m4758c()) {
                m4789a(c0898dy.m4759d());
            }
            if (c0898dy.m4760e()) {
                m4793a(c0898dy.m4761f());
            }
            if (c0898dy.m4762g()) {
                m4796b(c0898dy.m4763h());
            }
            if (c0898dy.m4764i()) {
                m4799c(c0898dy.m4765j());
            }
            if (c0898dy.m4766k()) {
                m4791a(c0898dy.m4767l());
            }
            if (c0898dy.m4768m()) {
                m4802d(c0898dy.m4769n());
            }
            if (c0898dy.m4770o()) {
                m4805e(c0898dy.m4771p());
            }
            if (c0898dy.m4772q()) {
                m4795b(c0898dy.m4773r());
            }
            if (c0898dy.m4774s()) {
                m4798c(c0898dy.m4775t());
            }
            if (c0898dy.m4776u()) {
                m4806f(c0898dy.m4777v());
            }
            if (c0898dy.m4778w()) {
                m4801d(c0898dy.m4779x());
            }
            if (c0898dy.m4780y()) {
                m4807g(c0898dy.m4781z());
            }
            if (c0898dy.m4752A()) {
                m4804e(c0898dy.m4753B());
            }
            if (!c0898dy.f2790p.isEmpty()) {
                if (this.f2807o.isEmpty()) {
                    this.f2807o = c0898dy.f2790p;
                    this.f2793a &= -8193;
                } else {
                    m4787j();
                    this.f2807o.addAll(c0898dy.f2790p);
                }
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
    public C0899dz mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f2793a |= 1;
                    this.f2794b = codedInputStream.readInt64();
                    break;
                case 18:
                    this.f2793a |= 2;
                    this.f2795c = codedInputStream.readBytes();
                    break;
                case 26:
                    this.f2793a |= 4;
                    this.f2796d = codedInputStream.readBytes();
                    break;
                case 34:
                    this.f2793a |= 8;
                    this.f2797e = codedInputStream.readBytes();
                    break;
                case 40:
                    EnumC0822bc enumC0822bcM3576a = EnumC0822bc.m3576a(codedInputStream.readEnum());
                    if (enumC0822bcM3576a == null) {
                        break;
                    } else {
                        this.f2793a |= 16;
                        this.f2798f = enumC0822bcM3576a;
                        break;
                    }
                case 50:
                    this.f2793a |= 32;
                    this.f2799g = codedInputStream.readBytes();
                    break;
                case 58:
                    this.f2793a |= 64;
                    this.f2800h = codedInputStream.readBytes();
                    break;
                case 64:
                    this.f2793a |= 128;
                    this.f2801i = codedInputStream.readInt64();
                    break;
                case 72:
                    this.f2793a |= 256;
                    this.f2802j = codedInputStream.readInt64();
                    break;
                case 82:
                    this.f2793a |= MotionRecognitionManager.EVENT_VOLUME_DOWN;
                    this.f2803k = codedInputStream.readBytes();
                    break;
                case 88:
                    this.f2793a |= 1024;
                    this.f2804l = codedInputStream.readInt64();
                    break;
                case 98:
                    this.f2793a |= MotionRecognitionManager.EVENT_TILT_TO_UNLOCK;
                    this.f2805m = codedInputStream.readBytes();
                    break;
                case 104:
                    this.f2793a |= 4096;
                    this.f2806n = codedInputStream.readInt64();
                    break;
                case 114:
                    m4787j();
                    this.f2807o.add(codedInputStream.readBytes());
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
    public C0899dz m4789a(long j) {
        this.f2793a |= 1;
        this.f2794b = j;
        return this;
    }

    /* renamed from: a */
    public C0899dz m4793a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2793a |= 2;
        this.f2795c = str;
        return this;
    }

    /* renamed from: b */
    public C0899dz m4796b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2793a |= 4;
        this.f2796d = str;
        return this;
    }

    /* renamed from: c */
    public C0899dz m4799c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2793a |= 8;
        this.f2797e = str;
        return this;
    }

    /* renamed from: a */
    public C0899dz m4791a(EnumC0822bc enumC0822bc) {
        if (enumC0822bc == null) {
            throw new NullPointerException();
        }
        this.f2793a |= 16;
        this.f2798f = enumC0822bc;
        return this;
    }

    /* renamed from: d */
    public C0899dz m4802d(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2793a |= 32;
        this.f2799g = str;
        return this;
    }

    /* renamed from: e */
    public C0899dz m4805e(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2793a |= 64;
        this.f2800h = str;
        return this;
    }

    /* renamed from: b */
    public C0899dz m4795b(long j) {
        this.f2793a |= 128;
        this.f2801i = j;
        return this;
    }

    /* renamed from: c */
    public C0899dz m4798c(long j) {
        this.f2793a |= 256;
        this.f2802j = j;
        return this;
    }

    /* renamed from: f */
    public C0899dz m4806f(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2793a |= MotionRecognitionManager.EVENT_VOLUME_DOWN;
        this.f2803k = str;
        return this;
    }

    /* renamed from: d */
    public C0899dz m4801d(long j) {
        this.f2793a |= 1024;
        this.f2804l = j;
        return this;
    }

    /* renamed from: g */
    public C0899dz m4807g(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2793a |= MotionRecognitionManager.EVENT_TILT_TO_UNLOCK;
        this.f2805m = str;
        return this;
    }

    /* renamed from: e */
    public C0899dz m4804e(long j) {
        this.f2793a |= 4096;
        this.f2806n = j;
        return this;
    }

    /* renamed from: j */
    private void m4787j() {
        if ((this.f2793a & MotionRecognitionManager.EVENT_FLAT) != 8192) {
            this.f2807o = new LazyStringArrayList(this.f2807o);
            this.f2793a |= MotionRecognitionManager.EVENT_FLAT;
        }
    }
}
