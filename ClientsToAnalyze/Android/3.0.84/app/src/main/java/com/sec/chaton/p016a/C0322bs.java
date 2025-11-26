package com.sec.chaton.p016a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.bs */
/* loaded from: classes.dex */
public final class C0322bs extends GeneratedMessageLite.Builder<C0321br, C0322bs> implements InterfaceC0323bt {

    /* renamed from: a */
    private int f1076a;

    /* renamed from: b */
    private long f1077b;

    /* renamed from: c */
    private EnumC0324bu f1078c = EnumC0324bu.TIMEOUT;

    /* renamed from: d */
    private Object f1079d = "";

    private C0322bs() {
        m1908g();
    }

    /* renamed from: g */
    private void m1908g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0322bs m1909h() {
        return new C0322bs();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0322bs clear() {
        super.clear();
        this.f1077b = 0L;
        this.f1076a &= -2;
        this.f1078c = EnumC0324bu.TIMEOUT;
        this.f1076a &= -3;
        this.f1079d = "";
        this.f1076a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0322bs mo13386clone() {
        return m1909h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0321br getDefaultInstanceForType() {
        return C0321br.m1890a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0321br build() {
        C0321br c0321brBuildPartial = buildPartial();
        if (!c0321brBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0321brBuildPartial);
        }
        return c0321brBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0321br m1910i() throws InvalidProtocolBufferException {
        C0321br c0321brBuildPartial = buildPartial();
        if (!c0321brBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0321brBuildPartial).asInvalidProtocolBufferException();
        }
        return c0321brBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0321br buildPartial() {
        C0321br c0321br = new C0321br(this);
        int i = this.f1076a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0321br.f1071c = this.f1077b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0321br.f1072d = this.f1078c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0321br.f1073e = this.f1079d;
        c0321br.f1070b = i2;
        return c0321br;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0322bs mergeFrom(C0321br c0321br) {
        if (c0321br != C0321br.m1890a()) {
            if (c0321br.m1898c()) {
                m1912a(c0321br.m1899d());
            }
            if (c0321br.m1900e()) {
                m1915a(c0321br.m1901f());
            }
            if (c0321br.m1902g()) {
                m1916a(c0321br.m1903h());
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
    public C0322bs mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f1076a |= 1;
                    this.f1077b = codedInputStream.readInt64();
                    break;
                case 16:
                    EnumC0324bu enumC0324buM1921a = EnumC0324bu.m1921a(codedInputStream.readEnum());
                    if (enumC0324buM1921a == null) {
                        break;
                    } else {
                        this.f1076a |= 2;
                        this.f1078c = enumC0324buM1921a;
                        break;
                    }
                case 26:
                    this.f1076a |= 4;
                    this.f1079d = codedInputStream.readBytes();
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
    public C0322bs m1912a(long j) {
        this.f1076a |= 1;
        this.f1077b = j;
        return this;
    }

    /* renamed from: a */
    public C0322bs m1915a(EnumC0324bu enumC0324bu) {
        if (enumC0324bu == null) {
            throw new NullPointerException();
        }
        this.f1076a |= 2;
        this.f1078c = enumC0324bu;
        return this;
    }

    /* renamed from: a */
    public C0322bs m1916a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1076a |= 4;
        this.f1079d = str;
        return this;
    }
}
