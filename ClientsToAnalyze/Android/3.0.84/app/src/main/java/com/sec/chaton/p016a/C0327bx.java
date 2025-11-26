package com.sec.chaton.p016a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.bx */
/* loaded from: classes.dex */
public final class C0327bx extends GeneratedMessageLite.Builder<C0326bw, C0327bx> implements InterfaceC0328by {

    /* renamed from: a */
    private int f1091a;

    /* renamed from: b */
    private long f1092b;

    /* renamed from: c */
    private C0369dl f1093c = C0369dl.m2485a();

    private C0327bx() {
        m1939i();
    }

    /* renamed from: i */
    private void m1939i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static C0327bx m1940j() {
        return new C0327bx();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0327bx clear() {
        super.clear();
        this.f1092b = 0L;
        this.f1091a &= -2;
        this.f1093c = C0369dl.m2485a();
        this.f1091a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0327bx mo13386clone() {
        return m1940j().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0326bw getDefaultInstanceForType() {
        return C0326bw.m1925a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0326bw build() {
        C0326bw c0326bwBuildPartial = buildPartial();
        if (!c0326bwBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0326bwBuildPartial);
        }
        return c0326bwBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public C0326bw m1941k() throws InvalidProtocolBufferException {
        C0326bw c0326bwBuildPartial = buildPartial();
        if (!c0326bwBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0326bwBuildPartial).asInvalidProtocolBufferException();
        }
        return c0326bwBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0326bw buildPartial() {
        C0326bw c0326bw = new C0326bw(this);
        int i = this.f1091a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0326bw.f1087c = this.f1092b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0326bw.f1088d = this.f1093c;
        c0326bw.f1086b = i2;
        return c0326bw;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0327bx mergeFrom(C0326bw c0326bw) {
        if (c0326bw != C0326bw.m1925a()) {
            if (c0326bw.m1931c()) {
                m1943a(c0326bw.m1932d());
            }
            if (c0326bw.m1933e()) {
                m1948b(c0326bw.m1934f());
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
    public C0327bx mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f1091a |= 1;
                    this.f1092b = codedInputStream.readInt64();
                    break;
                case 18:
                    C0370dm c0370dmNewBuilder = C0369dl.newBuilder();
                    if (m1952f()) {
                        c0370dmNewBuilder.mergeFrom(m1953g());
                    }
                    codedInputStream.readMessage(c0370dmNewBuilder, extensionRegistryLite);
                    m1946a(c0370dmNewBuilder.buildPartial());
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
    public C0327bx m1943a(long j) {
        this.f1091a |= 1;
        this.f1092b = j;
        return this;
    }

    /* renamed from: f */
    public boolean m1952f() {
        return (this.f1091a & 2) == 2;
    }

    /* renamed from: g */
    public C0369dl m1953g() {
        return this.f1093c;
    }

    /* renamed from: a */
    public C0327bx m1946a(C0369dl c0369dl) {
        if (c0369dl == null) {
            throw new NullPointerException();
        }
        this.f1093c = c0369dl;
        this.f1091a |= 2;
        return this;
    }

    /* renamed from: b */
    public C0327bx m1948b(C0369dl c0369dl) {
        if ((this.f1091a & 2) == 2 && this.f1093c != C0369dl.m2485a()) {
            this.f1093c = C0369dl.m2486a(this.f1093c).mergeFrom(c0369dl).buildPartial();
        } else {
            this.f1093c = c0369dl;
        }
        this.f1091a |= 2;
        return this;
    }
}
