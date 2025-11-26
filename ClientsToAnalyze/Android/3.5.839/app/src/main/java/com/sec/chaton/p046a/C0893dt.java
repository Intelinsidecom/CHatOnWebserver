package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.dt */
/* loaded from: classes.dex */
public final class C0893dt extends GeneratedMessageLite.Builder<C0892ds, C0893dt> implements InterfaceC0894du {

    /* renamed from: a */
    private int f2759a;

    /* renamed from: b */
    private Object f2760b = "";

    /* renamed from: c */
    private Object f2761c = "";

    private C0893dt() {
        m4674g();
    }

    /* renamed from: g */
    private void m4674g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0893dt m4675h() {
        return new C0893dt();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0893dt clear() {
        super.clear();
        this.f2760b = "";
        this.f2759a &= -2;
        this.f2761c = "";
        this.f2759a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0893dt mo19949clone() {
        return m4675h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0892ds getDefaultInstanceForType() {
        return C0892ds.m4659a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0892ds build() {
        C0892ds c0892dsBuildPartial = buildPartial();
        if (!c0892dsBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0892dsBuildPartial);
        }
        return c0892dsBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0892ds buildPartial() {
        C0892ds c0892ds = new C0892ds(this);
        int i = this.f2759a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0892ds.f2755c = this.f2760b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0892ds.f2756d = this.f2761c;
        c0892ds.f2754b = i2;
        return c0892ds;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0893dt mergeFrom(C0892ds c0892ds) {
        if (c0892ds != C0892ds.m4659a()) {
            if (c0892ds.m4667c()) {
                m4679a(c0892ds.m4668d());
            }
            if (c0892ds.m4669e()) {
                m4681b(c0892ds.m4670f());
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
    public C0893dt mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f2759a |= 1;
                    this.f2760b = codedInputStream.readBytes();
                    break;
                case 18:
                    this.f2759a |= 2;
                    this.f2761c = codedInputStream.readBytes();
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
    public C0893dt m4679a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2759a |= 1;
        this.f2760b = str;
        return this;
    }

    /* renamed from: b */
    public C0893dt m4681b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2759a |= 2;
        this.f2761c = str;
        return this;
    }
}
