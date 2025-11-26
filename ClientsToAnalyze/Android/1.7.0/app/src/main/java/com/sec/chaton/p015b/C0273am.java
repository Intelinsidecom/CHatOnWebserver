package com.sec.chaton.p015b;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.am */
/* loaded from: classes.dex */
public final class C0273am extends GeneratedMessageLite.Builder implements InterfaceC0289bb {

    /* renamed from: a */
    private int f707a;

    /* renamed from: b */
    private Object f708b = "";

    /* renamed from: c */
    private int f709c;

    private C0273am() {
        m1158g();
    }

    /* renamed from: g */
    private void m1158g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0273am m1159h() {
        return new C0273am();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0273am clear() {
        super.clear();
        this.f708b = "";
        this.f707a &= -2;
        this.f709c = 0;
        this.f707a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0273am mo5946clone() {
        return m1159h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0308bu getDefaultInstanceForType() {
        return C0308bu.m1552a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0308bu build() {
        C0308bu c0308buBuildPartial = buildPartial();
        if (!c0308buBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0308buBuildPartial);
        }
        return c0308buBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0308bu buildPartial() {
        C0308bu c0308bu = new C0308bu(this);
        int i = this.f707a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0308bu.f853c = this.f708b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0308bu.f854d = this.f709c;
        c0308bu.f852b = i2;
        return c0308bu;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0273am mergeFrom(C0308bu c0308bu) {
        if (c0308bu != C0308bu.m1552a()) {
            if (c0308bu.m1558c()) {
                m1164a(c0308bu.m1559d());
            }
            if (c0308bu.m1560e()) {
                m1161a(c0308bu.m1561f());
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
    public C0273am mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f707a |= 1;
                    this.f708b = codedInputStream.readBytes();
                    break;
                case 16:
                    this.f707a |= 2;
                    this.f709c = codedInputStream.readInt32();
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
    public C0273am m1164a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f707a |= 1;
        this.f708b = str;
        return this;
    }

    /* renamed from: a */
    public C0273am m1161a(int i) {
        this.f707a |= 2;
        this.f709c = i;
        return this;
    }
}
