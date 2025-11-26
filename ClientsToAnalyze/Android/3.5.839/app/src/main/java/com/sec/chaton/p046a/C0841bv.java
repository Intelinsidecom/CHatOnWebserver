package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.bv */
/* loaded from: classes.dex */
public final class C0841bv extends GeneratedMessageLite.Builder<C0840bu, C0841bv> implements InterfaceC0842bw {

    /* renamed from: a */
    private int f2438a;

    /* renamed from: b */
    private long f2439b;

    /* renamed from: c */
    private EnumC0843bx f2440c = EnumC0843bx.TIMEOUT;

    /* renamed from: d */
    private Object f2441d = "";

    private C0841bv() {
        m3784g();
    }

    /* renamed from: g */
    private void m3784g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0841bv m3785h() {
        return new C0841bv();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0841bv clear() {
        super.clear();
        this.f2439b = 0L;
        this.f2438a &= -2;
        this.f2440c = EnumC0843bx.TIMEOUT;
        this.f2438a &= -3;
        this.f2441d = "";
        this.f2438a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0841bv mo19949clone() {
        return m3785h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0840bu getDefaultInstanceForType() {
        return C0840bu.m3766a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0840bu build() {
        C0840bu c0840buBuildPartial = buildPartial();
        if (!c0840buBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0840buBuildPartial);
        }
        return c0840buBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0840bu m3786i() throws InvalidProtocolBufferException {
        C0840bu c0840buBuildPartial = buildPartial();
        if (!c0840buBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0840buBuildPartial).asInvalidProtocolBufferException();
        }
        return c0840buBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0840bu buildPartial() {
        C0840bu c0840bu = new C0840bu(this);
        int i = this.f2438a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0840bu.f2433c = this.f2439b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0840bu.f2434d = this.f2440c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0840bu.f2435e = this.f2441d;
        c0840bu.f2432b = i2;
        return c0840bu;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0841bv mergeFrom(C0840bu c0840bu) {
        if (c0840bu != C0840bu.m3766a()) {
            if (c0840bu.m3774c()) {
                m3788a(c0840bu.m3775d());
            }
            if (c0840bu.m3776e()) {
                m3791a(c0840bu.m3777f());
            }
            if (c0840bu.m3778g()) {
                m3792a(c0840bu.m3779h());
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
    public C0841bv mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f2438a |= 1;
                    this.f2439b = codedInputStream.readInt64();
                    break;
                case 16:
                    EnumC0843bx enumC0843bxM3797a = EnumC0843bx.m3797a(codedInputStream.readEnum());
                    if (enumC0843bxM3797a == null) {
                        break;
                    } else {
                        this.f2438a |= 2;
                        this.f2440c = enumC0843bxM3797a;
                        break;
                    }
                case 26:
                    this.f2438a |= 4;
                    this.f2441d = codedInputStream.readBytes();
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
    public C0841bv m3788a(long j) {
        this.f2438a |= 1;
        this.f2439b = j;
        return this;
    }

    /* renamed from: a */
    public C0841bv m3791a(EnumC0843bx enumC0843bx) {
        if (enumC0843bx == null) {
            throw new NullPointerException();
        }
        this.f2438a |= 2;
        this.f2440c = enumC0843bx;
        return this;
    }

    /* renamed from: a */
    public C0841bv m3792a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2438a |= 4;
        this.f2441d = str;
        return this;
    }
}
