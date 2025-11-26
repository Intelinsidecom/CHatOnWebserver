package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.dq */
/* loaded from: classes.dex */
public final class C0890dq extends GeneratedMessageLite.Builder<C0889dp, C0890dq> implements InterfaceC0891dr {

    /* renamed from: a */
    private int f2744a;

    /* renamed from: b */
    private long f2745b;

    /* renamed from: g */
    private long f2750g;

    /* renamed from: c */
    private Object f2746c = "";

    /* renamed from: d */
    private Object f2747d = "";

    /* renamed from: e */
    private Object f2748e = "";

    /* renamed from: f */
    private Object f2749f = "";

    /* renamed from: h */
    private EnumC0822bc f2751h = EnumC0822bc.SINGLE;

    /* renamed from: i */
    private Object f2752i = "";

    private C0890dq() {
        m4640g();
    }

    /* renamed from: g */
    private void m4640g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0890dq m4641h() {
        return new C0890dq();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0890dq clear() {
        super.clear();
        this.f2745b = 0L;
        this.f2744a &= -2;
        this.f2746c = "";
        this.f2744a &= -3;
        this.f2747d = "";
        this.f2744a &= -5;
        this.f2748e = "";
        this.f2744a &= -9;
        this.f2749f = "";
        this.f2744a &= -17;
        this.f2750g = 0L;
        this.f2744a &= -33;
        this.f2751h = EnumC0822bc.SINGLE;
        this.f2744a &= -65;
        this.f2752i = "";
        this.f2744a &= -129;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0890dq mo19949clone() {
        return m4641h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0889dp getDefaultInstanceForType() {
        return C0889dp.m4604a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0889dp build() {
        C0889dp c0889dpBuildPartial = buildPartial();
        if (!c0889dpBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0889dpBuildPartial);
        }
        return c0889dpBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0889dp m4642i() throws InvalidProtocolBufferException {
        C0889dp c0889dpBuildPartial = buildPartial();
        if (!c0889dpBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0889dpBuildPartial).asInvalidProtocolBufferException();
        }
        return c0889dpBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0889dp buildPartial() {
        C0889dp c0889dp = new C0889dp(this);
        int i = this.f2744a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0889dp.f2734c = this.f2745b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0889dp.f2735d = this.f2746c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0889dp.f2736e = this.f2747d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0889dp.f2737f = this.f2748e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0889dp.f2738g = this.f2749f;
        if ((i & 32) == 32) {
            i2 |= 32;
        }
        c0889dp.f2739h = this.f2750g;
        if ((i & 64) == 64) {
            i2 |= 64;
        }
        c0889dp.f2740i = this.f2751h;
        if ((i & 128) == 128) {
            i2 |= 128;
        }
        c0889dp.f2741j = this.f2752i;
        c0889dp.f2733b = i2;
        return c0889dp;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0890dq mergeFrom(C0889dp c0889dp) {
        if (c0889dp != C0889dp.m4604a()) {
            if (c0889dp.m4620c()) {
                m4644a(c0889dp.m4621d());
            }
            if (c0889dp.m4622e()) {
                m4648a(c0889dp.m4623f());
            }
            if (c0889dp.m4624g()) {
                m4651b(c0889dp.m4625h());
            }
            if (c0889dp.m4626i()) {
                m4653c(c0889dp.m4627j());
            }
            if (c0889dp.m4628k()) {
                m4655d(c0889dp.m4629l());
            }
            if (c0889dp.m4630m()) {
                m4650b(c0889dp.m4631n());
            }
            if (c0889dp.m4632o()) {
                m4646a(c0889dp.m4633p());
            }
            if (c0889dp.m4634q()) {
                m4657e(c0889dp.m4635r());
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
    public C0890dq mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f2744a |= 1;
                    this.f2745b = codedInputStream.readInt64();
                    break;
                case 18:
                    this.f2744a |= 2;
                    this.f2746c = codedInputStream.readBytes();
                    break;
                case 26:
                    this.f2744a |= 4;
                    this.f2747d = codedInputStream.readBytes();
                    break;
                case 34:
                    this.f2744a |= 8;
                    this.f2748e = codedInputStream.readBytes();
                    break;
                case 42:
                    this.f2744a |= 16;
                    this.f2749f = codedInputStream.readBytes();
                    break;
                case 48:
                    this.f2744a |= 32;
                    this.f2750g = codedInputStream.readInt64();
                    break;
                case 56:
                    EnumC0822bc enumC0822bcM3576a = EnumC0822bc.m3576a(codedInputStream.readEnum());
                    if (enumC0822bcM3576a == null) {
                        break;
                    } else {
                        this.f2744a |= 64;
                        this.f2751h = enumC0822bcM3576a;
                        break;
                    }
                case 66:
                    this.f2744a |= 128;
                    this.f2752i = codedInputStream.readBytes();
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
    public C0890dq m4644a(long j) {
        this.f2744a |= 1;
        this.f2745b = j;
        return this;
    }

    /* renamed from: a */
    public C0890dq m4648a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2744a |= 2;
        this.f2746c = str;
        return this;
    }

    /* renamed from: b */
    public C0890dq m4651b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2744a |= 4;
        this.f2747d = str;
        return this;
    }

    /* renamed from: c */
    public C0890dq m4653c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2744a |= 8;
        this.f2748e = str;
        return this;
    }

    /* renamed from: d */
    public C0890dq m4655d(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2744a |= 16;
        this.f2749f = str;
        return this;
    }

    /* renamed from: b */
    public C0890dq m4650b(long j) {
        this.f2744a |= 32;
        this.f2750g = j;
        return this;
    }

    /* renamed from: a */
    public C0890dq m4646a(EnumC0822bc enumC0822bc) {
        if (enumC0822bc == null) {
            throw new NullPointerException();
        }
        this.f2744a |= 64;
        this.f2751h = enumC0822bc;
        return this;
    }

    /* renamed from: e */
    public C0890dq m4657e(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2744a |= 128;
        this.f2752i = str;
        return this;
    }
}
