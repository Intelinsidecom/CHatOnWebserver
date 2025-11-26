package com.sec.p013a.p014a.p015a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.m */
/* loaded from: classes.dex */
public final class C0248m extends GeneratedMessageLite.Builder<C0247l, C0248m> implements InterfaceC0249n {

    /* renamed from: a */
    private int f571a;

    /* renamed from: b */
    private int f572b;

    /* renamed from: c */
    private Object f573c = "";

    private C0248m() {
        m925g();
    }

    /* renamed from: g */
    private void m925g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0248m m926h() {
        return new C0248m();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0248m clear() {
        super.clear();
        this.f572b = 0;
        this.f571a &= -2;
        this.f573c = "";
        this.f571a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0248m mo13386clone() {
        return m926h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0247l getDefaultInstanceForType() {
        return C0247l.m909a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0247l build() {
        C0247l c0247lBuildPartial = buildPartial();
        if (!c0247lBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0247lBuildPartial);
        }
        return c0247lBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0247l m927i() throws InvalidProtocolBufferException {
        C0247l c0247lBuildPartial = buildPartial();
        if (!c0247lBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0247lBuildPartial).asInvalidProtocolBufferException();
        }
        return c0247lBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0247l buildPartial() {
        C0247l c0247l = new C0247l(this);
        int i = this.f571a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0247l.f567c = this.f572b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0247l.f568d = this.f573c;
        c0247l.f566b = i2;
        return c0247l;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0248m mergeFrom(C0247l c0247l) {
        if (c0247l != C0247l.m909a()) {
            if (c0247l.m917c()) {
                m929a(c0247l.m918d());
            }
            if (c0247l.m919e()) {
                m932a(c0247l.m920f());
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
    public C0248m mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f571a |= 1;
                    this.f572b = codedInputStream.readInt32();
                    break;
                case 18:
                    this.f571a |= 2;
                    this.f573c = codedInputStream.readBytes();
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
    public C0248m m929a(int i) {
        this.f571a |= 1;
        this.f572b = i;
        return this;
    }

    /* renamed from: a */
    public C0248m m932a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f571a |= 2;
        this.f573c = str;
        return this;
    }
}
