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
/* renamed from: com.sec.chaton.a.g */
/* loaded from: classes.dex */
public final class C0954g extends GeneratedMessageLite.Builder<C0927f, C0954g> implements InterfaceC0972h {

    /* renamed from: a */
    private int f3059a;

    /* renamed from: b */
    private long f3060b;

    /* renamed from: f */
    private long f3064f;

    /* renamed from: j */
    private long f3068j;

    /* renamed from: k */
    private long f3069k;

    /* renamed from: c */
    private C0935fh f3061c = C0935fh.m5211a();

    /* renamed from: d */
    private LazyStringList f3062d = LazyStringArrayList.EMPTY;

    /* renamed from: e */
    private Object f3063e = "";

    /* renamed from: g */
    private Object f3065g = "";

    /* renamed from: h */
    private Object f3066h = "";

    /* renamed from: i */
    private LazyStringList f3067i = LazyStringArrayList.EMPTY;

    private C0954g() {
        m5512i();
    }

    /* renamed from: i */
    private void m5512i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static C0954g m5513j() {
        return new C0954g();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0954g clear() {
        super.clear();
        this.f3060b = 0L;
        this.f3059a &= -2;
        this.f3061c = C0935fh.m5211a();
        this.f3059a &= -3;
        this.f3062d = LazyStringArrayList.EMPTY;
        this.f3059a &= -5;
        this.f3063e = "";
        this.f3059a &= -9;
        this.f3064f = 0L;
        this.f3059a &= -17;
        this.f3065g = "";
        this.f3059a &= -33;
        this.f3066h = "";
        this.f3059a &= -65;
        this.f3067i = LazyStringArrayList.EMPTY;
        this.f3059a &= -129;
        this.f3068j = 0L;
        this.f3059a &= -257;
        this.f3069k = 0L;
        this.f3059a &= -513;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0954g mo19949clone() {
        return m5513j().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0927f getDefaultInstanceForType() {
        return C0927f.m5064a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0927f build() {
        C0927f c0927fBuildPartial = buildPartial();
        if (!c0927fBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0927fBuildPartial);
        }
        return c0927fBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public C0927f m5514k() throws InvalidProtocolBufferException {
        C0927f c0927fBuildPartial = buildPartial();
        if (!c0927fBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0927fBuildPartial).asInvalidProtocolBufferException();
        }
        return c0927fBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0927f buildPartial() {
        C0927f c0927f = new C0927f(this);
        int i = this.f3059a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0927f.f2902c = this.f3060b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0927f.f2903d = this.f3061c;
        if ((this.f3059a & 4) == 4) {
            this.f3062d = new UnmodifiableLazyStringList(this.f3062d);
            this.f3059a &= -5;
        }
        c0927f.f2904e = this.f3062d;
        if ((i & 8) == 8) {
            i2 |= 4;
        }
        c0927f.f2905f = this.f3063e;
        if ((i & 16) == 16) {
            i2 |= 8;
        }
        c0927f.f2906g = this.f3064f;
        if ((i & 32) == 32) {
            i2 |= 16;
        }
        c0927f.f2907h = this.f3065g;
        if ((i & 64) == 64) {
            i2 |= 32;
        }
        c0927f.f2908i = this.f3066h;
        if ((this.f3059a & 128) == 128) {
            this.f3067i = new UnmodifiableLazyStringList(this.f3067i);
            this.f3059a &= -129;
        }
        c0927f.f2909j = this.f3067i;
        if ((i & 256) == 256) {
            i2 |= 64;
        }
        c0927f.f2910k = this.f3068j;
        if ((i & MotionRecognitionManager.EVENT_VOLUME_DOWN) == 512) {
            i2 |= 128;
        }
        c0927f.f2911l = this.f3069k;
        c0927f.f2901b = i2;
        return c0927f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0954g mergeFrom(C0927f c0927f) {
        if (c0927f != C0927f.m5064a()) {
            if (c0927f.m5082c()) {
                m5518a(c0927f.m5083d());
            }
            if (c0927f.m5084e()) {
                m5526b(c0927f.m5085f());
            }
            if (!c0927f.f2904e.isEmpty()) {
                if (this.f3062d.isEmpty()) {
                    this.f3062d = c0927f.f2904e;
                    this.f3059a &= -5;
                } else {
                    m5515l();
                    this.f3062d.addAll(c0927f.f2904e);
                }
            }
            if (c0927f.m5088i()) {
                m5523a(c0927f.m5089j());
            }
            if (c0927f.m5090k()) {
                m5525b(c0927f.m5091l());
            }
            if (c0927f.m5092m()) {
                m5527b(c0927f.m5093n());
            }
            if (c0927f.m5094o()) {
                m5530c(c0927f.m5095p());
            }
            if (!c0927f.f2909j.isEmpty()) {
                if (this.f3067i.isEmpty()) {
                    this.f3067i = c0927f.f2909j;
                    this.f3059a &= -129;
                } else {
                    m5516m();
                    this.f3067i.addAll(c0927f.f2909j);
                }
            }
            if (c0927f.m5097r()) {
                m5529c(c0927f.m5098s());
            }
            if (c0927f.m5099t()) {
                m5532d(c0927f.m5100u());
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
    public C0954g mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f3059a |= 1;
                    this.f3060b = codedInputStream.readInt64();
                    break;
                case 18:
                    C0936fi c0936fiNewBuilder = C0935fh.newBuilder();
                    if (m5534f()) {
                        c0936fiNewBuilder.mergeFrom(m5535g());
                    }
                    codedInputStream.readMessage(c0936fiNewBuilder, extensionRegistryLite);
                    m5521a(c0936fiNewBuilder.buildPartial());
                    break;
                case 26:
                    m5515l();
                    this.f3062d.add(codedInputStream.readBytes());
                    break;
                case 34:
                    this.f3059a |= 8;
                    this.f3063e = codedInputStream.readBytes();
                    break;
                case 40:
                    this.f3059a |= 16;
                    this.f3064f = codedInputStream.readInt64();
                    break;
                case 50:
                    this.f3059a |= 32;
                    this.f3065g = codedInputStream.readBytes();
                    break;
                case 58:
                    this.f3059a |= 64;
                    this.f3066h = codedInputStream.readBytes();
                    break;
                case 66:
                    m5516m();
                    this.f3067i.add(codedInputStream.readBytes());
                    break;
                case 72:
                    this.f3059a |= 256;
                    this.f3068j = codedInputStream.readInt64();
                    break;
                case 80:
                    this.f3059a |= MotionRecognitionManager.EVENT_VOLUME_DOWN;
                    this.f3069k = codedInputStream.readInt64();
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
    public C0954g m5518a(long j) {
        this.f3059a |= 1;
        this.f3060b = j;
        return this;
    }

    /* renamed from: f */
    public boolean m5534f() {
        return (this.f3059a & 2) == 2;
    }

    /* renamed from: g */
    public C0935fh m5535g() {
        return this.f3061c;
    }

    /* renamed from: a */
    public C0954g m5521a(C0935fh c0935fh) {
        if (c0935fh == null) {
            throw new NullPointerException();
        }
        this.f3061c = c0935fh;
        this.f3059a |= 2;
        return this;
    }

    /* renamed from: a */
    public C0954g m5522a(C0936fi c0936fi) {
        this.f3061c = c0936fi.build();
        this.f3059a |= 2;
        return this;
    }

    /* renamed from: b */
    public C0954g m5526b(C0935fh c0935fh) {
        if ((this.f3059a & 2) == 2 && this.f3061c != C0935fh.m5211a()) {
            this.f3061c = C0935fh.m5212a(this.f3061c).mergeFrom(c0935fh).buildPartial();
        } else {
            this.f3061c = c0935fh;
        }
        this.f3059a |= 2;
        return this;
    }

    /* renamed from: l */
    private void m5515l() {
        if ((this.f3059a & 4) != 4) {
            this.f3062d = new LazyStringArrayList(this.f3062d);
            this.f3059a |= 4;
        }
    }

    /* renamed from: a */
    public C0954g m5523a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f3059a |= 8;
        this.f3063e = str;
        return this;
    }

    /* renamed from: b */
    public C0954g m5525b(long j) {
        this.f3059a |= 16;
        this.f3064f = j;
        return this;
    }

    /* renamed from: b */
    public C0954g m5527b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f3059a |= 32;
        this.f3065g = str;
        return this;
    }

    /* renamed from: c */
    public C0954g m5530c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f3059a |= 64;
        this.f3066h = str;
        return this;
    }

    /* renamed from: m */
    private void m5516m() {
        if ((this.f3059a & 128) != 128) {
            this.f3067i = new LazyStringArrayList(this.f3067i);
            this.f3059a |= 128;
        }
    }

    /* renamed from: c */
    public C0954g m5529c(long j) {
        this.f3059a |= 256;
        this.f3068j = j;
        return this;
    }

    /* renamed from: d */
    public C0954g m5532d(long j) {
        this.f3059a |= MotionRecognitionManager.EVENT_VOLUME_DOWN;
        this.f3069k = j;
        return this;
    }
}
