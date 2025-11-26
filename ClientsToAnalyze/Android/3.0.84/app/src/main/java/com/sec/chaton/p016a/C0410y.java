package com.sec.chaton.p016a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.y */
/* loaded from: classes.dex */
public final class C0410y extends GeneratedMessageLite.Builder<C0409x, C0410y> implements InterfaceC0411z {

    /* renamed from: a */
    private int f1454a;

    /* renamed from: b */
    private long f1455b;

    /* renamed from: c */
    private C0369dl f1456c = C0369dl.m2485a();

    private C0410y() {
        m3006i();
    }

    /* renamed from: i */
    private void m3006i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static C0410y m3007j() {
        return new C0410y();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0410y clear() {
        super.clear();
        this.f1455b = 0L;
        this.f1454a &= -2;
        this.f1456c = C0369dl.m2485a();
        this.f1454a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0410y mo13386clone() {
        return m3007j().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0409x getDefaultInstanceForType() {
        return C0409x.m2993a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0409x build() {
        C0409x c0409xBuildPartial = buildPartial();
        if (!c0409xBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0409xBuildPartial);
        }
        return c0409xBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public C0409x m3008k() throws InvalidProtocolBufferException {
        C0409x c0409xBuildPartial = buildPartial();
        if (!c0409xBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0409xBuildPartial).asInvalidProtocolBufferException();
        }
        return c0409xBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0409x buildPartial() {
        C0409x c0409x = new C0409x(this);
        int i = this.f1454a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0409x.f1450c = this.f1455b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0409x.f1451d = this.f1456c;
        c0409x.f1449b = i2;
        return c0409x;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0410y mergeFrom(C0409x c0409x) {
        if (c0409x != C0409x.m2993a()) {
            if (c0409x.m2998c()) {
                m3010a(c0409x.m2999d());
            }
            if (c0409x.m3000e()) {
                m3015b(c0409x.m3001f());
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
    public C0410y mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f1454a |= 1;
                    this.f1455b = codedInputStream.readInt64();
                    break;
                case 18:
                    C0370dm c0370dmNewBuilder = C0369dl.newBuilder();
                    if (m3019f()) {
                        c0370dmNewBuilder.mergeFrom(m3020g());
                    }
                    codedInputStream.readMessage(c0370dmNewBuilder, extensionRegistryLite);
                    m3012a(c0370dmNewBuilder.buildPartial());
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
    public C0410y m3010a(long j) {
        this.f1454a |= 1;
        this.f1455b = j;
        return this;
    }

    /* renamed from: f */
    public boolean m3019f() {
        return (this.f1454a & 2) == 2;
    }

    /* renamed from: g */
    public C0369dl m3020g() {
        return this.f1456c;
    }

    /* renamed from: a */
    public C0410y m3012a(C0369dl c0369dl) {
        if (c0369dl == null) {
            throw new NullPointerException();
        }
        this.f1456c = c0369dl;
        this.f1454a |= 2;
        return this;
    }

    /* renamed from: b */
    public C0410y m3015b(C0369dl c0369dl) {
        if ((this.f1454a & 2) == 2 && this.f1456c != C0369dl.m2485a()) {
            this.f1456c = C0369dl.m2486a(this.f1456c).mergeFrom(c0369dl).buildPartial();
        } else {
            this.f1456c = c0369dl;
        }
        this.f1454a |= 2;
        return this;
    }
}
