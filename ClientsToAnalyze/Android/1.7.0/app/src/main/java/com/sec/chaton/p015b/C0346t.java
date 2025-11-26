package com.sec.chaton.p015b;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.t */
/* loaded from: classes.dex */
public final class C0346t extends GeneratedMessageLite.Builder implements InterfaceC0287b {

    /* renamed from: a */
    private int f993a;

    /* renamed from: b */
    private Object f994b = "";

    /* renamed from: c */
    private long f995c;

    private C0346t() {
        m1962g();
    }

    /* renamed from: g */
    private void m1962g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0346t m1963h() {
        return new C0346t();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0346t clear() {
        super.clear();
        this.f994b = "";
        this.f993a &= -2;
        this.f995c = 0L;
        this.f993a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0346t mo5946clone() {
        return m1963h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0344r getDefaultInstanceForType() {
        return C0344r.m1949a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0344r build() {
        C0344r c0344rBuildPartial = buildPartial();
        if (!c0344rBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0344rBuildPartial);
        }
        return c0344rBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0344r buildPartial() {
        C0344r c0344r = new C0344r(this);
        int i = this.f993a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0344r.f989c = this.f994b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0344r.f990d = this.f995c;
        c0344r.f988b = i2;
        return c0344r;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0346t mergeFrom(C0344r c0344r) {
        if (c0344r != C0344r.m1949a()) {
            if (c0344r.m1955c()) {
                m1968a(c0344r.m1956d());
            }
            if (c0344r.m1957e()) {
                m1965a(c0344r.m1958f());
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
    public C0346t mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f993a |= 1;
                    this.f994b = codedInputStream.readBytes();
                    break;
                case 16:
                    this.f993a |= 2;
                    this.f995c = codedInputStream.readInt64();
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
    public C0346t m1968a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f993a |= 1;
        this.f994b = str;
        return this;
    }

    /* renamed from: a */
    public C0346t m1965a(long j) {
        this.f993a |= 2;
        this.f995c = j;
        return this;
    }
}
