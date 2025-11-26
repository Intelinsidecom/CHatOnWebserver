package com.sec.p043a.p044a.p045a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.ab */
/* loaded from: classes.dex */
public final class C0735ab extends GeneratedMessageLite.Builder<C0734aa, C0735ab> implements InterfaceC0736ac {

    /* renamed from: a */
    private int f1696a;

    /* renamed from: b */
    private int f1697b;

    /* renamed from: c */
    private long f1698c;

    /* renamed from: d */
    private int f1699d;

    private C0735ab() {
        m2330g();
    }

    /* renamed from: g */
    private void m2330g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0735ab m2331h() {
        return new C0735ab();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0735ab clear() {
        super.clear();
        this.f1697b = 0;
        this.f1696a &= -2;
        this.f1698c = 0L;
        this.f1696a &= -3;
        this.f1699d = 0;
        this.f1696a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0735ab mo19949clone() {
        return m2331h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0734aa getDefaultInstanceForType() {
        return C0734aa.m2313a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0734aa build() {
        C0734aa c0734aaBuildPartial = buildPartial();
        if (!c0734aaBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0734aaBuildPartial);
        }
        return c0734aaBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0734aa m2332i() throws InvalidProtocolBufferException {
        C0734aa c0734aaBuildPartial = buildPartial();
        if (!c0734aaBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0734aaBuildPartial).asInvalidProtocolBufferException();
        }
        return c0734aaBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0734aa buildPartial() {
        C0734aa c0734aa = new C0734aa(this);
        int i = this.f1696a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0734aa.f1691c = this.f1697b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0734aa.f1692d = this.f1698c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0734aa.f1693e = this.f1699d;
        c0734aa.f1690b = i2;
        return c0734aa;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0735ab mergeFrom(C0734aa c0734aa) {
        if (c0734aa != C0734aa.m2313a()) {
            if (c0734aa.m2320c()) {
                m2334a(c0734aa.m2321d());
            }
            if (c0734aa.m2322e()) {
                m2335a(c0734aa.m2323f());
            }
            if (c0734aa.m2324g()) {
                m2339b(c0734aa.m2325h());
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
    public C0735ab mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f1696a |= 1;
                    this.f1697b = codedInputStream.readInt32();
                    break;
                case 16:
                    this.f1696a |= 2;
                    this.f1698c = codedInputStream.readInt64();
                    break;
                case 24:
                    this.f1696a |= 4;
                    this.f1699d = codedInputStream.readInt32();
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
    public C0735ab m2334a(int i) {
        this.f1696a |= 1;
        this.f1697b = i;
        return this;
    }

    /* renamed from: a */
    public C0735ab m2335a(long j) {
        this.f1696a |= 2;
        this.f1698c = j;
        return this;
    }

    /* renamed from: b */
    public C0735ab m2339b(int i) {
        this.f1696a |= 4;
        this.f1699d = i;
        return this;
    }
}
