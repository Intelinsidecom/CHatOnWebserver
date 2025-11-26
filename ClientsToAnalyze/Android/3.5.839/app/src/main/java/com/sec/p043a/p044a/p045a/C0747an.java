package com.sec.p043a.p044a.p045a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.an */
/* loaded from: classes.dex */
public final class C0747an extends GeneratedMessageLite.Builder<C0746am, C0747an> implements InterfaceC0748ao {

    /* renamed from: a */
    private int f1759a;

    /* renamed from: b */
    private int f1760b;

    /* renamed from: c */
    private Object f1761c = "";

    /* renamed from: d */
    private Object f1762d = "";

    /* renamed from: e */
    private Object f1763e = "";

    private C0747an() {
        m2512g();
    }

    /* renamed from: g */
    private void m2512g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0747an m2513h() {
        return new C0747an();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0747an clear() {
        super.clear();
        this.f1760b = 0;
        this.f1759a &= -2;
        this.f1761c = "";
        this.f1759a &= -3;
        this.f1762d = "";
        this.f1759a &= -5;
        this.f1763e = "";
        this.f1759a &= -9;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0747an mo19949clone() {
        return m2513h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0746am getDefaultInstanceForType() {
        return C0746am.m2488a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0746am build() {
        C0746am c0746amBuildPartial = buildPartial();
        if (!c0746amBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0746amBuildPartial);
        }
        return c0746amBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0746am m2514i() throws InvalidProtocolBufferException {
        C0746am c0746amBuildPartial = buildPartial();
        if (!c0746amBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0746amBuildPartial).asInvalidProtocolBufferException();
        }
        return c0746amBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0746am buildPartial() {
        C0746am c0746am = new C0746am(this);
        int i = this.f1759a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0746am.f1753c = this.f1760b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0746am.f1754d = this.f1761c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0746am.f1755e = this.f1762d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0746am.f1756f = this.f1763e;
        c0746am.f1752b = i2;
        return c0746am;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0747an mergeFrom(C0746am c0746am) {
        if (c0746am != C0746am.m2488a()) {
            if (c0746am.m2500c()) {
                m2516a(c0746am.m2501d());
            }
            if (c0746am.m2502e()) {
                m2519a(c0746am.m2503f());
            }
            if (c0746am.m2504g()) {
                m2521b(c0746am.m2505h());
            }
            if (c0746am.m2506i()) {
                m2523c(c0746am.m2507j());
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
    public C0747an mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f1759a |= 1;
                    this.f1760b = codedInputStream.readInt32();
                    break;
                case 18:
                    this.f1759a |= 2;
                    this.f1761c = codedInputStream.readBytes();
                    break;
                case 26:
                    this.f1759a |= 4;
                    this.f1762d = codedInputStream.readBytes();
                    break;
                case 34:
                    this.f1759a |= 8;
                    this.f1763e = codedInputStream.readBytes();
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
    public C0747an m2516a(int i) {
        this.f1759a |= 1;
        this.f1760b = i;
        return this;
    }

    /* renamed from: a */
    public C0747an m2519a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1759a |= 2;
        this.f1761c = str;
        return this;
    }

    /* renamed from: b */
    public C0747an m2521b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1759a |= 4;
        this.f1762d = str;
        return this;
    }

    /* renamed from: c */
    public C0747an m2523c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1759a |= 8;
        this.f1763e = str;
        return this;
    }
}
