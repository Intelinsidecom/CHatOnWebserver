package com.sec.chaton.p007a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.sec.chaton.C0229at;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.cb */
/* loaded from: classes.dex */
public final class C0163cb extends GeneratedMessageLite.Builder implements InterfaceC0164cc {

    /* renamed from: a */
    private int f598a;

    /* renamed from: b */
    private Object f599b = "";

    /* renamed from: c */
    private Object f600c = "";

    private C0163cb() {
        m1379g();
    }

    /* renamed from: g */
    private void m1379g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0163cb m1380h() {
        return new C0163cb();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0163cb clear() {
        super.clear();
        this.f599b = "";
        this.f598a &= -2;
        this.f600c = "";
        this.f598a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0163cb mo7542clone() {
        return m1380h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0162ca getDefaultInstanceForType() {
        return C0162ca.m1364a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0162ca build() {
        C0162ca c0162caBuildPartial = buildPartial();
        if (!c0162caBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0162caBuildPartial);
        }
        return c0162caBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0162ca buildPartial() {
        C0162ca c0162ca = new C0162ca(this);
        int i = this.f598a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0162ca.f594c = this.f599b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0162ca.f595d = this.f600c;
        c0162ca.f593b = i2;
        return c0162ca;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0163cb mergeFrom(C0162ca c0162ca) {
        if (c0162ca != C0162ca.m1364a()) {
            if (c0162ca.m1372c()) {
                m1384a(c0162ca.m1373d());
            }
            if (c0162ca.m1374e()) {
                m1386b(c0162ca.m1375f());
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
    public C0163cb mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f598a |= 1;
                    this.f599b = codedInputStream.readBytes();
                    break;
                case C0229at.HorizontalSrollView_android_focusable /* 18 */:
                    this.f598a |= 2;
                    this.f600c = codedInputStream.readBytes();
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
    public C0163cb m1384a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f598a |= 1;
        this.f599b = str;
        return this;
    }

    /* renamed from: b */
    public C0163cb m1386b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f598a |= 2;
        this.f600c = str;
        return this;
    }
}
