package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.ec */
/* loaded from: classes.dex */
public final class C0903ec extends GeneratedMessageLite.Builder<C0902eb, C0903ec> implements InterfaceC0904ed {

    /* renamed from: a */
    private int f2816a;

    /* renamed from: c */
    private long f2818c;

    /* renamed from: e */
    private long f2820e;

    /* renamed from: b */
    private Object f2817b = "";

    /* renamed from: d */
    private Object f2819d = "";

    private C0903ec() {
        m4832g();
    }

    /* renamed from: g */
    private void m4832g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0903ec m4833h() {
        return new C0903ec();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0903ec clear() {
        super.clear();
        this.f2817b = "";
        this.f2816a &= -2;
        this.f2818c = 0L;
        this.f2816a &= -3;
        this.f2819d = "";
        this.f2816a &= -5;
        this.f2820e = 0L;
        this.f2816a &= -9;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0903ec mo19949clone() {
        return m4833h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0902eb getDefaultInstanceForType() {
        return C0902eb.m4810a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0902eb build() {
        C0902eb c0902ebBuildPartial = buildPartial();
        if (!c0902ebBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0902ebBuildPartial);
        }
        return c0902ebBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0902eb m4834i() throws InvalidProtocolBufferException {
        C0902eb c0902ebBuildPartial = buildPartial();
        if (!c0902ebBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0902ebBuildPartial).asInvalidProtocolBufferException();
        }
        return c0902ebBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0902eb buildPartial() {
        C0902eb c0902eb = new C0902eb(this);
        int i = this.f2816a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0902eb.f2810c = this.f2817b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0902eb.f2811d = this.f2818c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0902eb.f2812e = this.f2819d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0902eb.f2813f = this.f2820e;
        c0902eb.f2809b = i2;
        return c0902eb;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0903ec mergeFrom(C0902eb c0902eb) {
        if (c0902eb != C0902eb.m4810a()) {
            if (c0902eb.m4820c()) {
                m4839a(c0902eb.m4821d());
            }
            if (c0902eb.m4822e()) {
                m4836a(c0902eb.m4823f());
            }
            if (c0902eb.m4824g()) {
                m4842b(c0902eb.m4825h());
            }
            if (c0902eb.m4826i()) {
                m4841b(c0902eb.m4827j());
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
    public C0903ec mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f2816a |= 1;
                    this.f2817b = codedInputStream.readBytes();
                    break;
                case 16:
                    this.f2816a |= 2;
                    this.f2818c = codedInputStream.readInt64();
                    break;
                case 26:
                    this.f2816a |= 4;
                    this.f2819d = codedInputStream.readBytes();
                    break;
                case 32:
                    this.f2816a |= 8;
                    this.f2820e = codedInputStream.readInt64();
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
    public C0903ec m4839a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2816a |= 1;
        this.f2817b = str;
        return this;
    }

    /* renamed from: a */
    public C0903ec m4836a(long j) {
        this.f2816a |= 2;
        this.f2818c = j;
        return this;
    }

    /* renamed from: b */
    public C0903ec m4842b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2816a |= 4;
        this.f2819d = str;
        return this;
    }

    /* renamed from: b */
    public C0903ec m4841b(long j) {
        this.f2816a |= 8;
        this.f2820e = j;
        return this;
    }
}
