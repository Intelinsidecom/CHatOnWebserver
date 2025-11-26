package com.sec.p013a.p014a.p015a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.y */
/* loaded from: classes.dex */
public final class C0260y extends GeneratedMessageLite.Builder<C0259x, C0260y> implements InterfaceC0261z {

    /* renamed from: a */
    private int f621a;

    /* renamed from: b */
    private int f622b;

    /* renamed from: c */
    private long f623c;

    /* renamed from: d */
    private int f624d;

    private C0260y() {
        m1077g();
    }

    /* renamed from: g */
    private void m1077g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0260y m1078h() {
        return new C0260y();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0260y clear() {
        super.clear();
        this.f622b = 0;
        this.f621a &= -2;
        this.f623c = 0L;
        this.f621a &= -3;
        this.f624d = 0;
        this.f621a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0260y mo13386clone() {
        return m1078h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0259x getDefaultInstanceForType() {
        return C0259x.m1060a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0259x build() {
        C0259x c0259xBuildPartial = buildPartial();
        if (!c0259xBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0259xBuildPartial);
        }
        return c0259xBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0259x m1079i() throws InvalidProtocolBufferException {
        C0259x c0259xBuildPartial = buildPartial();
        if (!c0259xBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0259xBuildPartial).asInvalidProtocolBufferException();
        }
        return c0259xBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0259x buildPartial() {
        C0259x c0259x = new C0259x(this);
        int i = this.f621a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0259x.f616c = this.f622b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0259x.f617d = this.f623c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0259x.f618e = this.f624d;
        c0259x.f615b = i2;
        return c0259x;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0260y mergeFrom(C0259x c0259x) {
        if (c0259x != C0259x.m1060a()) {
            if (c0259x.m1067c()) {
                m1081a(c0259x.m1068d());
            }
            if (c0259x.m1069e()) {
                m1082a(c0259x.m1070f());
            }
            if (c0259x.m1071g()) {
                m1086b(c0259x.m1072h());
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
    public C0260y mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f621a |= 1;
                    this.f622b = codedInputStream.readInt32();
                    break;
                case 16:
                    this.f621a |= 2;
                    this.f623c = codedInputStream.readInt64();
                    break;
                case 24:
                    this.f621a |= 4;
                    this.f624d = codedInputStream.readInt32();
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
    public C0260y m1081a(int i) {
        this.f621a |= 1;
        this.f622b = i;
        return this;
    }

    /* renamed from: a */
    public C0260y m1082a(long j) {
        this.f621a |= 2;
        this.f623c = j;
        return this;
    }

    /* renamed from: b */
    public C0260y m1086b(int i) {
        this.f621a |= 4;
        this.f624d = i;
        return this;
    }
}
