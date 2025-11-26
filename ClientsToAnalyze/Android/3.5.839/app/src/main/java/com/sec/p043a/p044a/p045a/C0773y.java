package com.sec.p043a.p044a.p045a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.y */
/* loaded from: classes.dex */
public final class C0773y extends GeneratedMessageLite.Builder<C0772x, C0773y> implements InterfaceC0774z {

    /* renamed from: a */
    private int f1857a;

    /* renamed from: b */
    private int f1858b;

    /* renamed from: c */
    private long f1859c;

    /* renamed from: d */
    private int f1860d;

    private C0773y() {
        m2809g();
    }

    /* renamed from: g */
    private void m2809g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0773y m2810h() {
        return new C0773y();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0773y clear() {
        super.clear();
        this.f1858b = 0;
        this.f1857a &= -2;
        this.f1859c = 0L;
        this.f1857a &= -3;
        this.f1860d = 0;
        this.f1857a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0773y mo19949clone() {
        return m2810h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0772x getDefaultInstanceForType() {
        return C0772x.m2792a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0772x build() {
        C0772x c0772xBuildPartial = buildPartial();
        if (!c0772xBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0772xBuildPartial);
        }
        return c0772xBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0772x m2811i() throws InvalidProtocolBufferException {
        C0772x c0772xBuildPartial = buildPartial();
        if (!c0772xBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0772xBuildPartial).asInvalidProtocolBufferException();
        }
        return c0772xBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0772x buildPartial() {
        C0772x c0772x = new C0772x(this);
        int i = this.f1857a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0772x.f1852c = this.f1858b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0772x.f1853d = this.f1859c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0772x.f1854e = this.f1860d;
        c0772x.f1851b = i2;
        return c0772x;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0773y mergeFrom(C0772x c0772x) {
        if (c0772x != C0772x.m2792a()) {
            if (c0772x.m2799c()) {
                m2813a(c0772x.m2800d());
            }
            if (c0772x.m2801e()) {
                m2814a(c0772x.m2802f());
            }
            if (c0772x.m2803g()) {
                m2818b(c0772x.m2804h());
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
    public C0773y mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f1857a |= 1;
                    this.f1858b = codedInputStream.readInt32();
                    break;
                case 16:
                    this.f1857a |= 2;
                    this.f1859c = codedInputStream.readInt64();
                    break;
                case 24:
                    this.f1857a |= 4;
                    this.f1860d = codedInputStream.readInt32();
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
    public C0773y m2813a(int i) {
        this.f1857a |= 1;
        this.f1858b = i;
        return this;
    }

    /* renamed from: a */
    public C0773y m2814a(long j) {
        this.f1857a |= 2;
        this.f1859c = j;
        return this;
    }

    /* renamed from: b */
    public C0773y m2818b(int i) {
        this.f1857a |= 4;
        this.f1860d = i;
        return this;
    }
}
