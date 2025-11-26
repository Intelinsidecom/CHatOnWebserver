package com.sec.p013a.p014a.p015a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.ab */
/* loaded from: classes.dex */
public final class C0222ab extends GeneratedMessageLite.Builder<C0221aa, C0222ab> implements InterfaceC0223ac {

    /* renamed from: a */
    private int f460a;

    /* renamed from: b */
    private int f461b;

    /* renamed from: c */
    private long f462c;

    /* renamed from: d */
    private int f463d;

    private C0222ab() {
        m598g();
    }

    /* renamed from: g */
    private void m598g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0222ab m599h() {
        return new C0222ab();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0222ab clear() {
        super.clear();
        this.f461b = 0;
        this.f460a &= -2;
        this.f462c = 0L;
        this.f460a &= -3;
        this.f463d = 0;
        this.f460a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0222ab mo13386clone() {
        return m599h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0221aa getDefaultInstanceForType() {
        return C0221aa.m581a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0221aa build() {
        C0221aa c0221aaBuildPartial = buildPartial();
        if (!c0221aaBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0221aaBuildPartial);
        }
        return c0221aaBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0221aa m600i() throws InvalidProtocolBufferException {
        C0221aa c0221aaBuildPartial = buildPartial();
        if (!c0221aaBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0221aaBuildPartial).asInvalidProtocolBufferException();
        }
        return c0221aaBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0221aa buildPartial() {
        C0221aa c0221aa = new C0221aa(this);
        int i = this.f460a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0221aa.f455c = this.f461b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0221aa.f456d = this.f462c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0221aa.f457e = this.f463d;
        c0221aa.f454b = i2;
        return c0221aa;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0222ab mergeFrom(C0221aa c0221aa) {
        if (c0221aa != C0221aa.m581a()) {
            if (c0221aa.m588c()) {
                m602a(c0221aa.m589d());
            }
            if (c0221aa.m590e()) {
                m603a(c0221aa.m591f());
            }
            if (c0221aa.m592g()) {
                m607b(c0221aa.m593h());
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
    public C0222ab mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f460a |= 1;
                    this.f461b = codedInputStream.readInt32();
                    break;
                case 16:
                    this.f460a |= 2;
                    this.f462c = codedInputStream.readInt64();
                    break;
                case 24:
                    this.f460a |= 4;
                    this.f463d = codedInputStream.readInt32();
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
    public C0222ab m602a(int i) {
        this.f460a |= 1;
        this.f461b = i;
        return this;
    }

    /* renamed from: a */
    public C0222ab m603a(long j) {
        this.f460a |= 2;
        this.f462c = j;
        return this;
    }

    /* renamed from: b */
    public C0222ab m607b(int i) {
        this.f460a |= 4;
        this.f463d = i;
        return this;
    }
}
