package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.d */
/* loaded from: classes.dex */
public final class C0873d extends GeneratedMessageLite.Builder<C0846c, C0873d> implements InterfaceC0900e {

    /* renamed from: a */
    private int f2622a;

    /* renamed from: b */
    private Object f2623b = "";

    /* renamed from: c */
    private EnumC0822bc f2624c = EnumC0822bc.SINGLE;

    private C0873d() {
        m4289g();
    }

    /* renamed from: g */
    private void m4289g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0873d m4290h() {
        return new C0873d();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0873d clear() {
        super.clear();
        this.f2623b = "";
        this.f2622a &= -2;
        this.f2624c = EnumC0822bc.SINGLE;
        this.f2622a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0873d mo19949clone() {
        return m4290h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0846c getDefaultInstanceForType() {
        return C0846c.m3819a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0846c build() {
        C0846c c0846cBuildPartial = buildPartial();
        if (!c0846cBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0846cBuildPartial);
        }
        return c0846cBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0846c buildPartial() {
        C0846c c0846c = new C0846c(this);
        int i = this.f2622a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0846c.f2456c = this.f2623b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0846c.f2457d = this.f2624c;
        c0846c.f2455b = i2;
        return c0846c;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0873d mergeFrom(C0846c c0846c) {
        if (c0846c != C0846c.m3819a()) {
            if (c0846c.m3825c()) {
                m4295a(c0846c.m3826d());
            }
            if (c0846c.m3827e()) {
                m4293a(c0846c.m3828f());
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
    public C0873d mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f2622a |= 1;
                    this.f2623b = codedInputStream.readBytes();
                    break;
                case 16:
                    EnumC0822bc enumC0822bcM3576a = EnumC0822bc.m3576a(codedInputStream.readEnum());
                    if (enumC0822bcM3576a == null) {
                        break;
                    } else {
                        this.f2622a |= 2;
                        this.f2624c = enumC0822bcM3576a;
                        break;
                    }
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
    public C0873d m4295a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2622a |= 1;
        this.f2623b = str;
        return this;
    }

    /* renamed from: a */
    public C0873d m4293a(EnumC0822bc enumC0822bc) {
        if (enumC0822bc == null) {
            throw new NullPointerException();
        }
        this.f2622a |= 2;
        this.f2624c = enumC0822bc;
        return this;
    }
}
