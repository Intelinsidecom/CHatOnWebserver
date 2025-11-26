package com.sec.chaton.p016a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.cv */
/* loaded from: classes.dex */
public final class C0352cv extends GeneratedMessageLite.Builder<C0351cu, C0352cv> implements InterfaceC0353cw {

    /* renamed from: a */
    private int f1229a;

    /* renamed from: b */
    private Object f1230b = "";

    /* renamed from: c */
    private Object f1231c = "";

    private C0352cv() {
        m2341g();
    }

    /* renamed from: g */
    private void m2341g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0352cv m2342h() {
        return new C0352cv();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0352cv clear() {
        super.clear();
        this.f1230b = "";
        this.f1229a &= -2;
        this.f1231c = "";
        this.f1229a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0352cv mo13386clone() {
        return m2342h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0351cu getDefaultInstanceForType() {
        return C0351cu.m2326a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0351cu build() {
        C0351cu c0351cuBuildPartial = buildPartial();
        if (!c0351cuBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0351cuBuildPartial);
        }
        return c0351cuBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0351cu buildPartial() {
        C0351cu c0351cu = new C0351cu(this);
        int i = this.f1229a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0351cu.f1225c = this.f1230b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0351cu.f1226d = this.f1231c;
        c0351cu.f1224b = i2;
        return c0351cu;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0352cv mergeFrom(C0351cu c0351cu) {
        if (c0351cu != C0351cu.m2326a()) {
            if (c0351cu.m2334c()) {
                m2346a(c0351cu.m2335d());
            }
            if (c0351cu.m2336e()) {
                m2348b(c0351cu.m2337f());
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
    public C0352cv mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f1229a |= 1;
                    this.f1230b = codedInputStream.readBytes();
                    break;
                case 18:
                    this.f1229a |= 2;
                    this.f1231c = codedInputStream.readBytes();
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
    public C0352cv m2346a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1229a |= 1;
        this.f1230b = str;
        return this;
    }

    /* renamed from: b */
    public C0352cv m2348b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1229a |= 2;
        this.f1231c = str;
        return this;
    }
}
