package com.sec.chaton.p046a;

import android.hardware.motion.MotionRecognitionManager;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.UnmodifiableLazyStringList;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.cd */
/* loaded from: classes.dex */
public final class C0850cd extends GeneratedMessageLite.Builder<C0849cc, C0850cd> implements InterfaceC0851ce {

    /* renamed from: a */
    private int f2478a;

    /* renamed from: b */
    private long f2479b;

    /* renamed from: c */
    private EnumC0822bc f2480c = EnumC0822bc.SINGLE;

    /* renamed from: d */
    private Object f2481d = "";

    /* renamed from: e */
    private Object f2482e = "";

    /* renamed from: f */
    private Object f2483f = "";

    /* renamed from: g */
    private LazyStringList f2484g = LazyStringArrayList.EMPTY;

    /* renamed from: h */
    private long f2485h;

    /* renamed from: i */
    private long f2486i;

    /* renamed from: j */
    private boolean f2487j;

    /* renamed from: k */
    private boolean f2488k;

    private C0850cd() {
        m3892m();
    }

    /* renamed from: m */
    private void m3892m() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public static C0850cd m3893n() {
        return new C0850cd();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0850cd clear() {
        super.clear();
        this.f2479b = 0L;
        this.f2478a &= -2;
        this.f2480c = EnumC0822bc.SINGLE;
        this.f2478a &= -3;
        this.f2481d = "";
        this.f2478a &= -5;
        this.f2482e = "";
        this.f2478a &= -9;
        this.f2483f = "";
        this.f2478a &= -17;
        this.f2484g = LazyStringArrayList.EMPTY;
        this.f2478a &= -33;
        this.f2485h = 0L;
        this.f2478a &= -65;
        this.f2486i = 0L;
        this.f2478a &= -129;
        this.f2487j = false;
        this.f2478a &= -257;
        this.f2488k = false;
        this.f2478a &= -513;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0850cd mo19949clone() {
        return m3893n().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0849cc getDefaultInstanceForType() {
        return C0849cc.m3854a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0849cc build() {
        C0849cc c0849ccBuildPartial = buildPartial();
        if (!c0849ccBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0849ccBuildPartial);
        }
        return c0849ccBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public C0849cc m3894o() throws InvalidProtocolBufferException {
        C0849cc c0849ccBuildPartial = buildPartial();
        if (!c0849ccBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0849ccBuildPartial).asInvalidProtocolBufferException();
        }
        return c0849ccBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0849cc buildPartial() {
        C0849cc c0849cc = new C0849cc(this);
        int i = this.f2478a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0849cc.f2466c = this.f2479b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0849cc.f2467d = this.f2480c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0849cc.f2468e = this.f2481d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0849cc.f2469f = this.f2482e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0849cc.f2470g = this.f2483f;
        if ((this.f2478a & 32) == 32) {
            this.f2484g = new UnmodifiableLazyStringList(this.f2484g);
            this.f2478a &= -33;
        }
        c0849cc.f2471h = this.f2484g;
        if ((i & 64) == 64) {
            i2 |= 32;
        }
        c0849cc.f2472i = this.f2485h;
        if ((i & 128) == 128) {
            i2 |= 64;
        }
        c0849cc.f2473j = this.f2486i;
        if ((i & 256) == 256) {
            i2 |= 128;
        }
        c0849cc.f2474k = this.f2487j;
        if ((i & MotionRecognitionManager.EVENT_VOLUME_DOWN) == 512) {
            i2 |= 256;
        }
        c0849cc.f2475l = this.f2488k;
        c0849cc.f2465b = i2;
        return c0849cc;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0850cd mergeFrom(C0849cc c0849cc) {
        if (c0849cc != C0849cc.m3854a()) {
            if (c0849cc.m3869c()) {
                m3897a(c0849cc.m3870d());
            }
            if (c0849cc.m3871e()) {
                m3899a(c0849cc.m3872f());
            }
            if (c0849cc.m3873g()) {
                m3901a(c0849cc.m3874h());
            }
            if (c0849cc.m3875i()) {
                m3905b(c0849cc.m3876j());
            }
            if (c0849cc.m3877k()) {
                m3909c(c0849cc.m3878l());
            }
            if (!c0849cc.f2471h.isEmpty()) {
                if (this.f2484g.isEmpty()) {
                    this.f2484g = c0849cc.f2471h;
                    this.f2478a &= -33;
                } else {
                    m3895p();
                    this.f2484g.addAll(c0849cc.f2471h);
                }
            }
            if (c0849cc.m3880n()) {
                m3904b(c0849cc.m3881o());
            }
            if (c0849cc.m3882p()) {
                m3908c(c0849cc.m3883q());
            }
            if (c0849cc.m3884r()) {
                m3902a(c0849cc.m3885s());
            }
            if (c0849cc.m3886t()) {
                m3906b(c0849cc.m3887u());
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
    public C0850cd mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f2478a |= 1;
                    this.f2479b = codedInputStream.readInt64();
                    break;
                case 16:
                    EnumC0822bc enumC0822bcM3576a = EnumC0822bc.m3576a(codedInputStream.readEnum());
                    if (enumC0822bcM3576a == null) {
                        break;
                    } else {
                        this.f2478a |= 2;
                        this.f2480c = enumC0822bcM3576a;
                        break;
                    }
                case 26:
                    this.f2478a |= 4;
                    this.f2481d = codedInputStream.readBytes();
                    break;
                case 34:
                    this.f2478a |= 8;
                    this.f2482e = codedInputStream.readBytes();
                    break;
                case 42:
                    this.f2478a |= 16;
                    this.f2483f = codedInputStream.readBytes();
                    break;
                case 50:
                    m3895p();
                    this.f2484g.add(codedInputStream.readBytes());
                    break;
                case 56:
                    this.f2478a |= 64;
                    this.f2485h = codedInputStream.readInt64();
                    break;
                case 64:
                    this.f2478a |= 128;
                    this.f2486i = codedInputStream.readInt64();
                    break;
                case 72:
                    this.f2478a |= 256;
                    this.f2487j = codedInputStream.readBool();
                    break;
                case 80:
                    this.f2478a |= MotionRecognitionManager.EVENT_VOLUME_DOWN;
                    this.f2488k = codedInputStream.readBool();
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

    /* renamed from: f */
    public long m3913f() {
        return this.f2479b;
    }

    /* renamed from: a */
    public C0850cd m3897a(long j) {
        this.f2478a |= 1;
        this.f2479b = j;
        return this;
    }

    /* renamed from: g */
    public EnumC0822bc m3914g() {
        return this.f2480c;
    }

    /* renamed from: a */
    public C0850cd m3899a(EnumC0822bc enumC0822bc) {
        if (enumC0822bc == null) {
            throw new NullPointerException();
        }
        this.f2478a |= 2;
        this.f2480c = enumC0822bc;
        return this;
    }

    /* renamed from: h */
    public String m3915h() {
        Object obj = this.f2481d;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.f2481d = stringUtf8;
        return stringUtf8;
    }

    /* renamed from: a */
    public C0850cd m3901a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2478a |= 4;
        this.f2481d = str;
        return this;
    }

    /* renamed from: b */
    public C0850cd m3905b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2478a |= 8;
        this.f2482e = str;
        return this;
    }

    /* renamed from: i */
    public String m3916i() {
        Object obj = this.f2483f;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.f2483f = stringUtf8;
        return stringUtf8;
    }

    /* renamed from: c */
    public C0850cd m3909c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2478a |= 16;
        this.f2483f = str;
        return this;
    }

    /* renamed from: p */
    private void m3895p() {
        if ((this.f2478a & 32) != 32) {
            this.f2484g = new LazyStringArrayList(this.f2484g);
            this.f2478a |= 32;
        }
    }

    /* renamed from: j */
    public List<String> m3917j() {
        return Collections.unmodifiableList(this.f2484g);
    }

    /* renamed from: d */
    public C0850cd m3911d(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        m3895p();
        this.f2484g.add((LazyStringList) str);
        return this;
    }

    /* renamed from: k */
    public long m3918k() {
        return this.f2485h;
    }

    /* renamed from: b */
    public C0850cd m3904b(long j) {
        this.f2478a |= 64;
        this.f2485h = j;
        return this;
    }

    /* renamed from: c */
    public C0850cd m3908c(long j) {
        this.f2478a |= 128;
        this.f2486i = j;
        return this;
    }

    /* renamed from: a */
    public C0850cd m3902a(boolean z) {
        this.f2478a |= 256;
        this.f2487j = z;
        return this;
    }

    /* renamed from: b */
    public C0850cd m3906b(boolean z) {
        this.f2478a |= MotionRecognitionManager.EVENT_VOLUME_DOWN;
        this.f2488k = z;
        return this;
    }
}
