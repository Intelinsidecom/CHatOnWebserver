package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.ek */
/* loaded from: classes.dex */
public final class C0911ek extends GeneratedMessageLite.Builder<C0910ej, C0911ek> implements InterfaceC0912el {

    /* renamed from: a */
    private int f2851a;

    /* renamed from: b */
    private Object f2852b = "";

    /* renamed from: c */
    private Object f2853c = "";

    private C0911ek() {
        m4905g();
    }

    /* renamed from: g */
    private void m4905g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0911ek m4906h() {
        return new C0911ek();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0911ek clear() {
        super.clear();
        this.f2852b = "";
        this.f2851a &= -2;
        this.f2853c = "";
        this.f2851a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0911ek mo19949clone() {
        return m4906h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0910ej getDefaultInstanceForType() {
        return C0910ej.m4890a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0910ej build() {
        C0910ej c0910ejBuildPartial = buildPartial();
        if (!c0910ejBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0910ejBuildPartial);
        }
        return c0910ejBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0910ej buildPartial() {
        C0910ej c0910ej = new C0910ej(this);
        int i = this.f2851a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0910ej.f2847c = this.f2852b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0910ej.f2848d = this.f2853c;
        c0910ej.f2846b = i2;
        return c0910ej;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0911ek mergeFrom(C0910ej c0910ej) {
        if (c0910ej != C0910ej.m4890a()) {
            if (c0910ej.m4898c()) {
                m4910a(c0910ej.m4899d());
            }
            if (c0910ej.m4900e()) {
                m4912b(c0910ej.m4901f());
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
    public C0911ek mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f2851a |= 1;
                    this.f2852b = codedInputStream.readBytes();
                    break;
                case 18:
                    this.f2851a |= 2;
                    this.f2853c = codedInputStream.readBytes();
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
    public C0911ek m4910a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2851a |= 1;
        this.f2852b = str;
        return this;
    }

    /* renamed from: b */
    public C0911ek m4912b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2851a |= 2;
        this.f2853c = str;
        return this;
    }
}
