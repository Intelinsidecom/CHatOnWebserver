package com.sec.chaton.p046a;

import android.hardware.motion.MotionRecognitionManager;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.j */
/* loaded from: classes.dex */
public final class C0974j extends GeneratedMessageLite.Builder<C0973i, C0974j> implements InterfaceC0975k {

    /* renamed from: a */
    private int f3159a;

    /* renamed from: b */
    private long f3160b;

    /* renamed from: c */
    private EnumC0822bc f3161c = EnumC0822bc.SINGLE;

    /* renamed from: d */
    private Object f3162d = "";

    /* renamed from: e */
    private Object f3163e = "";

    /* renamed from: f */
    private Object f3164f = "";

    /* renamed from: g */
    private Object f3165g = "";

    /* renamed from: h */
    private Object f3166h = "";

    /* renamed from: i */
    private int f3167i;

    /* renamed from: j */
    private long f3168j;

    /* renamed from: k */
    private long f3169k;

    /* renamed from: l */
    private boolean f3170l;

    /* renamed from: m */
    private long f3171m;

    /* renamed from: n */
    private boolean f3172n;

    /* renamed from: o */
    private boolean f3173o;

    private C0974j() {
        m5796g();
    }

    /* renamed from: g */
    private void m5796g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0974j m5797h() {
        return new C0974j();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0974j clear() {
        super.clear();
        this.f3160b = 0L;
        this.f3159a &= -2;
        this.f3161c = EnumC0822bc.SINGLE;
        this.f3159a &= -3;
        this.f3162d = "";
        this.f3159a &= -5;
        this.f3163e = "";
        this.f3159a &= -9;
        this.f3164f = "";
        this.f3159a &= -17;
        this.f3165g = "";
        this.f3159a &= -33;
        this.f3166h = "";
        this.f3159a &= -65;
        this.f3167i = 0;
        this.f3159a &= -129;
        this.f3168j = 0L;
        this.f3159a &= -257;
        this.f3169k = 0L;
        this.f3159a &= -513;
        this.f3170l = false;
        this.f3159a &= -1025;
        this.f3171m = 0L;
        this.f3159a &= -2049;
        this.f3172n = false;
        this.f3159a &= -4097;
        this.f3173o = false;
        this.f3159a &= -8193;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0974j mo19949clone() {
        return m5797h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0973i getDefaultInstanceForType() {
        return C0973i.m5748a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0973i build() {
        C0973i c0973iBuildPartial = buildPartial();
        if (!c0973iBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0973iBuildPartial);
        }
        return c0973iBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0973i m5798i() throws InvalidProtocolBufferException {
        C0973i c0973iBuildPartial = buildPartial();
        if (!c0973iBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0973iBuildPartial).asInvalidProtocolBufferException();
        }
        return c0973iBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0973i buildPartial() {
        C0973i c0973i = new C0973i(this);
        int i = this.f3159a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0973i.f3143c = this.f3160b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0973i.f3144d = this.f3161c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0973i.f3145e = this.f3162d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0973i.f3146f = this.f3163e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0973i.f3147g = this.f3164f;
        if ((i & 32) == 32) {
            i2 |= 32;
        }
        c0973i.f3148h = this.f3165g;
        if ((i & 64) == 64) {
            i2 |= 64;
        }
        c0973i.f3149i = this.f3166h;
        if ((i & 128) == 128) {
            i2 |= 128;
        }
        c0973i.f3150j = this.f3167i;
        if ((i & 256) == 256) {
            i2 |= 256;
        }
        c0973i.f3151k = this.f3168j;
        if ((i & MotionRecognitionManager.EVENT_VOLUME_DOWN) == 512) {
            i2 |= MotionRecognitionManager.EVENT_VOLUME_DOWN;
        }
        c0973i.f3152l = this.f3169k;
        if ((i & 1024) == 1024) {
            i2 |= 1024;
        }
        c0973i.f3153m = this.f3170l;
        if ((i & MotionRecognitionManager.EVENT_TILT_TO_UNLOCK) == 2048) {
            i2 |= MotionRecognitionManager.EVENT_TILT_TO_UNLOCK;
        }
        c0973i.f3154n = this.f3171m;
        if ((i & 4096) == 4096) {
            i2 |= 4096;
        }
        c0973i.f3155o = this.f3172n;
        if ((i & MotionRecognitionManager.EVENT_FLAT) == 8192) {
            i2 |= MotionRecognitionManager.EVENT_FLAT;
        }
        c0973i.f3156p = this.f3173o;
        c0973i.f3142b = i2;
        return c0973i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0974j mergeFrom(C0973i c0973i) {
        if (c0973i != C0973i.m5748a()) {
            if (c0973i.m5770c()) {
                m5801a(c0973i.m5771d());
            }
            if (c0973i.m5772e()) {
                m5803a(c0973i.m5773f());
            }
            if (c0973i.m5774g()) {
                m5805a(c0973i.m5775h());
            }
            if (c0973i.m5776i()) {
                m5809b(c0973i.m5777j());
            }
            if (c0973i.m5778k()) {
                m5813c(c0973i.m5779l());
            }
            if (c0973i.m5780m()) {
                m5817d(c0973i.m5781n());
            }
            if (c0973i.m5782o()) {
                m5819e(c0973i.m5783p());
            }
            if (c0973i.m5784q()) {
                m5800a(c0973i.m5785r());
            }
            if (c0973i.m5786s()) {
                m5808b(c0973i.m5787t());
            }
            if (c0973i.m5788u()) {
                m5812c(c0973i.m5789v());
            }
            if (c0973i.m5790w()) {
                m5806a(c0973i.m5791x());
            }
            if (c0973i.m5792y()) {
                m5816d(c0973i.m5793z());
            }
            if (c0973i.m5763A()) {
                m5810b(c0973i.m5764B());
            }
            if (c0973i.m5765C()) {
                m5814c(c0973i.m5766D());
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
    public C0974j mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f3159a |= 1;
                    this.f3160b = codedInputStream.readInt64();
                    break;
                case 16:
                    EnumC0822bc enumC0822bcM3576a = EnumC0822bc.m3576a(codedInputStream.readEnum());
                    if (enumC0822bcM3576a == null) {
                        break;
                    } else {
                        this.f3159a |= 2;
                        this.f3161c = enumC0822bcM3576a;
                        break;
                    }
                case 26:
                    this.f3159a |= 4;
                    this.f3162d = codedInputStream.readBytes();
                    break;
                case 34:
                    this.f3159a |= 8;
                    this.f3163e = codedInputStream.readBytes();
                    break;
                case 42:
                    this.f3159a |= 16;
                    this.f3164f = codedInputStream.readBytes();
                    break;
                case 50:
                    this.f3159a |= 32;
                    this.f3165g = codedInputStream.readBytes();
                    break;
                case 58:
                    this.f3159a |= 64;
                    this.f3166h = codedInputStream.readBytes();
                    break;
                case 64:
                    this.f3159a |= 128;
                    this.f3167i = codedInputStream.readInt32();
                    break;
                case 72:
                    this.f3159a |= 256;
                    this.f3168j = codedInputStream.readInt64();
                    break;
                case 80:
                    this.f3159a |= MotionRecognitionManager.EVENT_VOLUME_DOWN;
                    this.f3169k = codedInputStream.readInt64();
                    break;
                case 88:
                    this.f3159a |= 1024;
                    this.f3170l = codedInputStream.readBool();
                    break;
                case 96:
                    this.f3159a |= MotionRecognitionManager.EVENT_TILT_TO_UNLOCK;
                    this.f3171m = codedInputStream.readInt64();
                    break;
                case 104:
                    this.f3159a |= 4096;
                    this.f3172n = codedInputStream.readBool();
                    break;
                case 112:
                    this.f3159a |= MotionRecognitionManager.EVENT_FLAT;
                    this.f3173o = codedInputStream.readBool();
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
    public C0974j m5801a(long j) {
        this.f3159a |= 1;
        this.f3160b = j;
        return this;
    }

    /* renamed from: a */
    public C0974j m5803a(EnumC0822bc enumC0822bc) {
        if (enumC0822bc == null) {
            throw new NullPointerException();
        }
        this.f3159a |= 2;
        this.f3161c = enumC0822bc;
        return this;
    }

    /* renamed from: a */
    public C0974j m5805a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f3159a |= 4;
        this.f3162d = str;
        return this;
    }

    /* renamed from: b */
    public C0974j m5809b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f3159a |= 8;
        this.f3163e = str;
        return this;
    }

    /* renamed from: c */
    public C0974j m5813c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f3159a |= 16;
        this.f3164f = str;
        return this;
    }

    /* renamed from: d */
    public C0974j m5817d(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f3159a |= 32;
        this.f3165g = str;
        return this;
    }

    /* renamed from: e */
    public C0974j m5819e(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f3159a |= 64;
        this.f3166h = str;
        return this;
    }

    /* renamed from: a */
    public C0974j m5800a(int i) {
        this.f3159a |= 128;
        this.f3167i = i;
        return this;
    }

    /* renamed from: b */
    public C0974j m5808b(long j) {
        this.f3159a |= 256;
        this.f3168j = j;
        return this;
    }

    /* renamed from: c */
    public C0974j m5812c(long j) {
        this.f3159a |= MotionRecognitionManager.EVENT_VOLUME_DOWN;
        this.f3169k = j;
        return this;
    }

    /* renamed from: a */
    public C0974j m5806a(boolean z) {
        this.f3159a |= 1024;
        this.f3170l = z;
        return this;
    }

    /* renamed from: d */
    public C0974j m5816d(long j) {
        this.f3159a |= MotionRecognitionManager.EVENT_TILT_TO_UNLOCK;
        this.f3171m = j;
        return this;
    }

    /* renamed from: b */
    public C0974j m5810b(boolean z) {
        this.f3159a |= 4096;
        this.f3172n = z;
        return this;
    }

    /* renamed from: c */
    public C0974j m5814c(boolean z) {
        this.f3159a |= MotionRecognitionManager.EVENT_FLAT;
        this.f3173o = z;
        return this;
    }
}
